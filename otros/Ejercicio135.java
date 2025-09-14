import java.util.Scanner;

public class Ejercicio135 {
    /*135. Programa que lea una cantidad de números N , dados por el usuario y
determine cuál de ellos es el mayor y cuál es el menor. Pedir la cantidad límite de
números al usuario. */
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números a comparar: ");
        int cantidadNumeros = lector.nextInt();

        if (cantidadNumeros <= 0) {
            System.out.println("La cantidad de números debe ser mayor que 0.");
            lector.close();
            return;
        }

        int mayor = Integer.MIN_VALUE; // Inicializar con el valor mínimo posible para enteros
        int menor = Integer.MAX_VALUE; // Inicializar con el valor máximo posible para enteros

        for (int i = 1; i <= cantidadNumeros; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int numero = lector.nextInt();

            if (numero > mayor) {
                mayor = numero;
            }

            if (numero < menor) {
                menor = numero;
            }
        }

        lector.close();

        System.out.println("El mayor es: " + mayor);
        System.out.println("El menor es: " + menor);
    }
}
