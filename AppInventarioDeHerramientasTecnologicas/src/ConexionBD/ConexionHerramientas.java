package ConexionBD;

import Datos.Herramienta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionHerramientas {
    private static final String url = "jdbc:mysql://localhost:3306/herramientas electronicasbd?useSSL=false&serverTimezone=UTC";
    private static final String Usuario = "root";
    private static final String contraseña = "";

    public static void guardarHerramientasEnBD(ArrayList<Herramienta> herramientas) throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        PreparedStatement consultaVerificacion = null;
        PreparedStatement consultaInsercion = null;

        try {
            // Cargar el controlador de MySQL y establecer la conexión
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, Usuario, contraseña);

            // Consulta para verificar si existen duplicados (código)
            String consultaVerificarDuplicados = "SELECT COUNT(*) FROM herramientas WHERE codigo = ?";
            consultaVerificacion = (PreparedStatement) conexion.prepareStatement(consultaVerificarDuplicados);

            // Consulta para insertar nuevas herramientas
            String consultaInsertarHerramienta = "INSERT INTO herramientas (codigo, nombre, precio, cantidad) VALUES (?, ?, ?, ?)";
            consultaInsercion = (PreparedStatement) conexion.prepareStatement(consultaInsertarHerramienta);

            // Recorremos el ArrayList de herramientas
            for (Herramienta herramienta : herramientas) {
                // Configuramos los parámetros para la consulta de verificación de duplicados
                consultaVerificacion.setDouble(1, herramienta.getCodigo());

                // Ejecutamos la consulta para verificar duplicados
                ResultSet resultado = consultaVerificacion.executeQuery();
                if (resultado.next()) {
                    int contador = resultado.getInt(1);
                    if (contador > 0) {
                        // Código duplicado encontrado, mostramos un mensaje y pasamos a la siguiente Herramienta
                        JOptionPane.showMessageDialog(null, "Ya existe una herramienta registrada con este código: " + herramienta.getCodigo());
                        continue; // Saltamos la inserción si encontramos duplicados
                    }
                }

                // Si no hay duplicados, procedemos a insertar la nueva Herramienta
                consultaInsercion.setDouble(1, herramienta.getCodigo());
                consultaInsercion.setString(2, herramienta.getNombre());
                consultaInsercion.setDouble(3, herramienta.getPrecio());
                consultaInsercion.setInt(4, herramienta.getCantidad());

                // Ejecutamos la consulta de inserción
                consultaInsercion.executeUpdate();
                JOptionPane.showMessageDialog(null, "La herramienta " + herramienta.getNombre() + " ha sido guardada en la base de datos.");
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
    
    public static ArrayList<Herramienta> recuperarHerramientasDeBD() throws SQLException {
        ArrayList<Herramienta> herramientas = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            // Conectar a la base de datos
            conexion = DriverManager.getConnection(url, Usuario, contraseña);

            // Preparar la consulta para recuperar todas las herramientas
            String consultaSQL = "SELECT codigo, nombre, precio, cantidad FROM herramientas";
            consulta = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Recorrer los resultados y agregar las herramientas al ArrayList
            while (resultado.next()) {
                double codigo = resultado.getDouble("codigo");
                String nombre = resultado.getString("nombre");
                double precio = resultado.getDouble("precio");
                int cantidad = resultado.getInt("cantidad");

                // Crear un nuevo objeto Herramienta y añadirlo a la lista
                herramientas.add(new Herramienta(codigo, nombre, precio, cantidad));
            }

        } catch (SQLException e) {
            System.out.println("Error al recuperar herramientas de la base de datos: " + e.getMessage());
            throw e;
        } finally {
            // Cerrar la conexión, la consulta y el resultado
            if (resultado != null) resultado.close();
            if (consulta != null) consulta.close();
            if (conexion != null) conexion.close();
        }

        return herramientas;
    }

    
    //Método para obtener el ID de la herramienta por el código ya que el ID se puede estar generando de manera automática en MySQL
    public static int obtenerIdHerramientaPorCodigo(double codigo) throws SQLException {
        int idHerramienta = -1; // Valor predeterminado en caso de que no se encuentre la herramienta
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            // Obtener la conexión a la base de datos
            conexion = DriverManager.getConnection(url, Usuario, contraseña);

            // Preparar la consulta SQL para obtener el ID de la herramienta por su código
            String consulta = "SELECT id FROM herramientas WHERE codigo = ?";

            // Crear una sentencia preparada para evitar la inyección SQL y pasar el parámetro
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setDouble(1, codigo);

            // Ejecutar la consulta para obtener el ID de la herramienta
            resultado = sentencia.executeQuery();

            // Verificar si se encontró una herramienta y obtener su ID
            if (resultado.next()) {
                idHerramienta = resultado.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID de la herramienta por código: " + e.getMessage());
            throw e;
        } finally {
            // Cerrar la conexión, el statement y el resultado
            if (resultado != null) resultado.close();
            if (sentencia != null) sentencia.close();
            if (conexion != null) conexion.close();
        }

        return idHerramienta;
    }
    
    //Método para editar los datos de la herramienta en la base de datos
    public static void editarDatosHerramienta(double codigo, String nombreCampo, String nuevoValor) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            // Obtener el ID de la herramienta utilizando el código
            int idHerramienta = obtenerIdHerramientaPorCodigo(codigo);
            
            // Verificar si se encontró la herramienta en la base de datos
            if (idHerramienta != -1) {
                // Obtener la conexión a la base de datos
                conexion = DriverManager.getConnection(url, Usuario, contraseña);

                // Preparar la consulta SQL para actualizar el dato específico de la herramienta
                String consulta = "UPDATE herramientas SET " + nombreCampo + " = ? WHERE id = ?";

                // Crear una sentencia preparada para evitar la inyección SQL y pasar los parámetros
                sentencia = conexion.prepareStatement(consulta);
                sentencia.setString(1, nuevoValor);
                sentencia.setInt(2, idHerramienta);
                
                // Ejecutar la consulta para actualizar el dato específico
                int filasActualizadas = sentencia.executeUpdate();

                // Verificar si se actualizó correctamente y mostrar un mensaje
                if (filasActualizadas <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el dato de la herramienta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La herramienta con el código especificado no existe.");
            }

        } catch (SQLException e) {
            System.out.println("Error al editar dato en la base de datos: " + e.getMessage());
            throw e;
        } finally {
            // Cerrar la conexión y la sentencia
            if (sentencia != null) sentencia.close();
            if (conexion != null) conexion.close();
        }
    }
    
    // Método para eliminar herramientas desde la base de datos
    public static void eliminarHerramienta(double codigo) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            // Establece la conexión a la base de datos
            conexion = DriverManager.getConnection(url, Usuario, contraseña);

            // Prepara la sentencia SQL para eliminar la herramienta
            String consulta = "DELETE FROM herramientas WHERE codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setDouble(1, codigo);

            // Ejecuta la sentencia SQL y verifica si se eliminó correctamente
            int filasEliminadas = sentencia.executeUpdate();
            
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Herramienta eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la herramienta con el código especificado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar la herramienta: " + e.getMessage());
            throw e;
        } finally {
            // Cierra la conexión y la sentencia
            if (sentencia != null) sentencia.close();
            if (conexion != null) conexion.close();
        }
    }

}