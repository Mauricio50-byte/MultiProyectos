public class Ejercicio_52 {
/*52.Crear una función que reciba como parámetro un número entero y escriba la tabla
de multiplicar de ese número (por ejemplo: para el 3 deberá llegar desde 3x0=0
hasta 3x10= */ 
    public static void main(String[] args) {
       int numero = 3; // Cambia el número por el que desees
       imprimirTablaMultiplicar(numero);
    }

    public static void imprimirTablaMultiplicar(int numero) {
    for (int i = 0; i <= 10; i++) {
        int resultado = numero * i;
        System.out.println(numero + " x " + i + " = " + resultado);
    }

  }

}
