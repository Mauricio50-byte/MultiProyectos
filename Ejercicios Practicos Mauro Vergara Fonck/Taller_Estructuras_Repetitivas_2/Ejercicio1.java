package Taller_Estructuras_Repetitivas_2;

import javax.swing.JOptionPane;

/* Desarrolle una clase ejecutable que calcule el cuadrado de un número
haciendo sólo sumas. Ayuda: el cuadrado de un número n es la suma de los
n primeros números impares. Ejemplo: 32=1+3+5=9.
Desarrolle una clase ejecutable que convierta un número entero en otro
número entero que será el primero pero con las cifras que lo forman
escritas al revés. Ejemplo: convertirá el número entero 1842 en el 2481
Simular Ta división usando solamente restas. Dados dos números enteros
mayores de uno, desarrollar una clase ejecutable en Java que calcule el
cociente y el residuo usando sólo restas. Método: Restar el dividendo del
divisor hasta obtener un resultado menor que el divisor, este resultado es el
residuo, y el número de restas realizadas es el cociente.
Por ejemplo: 50 / 13:
50 - 13= 37 una resta realizada
37 - 13 = 24 dos restas realizadas
24 - 13= 11 tres restas realizadas
11 es menor que 13, entonces: el residuo es 11 y el cociente es 3. */
public class Ejercicio1 {
     // Metodo para calcular el cuadrado de un número utilizando solo sumas
    public static int calcularCuadrado(int numero) {
        int cuadrado = 0;
        for (int i = 1; i <= numero; i += 2) {
            cuadrado += i;
        }
        return cuadrado;
    }

    // Metodo para invertir un número entero
    public static int invertirNumero(int numero) {
        int numeroInvertido = 0;
        while (numero != 0) {
            numeroInvertido = numeroInvertido * 10 + numero % 10;
            numero /= 10;
        }
        return numeroInvertido;
    }

    // Metodo para simular la división usando solo restas
    public static int[] dividirConRestas(int dividendo, int divisor) {
        int cociente = 0;
        while (dividendo >= divisor) {
            dividendo -= divisor;
            cociente++;
        }
        int[] resultado = { cociente, dividendo };
        return resultado;
    }

    public static void main(String[] args) {
        // Calculo del cuadrado
        String inputCuadrado = JOptionPane.showInputDialog("Ingrese un número para calcular su cuadrado:");
        int numeroCuadrado = Integer.parseInt(inputCuadrado);
        int cuadrado = calcularCuadrado(numeroCuadrado);
        JOptionPane.showMessageDialog(null, "El cuadrado de " + numeroCuadrado + " es: " + cuadrado);

        // Inversion de un numero
        String inputInvertir = JOptionPane.showInputDialog("Ingrese un número para invertir:");
        int numeroInvertir = Integer.parseInt(inputInvertir);
        int numeroInvertido = invertirNumero(numeroInvertir);
        JOptionPane.showMessageDialog(null, "El número " + numeroInvertir + " invertido es: " + numeroInvertido);

        // Division con restas
        String inputDividendo = JOptionPane.showInputDialog("Ingrese el dividendo:");
        int dividendo = Integer.parseInt(inputDividendo);
        String inputDivisor = JOptionPane.showInputDialog("Ingrese el divisor:");
        int divisor = Integer.parseInt(inputDivisor);
        int[] resultadoDivision = dividirConRestas(dividendo, divisor);
        int cociente = resultadoDivision[0];
        int residuo = resultadoDivision[1];
        JOptionPane.showMessageDialog(null, "División: " + dividendo + " / " + divisor + "\nCociente: " + cociente + "\nResiduo: " + residuo);
    }
}