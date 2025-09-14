import java.util.Scanner;

public class Ejercicio_35 {
/*35.A un profesor le pagan según sus horas y una tarifa de pago por horas. Si la
cantidad de horas trabajadas es mayor a 40 horas, la tarifa se incrementa en un
50 % para las horas extras. Calcular el salario del profesor dadas las horas
trabajadas y la tarifa. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese cantidad de horas trabajadas:");
        int horas = lector.nextInt();
        System.out.println("Ingrese la tarifa por horas:");
        double tarifa = lector.nextDouble();
        double salario;
        if (horas > 40) {
            salario = (horas - 40) * (tarifa * 1.5) + 40 * tarifa;
        }else{
            salario = horas * tarifa;
        }
        System.out.println("El salario del profesor es:"+ salario);
    }
}
