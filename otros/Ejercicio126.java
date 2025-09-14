import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio126 {
    /*126. Programa que de acuerdo a la fecha dada por el usuario en formato AAAA MM
DD y la muestre en formato texto. Ejemplo: 2012 01 23 deberá ser mostrado como:
23 Enero de 2012. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la fecha en formato AAAA MM DD (por ejemplo, 2012 01 23): ");
        int año = lector.nextInt();
        int mes = lector.nextInt();
        int dia = lector.nextInt();

        lector.close();

        // Crear una fecha usando el formato proporcionado
        Date fecha = new Date(año - 1900, mes - 1, dia);

        // Formatear la fecha al formato deseado
        DateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaTexto = formatoFecha.format(fecha);

        System.out.println(fechaTexto);
    }
}
