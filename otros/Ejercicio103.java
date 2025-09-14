import java.util.Scanner;

public class Ejercicio103 {
    /*103. Desarrolle un programa que solicite ingrese tres números distintos e indique de
manera visual en la pantalla cuál de ellos es el número menor ingresado. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        double numero1 = lector.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double numero2 = lector.nextDouble();

        System.out.print("Ingresa el tercer número: ");
        double numero3 = lector.nextDouble();

        double menor = encontrarMenor(numero1, numero2, numero3);

        System.out.println("El número menor ingresado es: " + menor);

        lector.close();
    }

    public static double encontrarMenor(double num1, double num2, double num3) {
        double menor = num1;

        if (num2 < menor) {
            menor = num2;
        }

        if (num3 < menor) {
            menor = num3;
        }

        return menor;
    }
}
