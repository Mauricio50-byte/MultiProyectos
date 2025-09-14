import numpy as np
import random
import time
from dataclasses import dataclass
from typing import Tuple, Dict, List, Optional
from enum import Enum
import logging
import json
from datetime import datetime
import matplotlib.pyplot as plt
from collections import deque

# Configuración de logging con rotación de archivos
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('traffic_simulation.log'),
        logging.StreamHandler()
    ]
)

class DireccionVehiculo(Enum):
    """Enumeración para las direcciones posibles de los vehículos"""
    NORTE = "Norte"
    SUR = "Sur"
    ESTE = "Este"
    OESTE = "Oeste"
    
    @classmethod
    def opuestas(cls, dir1, dir2):
        """Verifica si dos direcciones son opuestas"""
        return (
            (dir1 == cls.NORTE and dir2 == cls.SUR) or
            (dir1 == cls.SUR and dir2 == cls.NORTE) or
            (dir1 == cls.ESTE and dir2 == cls.OESTE) or
            (dir1 == cls.OESTE and dir2 == cls.ESTE)
        )

class TipoVehiculo(Enum):
    """Enumeración para los diferentes tipos de vehículos"""
    NORMAL = "Normal"
    EMERGENCIA = "Emergencia"
    TRANSPORTE_PUBLICO = "Transporte Público"
    CARGA = "Carga"
    BICICLETA = "Bicicleta"  # Nuevo tipo añadido

@dataclass
class ConfiguracionSimulacion:
    """Clase para almacenar la configuración de la simulación"""
    # Dimensiones de la matriz que representa la intersección
    tamaño_interseccion: Tuple[int, int] = (7, 7)  # Aumentado para mejor visualización
    max_vehiculos: int = 20  # Máximo número de vehículos simultáneos
    tiempo_cambio_semaforo: int = 8  # Ciclos antes de cambiar semáforos
    tiempo_max_espera: int = 5  # Tiempo máximo que un vehículo puede esperar
    probabilidad_nuevo_vehiculo: float = 0.4  # Probabilidad de generar nuevo vehículo
    velocidad_simulacion: float = 0.5  # Velocidad de actualización en segundos
    # Nuevos parámetros
    guardar_historial: bool = True  # Guardar historial para análisis
    tamaño_historial: int = 1000  # Número de estados a mantener en historial
    generar_graficas: bool = True  # Generar gráficas de estadísticas

