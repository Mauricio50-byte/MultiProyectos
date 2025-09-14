import java.util.Scanner;

public class Ejercicio95 {
    /*95. Desarrollar un programa que ordene un vector de enteros de mayor a menor. */
      public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la longitud del vector: ");
        int longitud = lector.nextInt();

        int[] vector = new int[longitud];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < longitud; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector[i] = lector.nextInt();
        }

        ordenarVectorDescendente(vector);

        System.out.println("Vector ordenado de mayor a menor:");
        for (int i : vector) {
            System.out.print(i + " ");
        }

        lector.close();
    }

    public static void ordenarVectorDescendente(int[] vector) {
        int n = vector.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (vector[j] > vector[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = vector[maxIndex];
            vector[maxIndex] = vector[i];
            vector[i] = temp;
        }
    }
}
