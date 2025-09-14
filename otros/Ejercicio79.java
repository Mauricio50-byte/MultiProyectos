import java.util.Scanner;

public class Ejercicio79 {
    /*79.Permite determinar el voltaje de tres bombillos en kilovoltio, considerando que el
bombillo trabaja con 120 V. calcular y visualizar el voltaje. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Voltaje de un bombillo en voltios
        int voltajePorBombillo = 120;

        System.out.print("Ingrese el número de bombillos: ");
        int numBombillos = lector.nextInt();

        // Calcular el voltaje total en voltios
        int voltajeTotal = voltajePorBombillo * numBombillos;

        // Convertir el voltaje total a kilovoltios
        double voltajeKilovoltios = voltajeTotal / 1000.0;

        // Mostrar el voltaje en kilovoltios
        System.out.println("El voltaje total en kilovoltios es: " + voltajeKilovoltios + " kV");
        lector.close();
    }
}
