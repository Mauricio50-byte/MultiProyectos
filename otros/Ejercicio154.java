import java.util.Scanner;

public class Ejercicio154 {
    /*154. Crear una cadena que tenga la siguiente frase "Hola que tal", luego crear otra
cadena para preguntarle al usuario su nombre, por último añadir el nombre al final
de la primera cadena y mostrar el mensaje completo "Hola que tal (Nombre De
Usuario)". */
    public static void main(String[] args) {
        String saludo = "Hola que tal";
        Scanner lector = new Scanner(System.in);

        System.out.println(saludo);
        System.out.println("Por favor, ingresa tu nombre: ");
        String nombreUsuario = lector.nextLine();

        String mensajeCompleto = saludo + " " + nombreUsuario;
        System.out.println("Hola que tal, " + nombreUsuario);
        lector.close();
    }
}
