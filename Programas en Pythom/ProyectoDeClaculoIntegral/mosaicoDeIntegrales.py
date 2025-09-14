import numpy as np
from scipy import integrate
import matplotlib.pyplot as plt
from matplotlib.gridspec import GridSpec
from typing import Callable, List, Tuple, Dict, Optional
import sympy as sp
from dataclasses import dataclass
import time
from datetime import datetime
import logging
import json
import tkinter as tk
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure
import seaborn as sns

# Configuración de logging mejorada
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('mosaic_generator.log'),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger(__name__)

@dataclass
class CalculoIntegral:
    """Clase para almacenar resultados de cálculos integrales."""
    valor: float
    error: float
    tiempo_calculo: float
    coordenadas: Tuple[float, float, float, float]
    convergencia: bool = True
    iteraciones: int = 0

class AnalizadorMatematico:
    """Clase mejorada para realizar análisis matemático de las funciones."""
    
    def __init__(self):
        self.x, self.y = sp.symbols('x y')
        
    def obtener_derivadas(self, expr_str: str) -> Dict[str, str]:
        """Calcula las derivadas parciales y características adicionales de la función."""
        try:
            expr = sp.sympify(expr_str)
            resultados = {
                'dx': str(sp.diff(expr, self.x)),
                'dy': str(sp.diff(expr, self.y)),
                'dxy': str(sp.diff(sp.diff(expr, self.x), self.y)),
                'laplaciano': str(sp.diff(expr, self.x, 2) + sp.diff(expr, self.y, 2)),
                'gradiente': str((sp.diff(expr, self.x), sp.diff(expr, self.y))),
                'singularidades': self._encontrar_singularidades(expr)
            }
            return resultados
        except Exception as e:
            logger.error(f"Error al calcular derivadas: {e}")
            return {}
    
    def _encontrar_singularidades(self, expr) -> List[str]:
        """Encuentra posibles singularidades en la expresión."""
        try:
            denominadores = self._obtener_denominadores(expr)
            singularidades = []
            for denom in denominadores:
                sols = sp.solve(denom, self.x)
                if sols:
                    singularidades.extend(str(sol) for sol in sols)
            return singularidades
        except Exception:
            return []
    
    def _obtener_denominadores(self, expr):
        """Obtiene los denominadores de una expresión."""
        if expr.is_rational_function():
            return [sp.denom(sp.together(expr))]
        return []

class FuncionAvanzada:
    """Clase mejorada para manejar funciones matemáticas."""
    
    def __init__(self, 
                 func: Callable,
                 expr_str: str,
                 limites: Tuple[float, float],
                 nombre: str = "",
                 color: str = "viridis"):
        self.func = func
        self.expr_str = expr_str
        self.limites = limites
        self.nombre = nombre
        self.color = color
        self.analizador = AnalizadorMatematico()
        self.derivadas = self.analizador.obtener_derivadas(expr_str)
        self.calculos: List[CalculoIntegral] = []
        self.estadisticas = {
            'tiempo_promedio': 0.0,
            'error_promedio': 0.0,
            'convergencia_rate': 1.0
        }
    
    def calcular_integral_region(self, 
                               x1: float, x2: float, 
                               y1: float, y2: float,
                               tolerancia: float = 1e-6,
                               max_iter: int = 50) -> CalculoIntegral:
        """Calcula la integral doble en una región con control de convergencia."""
        tiempo_inicio = time.time()
        iteraciones = 0
        convergencia = True
        
        try:
            resultado, error = integrate.dblquad(
                lambda y, x: self.func(x, y),
                x1, x2,
                lambda x: y1,
                lambda x: y2,
                epsabs=tolerancia,
                epsrel=tolerancia
            )
            
            if error > tolerancia and iteraciones < max_iter:
                # Intento de refinamiento adaptativo
                resultado_refinado, error_refinado = self._refinar_integral(
                    x1, x2, y1, y2, tolerancia/10
                )
                if error_refinado < error:
                    resultado, error = resultado_refinado, error_refinado
                    iteraciones += 1
                
        except Exception as e:
            logger.error(f"Error en integración: {e}")
            resultado, error = 0.0, float('inf')
            convergencia = False
            
        tiempo_calculo = time.time() - tiempo_inicio
        
        calculo = CalculoIntegral(
            valor=resultado,
            error=error,
            tiempo_calculo=tiempo_calculo,
            coordenadas=(x1, x2, y1, y2),
            convergencia=convergencia,
            iteraciones=iteraciones
        )
        self.calculos.append(calculo)
        self._actualizar_estadisticas(calculo)
        return calculo
    
    def _refinar_integral(self, x1, x2, y1, y2, tolerancia):
        """Método para refinar el cálculo de la integral en regiones difíciles."""
        xm = (x1 + x2) / 2
        ym = (y1 + y2) / 2
        
        # Calcular en subregiones
        resultados = []
        errores = []
        
        regiones = [
            (x1, xm, y1, ym),
            (xm, x2, y1, ym),
            (x1, xm, ym, y2),
            (xm, x2, ym, y2)
        ]
        
        for rx1, rx2, ry1, ry2 in regiones:
            try:
                r, e = integrate.dblquad(
                    lambda y, x: self.func(x, y),
                    rx1, rx2,
                    lambda x: ry1,
                    lambda x: ry2,
                    epsabs=tolerancia,
                    epsrel=tolerancia
                )
                resultados.append(r)
                errores.append(e)
            except Exception:
                return 0.0, float('inf')
        
        return sum(resultados), max(errores)
    
    def _actualizar_estadisticas(self, calculo: CalculoIntegral) -> None:
        """Actualiza las estadísticas de la función basado en nuevos cálculos."""
        n = len(self.calculos)
        self.estadisticas['tiempo_promedio'] = (
            (self.estadisticas['tiempo_promedio'] * (n-1) + calculo.tiempo_calculo) / n
        )
        self.estadisticas['error_promedio'] = (
            (self.estadisticas['error_promedio'] * (n-1) + calculo.error) / n
        )
        self.estadisticas['convergencia_rate'] = (
            sum(1 for c in self.calculos if c.convergencia) / n
        )

