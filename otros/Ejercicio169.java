import java.util.Scanner;

public class Ejercicio169 {
    /*169. Hacer un programa donde de acuerdo al año de nacimiento de una persona,
indique en qué etapa de su vida están, (niñez1-12, adolescencia13-18,
juventud19-30, adultes31-60, vejez60-100). Solo edades entre 1 y 100 años. */
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        System.out.println("Introduce el año de nacimiento");
        int año = lector.nextInt();
        if (año < 1 || año > 100) {
            System.out.println("Introduce un año entre 1 y 100");
        } else {
            if (año >= 1 && año <= 12) {
                System.out.println("Es niñez");
            } else if (año >= 13 && año <= 18) {
                System.out.println("Es adolescencia");
            } else if (año >= 19 && año <= 30) {
                System.out.println("Es juventud");
            } else if (año >= 31 && año <= 60) {
                System.out.println("Es adultes");
            } else if (año >= 61 && año <= 100) {
                System.out.println("Es vejez");
            }
        }
        lector.close();
    }
}
