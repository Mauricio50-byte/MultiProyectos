import javax.swing.JOptionPane;

public class Ejercicio234 {
    
    public static void main(String[] args) {
        // Solicitar al usuario ingresar un número
        int numero = obtenerEntero("Ingrese un número:");

        // Verificar si el número es capicúa
        if (esCapicua(numero)) {
            JOptionPane.showMessageDialog(null, "El número " + numero + " es capicúa.");
        } else {
            JOptionPane.showMessageDialog(null, "El número " + numero + " no es capicúa.");
        }
    }

    private static int obtenerEntero(String mensaje) {
        // Solicitar al usuario ingresar un número entero y convertir a int
        String input = JOptionPane.showInputDialog(mensaje);
        return Integer.parseInt(input);
    }

    private static boolean esCapicua(int numero) {
        // Convertir el número a cadena para invertirlo
        String numeroStr = Integer.toString(numero);
        String numeroInvertido = new StringBuilder(numeroStr).reverse().toString();

        // Verificar si el número invertido es igual al original
        return numeroStr.equals(numeroInvertido);
    }
    
}
