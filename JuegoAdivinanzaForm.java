import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoAdivinanzaForm extends JFrame {
    JPanel mainPanel;
    JLabel lblProgreso;
    JLabel lblIntentos;
    JLabel lblCantidadLetras;
    JLabel lblIngreseLetra;
    JTextField txtEntrada;
    JButton btnEnviar;
    JButton btnReiniciar;
    JButton btnSalir;

    JuegoAdivinanza juego;


    public JuegoAdivinanzaForm() {
        juego = new JuegoAdivinanza();

        // Inicializar etiquetas
        lblCantidadLetras.setText("La palabra tiene " + juego.getPalabra().length() + " letras.");
        actualizarInterfaz();

        // Botón Enviar
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarEntrada();
            }
        });

        // Botón Reiniciar
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });

        // Botón Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 300); // Ajusta el tamaño de la ventana según necesites
        setLocationRelativeTo(null); // Centrar ventana

    }

    // Manejar entrada del usuario
    private void manejarEntrada() {
        String entrada = txtEntrada.getText().toLowerCase();
        txtEntrada.setText("");

        if (entrada.length() == 1) {
            juego.adivinarLetra(entrada);
        } else {
            juego.verificarPalabraCompleta(entrada);
        }

        actualizarInterfaz();

        if (!juego.getProgreso().contains("_")) {
            JOptionPane.showMessageDialog(mainPanel, "¡Has ganado! La palabra era: " + juego.getPalabra());
        } else if (juego.getIntentos() <= 0) {
            JOptionPane.showMessageDialog(mainPanel, "¡Has perdido! La palabra era: " + juego.getPalabra());
        }
    }



    // Reiniciar el juego
    private void reiniciarJuego() {
        juego = new JuegoAdivinanza();
        actualizarInterfaz();
    }

    // Actualizar etiquetas de la interfaz
    private void actualizarInterfaz() {
        lblProgreso.setText("Progreso: " + juego.getProgreso());
        lblIntentos.setText("Intentos restantes: " + juego.getIntentos());
    }


    // Método principal para ejecutar la interfaz
    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego de Adivinanza");
        frame.setContentPane(new JuegoAdivinanzaForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
