package ConstructoraVentas;

import java.util.Scanner;

public class App {
    static Scanner lector = new Scanner(System.in);
    static final int elementos = 100;
    static final String fechaVenta = "10/11/2023";
    static final String peridoVenta = "2023 I";
    static Cliente[] clientes = new Cliente[elementos];
    static Cliente cliente = new Cliente();
    static Material[] materiales = new Material[elementos];
    static Material material;
    
    static Venta venta ; static Venta[] ventas = new Venta[elementos];
    static String documento, codigo;
    static int tipo_de_pago, tipo_de_documento;
    static int op, pos, opCrud, numeroDeClientes = 2, numeroDeMateriales= 1, numeroDeVentas = 0;
    public static void main(String[] args) {
        //Aqui quemamos un cliente en la pocision 1
        cliente = new Cliente();
        cliente.numeroDocumento = "1032938430";
        cliente.nombreCliente = "jose";
        cliente.apellidosCliente = "martinez";
        cliente.fechaDeNacimiento = "10/12/2009";
        cliente.direccioCliente = "ajhshh";
        cliente.ciudadCliente = "snxnsnxnx";
        cliente.barrioCliente = "nnxb";
        cliente.numeroCelular = "njjxhj";
        cliente.emailCliente = "njjnxb";
        cliente.saldoCliente = 100000;
        clientes[0] = cliente;

        //Aqui quemamos un cliente en la pocision 2
        cliente = new Cliente();
        cliente.numeroDocumento = "1051736741";
        cliente.nombreCliente = "leonel";
        cliente.apellidosCliente = "lanvias";
        cliente.fechaDeNacimiento = "09/10/2005";
        cliente.direccioCliente = "ajhshh";
        cliente.ciudadCliente = "snxnsnxnx";
        cliente.barrioCliente = "nnxb";
        cliente.numeroCelular = "njjxhj";
        cliente.emailCliente = "njjnxb";
        cliente.saldoCliente = 2000000;
        clientes[1] = cliente;

        //Aqui quemamos un material en la pocison 1
        material = new Material();
        material.codigo = "565656";
        material.nombreMaterial = "semento";
        material.precio = 10000;
        materiales[0] = material; 

        do {
            limpiarPantalla();
            menu_Principal();
            System.out.println("Digite una opcion: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    GestionClientes();
                    break;
                case 2:
                    GestionMateriales();
                    break;
                case 3:
                    Ventas();
                    break;
            
                case 4:
                    System.out.println(" ---- Salir ---- ");
                    pausa();
                    break;
                default:
                    System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                    break;
            }
        } while (op >= 1 && op < 4);
    }
    public static void GestionClientes(){
        do {
            limpiarPantalla();
            System.out.println("---- GESTION Y REGISTRO DE CLIENTES ----\n");
            pausa();
            limpiarPantalla();
            menu_crud();
            System.out.println("Digite una opcion: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    limpiarPantalla();
                    System.out.println("--- Registrar cliente ----\n");
                    limpiarPantalla();
                    if (numeroDeClientes < elementos) {
                        menu_tipoDocumento();
                        System.out.println("Digite una opcion: ");
                        tipo_de_documento = lector.nextInt();
                        switch (tipo_de_documento) {
                            case 1:
                                System.out.println("--- Tarjeta de identidad ---");
                                break;
                            case 2:
                                System.out.println("--- Cedula ---");
                                break;
                            default:
                                System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                                break;
                        }
                        System.out.println("Digite el numero de documento del cliente: ");
                        documento = lector.next();
                        pos = consultarClientes(documento);
                        if (pos != -1) {
                            System.out.println("\nYa existe un cliente registrado con este documento...!!!");
                            pausa();
                            break;
                        }
                        if (pos == -1) {
                            cliente = new Cliente();
                            cliente.numeroDocumento = documento;
                            System.out.println("Digite el nombre del cliente: ");
                            cliente.nombreCliente = lector.next();
                            System.out.println("Digite los apellidos del cliente:");
                            cliente.apellidosCliente = lector.next();
                            System.out.println("Digite la fecha de nacimiento del:");
                            cliente.fechaDeNacimiento = lector.next();
                            System.out.println("Digite un saldo para el cliente:");
                            cliente.saldoCliente = lector.nextLong();
                            System.out.println("Digite la direccion del cliente: ");
                            cliente.direccioCliente = lector.next();
                            if (pos != -1) {
                                System.out.println("\nYa existe un cliente registrado con esta direccion...!!!");
                                pausa();
                                break;
                            }
                            System.out.println("Digite la ciudad del cliente:");
                            cliente.ciudadCliente = lector.next();
                            System.out.println("Digite el barrio del cliente:");
                            cliente.barrioCliente = lector.next();
                            System.out.println("Digite el numero de celular del cliente:");
                            cliente.numeroCelular = lector.next();
                            if (pos != -1) {
                                System.out.println("\nYa existe un cliente registrado con este numero de celular...!!!");
                                pausa();
                                break;
                            }
                            System.out.println("Digite el email del cliente:");
                            cliente.emailCliente = lector.next();
                            if (pos != -1) {
                                System.out.println("\nYa existe un cliente registrado con este correo electrónico...!!!");
                                pausa();
                                break;
                            }
                            menu_tipoPago();
                            System.out.println(" Ingrse una opcion\n ");
                            tipo_de_pago = lector.nextInt();
                            switch (tipo_de_pago) {
                                case 1:
                                    System.out.println("-- Efectivo --");
                                    break;
                                case 2:
                                    System.out.println("-- Chueques --");
                                    break;
                                case 3:
                                    System.out.println("-- Tarjetas de debito --");
                                    break;
                                case 4:
                                    System.out.println("-- Tarjetas de creditos --");
                                    break;
                                case 5:
                                    System.out.println("-- Pagos moviles --");
                                    break;
                                case 6:
                                    System.out.println("-- Transferencias bancarias electronicas --");
                                    break;
                                default:
                                    System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                                    break;
                            }
                            clientes[numeroDeClientes] = cliente;
                            System.out.println("El cliente fue registrado con exito...!");
                            numeroDeClientes = numeroDeClientes + 1;
                        } else {
                            System.out.println("\nEl cliente se encuentra registrado...!!!");
                            mostraClientes(pos); 
                        }
                    } else {
                        System.out.println("El vector esta lleno, no es posible registrar otro cliente");
                    }
                    pausa();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    limpiarPantalla();
                    System.out.println("--- Modificar cliente ---\n");
                    pausa();
                    System.out.println("Digite el numero de documento del cliente:");
                    documento = lector.next();
                    pos = consultarClientes(documento);
                    if (pos == -1) {
                        System.out.println("\nEl cliente no se encuentra registrado...!!!");
                        pausa();
                    } else {
                        mostraClientes(pos);
                        System.out.println("\nQue campo del cliente deseas actualizar?");
                        System.out.println("1. Nombre.");
                        System.out.println("2. Apellidos.");
                        System.out.println("3. Fecha de nacimiento.");
                        System.out.println("4. Direccion.");
                        System.out.println("5. Ciudad.");
                        System.out.println("6. Barrio.");
                        System.out.println("7. Numero de celular.");
                        System.out.println("8. Email.");
                        System.out.println("9. Saldo.");
                        System.out.println("Digite una opcion:");
                        opCrud = lector.nextInt();  
                        switch (opCrud) {
                            case 1:
                                System.out. println("Digite el nombre a modificar:");
                                clientes[pos].nombreCliente = lector.next();
                                break;
                            case 2:
                                System.out.println("Digite el nuevo apellido:");
                                clientes[pos] .apellidosCliente = lector.next();
                                break;
                            case 3:
                                System.out. println("Digite la nueva fecha de nacimiento ");
                                clientes[pos].fechaDeNacimiento = lector.next();
                                break;
                            case 4:
                                System.out. println( "Digite la nueva direccion :");
                                clientes[pos].direccioCliente = lector.next();
                                if (pos != -1) {
                                    System.out.println("\nYa existe un cliente registrado con esta direccion...!!!");
                                    pausa();
                                    break;
                                }
                                break;
                            case 5:
                                System.out.println("Digite la nueva ciudad :");
                                clientes[pos].ciudadCliente = lector.next();
                                break;
                            case 6:
                                System.out.println("Digite el nuevo barrio :");
                                clientes[pos].barrioCliente = lector.next();
                                break;
                            case 7:
                                System.out.println("Digite el  nuevo numero de celular :");
                                clientes[pos].numeroCelular = lector.next();
                                if (pos != -1) {
                                    System.out.println("\nYa existe un cliente registrado con este numweo de celular...!!!");
                                    pausa();
                                    break;
                                }
                                break;
                            case 8:
                                System.out.println("Digite el nuevo email :");
                                clientes[pos].emailCliente = lector.next();
                                if (pos != -1) {
                                    System.out.println("\nYa existe un cliente registrado con este correo electrónico...!!!");
                                    pausa();
                                    break;
                                }
                                break;
                            case 9:
                                System.out.println("Digite el nuevo saldo:");
                                clientes[pos].saldoCliente = lector.nextLong();
                                break;
                            default:
                                System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                                break;
                        }   
                        System.out.println("Los datos fueron actualizados correctamente...!!");
                        mostraClientes(pos);
                        pausa();             
                    }
                    break;
                case 4:
                    limpiarPantalla();
                    System.out.println("--- Eliminar cliente ---\n");
                    limpiarPantalla();
                    System.out.println("Digite el numero de documento del cliente:");
                    documento = lector.next();
                    pos = consultarClientes(documento);
                    if (pos == -1) {
                        System.out.println("El cliente no se encuentra registrado.....");
                    } else {
                        mostraClientes(pos);
                        System.out.println("Estas seguro que deseas eliminar al cliente. si(1) no(2)\n");
                        System.out.println("Digite una opcion:");
                        opCrud = lector.nextInt();
                        if (opCrud == 1) {
                            for(int i = 0; i <= numeroDeClientes-1; i++){
                                clientes[i] = clientes[i+1];
                            }
                            numeroDeClientes = numeroDeClientes - 1;
                            System.out.println("El registro fue eliminado correctamente...!!");
                        }  
                    }
                    pausa();
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("--- Salir ----");
                    pausa();
                    limpiarPantalla();
                    System.out.println("Deseas salir de gestion de clientes. si(1) no(2)\n");
                    System.out.println("Digite una opcion:");
                    op = lector.nextInt();
                    pausa();
                    limpiarPantalla();
                    menu_Principal();
                    System.out.println("Digite una opcion:");
                    op = lector.nextInt();
                    GestionMateriales();
                    break;
                default:
                    System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                    break;
            }
        } while (op != 4);
    }
    public static void mostraClientes(int posicionCliente){
        System.out.println("\n*************************************************************");
        System.out.println("                    INFORMACION DEL CLIENTE                    ");
        System.out.println("****************************************************************");
        System.out.println("Numero documento del cliente : " + clientes[posicionCliente].numeroDocumento);
        System.out.println("Nombre del cliente: " + clientes[posicionCliente].nombreCliente);
        System.out.println("Apellidos del Cliente: " + clientes[posicionCliente].apellidosCliente);
        System.out.println("Fecha de nacimiento del cliente: " + clientes[posicionCliente].fechaDeNacimiento);
        System.out.println("Saldo del cliente: " + clientes[posicionCliente].saldoCliente);
        System.out.println("Direccion del cliente: " + clientes[posicionCliente].direccioCliente);
        System.out.println("Ciudad cliente: " + clientes[posicionCliente].ciudadCliente);
        System.out.println("Barrio del cliente: " + clientes[posicionCliente].barrioCliente);
        System.out.println("Numero de celular del cliete: " + clientes[posicionCliente].numeroCelular);
        System.out.println("Email del cliente: " + clientes[posicionCliente].emailCliente);
    }
    public static int consultarClientes(String documento){
        int posicion = -1;
        for(int i = 0; i < numeroDeClientes; i++){
            if (clientes[i].numeroDocumento.equals(documento)) {
                posicion = i;
            }
        }
        return posicion;
    }
    public static void listarClientes(){
        System.out.println("*****************************************************************************************************");
        System.out.println("                                    LISTADO DE CLIENTES                                      ");
        System.out.println("******************************************************************************************************");
        System.out.println("Documentos              Nombres         Apellidos       Fecha de nacimiento            Saldo ");
        System.out.println("******************************************************************************************************");
        for(int i = 0; i < numeroDeClientes; i++){
            System.out.println(clientes[i].numeroDocumento + "\t\t" + clientes[i].nombreCliente + "\t\t" +
            clientes[i].apellidosCliente + "\t\t" + clientes[i].fechaDeNacimiento + "\t\t" + clientes[i].saldoCliente);
        }
        System.out.println("**********************************************************************************************************************");
        System.out.println("Direccion               Ciudad                  Barrio                       Numero de celular              Gmail");
        System.out.println("**********************************************************************************************************************");
        for(int i = 0; i < numeroDeClientes; i++){
            System.out.println(clientes[i].direccioCliente + "\t\t" + clientes[i].ciudadCliente + "\t\t" + clientes[i].barrioCliente + "\t\t"+"\t\t" + clientes[i].numeroCelular + "\t\t" + clientes[i].emailCliente);
        }
        pausa();
    }
    public static void GestionMateriales(){
        do {
            limpiarPantalla();
            System.out.println("---- GESTION Y REGISTRO DE MATERIALES ----\n");
            pausa();
            limpiarPantalla();
            menu_crud();
            System.out.println("Digite una opcion: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    limpiarPantalla();
                    System.out.println("--- Registrar material ----\n");
                    pausa();
                    limpiarPantalla();
                    if (numeroDeMateriales < elementos) {
                        System.out.println("Digite el codigo del material:");
                        codigo = lector.next();
                        pos = ConsultarMateriales(codigo);
                        if (pos == -1) {
                            material = new Material();
                            material.codigo = codigo;
                            System.out.println("Digite el nombre del material:");
                            material.nombreMaterial = lector.next();
                            System.out.println("Digite el precio del material:");
                            material.precio = lector.nextLong();
                            materiales[numeroDeMateriales] = material;
                            System.out.println("El material fue registrado con exito..");
                            numeroDeMateriales = numeroDeMateriales + 1;
                            pausa();
                        } else {
                            System.out.println("\nEl material se encuentra registrado...!!!");
                            MostrarMateriales(pos);
                            pausa();
                        }
                    }else{
                        System.out.println("El vector esta lleno, no es posible registrar otro material");
                        pausa();
                    }
                    break;
                case 2:
                    ListarMateriales();
                    break;
                case 3:
                    limpiarPantalla();
                    System.out.println("--- Modificar material ---\n");
                    pausa();
                    System.out.println("Digite el codigo del material: ");
                    codigo = lector.next();
                    pos = ConsultarMateriales(codigo);
                    if (pos == -1) {
                        System.out.println("\nEl material no se encuentra registrado...!!!");
                        pausa();
                    } else {
                        MostrarMateriales(pos);
                        System.out.println("\nQue campo deseas actualizar ");
                        System.out.println("1. Nombre.");
                        System.out.println("2. Codigo.");
                        System.out.println("3. Precio.");
                        System.out.println("Digite una opcion:");
                        opCrud = lector.nextInt();
                        switch (opCrud) {
                            case 1:
                                System.out.println("Digite el nombre a modificar:");
                                materiales[pos].nombreMaterial = lector.next();
                                break;
                            case 2:
                                System.out.println("Digite el codigo a modificar:");
                                materiales[pos].codigo = lector.next();
                                break;
                            case 3:
                                System.out.println("Digite el precio a modificar:");
                                materiales[pos].precio = lector.nextLong();
                                break;
                            default:
                                System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                                break;
                        }
                        System.out.println("Los datos fueron actualizados correctamente...!!");
                        MostrarMateriales(pos);
                        pausa();          
                    }
                    break;
                case 4:
                    limpiarPantalla();
                    System.out.println("--- Eliminar material ---\n");
                    limpiarPantalla();
                    System.out.println("Digite el codigo del material:");
                    codigo = lector.next();
                    pos = ConsultarMateriales(codigo);
                    if (pos == 1) {
                        System.out.println("El material no se encuentra registrado.....");
                        pausa();
                    } else {
                        MostrarMateriales(pos);
                        System.out.println("Estas seguro que deseas eliminar el material. si(1) no(2)");
                        System.out.println("Digite una opcion:");
                        opCrud = lector.nextInt();
                        if (opCrud == 1) {
                            for (int i = pos; i < numeroDeMateriales - 1; i++) {
                                materiales[i] = materiales[i + 1];
                            }
                            numeroDeMateriales = numeroDeMateriales - 1;
                            System.out.println("El registro fue eliminado correctamente...!!");
                            pausa();
                        }
                    }
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("--- Salir ----");
                    pausa();
                    limpiarPantalla();
                    System.out.println("Deseas salir de gestion de materiales. si(1) no(2)\n");
                    System.out.println("Digite una opcion:");
                    op = lector.nextInt();
                    pausa();
                    limpiarPantalla();
                    menu_Principal();
                    System.out.println("Digite una opcion:");
                    op = lector.nextInt();
                    Ventas();
                    break;
                default:
                    System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                    break;   
            }
        } while (opCrud != 4);
    }
    public static void MostrarMateriales(int posicionMaterial){
        System.out.println("\n*************************************************************");
        System.out.println("                    INFORMACION DE MATERIALES                    ");
        System.out.println("***************************************************************");
        System.out.println("Nombre material: " + materiales[posicionMaterial].nombreMaterial);
        System.out.println("Codigo material: " + materiales[posicionMaterial].codigo);
        System.out.println("Precio material: " + materiales[posicionMaterial].precio);
    }

