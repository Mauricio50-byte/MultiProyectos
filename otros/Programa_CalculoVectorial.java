import java.util.Scanner;

public class Programa_CalculoVectorial {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Puntos del triángulo
        Punto punto1 = obtenerPunto(lector, "Ingrese las coordenadas del punto 1 (x1 y1): ");
        Punto punto2 = obtenerPunto(lector, "Ingrese las coordenadas del punto 2 (x2 y2): ");
        Punto punto3 = obtenerPunto(lector, "Ingrese las coordenadas del punto 3 (x3 y3): ");
        //llamamos la funcion pausar
        Pausa();
        // Menú
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Calcular distancia entre puntos");
            System.out.println("2. Identificar tipo de triángulo");
            System.out.println("3. Punto medio de un segmento");
            System.out.println("4. Crear punto desde coordenadas cartesianas");
            System.out.println("5. Crear punto desde coordenadas polares");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    //limpiamos la pantalla 
                    LimpiarPantalla();
                    // Calcular distancias entre los puntos
                    double ladoA = calcularDistancia(punto1, punto2);
                    double ladoB = calcularDistancia(punto2, punto3);
                    double ladoC = calcularDistancia(punto3, punto1);

                    // Resultados
                    System.out.println("Longitud del lado A: " + ladoA);
                    System.out.println("Longitud del lado B: " + ladoB);
                    System.out.println("Longitud del lado C: " + ladoC);
                    //llamamos la funcion pausar
                    Pausa();
                    break;
                case 2:
                    //limpiamos la pantalla 
                    LimpiarPantalla();
                    // Identificamos el tipo de triángulo (equilátero, isósceles, escaleno)
                    String tipoTriangulo = identificarTriangulo(calcularDistancia(punto1, punto2),
                                                                calcularDistancia(punto2, punto3),
                                                                calcularDistancia(punto3, punto1));
                    System.out.println("Tipo de triángulo: " + tipoTriangulo);
                    //llamamos la funcion pausar
                    Pausa();
                    break;
                case 3:
                    //limpiamos la pantalla 
                    LimpiarPantalla();
                    // Calculamos y mostramos el punto medio del lado A
                    Punto puntoMedioA = puntoMedio(punto1, punto2);
                    System.out.println("Punto medio del lado A: (" + puntoMedioA.getX() + ", " + puntoMedioA.getY() + ")");
                    // Calculamos y mostramos el punto medio del lado B
                    Punto puntoMedioB = puntoMedio(punto2, punto3);
                    System.out.println("Punto medio del lado B: (" + puntoMedioB.getX() + ", " + puntoMedioB.getY() + ")");

                    // Calculamos y mostramos el punto medio del lado C
                    Punto puntoMedioC = puntoMedio(punto3, punto1);
                    System.out.println("Punto medio del lado C: (" + puntoMedioC.getX() + ", " + puntoMedioC.getY() + ")");
                    Pausa();
                    break;
                case 4:
                    // Limpiamos la pantalla
                    LimpiarPantalla();
                    // Creamos un punto desde coordenadas cartesianas
                    System.out.print("Ingrese las coordenadas cartesianas (x y): ");
                    double xCartesiano = lector.nextDouble();
                    double yCartesiano = lector.nextDouble();
                    Punto nuevoPuntoCartesiano = crearPuntoDesdeCoordenadas(xCartesiano, yCartesiano);
                    System.out.println("Nuevo punto desde coordenadas cartesianas: (" + nuevoPuntoCartesiano.getX() + ", " + nuevoPuntoCartesiano.getY() + ")");
                    
                    // Calculamos la distancia entre el nuevo punto y el punto original punto1
                    double distanciaAlPunto1 = calcularDistancia(punto1, nuevoPuntoCartesiano);
                    System.out.println("Distancia entre el nuevo punto y el punto original punto1: " + distanciaAlPunto1);
                    
                    // Pausamos para después de mostrar resultados
                    Pausa();
                    break;
                case 5:
                    // Limpiamos la pantalla
                    LimpiarPantalla();
                    // Creamos un punto desde coordenadas polares
                    System.out.print("Ingrese el radio y el ángulo en grados (radio angulo): ");
                    double radioPolar = lector.nextDouble();
                    double anguloPolar = lector.nextDouble();
                    Punto nuevoPuntoPolar = crearPuntoDesdeCoordenadasPolares(radioPolar, anguloPolar);
                    System.out.println("Nuevo punto desde coordenadas polares: (" + nuevoPuntoPolar.getX() + ", " + nuevoPuntoPolar.getY() + ")");
                    // Pausamos para después de mostrar resultados
                    Pausa();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);

        lector.close();
    }

    private static Punto obtenerPunto(Scanner lector, String mensaje) {
        System.out.print(mensaje);
        double x = lector.nextDouble();
        double y = lector.nextDouble();
        return new Punto(x, y);
    }

    private static double calcularDistancia(Punto punto1, Punto punto2) {
        double deltaX = punto2.getX() - punto1.getX();
        double deltaY = punto2.getY() - punto1.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    private static String identificarTriangulo(double ladoA, double ladoB, double ladoC) {
        if (ladoA == ladoB && ladoB == ladoC) {
            return "Equilátero";
        } else if (ladoA == ladoB || ladoB == ladoC || ladoC == ladoA) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
    public static Punto puntoMedio(Punto punto1, Punto punto2) {
        double medioX = (punto1.getX() + punto2.getX()) / 2;
        double medioY = (punto1.getY() + punto2.getY()) / 2;
        return new Punto(medioX, medioY);
    }
     // Funcion para crear un Punto desde coordenadas cartesianas
    public static Punto crearPuntoDesdeCoordenadas(double x, double y) {
        return new Punto(x, y);
    }

    // Funcion para crear un Punto desde coordenadas polares
    public static Punto crearPuntoDesdeCoordenadasPolares(double radio, double anguloEnGrados) {
        // Convertimos el ángulo de grados a radianes
        double anguloEnRadianes = Math.toRadians(anguloEnGrados);

        // Calculamos las coordenadas cartesianas
        double x = radio * Math.cos(anguloEnRadianes);
        double y = radio * Math.sin(anguloEnRadianes);

        // Creamos y devolvemos el objeto Punto
        return new Punto(x, y);
    }
    public static void LimpiarPantalla() {
        try {
            ProcessBuilder limpiar = new ProcessBuilder("cmd", "/c", "cls");
            Process staProcess = limpiar.inheritIO().start();
            staProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Pausa() {
        try {
            System.out.println("\nPulse enter para continuar...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
}