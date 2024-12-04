import java.util.Random;

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
                "pajaro", "pez", "sol", "luna", "estrella",
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