import tkinter as tk
from PlanificadorMuebles import PlanificadorMuebles

class App:
    def __init__(self):
        self.raiz = tk.Tk()
        self.raiz.title("Planificador de Muebles")
        self.planificador = PlanificadorMuebles(self.raiz)
        self.raiz.mainloop()

if __name__ == "__main__":
    app = App()