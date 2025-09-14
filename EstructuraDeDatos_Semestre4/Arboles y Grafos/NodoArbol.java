public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol izquierdo, derecho;
    
    public NodoArbol(int dato, String nombre ){
        this.dato = dato;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String toString(){
        return nombre + "Su Dato es: " + dato;
    }
}
