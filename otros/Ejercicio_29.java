import java.util.Scanner;

public class Ejercicio_29 {
    /*29.Crear una función que permita calcular el cubo de un número real (float) */
   public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingrese un numero real");
    float num1=lector.nextFloat();
    double resultado = (Math.pow((double) (num1),3));
    System.out.println("El cubo de numero ingresado es:"+resultado);
   } 
}
