import java.util.Scanner;

public class Ejercicio89{
    /*89. Desarrolle el código fuente de un programa que permita ingresar y leer el valor
correspondiente a una distancia en metros y las visualice expresadas en km. */
public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);

    // Solicitar al usuario que ingrese la distancia en metros
    System.out.print("Ingrese la distancia en metros: ");
    double distanciaMetros = lector.nextDouble();

    // Convertir metros a kilómetros
    double distanciaKilometros = metrosAKilometros(distanciaMetros);

    // Mostrar la distancia en kilómetros
    System.out.println("La distancia en kilómetros es: " + distanciaKilometros + " km");
    lector.close();
}

// Método para convertir metros a kilómetros
public static double metrosAKilometros(double metros) {
    return metros / 1000.0; // 1 kilómetro = 1000 metros
}
}
    
