import AppData.*;
import objetos.convocatoria;
import objetos.egresado;
import objetos.empresa;

public class App extends Absoluto{

    public static void main(String[] args) {
        empresa Empresa_test_Admin = new empresa();
        Empresa_test_Admin.correo = "admin";
        Empresa_test_Admin.contraseña = "admin";
        Empresa_test_Admin.nombre = "admin";
        Empresa_test_Admin.nit = "admin";
        Empresa_test_Admin.telefono = "admin";
        Lista_empresas.add(Empresa_test_Admin);

        convocatoria test_convocatoria = new convocatoria();
        test_convocatoria.numero = "001";
        test_convocatoria.Fecha_Inicio = "23/23/2023";
        test_convocatoria.Fecha_Fin = "23/30/2023";
        test_convocatoria.Vacante = "Ingeniero";
        test_convocatoria.Sueldo = "1.700.000$";
        
        Empresa_test_Admin.convocatorias.add(test_convocatoria);
        
        
        egresado Egresado_test = new egresado();
        Egresado_test.correo = "user";
        Egresado_test.contraseña = "user";
        Egresado_test.nombre = "user";
        Egresado_test.programa_académico = "user";
        Egresado_test.documento= "user";
        Lista_egresados.add(Egresado_test);
        

        Boolean ciclo = true;
        while (ciclo) {
            String input = PrintMenu("X Menu de inicio", new String[] {
                "Ingresar session",
                "Registrar usuario",
                "Salir",
            });
            switch (input) {
                case "1":
                    menus.login.inicio();
                break;
                case "2":
                    menus.register.Inicio();
                break;
                case "3":
                    clear();
                    println("Que tenga un buen dia!!");
                    ciclo = false;
                break;
                default:
                    break;
            }
        }
    }
}
