import java.util.Scanner;

public class Ejercicio67 {
   // 67.Escriba un programa que calcule el valor de: 1*2*3*...-n (factorial)?
    public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingrese el valor de n: ");
    int n = lector.nextInt();
    int factorial = 1;
        for (int i = 1; i <= n; i++) {
         factorial = factorial * i;
        }
        System.out.println("El factorial de " + n + " es " + factorial);
        lector.close();
    }
}
