import java.util.Scanner;

public class Actividad_Algebra {
    private static final int[][] RestaMatriz = null;
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int filas, columnas;

        System.out.print("Ingrese el numero de filas de la matriz (A): ");
        filas = lector.nextInt();
        System.out.print("Ingrese el numero de columnas para la matriz (A): ");
        columnas = lector.nextInt();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        int[][] matrizA = new int[filas][columnas];

        
        int filasMB, columnasMB;

        System.out.print("Ingrese el numero de filas de la matriz (B): ");
        filasMB = lector.nextInt();
        System.out.print("Ingrese el numero de columnas para la matriz (B): ");
        columnasMB = lector.nextInt();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        int[][] matrizB = new int[filasMB][columnasMB];

        
        int filasMC, columnasMC;

        System.out.print("Ingrese el numero de filas de la matriz (C): ");
        filasMC = lector.nextInt();
        System.out.print("Ingrese el numero de columnas para la matriz (C): ");
        columnasMC = lector.nextInt();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        int[][] matrizC = new int[filasMC][columnasMC];

        Pausa();

        LimpiarPantalla();

        LlenarMatrizes("A", matrizA, lector);
        mostrarMatriz("A", matrizA);
        LlenarMatrizes("B", matrizB, lector);
        mostrarMatriz("B", matrizB);
        LlenarMatrizes("C", matrizC, lector);
        mostrarMatriz("C", matrizC);

        Pausa();

        LimpiarPantalla();

