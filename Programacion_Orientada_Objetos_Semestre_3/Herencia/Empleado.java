package Herencia;

/*Usaremos: # Extends.
 *          # Protected = es para indicar que la variable sea heredada en una clase hija
 *          # Super
 */
public class Empleado {
    protected String idintificacion;
    protected String nombre;
    protected String cargo;
    @SuppressWarnings("unused")
    private int nit_Empresa;

    public Empleado(String idintificacion, String nombre, String cargo) {
        this.idintificacion = idintificacion;
        this.nombre = nombre;
        this.cargo = cargo;
    }
}
