import java.util.Scanner;

public class Ejercicio144 {
    /*144. Programa que realice la suma de los números pares y la multiplicación de los
impares comprendidos entre 1 y el 100. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int sumaPares = 0;
        long multiplicacionImpares = 1;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            } else {
                multiplicacionImpares *= i;
            }
        }

        System.out.println("La suma de los números pares entre 1 y 100 es: " + sumaPares);
        System.out.println("La multiplicación de los números impares entre 1 y 100 es: " + multiplicacionImpares);

        lector.close();
    }
}
