package Calculo_Integral;
import java.util.Scanner;
import java.util.function.Function;

public class SimpsonUntercioCompuesto {
    public static void main(String[] args) {
        // Crear un objeto Scanner para la entrada de datos
        Scanner lector = new Scanner(System.in);

        // Solicitamos al usuario ingresar el limite inferior (a)
        System.out.print("Ingrese el limite inferior (a): ");
        double a = lector.nextDouble();

        // Solicitamos al usuario ingresar el limite superior (b)
        System.out.print("Ingrese el limite superior (b): ");
        double b = lector.nextDouble();

        // Solicitamos al usuario ingresar el numero de segmentos (n, debe ser un numero par)
        int n;
        do {
            System.out.print("Ingrese el numero de segmentos (n, debe ser un numero par): ");
            n = lector.nextInt();

            // Verificamos si el numero ingresado es impar y mostrar un mensaje de error
            if (n % 2 != 0) {
                System.out.println("El numero de segmentos debe ser par. Intentelo de nuevo.");
            }
        } while (n % 2 != 0);

        // Cerramos el Scanner para evitar posibles problemas de memoria
        lector.close();

        // Calculamos el ancho de cada subintervalo (h)
        double h = (b - a) / n;

        // Inicializamos la variable de suma para la regla de Simpson
        double suma = 0.0;

        // Aplicamos la regla de Simpson de un tercio compuesta para calcular el volumen
        for (int i = 0; i <= n; i++) {
            double x = a + i * h;

            // Calculamos el radio de la seccion transversal en terminos de x
            double radio = f.apply(x);

            // Calculamos el area del anillo infinitesimal
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

        // Calculamos el volumen total utilizando la formula de la regla de Simpson
        double volumen = (h / 3) * suma;

        // Inprimimos el resultado del calculo del volumen
        System.out.println("El resultado del volumen es: " + volumen);
    }

    // Definimos la función a integrar (en este caso, f(x) = x^2)
    static Function<Double, Double> f = x -> Math.pow(x, 2);
}


