import javax.swing.JOptionPane;

public class Ejercicio210 {
    public static void main(String[] args) {
        // Solicitar al usuario ingresar el monto presupuestal
        double montoPresupuestal = obtenerCantidad("Ingrese el monto presupuestal:");

        // Calcular la cantidad de dinero para cada área
        double ginecologia = calcularPorcentajeArea(montoPresupuestal, 40);
        double traumatologia = calcularPorcentajeArea(montoPresupuestal, 30);
        double pediatria = calcularPorcentajeArea(montoPresupuestal, 30);

        // Mostrar los resultados
        JOptionPane.showMessageDialog(null, "Monto para Ginecología: $" + ginecologia);
        JOptionPane.showMessageDialog(null, "Monto para Traumatología: $" + traumatologia);
        JOptionPane.showMessageDialog(null, "Monto para Pediatría: $" + pediatria);
    }

    private static double calcularPorcentajeArea(double montoTotal, double porcentaje) {
        // Calcular la cantidad de dinero para un área dada el porcentaje del presupuesto
        return (montoTotal * porcentaje) / 100;
    }

    private static double obtenerCantidad(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        return Double.parseDouble(input);
    }
    
}
