public class Ejercicio_44 {
    /*44.Realiza un programa que calcule las potencias de la 2 a la 10 del número PI y la
raíz cuadrada de dicha potencia. Para ello construye una función que calcule la
potencia n-ésima de un número cualquiera y utiliza después la función sqrt de la
librería matemática de C. */
    public static void main(String[] args) {
        for (int n = 2; n <= 10; n++) {
            double potencia = Math.pow(Math.PI, n);
            double raizCuadrada = Math.sqrt(potencia);
            System.out.println("Potencia de PI a la " + n + "ª: " + potencia);
            System.out.println("Raíz cuadrada de la potencia: " + raizCuadrada);
        }
    }
}
