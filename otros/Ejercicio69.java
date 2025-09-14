import java.util.Scanner;

public class Ejercicio69 {
    //69.Escriba un programa que calcule el valor de: 21+22+2+...+2?
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el valor de n: ");
        int n = lector.nextInt();
        
        int suma = calcularSumaSerie(n);
        
        System.out.println("El valor de la serie es: " + suma);
        
        lector.close();
    }
    
    public static int calcularSumaSerie(int n) {
        int suma = 0;
        int termino = 21;
        
        for (int i = 0; i <= n; i++) {
            suma += termino;
            termino *= 2;
        }
        return suma;
    }
}
