import java.util.Scanner;

public class Ejercicio_41 {
/*41.El cabello de los seres humanos crece en promedio medio centímetros por mes. Si
una persona no cortará nunca su cabello desde su nacimiento determinar según la
edad ingresada cuántos metros mide la caballera?. */
   public static void main(String[] args) {
      Scanner lector = new Scanner(System.in);
      System.out.println("Ingrese su edad:");
      int edad = lector.nextInt();
      double resultado = edad * 12 * 0.5;
      System.out.println("los metros que mide la cabellera de dicha persona es:"+ resultado+"(Metros)");
   } 
}
