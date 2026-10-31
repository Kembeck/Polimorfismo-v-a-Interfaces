import javax.swing.SwingUtilities;
import modelo.Dashboard;
import vista.DashboardVista;
import controlador.DashboardControlador;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard modelo = new Dashboard();
            DashboardVista vista = new DashboardVista();

            DashboardControlador controlador =
                new DashboardControlador(modelo, vista);

            controlador.iniciar();
        });
    }
}