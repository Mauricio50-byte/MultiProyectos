package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

/*Leer una serie de números hasta que el usuario ingrese el valor de -99 y escriba el númerc
mayor y el número menor
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        int numero;
        int numeroMayor = Integer.MIN_VALUE;
        int numeroMenor = Integer.MAX_VALUE;

        JOptionPane.showMessageDialog(null, "Ingrese una serie de números. Ingrese -99 para terminar.");

        while (true) {
            String input = JOptionPane.showInputDialog("Ingrese un número:");
            numero = Integer.parseInt(input);

            if (numero == -99) {
                break;
            }

            if (numero > numeroMayor) {
                numeroMayor = numero;
            }

            if (numero < numeroMenor) {
                numeroMenor = numero;
            }
        }

        if (numeroMayor == Integer.MIN_VALUE) {
            JOptionPane.showMessageDialog(null, "No se ingresaron números.");
        } else {
            JOptionPane.showMessageDialog(null, "El número mayor es: " + numeroMayor + "\nEl número menor es: " + numeroMenor);
        }
    }
}