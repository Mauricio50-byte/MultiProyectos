import java.util.Scanner;

public class Ejercicio_5 {
    /*5. Programa que pida los datos necesarios y muestre en pantalla el área de un rombo */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int Diagonal_mayor;
        int Diagonal_menor;
        System.out.println("Ingrese la medida de la Diagonal mayor:");
        Diagonal_mayor = lector.nextInt();
        System.out.println("Ingrese la medida de la Diagonal menor:");
        Diagonal_menor = lector.nextInt();
        double area = (Diagonal_mayor * Diagonal_menor)/2;
        System.out.println("El area de un rombo es:"+ area);
    }
}
