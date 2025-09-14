import java.util.Scanner;

public class Ejercicio62 {
    /*62.Escriba un programa que tome cada 4 horas la temperatura exterior, leyendola
durante un periodo de 24 horas. Es decir, debe leer 6 temperaturas. Calcule la
temperatura media del día, la temperatura más alta y la más baja. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        float temperaturaMedia = 0;
        float temperaturaMaxima = 0;
        float temperaturaMinima = 0;
        for (int i = 0; i < 6; i++) {
            System.out.print("Ingrese la temperatura exterior a las " + (i * 4) + " horas: ");
            float temperatura = lector.nextFloat();
            temperaturaMedia += temperatura;
            if (temperatura > temperaturaMaxima) {
                temperaturaMaxima = temperatura;
            }
            if (temperatura < temperaturaMinima) {
                temperaturaMinima = temperatura;
            }
        }
        temperaturaMedia /= 6;
        System.out.println("Temperatura media: " + temperaturaMedia);
        System.out.println("Temperatura maxima: " + temperaturaMaxima);
        System.out.println("Temperatura minima: " + temperaturaMinima);
        lector.close();

    }
}
