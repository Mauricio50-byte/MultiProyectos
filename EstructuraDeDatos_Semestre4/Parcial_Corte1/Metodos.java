package Parcial_Corte1;

import java.util.Arrays;

import javax.swing.JOptionPane;

class Metodos {  
    private int[] vector;  
    private int tamaño; 
    private int elementosActuales; 

    public Metodos(int tamaño) {  
        this.tamaño = tamaño;  
        this.vector = new int[tamaño];  
        this.elementosActuales = 0;
    }  

    public void insertarAlInicio(int valor) {  
        if (elementosActuales < tamaño) { // Verificamos si hay espacio disponible
            desplazarDerecha(0);  
            vector[0] = valor;  
            elementosActuales++; // Incrementamos el contador de elementos actuales
        } else {
            JOptionPane.showMessageDialog(null, "El vector esta lleno. No se puede insertar el valor.");
        }
    }  

    public void insertarAlFinal(int valor) {  
        if (elementosActuales < tamaño) { 
            vector[elementosActuales] = valor;  
            elementosActuales++; 
        } else {
            JOptionPane.showMessageDialog(null, "El vector est lleno. No se puede insertar el valor.");
        }  
    }  

    public void insertarEnPosicion(int valor, int posicion) {  
        if (elementosActuales < tamaño && posicion >= 0 && posicion <= elementosActuales) {  // Verificamos si hay espacio disponible y la posicion es valida
            desplazarDerecha(posicion);  
            vector[posicion] = valor;  
            elementosActuales++;  // Incrementamos el conteo de elementos
        } else {
            JOptionPane.showMessageDialog(null, "El vector esta lleno o la posición es invalida. No se puede insertar.");
        }
    }  

    public void eliminarAlInicio() {  
        if (elementosActuales > 0) {  // Verificamos si hay elementos para eliminar
            desplazarIzquierda(0);  
            elementosActuales--;  // Decrementamos el conteo de elementos
        } else {
            JOptionPane.showMessageDialog(null, "El vector está vacio. No se puede eliminar.");
        } 
    }  

    public void eliminarAlFinal() {  
        if (elementosActuales > 0) {  // Verificamos si hay elementos para eliminar
            vector[elementosActuales - 1] = 0;  // Asumimos que 0 es el valor por defecto
            elementosActuales--;  // Decrementamos el conteo de elementos
        } else {
            JOptionPane.showMessageDialog(null, "El vector esta vacio. No se puede eliminar.");
        }
    }  

    public void eliminarEnPosicion(int posicion) {  
        if (elementosActuales > 0 && posicion >= 0 && posicion < elementosActuales) {  // Verificamos si hay elementos para eliminar y la posicion es valida
            desplazarIzquierda(posicion);  
            elementosActuales--;  // Decrementamos el conteo de elementos
        } else {
            JOptionPane.showMessageDialog(null, "El vector esta vacio o la posicion es invalida. No se puede eliminar.");
        }
    }  

    public void ordenarSeleccion() {  
        for (int i = 0; i < tamaño - 1; i++) {  
            int indiceMinimo = i;  
            for (int j = i + 1; j < tamaño; j++) {  
                if (vector[j] < vector[indiceMinimo]) {  
                    indiceMinimo = j;  
                }  
            }  
            intercambiar(i, indiceMinimo);  
        }  
    }  

    public void ordenarBurbuja() {  
        for (int i = 0; i < tamaño - 1; i++) {  
            for (int j = 0; j < tamaño - i - 1; j++) {  
                if (vector[j] > vector[j + 1]) {  
                    intercambiar(j, j + 1);  
                }  
            }  
        }  
    }  

    public void ordenarInsercion() {  
        for (int i = 1; i < tamaño; i++) {  
            int clave = vector[i];  
            int j = i - 1;  
            while (j >= 0 && vector[j] > clave) {  
                vector[j + 1] = vector[j];  
                j--;  
            }  
            vector[j + 1] = clave;  
        }  
    }  

    public int busquedaSecuencial(int valor) {  
        for (int i = 0; i < tamaño; i++) {  
            if (vector[i] == valor) {  
                return i;  
            }  
        }  
        return -1;  
    }  

    public int busquedaBinaria(int valor) {  
        Arrays.sort(vector); // nos aseguramos de que el vector este ordenado  
        int izquierda = 0, derecha = tamaño - 1;  
        while (izquierda <= derecha) {  
            int medio = izquierda + (derecha - izquierda) / 2;  
            if (vector[medio] == valor) {  
                return medio;  
            }  
            if (vector[medio] < valor) {  
                izquierda = medio + 1;  
            } else {  
                derecha = medio - 1;  
            }  
        }  
        return -1;  
    }  

    private void desplazarDerecha(int indice) {  
        for (int i = elementosActuales; i > indice; i--) {  
            vector[i] = vector[i - 1];  
        } 
    }  

    private void desplazarIzquierda(int indice) {  
        for (int i = indice; i < elementosActuales - 1; i++) {  
            vector[i] = vector[i + 1];  
        }  
        vector[elementosActuales - 1] = 0; // Asumimos que 0 es el valor por defecto  
    }  

    private void intercambiar(int i, int j) {  
        int temp = vector[i];  
        vector[i] = vector[j];  
        vector[j] = temp;  
    }  

    public String mostrarVector() {  
        return Arrays.toString(vector);  
    }  
}
