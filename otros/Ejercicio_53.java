import java.util.Scanner;

public class Ejercicio_53 {
  //53.Calcule el área de un cuadrado.  
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el valor del lado del cuadrado: ");
        double lado = lector.nextDouble();

        double area = lado * lado;

        System.out.println("El área del cuadrado es: " + area);
        lector.close();
    } 
}
