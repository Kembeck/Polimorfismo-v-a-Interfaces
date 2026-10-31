import javax.swing.JComponent;

public interface InterfazDashboard extends Comparable<InterfazDashboard> {

    void renderizarContenido(String contenido);
    int getID();
    String getNombre();
    int memoria();
    JComponent obtenerVista();

    @Override
    default int compareTo(InterfazDashboard otro) {
        return Integer.compare(memoria(), otro.memoria());
    }
}