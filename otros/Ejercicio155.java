import java.util.Scanner;

public class Ejercicio155 {
    //155. Hacer un programa que determine si una palabra es palíndroma.
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese una palabra para verificar si es un palíndromo: ");
        String palabra = lector.nextLine();

        if (PalabraPalindromo(palabra)) {
            System.out.println("La palabra '" + palabra + "' es un palíndromo.");
        } else {
            System.out.println("La palabra '" + palabra + "' no es un palíndromo.");
        }

        lector.close();
    }

    public static boolean PalabraPalindromo(String palabra) {
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