class GeneradorMosaicoAvanzado:
    """Clase principal mejorada para generar mosaicos con análisis avanzado."""
    
    def __init__(self,
                 ancho: int,
                 alto: int,
                 num_divisiones: int,
                 funciones: List[FuncionAvanzada]):
        self.ancho = ancho
        self.alto = alto
        self.num_divisiones = num_divisiones
        self.funciones = funciones
        self.matriz_valores = np.zeros((num_divisiones, num_divisiones))
        self.matriz_errores = np.zeros((num_divisiones, num_divisiones))
        self.matriz_tiempos = np.zeros((num_divisiones, num_divisiones))
        self.metricas = {
            'tiempo_total': 0.0,
            'max_error': 0.0,
            'min_valor': float('inf'),
            'max_valor': float('-inf'),
            'regiones_divergentes': 0,
            'tiempo_promedio_por_region': 0.0
        }
        self.ventana = None
        self.fig = None
    
    def _generar_matriz_base(self) -> None:
        """Genera las matrices base con métricas detalladas."""
        tiempo_inicio = time.time()
        dx = self.ancho / self.num_divisiones
        dy = self.alto / self.num_divisiones
        regiones_divergentes = 0
        
        for i in range(self.num_divisiones):
            for j in range(self.num_divisiones):
                x1 = i * dx
                x2 = (i + 1) * dx
                y1 = j * dy
                y2 = (j + 1) * dy
                
                valor_celda = 0
                error_celda = 0
                tiempo_celda = 0
                
                for func in self.funciones:
                    calculo = func.calcular_integral_region(x1, x2, y1, y2)
                    valor_celda += calculo.valor
                    error_celda = max(error_celda, calculo.error)
                    tiempo_celda += calculo.tiempo_calculo
                    
                    if not calculo.convergencia:
                        regiones_divergentes += 1
                
                self.matriz_valores[i, j] = valor_celda
                self.matriz_errores[i, j] = error_celda
                self.matriz_tiempos[i, j] = tiempo_celda
                
                self.metricas['max_error'] = max(
                    self.metricas['max_error'],
                    error_celda
                )
                self.metricas['min_valor'] = min(
                    self.metricas['min_valor'],
                    valor_celda
                )
                self.metricas['max_valor'] = max(
                    self.metricas['max_valor'],
                    valor_celda
                )
        
        tiempo_total = time.time() - tiempo_inicio
        self.metricas.update({
            'tiempo_total': tiempo_total,
            'regiones_divergentes': regiones_divergentes,
            'tiempo_promedio_por_region': tiempo_total / (self.num_divisiones ** 2)
        })
    
    def _crear_ventana(self) -> None:
        """Crea la ventana principal de la aplicación."""
        self.ventana = tk.Tk()
        self.ventana.title("Análisis de Mosaico Matemático Avanzado")
        
        # Configurar la ventana para que ocupe toda la pantalla
        ancho_pantalla = self.ventana.winfo_screenwidth()
        alto_pantalla = self.ventana.winfo_screenheight()
        self.ventana.geometry(f"{ancho_pantalla}x{alto_pantalla}+0+0")
        
        # Crear el menú
        self._crear_menu()
        
        # Crear el frame principal
        frame_principal = tk.Frame(self.ventana)
        frame_principal.pack(fill=tk.BOTH, expand=True)
        
        # Crear la figura de matplotlib
        self.fig = Figure(figsize=(ancho_pantalla/100, alto_pantalla/100), dpi=100)
        
        # Crear el canvas
        canvas = FigureCanvasTkAgg(self.fig, master=frame_principal)
        canvas.draw()
        canvas.get_tk_widget().pack(fill=tk.BOTH, expand=True)
    
    def _crear_menu(self) -> None:
        """Crea la barra de menú de la aplicación."""
        menu_bar = tk.Menu(self.ventana)
        self.ventana.config(menu=menu_bar)
        
        # Menú Archivo
        file_menu = tk.Menu(menu_bar, tearoff=0)
        menu_bar.add_cascade(label="Archivo", menu=file_menu)
        file_menu.add_command(label="Guardar Imagen", command=self._guardar_imagen)
        file_menu.add_command(label="Guardar Datos", command=self._guardar_datos)
        file_menu.add_separator()
        file_menu.add_command(label="Salir", command=self.ventana.quit)
        
        # Menú Vista
        view_menu = tk.Menu(menu_bar, tearoff=0)
        menu_bar.add_cascade(label="Vista", menu=view_menu)
        view_menu.add_command(label="Actualizar", command=self._actualizar_visualizacion)
        view_menu.add_command(label="Cambiar Paleta", command=self._cambiar_paleta)
    
    def _guardar_imagen(self) -> None:
        """Guarda la visualización actual como imagen."""
        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        filename = f"mosaico_analisis_{timestamp}.png"
        self.fig.savefig(filename, dpi=300, bbox_inches='tight')
        logger.info(f"Imagen guardada como '{filename}'")
    
    def _guardar_datos(self) -> None:
        """Guarda los datos y métricas en formato JSON."""
        datos = {
            'metricas': self.metricas,
            'funciones': [
                {
                    'nombre': func.nombre,
                    'expresion': func.expr_str,
                    'estadisticas': func.estadisticas
                }
                for func in self.funciones
            ]
        }
        
        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        filename = f"datos_mosaico_{timestamp}.json"
        
        with open(filename, 'w') as f:
            json.dump(datos, f, indent=4)
        logger.info(f"Datos guardados como '{filename}'")
    
    def _actualizar_visualizacion(self) -> None:
        """Actualiza la visualización del mosaico."""
        self._generar_matriz_base()
        self._crear_visualizacion()
    
    def _cambiar_paleta(self) -> None:
        """Cambia la paleta de colores del mosaico."""
        paletas = ['viridis', 'magma', 'plasma', 'inferno', 'cividis']
        current_idx = paletas.index(self.funciones[0].color)
        new_idx = (current_idx + 1) % len(paletas)
        
        for func in self.funciones:
            func.color = paletas[new_idx]
        
        self._actualizar
    def _actualizar_visualizacion(self) -> None:
        """Actualiza la visualización completa del mosaico."""
        self.fig.clear()
        self._crear_visualizacion()
        self.fig.canvas.draw()

    def _crear_visualizacion(self) -> None:
        """Crea la visualización completa con análisis detallado."""
        gs = GridSpec(3, 4, figure=self.fig, wspace=0.4, hspace=0.4)
        
        # 1. Mosaico principal con valores
        ax_mosaico = self.fig.add_subplot(gs[0:2, 0:2])
        im = ax_mosaico.imshow(self.matriz_valores, 
                              cmap=self.funciones[0].color,
                              aspect='equal')
        ax_mosaico.set_title("Mosaico de Valores", fontsize=12)
        self.fig.colorbar(im, ax=ax_mosaico, label='Valor de la integral')
        
        # 2. Mapa de errores
        ax_errores = self.fig.add_subplot(gs[0:2, 2])
        im_err = ax_errores.imshow(self.matriz_errores,
                                  cmap='Reds',
                                  aspect='equal')
        ax_errores.set_title("Mapa de Errores", fontsize=12)
        self.fig.colorbar(im_err, ax=ax_errores, label='Error estimado')
        
        # 3. Mapa de tiempos
        ax_tiempos = self.fig.add_subplot(gs[0:2, 3])
        im_time = ax_tiempos.imshow(self.matriz_tiempos,
                                   cmap='YlOrRd',
                                   aspect='equal')
        ax_tiempos.set_title("Tiempos de Cálculo", fontsize=12)
        self.fig.colorbar(im_time, ax=ax_tiempos, label='Tiempo (s)')
        
        # 4. Histograma de valores
        ax_hist = self.fig.add_subplot(gs[2, 0])
        sns.histplot(data=self.matriz_valores.flatten(),
                    ax=ax_hist,
                    kde=True)
        ax_hist.set_title("Distribución de Valores", fontsize=12)
        
        # 5. Estadísticas de convergencia
        ax_stats = self.fig.add_subplot(gs[2, 1])
        ax_stats.axis('off')
        stats_text = self._generar_texto_estadisticas()
        ax_stats.text(0.05, 0.95, stats_text,
                     va='top',
                     fontsize=10,
                     family='monospace')
        
        # 6. Información de derivadas
        ax_derivadas = self.fig.add_subplot(gs[2, 2:])
        ax_derivadas.axis('off')
        derivadas_text = self._generar_texto_derivadas()
        ax_derivadas.text(0.05, 0.95, derivadas_text,
                         va='top',
                         fontsize=10,
                         family='monospace')
        
        self.fig.suptitle("Análisis Completo del Mosaico Matemático",
                         fontsize=16,
                         y=0.98)
    
    def _generar_texto_estadisticas(self) -> str:
        """Genera el texto con las estadísticas del cálculo."""
        return (
            f"Estadísticas:\n\n"
            f"Tiempo total: {self.metricas['tiempo_total']:.2f}s\n"
            f"Error máximo: {self.metricas['max_error']:.2e}\n"
            f"Valor mín: {self.metricas['min_valor']:.2f}\n"
            f"Valor máx: {self.metricas['max_valor']:.2f}\n"
            f"Regiones divergentes: {self.metricas['regiones_divergentes']}\n"
            f"Tiempo promedio/región: {self.metricas['tiempo_promedio_por_region']:.3f}s"
        )
    
    def _generar_texto_derivadas(self) -> str:
        """Genera el texto con la información de las derivadas."""
        texto = "Análisis de Funciones:\n\n"
        for func in self.funciones:
            texto += f"{func.nombre}:\n"
            texto += f"f(x,y) = {func.expr_str}\n"
            if 'dx' in func.derivadas:
                texto += f"∂/∂x = {func.derivadas['dx']}\n"
            if 'dy' in func.derivadas:
                texto += f"∂/∂y = {func.derivadas['dy']}\n"
            if 'laplaciano' in func.derivadas:
                texto += f"∇²f = {func.derivadas['laplaciano']}\n"
            texto += "\n"
        return texto
    
    def generar_visualizacion_completa(self,
                                    titulo: str = "Análisis de Mosaico Matemático",
                                    mostrar: bool = True,
                                    guardar: bool = False) -> None:
        """Genera y muestra la visualización completa en una ventana."""
        self._generar_matriz_base()
        self._crear_ventana()
        self._crear_visualizacion()
        
        if guardar:
            self._guardar_imagen()
            self._guardar_datos()
        
        if mostrar:
            self.ventana.mainloop()

