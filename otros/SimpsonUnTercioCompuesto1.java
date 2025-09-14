import java.util.Scanner;
import java.util.function.Function;

public class SimpsonUnTercioCompuesto1 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para la entrada de datos
        Scanner lector = new Scanner(System.in);

        // Solicitar al usuario ingresar el límite inferior (a)
        System.out.print("Ingrese el limite inferior (a): ");
        double a = lector.nextDouble();

        // Solicitar al usuario ingresar el límite superior (b)
        System.out.print("Ingrese el limite superior (b): ");
        double b = lector.nextDouble();

        // Solicitar al usuario ingresar el número de segmentos (n, debe ser un número par)
        int n;
        do {
            System.out.print("Ingrese el numero de segmentos (n, debe ser un numero par): ");
            n = lector.nextInt();

            // Verificar si el número ingresado es impar y mostrar un mensaje de error
            if (n % 2 != 0) {
                System.out.println("El número de segmentos debe ser par. Inténtelo de nuevo.");
            }
        } while (n % 2 != 0);

        // Cerrar el Scanner para evitar posibles problemas de memoria
        lector.close();

        // Calcular el ancho de cada subintervalo (h)
        double h = (b - a) / n;

        // Inicializar la variable de suma para la regla de Simpson
        double suma = 0.0;

        // Aplicar la regla de Simpson de un tercio compuesta para calcular el volumen
        for (int i = 0; i <= n; i++) {
            double x = a + i * h;

            // Calcular el radio de la sección transversal en términos de x
            double radio = f.apply(x);

            // Calcular el área del anillo infinitesimal
            double areaAnillo = Math.PI * Math.pow(radio, 2);

            // Actualizar la suma utilizando la regla de Simpson
            if (i == 0 || i == n) {
                suma += areaAnillo;
            } else if (i % 2 == 1) {
                suma += 4 * areaAnillo;
            } else {
                suma += 2 * areaAnillo;
            }
        }

        // Calcular el volumen total utilizando la fórmula de la regla de Simpson
        double volumen = (h / 3) * suma;

        // Mostrar el resultado del cálculo del volumen
        System.out.println("El resultado del volumen es: " + volumen);
    }

    // Definir la función a integrar (en este caso, f(x) = x^2)
    static Function<Double, Double> f = x -> Math.pow(x, 2);
}


