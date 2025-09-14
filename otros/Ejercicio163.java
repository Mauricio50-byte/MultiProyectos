import java.util.Scanner;

public class Ejercicio163 {
    /*163. Algoritmo que de acuerdo a 2 números ingresados (AyB), muestra el resultado
de la suma, resta, multiplicación, división y residuo entre ambos. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese un  numero en la variable A: ");
        int num1 = lector.nextInt();
        System.out.println("Ingrese un numero en la variable B: ");
        int num2 = lector.nextInt();
        // Suma
        int suma = num1 + num2;
        //resta
        int resta = num1 - num2;
        //multiplicacion
        int multiplicacion = num1 * num2;
        //division
        float division = (float) num1 / num2;
        //residuo
        int residuo = num1 % num2;
        System.out.println("\nLa suma es: " + suma);
        System.out.println("La resta es: "+ resta);
        System.out.println("La Multiplicacion es: " + multiplicacion);
        System.out.println("La Division es: " + division);
        System.out.println("El Residuo es: " + residuo);
        lector.close();
    }
}
