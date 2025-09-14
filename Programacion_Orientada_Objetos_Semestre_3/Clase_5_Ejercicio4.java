import java.util.Scanner;

public class Clase_5_Ejercicio4 {
    /* EJRCICIO:
            
            # Crear un programa que ingrese los dcatos a tabular de una encuesta de telefonia
            y por medio de funciones:
            - Calcule el total de votaciones de cada empresa.
            - Consulte el total de votaciones de una empresa.
            - Indicar quien gano la votacion.

            Nota: "encuesta de telefono"
            -telefonia
            *Claro - Cla
            *Tigo - Tigo
            *Movistar - Mov
            *Virgin - vir
            
     */
    
    public static void main(String[] args) {
        Scanner lector = new Scanner (System.in);
        Scanner lector2 = new Scanner (System.in);
        System.out.println("Digite el numero de datos:");
        int datos = lector.nextInt();
        String v [] = new String[datos];
        for (int i = 0; i < datos; i++) {
            System.out.println(". #Claro\n. #Tigo\n. #Movistar\n. #Virgin\n"
            +"Digite la empresa de telefonia de su preferencia:");
            v [i] = lector2.nextLine();
        }
         // Menú
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Calcular el total de votaciones de cada empresa");
            System.out.println("2. Calcular el total de votaciones de un empresa espesifica");
            System.out.println("3. Indicar quien gano");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("############################################\n");
                    ConsulteTotalVotacionesTodas(v, datos);
                    break;
                case 2:
                    //aqui el usuario puede consultar la cantidad de datos de una opcion especifica
                    System.out.println(". #Claro\n. #Tigo\n. #Movistar\n. #Virgin\n"
                        +"Digite la opcion a cunsultar:");
                    String consulta = lector2.nextLine();
                    
                    System.out.println("############################################\n");
                    CalcularTotalVotacionesEspecificas(v , datos , consulta, datos);
                    break;
                case 3:
                    System.out.println("############################################\n");
                    ConsulteElGanador(v,datos);
                    break;
            }
        }while (opcion != 0);
        
        //Cerramos los Scanner 
        lector.close();
        lector2.close();
    }
    public static void ConsulteTotalVotacionesTodas(String v[] , int datos) {
        int Contador_Claro = 0 , Contador_Tigo = 0 , Contador_Movistar = 0 , Contador_Virgin = 0;
        // Hacemos un bucle para recorrer el vector
        for (int i = 0; i < datos; i++) {
            if (v[i].equals("Claro")) {
                Contador_Claro++;
            }
            if (v[i].equals("Tigo")) {
                Contador_Tigo++;
            }
            if (v[i].equals("Movistar")) {
                Contador_Movistar++;
            }
            if (v[i].equals("Virgin")) {
                Contador_Virgin++;
            }
        }
        System.out.println("LA CANTIDAD DE VOTOS PARA LA EMPRESA CLARO ES : " + Contador_Claro);
        System.out.println("LA CANTIDAD DE VOTOS PARA LA EMPRESA TIGO ES : " + Contador_Tigo);
        System.out.println("LA CANTIDAD DE VOTOS PARA LA EMPRESA MOVISTAR ES : " + Contador_Movistar);
        System.out.println("LA CANTIDAD DE VOTOS PARA LA EMPRESA VIRGIN ES : " + Contador_Virgin);
    }
    
    public static void CalcularTotalVotacionesEspecificas(String v[] , int datos, String consulta, int contador){
        for (int j = 0; j < datos; j++) {
            contador = 0;
            if (v[j].equals(consulta)) {
                contador++;
            } 
        }
        //
        if (contador > 0 ) {
            System.out.println("La cantidad de datos de "+ consulta + " es :" + contador);
        } else {
            System.out.println("no hay datos");
        }
    }
    public static void ConsulteElGanador(String v[] , int datos) {
        int Contador_Claro = 0 , Contador_Tigo = 0 , Contador_Movistar = 0 , Contador_Virgin = 0;
        // Hacemos un bucle para recorrer el vector
        for (int i = 0; i < datos; i++) {
            if (v[i].equals("Claro")) {
                Contador_Claro++;
            }
            if (v[i].equals("Tigo")) {
                Contador_Tigo++;
            }
            if (v[i].equals("Movistar")) {
                Contador_Movistar++;
            }
            if (v[i].equals("Virgin")) {
                Contador_Virgin++;
            }
        }
        if (Contador_Claro > Contador_Movistar 
        && Contador_Claro > Contador_Tigo 
        && Contador_Claro > Contador_Virgin) {
            System.out.println("El ganador fue (Claro)");
        } else if (Contador_Movistar > Contador_Claro 
                && Contador_Movistar > Contador_Tigo 
                && Contador_Movistar > Contador_Virgin) {
            System.out.println("El ganador fue (Movistar)");
        } else if (Contador_Tigo > Contador_Claro 
                && Contador_Tigo > Contador_Movistar 
                && Contador_Tigo > Contador_Virgin) {
            System.out.println("El ganador fue (Tigo)");
        } else if (Contador_Virgin > Contador_Claro 
                && Contador_Virgin > Contador_Movistar 
                && Contador_Virgin > Contador_Tigo) {
            System.out.println("El Ganador fue (Virgin)");
        } else {
            System.out.println("Hubo un empate en las votaciones");
        }
    }
}
