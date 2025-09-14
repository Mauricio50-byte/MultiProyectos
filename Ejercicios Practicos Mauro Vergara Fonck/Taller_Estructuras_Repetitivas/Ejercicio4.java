package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

/*diseñar el algoritmo de un programa que muestre los números pares inferiores a un número
dado. */
public class Ejercicio4 {
    public static void main(String[] args) {
        int num = 10;
        int contador = 0;
        StringBuilder numerosPares = new StringBuilder("Numeros pares menores a ").append(num).append("\n");
        
        for (int i = 2; i < num; i++) {
            if (i % 2 == 0) {
                numerosPares.append(i).append("\t");
                contador++;
                if (contador % 5 == 0) {
                    numerosPares.append("\n");
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, numerosPares.toString());
    }
}
