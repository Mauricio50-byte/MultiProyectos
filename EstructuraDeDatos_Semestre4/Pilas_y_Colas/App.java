package Pilas_y_Colas;

import java.util.Scanner;

public class App {
    
    private static MetodosListaSimples Simples = new MetodosListaSimples();
    private static MetodosListasDobles Dobles = new MetodosListasDobles();
    private static Scanner Lector = new Scanner(System.in);
    
    private static void Menu(){
        System.out.println("\nOperaciones de la lista enlazada:");
        System.out.println("1. Insertar al inicio.");
        System.out.println("2. Insertar al final.");
        System.out.println("3. Insertar despues de posicion.");
        System.out.println("4. Insertar antes de posicion.");
        System.out.println("5. Insertar en una posicion.");
        System.out.println("6. Eliminar al inicio.");
        System.out.println("7. Eliminar al final.");
        System.out.println("8. Eliminar antes de posicion.");
        System.out.println("9. Eliminar despues de posicion.");
        System.out.println("10. Eliminar en una posicion.");
        System.out.println("11. Buscar.");
        System.out.println("12. Recorrer la lista.");
        System.out.println("13. Ordenar la lista.");
        System.out.println("0. Salir.\n");
    }
    @SuppressWarnings("unused")
    private void MenuFilas_Colas(){
        System.out.println("1. Insertar un elemento.");
        System.out.println("2. Eliminar un elemento.");
        System.out.println("3. Insertar en un posicion.");
        System.out.println("3. eliminar en una posicion.");
        System.out.println("4. Invertir");
    }
    @SuppressWarnings("unused")
    private static void OpListasDobles(){
        while (true) {            
            Menu();
            System.out.print("Selecciona una opcion: ");
            String opcion = Lector.nextLine();
            try {
                switch(opcion){
                    case "1":
                        System.out.print("Ingrese un dato: ");
                        String dato = Lector.nextLine();
                        Dobles.InsertarAlInicio(new Nodo(dato));
                        break;
                    case "2":
                        System.out.print("Ingrese un dato: ");
                        String dato1 = Lector.nextLine();
                        Dobles.InsertaraAlFinal(new Nodo(dato1));
                        break;
                    case "3":
                        System.out.print("Ingrese un dato: ");
                        String dato2 = Lector.nextLine();
                        System.out.print("Ingrese la posicion: ");
                        String pos = Lector.nextLine();
                        Dobles.InsertarDespuesDePos(new Nodo(dato2), pos);
                        break;
                    case "4":
                        System.out.print("Ingrese un dato: ");
                        String dato3 = Lector.nextLine();
                        System.out.print("Ingrese la posicion: ");
                        String pos1 = Lector.nextLine();
                        Dobles.InsertarAntesDePos(new Nodo(dato3), pos1);
                        break;
                    case "5":
                        System.out.print("Ingrese un dato: ");
                        String dato4 = Lector.nextLine();
                        System.out.print("Ingrese la posicion: ");
                        int pos2 = Lector.nextInt();
                        Dobles.InsertarEnPosicion(pos2, new Nodo(dato4));
                        break;
                    case "6":
                        Dobles.EliminarAlInicio();
                        break;
                    case "7":
                        Dobles.EliminarAlFinal();
                        break;
                    case "8":
                        System.out.print("Ingrese un dato: ");
                        String dato5 = Lector.nextLine();
                        Dobles.EliminarAntesDePos(dato5);
                        break;
                    case "9":
                        System.out.print("Ingrese un dato: ");
                        String dato6 = Lector.nextLine();
                        Dobles.EliminarDespuesDePos(dato6);
                        break;
                    case "10":
                        System.out.print("Ingrese una posicion: ");
                        int pos4 = Lector.nextInt();
                        Dobles.EliminarEnPosicion(pos4);
                        break;
                    case "11":
                        System.out.print("Ingrese el dato que desea Buscar: ");
                        String dato7 = Lector.nextLine();
                        Dobles.Buscar(dato7);
                        break;
                    case "12":
                        Dobles.Recorrer();
                        break;
                    case "13":
                        Dobles.ordenar();
                        break;
                    case "0":
                        System.out.println("Saliendo...");
                        Lector.close();
                        return;
                    default:
                        System.out.println("Opcion no valida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static void OpListasSimples(){
        while (true) {            
            Menu();
            System.out.print("Selecciona una opcion: ");
            String opcion = Lector.nextLine();
            try {
                switch(opcion){
                    case "1":
                        LimpiarPantalla();
                        System.out.print("Ingrese un dato: ");
                        String dato = Lector.nextLine();
                        Simples.InsertarAlInicio(new Nodo(dato));
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "2":
                        LimpiarPantalla();
                        System.out.print("Ingrese un dato: ");
                        String dato1 = Lector.nextLine();
                        Simples.InsertarAlFinal(new Nodo(dato1));
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "3":
                        LimpiarPantalla();
                        System.out.print("Ingrese un dato: ");
                        String dato2 = Lector.nextLine();
                        System.out.print("Ingrese la posicion: ");
                        String pos = Lector.nextLine();
                        Simples.InsertarDespuesDePos(new Nodo(dato2), pos);
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "4":
                        System.out.print("Ingrese un dato: ");
                        String dato3 = Lector.nextLine();
                        System.out.print("Ingrese la posicion: ");
                        String pos1 = Lector.nextLine();
                        Simples.InsertarAntesDePos(new Nodo(dato3), pos1);
                        break;
                    case "5":
                        LimpiarPantalla();
                        System.out.print("Ingrese un dato: ");
                        String dato4 = Lector.nextLine();
                        System.out.print("Ingrese la posicion: ");
                        int pos2 = Lector.nextInt();
                        Simples.InsertarEnPosicion(pos2, new Nodo(dato4));
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "6":
                        LimpiarPantalla();
                        Simples.EliminarAlInicio();
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "7":
                        LimpiarPantalla();
                        Simples.EliminarAlFinal();
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "8":
                        LimpiarPantalla();
                        System.out.print("Ingrese un dato: ");
                        String dato5 = Lector.nextLine();
                        Simples.EliminarAntesDePos(dato5);
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "9":
                        LimpiarPantalla();
                        System.out.print("Ingrese un dato: ");
                        String dato6 = Lector.nextLine();
                        Simples.EliminarDespuesDePos(dato6);
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "10":
                        LimpiarPantalla();
                        System.out.print("Ingrese una posicion: ");
                        int pos4 = Lector.nextInt();
                        Simples.EliminarEnPosicion(pos4);
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "11":
                        LimpiarPantalla();
                        System.out.print("Ingrese el dato que desea Buscar: ");
                        String dato7 = Lector.nextLine();
                        Simples.Buscar(dato7);
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "12":
                        LimpiarPantalla();
                        Simples.Recorrer();
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "13":
                        LimpiarPantalla();
                        Simples.ordenar();
                        Pausa();
                        LimpiarPantalla();
                        break;
                    case "0":
                        LimpiarPantalla();
                        System.out.println("Saliendo...");
                        Lector.close();
                        return;
                    default:
                        System.out.println("Opcion no valida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        OpListasSimples();
    }
    
    // Metodo para limpiar la pantalla
    public static void LimpiarPantalla() {
        try{
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Metodo para pausar la ejecucion del programa
    public static void Pausa() {
        Lector.nextLine(); //Limpiamos buffer del System.in
        System.out.println("\t\nPresione enter para continuar...");
        Lector.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
    }
}
