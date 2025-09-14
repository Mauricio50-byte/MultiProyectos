import java.util.Scanner;

public class Ejercicio75 {
    /*75.Algoritmo que indica si un año es bisiesto. Un año es bisiesto si es divisible por
cuatro, excepto cuando es divisible por 100, a no ser que sea divisible por 400. Así,
1900 no fue bisiesto, pero 2000 sí lo fue. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingrese el año: ");
        int año = lector.nextInt();
        
        if (esBisiesto(año)) {
            System.out.println(año + " es un año bisiesto.");
        } else {
            System.out.println(año + " no es un año bisiesto.");
        }
        lector.close();
    }
    
    public static boolean esBisiesto(int año) {
        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
            return true;
        } else { 
            return false;
        }
    }
}
