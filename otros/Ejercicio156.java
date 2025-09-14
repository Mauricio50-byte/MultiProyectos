import java.util.Scanner;

public class Ejercicio156 {
    /*156. Convertir dos cadenas de minúsculas a MAYÚSCULAS. Compararlas, y decir si
son iguales o no. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingresa la primera cadena en minúsculas: ");
        String cadena1 = lector.nextLine();

        System.out.println("Ingresa la segunda cadena en minúsculas: ");
        String cadena2 = lector.nextLine();

        String mayusculasCadena1 = cadena1.toUpperCase();
        String mayusculasCadena2 = cadena2.toUpperCase();

        System.out.println("Cadena 1 en mayúsculas: " + mayusculasCadena1);
        System.out.println("Cadena 2 en mayúsculas: " + mayusculasCadena2);

        if (mayusculasCadena1.equals(mayusculasCadena2)) {
            System.out.println("Las cadenas en mayúsculas son iguales.");
        } else {
            System.out.println("Las cadenas en mayúsculas son diferentes.");
        }

        lector.close();
    }
}
