import java.util.Scanner;

public class Ejercicio_50{

    /*50.Facilite el ingreso de tres números enteros y/o reales, muestre su respectiva suma
y multiplicación */
    public static void main(String[] args) {
         Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double numero1 = lector.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = lector.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double numero3 = lector.nextDouble();

        double suma = numero1 + numero2 + numero3;
        double multiplicacion = numero1 * numero2 * numero3;

        System.out.println("La suma de los números es: " + suma);
        System.out.println("La multiplicación de los números es: " + multiplicacion);
        lector.close();
    }
}
