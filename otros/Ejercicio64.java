import java.util.Scanner;

public class Ejercicio64 {
    /*64.Escriba un programa que calcule x^y, donde tanto x como y son enteros positivos,
sin utilizar la función pow() /* */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese x: ");
        int x = lector.nextInt();
        
        System.out.println("Ingrese y: ");
        int y = lector.nextInt();

        int resultado = calcularPotencia(x, y);
        
        System.out.println(x + " elevado a la " + y + " es igual a: " + resultado);
        
        lector.close();
    }
    
    public static int calcularPotencia(int x, int y) {
        if (y == 0) {
            return 1;
        }
        
        int resultado = 1;
        
        // Multiplicar x por sí mismo y veces
        for (int i = 0; i < y; i++) {
            resultado *= x;
        }
        
        return resultado;
    }  
}
