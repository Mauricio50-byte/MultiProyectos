import java.util.Scanner;

public class Ejercicio109 {
    /*109. Programa que aplique un descuento de 10% sobre el monto de una venta (dado
por el usuario), sólo si ésta es mayor a 1000 pesos. Mostrar el monto neto de la
venta. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el monto de la venta: ");
        double montoVenta = lector.nextDouble();

        double montoNetoVenta = montoVenta;

        if (montoVenta > 1000) {
            double descuento = montoVenta * 0.10;
            montoNetoVenta = montoVenta - descuento;
        }

        System.out.println("El monto neto de la venta es: " + montoNetoVenta);

        lector.close();
    }
}
