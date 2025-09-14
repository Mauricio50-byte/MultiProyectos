import java.util.Scanner;
/*2. Programa que pida al usuario que ingrese un texto e imprima el mensaje “El texto
ingresado es :” junto al texto ingresado */
public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String Texto;
        System.out.println("Ingrese un texto:");
        Texto = lector.nextLine();
        System.out.println("El texto ingresado es:"+Texto);
    }
}
