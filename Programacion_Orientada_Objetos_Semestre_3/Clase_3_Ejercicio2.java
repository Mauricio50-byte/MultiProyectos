import java.util.*;

public class Clase_3_Ejercicio2 {
    /*# Ejercicio:
            * Crear un programa que ingrese los datos en un array y los ordene
            de menor a mayor y muetsre el array ordenado y me diga el dats que
            es mayor y el que es menos    
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int[] datos = new int[5]; // Creamos un arreglo con 5 posiciones
        //System.out.println("Ingrese " + datos.length + " numeros enteros");
        for (int i=0;i<datos.length;i++) {
            System.out.print((i+1)+"° Ingrese un numero entero: ");
            datos[i] = lector.nextInt();
        }
        // recorremos el arreglo dato y ordenamos los datos de menor a mayor
        int ordenador = 0;
        for (int i = 0; i < datos.length - 1; i++) {
            for (int j = 0; j < datos.length - 1; j++) { 
                if (datos[j] > datos[j+1]) {  
                    ordenador = datos[j];
                    datos[j] = datos[j+1];
                    datos[j+1] = ordenador;
                }
            }
        }
       // Arrays.sort(datos);//Ordenamos los datos de la lista de menor a mayor con el (sort)
        System.out.println(Arrays.toString(datos)); //Mostramos la lista ordenada
        int mayor = datos[4], menor = datos[0]; //Asignamos las variables
        System.out.println(mayor+" es el numero mas grande");
        System.out.println(menor+" es el numero mas pequeño");
        lector.close();
    }     
}