import java.util.Scanner;

public class Ejercicio_30 {
    /*30.Que permita leer el valor correspondiente a una distancia en kilómetros y las
visualice expresadas en metros. */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la distancia en km:");
        double distancia = entrada.nextDouble();
        double visualice = distancia * 1000;
        System.out.println("Los metros que hay en los kilometros ingresados es:"+visualice);
    }
}
