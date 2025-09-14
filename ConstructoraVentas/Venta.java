package ConstructoraVentas;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private String fechaVenta;
    private String periodoVenta;
    private String documentoCliente;
    private List<Material> materialesVendidos;
    private int contadorCompras;

    public Venta(int id, String fechaVenta, String periodoVenta, String documentoCliente) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.periodoVenta = periodoVenta;
        this.documentoCliente = documentoCliente;
        this.materialesVendidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public String getPeriodoVenta() {
        return periodoVenta;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public List<Material> getMaterialesVendido() {
        return materialesVendidos;
    }

    public void agregarMaterial(Material productoVendido) {
        materialesVendidos.add(productoVendido);
        contadorCompras++;
    }
    public void aplicarDescuento() {
        if (contadorCompras >= 5) {
            double descuento = 0.20 * calcularTotalVenta(); // Calcular el descuento
            // Restar el descuento al precio total de la venta
            for (Material material : materialesVendidos) {
                material.setPrecio(material.getPrecio() - descuento);
            }
        }
    }

    private double calcularTotalVenta() {
        return 0;
    }
}
