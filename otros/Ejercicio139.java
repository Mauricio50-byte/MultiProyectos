import java.util.Scanner;

public class Ejercicio139 {
    /*139. Programa para calcular el factorial de un número N dado por el usuario.(
Ejemplo: Factorial de 5 = 1x2x3x4x5 , Factorial de 8=1x2x3x4x5x6x7x8) . */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un número para calcular su factorial: ");
        int numero = lector.nextInt();

        lector.close();

        long factorial = calcularFactorial(numero);
        System.out.println("Factorial de " + numero + " = " + factorial);
    }

    public static long calcularFactorial(int numero) {
        if (numero < 0) {
            System.err.println("El factorial no está definido para números negativos.");
            return -1;  // Devolvemos -1 para indicar un error
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
