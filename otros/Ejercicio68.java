import java.util.Scanner;

public class Ejercicio68 {
//68.Escriba un programa que calcule el valor de: 11+2+3!+...+n! (suma de factoriales).?
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el valor de n:");
        int n = lector.nextInt();
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma = suma + i * factorial(i);
        }
        System.out.println("La suma de factoriales es:"+suma);
        lector.close();
    }
    public static int factorial(int n) {
        if ((n == 0)){
        return 1;
        }else{
          return n * factorial(n-1);
        }
    }
}
