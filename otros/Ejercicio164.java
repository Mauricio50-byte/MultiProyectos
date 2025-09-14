import java.util.Scanner;

public class Ejercicio164 {
    /*164. Programa para la taquilla de un Cine, para que de acuerdo al tipo de boleto
vendido ( Adulto=$60 , Niño=$30, Promociones=$20 ) indique:
○ Cuántos boletos se vendieron.
○ Venta bruta.
○ Venta por cada tipo de boleto. El programa pedirá datos al menos en 10
ocasiones antes de mostrar el resumen . */
    public static void main(String[] args) { 
        Scanner lector = new Scanner(System.in);

        // Inicializar variables
        int totalBoletosVendidos = 0;
        double ventaBruta = 0;
        int boletosAdulto = 0;
        int boletosNiño = 0;
        int boletosPromocion = 0;

        // Ciclo para ingresar datos al menos 10 veces
        for (int i = 1; i <= 10; i++) {
            System.out.println("Venta #" + i);

            // Pedir tipo de boleto y cantidad
            System.out.print("Tipo de boleto (A=Adulto, N=Niño, P=Promocion): ");
            char tipoBoleto = lector.next().charAt(0);

            System.out.print("Cantidad de boletos vendidos: ");
            int cantidadBoletos = lector.nextInt();

            // Calcular venta por cada tipo de boleto y actualizar variables
            switch (tipoBoleto) {
                case 'A':
                    boletosAdulto += cantidadBoletos;
                    ventaBruta += cantidadBoletos * 60;
                    break;
                case 'N':
                    boletosNiño += cantidadBoletos;
                    ventaBruta += cantidadBoletos * 30;
                    break;
                case 'P':
                    boletosPromocion += cantidadBoletos;
                    ventaBruta += cantidadBoletos * 20;
                    break;
                default:
                    System.out.println("Tipo de boleto no válido. Inténtalo de nuevo.");
                    i--; // Decrementar el índice para repetir la entrada
            }

            totalBoletosVendidos += cantidadBoletos;
        }

        // Mostrar resumen
        System.out.println("\nResumen de ventas:");
        System.out.println("Total de boletos vendidos: " + totalBoletosVendidos);
        System.out.println("Venta bruta: $" + ventaBruta);
        System.out.println("Ventas por tipo de boleto:");
        System.out.println("  Adulto: $" + boletosAdulto * 60);
        System.out.println("  Niño: $" + boletosNiño * 30);
        System.out.println("  Promocion: $" + boletosPromocion * 20);

        // Cerrar el lector
        lector.close();
    }
    
}
