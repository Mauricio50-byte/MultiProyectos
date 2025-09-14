public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol izquiero, derecho;

    public NodoArbol(int dato, String nombre, NodoArbol izquiero, NodoArbol derecho) {
        this.dato = dato;
        this.nombre = nombre;
        this.izquiero = null;
        this.derecho = null;
    }
    
}
