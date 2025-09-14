
import java.util.ArrayList;
import java.util.List;

public class Ejercicio71 {
    //71. Hacer un que realice la serie fibonacci -> 11 23 5 8 13...n
    
    public static List<Integer> generarFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        int primero = 11;
        int segundo = 23;

        if (n >= 1) {
            fibonacci.add(primero);
        }
        if (n >= 2) {
            fibonacci.add(segundo);
        }

        for (int i = 3; i <= n; i++) {
            int next = segundo - primero;
            primero = segundo;
            segundo = next;
            fibonacci.add(next);
        }

        return fibonacci;
    }

    public static void main(String[] args) {
        int n = 10; // Número de elementos de la serie que quieres generar
        List<Integer> fibonacciSeries = generarFibonacci(n);

        // Imprimir la serie Fibonacci
        System.out.println("Serie Fibonacci:");
        for (int num : fibonacciSeries) {
            System.out.print(num + " ");
        }
    } 
}
