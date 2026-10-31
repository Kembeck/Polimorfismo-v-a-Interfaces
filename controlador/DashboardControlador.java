package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.DashboardVista;

public class DashboardControlador implements ActionListener {
    private Dashboard modelo;
    private DashboardVista vista;

    public DashboardControlador(
            Dashboard modelo, DashboardVista vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.conectarControlador(this);
    }

    public void iniciar() {
        vista.mostrarWidgets(modelo.getWidgets());
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcion = evento.getActionCommand();

        try {
            switch (opcion) {
                case "Listar":
                    vista.mostrarWidgets(modelo.getWidgets());
                    break;

                case "Buscar ID":
                    int id = Integer.parseInt(vista.getDato());
                    mostrarResultado(modelo.buscarID(id));
                    break;

                case "Buscar nombre":
                    mostrarResultado(
                        modelo.buscarNombre(vista.getDato())
                    );
                    break;

                case "Interactuar":
                    interactuar();
                    break;

                case "Ordenar":
                    modelo.ordenar();
                    vista.mostrarWidgets(modelo.getWidgets());
                    break;
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Escribe un ID numerico");
        }
    }

    private void mostrarResultado(InterfazDashboard widget) {
        if (widget == null) {
            vista.mostrarMensaje("Widget no encontrado");
        } else {
            vista.limpiarWidgets();
            vista.agregarWidget(widget);
        }
    }

    private void interactuar() {
        int id = Integer.parseInt(vista.getDato());
        InterfazDashboard widget = modelo.buscarID(id);

        if (widget == null) {
            vista.mostrarMensaje("Widget no encontrado");
        } else if (widget instanceof InterfazInteractivo) {
            modelo.interactuar(id);
        } else {
            vista.mostrarMensaje(
                "Este widget solo muestra informacion"
            );
        }
    }
}