package Ejercicio_con_objetos;

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
            System.out.println("Ingrese el numero de cédula del Usuario: ");
            String cedula = lector.nextLine();
    
            // Verificamos si ya existe un usuario con la misma cedula
            for (int i = 0; i < cantidadUsuarios; i++) {
                if (usuarios[i].getCedula().equals(cedula)) {
                    System.out.println("Ya existe un usuario registrado con esa cedula.");
                    return; // Salimos del metodo sin registrar
                }
            }
            System.out.println("Ingrese el salario Mesual: ");
            int salario = lector.nextInt();
            
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
    
            Aportes_Usuario usuario = new Aportes_Usuario(nombre, cedula, salario, horas, valor, diasSemestre, dias);
            usuarios[cantidadUsuarios] = usuario;
            cantidadUsuarios++;
    
            System.out.println("Usuario registrado con exito.");
        } else {
            System.out.println("No hay espacio para mas usuarios.");
        }
    }
    public static void consultarUsuarios() {
        if (cantidadUsuarios > 0) {
            System.out.println("**********************************************************************************************************");
            System.out.println("(Salario M)     (Numero Horas)     (Valor Horas)     (Dias trabajados)       (Dias traba durante Semestre)");
            System.out.println("**********************************************************************************************************");
            for(int i = 0; i < cantidadUsuarios; i++){
                System.out.println(usuarios[i].salarioMensual + "\t\t\t" + usuarios[i].numeroHoras + "\t\t\t" + usuarios[i].valorHoras + "\t\t\t" +
                usuarios[i].diasTrabajados + "\t\t\t" + usuarios[i].diasTrabajadosSemestres);

                // Calculamos y mostramos la prima de servicios para el usuario
                int primaServicios = Aportes_Usuario.primaDeServicios(usuarios[i].salarioMensual, usuarios[i].diasTrabajadosSemestres);
                System.out.println("Prima de Servicios: " + primaServicios);

                // Calculamos y mostramos las cesantias para el usuario
                int cesantias = Aportes_Usuario.cesantias(usuarios[i].salarioMensual, usuarios[i].diasTrabajados);
                System.out.println("Cesantías: " + cesantias);

                // Calculamos y mostramos los intereses sobre cesantias para el usuario
                int interesesCesantias = Aportes_Usuario.interecesSobreCesantias(cesantias, usuarios[i].diasTrabajados);
                System.out.println("Intereses sobre Cesantías: " + interesesCesantias);

                // Calculamos y mostramos el salario diario para el usuario
                int salarioDiario = Aportes_Usuario.salarioDiarios(usuarios[i].numeroHoras, usuarios[i].valorHoras);
                System.out.println("Salario Diario: " + salarioDiario);

                // Calculamos y mostramos el salario mensual para el usuario
                int salarioMensual = Aportes_Usuario.salarioMensual(salarioDiario);
                System.out.println("Salario Mensual: " + salarioMensual);

                // Calculamos y mostramos el aporte a la salud para el usuario
                int aporteSalud = Aportes_Usuario.aporteSalud(salarioMensual);
                System.out.println("Aporte a la Salud: " + aporteSalud);

                // Calculamos y mostramos el aporte a la pension para el usuario
                int aportePension = Aportes_Usuario.aportePencion(salarioMensual);
                System.out.println("Aporte a la Pensión: " + aportePension);
                System.out.println(" \t\tDatos para el señor@ " + usuarios[i].nombre + " con el numero de cedula " + usuarios[i].cedula);
                System.out.println("******************************************************************************************************\n\n");
            }
        } else {
            System.out.println("No hay usuarios registrados.");
        }
    }
}   
