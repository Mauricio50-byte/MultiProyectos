import java.util.Scanner;

public class Ejercicio96 {
    /*96. Crear un programa que lea una frase y a continuación visualice cada palabra de la
frase una debajo de otra, seguida cada palabra del número de letras que
componen cada palabra. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese una frase: ");
        String frase = lector.nextLine();

        String[] palabras = frase.split(" ");

        System.out.println("Palabras y sus longitudes:");
        for (String palabra : palabras) {
            System.out.println(palabra);
            System.out.println("Longitud: " + palabra.length());
        }

        lector.close();
    }
}
