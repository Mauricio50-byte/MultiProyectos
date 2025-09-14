package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

/*Desarrolle un algoritmo que permita imprimir el siguiente patrón de numeros hasta un
numero n de repeticiones*/
public class Ejercicio2 {
    public static void main(String[] args) {
        int num = 10; // Cantidad de filas del patrón
        StringBuilder patron = new StringBuilder("Patron Numero ").append(num).append("\n");
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                patron.append(j).append(" ");
            }
            patron.append("\n");
        }
        JOptionPane.showMessageDialog(null, patron.toString());
    }
}
