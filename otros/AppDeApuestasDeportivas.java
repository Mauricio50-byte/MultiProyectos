import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Usuario {
    private String nombre;
    private String apellido;
    private int edad;

    public Usuario(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }

    public int getEdad() {
        return edad;
    }
}

class ApuestasDeportivas {
    private List<String> nombresDeportes;
    private Map<String, List<String>> equiposPorDeporte;

    public ApuestasDeportivas() {
        // Inicializar la lista de deportes
        nombresDeportes = new ArrayList<>();
        nombresDeportes.add("Fútbol");
        nombresDeportes.add("Baloncesto");
        nombresDeportes.add("Tenis");
        nombresDeportes.add("Atletismo");
        nombresDeportes.add("Natación");

        // Inicializar la lista de equipos por deporte
        equiposPorDeporte = new HashMap<>();
        equiposPorDeporte.put("Fútbol", generarEquipos(10));
        equiposPorDeporte.put("Baloncesto", generarEquipos(8));
        equiposPorDeporte.put("Tenis", generarEquipos(4));
        equiposPorDeporte.put("Atletismo", generarEquipos(6));
        equiposPorDeporte.put("Natación", generarEquipos(5));
    }

    private List<String> generarEquipos(int numEquipos) {
        List<String> equipos = new ArrayList<>();
        for (int i = 1; i <= numEquipos; i++) {
            equipos.add("Equipo" + i);
        }
        return equipos;
    }

    public void mostrarDeportesDisponibles() {
        System.out.println("Deportes disponibles para el día de hoy:");
        for (String deporte : nombresDeportes) {
            System.out.println(deporte);
        }
    }

    public void generarEnfrentamientos(String deporteSeleccionado) {
        if (!nombresDeportes.contains(deporteSeleccionado)) {
            System.out.println("Deporte no válido.");
            return;
        }

        Random random = new Random();
        List<String> equipos = equiposPorDeporte.get(deporteSeleccionado);

        int equipo1Index = random.nextInt(equipos.size());
        int equipo2Index;
        do {
            equipo2Index = random.nextInt(equipos.size());
        } while (equipo2Index == equipo1Index);

        String equipo1 = equipos.get(equipo1Index);
        String equipo2 = equipos.get(equipo2Index);

        int marcadorEquipo1 = random.nextInt(5);
        int marcadorEquipo2 = random.nextInt(5);

        String ganador;
        if (marcadorEquipo1 > marcadorEquipo2) {
            ganador = equipo1;
        } else if (marcadorEquipo1 < marcadorEquipo2) {
            ganador = equipo2;
        } else {
            ganador = "Empate";
        }

        System.out.println("Encuentro: " + equipo1 + " vs " + equipo2);
        System.out.println("Marcador: " + equipo1 + " " + marcadorEquipo1 + " - " + equipo2 + " " + marcadorEquipo2);
        System.out.println("Ganador: " + ganador);
    }
}

public class AppDeApuestasDeportivas {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        // Crear algunos usuarios
        usuarios.put("usuario1", new Usuario("John", "Doe", 30));
        usuarios.put("usuario2", new Usuario("Alice", "Smith", 25));

        // Mostrar menú principal
        mostrarMenu();
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        ApuestasDeportivas apuestas = new ApuestasDeportivas();

        while (true) {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Mostrar deportes disponibles");
            System.out.println("2. Generar enfrentamientos");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Modificar usuario");
            System.out.println("6. Eliminar usuario");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    apuestas.mostrarDeportesDisponibles();
                    break;
                case 2:
                    System.out.print("Seleccione un deporte: ");
                    String deporteSeleccionado = scanner.nextLine();
                    apuestas.generarEnfrentamientos(deporteSeleccionado);
                    break;
                case 3:
                    registrarUsuario(scanner);
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    modificarUsuario(scanner);
                    break;
                case 6:
                    eliminarUsuario(scanner);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Usuario nuevoUsuario = new Usuario(nombre, apellido, edad);
        usuarios.put(nombre.toLowerCase(), nuevoUsuario);

        System.out.println("Usuario registrado exitosamente.");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("===== Lista de Usuarios =====");
            for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
                Usuario usuario = entry.getValue();
                System.out.println("Usuario: " + entry.getKey());
                usuario.imprimirInformacion();
                System.out.println();
            }
        }
    }
        private static void modificarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a modificar: ");
        String nombreUsuario = scanner.nextLine().toLowerCase();

        if (usuarios.containsKey(nombreUsuario)) {
            Usuario usuario = usuarios.get(nombreUsuario);
            System.out.println("Usuario encontrado. Proporcione los nuevos datos:");

            System.out.print("Ingrese el nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            usuario = new Usuario(nuevoNombre, usuario.getNombre(), usuario.getEdad());

            usuarios.remove(nombreUsuario);
            usuarios.put(nuevoNombre.toLowerCase(), usuario);

            System.out.println("Usuario modificado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a eliminar: ");
        String nombreUsuario = scanner.nextLine().toLowerCase();

        if (usuarios.containsKey(nombreUsuario)) {
            usuarios.remove(nombreUsuario);
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}