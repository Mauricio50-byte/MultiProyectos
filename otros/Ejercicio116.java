public class Ejercicio116 {
    /*116. Programa que sume los números enteros PARES comprendidos entre 1 y 1000,
y que además multiplique los números enteros NONES entre 1 y 50. */
public static void main(String[] args) {
    int sumaPares = 0;
    int productoNones = 1;

    for (int i = 2; i <= 1000; i += 2) {
        sumaPares += i;
    }

    for (int i = 1; i <= 50; i += 2) {
        productoNones *= i;
    }

    System.out.println("La suma de los números pares entre 1 y 1000 es: " + sumaPares);
    System.out.println("El producto de los números impares entre 1 y 50 es: " + productoNones);
    }
}
