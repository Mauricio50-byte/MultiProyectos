import java.util.Scanner;

public class Ejercicio128 {
    /*128. Programa para determinar si el año (en formato de 4 dígitos) indicado por el
usuario es bisiesto (todo año múltiplo de 4 es bisiesto, excepto aquellos múltiplos
de 100, aunque si también son múltiplos de 400, entonces, sí serán bisiestos. Ej.
2000 si es bisiesto, pero 1800 no). */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un año (formato de 4 dígitos): ");
        int año = lector.nextInt();

        lector.close();

        boolean esBisiesto = false;

        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
            esBisiesto = true;
        }

        if (esBisiesto) {
            System.out.println(año + " es un año bisiesto.");
        } else {
            System.out.println(año + " no es un año bisiesto.");
        }
    }
}
