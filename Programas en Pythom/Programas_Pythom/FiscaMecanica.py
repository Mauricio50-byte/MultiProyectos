import os
import matplotlib.pyplot as plt

# Función para limpiar la pantalla
def limpiar_pantalla():
    os.system('cls' if os.name == 'nt' else 'clear')

# Pedimos la cantidad de mediciones
n = int(input("Ingrese la cantidad de mediciones: "))

# Listas para almacenar los datos de tiempo y distancia
tiempo = []
distancia = []

# Pedir los datos de cada medición
for i in range(n):
    distancia_i = float(input("Ingrese la distancia (en metros) para la medición {}: ".format(i + 1)))
    tiempo_i = float(input("Ingrese el tiempo (en segundos) para la medición {}: ".format(i + 1)))
    distancia.append(distancia_i)
    tiempo.append(tiempo_i)
    print("###############################################################")

# Llamamos la función para limpiar la pantalla
limpiar_pantalla()

# Diagrama de dispersión
print("\n   Diagrama de dispersión")
print("-------------------------")
print("Tiempo (s)\tDistancia (m)")
for i in range(n):
    print("{:.2f}\t\t{:.2f}".format(tiempo[i], distancia[i]))
print("-------------------------")

# Crear gráfico de barras
plt.bar(tiempo, distancia, color='blue')

# Etiquetas y título
plt.xlabel('Tiempo (s)')
plt.ylabel('Distancia (m)')
plt.title('Gráfico de Barras: Distancia vs Tiempo')

# Mostrar gráfico
plt.show()

# Calculamos la sumatoria de tiempo, distancia, tiempo^2 y tiempo*distancia
suma_tiempo = sum(tiempo)
suma_distancia = sum(distancia)
suma_tiempo_cuadrado = sum(t**2 for t in tiempo)
suma_tiempo_distancia = sum(tiempo[i] * distancia[i] for i in range(n))

# Calculamos las constantes C y B usando el método de mínimos cuadrados
C = (n * suma_tiempo_distancia - suma_tiempo * suma_distancia) / (n * suma_tiempo_cuadrado - suma_tiempo**2)
B = (suma_distancia - C * suma_tiempo) / n

# Calculamos el resultado de la operación ( C * Tiempo + B )
resultado = C * tiempo[0] + B  # El índice 0 en tiempo es el tiempo al que deseas calcular

# Imprimimos la ecuación de la recta
print("La relación entre distancia y tiempo es: Distancia = {:.2f} * Tiempo + {:.2f} = {:.2f}".format(C, B, resultado))

# Calculamos la velocidad inicial (Vi) para cada medición
velocidad_inicial = [(distancia[i] - B) / (C * tiempo[i]) for i in range(n)]

# Imprimimos las velocidades iniciales para cada medición
print("Velocidades iniciales (Vi) para cada medición:")
for i in range(n):
    print("Medición {}: {:.2f}".format(i + 1, velocidad_inicial[i]))

# Calculamos el promedio de las velocidades iniciales obtenidas
promedio_vi = sum(velocidad_inicial) / n

# Imprimimos el promedio de las velocidades iniciales
print("El promedio de las velocidades iniciales (Vi) es: {:.2f}".format(promedio_vi))