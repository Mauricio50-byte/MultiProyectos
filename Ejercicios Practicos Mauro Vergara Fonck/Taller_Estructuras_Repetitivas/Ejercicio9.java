package Taller_Estructuras_Repetitivas;

import javax.swing.JOptionPane;

/*Escribe un programa que pida el límite inferior y superior de un intervalo. Si el límite inferior es
mayor que el superior lo tiene que volver a pedir. A continuación, se van introduciendo números
hasta que introduzcamos el 0. Cuando termine el programa dará las siguientes informaciones:
La suma de los números que están dentro del intervalo (intervalo abierto).
Cuantos números están fuera del intervalo.
He informa si hemos introducido algún número igual a los límites del intervalo */
public class Ejercicio9 {
    public static void main(String[] args) {
        int limiteInferior, limiteSuperior;
        int sumaIntervalo = 0;
        int numerosFueraIntervalo = 0;
        boolean igualLimiteInferior = false;
        boolean igualLimiteSuperior = false;

        do {
            String input1 = JOptionPane.showInputDialog("Ingrese el límite inferior del intervalo:");
            limiteInferior = Integer.parseInt(input1);
            String input2 = JOptionPane.showInputDialog("Ingrese el límite superior del intervalo:");
            limiteSuperior = Integer.parseInt(input2);

            if (limiteInferior > limiteSuperior) {
                JOptionPane.showMessageDialog(null, "Error: El límite inferior debe ser menor o igual al límite superior. Inténtelo de nuevo.");
            }
        } while (limiteInferior > limiteSuperior);

        JOptionPane.showMessageDialog(null, "Ingrese números. Ingrese 0 para terminar.");

        while (true) {
            String input = JOptionPane.showInputDialog("Ingrese un número:");
            int numero = Integer.parseInt(input);

            if (numero == 0) {
                break;
            }

            if (numero > limiteInferior && numero < limiteSuperior) {
                sumaIntervalo += numero;
            } else {
                numerosFueraIntervalo++;
            }

            if (numero == limiteInferior) {
                igualLimiteInferior = true;
            }
            if (numero == limiteSuperior) {
                igualLimiteSuperior = true;
            }
        }

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("La suma de los números dentro del intervalo es: ").append(sumaIntervalo).append("\n");
        mensaje.append("Cantidad de números fuera del intervalo: ").append(numerosFueraIntervalo).append("\n");
        if (igualLimiteInferior) {
            mensaje.append("Se ha introducido al menos un número igual al límite inferior del intervalo.").append("\n");
        }
        if (igualLimiteSuperior) {
            mensaje.append("Se ha introducido al menos un número igual al límite superior del intervalo.").append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}