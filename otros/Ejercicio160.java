import java.util.Scanner;

public class Ejercicio160 {
    /*
160. Programa que dado un tiempo en segundos, calcula los días, horas y minutos
que le corresponden. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el tiempo en segundos: ");
        int tiempoSegundos = lector.nextInt();

        int dias = tiempoSegundos / 86400; // 1 día tiene 86400 segundos
        int horas = (tiempoSegundos % 86400) / 3600; // 1 hora tiene 3600 segundos
        int minutos = ((tiempoSegundos % 86400) % 3600) / 60; // 1 minuto tiene 60 segundos
        int segundos = ((tiempoSegundos % 86400) % 3600) % 60;

        System.out.println("Días: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);

        lector.close();
    }
}
