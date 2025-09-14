import java.util.Scanner;

public class NuevoEjercicio {
    /*Hacer un programa que permita al usuario ingresar un texto
     * luego debes crear unas funciones:
     1. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de caracteres que tiene el texto
     2. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de palabras que tiene el texto,    
        las palabas deben estar unas arriva de la otras, tambien tiene que mostrar cada palabra en minuscula y en mayuscula
        e intercaladas, tambien cada palabra en letra capital
     3. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de letras que tiene el texto
     4. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de numeros que tiene el texto
     5. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de espacios que tiene el texto
     6. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de simbolos que tiene el texto
     7. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de vocales que tiene el texto
     8. El programa debe analizar el texto ingresado y la funcion debe devolverle el numero de consonantes que tiene el texto
     9  El programa debe analizar el texto ingresado y la funcion debe devolver cuantos caracteres especiales tiene el texto
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un texto: ");
        String texto = entrada.nextLine();
        System.out.println("--------------------------------------------------");
        numeroDecaracteres(texto);
        obtenerNumeroPalabras(texto);
        imprimirPalabrasIntercaleadas(texto);
        numeroDeletras(texto);
        obtenerNumeroNumeros(texto);
        obtenerNumeroEspacios(texto);
        obtenerNumeroSimbolos(texto);
        obtenerNumeroVocales(texto);
        obtenerNumeroConsonantes(texto);
        obtenerNumeroCaracteresEspeciales(texto);  
        entrada.close();
    }
    public static int numeroDecaracteres(String texto){
        System.out.println("El numero de caracteres del texto es : " + texto.length());
        return texto.length();
    }
    public static int obtenerNumeroPalabras(String texto) {
        String[] palabras = texto.split("\\s+");
        System.out.println("El numero de palaras que tiene el texto es : " + palabras.length);
        System.out.println("---------------------------------------------------");
        System.out.println("LAS PALABRAS SON : ");
        for (String string : palabras) {
            System.out.println("* "+string);
        }
        System.out.println("---------------------------------------------------");
        return palabras.length;
    }
    public static void imprimirPalabrasIntercaleadas(String texto) {
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            System.out.println("Minúscula: " + palabra.toLowerCase());
            System.out.println("Mayúscula: " + palabra.toUpperCase());
            System.out.println("Letra capital: " + palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase());
            System.out.println("-----------------------------------------------");
        }
    }
    public static int numeroDeletras(String texto){
        System.out.println("El numero de letras es : " + texto.replaceAll("[^0-9]", "").length());
        return texto.replaceAll("[^a-zA-Z]", "").length();
    }
    public static int obtenerNumeroNumeros(String texto) {
        System.out.println("la cantidad de numeros que hay en el texto es : " + texto.replaceAll("[^0-9]", "").length());
        return texto.replaceAll("[^0-9]", "").length();
    }
    public static int obtenerNumeroEspacios(String texto) {
        System.out.println("La cantidad de espacios que hay en el texto es : " +  texto.replaceAll("[^ ]", "").length() );
        return texto.replaceAll("[^ ]", "").length();
    }
    public static int obtenerNumeroSimbolos(String texto) {
        System.out.println("La cantidad de simbolos que hay en el texto es : " + texto.replaceAll("[^a-zA-Z0-9 ]", "").length());
        return texto.replaceAll("[a-zA-Z0-9 ]", "").length();
    }

    public static int obtenerNumeroVocales(String texto) {
        System.out.println("La cantidad de vocales que hay en el texto es : " + texto.replaceAll("[aeiouAEIOU]", "").length());
        return texto.replaceAll("[^aeiouAEIOU]", "").length();
    }

    public static int obtenerNumeroConsonantes(String texto) {
        System.out.println("La cantidad de consonantes que hay en el texto es : " + texto.replaceAll("[^aeiouAEIOU0-9 ]", "").length());
        return texto.replaceAll("[aeiouAEIOU0-9 ]", "").length();
    }

    public static int obtenerNumeroCaracteresEspeciales(String texto) {
        System.out.println("La cantidad de caracteres especiales que hay en el texto es : " + texto.replaceAll("[^a-zA-Z0-9 ]", "").length());
        return texto.replaceAll("[a-zA-Z0-9 ]", "").length();
    }
}
