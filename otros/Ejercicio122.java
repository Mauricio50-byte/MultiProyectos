import java.util.Scanner;

public class Ejercicio122 {
    /*122. Modificar el programa anterior para que en lugar de leer 5 números, se puedan
leer tantos números como el usuario quiera, hasta que se teclee un cero. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int suma = 0;
        int numero;

        System.out.println("Ingrese números (0 para finalizar):");

        do {
            System.out.print("Número: ");
            numero = lector.nextInt();
            suma += numero;
        } while (numero != 0);

        System.out.println("La suma total de los números ingresados es: " + suma);

        lector.close();
    }
}
