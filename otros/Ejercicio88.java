import java.util.Scanner;

public class Ejercicio88 {
    /*88. Desarrolle un programa que solicite ingrese tres voltajes distintos e indique si el
promedio de los voltajes ingresados es menor a 115 visualice “VOLTAJE
CORRECTO”, caso contrario sea mayor A 115 y menor a 220 visualice “ALTO
VOLTAJE”, y si es mayor a 220 visualice “PELIGRO”. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        double[] voltajes = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese el voltaje " + (i + 1) + ": ");
            voltajes[i] = lector.nextDouble();
        }

        double promedio = calcularPromedio(voltajes);

        System.out.println("El promedio de los voltajes es: " + promedio);

        if (promedio < 115) {
            System.out.println("VOLTAJE CORRECTO");
        } else if (promedio >= 115 && promedio < 220) {
            System.out.println("ALTO VOLTAJE");
        } else {
            System.out.println("PELIGRO");
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
