import java.util.Scanner;

public class Ejercicio165 {
    /*165. Realizar un programa que me permita ingresar la cantidad de horas, minutos y
segundos y que me indique cuantos segundos son en total. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de horas: ");
        int horas = lector.nextInt();
        System.out.println("Ingrese la cantidad de minutos: ");
        int minutos = lector.nextInt();
        System.out.println("Ingrese la cantidad de segundos");
        int segundos = lector.nextInt();
        int totalSegundos =  calcularTotalSegundos(horas, minutos, segundos);

        System.out.println("El total de segundos es = " + totalSegundos);
        lector.close();
    }
    
    // Método para calcular el total de segundos
    public static int calcularTotalSegundos(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }
}
