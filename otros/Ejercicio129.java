import java.util.Scanner;

public class Ejercicio129 {
    /*129. Programa que a partir del número del mes (1-12) y el año, indique el número
total de días que corresponden a cada mes, el número de mes será indicado por el
usuario. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el número de mes (1-12): ");
        int numeroMes = lector.nextInt();

        System.out.print("Ingrese el año: ");
        int año = lector.nextInt();

        lector.close();

        int dias;

        switch (numeroMes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
            case 2:
                if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
                    dias = 29; // Año bisiesto
                } else {
                    dias = 28; // Año no bisiesto
                }
                break;
            default:
                dias = -1;
                break;
        }

        if (dias != -1) {
            System.out.println("El número de días en el mes " + numeroMes + " del año " + año + " es: " + dias);
        } else {
            System.out.println("Número de mes no válido.");
        }
    }
}
