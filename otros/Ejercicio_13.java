import java.util.Scanner;

public class Ejercicio_13 {
    //13.Introducir tres números por teclado mostrar los últimos dígitos de cada número. 
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int num1,num2,num3;
        System.out.println("Ingrese el primer numero:");
        num1 = lector.nextInt();
        int UltimoDigito_num1 =  (num1 % 10);

        System.out.println("Ingrese el segundo numero:");
        num2 = lector.nextInt();
        int UltimoDigito_num2 = (num2 % 10);

        System.out.println("Ingresa el tercer numero:");
        num3 = lector.nextInt();
        int UltimoDigito_num3 = (num3 % 10);

        System.out.println("Los numeros ingresados son:");
        System.out.println("Numero 1:"+num1+"="+"Su ultimo digito es:"+UltimoDigito_num1);
        System.out.println("Numero 2:"+num2+"="+"Su ultimo digito es:"+UltimoDigito_num2);
        System.out.println("Numero 3:"+num3+"="+"Su ultimo digito es:"+UltimoDigito_num3);
        lector.close();
    }
}
