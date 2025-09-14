import java.util.Scanner;

public class Ejercicio141 {
    /*141. Usando la función para truncar números con decimales (ejemplo : trunc() )
realizar un programa que pida un número al usuario y calcule su raíz cuadrada.
Nota. Solo debe usarse las operaciones : + ,- ,*, / y % . */  
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese un número para calcular su raíz cuadrada: ");
        double numero = lector.nextDouble();

        // Truncamos el número para eliminar la parte decimal
        int numeroTruncado = (int) numero;

        // Inicializamos las variables necesarias
        int resultado = 0;
        int impar = 1;

        while (numeroTruncado >= impar) {
            numeroTruncado -= impar;
            impar += 2;
            resultado++;
        }

        System.out.println("La raíz cuadrada truncada de " + numero + " es: " + resultado);

        lector.close();
    }
}
