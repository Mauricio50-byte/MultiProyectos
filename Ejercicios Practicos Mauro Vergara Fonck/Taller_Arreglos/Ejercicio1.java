package Taller_Arreglos;

import javax.swing.JOptionPane;

/*Diseñe un algoritmo que lea dos vectores A y B de igual número de
elementos cada uno y multiplique el primer elemento de A con el último
elemento de B y luego el segundo elemento de A por el diecinueveavo
elemento de B y así sucesivamente hasta llegar al veinteavo elemento de
A por el primer elemento de B. El resultado de la multiplicación
almacenarlo en un vector C. */
public class Ejercicio1 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese la longitud de los vectores:");
        int longitud = Integer.parseInt(input);

        // Crearmos los vectores A, B y C
        int[] A = new int[longitud];
        int[] B = new int[longitud];
        int[] C = new int[longitud];

        JOptionPane.showMessageDialog(null, "Ingrese los elementos del vector A:");
        for (int i = 0; i < longitud; i++) {
            String elementInput = JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + " de A:");
            A[i] = Integer.parseInt(elementInput);
        }

        JOptionPane.showMessageDialog(null, "Ingrese los elementos del vector B:");
        for (int i = 0; i < longitud; i++) {
            String elementInput = JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + " de B:");
            B[i] = Integer.parseInt(elementInput);
        }

        // Calculamos la multiplicacion y almacenamos los resultados en el vector C
        for (int i = 0; i < longitud; i++) {
            int indiceB = longitud - i - 1; // Índice del elemento de B a multiplicar
            C[i] = A[i] * B[indiceB];
        }

        // Construimos el mensaje para mostrar el vector C
        StringBuilder mensaje = new StringBuilder("El vector C, resultado de la multiplicación, es:\n");
        for (int i = 0; i < longitud; i++) {
            mensaje.append(C[i]).append(" ");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}