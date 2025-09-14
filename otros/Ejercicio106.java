import java.util.Scanner;

public class Ejercicio106 {
    /*106. Crear un programa que encuentre el máximo común divisor de dos números
usando el algoritmo de Euclides : Dado dos números enteros positivos m y n, tal
que m > n, para encontrar su máximo común divisor, es decir, el mayor entero
positivo que divide a ambos: - Dividir m por n para obtener el resto r (0 = r < n) ;
- Si r = 0, el MCD es n.; - Si no, el máximo común divisor es MCD(n,r). */
public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el primer número (m): ");
        int m = lector.nextInt();

        System.out.print("Ingrese el segundo número (n): ");
        int n = lector.nextInt();

        int mcd = encontrarMCD(m, n);
        
        System.out.println("El máximo común divisor de " + m + " y " + n + " es: " + mcd);

        lector.close();
    }

    public static int encontrarMCD(int m, int n) {
    
        while (n != 0) {
            int resto = m % n;
            m = n;
            n = resto;
        }
        return m; // El máximo comun divisor es m
    }
}
