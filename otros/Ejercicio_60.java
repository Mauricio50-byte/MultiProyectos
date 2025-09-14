import java.util.Scanner;

public class Ejercicio_60 {
    /*60.Realice un programa que lea de la entrada estándar números hasta que se
introduzca un cero. En ese momento el programa debe terminar y mostrar en la
salida estándar el número de valores mayores que cero leídos. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
          int contador = 0;

          System.out.println("Ingrese números (ingrese 0 para finalizar):");

        while (true) {

            int numero = lector.nextInt();
            
            if (numero == 0) {
                break;
            }
            
            if (numero > 0) {
                contador++;
            }
        }  

        System.out.println("Cantidad de numeros mayores que cero: " + contador);
        lector.close();
    }
}