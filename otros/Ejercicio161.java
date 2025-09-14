import java.util.Scanner;

public class Ejercicio161 {
    /*161. Programa que intercambia los valores de dos variables numéricas dadas por el
usuario. */
    public static void main(String[] args) {
        Scanner lector = new Scanner (System.in);
        System.out.println("Ingrese un valor para la variable A: ");
        long A = lector.nextLong();
        System.out.println("Ingrese un valor para la variable B: ");
        long B = lector.nextLong();
        //Intercambio de valores entre las variables A y B
        long temp = A;
        A=B;
        B=temp;
        System.out.println("La variable A = " + A);
        System.out.println("La variable B = " + B);
        lector.close();
    }
}
