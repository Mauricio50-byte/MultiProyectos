import java.util.Scanner;

public class Ejercicio76 {
    /*76. Dado un número entero, indicar el número de cifras de ese número ( para el 432
debe indicar 3). */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingrese un número entero: ");
        int numero = lector.nextInt();
        
        int numeroCifras = contarCifras(numero);
        
        System.out.println("El número de cifras en " + numero + " es: " + numeroCifras);
        lector.close();
    }
    
    public static int contarCifras(int numero) {
        // Convertir el número a una cadena y contar la longitud de la cadena
        String numeroStr = String.valueOf(numero);
        return numeroStr.length();
    }
}
