import java.util.Scanner;

public class Ejercicio65 {
    /*65. Escriba un programa que calcule el valor de: 1+2+3+...+n */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("ingrese el valor de n:");
        int n = lector.nextInt();
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        System.out.println(suma);
        lector.close();
    }
}
