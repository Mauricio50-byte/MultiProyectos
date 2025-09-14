import java.util.Scanner;

public class Ejercicio_36 {
    /*36.En un estacionamiento cobran $15.00 por hora o fracción. Diseñe un algoritmo que
determine cuánto debe pagar un cliente por el estacionamiento de su vehículo,
conociendo el tiempo de estacionamiento en horas y minutos. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double cobro = 15.00; // cobro por horas de estacionamiento
        System.out.println("Ingrese la cantidad de horas que duro estacionado:");
        int hrsEstacionados = lector.nextInt();
        System.out.println("Ingrese el numero de minutos estacionados:");
        int minutosEstacionados = lector.nextInt();

        int tiempo = 60 * hrsEstacionados + minutosEstacionados;
        double precio = tiempo * cobro;

        System.out.println("El cliente debe pagar: $"+precio);
    }
}
