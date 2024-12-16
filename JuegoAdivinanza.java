/**
 * Clase que representa el juego de adivinanza de palabras.
 * Permite a los jugadores adivinar letras o la palabra completa
 * con un numero limitado de intentos.
 */
public class JuegoAdivinanza {
    private Palabra palabra;
    private int intentos;

    /**
     * Constructor para inicializar el juego con una nueva palabra y un número de intentos
     */
    public JuegoAdivinanza() {
        this.palabra = new Palabra();
        this.intentos = 15;
    }

    /**
     * Obtiene el progreso actual del jugador en el juego.
     * @return Progreso representado con letras y guiones bajos.
     */
    public String getProgreso() {
        return palabra.getProgreso();
    }

    /**
     * Obtiene el número de intentos restantes.
     * @return Número de intentos disponibles.
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * Obtiene la palabra que debe adivinar el jugador.
     * @return Palabra secreta del juego.
     */
    public String getPalabra() {
        return palabra.getPalabraSeleccionada();
    }

    /**
     * Obtiene la pista asociada a la palabra seleccionada.
     * @return Pista para ayudar al jugador.
     */
    public String getPista() {
        return palabra.getPista();
    }



    /**
     * Valida si la entrada del usuario es válida: debe contener solo letras y ser una letra o la palabra completa.
     * @param entrada Entrada del usuario.
     * @return true si la entrada es válida, false en caso contrario.
     */
    public boolean validarEntrada(String entrada) {
        if (!entrada.matches("[a-zA-Z]+")) {
            return false;
        }
        if (entrada.length() != 1 && entrada.length() != palabra.getPalabraSeleccionada().length()) {
            return false;
        }
        return true;
    }


    /**
     * Intenta adivinar una letra de la palabra secreta.
     * Si es correcta, actualiza el progreso; de lo contrario, reduce los intentos.
     * @param letra Letra ingresada por el jugador.
     */
    public void adivinarLetra(String letra) {
        if (!palabra.verificarLetra(letra)) {
            intentos--;
        }
    }

    /**
     * Permite al jugador intentar adivinar toda la palabra secreta.
     * Si es correcta, completa el progreso; de lo contrario, reduce los intentos.
     * @param intento Palabra ingresada por el jugador.
     */
    public void verificarPalabraCompleta(String intento) {
        if (!palabra.verificarPalabraCompleta(intento)) {
            intentos--;
        }
    }
}