import java.util.Scanner;

public class Ejercicio_20 {
    /*20.Introducir 5 notas por teclado, obtener la suma de las notas, el promedio de las
mismas y el doble de las notas. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresea la primera nota:");
        int nota1 = lector.nextInt();
        System.out.println("Ingresea la segunda nota:");
        int nota2 = lector.nextInt();
        System.out.println("Ingresea la tercera nota:");
        int nota3 = lector.nextInt();
        System.out.println("Ingresea la cuarta nota:");
        int nota4 = lector.nextInt();
        System.out.println("Ingresea la quinta nota:");
        int nota5 = lector.nextInt();
        double suma = nota1 + nota2 + nota3 + nota4 + nota5;
        double promedioNotas = (suma / 5);
        double dobleNotas = (suma * 2);

        System.out.println("La suma de las notas es:"+suma);
        System.out.println("El promedio de las notas es:"+promedioNotas);
        System.out.println("El doble de las notas es:"+dobleNotas);
    }
}
