import java.util.Scanner;

public class Ejercicio159 {
    /*159. Programa que pueda determinar si un número es primo (un número primo es
aquel que solo es divisible entre la unidad y él mismo por ejemplo el 7). */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingresa un número para verificar si es primo: ");
        int numero = lector.nextInt();

        lector.close(); 

        boolean esPrimo = true;

        if (numero <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }
    }
}
