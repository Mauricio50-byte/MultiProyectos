import java.util.Scanner;

public class Ejercicio_47 {
    /*47.Que escriba el porcentaje descontado en una compra, introduciendo la cantidad
comprada, el precio (valor) de la compra y el precio (valor) pagado. */
    public static void main(String[] args) {
         Scanner lector = new Scanner(System.in);

         System.out.println("Introduce la cantidad comprada: ");
         lector.nextDouble();

         System.out.println("Introduce el valor de la compra: ");
         double valorCompra = lector.nextDouble();

         System.out.println("Introduce el valor pagado: ");
         double valorPagado = lector.nextDouble();

         double porcentaje = ((valorCompra - valorPagado) / valorCompra) * 100;

         System.out.println("El porcentaje descontado es: " + porcentaje);
         lector.close();
    }
}
