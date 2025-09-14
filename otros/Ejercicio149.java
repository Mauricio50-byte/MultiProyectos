import java.util.Random;
import java.util.Scanner;

public class Ejercicio149 {
    /*149. Realice un programa que solicite al usuario que piense un número entero entre
el 1 y el 100. El programa debe generar un número aleatorio en ese mismo rango
[1-100], e indicarle al usuario si el número que dígito es menor o mayor al número
aleatorio, así hasta que lo adivine. Y por último mostrarle el número de intentos que
le llevó. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        int intentos = 0;
        int numeroUsuario;

        System.out.println("Piensa en un numero entre 1 y 100.");

        do {
            System.out.print("Intenta adivinar el numero: ");
            numeroUsuario = lector.nextInt();
            intentos++;

            if (numeroUsuario > numeroAleatorio) {
                System.out.println("El número es menor.");
            } else if (numeroUsuario < numeroAleatorio) {
                System.out.println("El número es mayor.");
            } else {
                System.out.println("¡Felicidades! Has adivinado el numero.");
            }
        } while (numeroUsuario != numeroAleatorio);

        System.out.println("Número de intentos: " + intentos);
        lector.close();
    }
}
