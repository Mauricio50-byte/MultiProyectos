import java.util.Scanner;

public class Ejercicio90 {
     /*90. Crear un programa que en base a una matriz y un vector, contar la cantidad de
números primos de ambos. */
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

    public static int contarPrimosEnMatriz(int[][] matriz) {
        int contadorPrimos = 0;
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                if (esPrimo(elemento)) {
                    contadorPrimos++;
                }
            }
        }
        return contadorPrimos;
    }

    public static int contarPrimosEnVector(int[] vector) {
        int contadorPrimos = 0;
        for (int elemento : vector) {
            if (esPrimo(elemento)) {
                contadorPrimos++;
            }
        }
        return contadorPrimos;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Lee la matriz
        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = lector.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz: ");
        int columnas = lector.nextInt();
        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = lector.nextInt();
            }
        }

        System.out.print("Ingrese el tamaño del vector: ");
        int tamanoVector = lector.nextInt();
        int[] vector = new int[tamanoVector];
        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < tamanoVector; i++) {
            vector[i] = lector.nextInt();
        }

        int primosEnMatriz = contarPrimosEnMatriz(matriz);
        int primosEnVector = contarPrimosEnVector(vector);

        System.out.println("Cantidad de números primos en la matriz: " + primosEnMatriz);
        System.out.println("Cantidad de números primos en el vector: " + primosEnVector);
        lector.close();
    }
}
