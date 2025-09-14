import java.util.Scanner;

public class Ejercicio143 {
    /*143. Programa que realice la suma de los números pares comprendidos entre 1 y el
100. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int suma = 0;

        for (int i = 2; i <= 100; i += 2) {
            suma += i;
        }

        System.out.println("La suma de los números pares entre 1 y 100 es: " + suma);

        lector.close();
    }
}
