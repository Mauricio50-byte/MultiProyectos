public class Ejercicio114 {
    /*114. Programa que muestre en pantalla todos los números comprendidos entre 1 y
1000. */
public static void main(String[] args) {
    for (int i = 1; i <= 1000; i++) {
        System.out.print(i + " ");
        // Agregar un salto de línea cada 10 números para mejorar la visualización
        if (i % 10 == 0) {
            System.out.println();
        }
    }
}
}
