package modelo;
import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {
    private ArrayList<InterfazDashboard> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
        cargar();
    }

    public void cargar() {
        widgets.clear();

        widgets.add(new Clima(1, "Guatemala", 25));
        widgets.add(new Clima(2, "Antigua", 20));

        widgets.add(new Pendientes(3,
            new String[]{"Estudiar", "Entregar ejercicio"}));

        widgets.add(new Pendientes(4,
            new String[]{"Leer", "Ordenar escritorio"}));

        widgets.add(new Alerta(5, 1, "Entregar proyecto"));
        widgets.add(new Alerta(6, 2, "Revisar correo"));

        widgets.add(new Reloj(7, 0));
        widgets.add(new Reloj(8, 0));

        widgets.add(new FraseDelDia(9, "Cada paso cuenta"));
        widgets.add(new FraseDelDia(10, "Sigue aprendiendo"));
    }

    public ArrayList<InterfazDashboard> getWidgets() {
        return widgets;
    }

    public InterfazDashboard buscarID(int id) {
        for (InterfazDashboard widget : widgets) {
            if (widget.getID() == id) {
                return widget;
            }
        }

        return null;
    }

    public InterfazDashboard buscarNombre(String nombre) {
        for (InterfazDashboard widget : widgets) {
            if (widget.getNombre().equalsIgnoreCase(nombre)) {
                return widget;
            }
        }

        return null;
    }

    public void interactuar(int id) {
        InterfazDashboard widget = buscarID(id);

        if (widget instanceof InterfazInteractivo) {
            InterfazInteractivo interactivo =
                (InterfazInteractivo) widget;

            interactivo.detectarInteraccion();
        }
    }

    public void ordenar() {
        Collections.sort(widgets);
    }
}