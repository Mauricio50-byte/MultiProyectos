import java.util.Scanner;

public class Ejercicio_19 {
    /*19.Introducir el sueldo básico de un empleado por teclado, hallar el total ganado
considerando que debe introducir el monto por horas extras, considerar un
descuento del 20%. Desplegar el sueldo básico, el total del descuento y el total
ganado. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el sueldo basico del cliente:");
        double sueldo = lector.nextDouble();
        int horasExtras = 5;
        double TotalGanado = sueldo + horasExtras;
        double descuento = (TotalGanado * 0.20);

        System.out.println("El sueldo basico es:"+sueldo);
        System.out.println("El descuento total es:"+descuento);
        System.out.println("El Total ganado es:"+TotalGanado);
        lector.close();
    }
}
