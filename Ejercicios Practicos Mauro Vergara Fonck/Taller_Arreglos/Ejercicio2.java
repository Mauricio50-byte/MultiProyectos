package Taller_Arreglos;

import javax.swing.JOptionPane;

/*Diseñe el algoritmo de un programa que tenga dos arreglos de 5
posiciones para almacenar nombres y apellidos de personas. El algoritmo
debe ser capaz de mostrar esta información por cada posición de los
arreglos.
NOMBRE APELLIDO (en mayúscula).
N. Apellido (Inicial del nombre en mayúscula un punto y el apellidc
en minúscula), numero de caracteres de" del Tomore nombre más más el el apellido

Ejemplo :
Arreglol
Juan
Maria_
Miguel
Sandra
Milena
----------------------------------
Arreglo2
Perez
Garces
ramirez
Gonzalez
Jimenez

SI los arreglos tienen esos valores que se muestran en la información anterior:
el programa de mostrar lo siguiente
siguiente:
JUAN PEREZ,J perez, 9 caracteres
MARIA GARCES, M garces, 11 caracteres
MIGUEL RAMIREZ, M ramirez, 13 caracteres
SANDRA GONZALEZ, S gonzalez, 14 caracteres
MILENA JIMENEZ, M jimenez, 13 caracteres. */
public class Ejercicio2 {
    public static void main(String[] args) {
        // Declaramos los arreglos de nombres y apellidos
        String[] nombres = new String[5];
        String[] apellidos = new String[5];

        JOptionPane.showMessageDialog(null, "Ingrese los nombres:");

        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = JOptionPane.showInputDialog("Nombre #" + (i + 1) + ":");
        }

        JOptionPane.showMessageDialog(null, "Ingrese los apellidos:");

        for (int i = 0; i < apellidos.length; i++) {
            apellidos[i] = JOptionPane.showInputDialog("Apellido #" + (i + 1) + ":");
        }

        StringBuilder mensaje = new StringBuilder("----------------------------------\n");

        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i].toUpperCase();
            String apellido = apellidos[i].toLowerCase();
            String inicialNombre = Character.toString(nombre.charAt(0));
            String info = nombre + " " + apellido.toUpperCase() + ", " + inicialNombre + " " + apellido + ", " +
                    (nombre.length() + apellido.length()) + " caracteres\n";
            mensaje.append(info);
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
