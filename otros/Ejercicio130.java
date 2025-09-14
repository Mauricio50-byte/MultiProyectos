import java.util.Scanner;

public class Ejercicio130 {
    /*130. Programa que calcule el monto total a pagar por mes, si el monto será pagado
en un plazo de 12 ó 24 meses, tomando en cuenta que por cada mes se aplica un
2% de interés sobre el saldo. Adicionalmente mostrar el total a pagar. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el monto inicial: ");
        double montoInicial = lector.nextDouble();

        System.out.print("Ingrese la cantidad de meses (12 o 24): ");
        int meses = lector.nextInt();

        lector.close();

        double tasaInteres = 0.02;
        double montoTotal = montoInicial;

        for (int i = 1; i <= meses; i++) {
            montoTotal += montoTotal * tasaInteres;
        }

        System.out.println("El monto total a pagar después de " + meses + " meses es: $" + montoTotal);
    }
}
