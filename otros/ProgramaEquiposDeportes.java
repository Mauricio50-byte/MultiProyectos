import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class EquipoDeporte {
    private String nombre;
    private List<EquipoDeporte> equiposEnfrentados;

    public EquipoDeporte(String nombre) {
        this.nombre = nombre;
        equiposEnfrentados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEquipoEnfrentado(EquipoDeporte equipo) {
        equiposEnfrentados.add(equipo);
    }

    public List<EquipoDeporte> getEquiposEnfrentados() {
        return equiposEnfrentados;
    }
}

class JuegoDeportivo {
    List<EquipoDeporte> equipos;

    public JuegoDeportivo() {
        equipos = new ArrayList<>();
    }

    public void agregarEquipo(EquipoDeporte equipo) {
        equipos.add(equipo);
    }

    public void enfrentarEquiposAleatoriamente() {
        Random rand = new Random();

        for (EquipoDeporte equipo : equipos) {
            // Elegir un equipo aleatorio para enfrentar
            int indiceAleatorio = rand.nextInt(equipos.size());
            EquipoDeporte equipoEnfrentado = equipos.get(indiceAleatorio);

            // No enfrentar al mismo equipo
            while (equipo == equipoEnfrentado) {
                indiceAleatorio = rand.nextInt(equipos.size());
                equipoEnfrentado = equipos.get(indiceAleatorio);
            }

            equipo.agregarEquipoEnfrentado(equipoEnfrentado);
        }
    }

    public void seleccionarGanadoresAleatoriamente() {
        Random rand = new Random();

        for (EquipoDeporte equipo : equipos) {
            List<EquipoDeporte> equiposEnfrentados = equipo.getEquiposEnfrentados();
            if (!equiposEnfrentados.isEmpty()) {
                int indiceGanador = rand.nextInt(equiposEnfrentados.size());
                EquipoDeporte ganador = equiposEnfrentados.get(indiceGanador);
                System.out.println(equipo.getNombre() + " vs " + ganador.getNombre() + " - Ganador: " + ganador.getNombre());
            }
        }
    }
}

public class ProgramaEquiposDeportes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        EquipoDeporte equipo1 = new EquipoDeporte("Equipo A");
        EquipoDeporte equipo2 = new EquipoDeporte("Equipo B");
        EquipoDeporte equipo3 = new EquipoDeporte("Equipo C");
        EquipoDeporte equipo4 = new EquipoDeporte("Equipo D");

        JuegoDeportivo juego = new JuegoDeportivo();
        juego.agregarEquipo(equipo1);
        juego.agregarEquipo(equipo2);
        juego.agregarEquipo(equipo3);
        juego.agregarEquipo(equipo4);

        juego.enfrentarEquiposAleatoriamente();
        juego.seleccionarGanadoresAleatoriamente();
        
        System.out.println("Realiza una apuesta. Selecciona tu equipo para ganar (A, B, C o D): ");
        String equipoApostado = scanner.nextLine().toUpperCase();

        EquipoDeporte equipoApostadoObj = null;
        for (EquipoDeporte equipo : juego.equipos) {
            if (equipo.getNombre().equals("Equipo " + equipoApostado)) {
                equipoApostadoObj = equipo;
                break;
            }
        }

        if (equipoApostadoObj != null) {
            Random rand = new Random();
            List<EquipoDeporte> equiposEnfrentados = equipoApostadoObj.getEquiposEnfrentados();
            if (!equiposEnfrentados.isEmpty()) {
                int indiceGanador = rand.nextInt(equiposEnfrentados.size());
                EquipoDeporte ganador = equiposEnfrentados.get(indiceGanador);
                if (ganador == equipoApostadoObj) {
                    System.out.println("¡Ganaste! Duplicas tu apuesta.");
                } else {
                    System.out.println("Perdiste. Pierdes tu apuesta.");
                }
            } else {
                System.out.println("No hay enfrentamientos para el equipo apostado.");
            }
        } else {
            System.out.println("El equipo apostado no existe.");
        }

        scanner.close();
    }
}