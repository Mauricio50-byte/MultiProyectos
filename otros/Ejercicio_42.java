import java.util.Scanner;

public class Ejercicio_42 {
/*42.Una naranja tiene la capacidad de producir 0.05 voltios. Si un sistema de
iluminación requiere de x kilovoltios para su funcionamiento. Cuántas naranjas
realizan el trabajo deseado. Adicionalmente, si cada naranja pesa en promedio 6
gramos. ¿Cuántas toneladas son necesarias? */
   public static void main(String[] args) {
      Scanner lector = new Scanner(System.in);
    // Definimos las constantes
      double voltiosPorNaranja = 0.05; // Voltios por naranja
      double kilovoltiosPorVoltio = 1000; // Kilovoltios por voltio
   
    // Pedimos al usuario que ingrese la cantidad de kilovoltios requeridos
      System.out.print("Ingrese la cantidad de kilovoltios requeridos: ");
      double kilovoltiosRequeridos = lector.nextDouble();
    // Calculamos la cantidad de naranjas necesarias
     double naranjasNecesarias = kilovoltiosRequeridos / (voltiosPorNaranja * kilovoltiosPorVoltio); 
    // Convertimos el peso de las naranjas a toneladas
    double pesoPorNaranjaEnGramos = 6; // Gramos por naranja
    double gramosPorTonelada = 1000000; // Gramos por tonelada
   double pesoPorNaranjaEnToneladas = pesoPorNaranjaEnGramos / gramosPorTonelada;
    double pesoTotalEnToneladas = naranjasNecesarias * pesoPorNaranjaEnToneladas;
    
    // Mostramos los resultados
    System.out.println("Se necesitan " + naranjasNecesarias + " naranjas para producir " + kilovoltiosRequeridos + " kilovoltios.");
    System.out.println("Esto equivale a " + pesoTotalEnToneladas + " toneladas de naranjas.");
    lector.close();
   }
}
