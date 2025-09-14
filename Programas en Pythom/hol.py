import tkinter as tk
from dataclasses import dataclass
import math
import random
from typing import List

# Constantes y datos estáticos
CANVAS_WIDTH = 800
CANVAS_HEIGHT = 400
ROAD_Y = CANVAS_HEIGHT // 2
VEHICLE_WIDTH = 40
VEHICLE_HEIGHT = 20

@dataclass
class TrafficData:
    velocidad_promedio: float  # km/h
    longitud_tramo: float     # metros
    vehiculos_retenidos: int
    vehiculos_pasantes: int
    tiempo_recoleccion: float # minutos
    tau: float               # constante de tiempo del sistema

class Vehicle:
    def __init__(self, canvas, x, direction=1):
        self.canvas = canvas
        self.x = x
        self.direction = direction  # 1 para derecha, -1 para izquierda
        self.y = ROAD_Y - VEHICLE_HEIGHT//2
        self.speed = 2
        self.stopped = False
        self.vehicle = canvas.create_rectangle(
            x, self.y,
            x + VEHICLE_WIDTH, self.y + VEHICLE_HEIGHT,
            fill='blue'
        )

    def move(self):
        if not self.stopped:
            self.x += self.speed * self.direction
            self.canvas.move(self.vehicle, self.speed * self.direction, 0)

    def stop(self):
        self.stopped = True

    def resume(self):
        self.stopped = False

class TrafficLight:
    def __init__(self, canvas, x, traffic_data: TrafficData):
        self.canvas = canvas
        self.x = x
        self.y = ROAD_Y - 50
        self.state = "red"  # red, green, yellow
        self.data = traffic_data
        
        # Crear semáforo
        self.body = canvas.create_rectangle(
            x-10, self.y-30,
            x+10, self.y+30,
            fill='gray'
        )
        self.light = canvas.create_oval(
            x-5, self.y-25,
            x+5, self.y-15,
            fill='red'
        )

    def calculate_green_time(self) -> float:
        # Calcular densidad del tráfico
        densidad = self.data.vehiculos_retenidos / self.data.longitud_tramo
        
        # Calcular flujo vehicular (Q_in)
        flujo_vehicular = (self.data.velocidad_promedio * densidad)
        
        # Calcular tiempo en verde usando la ecuación proporcionada
        if flujo_vehicular == 0:
            return 30  # tiempo por defecto
        
        try:
            t_verde = -self.data.tau * math.log(1 - (self.data.vehiculos_retenidos / flujo_vehicular))
            return max(min(t_verde, 60), 15)  # limitar entre 15 y 60 segundos
        except:
            return 30  # tiempo por defecto si hay error en el cálculo

    def change_state(self, new_state):
        self.state = new_state
        color = {
            "red": "red",
            "green": "green",
            "yellow": "yellow"
        }[new_state]
        self.canvas.itemconfig(self.light, fill=color)

class TrafficSimulation:
    def __init__(self, root):
        self.root = root
        self.root.title("Simulación de Tráfico")
        
        # Crear canvas
        self.canvas = tk.Canvas(root, width=CANVAS_WIDTH, height=CANVAS_HEIGHT, bg='white')
        self.canvas.pack(pady=20)
        
        # Dibujar carretera
        self.canvas.create_line(0, ROAD_Y, CANVAS_WIDTH, ROAD_Y, width=2)
        
        # Datos de tráfico para ambos semáforos
        self.traffic_data_1 = TrafficData(
            velocidad_promedio=40,    # 40 km/h
            longitud_tramo=60,        # 60 metros
            vehiculos_retenidos=5,    # 5 vehículos
            vehiculos_pasantes=20,    # 20 vehículos
            tiempo_recoleccion=5,     # 5 minutos
            tau=30                    # constante de tiempo
        )
        
        self.traffic_data_2 = TrafficData(
            velocidad_promedio=35,    # 35 km/h
            longitud_tramo=60,        # 60 metros
            vehiculos_retenidos=7,    # 7 vehículos
            vehiculos_pasantes=18,    # 18 vehículos
            tiempo_recoleccion=5,     # 5 minutos
            tau=30                    # constante de tiempo
        )
        
        # Crear semáforos
        self.traffic_light1 = TrafficLight(self.canvas, 200, self.traffic_data_1)
        self.traffic_light2 = TrafficLight(self.canvas, 600, self.traffic_data_2)
        
        # Lista de vehículos
        self.vehicles: List[Vehicle] = []
        
        # Iniciar simulación
        self.start_simulation()
        
    def start_simulation(self):
        # Iniciar ciclo de semáforos
        self.update_traffic_lights()
        
        # Generar vehículos periódicamente
        self.generate_vehicles()
        
        # Actualizar movimiento de vehículos
        self.update_vehicles()
        
    def generate_vehicles(self):
        if random.random() < 0.1:  # 10% de probabilidad de generar un nuevo vehículo
            if random.random() < 0.5:
                # Vehículo que va hacia la derecha
                vehicle = Vehicle(self.canvas, 0, 1)
            else:
                # Vehículo que va hacia la izquierda
                vehicle = Vehicle(self.canvas, CANVAS_WIDTH, -1)
            self.vehicles.append(vehicle)
        
        self.root.after(1000, self.generate_vehicles)
        
    def update_vehicles(self):
        for vehicle in self.vehicles[:]:
            vehicle.move()
            
            # Verificar colisiones con semáforos
            if (vehicle.direction == 1 and 
                self.traffic_light1.x - VEHICLE_WIDTH < vehicle.x < self.traffic_light1.x and 
                self.traffic_light1.state == "red"):
                vehicle.stop()
            elif (vehicle.direction == 1 and 
                self.traffic_light2.x - VEHICLE_WIDTH < vehicle.x < self.traffic_light2.x and 
                self.traffic_light2.state == "red"):
                vehicle.stop()
            else:
                vehicle.resume()
            
            # Eliminar vehículos que salen de la pantalla
            if vehicle.x < -VEHICLE_WIDTH or vehicle.x > CANVAS_WIDTH + VEHICLE_WIDTH:
                self.canvas.delete(vehicle.vehicle)
                self.vehicles.remove(vehicle)
        
        self.root.after(50, self.update_vehicles)
    
    def update_traffic_lights(self):
        # Calcular tiempos para ambos semáforos
        green_time1 = self.traffic_light1.calculate_green_time() * 1000  # convertir a milisegundos
        green_time2 = self.traffic_light2.calculate_green_time() * 1000
        
        # Ciclo del primer semáforo
        self.traffic_light1.change_state("green")
        self.traffic_light2.change_state("red")
        
        def yellow1():
            self.traffic_light1.change_state("yellow")
            self.root.after(3000, red1)  # 3 segundos en amarillo
            
        def red1():
            self.traffic_light1.change_state("red")
            self.traffic_light2.change_state("green")
            self.root.after(green_time2, yellow2)
            
        def yellow2():
            self.traffic_light2.change_state("yellow")
            self.root.after(3000, red2)  # 3 segundos en amarillo
            
        def red2():
            self.traffic_light2.change_state("red")
            self.traffic_light1.change_state("green")
            self.root.after(green_time1, yellow1)
        
        self.root.after(green_time1, yellow1)

if __name__ == "__main__":
    root = tk.Tk()
    app = TrafficSimulation(root)
    root.mainloop()