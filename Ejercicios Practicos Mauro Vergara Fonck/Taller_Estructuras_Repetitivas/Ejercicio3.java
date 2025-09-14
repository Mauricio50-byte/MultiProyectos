package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

/*Diseñar un algoripmo de un programa que calcule la suma de una serie de numero positivos, y la suma se muestre una vez
que se ingresado un numero negativo
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int suma = 0;

        JOptionPane.showMessageDialog(null, "Ingrese números positivos para sumar. Ingrese un número negativo para terminar y mostrar la suma.");

        while (true) {
            String input = JOptionPane.showInputDialog("Ingrese un número:");
            int num = Integer.parseInt(input);

            if (num < 0) {
                break; // Salimos del bucle si se ingresa un número negativo
            }

            suma += num; // Sumar el número positivo a la suma total
        }

        JOptionPane.showMessageDialog(null, "La suma de los números positivos ingresados es: " + suma);
    }
}
