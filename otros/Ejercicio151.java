import java.util.Scanner;

public class Ejercicio151 {
    /*151. Hacer un programa que pida al usuario que digite una cadena de caracteres,
luego verificar la longitud de la cadena, y si ésta supera a 10 caracteres mostrarla
en pantalla, caso contrario no mostrarla. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Por favor, ingresa una cadena de caracteres:");
        String cadena = lector.nextLine();

        if (cadena.length() > 10) {
            System.out.println("La cadena supera los 10 caracteres: " + cadena);
        } else {
            System.out.println("La cadena no supera los 10 caracteres.");
        }

        lector.close();
    }
}
