import java.util.Scanner;

public class Ejercicio105 {
    /*105. Desarrolle el código fuente de un programa que permita ingresar cuatro notas
sobre 20 con decimales, obtener su promedio y visualizar “APROBADO”, si su
promedio es mayor a 14.5; caso contrario su promedio sea menor a 14.5 y mayor a
10 visualizará “SUPLETORIO”. Si la nota promedio es menor a 10 mostrará
“PERDIDO EL AÑO”. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la primera nota: ");
        double nota1 = lector.nextDouble();

        System.out.print("Ingrese la segunda nota: ");
        double nota2 = lector.nextDouble();

        System.out.print("Ingrese la tercera nota: ");
        double nota3 = lector.nextDouble();

        System.out.print("Ingrese la cuarta nota: ");
        double nota4 = lector.nextDouble();

        double promedio = (nota1 + nota2 + nota3 + nota4) / 4.0;

        String estado;
        if (promedio > 14.5) {
            estado = "APROBADO";
        } else if (promedio >= 10) {
            estado = "SUPLETORIO";
        } else {
            estado = "PERDIDO EL AÑO";
        }

        System.out.println("El promedio de las notas es: " + promedio);
        System.out.println("Estado del estudiante: " + estado);
        lector.close();
    }
}
