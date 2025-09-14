import java.util.Scanner;

public class Ejercicio104 {
    /*104. Crear un programa que halle la raíz cuadrada de un número. Ejemplo el usuario
deberá indicar el número (por ejemplo y el índice de la raíz ( 3 por ejemplo para la
raíz cúbica). NOTA. Hallar la raíz cúbica de 2 es lo mismo que elevar 2 a 1/3. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el número: ");
        double numero = lector.nextDouble();

        System.out.print("Ingrese el índice de la raíz: ");
        double indice = lector.nextDouble();

        double resultado = Math.pow(numero, 1.0 / indice);

        System.out.println("La raíz " + indice + " de " + numero + " es: " + resultado);

        lector.close();
    }
}