class EstadisticasTrafico:
    """Clase mejorada para manejar las estadísticas del tráfico"""
    def __init__(self, config: ConfiguracionSimulacion):
        self.total_vehiculos = 0
        self.vehiculos_por_tipo: Dict[TipoVehiculo, int] = {tipo: 0 for tipo in TipoVehiculo}
        self.tiempo_espera_promedio = 0.0
        self.colisiones = []
        self.inicio_simulacion = datetime.now()
        # Nuevas estadísticas
        self.tiempos_espera = []  # Lista para almacenar tiempos de espera
        self.densidad_trafico = []  # Lista para almacenar densidad de tráfico
        self.historial_vehiculos = deque(maxlen=config.tamaño_historial)  # Historial limitado
        self.contadores_direccionales = {dir: 0 for dir in DireccionVehiculo}

    def registrar_vehiculo(self, tipo: TipoVehiculo, direccion: DireccionVehiculo):
        """Registra un nuevo vehículo en las estadísticas"""
        self.total_vehiculos += 1
        self.vehiculos_por_tipo[tipo] += 1
        self.contadores_direccionales[direccion] += 1

    def registrar_tiempo_espera(self, tiempo: float):
        """Registra el tiempo de espera de un vehículo"""
        self.tiempos_espera.append(tiempo)
        if self.tiempos_espera:
            self.tiempo_espera_promedio = sum(self.tiempos_espera) / len(self.tiempos_espera)

    def registrar_densidad(self, num_vehiculos: int, capacidad_total: int):
        """Registra la densidad actual del tráfico"""
        self.densidad_trafico.append(num_vehiculos / capacidad_total)

    def generar_graficas(self):
        """Genera gráficas de las estadísticas"""
        # Gráfica de tipos de vehículos
        plt.figure(figsize=(10, 6))
        tipos = list(self.vehiculos_por_tipo.keys())
        valores = list(self.vehiculos_por_tipo.values())
        plt.bar([tipo.value for tipo in tipos], valores)
        plt.title('Distribución de Tipos de Vehículos')
        plt.xticks(rotation=45)
        plt.savefig('distribucion_vehiculos.png')
        plt.close()

        # Gráfica de densidad de tráfico
        if self.densidad_trafico:
            plt.figure(figsize=(10, 6))
            plt.plot(self.densidad_trafico)
            plt.title('Densidad de Tráfico a lo largo del tiempo')
            plt.ylabel('Densidad')
            plt.xlabel('Ciclo de simulación')
            plt.savefig('densidad_trafico.png')
            plt.close()

    def exportar_estadisticas(self) -> dict:
        """Exporta las estadísticas en formato JSON"""
        return {
            "total_vehiculos": self.total_vehiculos,
            "vehiculos_por_tipo": {tipo.value: count for tipo, count in self.vehiculos_por_tipo.items()},
            "tiempo_espera_promedio": self.tiempo_espera_promedio,
            "colisiones": len(self.colisiones),
            "duracion_simulacion": str(datetime.now() - self.inicio_simulacion),
            "contadores_direccionales": {dir.value: count for dir, count in self.contadores_direccionales.items()},
            "densidad_promedio": sum(self.densidad_trafico) / len(self.densidad_trafico) if self.densidad_trafico else 0
        }

class Vehiculo:
    """Clase mejorada para representar vehículos con más características"""
    def __init__(self, direccion: DireccionVehiculo, tipo: TipoVehiculo):
        self.direccion = direccion
        self.tipo = tipo
        self.pos = self._calcular_pos_inicial()
        self.velocidad = self._asignar_velocidad()
        self.espera = False
        self.tiempo_espera = 0
        self.salir = False
        self.distancia_recorrida = 0
        self.id = f"{tipo.value}-{random.randint(1000, 9999)}"
        self.tiempo_creacion = time.time()
        
        # Características específicas según tipo
        self.prioridad = self._asignar_prioridad()
        self.tamaño = self._asignar_tamaño()
        self.capacidad_giro = self._asignar_capacidad_giro()
        
    def _asignar_prioridad(self) -> bool:
        """Asigna prioridad según el tipo de vehículo"""
        prioridades = {
            TipoVehiculo.EMERGENCIA: True,
            TipoVehiculo.TRANSPORTE_PUBLICO: False,
            TipoVehiculo.NORMAL: False,
            TipoVehiculo.CARGA: False,
            TipoVehiculo.BICICLETA: False
        }
        return prioridades[self.tipo]
    
    def _asignar_tamaño(self) -> int:
        """Asigna tamaño según el tipo de vehículo"""
        tamaños = {
            TipoVehiculo.NORMAL: 1,
            TipoVehiculo.EMERGENCIA: 1,
            TipoVehiculo.TRANSPORTE_PUBLICO: 2,
            TipoVehiculo.CARGA: 2,
            TipoVehiculo.BICICLETA: 1
        }
        return tamaños[self.tipo]
    
    def _asignar_capacidad_giro(self) -> float:
        """Asigna probabilidad de giro según el tipo de vehículo"""
        capacidades = {
            TipoVehiculo.NORMAL: 0.3,
            TipoVehiculo.EMERGENCIA: 0.4,
            TipoVehiculo.TRANSPORTE_PUBLICO: 0.1,
            TipoVehiculo.CARGA: 0.1,
            TipoVehiculo.BICICLETA: 0.5
        }
        return capacidades[self.tipo]

    def _calcular_pos_inicial(self) -> Tuple[int, int]:
        """Calcula la posición inicial según la dirección"""
        if self.direccion == DireccionVehiculo.NORTE:
            return (6, random.randint(2, 4))
        elif self.direccion == DireccionVehiculo.SUR:
            return (0, random.randint(2, 4))
        elif self.direccion == DireccionVehiculo.ESTE:
            return (random.randint(2, 4), 0)
        else:  # OESTE
            return (random.randint(2, 4), 6)

    def _asignar_velocidad(self) -> int:
        """Asigna velocidad según el tipo de vehículo"""
        velocidades = {
            TipoVehiculo.NORMAL: (1, 3),
            TipoVehiculo.EMERGENCIA: (2, 4),
            TipoVehiculo.TRANSPORTE_PUBLICO: (1, 2),
            TipoVehiculo.CARGA: (1, 2),
            TipoVehiculo.BICICLETA: (1, 1)
        }
        return random.randint(*velocidades[self.tipo])

    def intentar_giro(self) -> Optional[DireccionVehiculo]:
        """Intenta realizar un giro aleatorio"""
        if random.random() < self.capacidad_giro:
            nuevas_direcciones = [dir for dir in DireccionVehiculo 
                                if dir != self.direccion and 
                                not DireccionVehiculo.opuestas(dir, self.direccion)]
            return random.choice(nuevas_direcciones) if nuevas_direcciones else None
        return None

