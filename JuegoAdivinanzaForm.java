import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que gestiona la interfaz del juego de adivinanza.
 */
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
    JButton btnPista;
    JButton btnComoJugar;
    JuegoAdivinanza juego;


    /**
     * Constructor para inicializar la interfaz del juego.
     * Configura los elementos de la ventana, define los eventos de los botones
     * e inicia una nueva partida del juego.
     */
    public JuegoAdivinanzaForm() {
        juego = new JuegoAdivinanza();

        lblCantidadLetras.setText("La palabra tiene " + juego.getPalabra().length() + " letras.");
        actualizarInterfaz();

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarEntrada();
            }
        });

        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnPista.addActionListener(e -> mostrarPista());
        btnComoJugar.addActionListener(e -> mostrarComoJugar());

        setSize(400, 300); // Ajusta el tamaño de la ventana según necesites
        setLocationRelativeTo(null); // Centrar ventana

    }

    /**
     * Muestra las instrucciones de cómo jugar.
     */
    private void mostrarComoJugar() {
        JOptionPane.showMessageDialog(
                null,
                "=== Cómo Jugar ===\n\n"
                + "1. Ingresa una letra para intentar adivinar la palabra.\n"
                + "2. Si la letra es correcta, se revelará en el progreso.\n"
                + "3. Si crees saber la palabra completa, escríbela.\n"
                + "4. Tienes un número limitado de intentos.\n"
                + "5. Usa la opción de pista si necesitas ayuda.\n",

        "Como jugar",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void mostrarPista() {
        JOptionPane.showMessageDialog(mainPanel,
                "Pista: " + juego.getPista(),
                "Pista",
                JOptionPane.INFORMATION_MESSAGE);
    }


    private void manejarEntrada() {
        String entrada = txtEntrada.getText().toLowerCase().trim();
        txtEntrada.setText("");

        if (!juego.validarEntrada(entrada)) {
            JOptionPane.showMessageDialog(mainPanel, "Entrada inválida. Ingresa solo una letra o la palabra completa.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

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




    /**
     * Reinicia el juego con una nueva palabra.
     */
    private void reiniciarJuego() {
        juego = new JuegoAdivinanza();
        actualizarInterfaz();
    }

    /**
     * Actualiza las etiquetas de la interfaz con el progreso y los intentos restantes.
     */
    private void actualizarInterfaz() {
        lblProgreso.setText("Progreso: " + juego.getProgreso());
        lblIntentos.setText("Intentos restantes: " + juego.getIntentos());
        lblCantidadLetras.setText("La palabra tiene " + juego.getPalabra().length() + " letras.");
    }

}
