import math

class SimbolosMuebles:
    @staticmethod
    def rotar_punto(x, y, cx, cy, angulo):
        """Rota un punto (x,y) alrededor del centro (cx,cy) por un ángulo dado en grados"""
        angulo_rad = math.radians(angulo)
        cos_a = math.cos(angulo_rad)
        sin_a = math.sin(angulo_rad)
        
        nx = cos_a * (x - cx) - sin_a * (y - cy) + cx
        ny = sin_a * (x - cx) + cos_a * (y - cy) + cy
        return nx, ny

    @staticmethod
    def obtener_simbolo(nombre_mueble, x, y, ancho, alto, rotacion=0):
        # Definir el centro para la rotación
        cx = x + ancho/2
        cy = y + alto/2
        
        simbolos = {
            "cama_sencilla": [
                # Marco de la cama
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # Cabecera
                ('M', x, y + alto * 0.1),
                ('L', x + ancho * 0.2, y + alto * 0.1),
                ('L', x + ancho * 0.2, y + alto * 0.9),
                ('L', x, y + alto * 0.9),
                # Líneas del colchón
                ('M', x + ancho * 0.2, y + alto * 0.3),
                ('L', x + ancho, y + alto * 0.3),
                ('M', x + ancho * 0.2, y + alto * 0.7),
                ('L', x + ancho, y + alto * 0.7),
            ],
            "cama_doble": [
                # Marco de la cama
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # Cabecera
                ('M', x, y + alto * 0.1),
                ('L', x + ancho * 0.2, y + alto * 0.1),
                ('L', x + ancho * 0.2, y + alto * 0.9),
                ('L', x, y + alto * 0.9),
                # Líneas del colchón
                ('M', x + ancho * 0.2, y + alto * 0.25),
                ('L', x + ancho, y + alto * 0.25),
                ('M', x + ancho * 0.2, y + alto * 0.75),
                ('L', x + ancho, y + alto * 0.75),
            ],
            "lavamanos": [
                # Contorno del lavamanos
                ('M', x + ancho * 0.1, y + alto * 0.3),
                ('A', ancho * 0.4, alto * 0.3, 0, 0, 1, x + ancho * 0.9, y + alto * 0.3),
                ('L', x + ancho * 0.9, y + alto),
                ('L', x + ancho * 0.1, y + alto),
                ('Z',),
                # Grifo
                ('M', x + ancho * 0.45, y + alto * 0.2),
                ('L', x + ancho * 0.55, y + alto * 0.2),
            ],
            "sanitario": [
                # Taza
                ('M', x + ancho * 0.2, y + alto * 0.4),
                ('A', ancho * 0.3, alto * 0.3, 0, 0, 1, x + ancho * 0.8, y + alto * 0.4),
                ('L', x + ancho * 0.8, y + alto),
                ('L', x + ancho * 0.2, y + alto),
                ('Z',),
                # Tanque
                ('M', x + ancho * 0.3, y),
                ('L', x + ancho * 0.7, y),
                ('L', x + ancho * 0.7, y + alto * 0.4),
                ('L', x + ancho * 0.3, y + alto * 0.4),
                ('Z',),
            ],
            "ducha": [
                # Marco de la ducha
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # Regadera
                ('M', x + ancho * 0.4, y + alto * 0.1),
                ('L', x + ancho * 0.6, y + alto * 0.1),
                # Desagüe
                ('M', x + ancho * 0.45, y + alto * 0.9),
                ('L', x + ancho * 0.55, y + alto * 0.9),
            ],
            "lavadora": [
                # Marco
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # Tambor
                ('M', x + ancho * 0.5, y + alto * 0.5),
                ('A', ancho * 0.3, alto * 0.3, 0, 0, 0, x + ancho * 0.5, y + alto * 0.5),
                # Panel de control
                ('M', x + ancho * 0.1, y + alto * 0.2),
                ('L', x + ancho * 0.9, y + alto * 0.2),
            ],
            "estufa": [
                # Marco
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # Hornillas
                ('M', x + ancho * 0.25, y + alto * 0.25),
                ('A', ancho * 0.1, alto * 0.1, 0, 0, 0, x + ancho * 0.25, y + alto * 0.25),
                ('M', x + ancho * 0.75, y + alto * 0.25),
                ('A', ancho * 0.1, alto * 0.1, 0, 0, 0, x + ancho * 0.75, y + alto * 0.25),
                ('M', x + ancho * 0.25, y + alto * 0.75),
                ('A', ancho * 0.1, alto * 0.1, 0, 0, 0, x + ancho * 0.25, y + alto * 0.75),
                ('M', x + ancho * 0.75, y + alto * 0.75),
                ('A', ancho * 0.1, alto * 0.1, 0, 0, 0, x + ancho * 0.75, y + alto * 0.75),
            ],
            "nevera": [
                # Marco principal
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # División de compartimentos
                ('M', x, y + alto * 0.6),
                ('L', x + ancho, y + alto * 0.6),
                # Manijas
                ('M', x + ancho * 0.9, y + alto * 0.3),
                ('L', x + ancho * 0.9, y + alto * 0.4),
                ('M', x + ancho * 0.9, y + alto * 0.7),
                ('L', x + ancho * 0.9, y + alto * 0.8),
            ],
            "mesa_comedor": [
                # Superficie
                ('M', x, y + alto * 0.3),
                ('L', x + ancho, y + alto * 0.3),
                ('L', x + ancho, y + alto * 0.4),
                ('L', x, y + alto * 0.4),
                ('Z',),
                # Patas
                ('M', x + ancho * 0.1, y + alto * 0.4),
                ('L', x + ancho * 0.2, y + alto),
                ('M', x + ancho * 0.9, y + alto * 0.4),
                ('L', x + ancho * 0.8, y + alto),
            ],
            "sofa": [
                # Asiento
                ('M', x, y + alto * 0.4),
                ('L', x + ancho, y + alto * 0.4),
                ('L', x + ancho, y + alto),
                ('L', x, y + alto),
                ('Z',),
                # Respaldo
                ('M', x, y),
                ('L', x + ancho, y),
                ('L', x + ancho, y + alto * 0.4),
                ('M', x, y),
                ('L', x, y + alto * 0.4),
                # Brazos
                ('M', x, y + alto * 0.2),
                ('L', x + ancho * 0.1, y + alto * 0.4),
                ('M', x + ancho, y + alto * 0.2),
                ('L', x + ancho * 0.9, y + alto * 0.4),
            ],
        }
        pass