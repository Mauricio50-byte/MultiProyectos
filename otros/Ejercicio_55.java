public class Ejercicio_55 {
    /*55.Desarrolle una función que reciba un número y devuelva el valor 1 si es un número primo o 0 en caso contrario. */
    public static int esPrimo(int numero) {
        if (numero <= 1) {
            return 0;  // Los números menores o iguales a 1 no son primos
        }
        
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return 0;  // El número es divisible por otro número, por lo que no es primo
            }
        }
        
        return 1;  // Si no se encontraron divisores, el número es primo
    }
    
    public static void main(String[] args) {
        int numero = 17;  // Cambia este valor por el número que desees verificar
        int resultado = esPrimo(numero);
        
        if (resultado == 1) {
            System.out.println(numero + " es un número primo.");
        } else if (resultado == 0){
            System.out.println(numero + " no es un número primo.");
        }
    }
}
