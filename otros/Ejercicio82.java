import java.util.Scanner;

public class Ejercicio82 {
    /*82. Desarrolle el código fuente de un programa que permita ingresar un número y
visualizar si es positivo o negativo. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        double numero = lector.nextDouble();

        if (numero > 0) {
            System.out.println("El número ingresado es positivo.");
        } else if (numero < 0) {
            System.out.println("El número ingresado es negativo.");
        } else {
            System.out.println("El número ingresado es cero.");
        }
        lector.close();
    }
}
