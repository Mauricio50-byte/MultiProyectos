import tkinter as tk
from tkinter import ttk
from PIL import Image, ImageTk
from SimbolosMuebles import SimbolosMuebles
from AreaHabitacion import AreaHabitacion
from MuebleData import MuebleData

class PlanificadorMuebles:
    def __init__(self, raiz):
        # Inicializamos la ventana principal
        self.raiz = raiz
        self.raiz.title("Planificador de Muebles")
        
        # Establecemos dimensiones reales del plano en metros
        self.ANCHO_PLANO = 14.00  
        self.ALTO_PLANO = 8.00  
        
        # Definimos factor de escala para convertir metros a pixeles
        self.FACTOR_ESCALA = 50  
        
        # Inicializamos variables de estado
        self.mueble_seleccionado = None
        self.rotacion_actual = 0
        self.muebles_colocados = []
        self.arrastrando = None
        self.inicio_arrastre = None
        
        # Configuramos los componentes de la interfaz
        self.configurar_ventana_principal()
        self.cargar_datos_muebles()
        self.definir_areas_habitacion()
        self.configurar_barra_herramientas()
        self.configurar_lienzo()
        self.configurar_panel_info()
        self.configurar_eventos()
        self.cargar_plano()
        pass

    def configurar_ventana_principal(self):
        # Obtenemos dimensiones de la pantalla
        ancho_pantalla = self.raiz.winfo_screenwidth()
        alto_pantalla = self.raiz.winfo_screenheight()
        
        # Calculamos dimensiones de la ventana
        ancho_ventana = int(min(ancho_pantalla * 0.9, self.ANCHO_PLANO * self.FACTOR_ESCALA + 400))
        alto_ventana = int(min(alto_pantalla * 0.9, self.ALTO_PLANO * self.FACTOR_ESCALA + 100))
        
        # Configuramos geometria de la ventana
        self.raiz.geometry(f"{ancho_ventana}x{alto_ventana}")
        self.raiz.resizable(True, True)
        
        # Creamos marco principal
        self.marco_principal = ttk.Frame(self.raiz)
        self.marco_principal.pack(fill=tk.BOTH, expand=True)
        pass

    def cargar_datos_muebles(self):
        # Definimos datos de los muebles disponibles
        self.datos_muebles = {
            "cama_sencilla": {
                "dimensiones": (1.90, 0.90),
                "areas_permitidas": ["area privada"],
                "espacio_minimo": 0.50,
                "categoria": "dormitorio"
            },
            "cama_doble": {
                "dimensiones": (2.00, 1.40),
                "areas_permitidas": ["area privada"],
                "espacio_minimo": 0.50,
                "categoria": "dormitorio"
            },
            "lavamanos": {
                "dimensiones": (0.50, 0.40),
                "areas_permitidas": ["area humeda"],
                "espacio_minimo": 0.30,
                "categoria": "bano"
            },
            "sanitario": {
                "dimensiones": (0.70, 0.50),
                "areas_permitidas": ["area humeda"],
                "espacio_minimo": 0.30,
                "categoria": "bano"
            },
            "ducha": {
                "dimensiones": (0.90, 0.90),
                "areas_permitidas": ["area humeda"],
                "espacio_minimo": 0.30,
                "categoria": "bano"
            },
            "lavadora": {
                "dimensiones": (0.60, 0.60),
                "areas_permitidas": ["area humeda"],
                "espacio_minimo": 0.30,
                "categoria": "lavanderia"
            },
            "estufa": {
                "dimensiones": (0.60, 0.60),
                "areas_permitidas": ["area humeda"],
                "espacio_minimo": 0.30,
                "categoria": "cocina"
            },
            "nevera": {
                "dimensiones": (0.70, 0.70),
                "areas_permitidas": ["area humeda"],
                "espacio_minimo": 0.30,
                "categoria": "cocina"
            },
            "mesa_comedor": {
                "dimensiones": (1.60, 0.90),
                "areas_permitidas": ["area comun"],
                "espacio_minimo": 0.60,
                "categoria": "comedor"
            },
            "sofa": {
                "dimensiones": (2.00, 0.90),
                "areas_permitidas": ["area comun"],
                "espacio_minimo": 0.50,
                "categoria": "sala"
            }
        }
        pass

    def definir_areas_habitacion(self):
        # Definimos las areas especificas del plano
        self.areas_habitacion = [
            # Areas privadas
            AreaHabitacion("ALCOBA 3", 0, 0, 3.12, 2.44, "area privada"),
            AreaHabitacion("ALCOBA 2", 4.46, 0, 7.12, 2.44, "area privada"),
            AreaHabitacion("ALCOBA PRINCIPAL", 9.32, 0, 11.88, 2.44, "area privada"),
            
            # Areas humedas
            AreaHabitacion("BANO1", 3.12, 0, 4.46, 2.44, "area humeda"),
            AreaHabitacion("BANO2", 11.88, 0, 14.00, 2.44, "area humeda"),
            AreaHabitacion("COCINA", 7.12, 4, 9.32, 8, "area humeda"),
            AreaHabitacion("CUARTO DE ROPAS", 11.88, 4, 14.00, 8, "area humeda"),
            
            # Areas comunes
            AreaHabitacion("SALA", 0, 4, 4.46, 8, "area comun"),
            AreaHabitacion("COMEDOR", 4.46, 4, 7.12, 8, "area comun"),
            AreaHabitacion("HALL", 9.32, 2.44, 11.88, 4, "area comun")
        ]
        pass
    
    def configurar_barra_herramientas(self):
        # Creamos barra de herramientas
        self.barra_herramientas = ttk.Frame(self.marco_principal)
        self.barra_herramientas.pack(side=tk.LEFT, fill=tk.Y, padx=5, pady=5)
        
        # Creamos pestanas para categorias
        self.cuaderno = ttk.Notebook(self.barra_herramientas)
        self.cuaderno.pack(fill=tk.BOTH, expand=True)
        
        # Agrupamos muebles por categoria
        categorias = set(item["categoria"] for item in self.datos_muebles.values())
        
        # Creamos botones para cada categoria
        for categoria in categorias:
            marco = ttk.Frame(self.cuaderno)
            self.cuaderno.add(marco, text=categoria.capitalize())
            
            for nombre, datos in self.datos_muebles.items():
                if datos["categoria"] == categoria:
                    boton = ttk.Button(marco, text=nombre.replace("_", " ").title(),
                                command=lambda n=nombre: self.seleccionar_mueble(n))
                    boton.pack(fill=tk.X, padx=5, pady=2)
        
        # Creamos botones de rotacion
        marco_rotacion = ttk.Frame(self.barra_herramientas)
        marco_rotacion.pack(fill=tk.X, pady=5)
        
        ttk.Button(marco_rotacion, text="Rotar 90°",
                command=lambda: self.rotar_mueble(90)).pack(side=tk.LEFT, padx=2)
        ttk.Button(marco_rotacion, text="Rotar -90°",
                command=lambda: self.rotar_mueble(-90)).pack(side=tk.LEFT, padx=2)

    def configurar_lienzo(self):
        # Creamos marco para el lienzo
        marco_lienzo = ttk.Frame(self.marco_principal)
        marco_lienzo.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        
        # Creamos lienzo para dibujar
        self.lienzo = tk.Canvas(
            marco_lienzo,
            width=self.ANCHO_PLANO * self.FACTOR_ESCALA,
            height=self.ALTO_PLANO * self.FACTOR_ESCALA,
            bg="white"
        )
        self.lienzo.pack(fill=tk.BOTH, expand=True)

    def configurar_panel_info(self):
        # Creamos panel de informacion
        self.panel_info = ttk.Frame(self.marco_principal)
        self.panel_info.pack(side=tk.RIGHT, fill=tk.Y, padx=5, pady=5)
        
        # Creamos area de texto para informacion
        self.texto_info = tk.Text(self.panel_info, width=30, height=20)
        self.texto_info.pack(fill=tk.BOTH, expand=True)
        
        # Agregamos botones de accion
        ttk.Button(self.panel_info, text="Guardar Diseno",
                command=self.guardar_diseno).pack(fill=tk.X, pady=2)
        ttk.Button(self.panel_info, text="Cargar Diseno",
                command=self.cargar_diseno).pack(fill=tk.X, pady=2)
        ttk.Button(self.panel_info, text="Limpiar Todo",
                command=self.limpiar_diseno).pack(fill=tk.X, pady=2)

    def configurar_eventos(self):
        # Configuramos eventos del mouse
        self.lienzo.bind("<Button-1>", self.al_clic_lienzo)
        self.lienzo.bind("<B1-Motion>", self.al_arrastrar_lienzo)
        self.lienzo.bind("<ButtonRelease-1>", self.al_soltar_lienzo)
        self.lienzo.bind("<Button-3>", self.al_clic_derecho)

    def cargar_plano(self):
        # Cargamos y mostramos el plano arquitectonico
        try:
            # Cargamos imagen del plano
            self.imagen_plano = Image.open("C:/Users/ASUS/Pictures/Screenshots/plano.png")
            
            # Escalamos imagen al tamano del lienzo
            ancho_lienzo = int(self.ANCHO_PLANO * self.FACTOR_ESCALA)
            alto_lienzo = int(self.ALTO_PLANO * self.FACTOR_ESCALA)
            self.imagen_plano = self.imagen_plano.resize((ancho_lienzo, alto_lienzo))
            
            # Convertimos para tkinter
            self.foto_plano = ImageTk.PhotoImage(self.imagen_plano)
            
            # Mostramos en el lienzo
            self.lienzo.create_image(0, 0, image=self.foto_plano, anchor="nw")
            
            # Dibujamos areas
            self.dibujar_areas_habitacion()
        except FileNotFoundError:
            messagebox.showwarning("Error", "No se encontro el archivo planoimg")
            # Dibujamos solo areas si no hay plano
            self.dibujar_areas_habitacion()

    def dibujar_areas_habitacion(self):
        # Definimos colores para cada tipo de area
        colores = {
            "area privada": "#FFB6C1",  
            "area humeda": "#ADD8E6",   
            "area comun": "#98FB98"      
        }
        
        # Dibujamos cada area en el lienzo
        for area in self.areas_habitacion:
            x1 = area.x1 * self.FACTOR_ESCALA
            y1 = area.y1 * self.FACTOR_ESCALA
            x2 = area.x2 * self.FACTOR_ESCALA
            y2 = area.y2 * self.FACTOR_ESCALA
            
            # Creamos rectangulo para el area
            self.lienzo.create_rectangle(
                x1, y1, x2, y2,
                fill=colores[area.tipo_habitacion],
                stipple="gray50",
                tags=("habitacion", area.nombre)
            )
            
            # Agregamos etiqueta del area
            self.lienzo.create_text(
                (x1 + x2) / 2,
                (y1 + y2) / 2,
                text=area.nombre,
                font=("Arial", 8)
            )

    def seleccionar_mueble(self, nombre_mueble):
        # Seleccionamos mueble para colocar
        self.mueble_seleccionado = nombre_mueble
        self.rotacion_actual = 0
        self.actualizar_panel_info(f"Mueble seleccionado: {nombre_mueble}")

    def rotar_mueble(self, angulo):
        # Rotamos el mueble seleccionado
        if self.arrastrando:
            self.rotacion_actual = (self.rotacion_actual + angulo) % 360
            x1, y1, x2, y2 = self.lienzo.coords(self.arrastrando)
            ancho = x2 - x1
            alto = y2 - y1
            
            # Intercambiamos dimensiones si es necesario
            if angulo in [90, 270]:
                ancho, alto = alto, ancho
            
            # Calculamos centro y nuevas coordenadas
            centro_x = (x1 + x2) / 2
            centro_y = (y1 + y2) / 2
            
            self.lienzo.coords(self.arrastrando,
                            centro_x - ancho/2,
                            centro_y - alto/2,
                            centro_x + ancho/2,
                            centro_y + alto/2)


    def al_clic_lienzo(self, evento):
        # Manejamos el clic en el lienzo
        x = self.lienzo.canvasx(evento.x)
        y = self.lienzo.canvasy(evento.y)

        # Verificamos si se cliqueo un mueble existente
        elementos = self.lienzo.find_overlapping(x-2, y-2, x+2, y+2)
        for elemento in elementos:
            etiquetas = self.lienzo.gettags(elemento)
            if any(etiqueta in self.datos_muebles for etiqueta in etiquetas):
                self.arrastrando = elemento
                self.inicio_arrastre = (x, y)
                return

        # Colocamos un nuevo mueble si hay uno seleccionado
        if self.mueble_seleccionado:
            self.colocar_mueble(x, y)

    def al_arrastrar_lienzo(self, evento):
        # Manejamos el arrastre de muebles
        if self.arrastrando:
            x = self.lienzo.canvasx(evento.x)
            y = self.lienzo.canvasy(evento.y)
            
            dx = x - self.inicio_arrastre[0]
            dy = y - self.inicio_arrastre[1]
            
            self.lienzo.move(self.arrastrando, dx, dy)
            # Movemos la etiqueta asociada
            for elemento in self.lienzo.find_withtag(self.lienzo.gettags(self.arrastrando)[0]):
                if elemento != self.arrastrando:
                    self.lienzo.move(elemento, dx, dy)
            
            self.inicio_arrastre = (x, y)

    def al_soltar_lienzo(self, evento):
        # Manejamos la liberacion del mouse
        if self.arrastrando:
            # Verificamos si la nueva posicion es valida
            x = self.lienzo.canvasx(evento.x)
            y = self.lienzo.canvasy(evento.y)
            
            nombre_mueble = self.lienzo.gettags(self.arrastrando)[0]
            valido, mensaje = self.verificar_validez_ubicacion(x, y, nombre_mueble)
            
            if not valido:
                # Volvemos a la posicion original
                self.lienzo.coords(self.arrastrando, *self.obtener_coords_originales(self.arrastrando))
                messagebox.showwarning("Ubicacion Invalida", mensaje)
            
            self.arrastrando = None
            self.inicio_arrastre = None

    def al_clic_derecho(self, evento):
        # Manejamos el clic derecho para eliminar muebles
        x = self.lienzo.canvasx(evento.x)
        y = self.lienzo.canvasy(evento.y)
        
        elementos = self.lienzo.find_overlapping(x-2, y-2, x+2, y+2)
        for elemento in elementos:
            etiquetas = self.lienzo.gettags(elemento)
            if any(etiqueta in self.datos_muebles for etiqueta in etiquetas):
                self.lienzo.delete(etiquetas[0])
                self.muebles_colocados = [m for m in self.muebles_colocados if m["elemento"] != elemento]
                self.actualizar_panel_info(f"Mueble eliminado: {etiquetas[0]}")
                break

    def colocar_mueble(self, x, y):
        # Colocamos un mueble en el lienzo
        if not self.mueble_seleccionado:
            return
            
        valido, mensaje = self.verificar_validez_ubicacion(x, y, self.mueble_seleccionado)
        if not valido:
            messagebox.showwarning("Ubicacion Invalida", mensaje)
            return
            
        mueble = self.datos_muebles[self.mueble_seleccionado]
        ancho = self.metros_a_pixeles(mueble["dimensiones"][0])
        alto = self.metros_a_pixeles(mueble["dimensiones"][1])
        
        if self.rotacion_actual in [90, 270]:
            ancho, alto = alto, ancho
            
        # Creamos representacion visual del mueble
        elemento = self.lienzo.create_rectangle(
            x, y, x + ancho, y + alto,
            fill="blue",
            outline="black",
            tags=(self.mueble_seleccionado,)
        )
        
        # Agregamos etiqueta
        self.lienzo.create_text(
            x + ancho/2,
            y + alto/2,
            text=self.mueble_seleccionado,
            fill="white",
            tags=(self.mueble_seleccionado,)
        )
        
        self.muebles_colocados.append({
            "nombre": self.mueble_seleccionado,
            "elemento": elemento,
            "coords": (x, y, ancho, alto),
            "rotacion": self.rotacion_actual
        })
        
        self.actualizar_panel_info(f"Mueble colocado: {self.mueble_seleccionado}")

    def verificar_validez_ubicacion(self, x, y, nombre_mueble):
        # Verificamos si la ubicacion es valida para el mueble
        mueble = self.datos_muebles[nombre_mueble]
        
        # Convertimos coordenadas a metros
        x_metros = self.pixeles_a_metros(x)
        y_metros = self.pixeles_a_metros(y)
        
        # Encontramos en que area esta el punto
        area_actual = None
        for area in self.areas_habitacion:
            if (area.x1 <= x_metros <= area.x2 and 
                area.y1 <= y_metros <= area.y2):
                area_actual = area
                break
        
        if not area_actual:
            return False, "Fuera de las areas definidas"
            
        # Verificamos si el mueble esta permitido en esta area
        if area_actual.tipo_habitacion not in mueble["areas_permitidas"]:
            return False, f"Este mueble no esta permitido en {area_actual.nombre}"
        
        return True, "Ubicacion valida"

    def obtener_coords_originales(self, elemento):
        # Obtenemos las coordenadas originales de un mueble
        for mueble in self.muebles_colocados:
            if mueble["elemento"] == elemento:
                return mueble["coords"]
        return None

    def guardar_diseno(self):
        # Guardamos el diseno actual
        datos_diseno = []
        for mueble in self.muebles_colocados:
            x1, y1, _, _ = self.lienzo.coords(mueble["elemento"])
            datos_diseno.append({
                "nombre": mueble["nombre"],
                "posicion": (x1, y1),
                "rotacion": mueble["rotacion"]
            })
        
        try:
            with open("diseno.json", "w") as f:
                json.dump(datos_diseno, f)
            self.actualizar_panel_info("Diseno guardado exitosamente")
        except Exception as e:
            messagebox.showerror("Error", f"Error al guardar el diseno: {str(e)}")

    def cargar_diseno(self):
        # Cargamos un diseno guardado
        try:
            with open("diseno.json", "r") as f:
                datos_diseno = json.load(f)
            
            self.limpiar_diseno()
            
            for mueble in datos_diseno:
                self.mueble_seleccionado = mueble["nombre"]
                self.rotacion_actual = mueble["rotacion"]
                x, y = mueble["posicion"]
                self.colocar_mueble(x, y)
            
            self.actualizar_panel_info("Diseno cargado exitosamente")
        except FileNotFoundError:
            messagebox.showwarning("Error", "No hay diseno guardado")
        except Exception as e:
            messagebox.showerror("Error", f"Error al cargar el diseno: {str(e)}")

    def limpiar_diseno(self):
        # Limpiamos todo el diseno actual
        for mueble in self.muebles_colocados:
            self.lienzo.delete(mueble["nombre"])
        self.muebles_colocados = []
        self.actualizar_panel_info("Diseno limpiado")

    def actualizar_panel_info(self, mensaje):
        # Actualizamos el panel de informacion
        self.texto_info.insert(tk.END, mensaje + "\n")
        self.texto_info.see(tk.END)

    def metros_a_pixeles(self, metros):
        # Convertimos metros a pixeles
        return metros * self.FACTOR_ESCALA

    def pixeles_a_metros(self, pixeles):
        # Convertimos pixeles a metros
        return pixeles / self.FACTOR_ESCALA
