import java.util.Arrays;
import java.util.Scanner;

public class Parcial_3 {
    /* #Ejercicio:  Crear un programa que ingrese los datos en un array y por medio de una funcio indicar si el array es
    palindrome o no*/ 
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Digite la cantidad de elementos");
        int tamaño = lector.nextInt();
        int Datos[] = new int[tamaño];

        for(int i = 0; i< tamaño; i++){
            System.out.printf("Ingrese el dato ["+(i+1)+"] : ");
            Datos[i] = lector.nextInt();
        }
        System.out.println(Arrays.toString(Datos));
        
        boolean esPalindromo = palindrome(Datos, 0, Datos.length - 1);
        if (esPalindromo == true) {
            System.out.println("\nEl arreglo es Palindromo.");
        } else {
            System.out.println("\nNo es Palindromo.");
        }
        lector.close();
    }
    //funcion para saber si el array es palindrome o no es palindrome, primero tienes que invertir el array original
    public static boolean palindrome(int[] Datos, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }else{
            if (Datos[inicio] == Datos[fin]) {
                return palindrome(Datos, inicio + 1, fin - 1);
            }else{
                return false;
            }
        }
    }
}
