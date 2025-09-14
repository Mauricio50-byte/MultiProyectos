import java.util.Scanner;

public class Ejercicio_31 {
    /*31.Construir un programa que permita calcular el área de un triángulo. El usuario
ingresará la base y la altura en milímetros y el sistema mostrará los resultados en
milímetros, centímetros y metros cuadrados respectivamente. */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese la base del triangulo en milimetros:");
        int base_ml = lector.nextInt();
        System.out.println("Ingrese la altura del triangulo en milimetros:");
        int altura_ml = lector.nextInt();

        int area = (base_ml * altura_ml)/2;

        System.out.println("El area del triangulo es de:"+""+area+""+"(Milimetros)");
        
        double centimetros_enLaBase = base_ml * 0.1;

        double centimetros_enLaAltura = altura_ml * 0.1;

        double metros_cuadrados_enLaBase = base_ml * 0.001;

        double metros_cuadrasos_enLaAltura = altura_ml * 0.001;
        
        System.out.println("la base tiene: "+centimetros_enLaBase+"(centimetros)"+"--"+ base_ml+"(Milimetros)"+"--"+metros_cuadrados_enLaBase+"(Metros cuadrados)");
        System.out.println("la altura tiene: "+centimetros_enLaAltura+"(Centimetros)"+"--"+ altura_ml+"(Milimetros)"+"--"+metros_cuadrasos_enLaAltura+"(Metros cuadrados)");

    }
}