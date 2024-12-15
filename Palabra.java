import java.util.Random;

/**
 * Clase que gestiona la lógica relacionada con la palabra a adivinar.
 */
public class Palabra {
    private String palabraSeleccionada;
    private String progreso;
    private String pista;

    /**
     * Constructor que selecciona una palabra aleatoria y genera el progreso inicial.
     */
    public Palabra() {
        String[] palabras = seleccionarPalabraAleatoria();
        this.palabraSeleccionada = palabras[0].toLowerCase();
        this.pista = palabras[1];
        this.progreso = "_".repeat(palabraSeleccionada.length());
    }

    /**
     * Selecciona una palabra y su pista al azar de un conjunto predefinido.
     * @return Array con la palabra y su pista.
     */
    private String[] seleccionarPalabraAleatoria() {
        String[][] palabrasConPistas = {
                {"casa", "Es un lugar donde vivimos."},
                {"perro", "Es el mejor amigo del hombre."},
                {"gato", "Un animal que dice 'miau'."},
                {"bosque", "Un lugar lleno de árboles."},
                {"montana", "Es alta y los escaladores la suben."},
                {"luna", "Se ve de noche y está en el cielo."},
                {"sol", "El astro que ilumina el día."},
                {"mar", "Es un cuerpo de agua salada."},
                {"playa", "Lugar con arena cerca del mar."},
                {"ciudad", "Tiene edificios, coches y mucha gente."},
                {"familia", "Es el grupo de personas que más queremos."},
                {"amigo", "Una persona cercana y especial."},
                {"fiesta", "Un evento para celebrar algo."},
                {"escuela", "Un lugar donde aprendemos."},
                {"trabajo", "Lo que hacemos para ganar dinero."},
                {"bicicleta", "Un medio de transporte con dos ruedas."},
                {"avion", "Se usa para viajar por el aire."},
                {"puerta", "Se abre para entrar o salir."},
                {"ventana", "Se abre para dejar entrar aire o luz."},
                {"libro", "Tiene páginas con historias o información."},
                {"musica", "Sonidos organizados que disfrutamos escuchar."},
                {"deporte", "Actividad física que se practica por diversión o competición."},
                {"juego", "Actividad que hacemos para entretenernos."},
                {"pintura", "Arte hecho con colores en un lienzo."},
                {"flor", "Parte colorida de una planta."},
                {"pez", "Animal que vive en el agua."},
                {"pajaro", "Animal que vuela y canta."},
                {"reloj", "Sirve para saber la hora."},
                {"cocina", "Lugar donde preparamos los alimentos."},
                {"camisa", "Prenda de vestir para la parte superior del cuerpo."},
                {"zapato", "Se usa para proteger los pies."},
                {"silla", "Objeto donde nos sentamos."},
                {"carro", "Un medio de transporte con ruedas."},
                {"tren", "Un medio de transporte que va sobre rieles."},
                {"puente", "Estructura que conecta dos lugares separados por agua o vacío."},
                {"ciervo", "Un animal con cuernos que vive en los bosques."},
                {"fruta", "Alimento dulce y natural que crece en los árboles."},
                {"pastel", "Un postre que comemos en los cumpleaños."},
                {"sombrero", "Se usa en la cabeza para protegerse del sol."},
                {"viento", "Es aire que se mueve."},
                {"nieve", "Es agua congelada que cae del cielo."},
                {"arcoiris", "Aparece en el cielo después de la lluvia."},
                {"estrella", "Se ven de noche y brillan en el cielo."},
                {"leon", "Es el rey de la selva."},
                {"tigre", "Un gran felino con rayas."},
                {"elefante", "Un animal grande con trompa."},
                {"caballo", "Se monta y galopa rápidamente."},
                {"laguna", "Un cuerpo pequeño de agua."},
                {"fuego", "Es caliente y se usa para cocinar."},
                {"hielo", "Es agua congelada."}
        };
        Random random = new Random();
        return palabrasConPistas[random.nextInt(palabrasConPistas.length)];
    }

    /**
     * Obtiene la pista asociada con la palabra.
     * @return La pista.
     */
    public String getPista() {
        return pista;
    }



    /**
     * Verifica si la letra está en la palabra y actualiza el progreso si es correcta.
     * @param letra Letra ingresada por el jugador.
     * @return true si la letra está en la palabra, false en caso contrario.
     */
    public boolean verificarLetra(String letra) {
        boolean contiene = palabraSeleccionada.contains(letra);
        if (contiene) {
            StringBuilder sb = new StringBuilder(progreso);
            for (int i = 0; i < palabraSeleccionada.length(); i++) {
                if (palabraSeleccionada.charAt(i) == letra.charAt(0)) {
                    sb.setCharAt(i, letra.charAt(0));
                }
            }
            progreso = sb.toString();
        }
        return contiene;
    }

    /**
     * Verifica si la palabra completa es correcta.
     * @param intento Palabra ingresada por el jugador.
     * @return true si es igual a la palabra seleccionada, false en caso contrario.
     */
    public boolean verificarPalabraCompleta(String intento) {
        if (intento.equals(palabraSeleccionada)) {
            progreso = palabraSeleccionada;
            return true;
        }
        return false;
    }

    /**
     * Obtiene la palabra seleccionada.
     * @return La palabra secreta.
     */
    public String getPalabraSeleccionada() {
        return palabraSeleccionada;
    }

    /**
     * Obtiene el progreso actual del jugador.
     * @return Progreso de la palabra con guiones bajos y letras descubiertas.
     */
    public String getProgreso() {
        return progreso;
    }
}