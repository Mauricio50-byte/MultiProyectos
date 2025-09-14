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

# Configuracion de registro de eventos con rotacion de archivos
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('traffic_simulation.log'),
        logging.StreamHandler()
    ]
)

class DireccionVehiculo(Enum):
    """Enumeracion para las direcciones posibles de los vehiculos"""
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
    """Enumeracion para los diferentes tipos de vehiculos"""
    NORMAL = "Normal"
    EMERGENCIA = "Emergencia"
    TRANSPORTE_PUBLICO = "Transporte Publico"
    CARGA = "Carga"
    BICICLETA = "Bicicleta"  # Nuevo tipo anadido

@dataclass
class ConfiguracionSimulacion:
    """Clase para almacenar la configuracion de la simulacion"""
    # Dimensiones de la matriz que representa la interseccion
    tamano_interseccion: Tuple[int, int] = (10, 10)  # Aumentado para mejor visualizacion
    max_vehiculos: int = 20  # Maximo numero de vehiculos simultaneos
    tiempo_cambio_semaforo: int = 3  # Ciclos antes de cambiar semaforos
    tiempo_max_espera: int = 3  # Tiempo maximo que un vehiculo puede esperar
    probabilidad_nuevo_vehiculo: float = 2  # Probabilidad de generar nuevo vehiculo
    velocidad_simulacion: float = 3.5  # Velocidad de actualizacion en segundos
    # Nuevos parametros
    guardar_historial: bool = True  # Guardar historial para analisis
    tamano_historial: int = 1000  # Numero de estados a mantener en historial
    generar_graficas: bool = True  # Generar graficas de estadisticas

