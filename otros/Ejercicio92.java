import java.util.Scanner;

public class Ejercicio92 {
    /*92. Desarrollar un programa que calcule el producto escalar de dos vectores. */
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la longitud de los vectores: ");
        int longitud = lector.nextInt();

        int[] vector1 = new int[longitud];
        int[] vector2 = new int[longitud];

        System.out.println("Ingrese los elementos del primer vector:");
        for (int i = 0; i < longitud; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector1[i] = lector.nextInt();
        }

        System.out.println("Ingrese los elementos del segundo vector:");
        for (int i = 0; i < longitud; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector2[i] = lector.nextInt();
        }

        int productoEscalar = calcularProductoEscalar(vector1, vector2);

        System.out.println("El producto escalar de los vectores es: " + productoEscalar);

        lector.close();
    }

    public static int calcularProductoEscalar(int[] vector1, int[] vector2) {
        int productoEscalar = 0;
        for (int i = 0; i < vector1.length; i++) {
            productoEscalar += vector1[i] * vector2[i];
        }
        return productoEscalar;
    }
}
