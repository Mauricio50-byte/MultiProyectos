import java.util.Scanner;

public class Ejercicio113 {
    /*113. Programa que calcule el costo estimado de gasolina para viajar a la ciudad de
Monterrey (distancia=500km) para uno de los 3 transportes siguientes a elegir:

1) Motocicleta
2) Automóvil
3) Pickup .

Tomando en cuenta que cada vehículo tiene un rendimiento de :
Motocicleta=20km/lt , Auto=10km/lt , Pickup=5km/lt .
Como resultado debe mostrar el gasto total de gasolina. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Seleccione el transporte:");
        System.out.println("1) Motocicleta");
        System.out.println("2) Automóvil");
        System.out.println("3) Pickup");
        System.out.print("Elija su opción (1-3): ");

        int opcion = lector.nextInt();
        double rendimiento;
        double distancia = 500; // Distancia en km a Monterrey

        switch (opcion) {
            case 1:
                rendimiento = 20; // Rendimiento de la motocicleta en km/lt
                break;
            case 2:
                rendimiento = 10; // Rendimiento del automóvil en km/lt
                break;
            case 3:
                rendimiento = 5; // Rendimiento de la pickup en km/lt
                break;
            default:
                System.out.println("Opción no válida");
                lector.close();
                return;
        }

        // Calcular el gasto total de gasolina
        double gasolinaNecesaria = distancia / rendimiento;
        double costoGasolina = gasolinaNecesaria * 4.50; // Precio de la gasolina por litro

        System.out.println("El gasto total de gasolina es: $" + costoGasolina);

        lector.close();
    }
}
