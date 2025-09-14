public class Ejercicio_56 {
   /*56.Que exprese en horas, minutos y segundos un tiempo expresado en segundos. */
   public static void main(String[] args) {
      int segundosTotales = 3745; 

      int horas = segundosTotales / 3600;
      int minutos = (segundosTotales % 3600) / 60;
      int segundos = segundosTotales % 60;

      System.out.println("Tiempo en segundos: " + segundosTotales);
      System.out.println("Horas: " + horas);
      System.out.println("Minutos: " + minutos);
      System.out.println("Segundos: " + segundos);
    }

}
