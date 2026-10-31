import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardVista vista = new DashboardVista();

            vista.agregarWidget(
                new Clima(1, "Guatemala", 25)
            );

            vista.agregarWidget(new Pendientes(
                2,
                new String[]{"Estudiar Calculo", "Entregar ejercicio"}
            ));

            vista.agregarWidget(
                new Alerta(3, 1, "Entregar proyecto")
            );

            vista.agregarWidget(new Reloj(4, 0));

            vista.agregarWidget(
                new FraseDelDia(5, "Cada paso cuenta")
            );

            vista.setVisible(true);
        });
    }
}