        boolean continuar = true;
        while (continuar) {

            System.out.println("Menu CRUD:");
            System.out.println("1. Sumar A + B + C");
            System.out.println("2. Sumar A + B");
            System.out.println("3. Restar A - B");
            System.out.println("4. Restar A - C");
            System.out.println("5. Restar B - C");
            System.out.println("6. Producto A * B");
            System.out.println("7. Producto A * C");
            System.out.println("8. Producto B * C");
            System.out.println("9. Producto Escalar de A");
            System.out.println("10. Producto Escalar de B");
            System.out.println("11. Producto Escalar de A + B + C");
            System.out.println("12. Inversa de A");
            System.out.println("13. Inversa de C");
            System.out.println("14. Inversa de B");
            System.out.println("15. Independecia lineal");
            System.out.println("16. Salir");

            System.out.print("Seleccione una operación (1-16): ");
            int opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    LimpiarPantalla();
                    SumaMatrizABC(matrizA, matrizB, matrizC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 2:
                    LimpiarPantalla();
                    SumaMatrizAB(matrizA, matrizB);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 3:
                    LimpiarPantalla();
                    RestaMatrizAB(matrizA, matrizB);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 4:
                    LimpiarPantalla();
                    RestaMatrizAC(matrizA, matrizC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 5:
                    LimpiarPantalla();
                    RestaMatrizBC(matrizB, matrizC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 6:
                    LimpiarPantalla();
                    ProductoDeMatrizesAB(matrizA, matrizB);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 7:
                    LimpiarPantalla();
                    ProductoDeMatricesBC(matrizB, matrizC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 8:
                    LimpiarPantalla();
                    ProductoDeMatrizesAC(matrizA, matrizC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 9:
                    LimpiarPantalla();
                    System.out.print("Ingrese el escalar para la matriz A: ");
                    int escalarA = lector.nextInt();
                    ProductoEscalarM1(matrizA, escalarA);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 10:
                    LimpiarPantalla();
                    System.out.print("Ingrese el escalar para la matriz B: ");
                    int escalarB = lector.nextInt();
                    ProductoEscalarM2(matrizB, escalarB);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 11:
                    LimpiarPantalla();
                    System.out.print("Ingrese el escalar para A + B + C: ");
                    int escalarABC = lector.nextInt();
                    ProductoEscalar(SumaMatrizABC(matrizA, matrizB, matrizC), escalarABC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 12:
                    LimpiarPantalla();
                    inverzaMatrizA(matrizA);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 13:
                    LimpiarPantalla();
                    inverzaMatrizC(matrizC);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 14:
                    LimpiarPantalla();
                    inverzaMatrizB(matrizB);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 15:
                    LimpiarPantalla();
                    Actividad_AlgebraIndependeciaLineal.main(args);
                    continuar = false; // Añadir esta línea para salir del bucle
                    break;
                case 16:
                    continuar = false;
                    LimpiarPantalla();
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        lector.close();
    }
    public static void LlenarMatrizes(String nombre, int[][] matriz, Scanner lector) {
        System.out.println("Ingrese los valores para la matriz " + nombre + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(nombre + "[" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = lector.nextInt();
            }
        }
        System.out.println("........................................................");
    }
    public static void mostrarMatriz(String nombre, int[][] matriz) {
        System.out.println("        "+nombre);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    } 
    static int[][] matrizSuma;
    public static int[][] SumaMatrizABC(int [][] matriz1 , int [][]matriz2, int [][] matriz3){
        System.out.println("SUMA DE A + B + C:");
        int filas = matriz1.length;
        int columnas = matriz1[0].length;

        if (filas != matriz2.length || filas != matriz3.length || columnas != matriz2[0].length || columnas != matriz3[0].length) {
            // throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            System.out.println("Las matrices deben tener las mismas dimensiones");

            return null;

        }else{

            matrizSuma = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j] + matriz3[i][j];
                }
            }
            //inprimimos la Matriz1 resultante
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matrizSuma[i][j] + "  ");
                }
                System.out.println();
            }

        return matrizSuma;

        }

    }
    public static int[][] SumaMatrizAB(int[][] matriz1, int[][] matriz2) {
        System.out.println("SUMA DE A + B: ");
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        if (filas != matriz2.length || columnas != matriz1[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones");
            // throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            return null;
        }else{

            int[][] matrizSuma = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
            for (int i = 0; i < matrizSuma.length; i++) {
                for (int j = 0; j < matrizSuma[0].length; j++) {
                    System.out.print(matrizSuma[i][j] + "   ");
                }
                System.out.println();
            }

        return matrizSuma;

        }
    
    }
    public static int[][] RestaMatrizAB(int [][] matriz1 , int [][]matriz2){
        System.out.println("RESTA DE A - B: ");
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        if (filas != matriz2.length || columnas != matriz1[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones");
            //  throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            return null;
        }else{

            int[][] RestaMatriz = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    RestaMatriz[i][j] = matriz1[i][j] - matriz2[i][j];
                }
            }
            for (int i = 0; i < RestaMatriz.length; i++) {
                for (int j = 0; j < RestaMatriz[0].length; j++) {
                    System.out.print(RestaMatriz[i][j] + "   ");
                }
                System.out.println();
            }

        return RestaMatriz ;

        }
    }
    public static int[][] RestaMatrizAC(int[][] matriz1, int[][] matriz3) {
        System.out.println("RESTA DE A - C: ");
        int filas = matriz1.length;
        int columnas = matriz1[0].length;

        if (filas != matriz3.length || columnas != matriz3[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones");
            //throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            return null;
        }else{

            int[][] RestaMatriz = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    RestaMatriz[i][j] = matriz1[i][j] - matriz3[i][j];
                }
            }

            for (int i = 0; i < RestaMatriz.length; i++) {
                for (int j = 0; j < RestaMatriz[0].length; j++) {
                    System.out.print(RestaMatriz[i][j] + "   ");
                }
                System.out.println();
            }

        return RestaMatriz;

        }

    }
    public static int[][] RestaMatrizBC(int[][] matriz2, int[][] matriz3) {
        System.out.println("RESTA DE B - C: ");
        int filas = matriz2.length;
        int columnas = matriz2[0].length;

        if (filas != matriz3.length || columnas != matriz3[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones");
            //throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            return null;
        }else{

            int[][] RestarMatriz = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    RestarMatriz[i][j] = matriz2[i][j] - matriz3[i][j];
                }
            }

            for (int i = 0; i < RestarMatriz.length; i++) {
                for (int j = 0; j < RestarMatriz[0].length; j++) {
                    System.out.print(RestarMatriz[i][j] + "   ");
                }
                System.out.println();
            }

        return RestaMatriz;

        }
    
    }
    public static int[][] ProductoDeMatrizesAB(int [][] matriz1 , int [][]matriz2){
        System.out.println("RESTA DE A * B: ");
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        if (filas != matriz2.length || columnas != matriz1[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones");
            // throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            return null;
        }else{

            int[][] productoDeMatrizesAB = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    productoDeMatrizesAB[i][j] = matriz1[i][j] * matriz2[i][j];
                }
            }
            for (int i = 0; i < productoDeMatrizesAB.length; i++) {
                for (int j = 0; j < productoDeMatrizesAB[0].length; j++) {
                    System.out.print(productoDeMatrizesAB[i][j] + "   ");
                }
                System.out.println();
            }

            return productoDeMatrizesAB; // Devolver la matriz resultante
        }
    }
    public static Object ProductoDeMatrizesAC(int[][] matriz1, int[][] matriz3) {
        System.out.println("RESTA DE A * C: ");
        int filas = matriz1.length;
        int columnas = matriz1[0].length;

        if (filas != matriz3.length || columnas != matriz3[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones");
           // throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
            return null;

        }else{

            int[][] productoDeMatrizesAC = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    productoDeMatrizesAC[i][j] = matriz1[i][j] * matriz3[i][j];
                }
            }

            for (int i = 0; i < productoDeMatrizesAC.length; i++) {
                for (int j = 0; j < productoDeMatrizesAC[0].length; j++) {
                    System.out.print(productoDeMatrizesAC[i][j] + "   ");
                }
                System.out.println();
            }

        return productoDeMatrizesAC;

        }
    }
    public static int[][] ProductoDeMatricesBC(int[][] matriz2, int[][] matriz3) {
        System.out.println("PRODUCTO DE B * C:");
        int filasB = matriz2.length;
        int columnasB = matriz2[0].length;
        int filasC = matriz3.length;
        int columnasC = matriz3[0].length;
    
        if (columnasB != filasC) {
            System.out.println("El número de columnas de B debe ser igual al número de filas de C");
            return null;
        } else {
            int[][] productoDeMatrizBC = new int[filasB][columnasC];
            for (int i = 0; i < filasB; i++) {
                for (int j = 0; j < columnasC; j++) {
                    productoDeMatrizBC[i][j] = 0;
                    for (int k = 0; k < columnasB; k++) {
                        productoDeMatrizBC[i][j] += matriz2[i][k] * matriz3[k][j];
                    }
                }
            }
    
            for (int i = 0; i < filasB; i++) {
                for (int j = 0; j < columnasC; j++) {
                    System.out.print(productoDeMatrizBC[i][j] + "   ");
                }
                System.out.println();
            }
    
            return productoDeMatrizBC;
        }
    }
    public static int[][] ProductoEscalarM1(int[][] matriz, int escalar) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.err.println("Error: La matriz de entrada no es válida para el producto escalar.");
            return null;
        }
    
        int filas = matriz.length;
        int columnas = matriz[0].length;
    
        int[][] resultado = new int[filas][columnas];
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
    
        System.out.println("Matriz Producto Escalar de A * " + escalar + ":");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(resultado[i][j] + "     ");
            }
            System.out.println();
        }
    
        return resultado;
    }
    
    public static int[][] ProductoEscalarM2(int[][] matriz, int escalar) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.err.println("Error: La matriz de entrada no es válida para el producto escalar.");
            return null;
        }
    
        int filas = matriz.length;
        int columnas = matriz[0].length;
    
        int[][] resultado = new int[filas][columnas];
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
    
        System.out.println("Matriz Producto Escalar de B * " + escalar + ":");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(resultado[i][j] + "     ");
            }
            System.out.println();
        }
    
        return resultado;
    }
    public static int[][] ProductoEscalar(int[][] matriz, int escalar) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.err.println("Error: La matriz de entrada no es válida para el producto escalar.");
            return null;
        }
    
        int filas = matriz.length;
        int columnas = matriz[0].length;
    
        int[][] resultado = new int[filas][columnas];
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
    
        System.out.println("Matriz Producto Escalar * " + escalar + ":");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(resultado[i][j] + "     ");
            }
            System.out.println();
        }
    
        return resultado;
    }
    public static int[][] inverzaMatrizA(int[][] matriz1) {
        if (matriz1 == null || matriz1.length == 0 || matriz1.length != matriz1[0].length) {
            System.err.println("Error: La matriz de entrada no es válida para la inversión.");
            return null;
        }
    
        int n = matriz1.length;
        int[][] matrizAumentada = new int[n][n * 2];
    
        // Crear la matriz aumentada [ A | I ]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAumentada[i][j] = matriz1[i][j];
                matrizAumentada[i][j + n] = (i == j) ? 1 : 0;
            }
        }
    
        // Aplicar la eliminación de Gauss-Jordan para transformar la matriz A en la matriz identidad
        for (int i = 0; i < n; i++) {
            int pivote = matrizAumentada[i][i];
    
            if (pivote == 0) {
                System.err.println("Error: La matriz es singular, no tiene inversa.");
                return null;
            }
    
            for (int j = 0; j < 2 * n; j++) {
                matrizAumentada[i][j] /= pivote;
            }
    
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    int factor = matrizAumentada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        matrizAumentada[k][j] -= factor * matrizAumentada[i][j];
                    }
                }
            }
        }
    
        // Extraer la matriz inversa de la matriz aumentada
        int[][] matrizInversa = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizInversa[i][j] = matrizAumentada[i][j + n];
            }
        }
    
        System.out.println("Inversa de la Matriz A:");
        for (int i = 0; i < matrizInversa.length; i++) {
            for (int j = 0; j < matrizInversa[0].length; j++) {
                System.out.print(matrizInversa[i][j] + "   ");
            }
            System.out.println();
        }
    
        return matrizInversa;
    }
    public static int[][] inverzaMatrizC(int[][] matriz3) {
        if (matriz3 == null || matriz3.length == 0 || matriz3.length != matriz3[0].length) {
            System.err.println("Error: La matriz de entrada no es válida para la inversión.");
            return null;
        }
    
        int n = matriz3.length;
        int[][] matrizAumentada = new int[n][n * 2];
    
        // Crear la matriz aumentada [ A | I ]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAumentada[i][j] = matriz3[i][j];
                matrizAumentada[i][j + n] = (i == j) ? 1 : 0;
            }
        }
    
        // Aplicar la eliminación de Gauss-Jordan para transformar la matriz A en la matriz identidad
        for (int i = 0; i < n; i++) {
            int pivote = matrizAumentada[i][i];
    
            if (pivote == 0) {
                System.err.println("Error: La matriz es singular, no tiene inversa.");
                return null;
            }
    
            for (int j = 0; j < 2 * n; j++) {
                matrizAumentada[i][j] /= pivote;
            }
    
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    int factor = matrizAumentada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        matrizAumentada[k][j] -= factor * matrizAumentada[i][j];
                    }
                }
            }
        }
    
        // Extraer la matriz inversa de la matriz aumentada
        int[][] matrizInversa = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizInversa[i][j] = matrizAumentada[i][j + n];
            }
        }
    
        System.out.println("Inversa de la Matriz C:");
        for (int i = 0; i < matrizInversa.length; i++) {
            for (int j = 0; j < matrizInversa[0].length; j++) {
                System.out.print(matrizInversa[i][j] + "   ");
            }
            System.out.println();
        }
    
        return matrizInversa;
    }
    public static int[][] inverzaMatrizB(int[][] matriz2) {
        if (matriz2 == null || matriz2.length == 0 || matriz2.length != matriz2[0].length) {
            System.err.println("Error: La matriz de entrada no es válida para la inversión.");
            return null; // O podrías devolver una matriz especial que indique un problema
        }
    
        int n = matriz2.length;
        int[][] matrizAumentada = new int[n][n * 2];
    
        // Crear la matriz aumentada [ A | I ]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAumentada[i][j] = matriz2[i][j];
                matrizAumentada[i][j + n] = (i == j) ? 1 : 0;
            }
        }
    
        // Aplicar la eliminación de Gauss-Jordan para transformar la matriz A en la matriz identidad
        for (int i = 0; i < n; i++) {
            int pivote = matrizAumentada[i][i];
    
            if (pivote == 0) {
                System.err.println("Error: La matriz es singular, no tiene inversa.");
                return null; // O podrías devolver una matriz especial que indique un problema
            }
    
            for (int j = 0; j < 2 * n; j++) {
                matrizAumentada[i][j] /= pivote;
            }
    
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    int factor = matrizAumentada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        matrizAumentada[k][j] -= factor * matrizAumentada[i][j];
                    }
                }
            }
        }
    
        // Extraer la matriz inversa de la matriz aumentada
        int[][] matrizInversa = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizInversa[i][j] = matrizAumentada[i][j + n];
            }
        }
    
        System.out.println("Inversa de la Matriz B:");
        for (int i = 0; i < matrizInversa.length; i++) {
            for (int j = 0; j < matrizInversa[0].length; j++) {
                System.out.print(matrizInversa[i][j] + "   ");
            }
            System.out.println();
        }
    
        return matrizInversa;
    }
    public static void LimpiarPantalla() {
        try {
            ProcessBuilder limpiar = new ProcessBuilder("cmd", "/c", "cls");
            Process staProcess = limpiar.inheritIO().start();
            staProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Pausa() {
        try {
            System.out.println("\nPulse enter para continuar...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
