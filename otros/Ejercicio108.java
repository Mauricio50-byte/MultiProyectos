import java.util.Scanner;

public class Ejercicio108 {
    /*108. Programa que determine si un número dado por el usuario es par o impar. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número
        System.out.print("Ingrese un número: ");
        int numero = lector.nextInt();

        // Determinar si el número es par o impar
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar.");
        }

        // Cerrar el scanner
        lector.close();
    }
}
