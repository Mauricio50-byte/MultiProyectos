package ListasEnlazadasDobles;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Metodos lista = new Metodos();
        Scanner lector = new Scanner(System.in);
        
//        while (true) {            
//            
//            System.out.println("Menu de Opciones:");
//            System.out.println("1. Insertar al inicio.");
//            System.out.println("2. Insertar al final.");
//            System.out.println("3. Insertar despues de posicion.");
//            System.out.println("3. Eliminar al final.");
//            System.out.println("4. Eliminar al final.");
//            System.out.println("5. Recorrer.");
//            System.out.println("6. RecorrerInversa.");
//            System.out.println("0. Salir.");
//            
//            System.out.print("Selecciona una opcion: ");
//            String opcion = lector.nextLine();
//            
//            try {
//                switch(opcion){
//                
//                    case "1":
//                        System.out.println("Ingrese un dato: ");
//                        String dato = lector.nextLine();
//                        lista.InsertarAlInicio(new Nodo(dato));
//                        break;
//                    case "2":
//                        System.out.println("Ingrese un dato: ");
//                        String dato1 = lector.nextLine();
//                        lista.InsertaraAlFinal(new Nodo(dato1));
//                        break;
//                    case "3":
//                        lista.EliminarAlInicio();
//                        break;
//                    case "4":
//                        lista.EliminarAlFinal();
//                        break;
//                    case "5":
//                        lista.Recorrer();
//                        break;
//                    case "6":
//                        lista.RecorrerInversa();
//                        break;
//                    case "0":
//                        System.out.println("Saliendo.....");
//                        return;
//                    default:
//                        System.out.println("Opcion no valida. Intenta de nuevo.");
//                }
//            } catch (Exception e) {
//                 System.out.println("Error: " + e.getMessage());
//            }
        lista.InsertarAlInicio(new Nodo("Mango"));
        lista.InsertaraAlFinal(new Nodo("Coco"));
        lista.InsertarAlInicio(new Nodo ("Naranja"));
        lista.InsertaraAlFinal(new Nodo("Fresa"));
        lista.Recorrer();
        System.out.println(" ");
        lista.EliminarAlInicio();
        lista.Recorrer();
        System.out.println(" ");
        lista.EliminarAlFinal();
        lista.Recorrer();
        System.out.println(" ");
        lista.InsertarDespuesDePos(new Nodo("Mandarina"), "Coco");
        lista.Recorrer();
        System.out.println(" ");
        lista.InsertarAntesDePos(new Nodo("Yuca"), "Coco");
        lista.Recorrer();
        System.out.println(" ");
        lista.RecorrerInversa();
        Nodo busca = lista.Buscar("Coco");
        System.out.println(busca);
//        }
    }
    
}
