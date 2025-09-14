import tkinter as tk
from tkinter import messagebox, ttk
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
from PIL import Image, ImageTk

class Usuario:
    def __init__(self, nombre_usuario, contraseña):
        self.nombre_usuario = nombre_usuario
        self.contraseña = contraseña

class PiscinaApp:
    def __init__(self, root):
        self.root = root
        self.entry_usuario = None
        self.entry_contraseña = None
        self.entry_largo = None
        self.entry_ancho = None
        self.entry_profundo = None
        self.combobox_forma = None
        self.combobox_dispositivo = None
        self.imagen_piscina_3D = None  

        self.root.title("Inicio de sesión en la Piscina")
        self.root.geometry("800x600")

        self.piscina_image = Image.open("C:/Users/ASUS/Downloads/ninos-alegres-regocijandose-saltando-nadando-piscina.jpg")
        self.piscina_image = self.piscina_image.resize((800, 600), resample=Image.BILINEAR)
        self.piscina_image = ImageTk.PhotoImage(self.piscina_image)
        self.label_imagen = tk.Label(root, image=self.piscina_image)
        self.label_imagen.place(x=0, y=0, relwidth=1, relheight=1)

        self.label_usuario = tk.Label(root, text="Nombre de usuario:", bg="white")
        self.label_usuario.place(relx=0.5, rely=0.4, anchor=tk.CENTER)
        self.entry_usuario = tk.Entry(root)
        self.entry_usuario.place(relx=0.5, rely=0.45, anchor=tk.CENTER)

        self.label_contraseña = tk.Label(root, text="Contraseña:", bg="white")
        self.label_contraseña.place(relx=0.5, rely=0.5, anchor=tk.CENTER)
        self.entry_contraseña = tk.Entry(root, show="*")
        self.entry_contraseña.place(relx=0.5, rely=0.55, anchor=tk.CENTER)

        self.boton_login = tk.Button(root, text="Iniciar sesión", command=self.login)
        self.boton_login.place(relx=0.5, rely=0.6, anchor=tk.CENTER)

        self.boton_registro = tk.Button(root, text="Registrarse", command=self.registrarse)
        self.boton_registro.place(relx=0.5, rely=0.65, anchor=tk.CENTER)

        self.label_resultado = tk.Label(root, text="", bg="white")
        self.label_resultado.place(relx=0.5, rely=0.7, anchor=tk.CENTER)

        self.usuarios = [Usuario("usuario1", "contraseña1"), Usuario("usuario2", "contraseña2")]

    def login(self):
        nombre_usuario = self.entry_usuario.get()
        contraseña = self.entry_contraseña.get()

        for usuario in self.usuarios:
            if usuario.nombre_usuario == nombre_usuario and usuario.contraseña == contraseña:
                self.label_resultado.config(text="Inicio de sesión exitoso. ¡Bienvenido a la piscina!", fg="green")
                self.abrir_ventana_piscina_3D()
                return
        
        self.label_resultado.config(text="Nombre de usuario o contraseña incorrectos.", fg="red")

    def registrarse(self):
        pass

    def abrir_ventana_piscina_3D(self):
        ventana_piscina_3D = tk.Toplevel(self.root)
        ventana_piscina_3D.title("Piscina 3D")
        ventana_piscina_3D.geometry("400x400")

        imagen_piscina_3D = Image.open("C:/Users/ASUS/Downloads/ninos-alegres-regocijandose-saltando-nadando-piscina.jpg")
        imagen_piscina_3D = imagen_piscina_3D.resize((400, 300), resample=Image.BILINEAR)
        self.imagen_piscina_3D = ImageTk.PhotoImage(imagen_piscina_3D)
        label_imagen_piscina_3D = tk.Label(ventana_piscina_3D, image=self.imagen_piscina_3D)
        label_imagen_piscina_3D.pack()

        label_forma = tk.Label(ventana_piscina_3D, text="Forma de la piscina:")
        label_forma.place(relx=0.25, rely=0.1, anchor=tk.CENTER)
        self.combobox_forma = ttk.Combobox(ventana_piscina_3D, values=["Rectangular", "Ovalada", "Cuadrada"])
        self.combobox_forma.place(relx=0.75, rely=0.1, anchor=tk.CENTER)
        self.combobox_forma.current(0)

        label_largo = tk.Label(ventana_piscina_3D, text="Largo:")
        label_largo.place(relx=0.25, rely=0.25, anchor=tk.CENTER)
        self.entry_largo = tk.Entry(ventana_piscina_3D)
        self.entry_largo.place(relx=0.75, rely=0.25, anchor=tk.CENTER)

        label_ancho = tk.Label(ventana_piscina_3D, text="Ancho:")
        label_ancho.place(relx=0.25, rely=0.4, anchor=tk.CENTER)
        self.entry_ancho = tk.Entry(ventana_piscina_3D)
        self.entry_ancho.place(relx=0.75, rely=0.4, anchor=tk.CENTER)

        label_profundo = tk.Label(ventana_piscina_3D, text="Profundidad:")
        label_profundo.place(relx=0.25, rely=0.55, anchor=tk.CENTER)
        self.entry_profundo = tk.Entry(ventana_piscina_3D)
        self.entry_profundo.place(relx=0.75, rely=0.55, anchor=tk.CENTER)

        label_dispositivo = tk.Label(ventana_piscina_3D, text="Dispositivo de llenado:")
        label_dispositivo.place(relx=0.25, rely=0.7, anchor=tk.CENTER)
        self.combobox_dispositivo = ttk.Combobox(ventana_piscina_3D, values=["Manguera", "Motorbomba", "Llenado automático", "Rociador", "Llenado rápido", "Llenado ultra rápido"])
        self.combobox_dispositivo.place(relx=0.75, rely=0.7, anchor=tk.CENTER)
        self.combobox_dispositivo.current(0)

        boton_crear_piscina_3D = tk.Button(ventana_piscina_3D, text="Crear Piscina 3D", command=self.crear_piscina_3D)
        boton_crear_piscina_3D.place(relx=0.5, rely=0.85, anchor=tk.CENTER)  
    
    def crear_piscina_3D(self):
        def crear_piscina_rectangular(x_largo, y_ancho, z_profundidad):
            fig = plt.figure()
            ax = fig.add_subplot(111, projection='3d')

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

            caras = [
                [vertices[0], vertices[1], vertices[2], vertices[3]],
                [vertices[4], vertices[5], vertices[6], vertices[7]],
                [vertices[0], vertices[1], vertices[5], vertices[4]],
                [vertices[1], vertices[2], vertices[6], vertices[5]],
                [vertices[2], vertices[3], vertices[7], vertices[6]],
                [vertices[3], vertices[0], vertices[4], vertices[7]]
            ]

            for cara in caras:
                x = [v[0] for v in cara]
                y = [v[1] for v in cara]
                z = [v[2] for v in cara]
                ax.plot_surface(np.array([x]), np.array([y]), np.array([z]), color='blue', alpha=0.6)

            ax.set_xlabel('Largo (m)')
            ax.set_ylabel('Ancho (m)')
            ax.set_zlabel('Profundidad (m)')
            ax.set_title('Representación en 3D de la piscina rectangular')

            return fig
        
        def crear_piscina_ovalada(x_largo, y_ancho, z_profundidad):
            fig = plt.figure()
            ax = fig.add_subplot(111, projection='3d')

            u = np.linspace(0, 2 * np.pi, 100)
            v = np.linspace(0, np.pi, 100)
            x = (x_largo / 2) * np.outer(np.cos(u), np.sin(v))
            y = (y_ancho / 2) * np.outer(np.sin(u), np.sin(v))
            z = -z_profundidad * np.outer(np.ones(np.size(u)), np.cos(v))

            ax.plot_surface(x, y, z, color='blue', alpha=0.6)

            ax.set_xlabel('Largo (m)')
            ax.set_ylabel('Ancho (m)')
            ax.set_zlabel('Profundidad (m)')
            ax.set_title('Representación en 3D de la piscina ovalada')

            return fig
        
        def crear_piscina_cuadrada(lado, profundidad):
            fig = plt.figure()
            ax = fig.add_subplot(111, projection='3d')

            vertices = np.array([
                [0, 0, 0],
                [lado, 0, 0],
                [lado, lado, 0],
                [0, lado, 0],
                [0, 0, -profundidad],
                [lado, 0, -profundidad],
                [lado, lado, -profundidad],
                [0, lado, -profundidad]
            ])

            caras = [
                [vertices[0], vertices[1], vertices[2], vertices[3]],
                [vertices[4], vertices[5], vertices[6], vertices[7]],
                [vertices[0], vertices[1], vertices[5], vertices[4]],
                [vertices[1], vertices[2], vertices[6], vertices[5]],
                [vertices[2], vertices[3], vertices[7], vertices[6]],
                [vertices[3], vertices[0], vertices[4], vertices[7]]
            ]

            for cara in caras:
                x = [v[0] for v in cara]
                y = [v[1] for v in cara]
                z = [v[2] for v in cara]
                ax.plot_surface(np.array([x]), np.array([y]), np.array([z]), color='blue', alpha=0.6)

            ax.set_xlabel('Lado (m)')
            ax.set_ylabel('Lado (m)')
            ax.set_zlabel('Profundidad (m)')
            ax.set_title('Representación en 3D de la piscina cuadrada')

            return fig

        forma_piscina = self.combobox_forma.get()
        largo = float(self.entry_largo.get())
        ancho = float(self.entry_ancho.get())
        profundo = float(self.entry_profundo.get())

        if forma_piscina == "Rectangular":
            fig = crear_piscina_rectangular(largo, ancho, profundo)
        elif forma_piscina == "Ovalada":
            fig = crear_piscina_ovalada(largo, ancho, profundo)
        elif forma_piscina == "Cuadrada":
            fig = crear_piscina_cuadrada(largo, profundo)

        # Calcular tiempo de llenado según el dispositivo de llenado seleccionado
        dispositivo = self.combobox_dispositivo.get()
        if dispositivo == "Manguera":
            tasa_flujo = 500  # Litros por hora (Ejemplo)
        elif dispositivo == "Motorbomba":
            tasa_flujo = 1500  # Litros por hora (Ejemplo)
        elif dispositivo == "Llenado automático":
            tasa_flujo = 1000  # Litros por hora (Ejemplo)
        elif dispositivo == "Rociador":
            tasa_flujo = 700  # Litros por hora (Ejemplo)
        elif dispositivo == "Llenado rápido":
            tasa_flujo = 2000  # Litros por hora (Ejemplo)
        elif dispositivo == "Llenado ultra rápido":
            tasa_flujo = 3000  # Litros por hora (Ejemplo)
        
        volumen = largo * ancho * profundo * 1000  # Volumen en litros
        tiempo_llenado_horas = volumen / tasa_flujo
        tiempo_llenado_minutos = tiempo_llenado_horas * 60

        messagebox.showinfo("Tiempo de Llenado", f"Tiempo de llenado estimado: {tiempo_llenado_minutos:.2f} minutos")

        plt.show()

root = tk.Tk()
app = PiscinaApp(root)
root.mainloop()