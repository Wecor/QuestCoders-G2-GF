import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz de inicio del juego.
 */
public class PantallaInicioForm extends JFrame {
    JPanel mainPanel;
    JButton btnIniciarJuego;
    JButton btnAcercaDe;
    JButton btnSalir;

    /**
     * Constructor para inicializar la pantalla de inicio.
     * Configura los botones y sus respectivas acciones.
     */
    public PantallaInicioForm() {
        btnIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameJuego = new JFrame("Letras Fatales");
                frameJuego.setContentPane(new JuegoAdivinanzaForm().mainPanel);
                frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameJuego.pack();
                frameJuego.setLocationRelativeTo(null);
                frameJuego.setVisible(true);
                dispose();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnAcercaDe.addActionListener(e -> mostrarAcercaDe());
    }

    /**
     * Muestra la ficha técnica del equipo y el eslogan.
     */
    private void mostrarAcercaDe() {
        String mensaje = "=== Ficha Técnica del Equipo ===\n\n"
                + "Product Owner:\n"
                + "Eide Guerrero\n"
                + "Responsable de maximizar el valor del producto y el trabajo del equipo.\n\n"
                + "Scrum Master:\n"
                + "Kevin Rodriguez\n"
                + "Facilita eventos de Scrum y ayuda al equipo a mejorar.\n\n"
                + "Development Team:\n"
                + "Abiud Villamizar, Kevin Rodriguez\n"
                + "Profesionales auto-organizados que entregan incrementos de producto.\n\n"
                + "Líder Técnico:\n"
                + "Darcy Escalante\n"
                + "Líder del equipo de desarrollo.\n\n"
                + "Eslogan: \"Más que juegos, creamos experiencias.\"\n";

        JOptionPane.showMessageDialog(mainPanel, mensaje, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metodo principal para lanzar la aplicacion.
     * @param args Argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pantalla Inicial");
        frame.setContentPane(new PantallaInicioForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
    }

}
