package objetos;
import java.util.ArrayList;

// Extiende las propiedades de un objeto general
public class empresa extends usuario{
    public String nit;
    public String telefono;
    public ArrayList <convocatoria> convocatorias = new ArrayList<>();
    
    public empresa(String nit, String telefono) {
        this.nit = nit;
        this.telefono = telefono;
        this.TipoUsuario = "empresa";
    }


    public empresa() {
        this.TipoUsuario = "empresa";
    }
}
