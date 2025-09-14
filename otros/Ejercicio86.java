import java.util.Scanner;

public class Ejercicio86 {
    /*86. Desarrolle el código fuente de un programa que permita ingresar cinco voltajes,
obtener su promedio y visualizar “ALTO VOLTAJE”, si su promedio es mayor a 220,
caso contrario sea menor mostrar “VOLTAJE CORRECTO”. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Pedir al usuario que ingrese cinco voltajes
        double[] voltajes = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el voltaje " + (i + 1) + ": ");
            voltajes[i] = lector.nextDouble();
        }

        // Calcular el promedio de los voltajes
        double promedio = calcularPromedio(voltajes);

        // Mostrar el promedio
        System.out.println("El promedio de los voltajes es: " + promedio);

        // Verificar si el promedio es mayor a 220 y mostrar el resultado
        if (promedio > 220) {
            System.out.println("ALTO VOLTAJE");
        } else {
            System.out.println("VOLTAJE CORRECTO");
        }
        lector.close();
    }

    public static double calcularPromedio(double[] voltajes) {
        double suma = 0;

        for (double voltaje : voltajes) {
            suma += voltaje;
        }

        return suma / voltajes.length;
    }
}
