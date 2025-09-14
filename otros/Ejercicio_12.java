import java.util.Scanner;

public class Ejercicio_12 {
    /*12.Introducir tres números por teclado, hallar el promedio de los tres números, la suma
y desplegar del primer número el doble, del segundo número el triple y del tercer
número el cuadrado. */
   public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingrese el primer numero:");
    int num1 = lector.nextInt();
    System.out.println("Ingrese el segundo numero:");
    int num2 = lector.nextInt();
    System.out.println("Ingrese el tercer numero:");
    int num3 = lector.nextInt();

    int promedio = (num1 + num2 + num3) / 3;

    System.out.println("El promedio de los 3  numeros es:"+promedio);

    int suma = (num1 + num2 + num3);

    System.out.println("La suma de los 3 numeros es:"+suma);

    int num1_doble = num1 * 2;

    System.out.println("El doble del primer numero es:"+num1_doble);

    int num2_triple = num2 * 3;

    System.out.println("El triple del segundo numero es:"+num2_triple);

    int num3_cuadrado = num3 * num3;

    System.out.println("El cuadrado del tercer numero es:"+num3_cuadrado);
   } 
}
