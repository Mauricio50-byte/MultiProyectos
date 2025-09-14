import java.util.Scanner;

public class Ejercicio_28 {
/*28.Programa que muestre en pantalla una cuenta atrás de números tomando en
cuenta el número leído de teclado (ej. 7,6,5,4,3,2,1,0). */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un numero:");
        int num = lector.nextInt();
        if(num < 0){
           System.out.println("Ingrese un numero positivo.");
           return;
        }
        for(int i = num; i >= 0; i--){
            System.out.println(i);
        }
    }
}
