import java.util.Scanner;

public class Ejercicio158 {
    /*158. Ejercicio 8: Pedir al usuario 2 cadenas de caracteres de números, uno entero y
el otro real, convertirlos a sus respectivos valores y por último sumarlos. Realice un
programa que lea una cadena de caracteres de la entrada estándar y muestre en la
salida estándar cuántas ocurrencias de cada vocal existen en la cadena. */
        public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingresa una cadena de caracteres: ");
        String cadena = lector.nextLine().toLowerCase(); 

        lector.close(); 

        int contadorA = 0, contadorE = 0, contadorI = 0, contadorO = 0, contadorU = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            switch (caracter) {
                case 'a':
                    contadorA++;
                    break;
                case 'e':
                    contadorE++;
                    break;
                case 'i':
                    contadorI++;
                    break;
                case 'o':
                    contadorO++;
                    break;
                case 'u':
                    contadorU++;
                    break;
                default:
                    
                    break;
            }
        }

        System.out.println("Cantidad de 'a' en la cadena: " + contadorA);
        System.out.println("Cantidad de 'e' en la cadena: " + contadorE);
        System.out.println("Cantidad de 'i' en la cadena: " + contadorI);
        System.out.println("Cantidad de 'o' en la cadena: " + contadorO);
        System.out.println("Cantidad de 'u' en la cadena: " + contadorU);
    }
}
