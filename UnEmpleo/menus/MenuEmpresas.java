package menus;

import java.util.ArrayList;

import AppData.Absoluto;
import objetos.convocatoria;
import objetos.egresado;
import objetos.empresa;

public class MenuEmpresas  extends Absoluto{
    public static void Inicio(){
        boolean ciclo = true;
        while (ciclo) {
            String input = PrintMenu("Menu Empresa: bienvenido " + ((empresa) User_Session).nombre, new String[]{
                "Gestionar mis convocatorias",
                "Gestionar info de empresa",
                "Volver",
            });
            switch (input) {
                case "1":
                    Gestionar_Convocatorias();
                    break;
                case "2":
                    Gestionar_Info_Empresa();
                    break;
                case "3":
                    ciclo = false;
                    break;
                default:
                    break;
            }
        }
        return;
    }


    private static void Gestionar_Convocatorias(){
        boolean ciclo = true;
        while (ciclo) {
            ArrayList<String> lista_convocatoria_TEXTO_Menu = new ArrayList<>();
            lista_convocatoria_TEXTO_Menu.add("Volver");
            lista_convocatoria_TEXTO_Menu.add("Añadir");
            for (convocatoria convocatoria : ((empresa) User_Session).convocatorias) {
                String item = "";
                item += " Numero [" + convocatoria.numero + "] ";
                item += " Fecha [" +  convocatoria.Fecha_Inicio + " - " + convocatoria.Fecha_Fin + "]";
                item += " vacante [" +  convocatoria.Vacante + "] ";
                item += " Sueldo [" +  convocatoria.Sueldo + "] ";
                lista_convocatoria_TEXTO_Menu.add(item);
            }
            int input = Integer.parseInt(PrintMenu("Lista de convocatorias", lista_convocatoria_TEXTO_Menu, "Seleccione una convocatoria: "));
            if (input==1) {
                ciclo = false;
            }else if (input==2) {
                Añadir_Convocatoria();
            }else if (input<=lista_convocatoria_TEXTO_Menu.size()) {
                Menu_Convocatoria(input -3);
            }
        }
    }
    

