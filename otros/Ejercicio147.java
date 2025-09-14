import java.util.Scanner;

public class Ejercicio147 {
    /*147. En una clase de 5 alumnos se han realizado tres exámenes y se requiere
determinar el número de:

a) Alumnos que aprobaron todos los exámenes
b) Alumnos que aprobaron al menos un examen
c) Alumnos que aprobaron únicamente el último examen. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int aprobadosTodos = 0;
        int alMenosUno = 0;
        int soloUltimo = 0;

        for (int i = 1; i <= 5; i++) {
            int contadorAprobados = 0;

            for (int j = 1; j <= 3; j++) {
                System.out.print("Ingrese la calificación del alumno " + i + " en el examen " + j + ": ");
                int calificacion = lector.nextInt();

                if (calificacion >= 6) {
                    contadorAprobados++;
                }
            }

            if (contadorAprobados == 3) {
                aprobadosTodos++;
            }

            if (contadorAprobados > 0) {
                alMenosUno++;
            }

            if (contadorAprobados == 1) {
                soloUltimo++;
            }
        }

        System.out.println("a) Alumnos que aprobaron todos los exámenes: " + aprobadosTodos);
        System.out.println("b) Alumnos que aprobaron al menos un examen: " + alMenosUno);
        System.out.println("c) Alumnos que aprobaron únicamente el último examen: " + soloUltimo);

        lector.close();
    }
}
