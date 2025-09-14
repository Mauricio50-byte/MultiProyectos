import java.util.Scanner;

public class Ejercicio97 {
    /*97. Determinar la eficiencia energética de la Termoeléctrica Manta, considerando su
consumo general en 10000 Kw. Si su consumo ingresado está entre el 80% y 100%
kw visualizar “CONSUMO MEDIO”, caso contrario sea superior al 100% visualizar
“ALTO CONSUMO DE ENERGÍA”. */
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Solicitar al usuario que ingrese el consumo en Kw
        System.out.print("Ingrese el consumo de la Termoeléctrica Manta en Kw: ");
        double consumoKw = lector.nextDouble();

        // Calcular el porcentaje de consumo
        double porcentajeConsumo = (consumoKw / 10000) * 100;

        // Determinar la eficiencia energética
        String eficienciaEnergetica;
        if (porcentajeConsumo >= 80 && porcentajeConsumo <= 100) {
            eficienciaEnergetica = "CONSUMO MEDIO";
        } else {
            eficienciaEnergetica = "ALTO CONSUMO DE ENERGÍA";
        }

        // Mostrar el resultado
        System.out.println("Eficiencia energética de la Termoeléctrica Manta:");
        System.out.println("Porcentaje de consumo: " + porcentajeConsumo + "%");
        System.out.println("Eficiencia energética: " + eficienciaEnergetica);

        lector.close();
    }
}