class Interseccion:
    """Clase mejorada para manejar la lógica de la intersección"""
    def __init__(self, config: ConfiguracionSimulacion):
        self.config = config
        # Matriz principal que representa la intersección
        self.grid = np.zeros(config.tamaño_interseccion)
        self.vehiculos: List[Vehiculo] = []
        # Vector de estados de semáforos
        self.semaforos = {dir: False for dir in DireccionVehiculo}
        self.contador_semaforos = 0
        self.estadisticas = EstadisticasTrafico(config)
        # Nueva matriz para zonas especiales
        self.zonas_especiales = np.zeros(config.tamaño_interseccion)
        self._inicializar_zonas_especiales()
        self.ciclo_actual = 0

    def _inicializar_zonas_especiales(self):
        """Inicializa zonas especiales en la intersección"""
        # Zona central (intersección crítica)
        self.zonas_especiales[2:5, 2:5] = 1
        # Pasos de peatones
        for i in range(2, 5):
            self.zonas_especiales[i, [1, 5]] = 2  # Verticales
            self.zonas_especiales[[1, 5], i] = 2  # Horizontales

    def actualizar(self):
        """Actualiza el estado de la intersección"""
        self.ciclo_actual += 1
        self._actualizar_semaforos()
        self._mover_vehiculos()
        self._generar_vehiculos()
        self._actualizar_grid()
        self._actualizar_estadisticas()

    def _actualizar_estadisticas(self):
        """Actualiza las estadísticas de la simulación"""
        # Calcular densidad actual
        capacidad_total = self.config.tamaño_interseccion[0] * self.config.tamaño_interseccion[1]
        self.estadisticas.registrar_densidad(len(self.vehiculos), capacidad_total)
        
        # Guardar estado actual si está configurado
        if self.config.guardar_historial:
            estado_actual = {
                'ciclo': self.ciclo_actual,
                'num_vehiculos': len(self.vehiculos),
                'semaforos': self.semaforos.copy(),
                'colisiones': len(self.estadisticas.colisiones)
            }
            self.estadisticas.historial_vehiculos.append(estado_actual)

    def _actualizar_semaforos(self):
        """Maneja la lógica de cambio de semáforos con tiempo amarillo"""
        self.contador_semaforos += 1
        if self.contador_semaforos >= self.config.tiempo_cambio_semaforo:
            # Implementación de tiempo amarillo (2 ciclos)
            if self.contador_semaforos == self.config.tiempo_cambio_semaforo:
                # Marca todos los semáforos en amarillo
                for direccion in DireccionVehiculo:
                    self.semaforos[direccion] = False
            elif self.contador_semaforos >= self.config.tiempo_cambio_semaforo + 2:
                # Cambio completo de semáforos
                self.semaforos[DireccionVehiculo.NORTE] = not self.semaforos[DireccionVehiculo.NORTE]
                self.semaforos[DireccionVehiculo.SUR] = self.semaforos[DireccionVehiculo.NORTE]
                self.semaforos[DireccionVehiculo.ESTE] = not self.semaforos[DireccionVehiculo.NORTE]
                self.semaforos[DireccionVehiculo.OESTE] = self.semaforos[DireccionVehiculo.ESTE]
                self.contador_semaforos = 0
                logging.info("Cambio de semáforos realizado")

    def _generar_vehiculos(self):
        """Genera nuevos vehículos con probabilidades ajustadas según tipo"""
        if (len(self.vehiculos) < self.config.max_vehiculos and 
            random.random() < self.config.probabilidad_nuevo_vehiculo):
            
            # Probabilidades ajustadas para cada tipo de vehículo
            tipo = random.choices(
                list(TipoVehiculo),
                weights=[0.6, 0.1, 0.15, 0.05, 0.1]  # Normal, Emergencia, Transporte, Carga, Bicicleta
            )[0]
            
            # Selección de dirección basada en el tráfico actual
            direcciones_disponibles = list(DireccionVehiculo)
            pesos_direcciones = []
            
            # Calcula pesos para cada dirección basado en la congestión
            for dir in direcciones_disponibles:
                vehiculos_en_direccion = sum(1 for v in self.vehiculos if v.direccion == dir)
                peso = 1.0 / (vehiculos_en_direccion + 1)  # Evita división por cero
                pesos_direcciones.append(peso)
            
            # Normaliza los pesos
            suma_pesos = sum(pesos_direcciones)
            pesos_direcciones = [p/suma_pesos for p in pesos_direcciones]
            
            # Selecciona dirección
            direccion = random.choices(direcciones_disponibles, weights=pesos_direcciones)[0]
            
            nuevo_vehiculo = Vehiculo(direccion, tipo)
            if self._es_posicion_valida(nuevo_vehiculo.pos):
                self.vehiculos.append(nuevo_vehiculo)
                self.estadisticas.registrar_vehiculo(tipo, direccion)
                logging.info(f"Nuevo vehículo generado: {nuevo_vehiculo.id} - Tipo: {tipo.value}")

    def _detectar_colisiones(self, posiciones: Dict[Tuple[int, int], Vehiculo]) -> List[Tuple[int, int]]:
        """
        Detecta colisiones entre vehículos considerando sus tamaños y zonas especiales
        Retorna: Lista de posiciones donde ocurrieron colisiones
        """
        colisiones = []
        # Matriz temporal para verificar ocupación
        ocupacion = np.zeros(self.config.tamaño_interseccion)
        
        for pos, vehiculo in posiciones.items():
            # Verifica el espacio ocupado por el vehículo según su tamaño
            for dx in range(vehiculo.tamaño):
                for dy in range(vehiculo.tamaño):
                    nueva_pos = (pos[0] + dx, pos[1] + dy)
                    if self._es_posicion_valida(nueva_pos):
                        if ocupacion[nueva_pos] == 1:  # Ya hay un vehículo aquí
                            colisiones.append(pos)
                            break
                        ocupacion[nueva_pos] = 1
                        
                        # Verifica zonas especiales
                        if self.zonas_especiales[nueva_pos] == 1:  # Zona crítica
                            # Verifica conflictos de dirección en zona crítica
                            for otro_pos, otro_vehiculo in posiciones.items():
                                if otro_pos != pos and self.zonas_especiales[otro_pos] == 1:
                                    if not DireccionVehiculo.opuestas(vehiculo.direccion, otro_vehiculo.direccion):
                                        colisiones.append(pos)
                                        break
        
        for pos in colisiones:
            logging.warning(f"Colisión detectada en {pos} con vehículo {posiciones[pos].id}")
        
        return colisiones

    def _mover_vehiculos(self):
        """
        Gestiona el movimiento de todos los vehículos en la intersección
        Implementa lógica de movimiento, giros y respeto a semáforos
        """
        posiciones_ocupadas = {}
        vehiculos_a_eliminar = []

        # Ordena vehículos por prioridad
        self.vehiculos.sort(key=lambda v: (-v.prioridad, v.tiempo_espera))

        for vehiculo in self.vehiculos:
            if vehiculo.salir:
                vehiculos_a_eliminar.append(vehiculo)
                continue

            # Determina si el vehículo puede moverse
            puede_moverse = (
                self.semaforos[vehiculo.direccion] or 
                vehiculo.prioridad or 
                vehiculo.tiempo_espera >= self.config.tiempo_max_espera
            )

            # Intenta realizar giro si es posible
            if puede_moverse and random.random() < vehiculo.capacidad_giro:
                nueva_direccion = vehiculo.intentar_giro()
                if nueva_direccion and self.semaforos[nueva_direccion]:
                    vehiculo.direccion = nueva_direccion

            # Realiza el movimiento si es posible
            if puede_moverse and random.randint(1, 3) <= vehiculo.velocidad:
                nueva_pos = self._calcular_nueva_posicion(vehiculo)
                
                # Verifica si la nueva posición es válida y está libre
                if self._es_posicion_valida(nueva_pos) and nueva_pos not in posiciones_ocupadas:
                    vehiculo.pos = nueva_pos
                    vehiculo.distancia_recorrida += 1
                    vehiculo.espera = False
                    
                    # Registra tiempo de espera si el vehículo estuvo esperando
                    if vehiculo.tiempo_espera > 0:
                        self.estadisticas.registrar_tiempo_espera(vehiculo.tiempo_espera)
                        vehiculo.tiempo_espera = 0
                elif not self._es_posicion_valida(nueva_pos):
                    vehiculo.salir = True
                    vehiculos_a_eliminar.append(vehiculo)
                else:
                    vehiculo.espera = True
                    vehiculo.tiempo_espera += 1
            else:
                vehiculo.espera = True
                vehiculo.tiempo_espera += 1

            if not vehiculo.salir:
                posiciones_ocupadas[vehiculo.pos] = vehiculo

        # Detectar y manejar colisiones
        colisiones = self._detectar_colisiones(posiciones_ocupadas)
        for pos in colisiones:
            self.estadisticas.colisiones.append({
                'posicion': pos,
                'ciclo': self.ciclo_actual,
                'vehiculos_involucrados': [
                    posiciones_ocupadas[pos].id
                ]
            })
            vehiculos_a_eliminar.append(posiciones_ocupadas[pos])

        # Eliminar vehículos
        for vehiculo in set(vehiculos_a_eliminar):  # Usa set para evitar duplicados
            if vehiculo in self.vehiculos:
                self.vehiculos.remove(vehiculo)

    def _calcular_nueva_posicion(self, vehiculo: Vehiculo) -> Tuple[int, int]:
        """
        Calcula la nueva posición para un vehículo según su dirección
        Retorna: Tupla con las nuevas coordenadas (x, y)
        """
        direcciones = {
            DireccionVehiculo.NORTE: (-1, 0),
            DireccionVehiculo.SUR: (1, 0),
            DireccionVehiculo.ESTE: (0, 1),
            DireccionVehiculo.OESTE: (0, -1)
        }
        dx, dy = direcciones[vehiculo.direccion]
        return (vehiculo.pos[0] + dx, vehiculo.pos[1] + dy)

    def _es_posicion_valida(self, pos: Tuple[int, int]) -> bool:
        """
        Verifica si una posición está dentro de los límites de la intersección
        Retorna: Boolean indicando si la posición es válida
        """
        return (0 <= pos[0] < self.config.tamaño_interseccion[0] and 
                0 <= pos[1] < self.config.tamaño_interseccion[1])

    def _actualizar_grid(self):
        """
        Actualiza la representación visual de la intersección en la matriz grid
        """
        # Limpia la grid
        self.grid.fill(0)
        
        # Valores para cada tipo de vehículo
        valores_tipo = {
            TipoVehiculo.NORMAL: 1,
            TipoVehiculo.EMERGENCIA: 2,
            TipoVehiculo.TRANSPORTE_PUBLICO: 3,
            TipoVehiculo.CARGA: 4,
            TipoVehiculo.BICICLETA: 5
        }
        
        # Actualiza la grid con la posición de cada vehículo
        for vehiculo in self.vehiculos:
            valor_base = valores_tipo[vehiculo.tipo]
            valor = valor_base if not vehiculo.espera else valor_base + 5
            
            # Marca la posición del vehículo y su área según su tamaño
            for dx in range(vehiculo.tamaño):
                for dy in range(vehiculo.tamaño):
                    pos = (vehiculo.pos[0] + dx, vehiculo.pos[1] + dy)
                    if self._es_posicion_valida(pos):
                        self.grid[pos] = valor

    def mostrar_estado(self):
        """
        Muestra el estado actual de la intersección de manera visual
        """
        # Símbolos para cada tipo de vehículo y estado
        simbolos = {
            0: "·",    # Vacío
            1: "🚗",   # Normal
            2: "🚑",   # Emergencia
            3: "🚌",   # Transporte público
            4: "🚛",   # Carga
            5: "🚲",   # Bicicleta
            6: "🔴",   # Normal en espera
            7: "🔵",   # Emergencia en espera
            8: "🟡",   # Transporte público en espera
            9: "⬛",   # Carga en espera
            10: "🟣"   # Bicicleta en espera
        }

        # Limpia la pantalla (solo en sistemas Unix)
        print("\033[H\033[J")
        
        print("\n=== Estado de la Intersección ===")
        # Muestra la grid con los símbolos correspondientes
        for fila in self.grid:
            print(" ".join(simbolos[int(cel)] for cel in fila))

        print("\n=== Estado de los Semáforos ===")
        for direccion, estado in self.semaforos.items():
            print(f"{direccion.value}: {'🟢' if estado else '🔴'}")

        print("\n=== Estadísticas ===")
        print(f"Ciclo actual: {self.ciclo_actual}")
        print(f"Vehículos activos: {len(self.vehiculos)}")
        print(f"Total colisiones: {len(self.estadisticas.colisiones)}")
        print(f"Vehículos procesados: {self.estadisticas.total_vehiculos}")
        print(f"Tiempo promedio de espera: {self.estadisticas.tiempo_espera_promedio:.2f}")

def main():
    """
    Función principal que ejecuta la simulación
    """
    # Configuración inicial
    config = ConfiguracionSimulacion()
    interseccion = Interseccion(config)
    
    try:
        while True:
            # Actualiza y muestra el estado de la simulación
            interseccion.actualizar()
            interseccion.mostrar_estado()
            
            # Pausa entre ciclos según la velocidad configurada
            time.sleep(config.velocidad_simulacion)
            
    except KeyboardInterrupt:
        print("\nSimulación interrumpida por el usuario")
        
        # Genera gráficas si está configurado
        if config.generar_graficas:
            interseccion.estadisticas.generar_graficas()
        
        # Exporta estadísticas
        with open('estadisticas_simulacion.json', 'w', encoding='utf-8') as f:
            json.dump(interseccion.estadisticas.exportar_estadisticas(), f, 
                    indent=4, ensure_ascii=False)
        
        logging.info("Simulación finalizada - Estadísticas exportadas correctamente")

if __name__ == "__main__":
    main()