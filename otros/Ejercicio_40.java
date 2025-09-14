import java.util.Scanner;

public class Ejercicio_40 {
/*40.Construir una calculadora minera, la cual permita saber a cuántos pesos equivalen
los kilos de oro ingresados. El usuario deberá ingresar tanto los kilos a convertir
como el precio en pesos por onza de oro. Recordemos que una onza equivale a
28.3495 gramos y que 1000 gramos son un kilo. */
    public static void main(String[] args) {
       Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el precio por onza de oro: ");
        double pricePesoOnza = lector.nextDouble();

        System.out.print("Ingrese los kilos de oro: ");
        double oro = lector.nextDouble();

        double grams = oro * 1000;
        double precio = grams * pricePesoOnza;

        System.out.println("El precio total es: $" + precio);  
    }
}
