import java.util.Scanner;

public class Ejercicio_32 {
    /*32.Construir un programa que permita calcular el área de un rectángulo, los datos se
ingresan en metros y se espera ver los resultados en metros, centímetros y
milímetros cuadrados. */
   public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingresa el largo del rectangulo en metros:");
    int metros_largo = lector.nextInt();
    System.out.println("Ingresa el ancho del rectangulo en metros:");
    int metros_ancho = lector.nextInt();

    int area = metros_ancho * metros_largo;

    System.out.println("El area del rectangulo es de:"+area+"(Metros)");

    double  centimetros_enLargo = metros_largo* 100;
    double  centimetros_enAncho = metros_ancho * 100;
    double  milimetros_Cuadrados_enLargo = metros_largo * 1.000000;
    double milimetros_Cuadrados_enAncho = metros_ancho * 1.000000;
    System.out.println("en el largo de un rectangulo hay : "+centimetros_enLargo+"(Centimetros)"+"--"+ metros_largo+"(Metros)"+"--"+milimetros_Cuadrados_enLargo+"(Milimetros cuadrados)");
    System.out.println("en el ancho de un rectangulo hay : "+centimetros_enAncho+"(Centimetros)"+"--"+metros_ancho+"(Metros)"+"--"+milimetros_Cuadrados_enAncho+"(Milimetros cuadrados)");
   } 
}
