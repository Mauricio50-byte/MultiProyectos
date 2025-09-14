public class Ejercicio136 {
    /*136. Programa que simule en pantalla, el funcionamiento de un reloj digital , con el
formato Horas:Minutos:segundos. */
public static void main(String[] args) throws InterruptedException {
    while (true) {
        long tiempoActual = System.currentTimeMillis();
        long segundos = (tiempoActual / 1000) % 60;
        long minutos = (tiempoActual / (1000 * 60)) % 60;
        long horas = (tiempoActual / (1000 * 60 * 60)) % 24;
        System.out.printf("%02d:%02d:%02d%n", horas, minutos, segundos);
        Thread.sleep(1000);
    } 
    }
}
