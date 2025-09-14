import java.util.Scanner;

public class Ejercicio_22 {
    //22.Introducir un número real, mostrar la parte entera y la parte decimal del número.
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca un numero real:");
        double numero = lector.nextDouble();
        int parteEntera = (int) numero;
        double parteDesimal = numero - parteEntera;
        System.out.println("La parte entera del numero real es:"+parteEntera);
        System.out.println("La parte decimal del numero real es:"+parteDesimal);
    }
}
