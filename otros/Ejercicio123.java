import java.util.Scanner;

public class Ejercicio123 {
    /*123. Programa que calcula el capital final de un interés simple de forma diaria, de
acuerdo a los datos dados por el usuario(capital, interés y días). El resultado se
mostrará en pantalla. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el capital inicial: ");
        double capital = lector.nextDouble();

        System.out.print("Ingrese la tasa de interés diaria (%): ");
        double tasaInteres = lector.nextDouble() / 100;

        System.out.print("Ingrese el número de días: ");
        int dias = lector.nextInt();

        // Calcular el capital final con interés simple
        double capitalFinal = capital * (1 + tasaInteres * dias);

        System.out.println("El capital final con interés simple es: " + capitalFinal);

        lector.close();
    }
}
