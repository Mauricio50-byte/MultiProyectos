import java.util.Scanner;

public class Ejercicio157 {
    /*157. Pedir su nombre al usuario en MAYÚSCULA, si su nombre comienza por la letra
A, convertir su nombre a minúsculas, caso contrario no convertirlo. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingresa tu nombre en MAYÚSCULAS: ");
        String nombre = lector.nextLine();

        if (nombre.startsWith("A")) {
            String nombreMinusculas = nombre.toLowerCase();
            System.out.println("Tu nombre convertido a minúsculas: " + nombreMinusculas);
        } else {
            System.out.println("Tu nombre no comienza con la letra 'A', no se realizaron cambios.");
        }

        lector.close();
    }
}
