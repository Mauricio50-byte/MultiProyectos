import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nuevo_Juego{
    /*Imaginemos que vamos a participar en un juego de la suerte, el cual tiene las
siguientes reglas:
Un conjunto de personas se registra en una lista (participantes)
Una persona toma una bolsa llena de papelitos, cada uno contiene un número
ue corresponde la cantidad de 1 a N de la lista de participantes
Una persona saca un papelito y dice el numero que salio de forma aleatoria,
entonces, inicia el juego:
Comienza el participante que cuya posición en la lista coincida con el número
que fue sacado aleatoriamente de la bolsa.
1. El jugador debe tomar dos dados y realizar X cantidad de lanzamientos.
2. Una persona va anotando en un tablero visible por todos el resultado de
os números que salieron en cada uno de los lanzamientos hechos por
cada participante, esos datos sirven para calcular las siguientes
estadisticas:
*Cuantos 1, 2, 3, 4, 5, 6, 7, 8, .., etc..
*Cuanto dobles salieron (doble 1, doble 2, doble 3, ...).
*Cuántos números pares salientes (cuantos 2, 4, 6, 8,...).
*Cuántos números impares salieron (cuantos 3, 5, 7, 9,..
*La suma de cada lanzamiento (1 y 3= 4, 5y4=9,...).
*El promedio de apariciones de cada número.
*La sumatoria de todos los lanzamientos.
*El promedio de todos los lanzamientos.
*Si el jugador saca 3 veces seguida X número, pierde el juego.
*Si el jugador saca 3 veces seguidas un número doble, entonces
ganará el juego automáticamente.
3. Si nadie gana el juego automáticamente, entonces, ganará el jugador que
tenga la sumatoria general más alta y la sumatoria de dobles más alta.
4. Si no existe un jugador que cumpla con la condición anterior, entonces:
a. Gana el primer lugar el jugador que tenga la sumatoria más alta.
b. EI segundo lugar lo tendrá el que tenga la sumatoria de dobles más
alta.
c. El tercer lugar lo tendrá el que saque el valor más alto de la
sumatoria de 7 más la sumatoria 14.
5. Hacer un programa que haga una simulación del juego anterior */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("-------------------------BIENVENIDOS A ESTE NUEVO Y MARAVILLOZO JUEGO----------------------------");
        System.out.println("                                          ||||                                                   ");
        System.out.println("----------------------------DADOS DE LA SUERTE MRK EL QUE PIERDA---------------------------------\n");
        System.out.println("Ingrese el numero de participantes que ban a jugar: ");
        int numParticipantes = lector.nextInt();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("POR FAAVOR SE LE PIDE A LOS " + numParticipantes + " (PARTICIPANTES) REGISTRARSE PARA PODER JUGAR");
        System.out.println("-------------------------------------------------------------------------------------------------\n");
        List<String> participantes = new ArrayList<>();
        for(int i = 0; i < numParticipantes; i++ ){
            System.out.println("Ingrese el nombre del participante " + (i + 1) + " : ");
            String nombre = lector.next();
            System.out.println("Ingrese el apellido del participante " + (i + 1) + " : ");
            String apellido = lector.next();
            participantes.add(nombre  +"                             " + apellido);
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("El participante " + nombre + " " + apellido + " ha sido registrado");
            System.out.println("-------------------------------------------------------------------------------------------------\n");
        }
            System.out.println("**********************************************************");
            System.out.println("                LISTADO DE PARTICIPANTES                  ");
            System.out.println("**********************************************************");
            System.out.println(        "Nombre                            apellidos       ");
            System.out.println("----------------------------------------------------------");
            for (String dato : participantes) {
                System.out.println(dato);
            }
            System.out.println("----------------------------------------------------------\n");
            List<Integer> bolsa = new ArrayList<>();
            for (int i = 1; i <= participantes.size(); i++) {
                bolsa.add(i);
            }
    
            // Sacar un papelito de la bolsa y decir el número que salió de forma aleatoria
            int numeroAleatorio = bolsa.get((int) (Math.random() * bolsa.size()));
            System.out.println("El numero aleatorio es: " + numeroAleatorio);
    
            // Iniciar el juego
            int jugadorActual = numeroAleatorio - 1;
            System.out.println("Jugador actual : " + jugadorActual);
            int dados = 2;
            System.out.println("Dados : " + dados);
            int lanzamientos = 10;
            int[][] resultados = new int[participantes.size()][lanzamientos];
            int[] sumas = new int[participantes.size()];
            int[] dobles = new int[participantes.size()];
            int[] pares = new int[participantes.size()];
            int[] impares = new int[participantes.size()];
    
            // Realizar los lanzamientos de dados para cada participante
            for (int i = 0; i < lanzamientos; i++) {
                for (int j = 0; j < participantes.size(); j++) {
                        int dado1 = (int) (Math.random() * 6) + 1;
                        int dado2 = (int) (Math.random() * 6) + 1;
                        int suma = dado1 + dado2;
                        resultados[j][i] = suma;
                        sumas[j] += suma;
                        if (dado1 == dado2) {
                            dobles[j]++;
                        }
                        if (suma % 2 == 0) {
                            pares[j]++;
                        } else {
                            impares[j]++;
                        }
                }
            }
            // Continuación del juego y cálculo de estadísticas
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("RESULTADOS DEL JUEGO");
            System.out.println("------------------------------------------------------------------------------------------------\n");
            for (int i = 0; i < participantes.size(); i++) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("Resultados para el participante: " + participantes.get(i));
                System.out.println("--------------------------------------------------------------------------------------------\n");
                System.out.println("Lanzamientos: " + lanzamientos);
                System.out.println("Suma de lanzamientos: " + sumas[i]);
                System.out.println("Dobles obtenidos: " + dobles[i]);
                System.out.println("Numeros pares obtenidos: " + pares[i]);
                System.out.println("Numeros impares obtenidos: " + impares[i]);
                System.out.println("--------------------------------------------------------------------------------------------\n ");
            }

            // Calcular promedio de apariciones de cada número
            double[] promedios = new double[participantes.size()];
            for (int i = 0; i < participantes.size(); i++) {
                promedios[i] = (double) sumas[i] / lanzamientos;
                System.out.println("Promedio de apariciones para " + participantes.get(i) + ": " + promedios[i]);
            }

            // Calcular sumatoria de todos los lanzamientos
            int sumatoriaGeneral = 0;
            for (int i = 0; i < participantes.size(); i++) {
                sumatoriaGeneral += sumas[i];
            }
            System.out.println("Sumatoria general de lanzamientos: " + sumatoriaGeneral);

            // Calcular promedio de todos los lanzamientos
            double promedioGeneral = (double) sumatoriaGeneral / (participantes.size() * lanzamientos);
            System.out.println("Promedio general de lanzamientos: " + promedioGeneral);

            // Verificar ganador del juego
            int ganador = 0;
            for (int i = 1; i < participantes.size(); i++) {
                if (sumas[i] > sumas[ganador] || (sumas[i] == sumas[ganador] && dobles[i] > dobles[ganador])) {
                    ganador = i;
                }
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("GANADOR DEL JUEGO: " + participantes.get(ganador));
            System.out.println("------------------------------------------------------------------------------------------------");
            
            lector.close();
    }
}

