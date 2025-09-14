package Datos;

import java.util.ArrayList;

public class Usuario {
    public String nombre;
    private String apellido;
    private String numCedula;
    private String correo;
    private String contraseña;
    private String numTelefono;
    private double saldoUsuario;
    public static ArrayList<Usuario> usuariosBD = new ArrayList<>();

    public Usuario(String nombre, String apellido, String numCedula, String correo, String contraseña, String numTelefono, double saldoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCedula = numCedula;
        this.correo = correo;
        this.contraseña = contraseña;
        this.numTelefono = numTelefono;
        this.saldoUsuario = saldoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public double getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(double saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }

    public static ArrayList<Usuario> getUsuariosBD() {
        return usuariosBD;
    }

    public static void setUsuariosBD(ArrayList<Usuario> usuariosBD) {
        Usuario.usuariosBD = usuariosBD;
    }
}
