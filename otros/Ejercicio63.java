import java.util.Scanner;

public class Ejercicio63 {
    /*63.Escriba un programa que lea valores enteros hasta que se introduzca un valor en el
rango (20-30] o se introduzca el valor 0. El programa debe entregar la suma de los
valores mayores a 0 introducidos  */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int valor ;
        int suma = 0;

        System.out.println("Ingrese valores enteros. Para detener la entrada, ingrese un valor en el rango (20-30] o 0.");
        do {
            System.out.println("Ingrese un valor: ");
            valor = lector.nextInt();

            if (valor > 0) {
                suma += valor;
            }
        } while (valor != 0 && (valor <= 0 || valor > 30 || valor <= 20));
        System.out.println("La suma de los valores mayores a 0 es: " + suma);
        lector.close();
    }
}
