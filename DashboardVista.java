import javax.swing.*;
import java.awt.*;

public class DashboardVista extends JFrame {
    private JPanel contenedor;

    public DashboardVista() {
        setTitle("Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel barra = new JPanel();
        barra.add(new JLabel("Mi Dashboard"));

        contenedor = new JPanel(
            new GridLayout(0, 2, 10, 10)
        );

        add(barra, BorderLayout.NORTH);
        add(new JScrollPane(contenedor), BorderLayout.CENTER);
    }

    public void agregarWidget(InterfazDashboard widget) {
        contenedor.add(widget.obtenerVista());
        contenedor.revalidate();
        contenedor.repaint();
    }

    public void limpiarWidgets() {
        contenedor.removeAll();
        contenedor.revalidate();
        contenedor.repaint();
    }
}