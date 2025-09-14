package objetos;

// Extiende las propiedades de un objeto general
public class egresado extends usuario{
    public String documento;
    public String apellido;
    public String programa_académico;

    public egresado(String documento, String apellido, String programa_académico) {
        this.documento = documento;
        this.apellido = apellido;
        this.programa_académico = programa_académico;
        this.TipoUsuario = "egresado";
    }

    public egresado() {
        this.TipoUsuario = "egresado";
    }
}