def crear_funciones_ejemplo() -> List[FuncionAvanzada]:
    """Crea una lista de funciones de ejemplo más interesantes."""
    funciones = [
        FuncionAvanzada(
            lambda x, y: np.sin(2*x) * np.cos(3*y) + 0.5*np.sin(x*y),
            "sin(2*x) * cos(3*y) + 0.5*sin(x*y)",
            (-np.pi, np.pi),
            "Función Armónica Compuesta",
            "viridis"
        ),
        FuncionAvanzada(
            lambda x, y: np.exp(-((x-np.pi/2)**2 + (y-np.pi/2)**2)/4),
            "exp(-((x-pi/2)**2 + (y-pi/2)**2)/4)",
            (-np.pi, np.pi),
            "Gaussiana Centralizada",
            "magma"
        ),
        FuncionAvanzada(
            lambda x, y: np.sqrt(x**2 + y**2) * np.exp(-0.1*(x**2 + y**2)),
            "sqrt(x^2 + y^2) * exp(-0.1*(x^2 + y^2))",
            (-np.pi, np.pi),
            "Función Radial",
            "plasma"
        )
    ]
    return funciones

def Uso_Avansado():
    """Ejemplo de uso del generador de mosaicos avanzado."""
    try:
        # Crear funciones de ejemplo
        funciones = crear_funciones_ejemplo()
        
        # Crear el generador con una resolución más alta
        generador = GeneradorMosaicoAvanzado(
            ancho=10,
            alto=10,
            num_divisiones=50,
            funciones=funciones
        )
        
        # Generar y mostrar la visualización
        generador.generar_visualizacion_completa(
            titulo="Análisis Avanzado de Mosaico Matemático",
            mostrar=True,
            guardar=True
        )
        
    except Exception as e:
        logger.error(f"Error en la ejecución del ejemplo: {e}")
        raise

if __name__ == "__main__":
    Uso_Avansado()