    private static void Menu_Convocatoria(int Convocatoria_Seleccionada){
        boolean ciclo = true;
        while (ciclo) {
            String title = "";
            title += " Numero:" + ((empresa) User_Session).convocatorias.get(Convocatoria_Seleccionada).numero;
            title += " Vacante:" + ((empresa) User_Session).convocatorias.get(Convocatoria_Seleccionada).Vacante;
            String input = PrintMenu("Convocatoria ( " + title + ")", new String[]{
                "editar",
                "Eliminar",
                "Ver personas que aplicaron",
                "Volver",
            });
            switch (input) {
                case "1":
                    Editar_Convocatoria(Convocatoria_Seleccionada);
                    break;
                case "2":
                    Eliminar_Convocatoria(Convocatoria_Seleccionada);
                    ciclo = false;
                    break;
                case "3":
                    ver_personas_aplicaron(Convocatoria_Seleccionada);
                    break;
                case "4":
                ciclo = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    private static void ver_personas_aplicaron(int Convocatoria_Seleccionada){
        clear();
        convocatoria esta_convocatoria = ((empresa) User_Session).convocatorias.get(Convocatoria_Seleccionada);
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        println("Lista de egresados que aplicaron esta convocatoria [Numero:" + esta_convocatoria.numero + " Vacante:" + esta_convocatoria.Vacante + "]");
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        for (Object elemento : esta_convocatoria.Usuarios_Que_Aplicaron) {
            String item = "";
            egresado user_egresado = (egresado)elemento;
            item += "Nombre [" + user_egresado.nombre + "] ";
            item += "Correo [" + user_egresado.correo + "] ";
            println(item);
        }
        println("Presione una tecla para volver");
        pause();
    }


    private static void Añadir_Convocatoria(){
        convocatoria Mi_object_convocatoria = new convocatoria();
        ArrayList<Runnable> My_list_functions = new ArrayList<>();
        My_list_functions.add(()->{Mi_object_convocatoria.numero = input("Numero de la convocatoria: ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Fecha_Inicio = input("Fecha de inicio de la convocatoria: ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Fecha_Fin = input("Fecha fin convocatoria: ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Vacante = input("Vacante : ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Sueldo = input("Sueldo: ");});
        
        for (Runnable elemento : My_list_functions) {elemento.run();}

        boolean ciclo = true;
        while (ciclo) {
            String input = PrintMenu("Añadir convocatoria", new String[] {
                "Correo:" + Mi_object_convocatoria.numero,
                "Contraseña: " + Mi_object_convocatoria.Fecha_Inicio,
                "Nombre: " + Mi_object_convocatoria.Fecha_Fin,
                "Teléfono: " + Mi_object_convocatoria.Vacante,
                "Nit: " + Mi_object_convocatoria.Sueldo,
                "volver",
            }, "seleccione si quiere editar algún elemento o seleccione volver:");
            int Seleccion = Integer.parseInt(input);
            
            if (Seleccion==6) {
                ciclo = false;
                break;
            }else{
                try {
                    if (Seleccion <= My_list_functions.size()) {
                        My_list_functions.get(Seleccion-1).run();
                    }
                } catch (Exception e) {}
            }
        }

        ((empresa) User_Session).convocatorias.add(Mi_object_convocatoria);

        return;
    }


    private static void Eliminar_Convocatoria(int Convocatoria_Seleccionada){
        convocatoria esta_convocatoria = ((empresa) User_Session).convocatorias.get(Convocatoria_Seleccionada);
        ((empresa) User_Session).convocatorias.remove(esta_convocatoria);
    }
    private static void Editar_Convocatoria(int Convocatoria_Seleccionada){
        convocatoria Mi_object_convocatoria = ((empresa) User_Session).convocatorias.get(Convocatoria_Seleccionada);
        ArrayList<Runnable> My_list_functions = new ArrayList<>();
        My_list_functions.add(()->{Mi_object_convocatoria.numero = input("Numero de la convocatoria: ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Fecha_Inicio = input("Fecha de inicio de la convocatoria: ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Fecha_Fin = input("Fecha fin convocatoria: ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Vacante = input("Vacante : ");});
        My_list_functions.add(()->{Mi_object_convocatoria.Sueldo = input("Sueldo: ");});
        

        boolean ciclo = true;
        while (ciclo) {
            String input = PrintMenu("editar convocatoria", new String[] {
                "Correo:" + Mi_object_convocatoria.numero,
                "Contraseña: " + Mi_object_convocatoria.Fecha_Inicio,
                "Nombre: " + Mi_object_convocatoria.Fecha_Fin,
                "Teléfono: " + Mi_object_convocatoria.Vacante,
                "Nit: " + Mi_object_convocatoria.Sueldo,
                "volver",
            }, "seleccione si quiere editar algún elemento o seleccione volver:");
            int Seleccion = Integer.parseInt(input);
            
            if (Seleccion==6) {
                ciclo = false;
                break;
            }else{
                try {
                    if (Seleccion <= My_list_functions.size()) {
                        My_list_functions.get(Seleccion-1).run();
                    }
                } catch (Exception e) {}
            }
        }

    }


    private static void Gestionar_Info_Empresa(){
        empresa Mi_object = (empresa)User_Session;
        ArrayList<Runnable> My_list_functions = new ArrayList<>();
        My_list_functions.add(()->{Mi_object.correo = input("Ingrese su correo: ");});
        My_list_functions.add(()->{Mi_object.contraseña = input("Ingrese su contraseña: ");});
        My_list_functions.add(()->{Mi_object.nombre = input("Ingrese su nombre de empresa: ");});
        My_list_functions.add(()->{Mi_object.telefono = input("Ingrese su teléfono: ");});
        My_list_functions.add(()->{Mi_object.nit = input("Ingrese su nit: ");});
        
        boolean ciclo = true;
        while (ciclo) {
            String input = PrintMenu("ver mi info de Empresa", new String[] {
                "Correo:" + Mi_object.correo,
                "Contraseña: " + Mi_object.contraseña,
                "Nombre: " + Mi_object.nombre,
                "Teléfono: " + Mi_object.telefono,
                "Nit: " + Mi_object.nit,
                "volver",
            }, "seleccione si quiere editar algún elemento o seleccione volver:");
            int Seleccion = Integer.parseInt(input);
            
            if (Seleccion==6) {
                ciclo = false;
                break;
            }else{
                try {
                    if (Seleccion <= My_list_functions.size()) {
                        My_list_functions.get(Seleccion-1).run();
                    }
                } catch (Exception e) {}
            }
        }
    }
}
