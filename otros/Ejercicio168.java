import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio168{
    /*168. Programa que permita leer las 5 letras vocales en desorden y mostrarlas en
pantalla ordenadas. */
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        char letras[] = new char[5];
        System.out.println("Introduce las 5 letras vocales");
        for (int i = 0; i < 5; i++) {
            letras[i] = lector.next().charAt(0);
        }
        Arrays.sort(letras);
        for (int i = 0; i < 5; i++) {
            System.out.print(letras[i] + " ");
        }
        lector.close();
    }
}