package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

/*Realizar un algoritmo que pida números (se pedirá por teclado la cantidad de números a
introducir). El programa debe informar de cuantos números introducidos son mayores que 0,
menores que 0 e iguales a 0.
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de números a introducir:");
        int cantidadNumeros = Integer.parseInt(input);

        int mayoresQueCero = 0;
        int menoresQueCero = 0;
        int igualesACero = 0;

        for (int i = 0; i < cantidadNumeros; i++) {
            String numeroInput = JOptionPane.showInputDialog("Ingrese el número #" + (i + 1) + ":");
            int numero = Integer.parseInt(numeroInput);

            if (numero > 0) {
                mayoresQueCero++;
            } else if (numero < 0) {
                menoresQueCero++;
            } else {
                igualesACero++;
            }
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("Cantidad de números mayores que 0: ").append(mayoresQueCero).append("\n");
        resultado.append("Cantidad de números menores que 0: ").append(menoresQueCero).append("\n");
        resultado.append("Cantidad de números iguales a 0: ").append(igualesACero);

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}