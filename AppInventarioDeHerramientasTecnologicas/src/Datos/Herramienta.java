package Datos;

import java.util.ArrayList;

public class Herramienta {
    public double codigo;
    public String nombre;
    public double precio;
    public int cantidad;
    public static ArrayList<Herramienta> herramientaBD = new ArrayList<>();
    
    public Herramienta(double codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public double getCodigo() {
        return codigo;
    }
    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public static ArrayList<Herramienta> getHerramientaBD() {
        return herramientaBD;
    }
    public static void setHerramientaBD(ArrayList<Herramienta> herramientaBD) {
        Herramienta.herramientaBD = herramientaBD;
    }
}