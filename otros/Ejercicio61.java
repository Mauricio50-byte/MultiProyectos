public class Ejercicio61 {
    /*61.Ejercicio 3: Realice un programa que calcule y muestre en la salida estándar la
suma de los cuadrados de los 10 primeros enteros mayores que cero. */
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i <= 10; i++) {
            if (i > 0) {
                suma += i * i;
            }
        }
        System.out.println(suma);
    }
}
