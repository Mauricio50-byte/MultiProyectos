import java.util.Scanner;

public class Ejercicio_3 {
 /*3. Programa que obtenga el área de un triángulo, a partir de datos proporcionados por
el usuario.

● Ingresar la base y la altura
● Escribir la fórmula para el área
○ area = (base * altura) / 2
● mostrar el resultado del área */   
   public static void main(String[] args) {
       Scanner lector = new Scanner(System.in);
       int Base;
       int Altura;
       System.out.println("Ingrese la base del triangulo:");
       Base = lector.nextInt();
       System.out.println("Ingrese la altura del triangulo:");
       Altura = lector.nextInt();
       double Area = Base * Altura / 2;
       System.out.println("El area del triangulo es: "+ Area);
   }
}
