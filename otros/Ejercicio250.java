import java.util.Scanner;

public class Ejercicio250 {
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        Scanner  lector = new Scanner(System.in);

        System.out.println("Ingrese su edad");
        int edad = lector.nextInt();

        //metodo para saber si el usuarios es joven, adolecente y viejo.
        if (edad >= 18) {
            System.out.println("Es joven");
        } else if (edad >= 12) {
            System.out.println("Es adolecente");
        } else {
            System.out.println("Es viejo");
        }
        lector.close();
    }
}
