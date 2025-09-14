package Pilas_y_Colas;

// Clase Nodo
class Nodo1 {
    private String Dato;
    private Nodo siguiente;

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo1(String Dato) {
        this.Dato = Dato;
        this.siguiente = null;
    }

    public String toString() {
        return "[" + Dato + "]";
    }
}
public class MetodosListaSimples {
    private Nodo primero;

    public MetodosListaSimples() {
        this.primero = null;
    }

    // Insertar al inicio
    public void InsertarAlInicio(Nodo nuevo) {
        nuevo.setSiguiente(primero);
        primero = nuevo;
        System.out.println("Nodo " + nuevo.getDato() + " insertado al inicio.");
    }

    // Insertar al final
    public void InsertarAlFinal(Nodo nuevo) {
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        System.out.println("Nodo " + nuevo.getDato() + " insertado al final.");
    }

    //Insertar despues de posicion
    public void InsertarDespuesDePos(Nodo nuevo, String dato) {
        Nodo aux = this.Buscar(dato);
        if (aux == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else {
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            System.out.println("Nodo " + nuevo.getDato() + " insertado despues de " + dato + ".");
        }
    }

    // Insertar antes de una posicion
    public void InsertarAntesDePos(Nodo nuevo, String dato) {
        if (primero == null) {
            System.out.println("Error. La lista esta vacia.");
            return;
        }

        if (primero.getDato().equals(dato)) {
            InsertarAlInicio(nuevo);
            return;
        }

        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else {
            anterior.setSiguiente(nuevo);
            nuevo.setSiguiente(actual);
            System.out.println("Nodo " + nuevo.getDato() + " insertado antes de " + dato + ".");
        }
    }
    
    // Insertar en una posicion especifica 
    public void InsertarEnPosicion(int posicion, Nodo nuevo) {
        if (posicion < 1) {
            System.out.println("Error: La posicion debe ser mayor o igual a 1.");
            return;
        }

        if (posicion == 1) {
            InsertarAlInicio(nuevo);
            return;
        }

        Nodo actual = primero;
        int contador = 1;

        // Recorrer la lista hasta la posicion anterior a la deseada
        while (actual != null && contador < posicion - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual == null) {
            System.out.println("Error: La posicion " + posicion + " esta fuera de los limites de la lista.");
        } else {
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
            System.out.println("Nodo " + nuevo.getDato() + " insertado en la posicion " + posicion + ".");
        }
    }
    
    // Eliminar al inicio
    public void EliminarAlInicio() {
        if (primero == null) {
            System.out.println("Error. Lista vacia.");
        } else {
            System.out.println("Nodo " + primero.getDato() + " eliminado del inicio.");
            primero = primero.getSiguiente();
        }
    }

    // Eliminar al final
    public void EliminarAlFinal() {
        if (primero == null) {
            System.out.println("Error. Lista vacia.");
        } else if (primero.getSiguiente() == null) { // Solo un nodo
            System.out.println("Nodo " + primero.getDato() + " eliminado del final.");
            primero = null;
        } else {
            Nodo aux = primero;
            Nodo anterior = null;
            while (aux.getSiguiente() != null) {
                anterior = aux;
                aux = aux.getSiguiente();
            }
            anterior.setSiguiente(null);
            System.out.println("Nodo " + aux.getDato() + " eliminado del final.");
        }
    }

    // Eliminar despues de una posicion especifica
    public void EliminarDespuesDePos(String dato) {
        Nodo aux = this.Buscar(dato);
        if (aux == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else if (aux.getSiguiente() == null) {
            System.out.println("No hay un nodo despues de la posicion especificada.");
        } else {
            Nodo aEliminar = aux.getSiguiente();
            aux.setSiguiente(aEliminar.getSiguiente());
            System.out.println("Nodo " + aEliminar.getDato() + " eliminado despues de " + dato + ".");
        }
    }

    // Eliminar antes de una posicion
    public void EliminarAntesDePos(String dato) {
        if (primero == null || primero.getSiguiente() == null) {
            System.out.println("Error. No hay suficientes nodos en la lista.");
            return;
        }

        Nodo actual = primero.getSiguiente();
        Nodo anterior = primero;
        Nodo antesAnterior = null;

        while (actual != null && !actual.getDato().equals(dato)) {
            antesAnterior = anterior;
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else if (anterior == primero) {
            System.out.println("Nodo " + anterior.getDato() + " eliminado antes de " + dato + ".");
            primero.setSiguiente(actual);
        } else {
            antesAnterior.setSiguiente(actual);
            System.out.println("Nodo " + anterior.getDato() + " eliminado antes de " + dato + ".");
        }
    }
    
    // Eliminar en una posicion especifica
    public void EliminarEnPosicion(int posicion) {
        if (primero == null) {
            System.out.println("Error. Lista vacia.");
            return;
        }

        if (posicion < 1) {
            System.out.println("Error: La posicion debe ser mayor o igual a 1.");
            return;
        }

        if (posicion == 1) {
            System.out.println("Nodo " + primero.getDato() + " eliminado de la posicion " + posicion + ".");
            primero = primero.getSiguiente();
            return;
        }

        Nodo actual = primero;
        Nodo anterior = null;
        int contador = 1;

        // Recorrer la lista hasta la posicion deseada
        while (actual != null && contador < posicion) {
            anterior = actual;
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual == null) {
            System.out.println("Error: La posicion " + posicion + " esta fuera de los limites de la lista.");
        } else {
            anterior.setSiguiente(actual.getSiguiente());
            System.out.println("Nodo " + actual.getDato() + " eliminado de la posicion " + posicion + ".");
        }
    }
    
    // Buscar un nodo por dato
    public Nodo Buscar(String Dato) {
        Nodo aux = this.primero;
        int posicion = 1;
        while (aux != null) {
            if (aux.getDato().equals(Dato)) {
                System.out.println("Nodo " + Dato + " Encontrado en la pisicion " + posicion + ".");
                return aux;
            }
            aux = aux.getSiguiente();
            posicion++;
        }
        System.out.println("Nodo no encontado en la lista.");
        return null; // Si no se encuentra el dato
    }

    // Recorrer la lista en orden
    public void Recorrer() {
        if (primero == null) {
            System.out.println("La lista esta vacia.");
        } else {
            Nodo aux = this.primero;
            System.out.print("Lista: ");
            while (aux != null) {
                System.out.print("[" + aux.getDato() + "] -> ");
                aux = aux.getSiguiente();
            }
            System.out.println("null");
        }
    }
    
    //Ordenamos de forma alfabetica
    public void ordenar() {
        if (primero == null || primero.getSiguiente() == null) {
            System.out.println("La lista esta vacia o tiene un solo elemento. No es necesario ordenar.");
            return;
        }

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            Nodo actual = primero;
            Nodo anterior = null;

            while (actual.getSiguiente() != null) {
                Nodo siguiente = actual.getSiguiente();
                if (actual.getDato().compareTo(siguiente.getDato()) > 0) {
                    // Intercambiar los nodos
                    if (anterior == null) {
                        // Intercambio al inicio de la lista
                        primero = siguiente;
                    } else {
                        anterior.setSiguiente(siguiente);
                    }
                    actual.setSiguiente(siguiente.getSiguiente());
                    siguiente.setSiguiente(actual);

                    // Actualizar referencias
                    huboIntercambio = true;
                    anterior = siguiente;
                } else {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        } while (huboIntercambio);

        System.out.println("La lista ha sido ordenada.");
    }
//    // Recorrer la lista en orden inverso
//    public void RecorrerInversa() {
//        if (primero == null) {
//            System.out.println("La lista est? vac?a.");
//        } else {
//            System.out.print("Lista Inversa: ");
//            RecorrerInversaRecursivo(primero);
//            System.out.println("null");
//        }
//    }
//
//    private void RecorrerInversaRecursivo(Nodo nodo) {
//        if (nodo == null) {
//            return;
//        }
//        RecorrerInversaRecursivo(nodo.getSiguiente());
//        System.out.print("[" + nodo.getDato() + "] -> ");
//    }
}