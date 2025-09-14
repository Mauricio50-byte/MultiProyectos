import java.util.Scanner;

public class Ejercicio148 {
    /*148. Realice un programa que permita la lectura de los datos y el cálculo de las
estadísticas. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de datos: ");
        int cantidadDatos = lector.nextInt();

        int[] datos = new int[cantidadDatos];
        int suma = 0;
        
        // Lectura de datos
        for (int i = 0; i < cantidadDatos; i++) {
            System.out.print("Ingresa el dato " + (i + 1) + ": ");
            datos[i] = lector.nextInt();
            suma += datos[i];
        }

        // Cálculo de estadísticas
        int maximo = datos[0];
        int minimo = datos[0];
        
        for (int i = 1; i < cantidadDatos; i++) {
            if (datos[i] > maximo) {
                maximo = datos[i];
            }
            if (datos[i] < minimo) {
                minimo = datos[i];
            }
        }

        double promedio = (double) suma / cantidadDatos;

        System.out.println("Datos ingresados:");
        for (int i = 0; i < cantidadDatos; i++) {
            System.out.print(datos[i] + " ");
        }
        
        System.out.println("\n\nEstadísticas:");
        System.out.println("Promedio: " + promedio);
        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);

        lector.close();
    }
}
