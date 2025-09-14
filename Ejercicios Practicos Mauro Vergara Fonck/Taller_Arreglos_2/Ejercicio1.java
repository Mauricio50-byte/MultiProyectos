package Taller_Arreglos_2;

import java.util.Random;

import javax.swing.JOptionPane;

/*Crea un array de números donde le indicamos por teclado el tamaño del arrays
rellenaremos el array con números aleatorios entre 0 y 9, al final muestra por pantalla el valor
de cada posición y la suma de todos los valores. Haz un método para rellenar el array
(que tenga como parámetros los números entre los que tenga que generar), 
para mostrar el contenido y la suma del array
 y un método privado para generar número aleatorio (lo puedes usar para otros ejercicios). */
public class Ejercicio1 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese el tamaño del array:");
        int tamano = Integer.parseInt(input);

        int[] array = new int[tamano];

        // Rellenamos el array con numeros aleatorios entre 0 y 9
        llenarArray(array, 0, 9);

        // Mostramos el contenido del array y la suma de todos los valores
        mostrarArrayYSuma(array);
    }

    // Metodo para rellenar el array con numeros aleatorios dentro de un rango dado
    public static void llenarArray(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generarNumeroAleatorio(min, max);
        }
    }

    // Metodo para mostrar el contenido del array y la suma de todos los valores
    public static void mostrarArrayYSuma(int[] array) {
        StringBuilder mensaje = new StringBuilder("Contenido del array:\n");
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            mensaje.append("Posición ").append(i).append(": ").append(array[i]).append("\n");
            suma += array[i];
        }
        mensaje.append("Suma de todos los valores: ").append(suma);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Metodo privado para generar un numero aleatorio dentro de un rango dado
    private static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
