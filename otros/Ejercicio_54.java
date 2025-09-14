import java.util.Scanner;

public class Ejercicio_54 {
    /*54.Permite introducir una medida expresada en centímetros y la convierte en pulgadas
(1pulgada = 2,54 centímetros). */
     public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce una medida en centímetros: ");
        double centimeters = lector.nextDouble();

        double inches = centimeters / 2.54;

        System.out.println(centimeters + " centímetros equivalen a " + inches + " pulgadas.");
        lector.close();
    }
}