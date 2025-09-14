import java.util.Scanner;

public class Actividad_AlgebraIndependeciaLineal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        // Pedimos al usuario la cantidad de vectores y su dimensión
        System.out.print("Ingrese la cantidad de vectores: ");
        int cantidadVectores = lector.nextInt();
        System.out.print("Ingrese la dimensión de los vectores: ");
        int dimension = lector.nextInt();
        
        // Declaramos una matriz para almacenar los vectores
        double[][] matriz = new double[cantidadVectores][dimension];
        
        // Leer los vectores
        for (int i = 0; i < cantidadVectores; i++) {
            System.out.println("Ingrese los elementos del vector " + (i + 1) + ":");
            for (int j = 0; j < dimension; j++) {
                System.out.print("Elemento " + (j + 1) + ": ");
                matriz[i][j] = lector.nextDouble();
            }
        }
        
        // Verificamos la independencia lineal
        boolean esIndependiente = verificarIndependenciaLineal(matriz);
        
        // Mostramos el resultado
        if (esIndependiente) {
            System.out.println("Los vectores son linealmente independientes.");
        } else {
            System.out.println("Los vectores no son linealmente independientes.");
        }
        lector.close();
    }
    
    public static boolean verificarIndependenciaLineal(double[][] matriz) {
        int cantidadVectores = matriz.length;
        int dimension = matriz[0].length;
        
        if (cantidadVectores > dimension) {
            return false; // Si hay más vectores que dimensiones, son linealmente dependientes
        }
        
        // Creamos una matriz ampliada
        double[][] matrizAmpliada = new double[cantidadVectores][dimension + 1];
        for (int i = 0; i < cantidadVectores; i++) {
            for (int j = 0; j < dimension; j++) {
                matrizAmpliada[i][j] = matriz[i][j];
            }
        }
        
        // Resolvemos el sistema ecuaciones con el metodo de Gauss-Jordan
        for (int k = 0; k < cantidadVectores; k++) {
            for (int i = 0; i < cantidadVectores; i++) {
                if (i != k) {
                    double factor = matrizAmpliada[i][k] / matrizAmpliada[k][k];
                    for (int j = k; j < dimension + 1; j++) {
                        matrizAmpliada[i][j] -= factor * matrizAmpliada[k][j];
                    }
                }
            }
        }
        
        // Verificamos si hay una fila de ceros en la parte aumentada
        for (int i = 0; i < cantidadVectores; i++) {
            boolean filaNula = true;
            for (int j = 0; j < dimension; j++) {
                if (matrizAmpliada[i][j] != 0) {
                    filaNula = false;
                    break;
                }
            }
            if (filaNula && matrizAmpliada[i][dimension] != 0) {
                return false; // Hay una fila nula no nula
            }
        }
        
        return true; // No se encontraron filas nulas no nulas
    }
}
