import java.util.Scanner;

public class Ejercicio98 {
    /*98. Desarrollar un algoritmo que permita leer dos valores, e indicar si el resultado de
dividir la suma de los dos números entre la resta de los mismos es exacta, caso
contrario imprimir no es exacta. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Solicitar al usuario que ingrese dos valores
        System.out.print("Ingrese el primer valor: ");
        int valor1 = lector.nextInt();

        System.out.print("Ingrese el segundo valor: ");
        int valor2 = lector.nextInt();

        // Calcular la suma y la resta
        int suma = valor1 + valor2;
        int resta = valor1 - valor2;

        // Verificar si la división es exacta
        if (suma % resta == 0) {
            System.out.println("La división de la suma entre la resta es exacta.");
        } else {
            System.out.println("La división de la suma entre la resta no es exacta.");
        }

        lector.close();
    }
}
