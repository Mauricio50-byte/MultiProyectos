import java.util.Arrays;

public class Taller_1 {
    private int[] vector;
    private int size;

    // Constructor
    public Taller_1(int capacity) {
        vector = new int[capacity];
        size = 0;
    }

    // Insertar en posicion especificada
    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion >= 0 && posicion <= size && size < vector.length) {
            for (int i = size; i > posicion; i--) {
                vector[i] = vector[i - 1];
            }
            vector[posicion] = valor;
            size++;
        } else {
            System.out.println("Posición inválida o vector lleno.");
        }
    }

    // Insertar antes de una posición
    public void insertarAntesDePosicion(int valor, int posicion) {
        if (posicion > 0 && posicion <= size && size < vector.length) {
            insertarEnPosicion(valor, posicion - 1);
        } else {
            System.out.println("Posición inválida o vector lleno.");
        }
    }

    // Insertar después de una posición
    public void insertarDespuesDePosicion(int valor, int posicion) {
        if (posicion >= 0 && posicion < size && size < vector.length) {
            insertarEnPosicion(valor, posicion + 1);
        } else {
            System.out.println("Posición inválida o vector lleno.");
        }
    }

    // Eliminar en posición específica
    public void eliminarEnPosicion(int posicion) {
        if (posicion >= 0 && posicion < size) {
            for (int i = posicion; i < size - 1; i++) {
                vector[i] = vector[i + 1];
            }
            size--;
        } else {
            System.out.println("Posición inválida.");
        }
    }

    // Buscar un valor
    public int buscar(int valor) {
        for (int i = 0; i < size; i++) {
            if (vector[i] == valor) {
                return i;
            }
        }
        return -1; // Retorna -1 si no encuentra el valor
    }

    // Ordenar por seleccion
    public void ordenarPorSeleccion() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (vector[j] < vector[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = vector[minIndex];
            vector[minIndex] = vector[i];
            vector[i] = temp;
        }
    }

    // Ordenar por intercambio (burbuja)
    public void ordenarPorIntercambio() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    // Mostrar vector
    public void mostrarVector() {
        System.out.println("Vector: " + Arrays.toString(Arrays.copyOf(vector, size)));
    }

    public static void main(String[] args) {
        Taller_1 vm = new Taller_1(10);
        
        // Pruebas de inserción
        vm.insertarEnPosicion(5, 0);
        vm.insertarEnPosicion(3, 1);
        vm.insertarDespuesDePosicion(7, 1);
        vm.insertarAntesDePosicion(2, 1);
        vm.mostrarVector(); // Debe mostrar: [5, 2, 3, 7]

        // Prueba de eliminación
        vm.eliminarEnPosicion(2);
        vm.mostrarVector(); // Debe mostrar: [5, 2, 7]

        // Prueba de búsqueda
        int index = vm.buscar(2);
        System.out.println("Valor 2 encontrado en posición: " + index);

        // Prueba de ordenamiento
        vm.ordenarPorSeleccion();
        vm.mostrarVector(); // Debe mostrar el vector ordenado

        vm.insertarEnPosicion(6, 2);
        vm.ordenarPorIntercambio();
        vm.mostrarVector(); // Debe mostrar el vector ordenado
    }
}