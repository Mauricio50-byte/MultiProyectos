import java.util.Scanner;

public class Ejercicio84 {
    /*84. Desarrolle el código fuente de un programa que permita ingresar una edad y leer su
edad ingresada */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int edad = lector.nextInt();

        System.out.println("Edad ingresada: " + edad);
        lector.close();
    }
}
