import java.util.Scanner;

public class Ejercicio131 {
    /*131. Programa que calcule la nómina de los trabajadores de una empresa a los
cuales se les paga por hora de acuerdo a una tarifa, ambos datos capturados por
teclado, tomando en cuenta que las horas excedentes a 40 serán pagadas al doble
(horas extra). */
        
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del trabajador: ");
        String nombre = lector.nextLine();
        
        System.out.print("Ingrese la tarifa por hora: ");
        double tarifaPorHora = lector.nextDouble();
        
        System.out.print("Ingrese las horas trabajadas: ");
        int horasTrabajadas = lector.nextInt();
        
        lector.close();
        
        double salarioTotal;
        
        if (horasTrabajadas <= 40) {
            salarioTotal = tarifaPorHora * horasTrabajadas;
        } else {
            salarioTotal = (40 * tarifaPorHora) + ((horasTrabajadas - 40) * (tarifaPorHora * 2));
        }
        
        System.out.println("Nombre del trabajador: " + nombre);
        System.out.println("Salario total: $" + salarioTotal);
    }
}
