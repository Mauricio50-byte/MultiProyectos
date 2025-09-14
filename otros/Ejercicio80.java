import java.util.Scanner;

public class Ejercicio80 {
    /*80. Desarrolle el código fuente de un programa que permita ingresar un dato entero y
un dato real y visualizar los datos ingresados. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un dato entero: ");
        int datoEntero = lector.nextInt();

        System.out.print("Ingrese un dato real: ");
        double datoReal = lector.nextDouble();

        // Mostrar los datos ingresados
        System.out.println("Dato entero ingresado: " + datoEntero);
        System.out.println("Dato real ingresado: " + datoReal);
        lector.close();
    }
}
