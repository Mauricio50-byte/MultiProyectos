import java.util.Scanner;

public class Ejercicio132 {
    /*132. Programa que simula un cajero automático con un saldo inicial de $1000 y que
pida al usuario elegir entre las opciones 1.-Depósito 2.Retiro 3.Salir . En cada
depósito y en cada retiro se pedirá la cantidad a retirar ó a depositar. Al elegir salir,
el programa mostrará el saldo final en pantalla. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double saldo = 1000.0;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            int opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = lector.nextDouble();
                    saldo += cantidadDeposito;
                    System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = lector.nextDouble();
                    if (cantidadRetiro <= saldo) {
                        saldo -= cantidadRetiro;
                        System.out.println("Retiro exitoso. Saldo actual: $" + saldo);
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 3:
                    System.out.println("Saldo final: $" + saldo);
                    lector.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
