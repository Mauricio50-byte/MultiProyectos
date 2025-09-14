public class Ejercicio124 {
    /*124. Escribir un programa que muestre en pantalla todos los múltiplos de 3 de los
números comprendidos del 1 al 3000. */
    public static void main(String[] args) {
    System.out.println("Múltiplos de 3 entre 1 y 3000:");

        for (int i = 1; i <= 3000; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            // Agregar un salto de línea cada 10 múltiplos para mejorar la visualización
                if (i % 30 == 0) {
                System.out.println();
                }
            }
        }
    } 
}
