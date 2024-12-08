import java.util.Scanner;

/**
 * Método que gestiona el flujo del juego de adivinanza sin utilizar bucles explícitos (utiliza recursión en su lugar).
 * Este método verifica si el jugador aún tiene intentos restantes y progreso por completar.
 * <ul>
 *     <li>Si el jugador tiene intentos y la palabra no ha sido completada, muestra el progreso y solicita una entrada.</li>
 *     <li>Si el jugador adivina una letra o palabra incorrecta, reduce los intentos disponibles.</li>
 *     <li>Si el jugador completa la palabra correctamente, termina el juego mostrando un mensaje de victoria.</li>
 *     <li>Si se quedan sin intentos, termina el juego mostrando un mensaje de derrota.</li>
 * </ul>
 * El método se llama a sí mismo recursivamente hasta que se cumplan las condiciones de finalización del juego.
 *
 * @param juego    Instancia de la clase JuegoAdivinanza que contiene la lógica del juego y el estado actual.
 * @param scanner  Instancia de Scanner para recibir las entradas del jugador.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JuegoAdivinanza juego = new JuegoAdivinanza();
        Palabra palabra = new Palabra();
        palabra.setPalabraSeleccionada(juego.getPalabra());

        boolean continuar = true;

        do {
            System.out.println("\n-- Menú --");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Mostrar progreso");
            System.out.println("3. Comprobar letra");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                iniciarJuegoSinWhile(juego, scanner);
            } else if (opcion == 2) {
                palabra.mostrarConGuiones(juego.getProgreso());
            } else if (opcion == 3) {
                System.out.print("Ingrese una letra para comprobar: ");
                String letra = scanner.nextLine().toLowerCase();
                if (palabra.comprobarLetra(letra)) {
                    System.out.println("La letra está en la palabra.");
                } else {
                    System.out.println("La letra no está en la palabra.");
                }
            } else if (opcion == 4) {
                continuar = false;
                System.out.println("¡Gracias por jugar!");
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (continuar);

    }

    public static void iniciarJuegoSinWhile(JuegoAdivinanza juego, Scanner scanner) {
        if (juego.getIntentos() > 0 && juego.getProgreso().contains("_")) {
            System.out.println("Progreso: " + juego.getProgreso());
            System.out.println("Intentos restantes: " + juego.getIntentos());
            System.out.print("Adivina una letra o la palabra completa: ");
            String entrada = scanner.nextLine().toLowerCase();
            if (entrada.length() == 1) {
                juego.adivinarLetra(entrada);
            } else {
                juego.verificarPalabraCompleta(entrada);
            }
            iniciarJuegoSinWhile(juego, scanner); // Llamada recursiva
        } else {
            if (!juego.getProgreso().contains("_")) {
                System.out.println("¡Has ganado! La palabra era: " + juego.getPalabra());
            } else {
                System.out.println("¡Has perdido! La palabra era: " + juego.getPalabra());
            }
        }
    }
}