import java.util.Scanner;

public class Ejercicio_27 {
    /*27.Que el usuario de su género y su nombre, dependiendo de su género imprimir en
pantalla Bienvenido “nombre”, Bienvenida “nombre”, y si en dado caso se pone otra */
    public static void main(String[] args) {
       Scanner lector = new Scanner(System.in);
       System.out.println("Ingrese su nombres:");
       String nombre = lector.nextLine();
       System.out.println("Ingrese su genero (M para masculino / F para femeninos):");
       char genero = lector.next().charAt(0);
       if (genero == 'F' || genero == 'M') {
         System.out.println("Bienvenida:"+nombre);
       } else if (genero == 'F' || genero == 'M') {
         System.out.println("Bienvenida:"+nombre);
       }else{
         System.out.println("Bienvenido@:"+nombre);
       } 
    }
}
