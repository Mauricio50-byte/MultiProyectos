package Parcial;

import javax.swing.JOptionPane;

public class Parcial_c2 {
    public static void main(String[] args) {
        // Pedimos al usuario el tamaño de los arreglos
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de los arreglos:"));

        // Declaramos los arreglos
        int[] arregloA = new int[tamaño];
        int[] arregloB = new int[tamaño];
        int[] arregloC = new int[tamaño];
        int[] arregloResultante = new int[tamaño];
        double[] arregloPromedios = new double[tamaño];
        int[] menores = new int[tamaño]; // Arreglo para almacenar los menores de cada fila

        // Llenamos los arreglos A, B y C con numeros aleatorios del 0 al 100
        llenarArreglo(arregloA);
        llenarArreglo(arregloB);
        llenarArreglo(arregloC);

        // Llenamos el arreglo resultante con los numeros de los tres arreglos
        for (int i = 0; i < tamaño; i++) {
            arregloResultante[i] = arregloA[i] + arregloB[i] + arregloC[i];
        }

        // Calculamos los promedios y el promedio general
        double promedioGeneral = 0;
        for (int i = 0; i < tamaño; i++) {
            arregloPromedios[i] = (double) arregloResultante[i] / 3;
            promedioGeneral += arregloPromedios[i];
        }
        promedioGeneral /= tamaño;

        // Calculamos los menores de cada fila y almacenarlos en el arreglo menores
        for (int i = 0; i < tamaño; i++) {
            menores[i] = encontrarMenor(arregloA[i], arregloB[i], arregloC[i]);
        }
        // Mostramos la tabla con los valores de los arreglos A, B, C, los menores y el promedio
        StringBuilder tabla = new StringBuilder("Tabla:\n");
        tabla.append("ArregloA | ArregloB | ArregloC | Menor | Promedio\n");
        for (int i = 0; i < tamaño; i++) {
            tabla.append(arregloA[i]).append(" | ").append(arregloB[i]).append(" | ")
                    .append(arregloC[i]).append(" | ").append(menores[i]).append(" | ")
                    .append(arregloPromedios[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, tabla.toString());
        // Mostramos los arreglos y el promedio general
        JOptionPane.showMessageDialog(null, "Arreglo resultante:\n" + CadenaTexto(arregloResultante) +
                "\n\nArreglo de promedios:\n" + CadenaTexto(arregloPromedios) +
                "\n\nPromedio general: " + promedioGeneral);

        // Mostramos los numeros múltiplos de 3 inferiores al promedio general
        StringBuilder multiplosDeTres = new StringBuilder("Numeros multiplos de 3 inferiores al promedio general:\n");
        for (double num : arregloPromedios) {
            if ((int) num % 3 == 0 && num < promedioGeneral) {
                multiplosDeTres.append((int) num).append(", ");
            }
        }
        JOptionPane.showMessageDialog(null, multiplosDeTres.toString());

    }

    // Metodo para llenar un arreglo con numeros aleatorios del 0 al 100
    private static void llenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 101);
        }
    }

    // Metodo para encontrar el numero menor entre tres numeros
    private static int encontrarMenor(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    // Metodo para convertir un arreglo en una cadena de texto
    private static String CadenaTexto(int[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (int num : arreglo) {
            sb.append(num).append(", ");
        }
        return sb.toString();
    }

    // Metodo sobrecargado para convertir un arreglo de dobles en una cadena de texto
    private static String CadenaTexto(double[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (double num : arreglo) {
            sb.append(num).append(", ");
        }
        return sb.toString();
    }
}