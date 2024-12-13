/**
 * Clase Palabra que gestiona la lógica relacionada con la palabra a adivinar en el juego.
 *
 * Funcionalidades principales:
 * - Permite establecer la palabra seleccionada para el juego.
 * - Muestra el progreso del jugador con letras adivinadas y guiones bajos para las letras restantes.
 * - Comprueba si una letra específica está presente en la palabra seleccionada.
 */
public class Palabra {
    private String palabraSeleccionada;

    /**
     * Establece la palabra que será utilizada en el juego.
     *
     * @param palabra La palabra seleccionada que el jugador intentará adivinar.
     */

    public void setPalabraSeleccionada(String palabra) {
        this.palabraSeleccionada = palabra;
    }

    /**
     * Muestra el progreso actual del jugador en el formato de guiones.
     * Esto incluye las letras ya adivinadas correctamente, mientras que las
     * letras restantes permanecen como guiones bajos.
     *
     * @param progreso Cadena que representa el estado actual del progreso del jugador.
     */

    public void mostrarConGuiones(String progreso) {
        System.out.println("Progreso: " + progreso);
    }

    /**
     * Comprueba si una letra específica está contenida en la palabra seleccionada.
     *
     * @param letra La letra que el jugador desea comprobar.
     * @return {@code true} si la letra está en la palabra seleccionada, {@code false} en caso contrario.
     */

    public boolean comprobarLetra(String letra) {
        return palabraSeleccionada.contains(letra);
    }
}