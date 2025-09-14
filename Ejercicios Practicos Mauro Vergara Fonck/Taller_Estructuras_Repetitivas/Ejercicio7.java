package Taller_Estructuras_Repetitivas;

import java.util.Scanner;

import javax.swing.JOptionPane;

//Elabore un programa que lea un número y calcule la suma desde 1 hasta el número leído

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        String input = JOptionPane.showInputDialog("Introduce un numero:");
        int num = Integer.parseInt(input);
        
        int suma = 0;
        for (int i = 1; i <= num; i++) {
            suma += i;
        }

        JOptionPane.showMessageDialog(null, "La suma desde 1 hasta " + num + " es: " + suma);
        lector.close();
    }
}
