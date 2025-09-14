import java.util.Scanner;

public class Ejercicio134 {
    /*134. Programa que pida 3 números enteros y determine cuál de ellos es el mayor y
cuál el menor. Incluir una validación que evite que los 2 de esos números sean
iguales. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el primer número entero: ");
        int numero1 = lector.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int numero2 = lector.nextInt();

        System.out.print("Ingrese el tercer número entero: ");
        int numero3 = lector.nextInt();

        lector.close();

        // Validación para asegurar que al menos dos números sean diferentes
        if (numero1 == numero2 && numero2 == numero3) {
            System.out.println("Al menos dos números deben ser diferentes.");
            return;
        }

        int mayor = Math.max(Math.max(numero1, numero2), numero3);
        int menor = Math.min(Math.min(numero1, numero2), numero3);

        System.out.println("El mayor es: " + mayor);
        System.out.println("El menor es: " + menor);
    }
}
