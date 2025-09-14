import java.util.*;
/*#Ejercicio:
       *Crear un programa que ingrese los en un array y calcule el promedio
        y cantidad de datos pares e impares.  
 */
public class Clase_2_Ejercio1 {
    
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        
        System.out.println("Digite la cantidad de elementos");
        int tamaño = lector.nextInt();
        int Datos[] = new int[tamaño];

        for(int i = 0; i< tamaño; i++){
            System.out.println("Ingrese el dato ["+(i+1)+"] : ");
            Datos[i] = lector.nextInt();
        }
        System.out.println(Arrays.toString(Datos));
        double suma=0;
        for (int j = 0; j < tamaño; j++) {
            suma += Datos[j];
        }
        double resultado = (double)suma / tamaño;
        System.out.println("El promedio de los datos es : " +resultado);
        int Pares = 0, Impares = 0;
        int sumaPares = 0, sumaImpar = 0;
        //Recorremos los datos para saber caules son impares o pares
        for (int k = 0; k < tamaño; k++) {
            // Hacemos la respectiva operacion
            if (Datos[k] % 2 == 0){
                Pares++;
                sumaPares += Datos[k];
                }else{
                    Impares++;
                    sumaImpar += Datos[k];
                }
            }
            System.out.println("Hay "+Pares+" numeros pares.");
            System.out.println("Hay "+Impares+" numeros impares.");
            System.out.println("La suma de los numeros pares es : " + sumaPares);
            System.out.println("La suma de los numeros impares es : " + sumaImpar);
        lector.close();
    }
}
