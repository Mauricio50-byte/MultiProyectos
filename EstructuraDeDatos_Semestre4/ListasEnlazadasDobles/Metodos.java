package ListasEnlazadasDobles;

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
public class Metodos {
    private Nodo primero;
    private Nodo ultimo;

    public Metodos() {
        this.primero = null;
        this.ultimo = null;
    }
    
//    // Verificar si la lista esta vacia
//    public boolean estaVacia() {
//        return primero == null;
//        return ultimo == null;
//    }
    
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
            System.out.println("Error. No existe una referencia.");
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
            System.out.println("Error. No existe una referencia.");
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

    // Eliminar al inicio
    public void EliminarAlInicio() {
        if (primero == null) { 
            System.out.println("Error. Lista vac?a.");
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
            System.out.println("Error. Lista vac?a.");
        } else if (primero == ultimo) { // Solo hay un nodo
            primero = null;
            ultimo = null;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }
    }

    // Buscar nodo
    public Nodo Buscar(String Dato) {
        Nodo aux = this.primero;
        while (aux != null) {
            if (aux.getDato().equals(Dato)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null; // Si no se encuentra el dato
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