import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np

def crear_piscina(x_largo, y_ancho, z_profundidad):
    fig = plt.figure()
    ax = fig.add_subplot(111, projection='3d')

    # Coordenadas de los vértices de la piscina
    vertices = np.array([
        [0, 0, 0],
        [x_largo, 0, 0],
        [x_largo, y_ancho, 0],
        [0, y_ancho, 0],
        [0, 0, -z_profundidad],
        [x_largo, 0, -z_profundidad],
        [x_largo, y_ancho, -z_profundidad],
        [0, y_ancho, -z_profundidad]
    ])

    # Caras de la piscina
    caras = [
        [vertices[0], vertices[1], vertices[2], vertices[3]],
        [vertices[4], vertices[5], vertices[6], vertices[7]],
        [vertices[0], vertices[1], vertices[5], vertices[4]],
        [vertices[1], vertices[2], vertices[6], vertices[5]],
        [vertices[2], vertices[3], vertices[7], vertices[6]],
        [vertices[3], vertices[0], vertices[4], vertices[7]]
    ]

    # Dibujar caras
    for cara in caras:
        x = [v[0] for v in cara]
        y = [v[1] for v in cara]
        z = [v[2] for v in cara]
        ax.plot_surface(np.array([x]), np.array([y]), np.array([z]), color='blue', alpha=0.6)

    # Configuración de ejes
    ax.set_xlabel('Largo (m)')
    ax.set_ylabel('Ancho (m)')
    ax.set_zlabel('Profundidad (m)')
    ax.set_title('Representación en 3D de la piscina')
    
    plt.show()

# Solicitar dimensiones de la piscina al usuario
largo = float(input("Ingresa el largo de la piscina (metros): "))
ancho = float(input("Ingresa el ancho de la piscina (metros): "))
profundidad = float(input("Ingresa la profundidad de la piscina (metros): "))

# Crear la piscina
crear_piscina(largo, ancho, profundidad)