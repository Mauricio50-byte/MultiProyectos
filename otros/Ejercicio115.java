public class Ejercicio115 {
    /*115. Programa que sume los números enteros PARES comprendidos entre 1 y 1000. */
    public static void main(String[] args) {
        int sumaPares = 0;

        for (int i = 2; i <= 1000; i += 2) {
            sumaPares += i;
        }

        System.out.println("La suma de los números pares entre 1 y 1000 es: " + sumaPares);
    }
}
