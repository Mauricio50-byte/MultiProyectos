package ConexionBD;
import Datos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionUsuarios {
    //creamos nuestras variables staticas
    private static final String url = "jdbc:mysql://localhost:3306/herramientas electronicasbd?useSSL=false&serverTimezone=UTC";
    private static final String Usuario = "root";
    private static final String contraseña = "";
    
    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, Usuario, contraseña);
    }
    
    public static void guardarUsuariosEnBD(ArrayList<Usuario> usuarios) throws SQLException, ClassNotFoundException {
        // Creamos una variable de tipo Connection para la conexión a la base de datos
        Connection conexion = null;

        // Creamos variables de tipo PreparedStatement para ejecutar las consultas SQL
        PreparedStatement consultaVerificacion = null;
        PreparedStatement consultaInsercion = null;

        try {
            // Cargar el controlador de MySQL y establecer la conexión
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, Usuario, contraseña);

            // Consulta para verificar si existen duplicados (documento, teléfono o correo)
            String consultaVerificarDuplicados = "SELECT COUNT(*) FROM usuarios WHERE num_cedula = ? OR num_telefono = ? OR correo = ?";
            consultaVerificacion = (PreparedStatement) conexion.prepareStatement(consultaVerificarDuplicados);

            // Consulta para insertar nuevos usuarios
            String consultaInsertarUsuario = "INSERT INTO usuarios (nombre, apellido, num_cedula, num_telefono, correo, contraseña, saldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            consultaInsercion = (PreparedStatement) conexion.prepareStatement(consultaInsertarUsuario);

            // Recorremos el ArrayList de usuarios
            for (Usuario usuario : usuarios) {
                // Configuramos los parámetros para la consulta de verificación de duplicados
                consultaVerificacion.setString(1, usuario.getNumCedula());
                consultaVerificacion.setString(2, usuario.getNumTelefono());
                consultaVerificacion.setString(3, usuario.getCorreo());

                // Ejecutamos la consulta para verificar duplicados
                ResultSet resultado = consultaVerificacion.executeQuery();
                if (resultado.next()) {
                    int contador = resultado.getInt(1);
                    if (contador > 0) {
                        // Datos duplicados encontrados, mostramos un mensaje y pasamos al siguiente Usuario
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con estos datos:\n" +
                            "Documento: " + usuario.getNumCedula() + "\n" +
                            "Teléfono: " + usuario.getNumTelefono() + "\n" +
                            "Correo: " + usuario.getCorreo());
                        continue; // Saltamos la inserción si encontramos duplicados
                    }
                }

                // Si no hay duplicados, procedemos a insertar el nuevo Usuario
                consultaInsercion.setString(1, usuario.getNombre());
                consultaInsercion.setString(2, usuario.getApellido());
                consultaInsercion.setString(3, usuario.getNumCedula());
                consultaInsercion.setString(4, usuario.getNumTelefono());
                consultaInsercion.setString(5, usuario.getCorreo());
                consultaInsercion.setString(6, usuario.getContraseña());
                consultaInsercion.setDouble(7, usuario.getSaldoUsuario());

                // Ejecutamos la consulta de inserción
                consultaInsercion.executeUpdate();
                JOptionPane.showMessageDialog(null, "El usuario " + usuario.getNombre() + " ha sido guardado en la base de datos.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerramos los recursos en el bloque finally
            if (consultaVerificacion != null) {
                consultaVerificacion.close();
            }
            if (consultaInsercion != null) {
                consultaInsercion.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public static ArrayList<Usuario> recuperarUsuariosDeBD() throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        // Usamos un ArrayList para almacenar los usuarios recuperados
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            // Cargamos el controlador de MySQL
            Class.forName("com.mysql.jdbc.Driver"); // Cambia esto si usas un controlador diferente
            // Establecemos la conexión
            conexion = (Connection) DriverManager.getConnection(url, Usuario, contraseña);

            // Consulta SQL para seleccionar todos los usuarios
            String consulta = "SELECT * FROM usuarios";
            sentencia = (PreparedStatement) conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

            // Recorremos el resultado de la consulta
            while (resultado.next()) {
                // Recuperamos los datos de cada usuario
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String numCedula = resultado.getString("num_cedula");
                String numTelefono = resultado.getString("num_telefono");
                String correo = resultado.getString("correo");
                String contrasena = resultado.getString("contraseña");
                double saldo = resultado.getDouble("saldo");

                // Creamos un nuevo objeto Usuario y lo agregamos al ArrayList
                Usuario usuario = new Usuario(nombre, apellido, 
                                            numCedula, correo, 
                                            contrasena, numTelefono, saldo);
                usuarios.add(usuario);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerramos los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }

        return usuarios; // Devolvemos la lista de usuarios
    }
    
    //Metodo para obtener el numero de usuarios guardados en la base de datos
    public static int obtenerNumeroUsuariosDesdeBD() throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        int numeroUsuarios = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, Usuario, contraseña);

            String consulta = "SELECT COUNT(*) FROM usuarios";
            sentencia = (PreparedStatement) conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

            if (resultado.next()) {
                numeroUsuarios = resultado.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Asegúrate de cerrar los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }

        return numeroUsuarios;
    }
    
    //Metodo para Obtener el ID del usuario por el Correo ya que el ID se esta generando de manera automatica en MySQL
    public static int obtenerIdUsuarioPorCorreo(String correo)  throws SQLException {
        int idUsuario = -1; // Valor predeterminado en caso de que no se encuentre el usuario

        try {
            // Obtener la conexion a la base de datos
            Connection conexion = DriverManager.getConnection(url, Usuario, contraseña);

            // Preparar la consulta SQL para obtener el ID del usuario por su correo
            String consulta = "SELECT id FROM usuarios WHERE correo = ?";

            // Crear una sentencia preparada para evitar la inyección SQL y pasar el parámetro
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, correo);

            // Ejecutar la consulta para obtener el ID del usuario
            ResultSet resultado = sentencia.executeQuery();

            // Verificar si se encontró un usuario y obtener su ID
            if (resultado.next()) {
                idUsuario = resultado.getInt("id");
            }

            // Cerrar la conexión, el statement y el resultado
            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener ID del usuario por correo: " + e.getMessage());
        }

        return idUsuario;
    }
    
     //Metodo para editar los datos del usuario desde la base de datos
    public void editarDatosEnBaseDeDatos(String correoUsuario, String nombreCampo, String nuevoValor)  throws SQLException {
        try {
             // Obtener el ID del usuario utilizando el correo electrónico
            int idUsuario = obtenerIdUsuarioPorCorreo(correoUsuario);
            
            // Verificar si se encontró el usuario en la base de datos
            if (idUsuario != -1) {
                // Obtener la conexión a la base de datos
                Connection conexion = DriverManager.getConnection(url, Usuario, contraseña);

                // Preparar la consulta SQL para actualizar el dato específico del usuario
                String consulta = "UPDATE usuarios SET " + nombreCampo + " = ? WHERE id = ?";

                // Crear una sentencia preparada para evitar la inyección SQL y pasar los parámetros
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.setString(1, nuevoValor);
                sentencia.setInt(2, idUsuario);
                
                 // Ejecutar la consulta para actualizar el dato específico
                int filasActualizadas = sentencia.executeUpdate();

                // Verificar si se actualizo correctamente y mostrar un mensaje
                if (filasActualizadas > 0) {
                    //JOptionPane.showMessageDialog(null, "Dato actualizado correctamente en la base de datos.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el dato del usuario.");
                }

                // Cerrar la conexión y las consultas Sql
                sentencia.close();
                conexion.close();
            } else {
                JOptionPane.showMessageDialog(null, "El usuario con el correo especificado no existe.");
            }

        } catch (SQLException e) {
            System.out.println("Error al editar dato en la base de datos: " + e.getMessage());
        }
    }
    
      // metodo para eliminar usurios desde la base de datos precionando el boton eliminar en la ventana miCuenta
    public static void eliminarUsuario(String correo) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            // Establece la conexión a la base de datos
            conexion = DriverManager.getConnection(url,Usuario,contraseña);

            // Prepara la sentencia SQL para eliminar el Usuario
            String consulta = "DELETE FROM usuarios WHERE correo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, correo);

            // Ejecuta la sentencia SQL
            sentencia.executeUpdate();
        } finally {
            // Cierra la conexión y la sentencia
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
}