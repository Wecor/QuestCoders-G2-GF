import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase JuegoAdivinanzaForm que representa la interfaz gráfica del juego de adivinanza.
 * Permite al usuario adivinar letras o palabras completas y muestra el progreso del juego.
 *
 * Métodos:
 * - JuegoAdivinanzaForm(): Constructor que inicializa el juego y configura la interfaz gráfica.
 * - manejarEntrada(): Maneja la entrada del usuario, verifica si es una letra o una palabra completa,
 *   y actualiza el estado del juego. Muestra un mensaje de victoria o derrota si el juego ha terminado.
 * - reiniciarJuego(): Reinicia el juego creando una nueva instancia de JuegoAdivinanza y actualiza
 *   la interfaz gráfica.
 * - actualizarInterfaz(): Actualiza la interfaz gráfica con el progreso actual del juego y los intentos restantes.
 * - main(String[] args): Método principal que inicia la aplicación, creando una instancia de
 *   JuegoAdivinanzaForm y configurando la ventana principal.
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

    JuegoAdivinanza juego;


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

        setSize(400, 300); // Ajusta el tamaño de la ventana según necesites
        setLocationRelativeTo(null); // Centrar ventana

    }

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


    private void reiniciarJuego() {
        juego = new JuegoAdivinanza();
        actualizarInterfaz();
    }

    private void actualizarInterfaz() {
        lblProgreso.setText("Progreso: " + juego.getProgreso());
        lblIntentos.setText("Intentos restantes: " + juego.getIntentos());
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego de Adivinanza");
        frame.setContentPane(new JuegoAdivinanzaForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
