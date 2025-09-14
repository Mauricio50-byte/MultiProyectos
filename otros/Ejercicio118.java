import java.util.Scanner;

public class Ejercicio118 {
    /*118. Escribir un programa que pida los montos de 10 artículos (de una tienda) y
muestre en pantalla el monto total a pagar. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        double totalPagar = 0;

        System.out.println("Ingrese el monto de cada artículo:");

        for (int i = 1; i <= 10; i++) {
            System.out.print("Monto del artículo " + i + ": $");
            double montoArticulo = lector.nextDouble();
            totalPagar += montoArticulo;
        }

        System.out.println("El monto total a pagar es: $" + totalPagar);

        lector.close();
    }
}
