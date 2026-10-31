package modelo;
import javax.swing.*;

import java.awt.GridLayout;

public class Clima implements InterfazDashboard, InterfazInteractivo {
    private double temperatura;
    private String ciudad;
    private boolean enCelsius = true;
    private JPanel panel;
    private JLabel texto;
    private int id = 1;


    public Clima(int id, String ciudad, double temperatura) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void cambiarUnidadMedida() {
        if (enCelsius) {
            temperatura = temperatura * 9.0 / 5 + 32;
        } else {
            temperatura = (temperatura - 32) * 5.0 / 9;
        }

        enCelsius = !enCelsius;
    }
    
    @Override
    public void renderizarContenido(String contenido) {
        String unidad;

        if (enCelsius) {
            unidad = " °C";
        } else {
            unidad = " °F";
        }

        texto.setText(
            contenido + ciudad + ": "
            + String.format("%.1f", temperatura) + unidad
        );
    }                    

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Clima";
    }

    @Override
    public int memoria() {
        return 1024; 
    }

    @Override
    public void detectarInteraccion() {
        cambiarUnidadMedida();
        renderizarContenido("");
    }

    @Override
    public JComponent obtenerVista() {
        if (panel == null) {
            panel = new JPanel(new GridLayout(2, 1));
            panel.setBorder(
                BorderFactory.createTitledBorder("Clima")
            );

            texto = new JLabel();
            JButton boton = new JButton("Cambiar unidad");

            boton.addActionListener(e -> detectarInteraccion());

            panel.add(texto);
            panel.add(boton);

            renderizarContenido("");
        }

        return panel;
    }

}
