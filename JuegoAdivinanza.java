import java.util.Random;

/**
 * Clase: JuegoAdivinanza
 * Juego de adivinanza de palabras, el juego selecciona una palabra aleatoria y permite
 * a los jugadores adivinarla en un número limitado de intentos, los jugadores pueden ver su progreso
 * representado con guiones bajos que sustituyen letras no adivinadas de la palabra.
 *
 * Este juego es ideal para practicar habilidades de ortografía y expandir el vocabulario.
 * Los jugadores pueden aprovechar su conocimiento de palabras al intentar adivinar la palabra
 * correcta. También añade un elemento de emoción al limitar el número de intentos, lo que
 * hace que el juego sea desafiante y divertido.
 *
 * Atributos:
 * - palabra: La palabra secreta que los jugadores deben adivinar.
 * - intentos: El número de intentos restantes que los jugadores tienen para adivinar la palabra.
 * - progreso: Representa el estado actual de las letras adivinadas, utilizando guiones bajos
 *             para las letras que aún no se han adivinado.
 *
 * Métodos:
 * - seleccionarPalabraAleatoria(): Método privado que elige una palabra al azar de un conjunto
 *                                   predefinido de palabras.
 * - getProgreso(): Devuelve la representación actual del progreso de adivinanza del jugador.
 * - getIntentos(): Retorna el número de intentos restantes del jugador.
 * - getPalabra(): Devuelve la palabra secreta que debe adivinar el jugador.
 * - adivinarLetra(String letra): Permite a los jugadores intentar adivinar una letra de la
 *                                 palabra secreta y actualizar el progreso si la letra es correcta.
 * - verificarPalabraCompleta(String intento): Permite a los jugadores intentar adivinar
 *                                             toda la palabra secreta y actualizar el progreso
 *                                             en consecuencia.
 */

public class JuegoAdivinanza {
    private String palabra;
    private int intentos;
    private String progreso;

    public JuegoAdivinanza() {
        this.palabra = seleccionarPalabraAleatoria().toLowerCase();
        this.intentos = 15;
        this.progreso = "_".repeat(palabra.length());
    }

    private String seleccionarPalabraAleatoria() {
        String[] palabras = {"casa", "perro", "gato", "comida", "escuela",
                "amigo", "familia", "trabajo", "carro", "bicicleta",
                "computadora", "programacion", "telefono", "internet", "musica",
                "libro", "juego", "pintura", "deporte", "viaje",
                "ciudad", "montana", "playa", "bosque", "rio",
                "pajaro", "pez", "sol", "luna", "estrella", "homunculo",
                "codigo", "bucle", "variable", "clase", "funcion",
                "pelota", "camisa", "zapato", "silla", "puerta",
                "reloj", "cocina", "ventana", "fiesta", "avion", "parangaricutirimicuaro"};
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }


    public String getProgreso() {

        return progreso;
    }

    public int getIntentos() {

        return intentos;
    }


    public String getPalabra() {

        return palabra;
    }

    public void adivinarLetra(String letra) {
        if (palabra.contains(letra)) {
            StringBuilder sb = new StringBuilder(progreso);
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra.charAt(0)) {
                    sb.setCharAt(i, letra.charAt(0));
                }
            }
            progreso = sb.toString();
        } else {
            intentos--;
        }
    }

    public void verificarPalabraCompleta(String intento) {
        if (intento.equals(palabra)) {
            progreso = palabra;
        } else {
            intentos--;
        }
    }
}