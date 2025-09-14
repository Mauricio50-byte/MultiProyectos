package ListasEnlazadasSimples;

// Clase Nodo
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Creamos la lista enlazada y todos sus metodos
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

    // Insertar antes de la posicion especificada
    public void insertarAntesDePosicion(int dato, int posicion) {
        if (posicion <= 0) {
            System.out.println("Posicion no valida. Usa insertar al inicio para la posicion 0.");
            return;
        }

        if (posicion >= obtenerLongitud()) {
            System.out.println("Posicion fuera de rango.");
            return;
        }

        insertarEnPosicion(dato, posicion - 1);
    }

    // Insertar despues de la posicion especificada
    public void insertarDespuesDePosicion(int dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posicion no valida.");
            return;
        }

        if (posicion >= obtenerLongitud()) {
            System.out.println("Posicion fuera de rango.");
            return;
        }

        insertarEnPosicion(dato, posicion + 1);
    }

    // Insertar en una posicion especifica
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posicion no valida.");
            return;
        }

        Nodo nuevoNodo = new Nodo(dato);
        if (posicion == 0) {
            insertarAlInicio(dato);
        } else {
            Nodo actual = cabeza;
            Nodo anterior = null;
            int contador = 0;

            while (actual != null && contador < posicion) {
                anterior = actual;
                actual = actual.siguiente;
                contador++;
            }

            if (anterior != null) {
                nuevoNodo.siguiente = anterior.siguiente;
                anterior.siguiente = nuevoNodo;
            }
        }
    }

    // Eliminar antes de la posicion especificada
    public void eliminarAntesDePosicion(int posicion) {
        if (posicion <= 1) {
            System.out.println("No se puede eliminar antes de la posicion " + posicion);
            return;
        }

        eliminarEnPosicion(posicion - 1);
    }

    // Eliminar despues de la posicion especificada
    public void eliminarDespuesDePosicion(int posicion) {
        if (posicion < 0 || posicion >= obtenerLongitud() - 1) {
            System.out.println("No hay un nodo despues de la posicion " + posicion);
            return;
        }

        eliminarEnPosicion(posicion + 1);
    }

    // Eliminar en una posicion especifica
    public void eliminarEnPosicion(int posicion) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar. La lista esta vacia.");
            return;
        }

        if (posicion < 0 || posicion >= obtenerLongitud()) {
            System.out.println("Posicion fuera de rango.");
            return;
        }

        if (posicion == 0) {
            eliminarAlInicio();
        } else {
            Nodo actual = cabeza;
            Nodo anterior = null;
            int contador = 0;

            while (actual != null && contador < posicion) {
                anterior = actual;
                actual = actual.siguiente;
                contador++;
            }

            if (anterior != null && actual != null) {
                anterior.siguiente = actual.siguiente;
                System.out.println("Dato '" + actual.dato + "' eliminado correctamente.");
            }
        }
    }

    // Eliminar al inicio
    public void eliminarAlInicio() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar. La lista esta vacia.");
        } else {
            System.out.println("Dato '" + cabeza.dato + "' eliminado correctamente.");
            cabeza = cabeza.siguiente;
        }
    }

    // Eliminar al final
    public void eliminarAlFinal() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar. La lista esta vacia.");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual.siguiente != null) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (anterior != null) {
            anterior.siguiente = null;
        } else {
            cabeza = null;
        }

         System.out.println("Dato '" + cabeza.dato + "' eliminado correctamente.");
    }

    // Metodo auxiliar para obtener la longitud de la lista
    private int obtenerLongitud() {
        Nodo actual = cabeza;
        int contador = 0;
        while (actual != null) {
            actual = actual.siguiente;
            contador++;
        }
        return contador;
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
            return;
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