    public static int ConsultarMateriales(String codigo) {
        int posicion = -1;
        for (int i = 0; i < numeroDeMateriales; i++) {
            if (materiales[i] != null && materiales[i].codigo.equals(codigo)) {
                posicion = i;
                break; // Salimos del bucle una vez que se encuentre una coincidencia
            }
        }
        return posicion;
    }

    public static void ListarMateriales(){
        System.out.println("*******************************************************");
        System.out.println("                      LISTADO DE PRODUCTOS                         ");
        System.out.println("*******************************************************");
        System.out.println("Nombre material           codigo            precio     ");
        System.out.println("*******************************************************");
        for(int i = 0; i < numeroDeMateriales; i++){
            if (materiales[i] != null) {
                System.out.println(materiales[i].nombreMaterial + "\t\t" + "\t\t" + materiales[i].codigo + "\t\t"  + materiales[i].precio );
            }
        } 
        pausa();
    }

    
    public static Material[] eliminarMateriales(Material[] materiales, int pos) {
        Material[] nuevosMateriales = new Material[materiales.length - 1];
        for (int i = 0, j = 0; i < materiales.length; i++) {
            if (i != pos) {
                nuevosMateriales[j] = materiales[i];
                j++;
            }
        }
        return nuevosMateriales;
    }
    public static void Ventas() {
        int opcionVenta; // Variable para controlar la venta de materiales
    
        do {
            limpiarPantalla();
            System.out.println("---- GESTION DE VENTAS ----\n");
            pausa();
            limpiarPantalla();
            menu_crud_Ventas();
            System.out.println("Digite una opcion:");
            opCrud = lector.nextInt();
    
            switch (opCrud) {
                case 1:
                    limpiarPantalla();
                    System.out.println("--- VENDER MATERIALES ----\n");
                    pausa();
                    limpiarPantalla();
                    if (numeroDeVentas < elementos) {
                        System.out.println("Digite el número de documento del cliente:");
                        documento = lector.next();
                        pos = consultarClientes(documento);
                        if (pos == -1) {
                            System.out.println("El cliente no se encuentra registrado.");
                            pausa();
                        } else {
                            Cliente cliente = clientes[pos];
    
                            int id = numeroDeVentas + 1; // Asignar un nuevo ID de venta
    
                            Venta venta = new Venta(id, fechaVenta, peridoVenta, documento);
    
                            do {
                                ListarMateriales();
                                System.out.println("Digite el código del material a vender:");
                                codigo = lector.next();
                                pos = ConsultarMateriales(codigo);
    
                                if (pos == -1) {
                                    System.out.println("El material no se encuentra registrado.");
                                } else {

                                    Material productoVendido = materiales[pos];
                                    long saldo = cliente.saldoCliente;
                                    long precio = material.precio;
                                    if (saldo >= precio) {
                                        venta.agregarMaterial(productoVendido); // Agregar el material a la venta
                                        cliente.saldoCliente -= productoVendido.precio; // Restamos el precio del material al saldo del cliente
                                        System.out.println("Producto vendido: " + productoVendido.nombreMaterial);
                                        System.out.println(cliente.nombreCliente + ", tu saldo actual es: " + cliente.saldoCliente);
                                        materiales = eliminarMateriales(materiales, pos); // Eliminar el material vendido
                                        //aplicamos el descuento por las 5 compras del cliente
                                        venta.aplicarDescuento();
                                    } else {
                                        System.out.println("Saldo insuficiente para comprar este material.");
                                    }
                                }
    
                                System.out.println("¿Desea vender otro material? Si(1) No(2)");
                                opcionVenta = lector.nextInt();
                            } while (opcionVenta == 1);
    
                            ventas[numeroDeVentas] = venta;
                            numeroDeVentas++;
                            System.out.println("La venta fue registrada con éxito.");
                            pausa();
                        }
                    } else {
                        System.out.println("El vector de ventas está lleno, no es posible registrar otra venta.");
                        pausa();
                    }
                    break;
    
                case 2:
                    listarVentas();
                    break;
                case 3:
                    limpiarPantalla();
                    System.out.println("--- Salir ----");
                    pausa();
                    limpiarPantalla();
                    System.out.println("Deseas salir de gestion de materiales. si(1) no(2)\n");
                    System.out.println("Digite una opcion:");
                    op = lector.nextInt();
                    pausa();
                    limpiarPantalla();
                    menu_Principal();
                    System.out.println("Digite una opcion:");
                    op = lector.nextInt();
                    Ventas();
                    break;
                default:
                    System.out.println("Opcion invalida. por fabor, intente nuevamente.");
                    break;
            }
        } while (opCrud != 5);
    }
    public static void listarVentas() {
        System.out.println("*****************************************************************************************");
        System.out.println("                            LISTADO DE VENTAS REALIZADAS                               ");
        System.out.println("*****************************************************************************************");
        System.out.println("ID   Fecha de Venta   Periodo de Venta   Documento del Cliente");
        System.out.println("*****************************************************************************************");
    
        for (int i = 0; i < numeroDeVentas; i++) {
            Venta venta = ventas[i];
            if (venta != null) {
                System.out.println(venta.getId() + "\t" + venta.getFechaVenta() + "\t" + venta.getPeriodoVenta() + "\t\t" + venta.getDocumentoCliente());
                System.out.println("Material vendidos:");
                for (Material material : venta.getMaterialesVendido()) {
                    System.out.println("- " + material.nombreMaterial);
                }
                System.out.println("*************************************************************************************");
            }
        }
        pausa();
    }
    public static void menu_Principal() {
        System.out.println("|--------------------------------------------------------------------------------------------------|"); 
        System.out.println("|..................... BIENVENIDO AL NUEVO SOFWARE DE CONSTRU-MATERIALES ..........................|");
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.println("|.......................... TE DAMOS NUESTROS MAS CORDIALES SALUDOS ...............................|");
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.println("|                  ESTE ES UN SOFWARE QUE TE VA A YUDAR A TENER UN MEJOR MANEJO                    |");
        System.out.println("|      DE REGISTROS Y CONTROLES DE VENTAS EN TU CONSTRUCTURA  DE ARTICULOS PARA CONSTRUCCION       |");
        System.out.println("|__________________________________________________________________________________________________|\n");
        System.out.println("1. Gestion de clientes.");
        System.out.println("2. Gestion de materiales.");
        System.out.println("3. Gestion de ventas.");
        System.out.println("4. salir.\n");
    }
    private static void menu_crud() {
        System.out.println("----- COMTROL DE DATOS -----\n");
        System.out.println("1. Registrar.");
        System.out.println("2. Listar.");
        System.out.println("3. Modificar.");
        System.out.println("4. Eliminar.");
        System.out.println("5. Salir.\n");
    }
    private static void menu_crud_Ventas() {
        System.out.println("----- COMTROL DE VENTAS -----\n");
        System.out.println("1. Vender materiales.");
        System.out.println("2. Listar ventas.");
        System.out.println("3. Salir.\n");
    }
    private static void menu_tipoDocumento() {
        
        System.out.println("---- Cual es el tipo de documento del cliente ----\n");

        System.out.println("1. tarjeta de identidad.");

        System.out.println("2. cedula.");
    }
    private static void menu_tipoPago() {

        System.out.println("---- Cual es el tipo de pago del cliente ----\n");

        System.out.println("1. Efectivo.");

        System.out.println("2. Cheques. ");

        System.out.println("3. Tarjeta de debito.");

        System.out.println("4. Tarjeta de creditos.");

        System.out.println("5. Pagos moviles");

        System.out.println("6. Transferencias bancarias electronicas.\n");

    }
    public static void pausa() {

        try {

            System.out.println("\nPulse enter para continuar...");
            System.in.read();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void limpiarPantalla(){

        try{

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();

        }catch(Exception e){

            System.out.println(e);

        }

    }

}

