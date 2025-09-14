import java.util.Scanner;

public class Ejercicio137 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el valor de a: ");
        double a = lector.nextDouble();

        System.out.print("Ingrese el valor de b: ");
        double b = lector.nextDouble();

        System.out.print("Ingrese el valor de c: ");
        double c = lector.nextDouble();

        lector.close();

        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("La solución única es: x = " + x);
        } else {
            System.out.println("La ecuación no tiene soluciones reales.");
        }
    }
}
