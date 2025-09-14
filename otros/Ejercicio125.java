import java.util.Scanner;

public class Ejercicio125 {
    /*125. Modificar el programa anterior para que el número múltiplo pueda ser leído
desde un dispositivo externo (teclado por defecto). */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el límite superior para buscar múltiplos de 3: ");
        int limiteSuperior = lector.nextInt();

        System.out.println("Múltiplos de 3 entre 1 y " + limiteSuperior + ":");

        for (int i = 1; i <= limiteSuperior; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
                // Agregar un salto de línea cada 10 múltiplos para mejorar la visualización
                if (i % 30 == 0) {
                    System.out.println();
                }
            }
        }

        lector.close();
    }
}
