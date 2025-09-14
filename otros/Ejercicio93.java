import java.util.Scanner;

public class Ejercicio93 {
    /*93. Desarrolle el código fuente de un tiempo ingresado en minutos, visualizarlo por
pantalla en horas, minutos y segundos. */
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el tiempo en minutos: ");
        int tiempoMinutos = lector.nextInt();

        int horas = tiempoMinutos / 60;
        int minutos = tiempoMinutos % 60;
        int segundos = minutos * 60;

        System.out.println("Tiempo ingresado:");
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);

        lector.close();
    }
}
