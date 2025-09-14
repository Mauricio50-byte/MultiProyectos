import java.util.Scanner;

public class Ejercicio99 {
    /*99.Aplicando una función, crear un programa que permita ingresar un año y
determinar si es año bisiesto o no. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un año: ");
        int anio = lector.nextInt();

        boolean esBisiesto = esAnioBisiesto(anio);

        if (esBisiesto) {
            System.out.println(anio + " es un año bisiesto.");
        } else {
            System.out.println(anio + " no es un año bisiesto.");
        }

        lector.close();
    }

    public static boolean esAnioBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
}
