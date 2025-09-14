# Realizamos importacion de librerias necesarias
import tkinter as tk
from tkinter import ttk, messagebox
from PIL import Image, ImageTk
import json

# Creamos clase para definir areas de habitacion
class AreaHabitacion:
    def __init__(self, nombre, x1, y1, x2, y2, tipo_habitacion):
        self.nombre = nombre
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2
        self.tipo_habitacion = tipo_habitacion

# Creamos clase principal del planificador de muebles
class PlanificadorMuebles:
    def __init__(self, raiz):
        self.raiz = raiz
        self.raiz.title("Planificador de Muebles")
        
        # Dimensiones reales del plano en metros
        self.ANCHO_PLANO = 14.00  # Ancho total según el plano
        self.ALTO_PLANO = 8.00  # Alto total aproximado según el plano
        
        # Factor de escala para convertir metros a pixeles
        self.FACTOR_ESCALA = 50  # 50 pixeles por metro
        
        # Inicializamos variables de estado
        self.mueble_seleccionado = None
        self.rotacion_actual = 0
        self.muebles_colocados = []
        self.arrastrando = None
        self.inicio_arrastre = None
        # Variables de estado
        self.mueble_seleccionado = None
        self.current_rotation = 0
        self.placed_furniture = []
        self.dragging = None
        self.drag_start = None
        
        # Inicializar la interfaz
        self.setup_main_window()
        self.load_furniture_data()
        self.define_room_areas()
        self.setup_toolbar()
        self.setup_canvas()
        self.setup_info_panel()
        self.setup_bindings()
        self.load_floor_plan()

    def setup_main_window(self):
        """Configura la ventana principal"""
        screen_width = self.raiz.winfo_screenwidth()
        screen_height = self.raiz.winfo_screenheight()
        
        window_width = int(min(screen_width * 0.9, self.ANCHO_PLANO * self.FACTOR_ESCALA + 400))
        window_height = int(min(screen_height * 0.9, self.ALTO_PLANO * self.FACTOR_ESCALA + 100))
        
        self.raiz.geometry(f"{window_width}x{window_height}")
        self.raiz.resizable(True, True)
        
        self.main_frame = ttk.Frame(self.raiz)
        self.main_frame.pack(fill=tk.BOTH, expand=True)

    def load_furniture_data(self):
        """Carga la información de los muebles"""
        self.furniture_data = {
            "cama_sencilla": {
                "dimensions": (1.90, 0.90),
                "allowed_rooms": ["área privada"],
                "min_clearance": 0.50,
                "category": "dormitorio"
            },
            "cama_doble": {
                "dimensions": (2.00, 1.40),
                "allowed_rooms": ["área privada"],
                "min_clearance": 0.50,
                "category": "dormitorio"
            },
            "lavamanos": {
                "dimensions": (0.50, 0.40),
                "allowed_rooms": ["área húmeda"],
                "min_clearance": 0.30,
                "category": "baño"
            },
            "sanitario": {
                "dimensions": (0.70, 0.50),
                "allowed_rooms": ["área húmeda"],
                "min_clearance": 0.30,
                "category": "baño"
            },
            "ducha": {
                "dimensions": (0.90, 0.90),
                "allowed_rooms": ["área húmeda"],
                "min_clearance": 0.30,
                "category": "baño"
            },
            "lavadora": {
                "dimensions": (0.60, 0.60),
                "allowed_rooms": ["área húmeda"],
                "min_clearance": 0.30,
                "category": "lavandería"
            },
            "estufa": {
                "dimensions": (0.60, 0.60),
                "allowed_rooms": ["área húmeda"],
                "min_clearance": 0.30,
                "category": "cocina"
            },
            "nevera": {
                "dimensions": (0.70, 0.70),
                "allowed_rooms": ["área húmeda"],
                "min_clearance": 0.30,
                "category": "cocina"
            },
            "mesa_comedor": {
                "dimensions": (1.60, 0.90),
                "allowed_rooms": ["área común"],
                "min_clearance": 0.60,
                "category": "comedor"
            },
            "sofa": {
                "dimensions": (2.00, 0.90),
                "allowed_rooms": ["área común"],
                "min_clearance": 0.50,
                "category": "sala"
            }
        }

    def define_room_areas(self):
        """Define las áreas específicas del plano"""
        self.room_areas = [
            # Áreas privadas
            AreaHabitacion("ALCOBA 3", 0, 0, 3.12, 2.44, "área privada"),
            AreaHabitacion("ALCOBA 2", 4.46, 0, 7.12, 2.44, "área privada"),
            AreaHabitacion("ALCOBA PRINCIPAL", 9.32, 0, 11.88, 2.44, "área privada"),
            
            # Áreas húmedas
            AreaHabitacion("BAÑO1", 3.12, 0, 4.46, 2.44, "área húmeda"),
            AreaHabitacion("BAÑO2", 11.88, 0, 14.00, 2.44, "área húmeda"),
            AreaHabitacion("COCINA", 7.12, 4, 9.32, 8, "área húmeda"),
            AreaHabitacion("CUARTO DE ROPAS", 11.88, 4, 14.00, 8, "área húmeda"),
            
            # Áreas comunes
            AreaHabitacion("SALA", 0, 4, 4.46, 8, "área común"),
            AreaHabitacion("COMEDOR", 4.46, 4, 7.12, 8, "área común"),
            AreaHabitacion("HALL", 9.32, 2.44, 11.88, 4, "área común")
        ]

    def setup_toolbar(self):
        """Configura la barra de herramientas"""
        self.toolbar = ttk.Frame(self.main_frame)
        self.toolbar.pack(side=tk.LEFT, fill=tk.Y, padx=5, pady=5)
        
        # Crear pestañas para categorías
        self.notebook = ttk.Notebook(self.toolbar)
        self.notebook.pack(fill=tk.BOTH, expand=True)
        
        # Agrupar muebles por categoría
        categories = set(item["category"] for item in self.furniture_data.values())
        
        for category in categories:
            frame = ttk.Frame(self.notebook)
            self.notebook.add(frame, text=category.capitalize())
            
            for nombre, data in self.furniture_data.items():
                if data["category"] == category:
                    btn = ttk.Button(frame, text=nombre.replace("_", " ").title(),
                                   command=lambda n=nombre: self.select_furniture(n))
                    btn.pack(fill=tk.X, padx=5, pady=2)
        
        # Botones de rotación
        rotation_frame = ttk.Frame(self.toolbar)
        rotation_frame.pack(fill=tk.X, pady=5)
        
        ttk.Button(rotation_frame, text="Rotar 90°",
                  command=lambda: self.rotate_furniture(90)).pack(side=tk.LEFT, padx=2)
        ttk.Button(rotation_frame, text="Rotar -90°",
                  command=lambda: self.rotate_furniture(-90)).pack(side=tk.LEFT, padx=2)

    def setup_canvas(self):
        """Configura el área de dibujo"""
        canvas_frame = ttk.Frame(self.main_frame)
        canvas_frame.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        
        self.canvas = tk.Canvas(
            canvas_frame,
            width=self.ANCHO_PLANO * self.FACTOR_ESCALA,
            height=self.ALTO_PLANO * self.FACTOR_ESCALA,
            bg="white"
        )
        self.canvas.pack(fill=tk.BOTH, expand=True)

    def setup_info_panel(self):
        """Configura el panel de información"""
        self.info_panel = ttk.Frame(self.main_frame)
        self.info_panel.pack(side=tk.RIGHT, fill=tk.Y, padx=5, pady=5)
        
        self.info_text = tk.Text(self.info_panel, width=30, height=20)
        self.info_text.pack(fill=tk.BOTH, expand=True)
        
        # Botones de acción
        ttk.Button(self.info_panel, text="Guardar Diseño",
                  command=self.save_design).pack(fill=tk.X, pady=2)
        ttk.Button(self.info_panel, text="Cargar Diseño",
                  command=self.load_design).pack(fill=tk.X, pady=2)
        ttk.Button(self.info_panel, text="Limpiar Todo",
                  command=self.clear_design).pack(fill=tk.X, pady=2)

    def setup_bindings(self):
        """Configura los eventos del mouse"""
        self.canvas.bind("<Button-1>", self.on_canvas_click)
        self.canvas.bind("<B1-Motion>", self.on_canvas_drag)
        self.canvas.bind("<ButtonRelease-1>", self.on_canvas_release)
        self.canvas.bind("<Button-3>", self.on_right_click)

    def load_floor_plan(self):
        """Carga y muestra el plano arquitectónico"""
        try:
            # Cargar la imagen del plano
            self.floor_plan_image = Image.open("C:/Users/ASUS/Pictures/Screenshots/plano.png")
            
            # Escalar la imagen al tamaño del canvas
            canvas_width = int(self.ANCHO_PLANO * self.FACTOR_ESCALA)
            canvas_height = int(self.ALTO_PLANO * self.FACTOR_ESCALA)
            self.floor_plan_image = self.floor_plan_image.resize((canvas_width, canvas_height))
            
            # Convertir para tkinter
            self.floor_plan_photo = ImageTk.PhotoImage(self.floor_plan_image)
            
            # Mostrar en el canvas
            self.canvas.create_image(0, 0, image=self.floor_plan_photo, anchor="nw")
            
            # Dibujar las áreas con colores semi-transparentes
            self.draw_room_areas()
        except FileNotFoundError:
            messagebox.showwarning("Error", "No se encontró el archivo plano.png")
            # Dibujar solo las áreas si no hay plano
            self.draw_room_areas()

    def draw_room_areas(self):
        """Dibuja las áreas del plano con colores distintos según su tipo"""
        colors = {
            "área privada": "#FFB6C1",  # Rosa claro
            "área húmeda": "#ADD8E6",   # Azul claro
            "área común": "#98FB98"      # Verde claro
        }
        
        for area in self.room_areas:
            x1 = area.x1 * self.FACTOR_ESCALA
            y1 = area.y1 * self.FACTOR_ESCALA
            x2 = area.x2 * self.FACTOR_ESCALA
            y2 = area.y2 * self.FACTOR_ESCALA
            
            self.canvas.create_rectangle(
                x1, y1, x2, y2,
                fill=colors[area.tipo_habitacion],
                stipple="gray50",
                tags=("room", area.nombre)
            )
            
            # Agregar etiqueta
            self.canvas.create_text(
                (x1 + x2) / 2,
                (y1 + y2) / 2,
                text=area.nombre,
                font=("Arial", 8)
            )

    def select_furniture(self, furniture_name):
        """Selecciona un mueble para colocar"""
        self.mueble_seleccionado = furniture_name
        self.current_rotation = 0
        self.update_info_panel(f"Mueble seleccionado: {furniture_name}")

    def rotate_furniture(self, angle):
        """Rota el mueble seleccionado"""
        if self.dragging:
            self.current_rotation = (self.current_rotation + angle) % 360
            x1, y1, x2, y2 = self.canvas.coords(self.dragging)
            width = x2 - x1
            height = y2 - y1
            
            if angle in [90, 270]:
                width, height = height, width
            
            center_x = (x1 + x2) / 2
            center_y = (y1 + y2) / 2
            
            self.canvas.coords(self.dragging,
                            center_x - width/2,
                            center_y - height/2,
                            center_x + width/2,
                            center_y + height/2)

    def on_canvas_click(self, event):
        """Maneja el clic en el canvas"""
        x = self.canvas.canvasx(event.x)
        y = self.canvas.canvasy(event.y)
        
        # Verificar si se clickeó un mueble existente
        items = self.canvas.find_overlapping(x-2, y-2, x+2, y+2)
        for item in items:
            tags = self.canvas.gettags(item)
            if any(tag in self.furniture_data for tag in tags):
                self.dragging = item
                self.drag_start = (x, y)
                return
        
        # Si no se clickeó un mueble y hay uno seleccionado, colocarlo
        if self.mueble_seleccionado:
            self.place_furniture(x, y)

    def on_canvas_drag(self, event):
        """Maneja el arrastre de muebles"""
        if self.dragging:
            x = self.canvas.canvasx(event.x)
            y = self.canvas.canvasy(event.y)
            
            dx = x - self.drag_start[0]
            dy = y - self.drag_start[1]
            
            self.canvas.move(self.dragging, dx, dy)
            # Mover también la etiqueta asociada
            for item in self.canvas.find_withtag(self.canvas.gettags(self.dragging)[0]):
                if item != self.dragging:
                    self.canvas.move(item, dx, dy)
            
            self.drag_start = (x, y)

    def on_canvas_release(self, event):
        """Maneja la liberación del mouse"""
        if self.dragging:
            # Verificar si la nueva posición es válida
            x = self.canvas.canvasx(event.x)
            y = self.canvas.canvasy(event.y)
            
            furniture_name = self.canvas.gettags(self.dragging)[0]
            valid, message = self.check_placement_validity(x, y, furniture_name)
            
            if not valid:
                # Volver a la posición original
                self.canvas.coords(self.dragging, *self.get_original_coords(self.dragging))
                messagebox.showwarning("Ubicación Inválida", message)
            
            self.dragging = None
            self.drag_start = None

    def on_right_click(self, event):
        """Maneja el clic derecho para eliminar muebles"""
        x = self.canvas.canvasx(event.x)
        y = self.canvas.canvasy(event.y)
        
        items = self.canvas.find_overlapping(x-2, y-2, x+2, y+2)
        for item in items:
            tags = self.canvas.gettags(item)
            if any(tag in self.furniture_data for tag in tags):
                self.canvas.delete(tags[0])  # Elimina todos los elementos con ese tag
                # Actualizar la lista de muebles colocados
                self.placed_furniture = [f for f in self.placed_furniture if f["item"] != item]
                self.update_info_panel(f"Mueble eliminado: {tags[0]}")
                break

    def place_furniture(self, x, y):
        """Coloca un mueble en el canvas"""
        if not self.mueble_seleccionado:
            return
            
        valid, message = self.check_placement_validity(x, y, self.mueble_seleccionado)
        if not valid:
            messagebox.showwarning("Ubicación Inválida", message)
            return
            
        furniture = self.furniture_data[self.mueble_seleccionado]
        width = self.meters_to_pixels(furniture["dimensions"][0])
        height = self.meters_to_pixels(furniture["dimensions"][1])
        
        if self.current_rotation in [90, 270]:
            width, height = height, width
            
        # Crear representación visual del mueble
        item = self.canvas.create_rectangle(
            x, y, x + width, y + height,
            fill="blue",
            outline="black",
            tags=(self.mueble_seleccionado,)
        )
        
        # Agregar etiqueta
        self.canvas.create_text(
            x + width/2,
            y + height/2,
            text=self.mueble_seleccionado,
            fill="white",
            tags=(self.mueble_seleccionado,)
        )
        
        self.placed_furniture.append({
            "nombre": self.mueble_seleccionado,
            "item": item,
            "coords": (x, y, width, height),
            "rotation": self.current_rotation
        })
        
        self.update_info_panel(f"Mueble colocado: {self.mueble_seleccionado}")

    def check_placement_validity(self, x, y, furniture_name):
        """Verifica si la ubicación es válida para el mueble"""
        furniture = self.furniture_data[furniture_name]
        
        # Convertir coordenadas a metros
        x_meters = self.pixels_to_meters(x)
        y_meters = self.pixels_to_meters(y)
        
        # Encontrar en qué área está el punto
        current_area = None
        for area in self.room_areas:
            if (area.x1 <= x_meters <= area.x2 and 
                area.y1 <= y_meters <= area.y2):
                current_area = area
                break
        
        if not current_area:
            return False, "Fuera de las áreas definidas"
            
        # Verificar si el mueble está permitido en esta área
        if current_area.tipo_habitacion not in furniture["allowed_rooms"]:
            return False, f"Este mueble no está permitido en {current_area.nombre}"
        
        return True, "Ubicación válida"

    def get_original_coords(self, item):
        """Obtiene las coordenadas originales de un mueble"""
        for furniture in self.placed_furniture:
            if furniture["item"] == item:
                return furniture["coords"]
        return None

    def save_design(self):
        """Guarda el diseño actual"""
        design_data = []
        for furniture in self.placed_furniture:
            x1, y1, _, _ = self.canvas.coords(furniture["item"])
            design_data.append({
                "nombre": furniture["nombre"],
                "position": (x1, y1),
                "rotation": furniture["rotation"]
            })
        
        try:
            with open("design.json", "w") as f:
                json.dump(design_data, f)
            self.update_info_panel("Diseño guardado exitosamente")
        except Exception as e:
            messagebox.showerror("Error", f"Error al guardar el diseño: {str(e)}")

    def load_design(self):
        """Carga un diseño guardado"""
        try:
            with open("design.json", "r") as f:
                design_data = json.load(f)
            
            self.clear_design()
            
            for furniture in design_data:
                self.mueble_seleccionado = furniture["nombre"]
                self.current_rotation = furniture["rotation"]
                x, y = furniture["position"]
                self.place_furniture(x, y)
            
            self.update_info_panel("Diseño cargado exitosamente")
        except FileNotFoundError:
            messagebox.showwarning("Error", "No hay diseño guardado")
        except Exception as e:
            messagebox.showerror("Error", f"Error al cargar el diseño: {str(e)}")

    def clear_design(self):
        """Limpia todo el diseño actual"""
        for furniture in self.placed_furniture:
            self.canvas.delete(furniture["nombre"])
        self.placed_furniture = []
        self.update_info_panel("Diseño limpiado")

    def update_info_panel(self, message):
        """Actualiza el panel de información"""
        self.info_text.insert(tk.END, message + "\n")
        self.info_text.see(tk.END)

    def meters_to_pixels(self, meters):
        """Convierte metros a píxeles"""
        return meters * self.FACTOR_ESCALA

    def pixels_to_meters(self, pixels):
        """Convierte píxeles a metros"""
        return pixels / self.FACTOR_ESCALA

def main():
    raiz = tk.Tk()
    app = PlanificadorMuebles(raiz)
    raiz.mainloop()

if __name__ == "__main__":
    main()