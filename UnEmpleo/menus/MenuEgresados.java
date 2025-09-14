package menus;
import java.util.ArrayList;

import AppData.Absoluto;
import objetos.convocatoria;
import objetos.egresado;
import objetos.empresa;
import objetos.usuario;
public class MenuEgresados extends Absoluto {
    public static void Inicio(){
        boolean ciclo = true;
        while (ciclo) {
            String input = PrintMenu("Menu Egresado: bienvenido " + ((egresado) User_Session).nombre, new String[]{
                "Ver convocatorias",
                "Ver información personal",
                // "Eliminar cuenta",
                "Volver",
            });
            switch (input) {
                case "1":
                    VerConvocatorias();
                    break;
                case "2":
                    VerInformaciónPersonal();
                    break;
                // case "3":
                //     EliminarCuenta();
                //     break;
                case "3":
                    ciclo = false;
                    break;
                default:
                    break;
            }
        }
        return;
    }


    private static void VerConvocatorias() {
        boolean ciclo = true;
        while (ciclo) {
            ArrayList<String> lista_convocatoria_TEXTO_Menu = new ArrayList<>();
            ArrayList<convocatoria> lista_convocatoria_OBJETO = new ArrayList<>();

            lista_convocatoria_TEXTO_Menu.add("Volver");
            for (empresa empresa : Lista_empresas) {
                for (convocatoria convocatoria : empresa.convocatorias) {
                    boolean  si_existe = false;
                    for (Object userConvocatoria : convocatoria.Usuarios_Que_Aplicaron) {
                        if (((usuario)userConvocatoria).nombre.equals(((egresado) User_Session).nombre)) {
                            si_existe = true;
                        }
                    }
                    if (si_existe==false) {
                        String item = "";
                        item += convocatoria.numero;
                        item += " " +  convocatoria.Fecha_Inicio;
                        item += " " +  convocatoria.Fecha_Fin;
                        item += " " +  convocatoria.Vacante;
                        item += " " +  convocatoria.Sueldo;
                        lista_convocatoria_TEXTO_Menu.add(item);
                        lista_convocatoria_OBJETO.add(convocatoria);
                    }
                }
            }
            
            int input = -1;
            
            try {input = Integer.parseInt(PrintMenu("Aplicar a convocatoria", lista_convocatoria_TEXTO_Menu));} catch (Exception e) {}

            if (input == 1) {
                ciclo = false;
            }else if(input <= lista_convocatoria_TEXTO_Menu.size()){
                lista_convocatoria_OBJETO.get(input-2).Usuarios_Que_Aplicaron.add(User_Session);
                clear();
                println("Usted fue añadido a este evento");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ciclo = false;
            }

        }
    }

    private static void EliminarCuenta() {
        String input = PrintMenu("Seguro desea eliminar su cuenta??", new String[]{
            "s",
            "n",
        });
        if (input=="s" || input=="1") { Lista_egresados.remove((egresado)User_Session); }
    }

    private static void VerInformaciónPersonal() {
        boolean ciclo=true;
        while (ciclo) {
            egresado Mielemento = (egresado) User_Session;
            ArrayList<Runnable> Mi_Lista_Egresados = new ArrayList<>();
            Mi_Lista_Egresados.add(()->{Mielemento.correo = input("Ingrese su correo: ");});
            Mi_Lista_Egresados.add(()->{Mielemento.contraseña = input("Ingrese su contraseña: ");});
            Mi_Lista_Egresados.add(()->{Mielemento.nombre = input("Ingrese su nombre de empresa: ");});
            Mi_Lista_Egresados.add(()->{Mielemento.programa_académico = input("Ingrese su programa académico: ");});
            Mi_Lista_Egresados.add(()->{Mielemento.documento = input("Ingrese su documento: ");});

            String input = PrintMenu("Ver info de Egresado", new String[] {
                "Correo:" + Mielemento.correo,
                "Contraseña: " + Mielemento.contraseña,
                "Nombre: " + Mielemento.nombre,
                "Programa académico: " + Mielemento.programa_académico,
                "Documento: " + Mielemento.documento,
                "Volver",
            }, "seleccione si quiere editar algún elemento o seleccione volver:");

            int Selección = Integer.parseInt(input);

            if (Selección==6) {
                ciclo = false;
                break;
            }else{
                try {
                    if (Selección <= Mi_Lista_Egresados.size()) {
                        Mi_Lista_Egresados.get(Selección-1).run();
                    }
                } catch (Exception e) {}
            }
        }

    }
}
