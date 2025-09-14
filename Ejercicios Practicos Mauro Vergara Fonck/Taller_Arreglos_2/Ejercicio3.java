package Taller_Arreglos_2;

import javax.swing.JOptionPane;

/*Crea un array de caracteres que contenga de la ‘A’ a la ‘Z’ (solo las mayúsculas). Después, ve pidiendo posiciones del array por teclado y si la posicion es correcta, se añadira a una cadena que se mostrara al final, se dejará de insertar cuando se introduzca un -1.
Por ejemplo, si escribo los siguientes numeros
0 //Añadira la ‘A’
5 //Añadira la ‘F’
25 //Añadira la ‘Z’
50 //Error, inserte otro numero
-1 //fin
Cadena resultante: AFZ
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        // Creamos un array de caracteres que contenga de la 'A' a la 'Z'
        char[] letras = new char[26];
        for (int i = 0; i < 26; i++) {
            letras[i] = (char) ('A' + i);
        }

        // Pedimos posiciones del array mediante dialogos emergentes y construimos la cadena resultante
        StringBuilder cadenaResultante = new StringBuilder();
        int posicion;
        do {
            String input = JOptionPane.showInputDialog("Ingrese una posición del array (-1 para terminar):");
            posicion = Integer.parseInt(input);
            if (posicion >= 0 && posicion < letras.length) {
                cadenaResultante.append(letras[posicion]);
            } else if (posicion != -1) {
                JOptionPane.showMessageDialog(null, "Error: posición fuera de rango. Introduzca otro número.");
            }
        } while (posicion != -1);

        // Mostramos la cadena resultante en un diálogo emergente
        JOptionPane.showMessageDialog(null, "Cadena resultante: " + cadenaResultante.toString());
    }
}