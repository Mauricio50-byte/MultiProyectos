import java.util.Scanner;

public class Ejercicio_46 {
 /*46.Que permita leer el valor correspondiente a una distancia en millas y las visualice
expresadas en metros. Sabiendo que 1 milla marina equivale a 1852 metros. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingresa la distancia en millas: ");
        double millas = lector.nextDouble();
        
        double metros = millas * 1852;
        
        System.out.println(millas + " millas equivalen a " + metros + " metros.");
        
        lector.close();
    }
}
