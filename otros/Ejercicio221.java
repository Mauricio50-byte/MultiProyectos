import javax.swing.JOptionPane;

public class Ejercicio221 {
    public static void main(String[] args) {
        // Clave a adivinar
        String claveCorrecta = "eureka";

        // Número máximo de intentos
        int intentosMaximos = 3;

        // Bucle para realizar hasta 3 intentos
        for (int intento = 1; intento <= intentosMaximos; intento++) {
            // Solicitar al usuario ingresar la clave
            String claveIngresada = JOptionPane.showInputDialog("Intento " + intento + ": Ingrese la clave:");

            // Verificar si la clave es correcta
            if (claveIngresada.equals(claveCorrecta)) {
                JOptionPane.showMessageDialog(null, "¡Clave correcta! Has adivinado la clave.");
                // Salir del programa si la clave es correcta
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Clave incorrecta. Intenta de nuevo.");
            }
        }

        // Mostrar mensaje si se agotan los intentos
        JOptionPane.showMessageDialog(null, "Has agotado los 3 intentos. La clave correcta era 'eureka'.");
    }
    
}