class EstadisticasTrafico:
    """Clase mejorada para manejar las estadisticas del trafico"""
    def __init__(self, config: ConfiguracionSimulacion):
        self.total_vehiculos = 0
        self.vehiculos_por_tipo: Dict[TipoVehiculo, int] = {tipo: 0 for tipo in TipoVehiculo}
        self.tiempo_espera_promedio = 0.0
        self.colisiones = []
        self.inicio_simulacion = datetime.now()
        # Nuevas estadisticas
        self.tiempos_espera = []  # Lista para almacenar tiempos de espera
        self.densidad_trafico = []  # Lista para almacenar densidad de trafico
        self.historial_vehiculos = deque(maxlen=config.tamano_historial)  # Historial limitado
        self.contadores_direccionales = {dir: 0 for dir in DireccionVehiculo}

    def registrar_vehiculo(self, tipo: TipoVehiculo, direccion: DireccionVehiculo):
        """Registra un nuevo vehiculo en las estadisticas"""
        self.total_vehiculos += 1
        self.vehiculos_por_tipo[tipo] += 1
        self.contadores_direccionales[direccion] += 1

    def registrar_tiempo_espera(self, tiempo: float):
        """Registra el tiempo de espera de un vehiculo"""
        self.tiempos_espera.append(tiempo)
        if self.tiempos_espera:
            self.tiempo_espera_promedio = sum(self.tiempos_espera) / len(self.tiempos_espera)

    def registrar_densidad(self, num_vehiculos: int, capacidad_total: int):
        """Registra la densidad actual del trafico"""
        self.densidad_trafico.append(num_vehiculos / capacidad_total)

    def generar_graficas(self):
        """Genera graficas de las estadisticas"""
        # Grafica de tipos de vehiculos
        plt.figure(figsize=(10, 6))
        tipos = list(self.vehiculos_por_tipo.keys())
        valores = list(self.vehiculos_por_tipo.values())
        plt.bar([tipo.value for tipo in tipos], valores)
        plt.title('Distribucion de Tipos de Vehiculos')
        plt.xticks(rotation=45)
        plt.savefig('distribucion_vehiculos.png')
        plt.close()

        # Grafica de densidad de trafico
        if self.densidad_trafico:
            plt.figure(figsize=(10, 6))
            plt.plot(self.densidad_trafico)
            plt.title('Densidad de Trafico a lo largo del tiempo')
            plt.ylabel('Densidad')
            plt.xlabel('Ciclo de simulacion')
            plt.savefig('densidad_trafico.png')
            plt.close()

    def exportar_estadisticas(self) -> dict:
        """Exporta las estadisticas en formato JSON"""
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
    """Clase mejorada para representar vehiculos con mas caracteristicas"""
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
        
        # Caracteristicas especificas segun tipo
        self.prioridad = self._asignar_prioridad()
        self.tamano = self._asignar_tamano()
        self.capacidad_giro = self._asignar_capacidad_giro()
        
    def _asignar_prioridad(self) -> bool:
        """Asigna prioridad segun el tipo de vehiculo"""
        prioridades = {
            TipoVehiculo.EMERGENCIA: True,
            TipoVehiculo.TRANSPORTE_PUBLICO: False,
            TipoVehiculo.NORMAL: False,
            TipoVehiculo.CARGA: False,
            TipoVehiculo.BICICLETA: False
        }
        return prioridades[self.tipo]
    
    def _asignar_tamano(self) -> int:
        """Asigna tamano segun el tipo de vehiculo"""
        tamanos = {
            TipoVehiculo.NORMAL: 1,
            TipoVehiculo.EMERGENCIA: 1,
            TipoVehiculo.TRANSPORTE_PUBLICO: 2,
            TipoVehiculo.CARGA: 2,
            TipoVehiculo.BICICLETA: 1
        }
        return tamanos[self.tipo]
    
    def _asignar_capacidad_giro(self) -> float:
        """Asigna probabilidad de giro segun el tipo de vehiculo"""
        capacidades = {
            TipoVehiculo.NORMAL: 0.3,
            TipoVehiculo.EMERGENCIA: 0.4,
            TipoVehiculo.TRANSPORTE_PUBLICO: 0.1,
            TipoVehiculo.CARGA: 0.1,
            TipoVehiculo.BICICLETA: 0.5
        }
        return capacidades[self.tipo]

    def _calcular_pos_inicial(self) -> Tuple[int, int]:
        """Calcula la posicion inicial segun la direccion"""
        if self.direccion == DireccionVehiculo.NORTE:
            return (6, random.randint(2, 4))
        elif self.direccion == DireccionVehiculo.SUR:
            return (0, random.randint(2, 4))
        elif self.direccion == DireccionVehiculo.ESTE:
            return (random.randint(2, 4), 0)
        else:  # OESTE
            return (random.randint(2, 4), 6)

    def _asignar_velocidad(self) -> int:
        """Asigna velocidad segun el tipo de vehiculo"""
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
    """Clase mejorada para manejar la logica de la interseccion"""
    def __init__(self, config: ConfiguracionSimulacion):
        self.config = config
        # Matriz principal que representa la interseccion
        self.grid = np.zeros(config.tamano_interseccion)
        self.vehiculos: List[Vehiculo] = []
        # Vector de estados de semaforos
        self.semaforos = {dir: False for dir in DireccionVehiculo}
        self.contador_semaforos = 0
        self.estadisticas = EstadisticasTrafico(config)
        # Nueva matriz para zonas especiales
        self.zonas_especiales = np.zeros(config.tamano_interseccion)
        self._inicializar_zonas_especiales()
        self.ciclo_actual = 0

    def _inicializar_zonas_especiales(self):
        """Inicializa zonas especiales en la interseccion"""
        # Zona central (interseccion critica)
        self.zonas_especiales[2:5, 2:5] = 1
        # Pasos de peatones
        for i in range(2, 5):
            self.zonas_especiales[i, [1, 5]] = 2  # Verticales
            self.zonas_especiales[[1, 5], i] = 2  # Horizontales

    def actualizar(self):
        """Actualiza el estado de la interseccion"""
        self.ciclo_actual += 1
        self._actualizar_semaforos()
        self._mover_vehiculos()
        self._generar_vehiculos()
        self._actualizar_grid()
        self._actualizar_estadisticas()

    def _actualizar_estadisticas(self):
        """Actualiza las estadisticas de la simulacion"""
        # Calcular densidad actual
        capacidad_total = self.config.tamano_interseccion[0] * self.config.tamano_interseccion[1]
        self.estadisticas.registrar_densidad(len(self.vehiculos), capacidad_total)
        
        # Guardar estado actual si esta configurado
        if self.config.guardar_historial:
            estado_actual = {
                'ciclo': self.ciclo_actual,
                'num_vehiculos': len(self.vehiculos),
                'semaforos': self.semaforos.copy(),
                'colisiones': len(self.estadisticas.colisiones)
            }
            self.estadisticas.historial_vehiculos.append(estado_actual)

    def _actualizar_semaforos(self):
        """Maneja la logica de cambio de semaforos con tiempo amarillo"""
        self.contador_semaforos += 1
        if self.contador_semaforos >= self.config.tiempo_cambio_semaforo:
            # Implementacion de tiempo amarillo (2 ciclos)
            if self.contador_semaforos == self.config.tiempo_cambio_semaforo:
                # Marca todos los semaforos en amarillo
                for direccion in DireccionVehiculo:
                    self.semaforos[direccion] = False
            elif self.contador_semaforos >= self.config.tiempo_cambio_semaforo + 2:
                # Cambio completo de semaforos
                self.semaforos[DireccionVehiculo.NORTE] = not self.semaforos[DireccionVehiculo.NORTE]
                self.semaforos[DireccionVehiculo.SUR] = self.semaforos[DireccionVehiculo.NORTE]
                self.semaforos[DireccionVehiculo.ESTE] = not self.semaforos[DireccionVehiculo.NORTE]
                self.semaforos[DireccionVehiculo.OESTE] = self.semaforos[DireccionVehiculo.ESTE]
                self.contador_semaforos = 0
                logging.info("Cambio de semaforos realizado")

    def _generar_vehiculos(self):
        """Genera nuevos vehiculos con probabilidades ajustadas segun tipo"""
        if (len(self.vehiculos) < self.config.max_vehiculos and 
            random.random() < self.config.probabilidad_nuevo_vehiculo):
            
            # Probabilidades ajustadas para cada tipo de vehiculo
            tipo = random.choices(
                list(TipoVehiculo),
                weights=[0.6, 0.1, 0.15, 0.05, 0.1]  # Normal, Emergencia, Transporte, Carga, Bicicleta
            )[0]
            
            # Seleccion de direccion basada en el trafico actual
            direcciones_disponibles = list(DireccionVehiculo)
            pesos_direcciones = []
            
            # Calcula pesos para cada direccion basado en la congestion
            for dir in direcciones_disponibles:
                vehiculos_en_direccion = sum(1 for v in self.vehiculos if v.direccion == dir)
                peso = 1.0 / (vehiculos_en_direccion + 1)  # Evita división por cero
                pesos_direcciones.append(peso)
            
                
            # Normaliza los pesos
            suma_pesos = sum(pesos_direcciones)
            pesos_direcciones = [p/suma_pesos for p in pesos_direcciones]
                    
            # Selecciona direccion
            direccion = random.choices(direcciones_disponibles, weights=pesos_direcciones)[0]
                    
            nuevo_vehiculo = Vehiculo(direccion, tipo)
            if self._es_posicion_valida(nuevo_vehiculo.pos):
                self.vehiculos.append(nuevo_vehiculo)
                self.estadisticas.registrar_vehiculo(tipo, direccion)
                logging.info(f"Nuevo vehiculo generado: {nuevo_vehiculo.id} - Tipo: {tipo.value}")

    def _detectar_colisiones(self, posiciones: Dict[Tuple[int, int], Vehiculo]) -> List[Tuple[int, int]]:
        """
        Detecta colisiones entre vehiculos considerando sus tamanos y zonas especiales
        Retorna: Lista de posiciones donde ocurrieron colisiones
        """
        colisiones = []
        # Matriz temporal para verificar ocupacion
        ocupacion = np.zeros(self.config.tamano_interseccion)
            
        for pos, vehiculo in posiciones.items():
            # Verifica el espacio ocupado por el vehiculo segun su tamano
            for dx in range(vehiculo.tamano):
                for dy in range(vehiculo.tamano):
                    nueva_pos = (pos[0] + dx, pos[1] + dy)
                    if self._es_posicion_valida(nueva_pos):
                        if ocupacion[nueva_pos] == 1:  # Ya hay un vehiculo aqui
                            colisiones.append(pos)
                            break
                        ocupacion[nueva_pos] = 1
                            
                        # Verifica zonas especiales
                        if self.zonas_especiales[nueva_pos] == 1:  # Zona critica
                            # Verifica conflictos de direccion en zona critica
                            for otro_pos, otro_vehiculo in posiciones.items():
                                if otro_pos != pos and self.zonas_especiales[otro_pos] == 1:
                                    if not DireccionVehiculo.opuestas(vehiculo.direccion, otro_vehiculo.direccion):
                                        colisiones.append(pos)
                                        break
            
        for pos in colisiones:
            logging.warning(f"Colision detectada en {pos} con vehiculo {posiciones[pos].id}")
            
        return colisiones

    def _mover_vehiculos(self):
        """
        Gestiona el movimiento de todos los vehiculos en la interseccion
        Implementa logica de movimiento, giros y respeto a semaforos
        """
        posiciones_ocupadas = {}
        vehiculos_a_eliminar = []

        # Ordena vehiculos por prioridad
        self.vehiculos.sort(key=lambda v: (-v.prioridad, v.tiempo_espera))

        for vehiculo in self.vehiculos:
            if vehiculo.salir:
                vehiculos_a_eliminar.append(vehiculo)
                continue

            # Determina si el vehiculo puede moverse
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
                    
                # Verifica si la nueva posicion es valida y esta libre
                if self._es_posicion_valida(nueva_pos) and nueva_pos not in posiciones_ocupadas:
                    vehiculo.pos = nueva_pos
                    vehiculo.distancia_recorrida += 1
                    vehiculo.espera = False
                        
                    # Registra tiempo de espera si el vehiculo estuvo esperando
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

        # Eliminar vehiculos
        for vehiculo in set(vehiculos_a_eliminar):  # Usa set para evitar duplicados
            if vehiculo in self.vehiculos:
                self.vehiculos.remove(vehiculo)

    def _calcular_nueva_posicion(self, vehiculo: Vehiculo) -> Tuple[int, int]:
        """
        Calcula la nueva posicion para un vehiculo segun su direccion
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
        Verifica si una posicion esta dentro de los limites de la interseccion
        Retorna: Boolean indicando si la posicion es valida
        """
        return (0 <= pos[0] < self.config.tamano_interseccion[0] and 
                0 <= pos[1] < self.config.tamano_interseccion[1])

    def _actualizar_grid(self):
        """
        Actualiza la representacion visual de la interseccion en la matriz grid
        """
        # Limpia la grid
        self.grid.fill(0)
            
        # Valores para cada tipo de vehiculo
        valores_tipo = {
            TipoVehiculo.NORMAL: 1,
            TipoVehiculo.EMERGENCIA: 2,
            TipoVehiculo.TRANSPORTE_PUBLICO: 3,
            TipoVehiculo.CARGA: 4,
            TipoVehiculo.BICICLETA: 5
        }
            
        # Actualiza la grid con la posicion de cada vehiculo
        for vehiculo in self.vehiculos:
            valor_base = valores_tipo[vehiculo.tipo]
            valor = valor_base if not vehiculo.espera else valor_base + 5
                
            # Marca la posicion del vehiculo y su area segun su tamano
            for dx in range(vehiculo.tamano):
                for dy in range(vehiculo.tamano):
                    pos = (vehiculo.pos[0] + dx, vehiculo.pos[1] + dy)
                    if self._es_posicion_valida(pos):
                        self.grid[pos] = valor

    def mostrar_estado(self):
        """
        Muestra el estado actual de la interseccion de manera visual
        """
        # Simbolos para cada tipo de vehiculo y estado
        simbolos = {
            0: "·",    # Vacio
            1: "🚗",   # Normal
            2: "🚑",   # Emergencia
            3: "🚌",   # Transporte publico
            4: "🚛",   # Carga
            5: "🚲",   # Bicicleta
            6: "🔴",   # Normal en espera
            7: "🔵",   # Emergencia en espera
            8: "🟡",   # Transporte publico en espera
            9: "⬛",   # Carga en espera
            10: "🟣"   # Bicicleta en espera
        }

        # Limpia la pantalla (solo en sistemas Unix)
        print("\033[H\033[J")
            
        print("\n=== Estado de la Interseccion ===")
        # Muestra la grid con los simbolos correspondientes
        for fila in self.grid:
            print(" ".join(simbolos[int(cel)] for cel in fila))

        print("\n=== Estado de los Semaforos ===")
        for direccion, estado in self.semaforos.items():
            print(f"{direccion.value}: {'🟢' if estado else '🔴'}")

        print("\n=== Estadisticas ===")
        print(f"Ciclo actual: {self.ciclo_actual}")
        print(f"Vehiculos activos: {len(self.vehiculos)}")
        print(f"Total colisiones: {len(self.estadisticas.colisiones)}")
        print(f"Vehiculos procesados: {self.estadisticas.total_vehiculos}")
        print(f"Tiempo promedio de espera: {self.estadisticas.tiempo_espera_promedio:.2f}")

def main():
    """
    Funcion principal que ejecuta la simulacion
    """
    # Configuracion inicial
    config = ConfiguracionSimulacion()
    interseccion = Interseccion(config)
    
    try:
        while True:
            # Actualiza y muestra el estado de la simulacion
            interseccion.actualizar()
            interseccion.mostrar_estado()
            
            # Pausa entre ciclos segun la velocidad configurada
            time.sleep(config.velocidad_simulacion)
            
    except KeyboardInterrupt:
        print("\nSimulacion interrumpida por el usuario")
        
        # Genera graficas si esta configurado
        if config.generar_graficas:
            interseccion.estadisticas.generar_graficas()
        
        # Exporta estadisticas
        with open('estadisticas_simulacion.json', 'w', encoding='utf-8') as f:
            json.dump(interseccion.estadisticas.exportar_estadisticas(), f, 
                    indent=4, ensure_ascii=False)
        
        logging.info("Simulacion finalizada - Estadisticas exportadas correctamente")

if __name__ == "__main__":
    main()