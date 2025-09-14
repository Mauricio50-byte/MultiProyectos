import java.util.Scanner;

public class Ejercicio_59 {
   /* 59.Realice un programa que solicite de la entrada estándar un entero del 1 al 10 y
muestre en la salida estándar su tabla de multiplicar.*/ 
     public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingresa un número del 1 al 10: ");
        int numero = lector.nextInt();
        
        if (numero < 1 || numero > 10) {
            System.out.println("El número debe estar entre 1 y 10.");
        } else {
            System.out.println("Tabla de multiplicar del " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                System.out.println(numero + " x " + i + " = " + resultado);
                lector.close();
            }
        }
    }
}
