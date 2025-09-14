import java.util.Scanner;

public class Ejercicio152 {
    /*152. Pedir al usuario una cadena de caracteres, almacenarla en un arreglo y copiar
todo su contenido hacia otro arreglo de caracteres. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Por favor, ingresa una cadena de caracteres:");
        String cadena = lector.nextLine();

        char[] arregloOriginal = cadena.toCharArray();

        char[] arregloCopia = new char[arregloOriginal.length];

        for (int i = 0; i < arregloOriginal.length; i++) {
            arregloCopia[i] = arregloOriginal[i];
        }
        System.out.print("Contenido del arreglo de copia: ");
        for (char caracter : arregloCopia) {
            System.out.print(caracter);
        }

        lector.close();
    }
}
