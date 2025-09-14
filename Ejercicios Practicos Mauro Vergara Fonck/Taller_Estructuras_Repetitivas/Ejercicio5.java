package Taller_Estructuras_Repetitivas;

import java.util.Random;
import javax.swing.JOptionPane;

/*Crea una aplicación que permita adivinar un número. La aplicación genera un número aleatorio
del 1 al 100. A continuación, va pidiendo números y va respondiendo si el número a adivinar es
mayor o menor que el introducido, además de los intentos que te quedan (tienes 10 intentos para
acertarlo). El programa termina cuando se acierta el número (además te dice en cuantos intentos
lo has acertado), si se llega al límite de intentos te muestra el número que había generado. */
public class Ejercicio5 {
    
    public static void main(String[] args) {
        Random random = new Random();

        int numeroAdivinar = random.nextInt(100) + 1; // Generamos un numero aleatorio entre 1 y 100
        int intentos = 10;
        int intentoActual = 0;
        int numeroUsuario;

        JOptionPane.showMessageDialog(null, "Bienvenido al juego Adivina el Numero!\nTienes 10 intentos para adivinar el número. ¡Buena suerte!");

        while (intentoActual < 10) {
            String input = JOptionPane.showInputDialog("Introduce un número entre 1 y 100:");
            numeroUsuario = Integer.parseInt(input);
            intentoActual++;

            if (numeroUsuario == numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "¡Felicidades! ¡Has adivinado el número en " + intentoActual + " intentos!");
                return; // Salimos del programa
            } else if (numeroUsuario < numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "El número a adivinar es mayor. Intentos restantes: " + (intentos - intentoActual));
            } else {
                JOptionPane.showMessageDialog(null, "El número a adivinar es menor. Intentos restantes: " + (intentos - intentoActual));
            }
        }

        JOptionPane.showMessageDialog(null, "Lo siento, has agotado tus intentos. El número a adivinar era: " + numeroAdivinar);
    }
    
}