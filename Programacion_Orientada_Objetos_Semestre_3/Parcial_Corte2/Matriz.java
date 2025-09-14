package Parcial_Corte2;

/*Crear un programa que ingrese los datos en una matriz, solicite una de las letras: X;N.
la dibuje en la matriz y calcule el promedio de los numeros que conforme la letra
*EL numero de fila y columnas debe ser igual
*solo debe permitir filas y columnas igual y mayor de 3 */ 

import java.util.Scanner;

public class Matriz {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitamos al usuario el tamaño de la matriz
        System.out.println("Ingrese el tamaño de la matriz (debe ser igual o mayor que 3):");
        int tamaño = scanner.nextInt();
        
        // Verificamos que el tamaño sea igual o mayor que 3
        if (tamaño < 3) {
            System.out.println("El tamaño de la matriz debe ser igual o mayor que 3. Por favor, intente nuevamente.");
            return;
        }
        
        int[][] matriz = new int[tamaño][tamaño];
        
        // Solicitamos al usuario ingresar los datos en la matriz
        System.out.println("Ingrese los datos en la matriz:");
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        // Solicitamos al usuario elegir una letra (X o N)
        System.out.println("Ingrese la letra que desea dibujar en la matriz (X o N):");
        char letra = scanner.next().charAt(0);
        
        // Verificamos si la letra ingresada es valida
        if (letra != 'X' && letra != 'N') {
            System.out.println("La letra ingresada no es valida. Por favor, ingrese X o N.");
            return;
        }
        
        // Dibujamos la letra en la matriz y calculamos el promedio
        int suma = 0;
        int contador = 0;
        
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (letra == 'X') {
                    if (i == j || i + j == tamaño - 1) {
                        System.out.print("X ");
                        suma += matriz[i][j];
                        contador++;
                    } else {
                        System.out.print(matriz[i][j] + " ");
                    }
                } else if (letra == 'N') {
                    if (i == 0 || j == 0 || i == tamaño - 1 || j == tamaño - 1 || i == j) {
                        System.out.print("N ");
                        suma += matriz[i][j];
                        contador++;
                    } else {
                        System.out.print(matriz[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
        
        // Calculamos el promedio
        double promedio = (double) suma / contador;
        System.out.println("El promedio de los numeros que conforman la letra " + letra + " es: " + promedio);
        
        scanner.close();
    }

}

