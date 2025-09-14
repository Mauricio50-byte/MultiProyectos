import java.util.Scanner;

public class Ejercicio138 {
    /*138. Programa que muestre un menú de 3 opciones para calcular 3 áreas de figuras
geométricas diferentes para que el usuario pueda elegir cuál área calcular. El
algoritmo termina al teclear un 0. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int opcion;
        double resultado;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Calcular área de un cuadrado");
            System.out.println("2. Calcular área de un círculo");
            System.out.println("3. Calcular área de un triángulo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = lector.nextDouble();
                    resultado = calcularAreaCuadrado(lado);
                    System.out.println("El área del cuadrado es: " + resultado);
                    break;

                case 2:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = lector.nextDouble();
                    resultado = calcularAreaCirculo(radio);
                    System.out.println("El área del círculo es: " + resultado);
                    break;

                case 3:
                    System.out.print("Ingrese la base del triángulo: ");
                    double base = lector.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double altura = lector.nextDouble();
                    resultado = calcularAreaTriangulo(base, altura);
                    System.out.println("El área del triángulo es: " + resultado);
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);

        lector.close();
    }

    public static double calcularAreaCuadrado(double lado) {
        return lado * lado;
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }
}
