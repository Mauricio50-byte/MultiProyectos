import java.util.Scanner;

public class Ejercicio111 {
    /*111. Programa que pida un número de día y lo muestre en formato de texto, ejemplo:
1=Domingo, 2=Lunes... 7=Sábado . */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese un número de día (1-7): ");
        int numeroDia = lector.nextInt();

        String nombreDia;

        switch (numeroDia) {
            case 1:
                nombreDia = "Domingo";
                break;
            case 2:
                nombreDia = "Lunes";
                break;
            case 3:
                nombreDia = "Martes";
                break;
            case 4:
                nombreDia = "Miércoles";
                break;
            case 5:
                nombreDia = "Jueves";
                break;
            case 6:
                nombreDia = "Viernes";
                break;
            case 7:
                nombreDia = "Sábado";
                break;
            default:
                nombreDia = "Número de día no válido";
                break;
        }

        System.out.println("El nombre del día es: " + nombreDia);

        lector.close();
    }
}
