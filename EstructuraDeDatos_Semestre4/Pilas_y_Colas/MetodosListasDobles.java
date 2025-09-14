package Pilas_y_Colas;

class Nodo{
   private String Dato;
   private Nodo anterior;
   private Nodo siguiente;

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo(String Dato) {
        this.Dato = Dato;
        this.anterior = null;
        this.siguiente = null;
    }
    public String toString() {
        return "[" + Dato + "]";
    }
}
public class MetodosListasDobles {
    private Nodo primero;
    private Nodo ultimo;

    public MetodosListasDobles() {
        this.primero = null;
        this.ultimo = null;
    }
    
    //Insertar al inicio
    public void InsertarAlInicio(Nodo nuevo){
        if (primero == null && ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        }else{
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }
    
    //Insertara al final
    public void InsertaraAlFinal(Nodo nuevo){
        if (primero == null && ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }
    
    //Insertar despues de posicion
    public void InsertarDespuesDePos(Nodo nuevo, String dato) {
        Nodo aux = this.Buscar(dato);
        if (aux == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else {
            nuevo.setAnterior(aux);
            nuevo.setSiguiente(aux.getSiguiente());

            if (aux.getSiguiente() != null) { // Si no es el ultimo
                aux.getSiguiente().setAnterior(nuevo);
            } else {
                ultimo = nuevo; // Si es el ultimo, actualizar "ultimo"
            }
            aux.setSiguiente(nuevo);
        }
    }

    // Insertar antes de una posicion
    public void InsertarAntesDePos(Nodo nuevo, String dato) {
        Nodo aux = this.Buscar(dato);
        if (aux == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else {
            nuevo.setSiguiente(aux);
            nuevo.setAnterior(aux.getAnterior());

            if (aux.getAnterior() != null) { // Si no es el primero
                aux.getAnterior().setSiguiente(nuevo);
            } else {
                primero = nuevo; // Si es el primero, actualizar "primero"
            }
            aux.setAnterior(nuevo);
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
        } else if (primero == ultimo) { // Solo hay un nodo
            primero = null;
            ultimo = null;
        } else {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
        }
    }

    // Eliminar al final
    public void EliminarAlFinal() {
        if (primero == null) { 
            System.out.println("Error. Lista vacia.");
        } else if (primero == ultimo) { // Solo hay un nodo
            primero = null;
            ultimo = null;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }
    }

     // Eliminar despues de una posicion
    public void EliminarDespuesDePos(String dato) {
        Nodo aux = this.Buscar(dato);
        if (aux == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else if (aux.getSiguiente() == null) {
            System.out.println("No hay un nodo despues de la posicion especificada.");
        } else {
            Nodo aEliminar = aux.getSiguiente();
            aux.setSiguiente(aEliminar.getSiguiente());

            if (aEliminar.getSiguiente() != null) { // Si no es el ultimo
                aEliminar.getSiguiente().setAnterior(aux);
            } else {
                ultimo = aux; // Si es el ultimo, actualizamos "ultimo"
            }
            //limpiamos referencias del nodo eliminado
            aEliminar.setAnterior(null);
            aEliminar.setSiguiente(null);
            System.out.println("Nodo " + aEliminar.getDato() + " eliminado despues de " + dato + ".");
        }
    }

    // Eliminar antes de una posicion
    public void EliminarAntesDePos(String dato) {
        Nodo aux = this.Buscar(dato);
        if (aux == null) {
            System.out.println("Error. No existe una referencia con dato: " + dato);
        } else if (aux.getAnterior() == null) {
            System.out.println("No hay un nodo antes de la posicion especificada.");
        } else {
            Nodo aEliminar = aux.getAnterior();
            aux.setAnterior(aEliminar.getAnterior());

            if (aEliminar.getAnterior() != null) { // Si no es el primero
                aEliminar.getAnterior().setSiguiente(aux);
            } else {
                primero = aux; // Si es el primero, actualizar "primero"
            }
            //limpiamos referencias del nodo eliminado
            aEliminar.setAnterior(null);
            aEliminar.setSiguiente(null);
            System.out.println("Nodo " + aEliminar.getDato() + " eliminado antes de " + dato + ".");
        }
    }
    
    // Eliminar en una posici?n espec?fica
    public void EliminarEnPosicion(int posicion) {
        if (posicion < 1) {
            System.out.println("Error: La posicion debe ser mayor o igual a 1.");
            return;
        }

        if (primero == null) {
            System.out.println("Error. Lista vacia.");
            return;
        }

        // Si se elimina el primer nodo
        if (posicion == 1) {
            EliminarAlInicio();
            return;
        }

        Nodo actual = primero;
        int contador = 1;

        // Recorrer la lista hasta la posicion deseada
        while (actual != null && contador < posicion) {
            actual = actual.getSiguiente();
            contador++;
        }

        // Si la posici?n esta fuera de los limites de la lista
        if (actual == null) {
            System.out.println("Error: La posicion " + posicion + " esta fuera de los limites de la lista.");
            return;
        }

        // Eliminar el nodo actual
        Nodo aEliminar = actual;
        if (aEliminar.getAnterior() != null) {
            aEliminar.getAnterior().setSiguiente(aEliminar.getSiguiente());
        }
        if (aEliminar.getSiguiente() != null) {
            aEliminar.getSiguiente().setAnterior(aEliminar.getAnterior());
        }

        // Actualizar primero y ultimo si es necesario
        if (aEliminar == primero) {
            primero = aEliminar.getSiguiente();
        }
        if (aEliminar == ultimo) {
            ultimo = aEliminar.getAnterior();
        }

        // Limpiar referencias del nodo eliminado
        aEliminar.setAnterior(null);
        aEliminar.setSiguiente(null);
        System.out.println("Nodo " + aEliminar.getDato() + " eliminado en la posicion " + posicion + ".");
    }

    // Buscar nodo
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
    
     //Ordenamos de forma alfabetica
    public void ordenar() {
        if (primero == null) {
            System.out.println("La lista est? vacia.");
            return;
        }

        boolean intercambiado;
        do {
            Nodo actual = primero;
            intercambiado = false;

            while (actual.getSiguiente() != null) {
                if (actual.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                    // Intercambiar datos
                    String temp = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temp);
                    intercambiado = true;
                }
                actual = actual.getSiguiente();
            }
        } while (intercambiado);

        System.out.println("Lista ordenada.");
    }
    
    // Recorrer lista en orden
    public void Recorrer() {
        if (primero == null) {
            System.out.println("La lista esta vacia.");
        } else {
            Nodo aux = this.primero;
            while (aux != null) {
                System.out.print("[" + aux.getDato() + "]<->");
                aux = aux.getSiguiente();
            }
            System.out.println(" [null]"); // Para indicar el fin de la lista
        }
    }

    // Recorrer lista en orden inverso
    public void RecorrerInversa() {
        if (ultimo == null) {
            System.out.println("La lista esta vacia.");
        } else {
            Nodo aux = this.ultimo;
            while (aux != null) {
                System.out.print("[" + aux.getDato() + "]<->");
                aux = aux.getAnterior();
            }
            System.out.println(" [null]"); // Para indicar el fin de la lista
        }
    }
}