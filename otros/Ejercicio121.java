import java.util.Scanner;

public class Ejercicio121 {
    /*121. Programa que pida 5 números al usuario y muestre en pantalla la suma total de
todos ellos. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int suma = 0;

        System.out.println("Ingrese 5 números:");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Número " + i + ": ");
            int numero = lector.nextInt();
            suma += numero;
        }

        System.out.println("La suma total de los 5 números es: " + suma);

        lector.close();
    }
}
