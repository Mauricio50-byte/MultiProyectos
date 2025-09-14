import java.util.Scanner;

public class Ejercicio_37 {
    /*37.Hacer lo mismo que el ejercicio anterior pero ahora suponer que después de una
hora de estacionamiento si los minutos no excedan los 10, no se le cobra la hora;
es decir, si el cliente ocupa el estacionamiento una hora 8 minutos, se le cobra sólo
una hora, otro ejemplo sería si el cliente ocupa el estacionamiento 2 horas 15
minutos, se le cobra 3 horas de estacionamiento */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el tiempo de estacionamiento en horas: ");
        int hora = lector.nextInt();

        System.out.print("Ingrese el tiempo de estacionamiento en minutos: ");
        int minuto = lector.nextInt();

        int tiempo = hora * 60 + minuto;

        double precio = 0;
        if (tiempo <= 60) {
            precio = tiempo * 15.00;
        } else if (tiempo > 60 && tiempo <= 70) {
            precio = 15.00;
        } else if (tiempo > 70 && tiempo <= 120) {
            precio = 15.00 + ((tiempo - 70) * 0.50);
        } else if (tiempo > 120) {
            int horas = tiempo / 60;
            int minutos = tiempo % 60;
            precio = 15.00 + ((horas - 1) * 1.00) + ((minutos - 60) * 0.50);
        }
        System.out.println("El cliente debe pagar: $" + precio);
        lector.close();
    }
}
