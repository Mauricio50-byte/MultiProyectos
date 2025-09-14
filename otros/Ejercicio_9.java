import java.util.Scanner;

public class Ejercicio_9 {
    /*9. Programa que obtenga el IVA sobre una cantidad dada por el usuario. */
   public static void main(String[] args) {
      Scanner lector = new Scanner(System.in);
         System.out.println("Ingrese la cantidad a la que se le va a sacar el IVA:");
         int  cantidad = lector.nextInt();
         System.out.println("Ingrse el porcentaje de IVA a calcular:");
         double IVA = lector.nextDouble();

         double valorIVa = cantidad * IVA / 100;
         double total = valorIVa + cantidad;

         System.out.println("Elvalor del iva es:"+valorIVa);
         System.out.println("El total a pagar es:"+total);
   } 
}
