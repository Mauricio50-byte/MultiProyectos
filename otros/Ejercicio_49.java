public class Ejercicio_49 {
    /*49.Crear una función que devuelva la primera letra de una cadena de texto. */
   public static void main(String[] args) {
    String texto = "Hola, mundo";
    char primeraLetra = obtenerPrimeraLetra(texto);
    System.out.println("La primera letra es: " + primeraLetra);
}

public static char obtenerPrimeraLetra(String cadena) {
    if (cadena.length() > 0) {
        return cadena.charAt(0);
    } else {
        return '\0';
    }

   } 
}
