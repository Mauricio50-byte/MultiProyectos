import java.util.Scanner;

public class Ejercicio_25 {
    /*25.Programa que de acuerdo a una cantidad de grados centígrados ingresadas por
teclado, realice la conversión a grados fahrenheit. (Multiplica por 9, divide entre 5,
después suma 32). */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese  la cantidad de grados centigrados:");
        double gradosCentigrados = lector.nextDouble();
        //Calculo del valor en fahrenheit
        double conversión = (gradosCentigrados * 9 / 5)+ 32;
        System.out.println("La convercion es :"+conversión);

    }
}
