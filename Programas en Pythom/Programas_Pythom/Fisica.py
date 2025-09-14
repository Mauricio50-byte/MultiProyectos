import os
import matplotlib.pyplot as plt

# Función para limpiar la pantalla
def limpiar_pantalla():
    os.system('cls' if os.name == 'nt' else 'clear')

# Pedimos la cantidad de mediciones
while True:
    try:
        n = int(input("Ingrese la cantidad de mediciones: "))
        if n <= 0:
            print("Ingrese un número mayor que cero.")
        else:
            break
    except ValueError:
        print("Por favor, ingrese un número entero válido.")

# Listas para almacenar los datos de tiempo y distancia
tiempo = []
distancia = []

# Pedir los datos de cada medición
for i in range(n):
    while True:
        try:
            distancia_i = float(input("Ingrese la distancia (en metros) para la medición {}: ".format(i + 1)))
            tiempo_i = float(input("Ingrese el tiempo (en segundos) para la medición {}: ".format(i + 1)))
            if tiempo_i == 0:
                print("El tiempo no puede ser cero.")
            else:
                distancia.append(distancia_i)
                tiempo.append(tiempo_i)
                print("###############################################################")
                break
        except ValueError:
            print("Por favor, ingrese un número válido.")

# Llamamos la función para limpiar la pantalla
limpiar_pantalla()

# Diagrama de dispersión
print("\n   Diagrama de dispersión")
print("-------------------------")
print("Tiempo (s)\tDistancia (m)")
for i in range(n):
    print("{:.2f}\t\t{:.2f}".format(tiempo[i], distancia[i]))
print("-------------------------")

# Calculamos las constantes C y B usando el método de minimos cuadrados
suma_tiempo = sum(tiempo)
suma_distancia = sum(distancia)
suma_tiempo_cuadrado = sum(t**2 for t in tiempo)
suma_tiempo_distancia = sum(tiempo[i] * distancia[i] for i in range(n))

# Evitamos la division por cero
if n * suma_tiempo_cuadrado - suma_tiempo**2 != 0:
    # Calculamos las constantes C y B usando el método de minimos cuadrados
    C = (n * suma_tiempo_distancia - suma_tiempo * suma_distancia) / (n * suma_tiempo_cuadrado - suma_tiempo**2)
    B = (suma_distancia - C * suma_tiempo) / n
else:
    print("Error: División por cero en el cálculo de la pendiente.")

# Imprimimos la ecuacion de la recta si no hay error de division por cero
if 'C' in locals() and 'B' in locals():
    print("C * Tiempo + B")
    print("La relación entre distancia y tiempo es: Distancia = {:.2f} * Tiempo + {:.2f}".format(C, B))
    #Calculamos la operacion ( C * Tiempo + B )
    resultado = C * tiempo[0] + B # 0 hace referencia al indice del tiempo a calcular, en este caso es el primero
    print("El resultado para el primer tiempo es {:.2f}".format(resultado))

    # Calculamos la velocidad inicial (Vi) para cada medicion
    velocidad_inicial = [(distancia[i] - B) / (C * tiempo[i]) for i in range(n)]

    # Imprimimos las velocidades iniciales para cada medicion
    print("Velocidades iniciales (Vi) para cada medición:")
    for i in range(n):
        print("Medición {}: {:.2f}".format(i + 1, velocidad_inicial[i]))

    # Calculamos el promedio de las velocidades iniciales obtenidas
    promedio_vi = sum(velocidad_inicial) / n

    # Imprimimos el promedio de las velocidades iniciales
    print("El promedio de las velocidades iniciales (Vi) es: {:.2f}".format(promedio_vi))
    
    # Calculamos los valores predichos de distancia
    distancia_predicha = [C * t + B for t in tiempo]

    # Grafico de dispersion de distancia en funcion del tiempo con lineas
    plt.plot(tiempo, distancia, marker='o', linestyle='-', label='Datos Originales')
    plt.plot(tiempo, distancia_predicha, linestyle='--', label='Recta de Minimos Cuadrados')

    # Etiquetas y titulo
    plt.xlabel('Tiempo (s)')
    plt.ylabel('Distancia (m)')
    plt.title('Distancia vs Tiempo')
    plt.legend()

    # Mostrar grafico
    plt.grid(True)
    plt.show()