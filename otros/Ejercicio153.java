import java.util.Scanner;

public class Ejercicio153 {
    /*153. Pedir al usuario que digite 2 cadenas de caracteres, e indicar si ambas cadenas
son iguales, en caso de no serlo, indicar cuál es mayor alfabéticamente. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingresa la primera cadena de caracteres: ");
        String cadena1 = lector.nextLine();

        System.out.println("Ingresa la segunda cadena de caracteres: ");
        String cadena2 = lector.nextLine();

        if (cadena1.equals(cadena2)) {
            System.out.println("Las cadenas son iguales.");
        } else {
            System.out.println("Las cadenas son diferentes.");

            int comparacion = cadena1.compareTo(cadena2);

            if (comparacion < 0) {
                System.out.println("La cadena '" + cadena1 + "' es mayor alfabéticamente que '" + cadena2 + "'.");
            } else {
                System.out.println("La cadena '" + cadena2 + "' es mayor alfabéticamente que '" + cadena1 + "'.");
            }
        }

        lector.close();
    }
}
