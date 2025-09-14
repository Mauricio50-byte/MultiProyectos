import java.util.Scanner;

public class Ejercicio170 {
    /*170. Programa que realice la suma y resta de 2 fracciones, el numerador y
denominador de cada una serán capturados por el usuario. Ambas fracciones
deberán tener el mismo denominador. Ejemplo 2/6 + 8/6 = ¿?. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese el numerador de la primera fracción:");
        int numerador1 = lector.nextInt();
        System.out.println("Ingrese el denominador de la primera fracción:");
        int denominador1 = lector.nextInt();

        System.out.println("Ingrese el numerador de la segunda fracción:");
        int numerador2 = lector.nextInt();
        System.out.println("Ingrese el denominador de la segunda fracción:");
        int denominador2 = lector.nextInt();
        lector.close();

        if (denominador1 != denominador2) {
            System.out.println("Las fracciones deben tener el mismo denominador.");
            return;
        }

        int sumaNumerador = numerador1 + numerador2;
        int denominadorComun = denominador1;

        int restaNumerador = numerador1 - numerador2;

        System.out.println("Suma: " + sumaNumerador + "/" + denominadorComun);
        System.out.println("Resta: " + restaNumerador + "/" + denominadorComun);
    }
}
