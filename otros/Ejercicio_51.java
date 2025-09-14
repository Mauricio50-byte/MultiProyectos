import java.util.Scanner;

public class Ejercicio_51 {
/*51.Calcule el área y el perímetro de un rectángulo dada la base y la altura. */
    public static void main(String[] args) {
          Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la base del rectángulo: ");
        double base = lector.nextDouble();

        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = lector.nextDouble();

        double area = base * altura;
        double perimetro = (base + altura) * 2;

        System.out.println("El área del rectángulo es: " + area);
        System.out.println("El perímetro del rectángulo es: " + perimetro);
        lector.close();
    }
}
