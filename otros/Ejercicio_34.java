import java.util.Scanner;

public class Ejercicio_34 {
    /*34.Dado el monto de una compra calcular el descuento considerado -descuento es
10% si el monto es mayor a 1000 pesos -descuento es 20% si el monto es mayor a
500 pesos y menor o igual a 1000 pesos -no hay descuento si el monto es mayor o
igual a 500 pesos . */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el valor del celular:");
        double PrecioCelular = lector.nextDouble();
        double descuento = 0;
        if (PrecioCelular >= 1000) {
            descuento = PrecioCelular * 0.01;
        }else if (PrecioCelular >= 500 ) {
            descuento = PrecioCelular * 0.02;
        }
        System.out.println("El descuento del celular es:"+ descuento);
        lector.close();
    }
}
