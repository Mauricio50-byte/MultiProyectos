import java.util.Scanner;

public class Ejercicio91 {
    /*91. Desarrolle el código fuente de un programa que le permita ingresar los siguientes
datos: nombre, apellido, edad y número de celular de una persona, al término debe
mostrar los datos ingresados. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        String nombre = lector.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = lector.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = lector.nextInt();

        System.out.print("Ingrese el número de celular: ");
        String numeroCelular = lector.next();

        // Mostrar los datos ingresados
        System.out.println("Datos ingresados:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Número de celular: " + numeroCelular);

        lector.close();
    }
}
