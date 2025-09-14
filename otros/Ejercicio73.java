import java.util.Scanner;

public class Ejercicio73 {
    /* 73.A un trabajador le descuentan de su sueldo el 10% si su sueldo es menor o igual a
1000, por encima de 1000 y hasta 2000 el 5% del adicional, y por encima de 2000
el 3% del adicional. Calcular el descuento y sueldo neto que recibe el trabajador
dado su sueldo.*/
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingrese el sueldo del trabajador: ");
        double sueldo = lector.nextDouble();
        
        double descuento = calcularDescuento(sueldo);
        double sueldoNeto = sueldo - descuento;
        
        System.out.println("Descuento: " + descuento);
        System.out.println("Sueldo neto: " + sueldoNeto);
        lector.close();
    }
    
    public static double calcularDescuento(double sueldo) {
        double descuento;
        
        if (sueldo <= 1000) {
            descuento = sueldo * 0.10;
        } else if (sueldo <= 2000) {
            double adicional = sueldo - 1000;
            descuento = 1000 * 0.10 + adicional * 0.05;
        } else {
            double adicional = sueldo - 2000;
            descuento = 1000 * 0.10 + 1000 * 0.05 + adicional * 0.03;
        }
        
        return descuento;
    }
}
