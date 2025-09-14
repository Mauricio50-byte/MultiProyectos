package Herencia;

public class Aportes_Usuario extends Empleado{

    public int diasTrabajadosSemestres;
    public int diasTrabajados;
    public int numeroHoras;
    public int valorHoras;
    
    public Aportes_Usuario (String idintificacion, String cargo, String nombre,
                            int diasTrabajadosSemestres, int diasTrabajados, 
                            int numeroHoras, int valorHoras) {

        super(idintificacion,nombre,cargo);
        this.diasTrabajadosSemestres = diasTrabajadosSemestres;
        this.diasTrabajados = diasTrabajados;
        this.numeroHoras = numeroHoras;
        this.valorHoras = valorHoras;
    }

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return idintificacion;
    }
    public void setCedula(String identificacion) {
        this.idintificacion = identificacion;
    }

    public int getDiasTrabajadosSemestres() {
        return diasTrabajadosSemestres;
    }
    public void setDiasTrabajadosSemestres(int diasTrabajadosSemestres) {
        this.diasTrabajadosSemestres = diasTrabajadosSemestres;
    }
    public int getDiasTrabajados() {
        return diasTrabajados;
    }
    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }
    public int getNumeroHoras() {
        return numeroHoras;
    }
    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }
    public int getValorHoras() {
        return valorHoras;
    }
    public void setValorHoras(int valorHoras) {
        this.valorHoras = valorHoras;
    }
    
    public static int primaDeServicios(int salarioMensual, int diasTrabajadosSemestres){
        int valor = (salarioMensual * diasTrabajadosSemestres) / 360;
        return valor;
    }

    public static int cesantias(int salarioMensual, int diasTrabajados){
        int valor = (salarioMensual * diasTrabajados) / 360;
        return valor;
    }

    public static int interecesSobreCesantias(int cesantias, int diasTrabajados){
        double dato = 0.12;
        int nuevoValor = (int) dato;
        int valor = (cesantias * diasTrabajados * nuevoValor) / 360;
        return valor;
    }
    //metodo para calcular el salario diario
    public static int salarioDiarios(int nro_horasTrabajadas,int valorHoras){
        int salario = nro_horasTrabajadas * valorHoras;
        return salario;
    }

    public static int salarioMensual(int salarioDiarios){
        int valor = salarioDiarios * 30;
        return valor;
    }

    public static int aporteSalud(int salarioMensual){
        double dato = 12.5;
        int nuevoValor = (int) dato;
        int valor = salarioMensual * nuevoValor;
        return valor;
    }
    
    public static int aportePencion(int salarioMensual){
        int valor = salarioMensual * 16;
        return valor;
    }
}
