import java.util.Scanner;

public class Ejercicio_24 {
    /*24.Programa que de acuerdo a una cantidad de pulgadas ingresadas por teclado,
realice la conversión a centímetros. (1plg=2.54cm). */
   public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingrese las pulgadas:");
    int pulgadas = lector.nextInt();
    double centimetros = (pulgadas * 2.54);
    System.out.println("los centimetros que hay en dichas pulgadas es:"+centimetros+"Cm");
   } 
}
