package Taller_Arreglos;

import java.util.Scanner;

import javax.swing.JOptionPane;

/*Diseñar un algoritmo que permita almacenar un numero N de valores, pero
solo puede almacenar valores pares en indices impares y en los indices
pares, solo se pueden almacenar números negativos. Al final el algoritmo
debe mostrar los números almacenados, la sumatoria de los números y si
el resultado es negativo decir, los índices Impares son mayores, y siel
resultado es positivo decir, los índices pares son mayores */
public class Ejercicio3 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de valores a almacenar:");
        int n = Integer.parseInt(input);

        int[] valores = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // Indices pares
                String negativoInput = JOptionPane.showInputDialog("Ingrese un número negativo para el índice " + i + ":");
                valores[i] = Integer.parseInt(negativoInput);
            } else { // Indices impares
                boolean esPar = false;
                while (!esPar) {
                    String parInput = JOptionPane.showInputDialog("Ingrese un número par para el índice " + i + ":");
                    int valor = Integer.parseInt(parInput);
                    if (valor % 2 == 0) {
                        valores[i] = valor;
                        esPar = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "El número ingresado no es par. Inténtelo de nuevo.");
                    }
                }
            }
        }

        StringBuilder mensajeValores = new StringBuilder("Valores almacenados:\n");

        for (int i = 0; i < n; i++) {
            mensajeValores.append("Índice ").append(i).append(": ").append(valores[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensajeValores.toString());

        int sumatoria = 0;
        for (int valor : valores) {
            sumatoria += valor;
        }

        String mensaje;
        if (sumatoria < 0) {
            mensaje = "Los índices impares son mayores.";
        } else if (sumatoria > 0) {
            mensaje = "Los índices pares son mayores.";
        } else {
            mensaje = "Los índices pares e impares tienen la misma suma.";
        }

        JOptionPane.showMessageDialog(null, "Sumatoria de los valores: " + sumatoria + "\n" + mensaje);
    }
}
