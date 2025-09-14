import java.util.Scanner;

public class Ejercicio110 {
    /*110. Programa que escriba en pantalla un comentario con respecto a la temperatura
del día. Tomando en cuenta que Mucho Frío ( 0 -10) , Frío (11-18)
, Templado (19-25), Calor(26-40). */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la temperatura del día: ");
        double temperatura = lector.nextDouble();

        String comentario;

        if (temperatura >= 0 && temperatura <= 10) {
            comentario = "Mucho Frío";
        } else if (temperatura >= 11 && temperatura <= 18) {
            comentario = "Frío";
        } else if (temperatura >= 19 && temperatura <= 25) {
            comentario = "Templado";
        } else if (temperatura >= 26 && temperatura <= 40) {
            comentario = "Calor";
        } else {
            comentario = "Temperatura fuera de rango.";
        }

        System.out.println("Comentario sobre la temperatura del día: " + comentario);

        lector.close();
    }
}
