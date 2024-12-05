import java.util.Random;

/**
 * Clase: JuegoAdivinanza
 * Juego de adivinanza de palabras, el juego selecciona una palabra aleatoria y permite
 * a los jugadores adivinarla en un número limitado de intentos, los jugadores pueden ver su progreso
 * representado con guiones bajos que sustituyen letras no adivinadas de la palabra.
 */
public class JuegoAdivinanza {
    private String palabra;
    private int intentos;
    private String progreso;

    /**
     * Constructor de clase: JuegoAdivinanza.
     * Inicializa el juego seleccionando una palabra aleatoria, asignando un número max de intentos.
     */
    public JuegoAdivinanza() {
        this.palabra = seleccionarPalabraAleatoria().toLowerCase();
        this.intentos = 40;
        this.progreso = "_".repeat(palabra.length());
    }

    /**
     * Método seleccionarPalabraAleatoria.
     * Selecciona una palabra al azar de un conjunto definido de palabras.
     * @return Retorna o escoge una palabra seleccionada aleatoriamente.
     */
    private String seleccionarPalabraAleatoria() {
        String[] palabras = {"casa", "perro", "gato", "comida", "escuela",
                "amigo", "familia", "trabajo", "carro", "bicicleta",
                "computadora", "programacion", "telefono", "internet", "musica",
                "libro", "juego", "pintura", "deporte", "viaje",
                "ciudad", "montana", "playa", "bosque", "rio",
                "pajaro", "pez", "sol", "luna", "estrella", "homunculo",
                "codigo", "bucle", "variable", "clase", "funcion",
                "pelota", "camisa", "zapato", "silla", "puerta",
                "reloj", "cocina", "ventana", "fiesta", "avion", "parangaricutirimicuaro", };
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    /**
     * Método obtProgreso.
     * Obtiene la representación actual del progreso del jugador.
     * @return Retorna una cadena de texto que muestra las letras adivinadas y guiones bajos
     * para las letras pendientes.
     */
    public String getProgreso() {

        return progreso;
    }

    /**
     * Método getIntentos.
     * Obtiene el número de intentos restantes del jugador.
     * @return Da un numero entero que representa el número de intentos restantes.
     */
    public int getIntentos() {

        return intentos;
    }

    /**
     * Método getPalabra.
     * Obtiene la palabra secreta que el jugador debe adivinar.
     * @return Retorna una cadena de texto que contiene la palabra secreta.
     */
    public String getPalabra() {

        return palabra;
    }
}