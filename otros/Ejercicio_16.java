import java.util.Scanner;

public class Ejercicio_16 {
    //16.Algoritmo que determine si una persona gano o no un examen matemático
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("ingrese la nota maxima para poder ganar el examen de matenaticas:");
        int nota = lector.nextInt();
        if (nota >= 3) {
            System.out.println("Flicidades ganastes el examen tu nota es:"+nota);
        } else {
           System.out.println("Lo siento, pero reprobastes el examen tu nota es:"+nota); 
        }
    }
}
