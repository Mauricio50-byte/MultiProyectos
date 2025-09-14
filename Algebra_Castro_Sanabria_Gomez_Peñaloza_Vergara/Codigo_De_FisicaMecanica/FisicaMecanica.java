package Codigo_De_FisicaMecanica;

import java.util.*;

public class FisicaMecanica {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Pedimos la cantidad de mediciones
        System.out.print("Ingrese la cantidad de mediciones: ");
        int n = lector.nextInt();

        // Arreglos para almacenar los datos de tiempo y distancia
        double[] tiempo = new double[n];
        double[] distancia = new double[n];

        // Pedir los datos de cada medición
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el distancia (en metros) para la medición " + (i + 1) + ": ");
            distancia[i] = lector.nextDouble();
            System.out.print("Ingrese la tiempo (en segundos) para la medición " + (i + 1) + ": ");
            tiempo[i] = lector.nextDouble();
            System.out.println("###############################################################");
        }
        
        // Llamamos el metodo para limpiar pantalla
        LimpiarPantalla();
        
        // Diagrama de dispersión
        System.out.println("\n   Diagrama de dispersión");
        System.out.println("-------------------------");
        System.out.println("Tiempo (s)\tDistancia (m)");
        for (int i = 0; i < n; i++) {
            System.out.println(""+tiempo[i] + "\t\t" + distancia[i]+"");
        }
        System.out.println("-------------------------");

        // llamamos al metodo de la grafica de barra
        graficaDeBarra(tiempo, distancia);
        
        // Calculamos la sumatoria de tiempo, distancia, tiempo^2 y tiempo*distancia
        double sumaTiempo = 0, sumaDistancia = 0, sumaTiempoCuadrado = 0, sumaTiempoDistancia = 0;
        for (int i = 0; i < n; i++) { 
            sumaTiempo += tiempo[i];
            sumaDistancia += distancia[i];
            sumaTiempoCuadrado += Math.pow(tiempo[i], 2);
            sumaTiempoDistancia += tiempo[i] * distancia[i];
        }

        // Calculamos las constantes C y B usando el método de mínimos cuadrados
        double C = (n * sumaTiempoDistancia - sumaTiempo * sumaDistancia) / (n * sumaTiempoCuadrado - Math.pow(sumaTiempo, 2));
        double B = (sumaDistancia - C * sumaTiempo) / n;
        
         // Calculamos el resultado de la operación ( C * Tiempo + B )
         double resultado = C * tiempo[0] + B; // El indice 0 en tiempo es el tiempo al que deseas calcular

        // Imprimimos la ecuación de la recta
        System.out.println("La relación entre distancia y tiempo es: Distancia = " + C + " * Tiempo + " + B + " = " + resultado);

        // Calculamos la velocidad inicial (Vi) para cada medición
        double[] velocidadInicial = new double[n];
        for (int i = 0; i < n; i++) {
            velocidadInicial[i] = (distancia[i] - B) / (C * tiempo[i]);
        }
        
        // Imprimimos las velocidades iniciales para cada medición
        System.out.println("Velocidades iniciales (Vi) para cada medición:");
        for (int i = 0; i < n; i++) {
            System.out.println("Medición " + (i + 1) + ": " + velocidadInicial[i]);
        }

        // Calculamos el promedio de las velocidades iniciales obtenidas
        double sumaVi = 0;
        for (double vi : velocidadInicial) {
            sumaVi += vi;
        }
        double promedioVi = sumaVi / n;

        // Imprimimos el promedio de las velocidades iniciales
        System.out.println("El promedio de las velocidades iniciales (Vi) es: " + promedioVi);
    
        // Cerramos el Scanner al final de los procesos
        lector.close();
    }
    // Metodo para limpiar la pantalla
    public static void LimpiarPantalla() {
        try {
            ProcessBuilder limpiar = new ProcessBuilder("cmd", "/c", "cls");
            Process staProcess = limpiar.inheritIO().start();
            staProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void graficaDeBarra(double[] tiempo, double[] distancia) {
        System.out.println("\n   Gráfica de Barras");
        System.out.println("-------------------------");
        
        // Encontramos la distancia máxima para normalizar las barras
        double maxDistancia = 0;
        for (double d : distancia) {
            if (d > maxDistancia) {
                maxDistancia = d;
            }
        }
        
        // Tamaño máximo de la barra (en caracteres) para la normalización
        int tamañoMaximoBarra = 20;
        
        for (int i = 0; i < tiempo.length; i++) {
            // Calculamos el tamaño de la barra para esta medición
            int tamañoBarra = (int) Math.round((distancia[i] / maxDistancia) * tamañoMaximoBarra);
            
            // Imprimimos el número de medición y la barra de distancia
            System.out.print("Medición " + (i + 1) + ": ");
            for (int j = 0; j < tamañoBarra; j++) {
                // Utilizamos el carácter █ (bloque lleno) para representar la barra
                System.out.print("\u2588");
            }
            System.out.println(" (" + distancia[i] + "m en " + tiempo[i] + "s)");
        }
        System.out.println("-------------------------");
    }
    
}
