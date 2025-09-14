package objetos;

import java.util.ArrayList;

public class convocatoria {
    public String numero;
    public String Fecha_Inicio;
    public String Fecha_Fin;
    public String Vacante;
    public String Sueldo;
    public ArrayList <Object> Usuarios_Que_Aplicaron = new ArrayList<>();
    
    public convocatoria(String numero, String fecha_Inicio, String fecha_Fin, String bacante, String sueldo) {
        this.numero = numero;
        Fecha_Inicio = fecha_Inicio;
        Fecha_Fin = fecha_Fin;
        Vacante = bacante;
        Sueldo = sueldo;
    }
    public convocatoria() {}
    
}
