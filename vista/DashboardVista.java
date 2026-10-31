package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.InterfazDashboard;

public class DashboardVista extends JFrame {
    private JPanel contenedor;
    private JTextField dato;

    private JButton listar;
    private JButton buscarID;
    private JButton buscarNombre;
    private JButton interactuar;
    private JButton ordenar;

    public DashboardVista() {
        setTitle("Dashboard");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        JPanel barra = new JPanel(new BorderLayout());
        barra.add(new JLabel("Mi Dashboard"), BorderLayout.NORTH);

        
        JPanel controles = new JPanel();

        dato = new JTextField(15);

        listar = new JButton("Listar");
        buscarID = new JButton("Buscar ID");
        buscarNombre = new JButton("Buscar nombre");
        interactuar = new JButton("Interactuar");
        ordenar = new JButton("Ordenar");

        controles.add(new JLabel("ID o nombre:"));
        controles.add(dato);
        controles.add(listar);
        controles.add(buscarID);
        controles.add(buscarNombre);
        controles.add(interactuar);
        controles.add(ordenar);

        barra.add(controles, BorderLayout.CENTER);

       
        contenedor = new JPanel(
            new GridLayout(0, 2, 10, 10)
        );

        add(barra, BorderLayout.NORTH);
        add(new JScrollPane(contenedor), BorderLayout.CENTER);
    }

    public void conectarControlador(ActionListener controlador) {
        listar.addActionListener(controlador);
        buscarID.addActionListener(controlador);
        buscarNombre.addActionListener(controlador);
        interactuar.addActionListener(controlador);
        ordenar.addActionListener(controlador);
    }

    public String getDato() {
        return dato.getText().trim();
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

    public void mostrarWidgets(
            ArrayList<InterfazDashboard> widgets) {

        limpiarWidgets();

        for (InterfazDashboard widget : widgets) {
            agregarWidget(widget);
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}