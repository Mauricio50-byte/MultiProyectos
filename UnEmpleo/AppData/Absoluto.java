package AppData;
import java.util.ArrayList;
import java.util.Scanner;

import objetos.egresado;
import objetos.empresa;

public class Absoluto {
    //XXXXXXXXXXXXXXXXXXXX Empresa XXXXXXXXXXXXXXXXXXXX
    public static ArrayList <empresa> Lista_empresas = new ArrayList<>(); //la convocatoria es una propiedad de la empresa
    // Otros elementos
    public static empresa Empresa_Satita_Element;
    public static ArrayList<Runnable> Lista_Editar_Empresas = new ArrayList<>();
    

    
    // XXXXXXXXXXXXXXXXXXXX Egresado XXXXXXXXXXXXXXXXXXXX
    public static ArrayList <egresado> Lista_egresados = new ArrayList<>();
    // Otros elementos
    public static ArrayList<Runnable> Lista_Editar_Egresados = new ArrayList<>();
    public static egresado Egresado_Statica_Element;
    

    // XXXXXXXXXXXXXXXXXXXX programa XXXXXXXXXXXXXXXXXXXX
    // Session del usuario
    public static Object User_Session = null; // guarda el suaurio que se va a logear






















    // ------------------------------------ TOOLS --------------------------------
    public static void println(Object texto){System.out.println(texto);}
    public static void print(Object texto){System.out.print(texto);}
    // ----------------------------------------------------------------
    public static String input(){return input("");}
    public static String input(String texto){
        Scanner retorno = new Scanner(System.in);
        print(texto);
        String resultado = retorno.next();
        return resultado;
    }

    public static void clear(){
        try{
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static String PrintMenu(String titulo, ArrayList<String> Array_opciones){
        // Convirtiendo arraylist a array vectorial
        String[] Array_to_String = new String[Array_opciones.size()];
        
        for (int i = 0; i < Array_opciones.size(); i++) {
            Array_to_String[i] = Array_opciones.get(i); 
        }
        
        return PrintMenu(titulo, Array_to_String, "Selecciones una opción: ");
    }


    public static String PrintMenu(String titulo, ArrayList<String> Array_opciones, String mensageInput){
        // Convirtiendo arraylist a array vectorial
        String[] Array_to_String = new String[Array_opciones.size()];
        
        for (int i = 0; i < Array_opciones.size(); i++) {
            Array_to_String[i] = Array_opciones.get(i); 
        }

        return PrintMenu(titulo, (String[]) Array_to_String, "Selecciones una opción: ");
    }

    public static String PrintMenu(String titulo, String[] Array_opciones){
        return PrintMenu(titulo, Array_opciones, "Selecciones una opción: ");
    }
    public static String PrintMenu(String titulo, String[] Array_opciones, String mensageInput){
        clear();
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        println(titulo);
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        for (int i = 0; i < Array_opciones.length; i++) {
            String elemento_En_El_Momento = Array_opciones[i];
            println(String.valueOf(i+1) + ")" + elemento_En_El_Momento);
            //  "1 ) opcion 1"
        }
        println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        return input(mensageInput);
    }


    public static void pause() {
        try{System.in.read();}catch(Exception e){}
    }

}





        // String.valueOf Convertir un elemento o variable a un tipo string
        // numero 10 integer =>() => "10" string
        // true booleano  =>() => "true" string


        // for (String elemento_En_El_Momento : Array_opciones) {
        //     print(elemento_En_El_Momento);
        // }