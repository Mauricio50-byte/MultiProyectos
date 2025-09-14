import java.util.Scanner;

public class Ejercicio166 {
    /*166. Programa que determine el IMC (Índice de Masa Corporal) de una persona.
IMC=kg / estMetros2 . Y determine : */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = lector.nextDouble();

        System.out.print("Ingrese su estatura en metros: ");
        double estatura = lector.nextDouble();

        // Calcular el IMC
        double imc = calcularIMC(peso, estatura);

        // Determinar la categoría del IMC
        String categoria = determinarCategoriaIMC(imc);

        System.out.println("\nSu IMC es: " + imc);
        System.out.println("Categoría de IMC: " + categoria);

        lector.close();
    }

    // Método para calcular el IMC
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    // Método para determinar la categoría del IMC
    public static String determinarCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
