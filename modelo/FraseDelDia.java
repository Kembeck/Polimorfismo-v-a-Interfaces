package modelo;
import javax.swing.*;

public class FraseDelDia implements InterfazDashboard {
    private String frase;
    private JPanel panel;
    private JLabel texto;
    private int id = 5;


    public FraseDelDia(int id, String frase) {
        this.id = id;
        this.frase = frase;
    }

    public void mostrarFrase(String frase) {
        System.out.println("Frase del dia: " + frase);
    }

    @Override
    public void renderizarContenido(String contenido) {
        texto.setText(contenido + frase);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Frase del dia";
    }

    @Override
    public int memoria() {
        return 128;
    }

    @Override
    public JComponent obtenerVista() {
        if (panel == null) {
            panel = new JPanel();
            panel.setBorder(
                BorderFactory.createTitledBorder("Frase del dia")
            );

            texto = new JLabel();
            panel.add(texto);

            mostrarFrase();
        }

        return panel;
    }

    public void mostrarFrase() {
        renderizarContenido("");
    }

   
}