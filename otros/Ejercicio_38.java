import java.util.Scanner;

public class Ejercicio_38 {
/*38.Una persona por cada año de vida debe consumir 8 kilogramos de fruta. Dada la
edad de una persona, imprimir cuántos gramos de fruta ha consumido y
adicionalmente si una manzana pesa en promedio 4 gramos, determinar cuántas
manzanas ha consumido. */
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese su edad: ");
    int edad = sc.nextInt();

    int gramosFruta = edad * 8;
    System.out.println("Ha consumido " + gramosFruta + " gramos de fruta.");

    int manzanas = gramosFruta / 4;
    System.out.println("Ha consumido " + manzanas + " manzanas.");

   } 
}
