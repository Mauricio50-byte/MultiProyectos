import java.util.Scanner;

public class Ejercicio107 {
    /*107. Programa que de acuerdo al dato de la edad, indicado por el usuario, determine
si una persona es mayor o menor de edad, incluir una verificación para que solo se
acepten valores entre 1 y 100. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int edad;

        do {
            System.out.print("Ingrese la edad (entre 1 y 100): ");
            edad = lector.nextInt();

            if (edad < 1 || edad > 100) {
                System.out.println("La edad debe estar entre 1 y 100. Intente nuevamente.");
            }
        } while (edad < 1 || edad > 100);

        if (edad >= 18) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }

        lector.close();
    }
}
