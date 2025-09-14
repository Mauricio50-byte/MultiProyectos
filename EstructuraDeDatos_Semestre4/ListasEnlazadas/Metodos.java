package ListasEnlazadas;

// Clase Nodo
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

//Creamos la listasEnlazadas y todos sus metodos
public class Metodos {
    private Nodo cabeza;

    public Metodos() {
        this.cabeza = null;
    }

    // Verificar si la lista esta vacia
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Insertar al inicio de la lista
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    // Insertar al final de la lista
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Insertar en una posicion especifica
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posicion no valida. Las posiciones deben ser mayores o iguales a cero.");
        }

        Nodo nuevoNodo = new Nodo(dato);
        if (posicion == 0) {
            insertarAlInicio(dato);
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;
        int contador = 0;

        while (actual != null && contador < posicion) {
            anterior = actual;
            actual = actual.siguiente;
            contador++;
        }

        if (contador == posicion) {
            nuevoNodo.siguiente = actual;
            if (anterior != null) {
                anterior.siguiente = nuevoNodo;
            }
        } else {
            System.out.println("Posicion fuera de rango. Intentaste insertar en una posicion mayor a la longitud de la lista.");
        }
    }

    // Eliminar al inicio
    public void eliminarAlInicio() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar. La lista esta vacia.");
        } else {
            System.out.println("Eliminando el primer dato...");
            System.out.println("Dato '" + cabeza.dato + "' eliminado correctamente.");
            cabeza = cabeza.siguiente;
        }
    }

    // Eliminar al final
    public void eliminarAlFinal() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar. La lista esta vacia.");
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        System.out.println("Eliminando el ultimo dato...");

        while (actual.siguiente != null) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (anterior != null) {
            System.out.println("Dato '" + actual.dato + "' eliminado correctamente.");
            anterior.siguiente = null;
        } else {
            System.out.println("Dato '" + actual.dato + "' eliminado correctamente.");
            cabeza = null;  // Si solo hay un nodo
        }
    }

    // Eliminar en una posicion especifica
    public void eliminarEnPosicion(int posicion) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar. La lista esta vacia.");
        }
        if (posicion < 0) {
            System.out.println("Posicion no valida. Las posiciones deben ser mayores o iguales a cero.");
        }

        if (posicion == 0) {
            eliminarAlInicio();
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;
        int contador = 0;

        System.out.println("Eliminando el dato en la posicion " + posicion + "...");

        while (actual != null && contador < posicion) {
            anterior = actual;
            actual = actual.siguiente;
            contador++;
        }

        if (contador == posicion && actual != null) {
            System.out.println("Dato '" + actual.dato + "' eliminado correctamente.");
            anterior.siguiente = actual.siguiente;
        } else {
            System.out.println("Posicion fuera de rango. No existe un elemento en la posicion especificada.");
        }
    }

    // Buscar un valor en la lista
    public int buscar(int dato) {
        Nodo actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        System.out.println("Valor " + dato + " no encontrado en la lista.");
        return posicion;
    }

    // Recorrer y mostrar la lista
    public void recorrer() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia.");
        } else {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("None");
        }
    }

    // Ordenar la lista (Bubble Sort)
    public void ordenar() {
        if (estaVacia()) {
            System.out.println("No se puede ordenar. La lista esta vacia.");
        }

        boolean huboIntercambio;
        do {
            Nodo actual = cabeza;
            Nodo siguiente = cabeza.siguiente;
            huboIntercambio = false;

            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    huboIntercambio = true;
                }
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (huboIntercambio);
    }
}
