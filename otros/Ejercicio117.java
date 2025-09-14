import java.util.Scanner;

public class Ejercicio117 {
    /*117. Escribir un programa que lea números indefinidamente hasta que llegue el
número 0, y antes de finalizar indique la cantidad de números leídos. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int contador = 0;

        System.out.println("Ingrese números (0 para finalizar):");

        while (true) {
            int numero = lector.nextInt();

            if (numero == 0) {
                break;
            }

            contador++;
        }

        System.out.println("Se han ingresado " + contador + " número(s).");

        lector.close();
    }
}
