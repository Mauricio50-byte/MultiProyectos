import java.util.Scanner;

public class Ejercicio94 {
    /*94. Determinar e imprimir el valor absoluto de un número entero. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int numero = lector.nextInt();

        int valorAbsoluto = calcularValorAbsoluto(numero);

        System.out.println("El valor absoluto de " + numero + " es: " + valorAbsoluto);

        lector.close();
    }

    public static int calcularValorAbsoluto(int numero) {
        return numero < 0 ? -numero : numero;
    }
}
