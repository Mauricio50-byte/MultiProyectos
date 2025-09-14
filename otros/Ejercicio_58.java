import java.util.Scanner;

public class Ejercicio_58 {
   /*58.Dada las horas trabajadas de una persona y el valor por hora. Calcular su salario y
visualizarlos. */ 
   public static void main(String[] args) {
         Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese las horas trabajadas: ");
        double horasTrabajadas = lector.nextDouble();

        System.out.print("Ingrese el valor por hora: ");
        double valorPorHora = lector.nextDouble();

        double salario = horasTrabajadas * valorPorHora;

        System.out.println("El salario de la persona es: $" + salario);
        lector.close();
   }

}
