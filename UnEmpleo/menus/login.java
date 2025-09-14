package menus;
import AppData.Absoluto;

public class login extends Absoluto{
    public static void inicio(){
        boolean ciclo = true;
        while (ciclo) {
            clear();
            println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            println("X                 Login                      X");
            println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            String Address = input("ingrese su correo:");
            String password = input("ingrese su contraseña:");
            
            // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            // Empresas
            // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


            for (int i = 0; i < Lista_empresas.size(); i++) {
                if (Lista_empresas.get(i).correo.equals(Address) && Lista_empresas.get(i).contraseña.equals(password)) {
                    Absoluto.User_Session = Lista_empresas.get(i);
                    menus.MenuEmpresas.Inicio();
                    return;
                }
            }

            for (int i = 0; i < Lista_egresados.size(); i++) {
                if (Lista_egresados.get(i).correo.equals(Address) && Lista_egresados.get(i).contraseña.equals(password)) {
                    Absoluto.User_Session = Lista_egresados.get(i);
                    menus.MenuEgresados.Inicio();
                    return;
                }
            }

            if (Absoluto.User_Session == null) {
                String input = PrintMenu("Usuario o contraseña no validos", new String[]{
                    "Volver a intentar?(s/n)",
                    "Volver",
                });
                if (!input.equals("s")) {
                    ciclo = false;
                }

            }
        }

    }
}
