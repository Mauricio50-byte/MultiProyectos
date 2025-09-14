package Herencia;

import java.util.Scanner;

public class App{

    static Aportes_Usuario[] usuarios = new Aportes_Usuario[100];
    static int cantidadUsuarios = 0;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("***** Menú *****");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Consultar Datos");
            System.out.println("3. Salir");
            System.out.println("****************");
            System.out.print("Ingrese una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario(lector);
                    break;
                case 2:
                    consultarUsuarios();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);

        lector.close();
    }

    public static void registrarUsuario(Scanner lector) {
        if (cantidadUsuarios < usuarios.length) {
            System.out.println("Ingrese el Nombre del Usuario: ");
            String nombre = lector.nextLine();
            System.out.println("Ingrese el numero de cedula del Usuario: ");
            String cedula = lector.nextLine();
            System.out.println("Ingrese el cargo del Usuario: ");
            String cargo = lector.nextLine();
    
            // Verificamos si ya existe un usuario con la misma cedula
            for (int i = 0; i < cantidadUsuarios; i++) {
                if (usuarios[i].getCedula().equals(cedula)) {
                    System.out.println("Ya existe un usuario registrado con esa cedula.");
                    return; // Salimos del metodo sin registrar
                }
            }
            int horas;
            do {
                System.out.println("Ingrese el numero de horas trabajadas : ");
                horas = lector.nextInt();
                lector.nextLine(); // Limpiamos el buffer del scanner
                if (horas > 15) {
                    System.out.println("Las horas trabajadas no pueden ser más de 15.");
                }
            } while (horas > 15);
    
            System.out.println("Ingrese el valor por horas trabajadas: ");
            int valor = lector.nextInt();
            System.out.println("Ingrese el numero de dias trabajados durante el semestre: ");
            int diasSemestre = lector.nextInt();
            System.out.println("Ingrese el numero de días trabajados: ");
            int dias = lector.nextInt();
            lector.nextLine();
    
            Aportes_Usuario usuario = new Aportes_Usuario(cedula, cargo, nombre, diasSemestre, dias, horas, valor);
            usuarios[cantidadUsuarios] = usuario;
            cantidadUsuarios++;
    
            System.out.println("Usuario registrado con exito.");
        } else {
            System.out.println("No hay espacio para mas usuarios.");
        }
    }
    public static void consultarUsuarios() {
        if (cantidadUsuarios > 0) {
            System.out.println("*********************************************************************************************************************");
            System.out.println("(Cargo)    (Numero Horas)     (Valor Horas)     (Dias trabajados)       (Dias traba durante Semestre)");
            System.out.println("*********************************************************************************************************************");
            for(int i = 0; i < cantidadUsuarios; i++){
                System.out.println(usuarios[i].cargo + "\t\t" +  usuarios[i].getNumeroHoras() + "\t\t" + usuarios[i].getValorHoras() + "\t\t\t" +
                usuarios[i].getDiasTrabajados() + "\t\t" + usuarios[i].getDiasTrabajadosSemestres());

                // Calculamos y mostramos el salario diario para el usuario
                int salarioDiario = Aportes_Usuario.salarioDiarios(usuarios[i].getNumeroHoras(), usuarios[i].getValorHoras());
                System.out.println("Salario Diario: " + salarioDiario);

                // Calculamos y mostramos el salario mensual para el usuario
                int salarioMensual = Aportes_Usuario.salarioMensual(salarioDiario);
                System.out.println("Salario Mensual: " + salarioMensual);

                // Calculamos y mostramos la prima de servicios para el usuario
                int primaServicios = Aportes_Usuario.primaDeServicios(salarioMensual, usuarios[i].getDiasTrabajadosSemestres());
                System.out.println("Prima de Servicios: " + primaServicios);

                // Calculamos y mostramos las cesantias para el usuario
                int cesantias = Aportes_Usuario.cesantias(salarioMensual, usuarios[i].getDiasTrabajados());
                System.out.println("Cesantias: " + cesantias);

                // Calculamos y mostramos los intereses sobre cesantias para el usuario
                int interesesCesantias = Aportes_Usuario.interecesSobreCesantias(cesantias, usuarios[i].getDiasTrabajados());
                System.out.println("Intereses sobre Cesantías: " + interesesCesantias);

                // Calculamos y mostramos el aporte a la salud para el usuario
                int aporteSalud = Aportes_Usuario.aporteSalud(salarioMensual);
                System.out.println("Aporte a la Salud: " + aporteSalud);

                // Calculamos y mostramos el aporte a la pension para el usuario
                int aportePension = Aportes_Usuario.aportePencion(salarioMensual);
                System.out.println("Aporte a la Pensión: " + aportePension);
                System.out.println(" \t\tDatos para el señor@ " + usuarios[i].getNombre() + " con el numero de cedula " + usuarios[i].getCedula() + " y el cargo de " + usuarios[i].cargo);
                System.out.println("****************************************************************************************************************\n\n");
            }
        } else {
            System.out.println("No hay usuarios registrados.");
        }
    }
}   
