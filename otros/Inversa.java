import java.util.Scanner;
public class Inversa {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de filas de las matrices: ");
        int filas = scanner.nextInt();

        System.out.print("Ingrese el número de columnas de las matrices: ");
        int columnas = scanner.nextInt();

        int[][] matriz1 = new int[filas][columnas];
        int[][] matriz2 = new int[filas][columnas];

        System.out.println("Ingrese la primera matriz:");
        llenarMatriz(scanner, matriz1);

        System.out.println("Ingrese la segunda matriz:");
        llenarMatriz(scanner, matriz2);

        int[][] sumaMatrices = sumarMatrices(matriz1, matriz2);
        int[][] inversaSumaMatrices = invertirMatriz(sumaMatrices);

        System.out.println("-------------------------------------------------------");
        System.out.println("Inversa de la suma de las matrices:");
        mostrarMatriz(inversaSumaMatrices);

        boolean sonLinealmenteIndependientes = calcularIndependenciaLineal(matriz1, matriz2);
        System.out.println("Las matrices son linealmente independientes: " + sonLinealmenteIndependientes);
    }

    private static void llenarMatriz(Scanner scanner, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Ingrese el elemento en la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    private static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] sumaMatrices = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sumaMatrices[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return sumaMatrices;
    }

    private static int[][] invertirMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] inversaMatriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                inversaMatriz[i][j] = -matriz[i][j];
            }
        }

        return inversaMatriz;
    }

    private static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean calcularIndependenciaLineal(int[][] matriz1, int[][] matriz2) {
        int determinanteMatriz1 = calcularDeterminante(matriz1);
        int determinanteMatriz2 = calcularDeterminante(matriz2);

        return (determinanteMatriz1 != 0) && (determinanteMatriz2 != 0);
    }

    private static int calcularDeterminante(int[][] matriz) {
        if (matriz.length != matriz[0].length) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada para calcular el determinante.");
        }

        int n = matriz.length;

        if (n == 1) {
            return matriz[0][0];
        }

        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        int determinante = 0;

        for (int j = 0; j < n; j++) {
            determinante += matriz[0][j] * cofactor(matriz, 0, j);
        }

        return determinante;
    }

    private static int cofactor(int[][] matriz, int fila, int columna) {
        return (int) Math.pow(-1, fila + columna) * calcularDeterminante(submatriz(matriz, fila, columna));
    }

    private static int[][] submatriz(int[][] matriz, int fila, int columna) {
        int n = matriz.length;
        int[][] submatriz = new int[n - 1][n - 1];

        int datos = 0;
        for (int i = 0; i < n; i++) {
            if (i == fila) continue;

            int datico = 0;
            for (int j = 0; j < n; j++) {
                if (j == columna) continue;

                submatriz[datos][datico] = matriz[i][j];
                datico++;
            }

            datos++;
        }

        return submatriz;
    }
}
