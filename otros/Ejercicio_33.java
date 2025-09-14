import java.util.Scanner;

public class Ejercicio_33{
/*33.Una empresa almacena los datos de N empleados, para esto, en un proceso
repetitivo se ingresa el sexo y el salario de cada empleado. Se pide calcular:
a) La cantidad de personas que ganan más de 700 al mes.
b) El promedio de salarios.
c) El porcentaje de mujeres que trabajan en esa empresa
d) El porcentaje de varones que trabajan en esa empresa */
public static void main(String[] args) {
     Scanner lector = new Scanner(System.in);
     System.out.println("Ingrese el numero de empleados que tiene dicha empresa:");
     int empleados = lector.nextInt();
     int cont_Mes = 0, cont_Hombres = 0, cont_Mujeres = 0, suma_salario = 0;
     double porcentaje_Hombres, porcentaje_Mujeres, promedio_Salario;
        for(int i = 1; i <= empleados;i++){
           System.out.println("Ingrese su genero (H para Hombre / M para Mujeres):");
           char genero = lector.next().charAt(0);

           System.out.println("Ingrese el salario de cada empleado:");
           double salario = lector.nextDouble();
             if (salario > 700) {
               cont_Mes++;
             }
             suma_salario += salario;
               if (genero == 'H') {
                cont_Hombres++;
               } else if (genero == 'M') {
                    cont_Mujeres++;
            }     
        }
        promedio_Salario = suma_salario / empleados;
        porcentaje_Mujeres = cont_Mujeres / empleados * 100;
        porcentaje_Hombres = cont_Hombres / empleados * 100;

        System.out.println("La cantidad de personas que ganan mas de 700 al mes es: " + cont_Mes);
        System.out.println("El promedio de salarios es: " + promedio_Salario);
        System.out.println("El porcentaje de mujeres que trabajan en esa empresa es: " + porcentaje_Mujeres + "%");
        System.out.println("El porcentaje de varones que trabajan en esa empresa es: " + porcentaje_Hombres + "%");
    }  
}