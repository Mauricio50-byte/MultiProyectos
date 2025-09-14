import java.util.Scanner;

public class Ejercicio112 {
    /*112. Programa que muestre en pantalla el siguiente menú de
opciones : Línea de autobuses ADO, seleccione su
destino:
a) Cartagena. [$150]
b) Barranquilla. [$320]
c) Sincelejo. [$120]
d) Valledupar. [$90]
e) Santa Marta.[$110]

Tomando en cuenta el menú anterior, obtener la opción seleccionada por el usuario
y muestre el mensaje según corresponda:

Su destino es “Cartagena”, tiempo de traslado 2 hrs, costo $200. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Menú de opciones:");
        System.out.println("a) Cartagena. [$150]");
        System.out.println("b) Barranquilla. [$320]");
        System.out.println("c) Sincelejo. [$120]");
        System.out.println("d) Valledupar. [$90]");
        System.out.println("e) Santa Marta.[$110]");
        System.out.print("Seleccione su destino (a-e): ");

        char opcion = lector.next().charAt(0);

        String destino;
        int tiempoTraslado;
        double costo;

        switch (opcion) {
            case 'a':
                destino = "Cartagena";
                tiempoTraslado = 2;
                costo = 150;
                break;
            case 'b':
                destino = "Barranquilla";
                tiempoTraslado = 3;
                costo = 320;
                break;
            case 'c':
                destino = "Sincelejo";
                tiempoTraslado = 1;
                costo = 120;
                break;
            case 'd':
                destino = "Valledupar";
                tiempoTraslado = 4;
                costo = 90;
                break;
            case 'e':
                destino = "Santa Marta";
                tiempoTraslado = 3;
                costo = 110;
                break;
            default:
                destino = "Destino no válido";
                tiempoTraslado = 0;
                costo = 0;
                break;
        }

        System.out.println("Su destino es \"" + destino + "\", tiempo de traslado " + tiempoTraslado + " hrs, costo $" + costo);

        lector.close();
    }
}
