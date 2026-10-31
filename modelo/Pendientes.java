package modelo;
import javax.swing.*;

import java.awt.GridLayout;

public class Pendientes implements InterfazDashboard, InterfazInteractivo {
    private String[] tareas;
    private int completadas = 0;
    private JPanel panel;
    private JLabel texto;
    private int id = 2;


    public Pendientes(int id, String[] tareas) {
        this.tareas = tareas;
        this.id = id;
    }

    public void agregarTarea(String tarea) {
        String[] nuevo = new String[tareas.length + 1];

        for (int i = 0; i < tareas.length; i++) {
            nuevo[i] = tareas[i];
        }

        nuevo[tareas.length] = tarea;
        tareas = nuevo;
    }

    public boolean marcarCompletada() {
        if (completadas < tareas.length) {
            completadas++;
            return true;
        }
        return false;
    }

    public String[] getTareas() {
        return tareas;
    }

    @Override
    public void renderizarContenido(String contenido) {
        String lista = "<html>" + contenido;

        for (int i = 0; i < tareas.length; i++) {
            if (i < completadas) {
                lista += "[Completada] ";
            } else {
                lista += "[Pendiente] ";
            }

            lista += tareas[i] + "<br>";
        }

        lista += "</html>";
        texto.setText(lista);
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getNombre() { 
        return "Pendientes";
    }

    @Override
    public int memoria() {
        return 2048; 
    }   

    @Override
    public void detectarInteraccion() {
        marcarCompletada();
        renderizarContenido("");
    }

    @Override
    public JComponent obtenerVista() {
        if (panel == null) {
            panel = new JPanel(new GridLayout(2, 1));
            panel.setBorder(
                BorderFactory.createTitledBorder("Pendientes")
            );

            texto = new JLabel();
            JButton boton = new JButton("Completar tarea");

            boton.addActionListener(e -> detectarInteraccion());

            panel.add(texto);
            panel.add(boton);

            renderizarContenido("");
        }

        return panel;
    }

}