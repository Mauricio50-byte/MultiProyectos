import java.util.Scanner;

public class Ejercicio120 {
    /*120. Programa que mande a imprimir el texto “Hola usuario!” , y que pregunte al
usuario si desea que siga imprimiendo el texto [S/N]? . De acuerdo a la respuesta
del usuario [S ó N], el saludo siga imprimiendo ó se detenga . */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        char respuesta;

        do {
            System.out.println("Hola usuario!");
            System.out.print("¿Desea que siga imprimiendo el saludo? [S/N]: ");
            respuesta = Character.toUpperCase(lector.next().charAt(0));
        } while (respuesta == 'S');

        lector.close();
    }
}
