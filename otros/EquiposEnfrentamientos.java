import java.util.ArrayList;
import java.util.Collections;

class Equipo {
    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

public class EquiposEnfrentamientos {
    private ArrayList<Equipo> equipos;

    public EquiposEnfrentamientos() {
        equipos = new ArrayList<>();
        equipos.add(new Equipo("Real Madrid"));
        equipos.add(new Equipo("FC Barcelona"));
        equipos.add(new Equipo("Manchester United"));
        equipos.add(new Equipo("Liverpool FC"));
        equipos.add(new Equipo("Bayern Munich"));
        equipos.add(new Equipo("AC Milan"));
        equipos.add(new Equipo("Paris Saint-Germain"));
        equipos.add(new Equipo("Juventus"));
        equipos.add(new Equipo("Chelsea FC"));
        equipos.add(new Equipo("Arsenal FC"));
        equipos.add(new Equipo("Borussia Dortmund"));
        equipos.add(new Equipo( "Manchester City"));
        equipos.add(new Equipo("Atletico Madrid"));
        equipos.add(new Equipo("Inter Milan"));
        equipos.add(new Equipo("Tottenham Hotspur"));
        equipos.add(new Equipo("Real Betis"));
        equipos.add(new Equipo("Valencia CF"));
        equipos.add(new Equipo("Sevilla FC"));
        equipos.add(new Equipo("Napoli"));
        equipos.add(new Equipo("AS Roma"));
    }

    public ArrayList<Equipo> elegirEquiposAleatorios() {
        if (equipos.size() < 10) {
            System.out.println("No hay suficientes equipos para crear 5 enfrentamientos.");
            return new ArrayList<>();
        }
    
        ArrayList<Equipo> equiposAleatorios = new ArrayList<>();
        ArrayList<Equipo> copiaEquipos = new ArrayList<>(equipos);
        Collections.shuffle(copiaEquipos);
    
        for (int i = 0; i < 10; i++) {
            equiposAleatorios.add(copiaEquipos.get(i));
        }
    
        return equiposAleatorios;
    }

    public void crearEnfrentamientos(ArrayList<Equipo> equiposAleatorios) {
        if (equiposAleatorios.size() != 10) {
            System.out.println("Se necesitan exactamente 10 equipos para crear 5 enfrentamientos.");
            return;
        }
    
        System.out.println("Enfrentamientos:");
        for (int i = 0; i < 5; i++) {
            Equipo equipoLocal = equiposAleatorios.get(i * 2);
            Equipo equipoVisitante = equiposAleatorios.get(i * 2 + 1);
    
            if (equipos.contains(equipoLocal) && equipos.contains(equipoVisitante)) {
                System.out.println(equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());
            } else {
                System.out.println("Alguno de los equipos seleccionados no existe en la lista de equipos predefinidos.");
                return;
            }
        }
    }

    public static void main(String[] args) {
        EquiposEnfrentamientos futbol = new EquiposEnfrentamientos();
        ArrayList<Equipo> equiposAleatorios = futbol.elegirEquiposAleatorios();
        futbol.crearEnfrentamientos(equiposAleatorios);
    }
}
