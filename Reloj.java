import javax.swing.*;
import java.time.LocalTime;

public class Reloj implements InterfazDashboard {
    private int horaActualEnMinutos;
    private JPanel panel;
    private JLabel texto;
    private int id = 4;

    public Reloj(int id, int horaActualEnMinutos) {
        this.horaActualEnMinutos = horaActualEnMinutos;
        this.id = id;
    }

    public void mostrarHora() {
        LocalTime ahora = LocalTime.now();

        horaActualEnMinutos =
            ahora.getHour() * 60 + ahora.getMinute();

        renderizarContenido("");
    }

    @Override
    public void renderizarContenido(String contenido) {
        int horas = horaActualEnMinutos / 60;
        int minutos = horaActualEnMinutos % 60;

        texto.setText(
            contenido + String.format("Hora: %02d:%02d", horas, minutos)
        );
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Reloj";
    }

    @Override
    public int memoria() {
        return 256;
    }

    @Override
    public JComponent obtenerVista() {
        if (panel == null) {
            panel = new JPanel();
            panel.setBorder(
                BorderFactory.createTitledBorder("Reloj")
            );

            texto = new JLabel();
            panel.add(texto);

            mostrarHora();

            Timer timer = new Timer(1000, e -> mostrarHora());
            timer.start();
        }

        return panel;
    }

    
}