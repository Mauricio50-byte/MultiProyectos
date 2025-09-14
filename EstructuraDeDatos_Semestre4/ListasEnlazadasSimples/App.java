package ListasEnlazadasSimples;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Metodos lista = new Metodos();
        Scanner Lector = new Scanner(System.in);

        while (true) {
            System.out.println("\nOperaciones de la lista enlazada:");
            System.out.println("1. Insertar al inicio.");
            System.out.println("2. Insertar al final.");
            System.out.println("3. Insertar antes de posicion.");
            System.out.println("4. Insertar despues de posicion.");
            System.out.println("5. Insertar en una posicion.");
            System.out.println("6. Eliminar al inicio.");
            System.out.println("7. Eliminar al final.");
            System.out.println("8. Eliminar antes de posicion.");
            System.out.println("9. Eliminar despues de posicion.");
            System.out.println("10. Eliminar en una posicion.");
            System.out.println("11. Buscar un valor.");
            System.out.println("12. Recorrer la lista.");
            System.out.println("13. Ordenar la lista.");
            System.out.println("0. Salir.\n");

            System.out.print("Selecciona una opcion: ");
            String opcion = Lector.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        System.out.print("Ingresa el valor a insertar al inicio: ");
                        int valorInicio = Integer.parseInt(Lector.nextLine());
                        lista.insertarAlInicio(valorInicio);
                        break;
                    case "2":
                        System.out.print("Ingresa el valor a insertar al final: ");
                        int valorFinal = Integer.parseInt(Lector.nextLine());
                        lista.insertarAlFinal(valorFinal);
                        break;
                    case "3":
                        System.out.print("Ingresa el valor a insertar: ");
                        int valorPosicion = Integer.parseInt(Lector.nextLine());
                        System.out.print("Ingresa la posicion donde desee insertar: ");
                        int posicionInsertar = Integer.parseInt(Lector.nextLine());
                        lista.insertarAntesDePosicion(valorPosicion, posicionInsertar);
                        break;
                    case "4":
                        System.out.print("Ingresa el valor a insertar: ");
                        int valorPosicion1 = Integer.parseInt(Lector.nextLine());
                        System.out.print("Ingresa la posicion donde desee insertar: ");
                        int posicionInsertar1 = Integer.parseInt(Lector.nextLine());
                        lista.insertarDespuesDePosicion(valorPosicion1, posicionInsertar1);
                        break;
                    case "5":
                        System.out.print("Ingresa el valor a insertar: ");
                        int valorPosicion2 = Integer.parseInt(Lector.nextLine());
                        System.out.print("Ingresa la posicion donde desee insertar: ");
                        int posicionInsertar2 = Integer.parseInt(Lector.nextLine());
                        lista.insertarEnPosicion(valorPosicion2, posicionInsertar2);
                        break;
                    case "6":
                        lista.eliminarAlInicio();
                        break;
                    case "7":
                        lista.eliminarAlFinal();
                        break;
                    case "8":
                        System.out.print("Ingresa la posicion : ");
                        int pos = Integer.parseInt(Lector.nextLine());
                        lista.eliminarAntesDePosicion(pos);
                        break;
                    case "9":
                        System.out.print("Ingresa la posicion : ");
                        int pos1 = Integer.parseInt(Lector.nextLine());
                        lista.eliminarDespuesDePosicion(pos1);
                        break;
                    case "10":
                        System.out.print("Ingresa la posicion a eliminar: ");
                        int posicionEliminar = Integer.parseInt(Lector.nextLine());
                        lista.eliminarEnPosicion(posicionEliminar);
                        break;
                    case "11":
                        System.out.print("Ingresa el valor a buscar: ");
                        int valorBuscar = Integer.parseInt(Lector.nextLine());
                        int posicionEncontrada = lista.buscar(valorBuscar);
                        System.out.println("Valor encontrado en la posicion: " + posicionEncontrada);
                        break;
                    case "12":
                        lista.recorrer();
                        break;
                    case "13":
                        System.out.println("Ordenando la lista...");
                        lista.ordenar();
                        System.out.println("Lista ordenada:");
                        lista.recorrer();
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
}
