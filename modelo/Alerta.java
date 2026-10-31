package modelo;
import javax.swing.*;

import java.awt.GridLayout;

public class Alerta implements InterfazDashboard, InterfazInteractivo {
    private int prioridad;
    private String mensaje;
    private boolean leida = false;
    private JPanel panel;
    private JLabel texto;
    private int id = 3;



    public Alerta(int id, int prioridad, String mensaje) {
        this.prioridad = prioridad;
        this.mensaje = mensaje;
        this.id = id;
    }

    public boolean marcarLeida() {
        leida = true;
        return leida;
    }

    @Override
    public void renderizarContenido(String contenido) {
        String estado;

        if (leida) {
            estado = "Leida";
        } else {
            estado = "No leida";
        }

        texto.setText(
            "<html>" + contenido + mensaje
            + "<br>Prioridad: " + prioridad
            + "<br>Estado: " + estado
            + "</html>"
        );
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Alerta";
    }

    @Override
    public int memoria() {
        return 512;
    }

    @Override
    public void detectarInteraccion() {
        marcarLeida();
        renderizarContenido("");
    }

    @Override
    public JComponent obtenerVista() {
        if (panel == null) {
            panel = new JPanel(new GridLayout(2, 1));
            panel.setBorder(
                BorderFactory.createTitledBorder("Alerta")
            );

            texto = new JLabel();
            JButton boton = new JButton("Marcar leida");

            boton.addActionListener(e -> detectarInteraccion());

            panel.add(texto);
            panel.add(boton);

            renderizarContenido("");
        }

        return panel;
    }
}
