import java.util.Scanner;

public class Ejercicio140 {
    /*140. Crear un programa que muestre un menú como este:

○ 1) Salir
○ 2) Sumatoria
○ 3) Factorial
Tras mostrar el menú, el programa debe leer un número del 1 al tres si se
elige 1, el programa acaba. Si se elige 2 se calcula la sumatoria del
número (ej: 5 = 1+2+3+4+5), si se elige 3 se calcula el factorial (en ambos
casos el programa pedirá escribir el número sobre el que se calcula el
sumatorio o el factorial). Tras calcular el sumatorio o el factorial e indicar
el resultado, el programa volverá a mostrar el menú y así sucesivamente. */
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saliendo del programa.");
                    break;

                case 2:
                    System.out.print("Ingrese un número para calcular la sumatoria: ");
                    int numeroSumatoria = lector.nextInt();
                    int sumatoria = calcularSumatoria(numeroSumatoria);
                    System.out.println("La sumatoria de " + numeroSumatoria + " es: " + sumatoria);
                    break;

                case 3:
                    System.out.print("Ingrese un número para calcular el factorial: ");
                    int numeroFactorial = lector.nextInt();
                    long factorial = calcularFactorial(numeroFactorial);
                    System.out.println("El factorial de " + numeroFactorial + " es: " + factorial);
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 1);

        lector.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1) Salir");
        System.out.println("2) Sumatoria");
        System.out.println("3) Factorial");
        System.out.print("Seleccione una opción: ");
    }

    public static int calcularSumatoria(int numero) {
        int sumatoria = 0;
        for (int i = 1; i <= numero; i++) {
            sumatoria += i;
        }
        return sumatoria;
    }

    public static long calcularFactorial(int numero) {
        if (numero < 0) {
            System.err.println("El factorial no está definido para numeros negativos.");
            return -1;
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
