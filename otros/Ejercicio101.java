import java.util.Scanner;

public class Ejercicio101 {
    /*101. Determinar si un número entero es divisible por otro e imprimir divisible, caso
contrario visualizar no es divisible. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce el primer número entero: ");
        int numero1 = lector.nextInt();

        System.out.print("Introduce el segundo número entero: ");
        int numero2 = lector.nextInt();

        if (esDivisible(numero1, numero2)) {
            System.out.println(numero1 + " es divisible por " + numero2);
        } else {
            System.out.println(numero1 + " no es divisible por " + numero2);
        }
        lector.close();
    }

    public static boolean esDivisible(int numero1, int numero2) {
        return numero1 % numero2 == 0;
    }
}
