import java.util.Scanner;

public class Ejercicio70 {
   /*70. Hacer un programa que calcule el resultado de la siguiente expresión:
1-2+3-4+5-6...n*/
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrse el valor de n:");
        int n = lector.nextInt();

        int resultado = calcularExpresion(n);
        
        System.out.println("El resultado de la expresión es: " + resultado);
        
        lector.close();
    }
    
    public static int calcularExpresion(int n) {
        int resultado = 0;
        int signo = 1;  // Alternar entre sumar y restar
        
        for (int i = 1; i <= n; i++) {
            resultado += signo * i;
            signo *= -1;  // Cambiar el signo para el siguiente término
        }
        
        return resultado;

    }

}
