public class Ejercicio_43 {
    /*43.Crear una función que calcule cual es el número menor de dos números enteros */
    public static int calcularMenor(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static void main(String[] args) {
        int numero1 = 10;
        int numero2 = 5;
        
        int menor = calcularMenor(numero1, numero2);
        System.out.println("El menor número entre " + numero1 + " y " + numero2 + " es: " + menor);
    }
}
