import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicioForm extends JFrame {
    JPanel mainPanel;
    JButton btnIniciarJuego;
    JButton btnAcercaDe;
    JButton btnSalir;

    public PantallaInicioForm() {
        // Acción para el botón "Iniciar Juego"
        btnIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se Crear la ventana principal del juego
                JFrame frameJuego = new JFrame("Juego de Adivinanza");
                frameJuego.setContentPane(new JuegoAdivinanzaForm().mainPanel);
                frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameJuego.pack();
                frameJuego.setLocationRelativeTo(null);
                frameJuego.setVisible(true);


                // Cerrar la ventana inicial
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

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(
                null,

                "Juego de Adivinanza de Palabras\n\n" +
                        "Instrucciones:\n" +
                        "1. Adivina la palabra secreta letra por letra o completa.\n" +
                        "2. Tienes un número limitado de intentos.\n" +
                        "3. El progreso se muestra en pantalla con guiones bajos para letras pendientes.\n\n" +
                        "¡Diviértete jugando!",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Método principal para lanzar la pantalla inicial
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pantalla Inicial");
        frame.setContentPane(new PantallaInicioForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
    }


}
