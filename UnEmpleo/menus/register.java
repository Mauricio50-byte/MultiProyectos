package menus;
import java.sql.Array;
import java.util.ArrayList;

import AppData.Absoluto;
import objetos.egresado;
import objetos.empresa;
public class register extends Absoluto{
    public static void Inicio(){
        String input = PrintMenu("Registro", new String[]{
            "Registrarse como Empresa",
            "Registrarse como Egresado",
            "Volver",
        });
        switch (input) {
            case "1":
                MenuRegistroEmpresa();
                break;
            case "2":
                MenuRegistroEgresado(); 
            break;
            default:
                break;
        }
    }


    //             ()->{} Lamnda
    // static void (){} Normal

    private static void MenuRegistroEmpresa() {
        clear();
        
        Empresa_Satita_Element = new empresa();
        Lista_Editar_Empresas.add(()->{Empresa_Satita_Element.correo = input("Ingrese su correo: ");});
        Lista_Editar_Empresas.add(()->{Empresa_Satita_Element.contraseña = input("Ingrese su contraseña: ");});
        Lista_Editar_Empresas.add(()->{Empresa_Satita_Element.nombre = input("Ingrese su nombre de empresa: ");});
        Lista_Editar_Empresas.add(()->{Empresa_Satita_Element.telefono = input("Ingrese su teléfono: ");});
        Lista_Editar_Empresas.add(()->{Empresa_Satita_Element.nit = input("Ingrese su nit: ");});
        
        for (Runnable Elemento : Lista_Editar_Empresas) {
            Elemento.run();
        }

        boolean ciclo = true;
        while (ciclo) {
            clear();
            println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            println("X     Proceso de registro Empresa    X");
            println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            String input = PrintMenu("Tus opciones de registro de empresa", new String[] {
                "Correo:" + Empresa_Satita_Element.correo,
                "Contraseña: " + Empresa_Satita_Element.contraseña,
                "Nombre: " + Empresa_Satita_Element.nombre,
                "Teléfono: " + Empresa_Satita_Element.telefono,
                "Nit: " + Empresa_Satita_Element.nit,
                "Guardar",
            }, "seleccione si quiere editar algún elemento o seleccione guardar:");
            int Seleccion = Integer.parseInt(input);
            
            if (Seleccion==6) {
                ciclo = false;
                break;
            }else{
                try {
                    if (Seleccion <= Lista_Editar_Empresas.size()) {
                        Lista_Editar_Empresas.get(Seleccion-1).run();
                    }
                } catch (Exception e) {}
            }
        }

        // Añadiendo al usuario
        Lista_empresas.add(Empresa_Satita_Element);

    }
    
    
    
    private static void MenuRegistroEgresado(){
        clear();
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        println("X     Proceso de registro Egresado    X");
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        Egresado_Statica_Element = new egresado();
        Lista_Editar_Egresados = new ArrayList<>();
        Lista_Editar_Egresados.add(()->{Egresado_Statica_Element.correo = input("Ingrese su correo: ");});
        Lista_Editar_Egresados.add(()->{Egresado_Statica_Element.contraseña = input("Ingrese su contraseña: ");});
        Lista_Editar_Egresados.add(()->{Egresado_Statica_Element.nombre = input("Ingrese su nombre: ");});
        Lista_Editar_Egresados.add(()->{Egresado_Statica_Element.programa_académico = input("Ingrese su programa académico: ");});
        Lista_Editar_Egresados.add(()->{Egresado_Statica_Element.documento = input("Ingrese su documento: ");});
        
        for (Runnable Elemento : Lista_Editar_Egresados) {
            Elemento.run();
        }

        boolean ciclo = true;
        while (ciclo) {
            clear();
            String input = PrintMenu("Tus opciones de registro de egresado", new String[] {
                "Correo:" + Egresado_Statica_Element.correo,
                "Contraseña: " + Egresado_Statica_Element.contraseña,
                "Nombre: " + Egresado_Statica_Element.nombre,
                "Programa académico: " + Egresado_Statica_Element.programa_académico,
                "Documento: " + Egresado_Statica_Element.documento,
                "Guardar",
            }, "seleccione si quiere editar algún elemento o seleccione guardar:");
            int Selección = Integer.parseInt(input);
            
            if (Selección==6) {
                ciclo = false;
                break;
            }else{
                try {
                    if (Selección <= Lista_Editar_Egresados.size()) {
                        Lista_Editar_Egresados.get(Selección-1).run();
                    }
                } catch (Exception e) {}
            }
        }

        Lista_egresados.add(Egresado_Statica_Element);
    }
}
