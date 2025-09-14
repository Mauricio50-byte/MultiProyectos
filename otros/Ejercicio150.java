import java.util.Scanner;

public class Ejercicio150 {
    /*150. Realice un programa que calcule la descomposición en factores primos de un
número entero. Por ejemplo: 20 = 2*2*5. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un numero entero para calcular su descomposición en factores primos: ");
        int numero = lector.nextInt();
        int divisor = 2;

        System.out.print(numero + " = ");

        while (numero > 1) {
            if (numero % divisor == 0) {
                System.out.print(divisor);
                numero = numero / divisor;
                if (numero != 1) {
                    System.out.print("*");
                }
            } else {
                divisor++;
            }
        }

        lector.close();
    }
}
