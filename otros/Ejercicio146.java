import java.util.Scanner;

public class Ejercicio146 {
    /*146. Programa que muestre la serie Fibonacci de un número límite indicado por
teclado */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresa el número límite para la serie Fibonacci: ");
        int limite = lector.nextInt();

        int num1 = 0, num2 = 1;
        System.out.println("Serie Fibonacci hasta el límite de " + limite + ":");
        while (num1 <= limite) {
            System.out.print(num1 + " ");
            int suma = num1 + num2;
            num1 = num2;
            num2 = suma;
        }

        lector.close();
    }
}
