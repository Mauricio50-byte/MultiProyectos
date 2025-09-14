import java.util.Scanner;

public class Ejercicio119 {
    /*119. Programa que pida al usuario una contraseña a el usuario, y muestre un
mensaje de “contraseña incorrecta” ó “contraseña aceptada” según corresponda,
colocando un contador de intentos, si excede 3 intentos deberá mostrar “Intentos
excedidos” y finalice. La contraseña correcta será “passwd” . */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        String contraseñaCorrecta = "passwd";
        int intentos = 0;

        while (intentos < 3) {
            System.out.print("Ingrese la contraseña: ");
            String contraseñaIngresada = lector.nextLine();

            if (contraseñaIngresada.equals(contraseñaCorrecta)) {
                System.out.println("Contraseña aceptada");
                lector.close();
                return;
            } else {
                System.out.println("Contraseña incorrecta");
                intentos++;
            }
        }

        System.out.println("Intentos excedidos");

        lector.close();
    }
}
