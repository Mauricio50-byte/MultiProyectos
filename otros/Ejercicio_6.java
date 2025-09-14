import java.util.Scanner;

public class Ejercicio_6 {
    /*6.Programa que calcula la media aritmética de tres números cualesquiera dados por
el usuario. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double num1, num2, num3, media = 0;
        System.out.println("Ingrese el primer numero:");
        num1 = lector.nextDouble();
        System.out.println("Ingrese el segundo numero:");
        num2 = lector.nextDouble();
        System.out.println("Ingrse el tercer numero:");
        num3 = lector.nextDouble();
        //calculo de la sumatoria
        media = (num1 + num2 + num3)/ 3;
        System.out.println("La media aritmetica de los tres numeros dados es:"+media);

    }
}
