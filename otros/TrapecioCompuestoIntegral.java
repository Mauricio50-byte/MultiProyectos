import java.util.Scanner;
import java.util.function.Function;

public class TrapecioCompuestoIntegral {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Solicitar al usuario los límites de integración y el número de subintervalos
        System.out.print("Ingrese el límite inferior de integración (a): ");
        double a = lector.nextDouble();

        System.out.print("Ingrese el límite superior de integración (b): ");
        double b = lector.nextDouble();

        System.out.print("Ingrese el número de subintervalos (n): ");
        int n = lector.nextInt();

        // Calcular el volumen del sólido de revolución utilizando el método del trapecio compuesto
        double volumen = TrapecioCompuesto(a, b, n, x -> Math.PI * Math.pow(funcionSeccionTransversal(x), 2));

        // Mostrar el resultado al usuario
        System.out.println("Volumen del solido en revolución es : " + volumen);

        lector.close();
    }

    // Función para calcular el volumen utilizando el método del trapecio compuesto
    public static double TrapecioCompuesto(double a, double b, int n, Function<Double, Double> funcion) {
        double h = (b - a) / n; // Ancho de cada subintervalo
        double suma = 0.5 * (funcion.apply(a) + funcion.apply(b)); // Suma inicial

        // Calcular la suma de las áreas de los trapecios
        for (int i = 1; i < n; i++) {
            double x = a + i * h; // Punto medio del subintervalo
            suma += funcion.apply(x); // Evaluar la función en el punto medio y sumar al resultado
        }

        return h * suma; // se Multiplica por el ancho de los subintervalos para obtener el resultado final
    }
    // Sección transversal utilizando la función 0.02x^6 + 0.2x^5 - 0.88x^4 + 1.87x^3 - 2.01x^2 + 0.99x - 0.39
    public static double funcionSeccionTransversal(double x) {
        return 0.02 * Math.pow(x, 6) + 0.2 * Math.pow(x, 5) - 0.88 * Math.pow(x, 4) 
        + 1.87 * Math.pow(x, 3) - 2.01 * Math.pow(x, 2) + 0.99 * x - 0.39;
    }
}


