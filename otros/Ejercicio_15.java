import java.util.Scanner;

public class Ejercicio_15 {
    //15.Algoritmo que determine si una persona es mayor o menor de edad
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Digite su edad:");
        int edad = lector.nextInt();
        if ( edad >= 18) {
            System.out.println("Si es mayor de edad");
        } else {
            System.out.println("No es mayor de edad");
        }
    }
}
