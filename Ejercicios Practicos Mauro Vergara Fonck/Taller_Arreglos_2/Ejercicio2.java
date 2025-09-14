package Taller_Arreglos_2;

import java.util.Random;
import javax.swing.JOptionPane;

/*Crea un array de números de un tamaño pasado por teclado,
el array contendrá números aleatorios primos entre los números deseados,
por último nos indica cual es el mayor de todos.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese el tamaño del array:");
        int tamano = Integer.parseInt(input);

        int[] array = new int[tamano];

        // Llenamos el array con numeros primos aleatorios
        llenarArrayConPrimos(array);

        // Creamos un StringBuilder para almacenar el contenido del array
        StringBuilder contenidoArray = new StringBuilder("Contenido del array:\n");
        for (int i = 0; i < array.length; i++) {
            contenidoArray.append("Posición ").append(i).append(": ").append(array[i]).append("\n");
        }

        // Encontramos el mayor número primo en el array
        int mayorPrimo = encontrarMayorPrimo(array);

        // Construimos el mensaje completo
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(contenidoArray).append("El mayor número primo en el array es: ").append(mayorPrimo);

        // Mostramos el mensaje en un diálogo emergente
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    // Metodo para llenar el array con numeros primos aleatorios
    public static void llenarArrayConPrimos(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int numero = 0;
            do {
                numero = random.nextInt(Integer.MAX_VALUE); // Generamos un numero aleatorio grande
            } while (!esPrimo(numero));
            array[i] = numero;
        }
    }

    // Metodo para verificar si un numero es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Metodo para encontrar el mayor numero primo en el array
    public static int encontrarMayorPrimo(int[] array) {
        int mayorPrimo = Integer.MIN_VALUE;
        for (int numero : array) {
            if (numero > mayorPrimo && esPrimo(numero)) {
                mayorPrimo = numero;
            }
        }
        return mayorPrimo;
    }
}
