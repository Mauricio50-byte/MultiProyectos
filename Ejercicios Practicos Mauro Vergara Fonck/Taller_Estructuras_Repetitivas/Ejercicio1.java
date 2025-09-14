package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

// Desarrolle un algoripmo que permita leer un valor entero positivo N y determine si es primo o no
public class Ejercicio1 {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese un número entero positivo:");
        int num = Integer.parseInt(input);
        int contador = 0;

        if (num > 1) {

            for (int i = 2; i <= num / 2; i++) {

                if (num % i == 0) {
                    contador++;
                }
            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(null, "El número " + num + " es primo");
            } else {
                JOptionPane.showMessageDialog(null, "El número " + num + " no es primo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! El número debe ser mayor a cero.");
        }
    }
}