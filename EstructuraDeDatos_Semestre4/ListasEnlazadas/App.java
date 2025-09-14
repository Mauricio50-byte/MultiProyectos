package ListasEnlazadas;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Metodos lista = new Metodos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOperaciones de la lista enlazada:");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en una posicion");
            System.out.println("4. Eliminar al inicio");
            System.out.println("5. Eliminar al final");
            System.out.println("6. Eliminar en una posicion");
            System.out.println("7. Buscar un valor");
            System.out.println("8. Recorrer la lista");
            System.out.println("9. Ordenar la lista");
            System.out.println("0. Salir");

            System.out.print("Selecciona una opcion: ");
            String opcion = scanner.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        System.out.print("Ingresa el valor a insertar al inicio: ");
                        int valorInicio = Integer.parseInt(scanner.nextLine());
                        lista.insertarAlInicio(valorInicio);
                        break;
                    case "2":
                        System.out.print("Ingresa el valor a insertar al final: ");
                        int valorFinal = Integer.parseInt(scanner.nextLine());
                        lista.insertarAlFinal(valorFinal);
                        break;
                    case "3":
                        System.out.print("Ingresa el valor a insertar: ");
                        int valorPosicion = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingresa la posicion donde insertar: ");
                        int posicionInsertar = Integer.parseInt(scanner.nextLine());
                        lista.insertarEnPosicion(valorPosicion, posicionInsertar);
                        break;
                    case "4":
                        lista.eliminarAlInicio();
                        break;
                    case "5":
                        lista.eliminarAlFinal();
                        break;
                    case "6":
                        System.out.print("Ingresa la posicion a eliminar: ");
                        int posicionEliminar = Integer.parseInt(scanner.nextLine());
                        lista.eliminarEnPosicion(posicionEliminar);
                        break;
                    case "7":
                        System.out.print("Ingresa el valor a buscar: ");
                        int valorBuscar = Integer.parseInt(scanner.nextLine());
                        int posicionEncontrada = lista.buscar(valorBuscar);
                        System.out.println("Valor encontrado en la posicion: " + posicionEncontrada);
                        break;
                    case "8":
                        lista.recorrer();
                        break;
                    case "9":
                        System.out.println("Ordenando la lista...");
                        lista.ordenar();
                        System.out.println("Lista ordenada:");
                        lista.recorrer();
                        break;
                    case "0":
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opcion no valida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
