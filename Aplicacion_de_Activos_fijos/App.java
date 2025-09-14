package Aplicacion_de_Activos_fijos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String FILENAME = "datos.txt"; // Nombre del archivo de texto

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        List<Dependencias> dependencias = cargarDatosDesdeArchivo();

        int opcion;
        do {
            mostrarMenu(); // Mostramos el menu de cada interaccion del bucle
            opcion = lector.nextInt();
            lector.nextLine(); // Consumir el salto de línea después del número
            
            // Switch para manejar las diferentes opciones del menu
            switch (opcion) {
                case 1:
                    LimpiarPantalla();
                    agregarDependencia(dependencias, lector);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 2:
                    LimpiarPantalla();
                    agregarActivo(dependencias, lector);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 3:
                    LimpiarPantalla();
                    ordenarActivosPorNumero(dependencias);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 4:
                    LimpiarPantalla();
                    ordenarActivosPorIdentificacion(dependencias);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 5:
                    LimpiarPantalla();
                    ordenarActivosPorValorActual(dependencias);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 6:
                    LimpiarPantalla();
                    buscarActivoPorCodigo(dependencias, lector);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 7:
                    LimpiarPantalla();
                    buscarDependenciaConMenosValor(dependencias);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 8:
                    LimpiarPantalla();
                    buscarDependenciaConMayorValor(dependencias);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 9:
                    LimpiarPantalla();
                    buscarDependenciaPorActivo(dependencias, lector);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 10:
                    LimpiarPantalla();
                    buscarDependenciaPorFechaDeCompra(dependencias, lector);
                    Pausa();
                    LimpiarPantalla();
                    break;
                case 0:
                    LimpiarPantalla();
                    System.out.println("Saliendo..."); // mensaje de salida
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0); // Continuar hasta que la opción sea 0 (salir)
        
        // Cuando se cierra la aplicación, guardar los datos en el archivo
        guardarDatosEnArchivo(dependencias);

        lector.close(); // cerramos todas las operaciones del Scanner
    }
    
    // Metodo para guardar los datos en el archivo de texto
    public static void guardarDatosEnArchivo(List<Dependencias> dependencias) {
        try (FileWriter dato = new FileWriter(FILENAME)) {
            // Escribir cada dependencia y sus activos en el archivo
            for (Dependencias dependencia : dependencias) {
                dato.write("Dependencia: " + dependencia.nombre + "\n");
                dato.write("Centro de costo: " + dependencia.centroDeCosto + "\n");

                for (Activo activo : dependencia.getActivos()) {
                    dato.write("Activo: " + activo.numeroDeActivo + "\n");
                    dato.write("Descripcion: " + activo.descripcion + "\n");
                    dato.write("Fecha de compra: " + activo.fechaDeCompra.año + "/" + activo.fechaDeCompra.mes + "/" + activo.fechaDeCompra.dia + "\n");
                    dato.write("Documento del responsable: " + activo.documentoDelResponsable + "\n");
                    dato.write("Nombre del responsable: " + activo.nombreDelResponsable + "\n");
                    dato.write("Valor historico: " + activo.valorHistorico + "\n");
                    dato.write("Valor actual: " + activo.valorActual + "\n");
                    dato.write("Ubicacion especifica: " + activo.ubicacionEspecifica + "\n");
                }

                dato.write("\n"); // Separador entre dependencias
            }

            System.out.println("Datos guardados en el archivo: " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }

    // Metodo para cargar datos desde el archivo al iniciar del programa
    public static List<Dependencias> cargarDatosDesdeArchivo() {
        List<Dependencias> dependencias = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            Dependencias dependencia = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Dependencia: ")) {
                    String nombre = line.substring("Dependencia: ".length());
                    String centroDeCosto = reader.readLine().substring("Centro de costo: ".length());
                    dependencia = new Dependencias(nombre, centroDeCosto);
                    dependencias.add(dependencia);
                } else if (line.startsWith("Activo: ") && dependencia != null) {
                    int numeroDeActivo = Integer.parseInt(line.substring("Activo: ".length()));
                    String descripcion = reader.readLine().substring("Descripcion: ".length());
                    String[] fechaPartes = reader.readLine().substring("Fecha de compra: ".length()).split("/");
                    int año = Integer.parseInt(fechaPartes[0]);
                    int mes = Integer.parseInt(fechaPartes[1]);
                    int dia = Integer.parseInt(fechaPartes[2]);
                    FechaDeCompra fechaDeCompra = new FechaDeCompra(año, mes, dia);
                    String documentoDelResponsable = reader.readLine().substring("Documento del responsable: ".length());
                    String nombreDelResponsable = reader.readLine().substring("Nombre del responsable: ".length());
                    double valorHistorico = Double.parseDouble(reader.readLine().substring("Valor historico: ".length()));
                    double valorActual = Double.parseDouble(reader.readLine().substring("Valor actual: ".length()));
                    String ubicacionEspecifica = reader.readLine().substring("Ubicacion especifica: ".length());

                    Activo activo = new Activo(numeroDeActivo, descripcion, fechaDeCompra, documentoDelResponsable, nombreDelResponsable, valorHistorico, valorActual, ubicacionEspecifica);
                    dependencia.agregarActivo(activo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return dependencias;
    }

    //Metodo para mostrar el menu
    public static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Agregar una nueva dependencia");
        System.out.println("2. Agregar activos a una dependencia");
        System.out.println("3. Ordenar ascendentemente los activos por numero");
        System.out.println("4. Ordenar ascendentemente los activos por identificacion");
        System.out.println("5. Ordenar descendentemente los activos por valor actual");
        System.out.println("6. Buscar un activo dado su codigo");
        System.out.println("7. Buscar la dependencia con menos valor de activos");
        System.out.println("8. Buscar la dependencia con mayor valor de activos");
        System.out.println("9. Buscar la dependencia que tenga un activo dado su codigo");
        System.out.println("10. Buscar la dependencia que tenga un activo según una fecha de compra dada");
        System.out.println("0. Salir");
        System.out.println("Ingrese la opción deseada:");
    }

    // Metodo para Agregar las dependencias
    public static void agregarDependencia(List<Dependencias> dependencias, Scanner lector) {
        System.out.println("Ingrese el nombre de la dependencia:");
        String nombre = lector.nextLine();
        System.out.println("Ingrese el centro de costo:");
        String centroDeCosto = lector.nextLine();
        Dependencias dependencia = new Dependencias(nombre, centroDeCosto);
        dependencias.add(dependencia);
        System.out.println("Dependencia agregada correctamente.");
    }

    // Metodo para agregar activos a una dependencia
    public static void agregarActivo(List<Dependencias> dependencias, Scanner lector) {
        if (dependencias.isEmpty()) {
            System.out.println("No hay dependencias disponibles. Primero agregue una dependencia.");
            return;
        }

        System.out.println("Seleccione la dependencia:");
        for (int i = 0; i < dependencias.size(); i++) {
            System.out.println((i + 1) + ". " + dependencias.get(i).nombre);
        }
        int opcion = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea después del número

        if (opcion < 1 || opcion > dependencias.size()) {
            System.out.println("Opción no valida.");
            return;
        }

        Dependencias dependencia = dependencias.get(opcion - 1);

        System.out.println("Ingrese el numero de activo:");
        int numeroDeActivo = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea después del número

        System.out.println("Ingrese la descripcion del activo:");
        String descripcion = lector.nextLine();

        System.out.println("Ingrese el año de compra:");
        int año = lector.nextInt();

        System.out.println("Ingrese el mes de compra:");
        int mes = lector.nextInt();

        System.out.println("Ingrese el dia de compra:");
        int dia = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea después del número

        System.out.println("Ingrese el documento del responsable:");
        String documentoDelResponsable = lector.nextLine();

        System.out.println("Ingrese el nombre del responsable:");
        String nombreDelResponsable = lector.nextLine();

        System.out.println("Ingrese el valor historico:");
        double valorHistorico = lector.nextDouble();

        System.out.println("Ingrese el valor actual:");
        double valorActual = lector.nextDouble();
        lector.nextLine(); // Consumir el salto de línea después del número

        System.out.println("Ingrese la ubicacion especifica:");
        String ubicacionEspecifica = lector.nextLine();

        FechaDeCompra fechaDeCompra = new FechaDeCompra(año, mes, dia);
        Activo activo = new Activo(numeroDeActivo, descripcion, fechaDeCompra, documentoDelResponsable, nombreDelResponsable, valorHistorico, valorActual, ubicacionEspecifica);
        dependencia.agregarActivo(activo);

        System.out.println("Activo agregado correctamente.");
    }

    // Metodo para ordenar los activos de las dependencias por numero
    public static void ordenarActivosPorNumero(List<Dependencias> dependencias) {
        for (Dependencias dependencia : dependencias) {
            dependencia.getActivos().sort(Comparator.comparingInt(activo -> activo.numeroDeActivo));
        }
        System.out.println("Activos ordenados por numero de activo.");
    }

    // Metodo para ordenar los activos de las dependencias por identificacion
    public static void ordenarActivosPorIdentificacion(List<Dependencias> dependencias) {
        for (Dependencias dependencia : dependencias) {
            dependencia.getActivos().sort(Comparator.comparing(activo -> activo.descripcion));
        }
        System.out.println("Activos ordenados por identificacion.");
    }

    // Metodo para ordenar los activos de las dependencias por valor actual
    public static void ordenarActivosPorValorActual(List<Dependencias> dependencias) {
        for (Dependencias dependencia : dependencias) {
            dependencia.getActivos().sort(Comparator.comparingDouble(activo -> -activo.valorActual));
        }
        System.out.println("Activos ordenados por valor actual en forma descendente.");
    }

    // Metodo para buscar un activo por codigo
    public static void buscarActivoPorCodigo(List<Dependencias> dependencias, Scanner lector) {
        System.out.println("Ingrese el codigo del activo:");
        int codigo = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea después del número
    
        boolean encontrado = false;
    
        for (Dependencias dependencia : dependencias) {
            for (Activo activo : dependencia.getActivos()) {
                if (activo.numeroDeActivo == codigo) {
                    encontrado = true;
                    System.out.println("Activo encontrado:");
                    System.out.println("Dependencia: " + dependencia.nombre);
                    System.out.println("Número de activo: " + activo.numeroDeActivo);
                    System.out.println("Descripción: " + activo.descripcion);
                    System.out.println("Fecha de compra: " + activo.fechaDeCompra.año + "/" + activo.fechaDeCompra.mes + "/" + activo.fechaDeCompra.dia);
                    System.out.println("Documento del responsable: " + activo.documentoDelResponsable);
                    System.out.println("Nombre del responsable: " + activo.nombreDelResponsable);
                    System.out.println("Valor histórico: " + activo.valorHistorico);
                    System.out.println("Valor actual: " + activo.valorActual);
                    System.out.println("Ubicación específica: " + activo.ubicacionEspecifica);
                    break;
                }
            }
        }
    
        if (!encontrado) {
            System.out.println("Activo no encontrado.");
        }
    }

    
    // Metodo para buscar la dependencia con menos valor de activos
    public static void buscarDependenciaConMenosValor(List<Dependencias> dependencias) {
        Dependencias dependenciaMenosValor = null;
        double menorValor = Double.MAX_VALUE;
    
        for (Dependencias dependencia : dependencias) {
            double valorTotal = dependencia.calcularTotal();
            if (valorTotal < menorValor) {
                menorValor = valorTotal;
                dependenciaMenosValor = dependencia;
            }
        }
    
        System.out.println("Dependencia con menos valor de activos:");
        if (dependenciaMenosValor != null) {
            System.out.println("Nombre: " + dependenciaMenosValor.nombre);
            System.out.println("Centro de costo: " + dependenciaMenosValor.centroDeCosto);
            System.out.println("Valor total de activos: " + menorValor);
        } else {
            System.out.println("No hay dependencias disponibles.");
        }
    }

    // Metodo para buscar la dependencia con mayor valor de activos
    public static void buscarDependenciaConMayorValor(List<Dependencias> dependencias) {
        Dependencias dependenciaMayorValor = null;
        double mayorValor = Double.MIN_VALUE;
    
        for (Dependencias dependencia : dependencias) {
            double valorTotal = dependencia.calcularTotal();
            if (valorTotal > mayorValor) {
                mayorValor = valorTotal;
                dependenciaMayorValor = dependencia;
            }
        }
    
        System.out.println("Dependencia con mayor valor de activos:");
        if (dependenciaMayorValor != null) {
            System.out.println("Nombre: " + dependenciaMayorValor.nombre);
            System.out.println("Centro de costo: " + dependenciaMayorValor.centroDeCosto);
            System.out.println("Valor total de activos: " + mayorValor);
        } else {
            System.out.println("No hay dependencias disponibles.");
        }
    }

    // Metodo para buscar la dependencia que tenga un activo dado su codigo
    public static void buscarDependenciaPorActivo(List<Dependencias> dependencias, Scanner lector) {
        System.out.println("Ingrese el codigo del activo:");
        int codigo = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea después del número
    
        boolean encontrado = false;
    
        for (Dependencias dependencia : dependencias) {
            for (Activo activo : dependencia.getActivos()) {
                if (activo.numeroDeActivo == codigo) {
                    encontrado = true;
                    System.out.println("Dependencia que tiene el activo:");
                    System.out.println("Nombre: " + dependencia.nombre);
                    System.out.println("Centro de costo: " + dependencia.centroDeCosto);
                    System.out.println("Activo:");
                    System.out.println("Número de activo: " + activo.numeroDeActivo);
                    System.out.println("Descripción: " + activo.descripcion);
                    System.out.println("Fecha de compra: " + activo.fechaDeCompra.año + "/" + activo.fechaDeCompra.mes + "/" + activo.fechaDeCompra.dia);
                    System.out.println("Documento del responsable: " + activo.documentoDelResponsable);
                    System.out.println("Nombre del responsable: " + activo.nombreDelResponsable);
                    System.out.println("Valor histórico: " + activo.valorHistorico);
                    System.out.println("Valor actual: " + activo.valorActual);
                    System.out.println("Ubicación específica: " + activo.ubicacionEspecifica);
                    break;
                }
            }
        }
    
        if (!encontrado) {
            System.out.println("No se encontro ninguna dependencia que tenga el activo con el código proporcionado.");
        }
    }

    // Metodo para buscar la dependencia que tenga un activo segun una fecha de compra dada
    public static void buscarDependenciaPorFechaDeCompra(List<Dependencias> dependencias, Scanner lector) {
        System.out.println("Ingrese el año de compra:");
        int año = lector.nextInt();
        System.out.println("Ingrese el mes de compra:");
        int mes = lector.nextInt();
        System.out.println("Ingrese el dia de compra:");
        int dia = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea después de leer el número
    
        FechaDeCompra fechaBuscada = new FechaDeCompra(año, mes, dia);
    
        boolean encontrado = false;
    
        for (Dependencias dependencia : dependencias) {
            for (Activo activo : dependencia.getActivos()) {
                if (activo.fechaDeCompra.equals(fechaBuscada)) {
                    encontrado = true;
                    System.out.println("Dependencia que tiene el activo con la fecha de compra proporcionada:");
                    System.out.println("Nombre: " + dependencia.nombre);
                    System.out.println("Centro de costo: " + dependencia.centroDeCosto);
                    System.out.println("Activo:");
                    System.out.println("Número de activo: " + activo.numeroDeActivo);
                    System.out.println("Descripción: " + activo.descripcion);
                    System.out.println("Fecha de compra: " + activo.fechaDeCompra.año + "/" + activo.fechaDeCompra.mes + "/" + activo.fechaDeCompra.dia);
                    System.out.println("Documento del responsable: " + activo.documentoDelResponsable);
                    System.out.println("Nombre del responsable: " + activo.nombreDelResponsable);
                    System.out.println("Valor histórico: " + activo.valorHistorico);
                    System.out.println("Valor actual: " + activo.valorActual);
                    System.out.println("Ubicación específica: " + activo.ubicacionEspecifica);
                }
            }
        }
    
        if (!encontrado) {
            System.out.println("No se encontró ninguna dependencia que tenga un activo con la fecha de compra proporcionada.");
        }
    }
    // Metodo para limpiar la pantalla
    public static void LimpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Metodo para pausar la ejecucion del programa
    public static void Pausa() {
        System.out.println("Presione enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
