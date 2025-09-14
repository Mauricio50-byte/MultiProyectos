import java.util.Scanner;

public class Ejercicio133 {
    /* 133. Programa que pida 2 números enteros y determine cuál de ellos es el mayor y
cuál el menor.*/
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el primer número entero: ");
        int numero1 = lector.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int numero2 = lector.nextInt();

        lector.close();

        if (numero1 > numero2) {
            System.out.println(numero1 + " es mayor que " + numero2);
            System.out.println(numero2 + " es menor que " + numero1);
        } else if (numero1 < numero2) {
            System.out.println(numero2 + " es mayor que " + numero1);
            System.out.println(numero1 + " es menor que " + numero2);
        } else {
            System.out.println("Ambos números son iguales: " + numero1);
        }
    }
}
