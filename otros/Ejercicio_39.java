import java.util.Scanner;

public class Ejercicio_39 {
/*39.Una persona pasa el 34 por ciento de su vida durmiendo. Dado el año de
nacimiento, el año actual y el nombre de una persona, imprimir cuántos días ha
dormido. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int añoActual = 2023;
        System.out.println("Ingrse su nombre:");
        String nombre = lector.nextLine();
        System.out.println("Ingrse su año de nacimiento:");
        int añoNacimiento = lector.nextInt();

        double dias = añoActual - añoNacimiento * 365 * 0.34;
        System.out.println("El señor@ - "+nombre+" - nacion en el año"+"("+añoNacimiento+")"+" - y ha pasado - "+dias+"(dias de su vida durmiendo)");
    }
} 
