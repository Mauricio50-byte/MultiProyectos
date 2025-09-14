import javax.swing.JOptionPane;
public class Ejercicio217 {
    public static void main(String[] args) {
        // Calcular y mostrar el cuadrado de los 9 primeros números naturales
        for (int i = 1; i <= 9; i++) {
            int cuadrado = calcularCuadrado(i);
            JOptionPane.showMessageDialog(null, "El cuadrado de " + i + " es: " + cuadrado);
        }
    }

    private static int calcularCuadrado(int numero) {
        // Calcular el cuadrado de un número
        return numero * numero;
    }
}
