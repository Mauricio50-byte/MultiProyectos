import java.util.Scanner;

public class Ejercicio127 {
    /*127. Programa que de acuerdo a la fecha dada por el usuario (día,mes,año)
determine a qué estación del año pertenece (primavera, verano, otoño, invierno). */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese el día: ");
        int dia = lector.nextInt();

        System.out.print("Ingrese el mes (1-12): ");
        int mes = lector.nextInt();

        System.out.print("Ingrese el año: ");
        lector.nextInt();

        lector.close();

        String estacion;

        switch (mes) {
            case 1:
            case 2:
                estacion = "Invierno";
                break;
            case 3:
                if (dia < 21)
                    estacion = "Invierno";
                else
                    estacion = "Primavera";
                break;
            case 4:
            case 5:
                estacion = "Primavera";
                break;
            case 6:
                if (dia < 21)
                    estacion = "Primavera";
                else
                    estacion = "Verano";
                break;
            case 7:
            case 8:
                estacion = "Verano";
                break;
            case 9:
                if (dia < 21)
                    estacion = "Verano";
                else
                    estacion = "Otoño";
                break;
            case 10:
            case 11:
                estacion = "Otoño";
                break;
            case 12:
                if (dia < 21)
                    estacion = "Otoño";
                else
                    estacion = "Invierno";
                break;
            default:
                estacion = "Mes no válido";
                break;
        }

        System.out.println("La estación del año para la fecha ingresada es: " + estacion);
    }
}
