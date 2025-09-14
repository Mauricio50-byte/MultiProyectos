package Aplicacion_de_Activos_fijos;

import java.util.ArrayList;
import java.util.List;

public class Dependencias {
    public String nombre;
    public String centroDeCosto;
    public List<Activo> activos;

    public Dependencias(String nombre, String centroDeCosto) {
        this.nombre = nombre;
        this.centroDeCosto = centroDeCosto;
        this.activos = new ArrayList<>();
    }

    public void agregarActivo(Activo activo) {
        activos.add(activo);
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Activo activo : activos) {
            total += activo.valorActual;
        }
        return total;
    }

    
}
