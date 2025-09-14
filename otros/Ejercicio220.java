import javax.swing.JOptionPane;

public class Ejercicio220 {
    public static void main(String[] args) {
        // Variables para la lectura y cálculos
        int suma = 0;
        int contador = 0;

        // Leer números hasta que se ingrese -1
        int numero;
        do {
            numero = obtenerEnteroPositivo("Ingrese un número (-1 para finalizar):");
            if (numero != -1) {
                suma += numero;
                contador++;
            }
        } while (numero != -1);

        // Calcular y mostrar la media aritmética
        if (contador > 0) {
            double media = (double) suma / contador;
            JOptionPane.showMessageDialog(null, "La media aritmética es: " + media);
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresaron números válidos.");
        }
    }

    private static int obtenerEnteroPositivo(String mensaje) {
        int numero;
        do {
            String input = JOptionPane.showInputDialog(mensaje);
            numero = Integer.parseInt(input);
        } while (numero < 0);

        return numero;
    }
}
