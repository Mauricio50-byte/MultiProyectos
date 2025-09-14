import tkinter as tk
from tkinter import messagebox
import random
import time
from PIL import Image, ImageTk
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from mpl_toolkits.mplot3d import Axes3D  # Importar para gráficos 3D

# Clase principal que gestiona el flujo del juego
class JuegoMetaversoGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Juego del Metaverso")
        self.root.geometry("800x600")

        # Variables de estado
        self.nombre_jugador = ""
        self.puntos = 0
        self.tiempo_inicio = 0
        self.actualizar_tiempo_activo = False  # Flag para controlar la actualización del tiempo
        
        # Inicializa la interfaz
        self.mini_juego_volumen_masa()     

        # Cargar imágenes
        self.imagen_resolucion = ImageTk.PhotoImage(Image.open("C:/Users/ASUS/Downloads/imagen1.jpeg"))  # Cambia el nombre del archivo según corresponda
        self.imagen_fps = ImageTk.PhotoImage(Image.open("C:/Users/ASUS/Downloads/images2.jpeg"))  # Cambia el nombre del archivo según corresponda
        self.imagen_equilibrar = ImageTk.PhotoImage(Image.open("C:/Users/ASUS/Downloads/images3.jpeg"))  # Cambia el nombre del archivo según corresponda
        
        # Configuración de la interfaz inicial
        self.configurar_interfaz_inicial()

    def configurar_interfaz_inicial(self):
        self.limpiar_interfaz()
        self.etiqueta_bienvenida = tk.Label(self.root, text="¡Bienvenido al Juego del Metaverso!", font=("Helvetica", 18, "bold"), fg="blue")
        self.etiqueta_bienvenida.pack(pady=20)

        self.etiqueta_nombre = tk.Label(self.root, text="Ingresa tu nombre:", font=("Helvetica", 14))
        self.etiqueta_nombre.pack(pady=10)

        self.entrada_nombre = tk.Entry(self.root, font=("Helvetica", 14))
        self.entrada_nombre.pack(pady=10)

        self.boton_inicio = tk.Button(self.root, text="Comenzar", command=self.iniciar_juego, bg="green", fg="white", font=("Helvetica", 12, "bold"))
        self.boton_inicio.pack(pady=20)

    def iniciar_juego(self):
        self.nombre_jugador = self.entrada_nombre.get().strip()

        if not self.nombre_jugador:
            messagebox.showerror("Error", "Por favor, ingresa un nombre válido.")
            return

        self.tiempo_inicio = time.time()
        self.puntos = 0
        self.limpiar_interfaz()
        self.mostrar_menu_principal()

    def mostrar_menu_principal(self):
        self.limpiar_interfaz()
        tk.Label(self.root, text=f"Hola {self.nombre_jugador}, ¡explora el Metaverso!", font=("Helvetica", 18, "bold")).pack(pady=20)

        mini_juegos = [
            ("1. Volumen y Masa De un solido en revolucion", self.mini_juego_volumen_masa),
            ("2. Gráficos por Computadora", self.mini_juego_graficos),
            ("3. Distribución de Temperatura", self.mini_juego_temperatura),
            ("4. Trabajo Mecánico", self.mini_juego_trabajo),
            ("5. Carga Eléctrica", self.mini_juego_carga),
            ("6. Flujo de Fluido", self.mini_juego_flujo),
            ("7. Exploración de Objetos", self.mini_juego_exploracion)
        ]

        for texto, funcion in mini_juegos:
            tk.Button(self.root, text=texto, command=funcion, font=("Helvetica", 12), width=40).pack(padx=10, pady=10)

        self.etiqueta_puntos = tk.Label(self.root, text=f"Puntos: {self.puntos}", font=("Helvetica", 12, "bold"))
        self.etiqueta_puntos.pack(pady=10)

        self.etiqueta_tiempo = tk.Label(self.root, text="Tiempo transcurrido: 0s", font=("Helvetica", 10))
        self.etiqueta_tiempo.pack(pady=10)

        self.actualizar_tiempo_activo = True  # Activamos la actualización del tiempo
        self.actualizar_tiempo()

    def actualizar_tiempo(self):
        if not self.actualizar_tiempo_activo:
            return

        tiempo_transcurrido = int(time.time() - self.tiempo_inicio)

        if self.etiqueta_tiempo.winfo_exists():  # Verificamos si la etiqueta todavía existe
            self.etiqueta_tiempo.config(text=f"Tiempo transcurrido: {tiempo_transcurrido}s")

        self.root.after(1000, self.actualizar_tiempo)  # Repetimos cada segundo

    def limpiar_interfaz(self):
        self.actualizar_tiempo_activo = False  # Desactivamos la actualización del tiempo antes de limpiar
        for widget in self.root.winfo_children():
            widget.destroy()

    # Mini-juegos
    def mini_juego_volumen_masa(self):
        self.limpiar_interfaz()
        tk.Label(self.root, text="Mini-juego: Volumen de un Sólido de Revolución", font=("Helvetica", 18, "bold")).pack(pady=20)

        # Entradas del usuario para los límites de integración
        tk.Label(self.root, text="Ingresa el límite inferior (a):", font=("Helvetica", 14)).pack(pady=10)
        entrada_a = tk.Entry(self.root)
        entrada_a.pack(pady=10)

        tk.Label(self.root, text="Ingresa el límite superior (b):", font=("Helvetica", 14)).pack(pady=10)
        entrada_b = tk.Entry(self.root)
        entrada_b.pack(pady=10)

        tk.Label(self.root, text="Ingresa la masa (kg):", font=("Helvetica", 14)).pack(pady=10)
        entrada_masa = tk.Entry(self.root)
        entrada_masa.pack(pady=10)

        # Botón para calcular el volumen y mostrar el gráfico
        tk.Button(self.root, text="Calcular Volumen y Mostrar Gráfico",
                command=lambda: self.calcular_y_mostrar(entrada_a.get(), entrada_b.get(), entrada_masa.get())).pack(pady=20)
        
        # Volver al menú principal
        tk.Button(self.root, text="Volver al Menú Principal", command=self.mostrar_menu_principal).pack(pady=20)
        
    def limpiar_interfaz(self):
        for widget in self.root.winfo_children():
            widget.destroy()

    def calcular_volumen(self, funcion, a, b):
        # Aquí deberías implementar el cálculo del volumen del sólido de revolución
        # Por ejemplo, usando integración
        from scipy.integrate import quad
        volumen, _ = quad(lambda x: np.pi * (funcion(x) ** 2), a, b)
        return volumen

    def calcular_y_mostrar(self, a, b, masa):
        try:
            a = float(a)
            b = float(b)
            masa = float(masa)

            # Definimos la función a utilizar
            self.funcion = lambda x: x ** 2  # Por ejemplo, f(x) = x^2

            # Calculamos el volumen
            volumen = self.calcular_volumen(self.funcion, a, b)

            # Actualizamos los puntos
            self.puntos += 10  # Se pueden ajustar los puntos como desees

            # Mostramos los resultados
            resultado = f"Resultados:\nMasa: {masa:.2f} kg\nVolumen: {volumen:.2f} m³"
            messagebox.showinfo("Resultados", resultado)

            # Mostramos el gráfico
            self.mostrar_grafico(self.funcion, a, b)
        except ValueError:
            messagebox.showerror("Error", "Por favor, ingresa valores numéricos válidos.")

    def mostrar_grafico(self, funcion, a, b):
        # Crear valores para x en el rango dado
        x = np.linspace(a, b, 100)
        y = funcion(x)
        
        # Crear una malla para el sólido de revolución
        theta = np.linspace(0, 2 * np.pi, 100)
        X, T = np.meshgrid(x, theta)
        Y = funcion(X)

        # Sólido de revolución alrededor del eje X
        R = Y * np.cos(T)  # Coordenada Y
        Z = Y * np.sin(T)  # Coordenada Z

        # Crear la figura y el eje 3D
        fig = plt.figure()
        ax = fig.add_subplot(111, projection='3d')

        # Graficar el sólido
        ax.plot_surface(X, R, Z, alpha=0.5, rstride=5, cstride=5, color='cyan', edgecolor='none')
        
        # Configurar etiquetas
        ax.set_xlabel('X-axis')
        ax.set_ylabel('Y-axis')
        ax.set_zlabel('Z-axis')
        ax.set_title('Sólido de Revolución')

        # Ajustar límites para una mejor visualización
        ax.set_xlim([a, b])
        ax.set_ylim([-max(y), max(y)])
        ax.set_zlim([-max(y), max(y)])

        # Mostrar el gráfico
        plt.show()


    def mini_juego_graficos(self):
            self.limpiar_interfaz()
            tk.Label(self.root, text="Mini-juego: Gráficos por Computadora", font=("Helvetica", 18, "bold")).pack(pady=20)

            resolucion = random.choice(["720p", "1080p", "4K"])
            fps = random.choice([30, 60, 120])

            opciones = ["Mejorar resolución", "Aumentar FPS", "Equilibrar calidad"]
            respuesta_usuario = tk.StringVar(value=opciones[0])

            for opcion in opciones:
                tk.Radiobutton(self.root, text=opcion, variable=respuesta_usuario, value=opcion).pack(anchor=tk.W)

            tk.Button(self.root, text="Aplicar Configuración", command=lambda: self.optimizar_graficos(resolucion, fps, respuesta_usuario.get())).pack(pady=20)

    def optimizar_graficos(self, resolucion, fps, optimizacion):
        if optimizacion == "Mejorar resolución":
            nueva_resolucion = "4K" if resolucion != "4K" else resolucion
            fps = max(30, fps - 30)
            imagen_a_mostrar = self.imagen_resolucion
        elif optimizacion == "Aumentar FPS":
            nueva_resolucion = "720p" if resolucion != "720p" else resolucion
            fps = min(120, fps + 30)
            imagen_a_mostrar = self.imagen_fps
        else:
            nueva_resolucion = resolucion
            fps = fps
            imagen_a_mostrar = self.imagen_equilibrar

        resultado = f"Optimización aplicada: Resolución {nueva_resolucion}, {fps} FPS."
        messagebox.showinfo("Resultado", resultado)

        # Mostrar la imagen
        self.mostrar_imagen(imagen_a_mostrar)

    def mostrar_imagen(self, imagen):
        # Limpiar la interfaz actual
        self.limpiar_interfaz()
        
        # Mostrar la imagen
        etiqueta_imagen = tk.Label(self.root, image=imagen)
        etiqueta_imagen.image = imagen  # Mantener una referencia a la imagen
        etiqueta_imagen.pack(pady=20)

        # Volver al menú principal
        tk.Button(self.root, text="Volver al Menú Principal", command=self.mostrar_menu_principal).pack(pady=20)

    def mini_juego_temperatura(self):
            self.limpiar_interfaz()
            tk.Label(self.root, text="Mini-juego: Distribución de Temperatura", font=("Helvetica", 18, "bold")).pack(pady=20)

            # Solicitar al usuario el número de puntos de temperatura
            tk.Label(self.root, text="¿Cuántos puntos de temperatura deseas ingresar?", font=("Helvetica", 14)).pack(pady=10)
            entrada_num_puntos = tk.Entry(self.root)
            entrada_num_puntos.pack(pady=10)

            tk.Button(self.root, text="Continuar", command=lambda: self.pedir_temperaturas(entrada_num_puntos.get())).pack(pady=20)

    def pedir_temperaturas(self, num_puntos):
        try:
            num_puntos = int(num_puntos)

            # Limpiar interfaz para ingresar temperaturas
            self.limpiar_interfaz()
            self.temperaturas = []

            for i in range(num_puntos):
                tk.Label(self.root, text=f"Ingrese la temperatura en el punto {i + 1} (°C):", font=("Helvetica", 14)).pack(pady=10)
                entrada_temp = tk.Entry(self.root)
                entrada_temp.pack(pady=10)
                self.temperaturas.append(entrada_temp)

            tk.Button(self.root, text="Calcular Temperatura Promedio", command=lambda: self.calcular_temperatura_promedio(num_puntos)).pack(pady=20)
        
        except ValueError:
            messagebox.showerror("Error", "Por favor, ingrese un número válido de puntos.")

    def calcular_temperatura_promedio(self, num_puntos):
        try:
            # Recoger las temperaturas ingresadas
            temperaturas = [float(temp.get()) for temp in self.temperaturas]

            # Calcular la temperatura promedio
            temperatura_promedio = sum(temperaturas) / num_puntos

            # Mostrar resultados
            resultado = f"Temperatura Promedio: {temperatura_promedio:.2f} °C"
            messagebox.showinfo("Resultados", resultado)

            # Mostrar la estructura con su temperatura
            self.mostrar_estructura_temperatura(temperatura_promedio)

        except ValueError:
            messagebox.showerror("Error", "Por favor, ingrese valores numéricos válidos.")

    def mostrar_estructura_temperatura(self, temperatura_promedio):
        # Limpiar la interfaz
        self.limpiar_interfaz()

        # Crear un gráfico de barras para la temperatura
        fig, ax = plt.subplots()
        ax.bar(["Estructura"], [temperatura_promedio], color='blue')
        ax.set_ylim(0, 100)  # Ajustar el límite del eje Y según el rango esperado de temperatura
        ax.set_ylabel('Temperatura (°C)')
        ax.set_title('Temperatura Promedio de la Estructura')

        # Mostrar el gráfico
        canvas = FigureCanvasTkAgg(fig, master=self.root)
        canvas.draw()
        canvas.get_tk_widget().pack(pady=20)

        tk.Button(self.root, text="Volver al Menú Principal", command=self.mostrar_menu_principal).pack(pady=20)
    def mini_juego_trabajo(self):
        self.limpiar_interfaz()
        tk.Label(self.root, text="Mini-juego: Trabajo Mecánico", font=("Helvetica", 18, "bold")).pack(pady=20)

        # Etiquetas y campos de entrada para la fuerza y la distancia
        tk.Label(self.root, text="Ingrese la fuerza (N):").pack(pady=5)
        self.entrada_fuerza = tk.Entry(self.root)
        self.entrada_fuerza.pack(pady=5)

        tk.Label(self.root, text="Ingrese la distancia (m):").pack(pady=5)
        self.entrada_distancia = tk.Entry(self.root)
        self.entrada_distancia.pack(pady=5)

        # Botón para calcular el trabajo
        tk.Button(self.root, text="Calcular Trabajo", command=self.calcular_y_mostrar_trabajo).pack(pady=20)
        
        # Botón para regresar al menú principal
        tk.Button(self.root, text="Volver al Menú Principal", command=self.mostrar_menu_principal).pack(pady=20)
    def calcular_y_mostrar_trabajo(self):
        try:
            # Obtener valores ingresados por el usuario
            fuerza = float(self.entrada_fuerza.get())
            distancia = float(self.entrada_distancia.get())

            # Calcular el trabajo mecánico
            trabajo = self.calcular_trabajo(fuerza, distancia)

            # Mostrar el resultado en una ventana emergente
            resultado = f"Fuerza: {fuerza:.2f} N\nDistancia: {distancia:.2f} m\n\nTrabajo Mecánico: {trabajo:.2f} J"
            messagebox.showinfo("Resultados", resultado)

            # Mostrar la gráfica en la misma ventana
            self.mostrar_grafica(fuerza, distancia, trabajo)

            # Actualizar puntos
            self.puntos += 10  # O ajustar según lo que consideres adecuado

        except ValueError:
            messagebox.showerror("Error", "Por favor, ingrese valores válidos para fuerza y distancia.")

    def calcular_trabajo(self, fuerza, distancia):
        # Calcular el trabajo mecánico (fuerza * distancia)
        return fuerza * distancia

    def mostrar_grafica(self, fuerza, distancia, trabajo):
        # Crear una gráfica que muestre la relación de la fuerza, distancia y trabajo mecánico
        fig, ax = plt.subplots()

        # Etiquetas y datos para el gráfico
        etiquetas = ['Fuerza (N)', 'Distancia (m)', 'Trabajo (J)']
        valores = [fuerza, distancia, trabajo]

        # Crear gráfico de barras
        ax.bar(etiquetas, valores, color=['blue', 'green', 'red'])

        # Añadir títulos y etiquetas
        ax.set_title('Relación de Fuerza, Distancia y Trabajo Mecánico')
        ax.set_ylabel('Valores')

        # Mostrar la gráfica
        plt.show()
    def mini_juego_carga(self):
        self.limpiar_interfaz()
        tk.Label(self.root, text="Mini-juego: Carga Eléctrica", font=("Helvetica", 18, "bold")).pack(pady=20)

        # Campos para entrada de datos
        tk.Label(self.root, text="Ingrese la carga eléctrica (Coulombs):", font=("Helvetica", 14)).pack(pady=10)
        self.entrada_carga = tk.Entry(self.root)
        self.entrada_carga.pack(pady=5)

        tk.Label(self.root, text="Ingrese el voltaje (Volts):", font=("Helvetica", 14)).pack(pady=10)
        self.entrada_voltaje = tk.Entry(self.root)
        self.entrada_voltaje.pack(pady=5)

        # Botón para calcular
        tk.Button(self.root, text="Calcular Energía", command=self.calcular_y_mostrar_energia, 
                font=("Helvetica", 12)).pack(pady=20)

        # Botón para volver al menú principal
        tk.Button(self.root, text="Volver al Menú Principal", command=self.mostrar_menu_principal, 
                font=("Helvetica", 12)).pack(pady=10)

    def calcular_y_mostrar_energia(self):
        try:
            # Obtener valores ingresados por el usuario
            carga = float(self.entrada_carga.get())
            voltaje = float(self.entrada_voltaje.get())

            # Calcular la energía
            energia = self.calcular_energia(carga, voltaje)

            # Mostrar resultados
            resultado = f"Resultados:\n\nCarga: {carga:.2f} C\nVoltaje: {voltaje:.2f} V\nEnergía: {energia:.2f} J"
            messagebox.showinfo("Resultados del Cálculo", resultado)

            # Mostrar gráfica
            self.mostrar_grafica_energia(carga, voltaje, energia)

            # Actualizar puntos
            self.puntos += 10

        except ValueError:
            messagebox.showerror("Error", "Por favor, ingrese valores numéricos válidos.")

    def mostrar_grafica_energia(self, carga, voltaje, energia):
        # Crear una nueva figura
        fig = plt.figure(figsize=(10, 6))
        ax = fig.add_subplot(111)

        # Crear datos para la gráfica
        variables = ['Carga (C)', 'Voltaje (V)', 'Energía (J)']
        valores = [carga, voltaje, energia]
        colores = ['blue', 'red', 'green']

        # Crear gráfico de barras
        barras = ax.bar(variables, valores, color=colores)

        # Personalizar gráfico
        ax.set_title('Relación entre Carga, Voltaje y Energía Eléctrica', pad=20)
        ax.set_ylabel('Valores')
        
        # Añadir valores sobre las barras
        for barra in barras:
            altura = barra.get_height()
            ax.text(barra.get_x() + barra.get_width()/2., altura,
                    f'{altura:.2f}',
                    ha='center', va='bottom')

        # Ajustar layout y mostrar
        plt.tight_layout()
        plt.show()

    def calcular_energia(self, carga, voltaje):
        return carga * voltaje
    
    def mini_juego_flujo(self):
        self.limpiar_interfaz()
        tk.Label(self.root, text="Mini-juego: Flujo de Fluido", font=("Helvetica", 18, "bold")).pack(pady=20)
        
        # Campos para entrada de velocidad
        tk.Label(self.root, text="Ingrese la velocidad del fluido (m/s):", font=("Helvetica", 14)).pack(pady=10)
        self.entrada_velocidad = tk.Entry(self.root)
        self.entrada_velocidad.pack(pady=5)
        
        # Campos para entrada de área
        tk.Label(self.root, text="Ingrese el área de la sección transversal (m²):", font=("Helvetica", 14)).pack(pady=10)
        self.entrada_area = tk.Entry(self.root)
        self.entrada_area.pack(pady=5)
        
        # Campo para la densidad del fluido (opcional)
        tk.Label(self.root, text="Ingrese la densidad del fluido (kg/m³):", font=("Helvetica", 14)).pack(pady=10)
        self.entrada_densidad = tk.Entry(self.root)
        self.entrada_densidad.insert(0, "1000")  # Valor por defecto para agua
        self.entrada_densidad.pack(pady=5)
        
        # Botón para calcular
        tk.Button(self.root, text="Calcular Flujo", 
                command=self.calcular_y_mostrar_flujo,
                font=("Helvetica", 12)).pack(pady=20)
        
        # Botón para volver al menú principal
        tk.Button(self.root, text="Volver al Menú Principal",
                command=self.mostrar_menu_principal,
                font=("Helvetica", 12)).pack(pady=10)

    def calcular_y_mostrar_flujo(self):
        try:
            # Obtener valores ingresados por el usuario
            velocidad = float(self.entrada_velocidad.get())
            area = float(self.entrada_area.get())
            densidad = float(self.entrada_densidad.get())
            
            # Calcular el flujo volumétrico y másico
            flujo_volumetrico = self.calcular_flujo(velocidad, area)
            flujo_masico = flujo_volumetrico * densidad
            
            # Mostrar resultados
            resultado = (f"Resultados:\n\n"
                        f"Velocidad: {velocidad:.2f} m/s\n"
                        f"Área: {area:.2f} m²\n"
                        f"Densidad: {densidad:.2f} kg/m³\n"
                        f"Flujo Volumétrico: {flujo_volumetrico:.2f} m³/s\n"
                        f"Flujo Másico: {flujo_masico:.2f} kg/s")
            messagebox.showinfo("Resultados del Cálculo", resultado)
            
            # Mostrar gráfica
            self.mostrar_grafica_flujo(velocidad, area, flujo_volumetrico, flujo_masico)
            
            # Actualizar puntos
            self.puntos += 10
            
        except ValueError:
            messagebox.showerror("Error", "Por favor, ingrese valores numéricos válidos.")

    def mostrar_grafica_flujo(self, velocidad, area, flujo_volumetrico, flujo_masico):
        # Crear una figura con dos subplots
        fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(12, 5))
        
        # Primer subplot: Relación entre velocidad, área y flujo volumétrico
        variables1 = ['Velocidad\n(m/s)', 'Área\n(m²)', 'Flujo Vol.\n(m³/s)']
        valores1 = [velocidad, area, flujo_volumetrico]
        colores1 = ['blue', 'green', 'red']
        
        barras1 = ax1.bar(variables1, valores1, color=colores1)
        ax1.set_title('Flujo Volumétrico y sus Componentes')
        ax1.set_ylabel('Valores')
        
        # Añadir valores sobre las barras
        for barra in barras1:
            altura = barra.get_height()
            ax1.text(barra.get_x() + barra.get_width()/2., altura,
                    f'{altura:.2f}',
                    ha='center', va='bottom')
        
        # Segundo subplot: Comparación flujo volumétrico vs másico
        variables2 = ['Flujo Volumétrico\n(m³/s)', 'Flujo Másico\n(kg/s)']
        valores2 = [flujo_volumetrico, flujo_masico]
        colores2 = ['red', 'purple']
        
        barras2 = ax2.bar(variables2, valores2, color=colores2)
        ax2.set_title('Comparación de Flujos')
        ax2.set_ylabel('Valores')
        
        # Añadir valores sobre las barras
        for barra in barras2:
            altura = barra.get_height()
            ax2.text(barra.get_x() + barra.get_width()/2., altura,
                    f'{altura:.2f}',
                    ha='center', va='bottom')
        
        # Ajustar layout y mostrar
        plt.tight_layout()
        plt.show()

    def calcular_flujo(self, velocidad, area):
        # Cálculo del flujo volumétrico
        return velocidad * area

    def mini_juego_exploracion(self):
        self.limpiar_interfaz()
        tk.Label(self.root, text="Mini-juego: Exploración de Objetos", font=("Helvetica", 18, "bold")).pack(pady=20)

        # Definir elementos disponibles para búsqueda
        self.elementos = {
            "estrella": {
                "coordenadas": {"x": random.uniform(-100, 100), "y": random.uniform(-100, 100), "z": random.uniform(-100, 100)},
                "descripcion": "Una estrella brillante en el espacio",
                "color": "yellow",
                "tamaño": random.uniform(1, 5)
            },
            "planeta": {
                "coordenadas": {"x": random.uniform(-100, 100), "y": random.uniform(-100, 100), "z": random.uniform(-100, 100)},
                "descripcion": "Un planeta misterioso",
                "color": "blue",
                "tamaño": random.uniform(5, 10)
            },
            "asteroide": {
                "coordenadas": {"x": random.uniform(-100, 100), "y": random.uniform(-100, 100), "z": random.uniform(-100, 100)},
                "descripcion": "Un asteroide flotando en el espacio",
                "color": "gray",
                "tamaño": random.uniform(0.5, 2)
            },
            "cometa": {
                "coordenadas": {"x": random.uniform(-100, 100), "y": random.uniform(-100, 100), "z": random.uniform(-100, 100)},
                "descripcion": "Un cometa con una brillante cola",
                "color": "white",
                "tamaño": random.uniform(2, 4)
            }
        }

        # Campo de búsqueda
        tk.Label(self.root, text="Buscar elemento (estrella/planeta/asteroide/cometa):", 
                font=("Helvetica", 14)).pack(pady=10)
        self.entrada_busqueda = tk.Entry(self.root)
        self.entrada_busqueda.pack(pady=5)

        # Botón de búsqueda
        tk.Button(self.root, text="Buscar", command=self.buscar_elemento,
                font=("Helvetica", 12)).pack(pady=10)

        # Área para mostrar resultados
        self.frame_resultados = tk.Frame(self.root)
        self.frame_resultados.pack(pady=20)

        # Botón para volver al menú
        tk.Button(self.root, text="Volver al menú", command=self.mostrar_menu_principal,
                font=("Helvetica", 12)).pack(pady=10)

    def buscar_elemento(self):
        elemento_buscado = self.entrada_busqueda.get().lower()
        
        # Limpiar resultados anteriores
        for widget in self.frame_resultados.winfo_children():
            widget.destroy()

        if elemento_buscado in self.elementos:
            self.mostrar_elemento_encontrado(elemento_buscado)
        else:
            tk.Label(self.frame_resultados, 
                    text="Elemento no encontrado. Intente con: estrella, planeta, asteroide o cometa",
                    font=("Helvetica", 12),
                    fg="red").pack()

    def mostrar_elemento_encontrado(self, elemento):
        info = self.elementos[elemento]
        
        # Crear frame para la información
        frame_info = tk.Frame(self.frame_resultados)
        frame_info.pack(pady=10)

        # Mostrar información del elemento
        tk.Label(frame_info, 
                text=f"¡{elemento.title()} encontrado!",
                font=("Helvetica", 16, "bold")).pack()

        tk.Label(frame_info,
                text=f"Descripción: {info['descripcion']}",
                font=("Helvetica", 12)).pack()

        # Mostrar coordenadas
        coords = info['coordenadas']
        tk.Label(frame_info,
                text=f"Coordenadas:\nX: {coords['x']:.2f}\nY: {coords['y']:.2f}\nZ: {coords['z']:.2f}",
                font=("Helvetica", 12)).pack()

        # Crear y mostrar visualización del elemento
        self.mostrar_visualizacion_elemento(elemento, info)
        
        # Añadir puntos
        self.puntos += 15

    def mostrar_visualizacion_elemento(self, elemento, info):
        # Crear figura 3D
        fig = plt.figure(figsize=(8, 6))
        ax = fig.add_subplot(111, projection='3d')

        # Obtener coordenadas
        x = info['coordenadas']['x']
        y = info['coordenadas']['y']
        z = info['coordenadas']['z']

        # Dibujar elemento según su tipo
        if elemento == "estrella":
            self.dibujar_estrella(ax, x, y, z, info)
        elif elemento == "planeta":
            self.dibujar_planeta(ax, x, y, z, info)
        elif elemento == "asteroide":
            self.dibujar_asteroide(ax, x, y, z, info)
        elif elemento == "cometa":
            self.dibujar_cometa(ax, x, y, z, info)

        # Configurar gráfico
        ax.set_xlabel('X')
        ax.set_ylabel('Y')
        ax.set_zlabel('Z')
        ax.set_title(f'Visualización de {elemento.title()}')

        # Establecer límites del gráfico
        ax.set_xlim(-100, 100)
        ax.set_ylim(-100, 100)
        ax.set_zlim(-100, 100)

        # Mostrar cuadrícula
        ax.grid(True)

        plt.show()

    def dibujar_estrella(self, ax, x, y, z, info):
        scatter = ax.scatter(x, y, z, c=info['color'], s=info['tamaño']*100, marker='*')
        # Añadir efecto de brillo
        ax.scatter(x, y, z, c='yellow', alpha=0.3, s=info['tamaño']*200)

    def dibujar_planeta(self, ax, x, y, z, info):
        # Crear una esfera
        u = np.linspace(0, 2 * np.pi, 100)
        v = np.linspace(0, np.pi, 100)
        radius = info['tamaño']
        x = x + radius * np.outer(np.cos(u), np.sin(v))
        y = y + radius * np.outer(np.sin(u), np.sin(v))
        z = z + radius * np.outer(np.ones(np.size(u)), np.cos(v))
        ax.plot_surface(x, y, z, color=info['color'], alpha=0.7)

    def dibujar_asteroide(self, ax, x, y, z, info):
        # Crear forma irregular
        scatter = ax.scatter(x, y, z, c=info['color'], s=info['tamaño']*100, marker='o')
        # Añadir algunos puntos alrededor para darle forma irregular
        for _ in range(5):
            dx = random.uniform(-0.5, 0.5) * info['tamaño']
            dy = random.uniform(-0.5, 0.5) * info['tamaño']
            dz = random.uniform(-0.5, 0.5) * info['tamaño']
            ax.scatter(x+dx, y+dy, z+dz, c=info['color'], s=info['tamaño']*50)

    def dibujar_cometa(self, ax, x, y, z, info):
        # Dibujar el núcleo del cometa
        ax.scatter(x, y, z, c=info['color'], s=info['tamaño']*100)
        
        # Dibujar la cola del cometa
        tail_length = info['tamaño'] * 2
        tail_points = 20
        for i in range(tail_points):
            alpha = 1 - (i/tail_points)
            size = info['tamaño'] * 100 * (1 - i/tail_points)
            ax.scatter(x - i*(tail_length/tail_points), 
                    y - i*(tail_length/tail_points), 
                    z - i*(tail_length/tail_points), 
                    c=info['color'], alpha=alpha, s=size)

if __name__ == "__main__":
    root = tk.Tk()
    juego = JuegoMetaversoGUI(root)
    root.mainloop()
