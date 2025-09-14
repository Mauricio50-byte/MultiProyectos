import java.util.Scanner;

public class Ejercicio83 {
    /*83. Desarrolle el código fuente de un programa que permita ingresar tres números,
obtener su promedio y visualizar “APROBADO”, si su promedio es mayor a 7, caso
contrario visualizará “MEJORE LA NOTA”.*/
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double num1 = lector.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = lector.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double num3 = lector.nextDouble();

        // Calcular el promedio
        double promedio = (num1 + num2 + num3) / 3;

        // Mostrar el promedio
        System.out.println("El promedio es: " + promedio);

        // Verificar si el promedio es mayor a 7 y mostrar el resultado
        if (promedio > 7) {
            System.out.println("APROBADO");
        } else {
            System.out.println("MEJORE LA NOTA");
        }
        lector.close();
    }
}
