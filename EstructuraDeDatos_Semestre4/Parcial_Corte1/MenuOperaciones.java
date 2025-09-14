package Parcial_Corte1;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class MenuOperaciones extends JFrame implements ActionListener {  
    private Metodos operacionesVector;  
    private JTextArea areaSalida;  
    private JTextField campoEntrada;  
    private JComboBox<String> selectorOperacion;  

    public MenuOperaciones() {  
        setTitle("Operaciones sobre Vectores");  
        setSize(400, 400);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(new FlowLayout());  

        JLabel etiqueta = new JLabel("Ingrese el tamaño del vector:");  
        add(etiqueta);  

        campoEntrada = new JTextField(10);  
        add(campoEntrada);  

        JButton botonCrear = new JButton("Crear Vector");  
        botonCrear.addActionListener(e -> crearVector());  
        add(botonCrear);  

        selectorOperacion = new JComboBox<>(new String[]{  
                "Insertar al Inicio", "Insertar al Final", "Insertar en Posicion",  
                "Eliminar al Inicio", "Eliminar al Final", "Eliminar en Posicion",  
                "Ordenar por Seleccion", "Ordenar por Burbuja", "Ordenar por Insercion",  
                "Buscar Secuencial", "Buscar Binaria"  
        });  
        add(selectorOperacion);  

        JButton botonEjecutar = new JButton("Ejecutar");  
        botonEjecutar.addActionListener(this);  
        add(botonEjecutar);  

        areaSalida = new JTextArea(10, 30);  
        areaSalida.setEditable(false);  
        add(new JScrollPane(areaSalida));  

        setVisible(true);  
    }  

    private void crearVector() {  
        int tamaño = Integer.parseInt(campoEntrada.getText());  
        operacionesVector = new Metodos(tamaño);  
        areaSalida.setText("Vector creado con tamaño: " + tamaño);  
    }  

    @Override  
    public void actionPerformed(ActionEvent e) {  
        if (operacionesVector == null) {  
            areaSalida.setText("Por favor, crea un vector primero.");  
            return;  
        }  

        String operacion = (String) selectorOperacion.getSelectedItem();  
        String entrada = JOptionPane.showInputDialog("Ingrese valor :");  

        switch (operacion) {  
            case "Insertar al Inicio":  
                operacionesVector.insertarAlInicio(Integer.parseInt(entrada));  
                break;  
            case "Insertar al Final":  
                operacionesVector.insertarAlFinal(Integer.parseInt(entrada));  
                break;  
            case "Insertar en Posicion":  
                int posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese posicion:"));  
                operacionesVector.insertarEnPosicion(Integer.parseInt(entrada), posicion);  
                break;  
            case "Eliminar al Inicio":  
                operacionesVector.eliminarAlInicio();  
                break;  
            case "Eliminar al Final":  
                operacionesVector.eliminarAlFinal();  
                break;  
            case "Eliminar en Posicion":  
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese posicion:"));  
                operacionesVector.eliminarEnPosicion(posicion);  
                break;  
            case "Ordenar por Seleccion":  
                operacionesVector.ordenarSeleccion();  
                break;  
            case "Ordenar por Burbuja":  
                operacionesVector.ordenarBurbuja();  
                break;  
            case "Ordenar por Insercion":  
                operacionesVector.ordenarInsercion();  
                break;  
            case "Buscar Secuencial":  
                int indice = operacionesVector.busquedaSecuencial(Integer.parseInt(entrada));  
                areaSalida.setText("Valor encontrado en el indice: " + indice);  
                return;  
            case "Buscar Binaria":  
                indice = operacionesVector.busquedaBinaria(Integer.parseInt(entrada));  
                areaSalida.setText("Valor encontrado en el indice: " + indice);  
                return;  
        }  
        areaSalida.setText("Vector Actual: " + operacionesVector.mostrarVector());  
    }  

    public static void main(String[] args) {  
        new MenuOperaciones();  
    }  
}
