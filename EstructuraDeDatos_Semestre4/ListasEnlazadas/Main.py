# Clase de excepcion personalizada
class ListaEnlazadaError(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)

# Creamos el Nodo
class Nodo:
    def __init__(self, dato):
        self.dato = dato
        self.siguiente = None

# Creamos la ListaEnlazada
class ListaEnlazada:
    def __init__(self):
        self.cabeza = None

    # Funcion para verificar si la lista esta vacia
    def esta_vacia(self):
        return self.cabeza is None

    # Insertar al inicio de la lista
    def insertar_al_inicio(self, dato):
        nuevoNodo = Nodo(dato)
        nuevoNodo.siguiente = self.cabeza
        self.cabeza = nuevoNodo

    # Insertar al final de la lista
    def insertar_al_final(self, dato):
        nuevoNodo = Nodo(dato)
        if self.esta_vacia():
            self.cabeza = nuevoNodo
        else:
            actual = self.cabeza
            while actual.siguiente:
                actual = actual.siguiente
            actual.siguiente = nuevoNodo

    # Insertar en una posicion especifica
    def insertarEnPosicion(self, dato, posicion):
        if posicion < 0:
            raise ListaEnlazadaError("Posicion no valida. Las posiciones deben ser mayores o iguales a cero.")

        nuevoNodo = Nodo(dato)

        if posicion == 0:  # Insertar al inicio
            self.insertar_al_inicio(dato)
            return

        actual = self.cabeza
        anterior = None
        contador = 0

        while actual and contador < posicion:
            anterior = actual
            actual = actual.siguiente
            contador += 1

        if contador == posicion:
            nuevoNodo.siguiente = actual
            anterior.siguiente = nuevoNodo
        else:
            raise ListaEnlazadaError("Posicion fuera de rango. Intentaste insertar en una posicion mayor a la longitud de la lista.")

    # Insertar antes de una posicion especifica
    def insertar_antes_de_posicion(self, dato, posicion):
        if posicion <= 0:
            raise ListaEnlazadaError("Posicion no valida. Para insertar antes de la posicion 0, debes usar insertar al inicio.")
        self.insertarEnPosicion(dato, posicion - 1)

    # Insertar despues de una posicion especifica
    def insertar_despues_de_posicion(self, dato, posicion):
        self.insertarEnPosicion(dato, posicion + 1)

    # Eliminar al inicio
    def eliminar_al_inicio(self):
        if self.esta_vacia():
            raise ListaEnlazadaError("No se puede eliminar. La lista esta vacia.")
        else:
            self.cabeza = self.cabeza.siguiente

    # Eliminar al final
    def eliminar_al_final(self):
        if self.esta_vacia():
            raise ListaEnlazadaError("No se puede eliminar. La lista esta vacia.")
        else:
            actual = self.cabeza
            anterior = None
            while actual.siguiente:
                anterior = actual
                actual = actual.siguiente
            if anterior:
                anterior.siguiente = None
            else:
                self.cabeza = None  # Si solo hay un nodo

    # Eliminar en una posicion especifica
    def eliminar_en_posicion(self, posicion):
        if self.esta_vacia():
            raise ListaEnlazadaError("No se puede eliminar. La lista esta vacia.")
        if posicion < 0:
            raise ListaEnlazadaError("Posicion no valida. Las posiciones deben ser mayores o iguales a cero.")

        if posicion == 0:  # Eliminar al inicio
            self.eliminar_al_inicio()
            return

        actual = self.cabeza
        anterior = None
        contador = 0

        while actual and contador < posicion:
            anterior = actual
            actual = actual.siguiente
            contador += 1

        if contador == posicion and actual:
            anterior.siguiente = actual.siguiente
        else:
            raise ListaEnlazadaError("Posicion fuera de rango. No existe un elemento en la posicion especificada.")

    # Buscar un valor en la lista
    def buscar(self, dato):
        actual = self.cabeza
        posicion = 0
        while actual:
            if actual.dato == dato:
                return f"Valor {dato} encontrado en la posicion {posicion}"
            actual = actual.siguiente
            posicion += 1
        raise ListaEnlazadaError(f"Valor {dato} no encontrado en la lista.")

    # Recorrer y mostrar la lista
    def recorrer(self):
        if self.esta_vacia():
            print("La lista esta vacia.")
        else:
            actual = self.cabeza
            while actual:
                print(actual.dato, end=" -> ")
                actual = actual.siguiente
            print("None")

    # Ordenar la lista (usamos bubble sort para simplicidad)
    def ordenar(self):
        if self.esta_vacia():
            raise ListaEnlazadaError("No se puede ordenar. La lista esta vacia.")

        actual = self.cabeza
        while actual:
            siguiente = actual.siguiente
            while siguiente:
                if actual.dato > siguiente.dato:
                    # Intercambiamos los valores
                    actual.dato, siguiente.dato = siguiente.dato, actual.dato
                siguiente = siguiente.siguiente
            actual = actual.siguiente

# Programa Principal
class ProgramaPrincipal:
    def __init__(self):
        self.lista = ListaEnlazada()

    def ejecutar(self):
        while True:
            print("\nOperaciones de la lista enlazada:")
            print("1. Insertar al inicio")
            print("2. Insertar al final")
            print("3. Insertar en una posicion")
            print("4. Eliminar al inicio")
            print("5. Eliminar al final")
            print("6. Eliminar en una posicion")
            print("7. Buscar un valor")
            print("8. Recorrer la lista")
            print("9. Ordenar la lista")
            print("0. Salir")
            
            opcion = input("Selecciona una opcion: ")

            try:
                if opcion == "1":
                    dato = int(input("Ingresa el valor a insertar al inicio: "))
                    self.lista.insertar_al_inicio(dato)

                elif opcion == "2":
                    dato = int(input("Ingresa el valor a insertar al final: "))
                    self.lista.insertar_al_final(dato)

                elif opcion == "3":
                    dato = int(input("Ingresa el valor a insertar: "))
                    posicion = int(input("Ingresa la posicion donde insertar: "))
                    self.lista.insertarEnPosicion(dato, posicion)

                elif opcion == "4":
                    self.lista.eliminar_al_inicio()

                elif opcion == "5":
                    self.lista.eliminar_al_final()

                elif opcion == "6":
                    posicion = int(input("Ingresa la posicion a eliminar: "))
                    self.lista.eliminar_en_posicion(posicion)

                elif opcion == "7":
                    dato = int(input("Ingresa el valor a buscar: "))
                    print(self.lista.buscar(dato))

                elif opcion == "8":
                    print("Lista enlazada:")
                    self.lista.recorrer()

                elif opcion == "9":
                    print("Ordenando la lista...")
                    self.lista.ordenar()
                    print("Lista ordenada:")
                    self.lista.recorrer()

                elif opcion == "0":
                    print("Saliendo...")
                    break

                else:
                    print("Opcion no valida. Intenta de nuevo.")

            except ListaEnlazadaError as e:
                print(f"Error: {e}")

# Ejecutar el programa principal
if __name__ == "__main__":
    programa = ProgramaPrincipal()
    programa.ejecutar()
