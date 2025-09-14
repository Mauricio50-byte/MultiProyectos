import java.util.Scanner;

public class Ejercicio102 {
    /*102. A un trabajador eléctrico le pagan según sus horas trabajadas y la tarifa está a
un valor determinado por hora. Si la cantidad de horas trabajadas es mayor a 40
horas, la tarifa por hora se incrementa en un 25% para las horas extras. Calcular el
salario del trabajador dadas las horas trabajadas y la tarifa de horas extras. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce las horas trabajadas: ");
        int horasTrabajadas = lector.nextInt();

        System.out.print("Introduce la tarifa por hora: ");
        double tarifaPorHora = lector.nextDouble();

        double salario = calcularSalario(horasTrabajadas, tarifaPorHora);
        System.out.println("El salario del trabajador es: $" + salario);
        lector.close();
    }

    public static double calcularSalario(int horasTrabajadas, double tarifaPorHora) {
        double salario;
        if (horasTrabajadas > 40) {
            int horasExtras = horasTrabajadas - 40;
            double tarifaHorasExtras = tarifaPorHora * 1.25;  // Incremento del 25% para horas extras
            salario = (40 * tarifaPorHora) + (horasExtras * tarifaHorasExtras);
        } else {
            salario = horasTrabajadas * tarifaPorHora;
        }
        return salario;
    }
}
