import java.util.Scanner;

public class Ejercicio_48 {
    /*48.Facilite el ingreso de dos números enteros y/o reales, muestre su suma, resta,
multiplicación, división y el resto (módulo) de la división. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        double numero1 = lector.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = lector.nextDouble();

        double suma = numero1 + numero2;
        double resta = numero1 - numero2;
        double multiplicacion = numero1 * numero2;
        
        if (numero2 != 0) {
            double division = numero1 / numero2;
            double modulo = numero1 % numero2;

            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);
            System.out.println("División: " + division);
            System.out.println("Resto (Módulo): " + modulo);
        } else {
            System.out.println("No se puede dividir por cero.");
            lector.close();
        }
    }
}
