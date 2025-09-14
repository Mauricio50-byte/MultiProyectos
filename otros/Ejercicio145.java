import java.util.Scanner;

public class Ejercicio145 {
    /*145. Programa que lea tres números e indique el tipo de triángulo que forman
(isósceles, equilátero, escaleno). Comprobar que los números realmente formen un
triángulo, sino emitir el error. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese la longitud del primer lado: ");
        double lado1 = lector.nextDouble();

        System.out.println("Ingrese la longitud del segundo lado: ");
        double lado2 = lector.nextDouble();

        System.out.println("Ingrese la longitud del tercer lado: ");
        double lado3 = lector.nextDouble();

        if (esTriangulo(lado1, lado2, lado3)) {
            if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("Los lados forman un triangulo equilatero.");
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                System.out.println("Los lados forman un triangulo isosceles.");
            } else {
                System.out.println("Los lados forman un triangulo escaleno.");
            }
        } else {
            System.out.println("Error: Los lados no forman un triangulo.");
        }

        lector.close();
    }

    public static boolean esTriangulo(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) && (lado2 + lado3 > lado1) && (lado1 + lado3 > lado2);
    }
}
