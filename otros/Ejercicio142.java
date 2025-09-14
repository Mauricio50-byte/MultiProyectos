import java.util.Scanner;

public class Ejercicio142 {
    /*142. Programa para elevar un número N a la potencia X, ambos datos serán
otorgados por el usuario. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese la base (N): ");
        double base = lector.nextDouble();

        System.out.println("Ingrese el exponente (X): ");
        int exponente = lector.nextInt();

        double resultado = 1;

        // Calcula la potencia
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }

        System.out.println(base + " elevado a la potencia " + exponente + " es igual a: " + resultado);

        lector.close();
    }
}
