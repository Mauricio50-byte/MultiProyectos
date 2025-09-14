import java.util.Scanner;

public class Ejercicio66 {
   // 66.Escriba un programa que calcule el valor de: 1+3+5+...+2n-1?
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrse el valor de n:");
        int n = lector.nextInt();
        int suma = 0;
        for (int i = 1; i <= 2 * n; i += 2) {
            suma += i;
        }   
        System.out.println("La suma de 2n-1 es:"+ suma);  
        lector.close();
    }
}


