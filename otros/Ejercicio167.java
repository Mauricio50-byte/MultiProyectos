import java.util.Scanner;

public class Ejercicio167 {
    /*167. Programa que calcule el promedio de una lista de números positivos indicados
por el usuario, para terminar debe teclear 0. */
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        int num, suma = 0, contador = 0;
        System.out.println("Introduce los numeros positivos");
        do {
            num = lector.nextInt();
            if (num > 0) {
                suma += num;
                contador++;
            }
        } while (num != 0);
        double promedio = suma / contador;
        System.out.println("El promedio es: " + promedio);
        lector.close();
    }
}
