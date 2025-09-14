import java.util.Scanner;

public class Ejercicio72 {
/*72.A un trabajador le pagan según sus horas trabajadas y la tarifa está a un valor por
hora. Si la cantidad de horas trabajadas es mayor a 40 horas, la tarifa por hora se
incrementa en un 50% para las horas extras. Calcular el salario del trabajador
dadas las horas trabajadas y la tarifa. */
public static double calcularSalario(double horasTrabajadas, double tarifaPorHora) {
    double salario = 0;

    if (horasTrabajadas <= 40) {
        salario = horasTrabajadas * tarifaPorHora;
    } else {
        // Calcular el salario para las primeras 40 horas
        salario = 40 * tarifaPorHora;

        double horasExtras = horasTrabajadas - 40;
        double tarifaPorHoraExtra = tarifaPorHora * 1.5;  
        salario += horasExtras * tarifaPorHoraExtra;
    }

    return salario;
}
public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);

    System.out.print("Ingrese las horas trabajadas: ");
    double horasTrabajadas = lector.nextDouble();

    System.out.print("Ingrese la tarifa por hora: ");
    double tarifaPorHora = lector.nextDouble();

    double salario = calcularSalario(horasTrabajadas, tarifaPorHora);

    System.out.println("El salario del trabajador es: $" + salario);

    lector.close();
    }
}
