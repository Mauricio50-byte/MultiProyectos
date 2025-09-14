import java.util.Scanner;

public class Ejercicio77 {
    /*77. Calcular los pagos mensuales de una hipoteca y el total a pagar. El programa debe
solicitar el capital, el interés anual y el número de años y debe escribir la cuota a
pagar mensualmente. Para calcular la cuota se utiliza la siguiente fórmula: sea C el
capital del préstamo, R la tasa de interés mensual y N el número de pagos. La
cuota mensual viene dada por: */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el capital del préstamo: ");
        double capital = lector.nextDouble();

        System.out.print("Ingrese la tasa de interés anual (en porcentaje): ");
        double tasaInteresAnual = lector.nextDouble();

        System.out.print("Ingrese el número de años: ");
        int anos = lector.nextInt();

        double tasaInteresMensual = tasaInteresAnual / 12 / 100; // Convertir tasa de interés anual a mensual y a porcentaje
        int numeroPagos = anos * 12; // Calcular el número total de pagos mensuales

        // Calcular la cuota mensual
        double cuotaMensual = (capital * tasaInteresMensual) /
                (1 - Math.pow(1 + tasaInteresMensual, -numeroPagos));

        // Calcular el total a pagar
        double totalPagar = cuotaMensual * numeroPagos;

        // Mostrar la cuota mensual y el total a pagar
        System.out.println("La cuota mensual a pagar es: " + cuotaMensual);
        System.out.println("El total a pagar es: " + totalPagar);
        lector.close();
    }
}
