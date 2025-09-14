import java.util.Scanner;

public class Ejercicio_14 {
    /* 14.Introducir un número por teclado supone que tiene cuatro dígitos, Desplegar la
suma de los dígitos.*/
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el numero con los 4 digitos:");
        int numero = lector.nextInt();

        int digito1 = (numero / 1000);
        int digito2 = (numero / 100) % 10;
        int digito3 = ((numero %= 100)/10);
        int digito4 = (numero % 10);

        int suma = (digito1 + digito2 + digito3 + digito4);
        System.out.println("La suma de todos los digitos del numero introducido es:"+suma);
    }
}
