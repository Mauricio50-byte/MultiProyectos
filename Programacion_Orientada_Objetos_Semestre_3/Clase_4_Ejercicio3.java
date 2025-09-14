import java.util.*;

public class Clase_4_Ejercicio3 {
    /* EJRCICIO:
            
            # Crear un programa que ingrese un pool de datos de una encuestas
            y permita al usuario consultar la cantidad de datos de una opcion
            especifica.

            Nota: "encuesta de telefono"
            -telefonia
            *Claro - Cla
            *Tigo - Tigo
            *Movistar - Mov
            *Virgin - vir
            
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner (System.in);
        System.out.println("Digite el numero de datos:");
        int datos = lector.nextInt();
        String v [] = new String[datos];
        Scanner lector2 = new Scanner(System.in);
        for (int i = 0; i < datos; i++) {
            System.out.println(". #Claro\n. #Tigo\n. #Movistar\n. #Virgin\n"
            +"Digite la empresa de telefonia de su preferencia:");
            v [i] = lector2.nextLine();
        }
        //aqui el usuario puede consultar la cantidad de datos de una opcion especifica
        System.out.println(". #Claro\n. #Tigo\n. #Movistar\n. #Virgin\n"
            +"Digite la opcion a cunsultar:");
        String consulta = lector2.nextLine();
        int contador = 0;
        // recorremos los datos de la encuesta y los guradamos en el vector
        for (int j = 0; j < datos; j++) {
            if (v[j].equalsIgnoreCase(consulta)) {
                contador++;
            }
        }
        //
        if (contador > 0 ) {
            System.out.println("La cantidad de datos de "+ consulta + " es :" + contador);
        } else {
            System.out.println("no hay datos");
        }
        lector.close();
        lector2.close();
    }
}
