# Letras Fatales

Este proyecto es un juego de adivinanza de palabras en Java, donde los jugadores deben adivinar una palabra secreta seleccionada aleatoriamente.
Los jugadores tienen un número limitado de intentos para adivinar la palabra, y su progreso se muestra utilizando guiones bajos para las letras no adivinadas. 
El juego es una forma divertida de aumentar habilidades cognitivas de los jugadores.

 °Explicación de los metodos y clases

           °Clase: JuegoAdivinanza

Atributos:

String palabra: La palabra secreta que los jugadores deben adivinar.

int intentos: El número de intentos restantes que los jugadores tienen para adivinar la palabra.

String progreso: Representa el estado actual de las letras adivinadas, utilizando guiones bajos para las letras que aún no se han adivinado.

Métodos:

private String seleccionarPalabraAleatoria(): Método privado que elige una palabra al azar de un conjunto predefinido de palabras.

public String getProgreso(): Devuelve la representación actual del progreso de adivinanza del jugador.

public int getIntentos(): Retorna el número de intentos restantes del jugador.

public String getPalabra(): Devuelve la palabra secreta que debe adivinar el jugador.

public void adivinarLetra(String letra): Permite a los jugadores intentar adivinar una letra de la palabra secreta y actualizar el 
progreso si la letra es correcta.

public void verificarPalabraCompleta(String intento): Permite a los jugadores intentar adivinar toda la palabra secreta y actualizar el progreso en consecuencia.

       Clase: Palabra

Atributos:

String palabraSeleccionada: La palabra que será utilizada en el juego.

Métodos:

public void setPalabraSeleccionada(String palabra): Establece la palabra que será utilizada en el juego.

public void mostrarConGuiones(String progreso): Muestra el progreso actual del jugador en el formato de guiones.

public boolean comprobarLetra(String letra): Comprueba si una letra específica está contenida en la palabra seleccionada.

       Clase: PantallaInicioForm

Métodos:

public static void main(String[] args): Método principal que lanza la pantalla inicial del juego.

private void mostrarAcercaDe(): Muestra un cuadro de diálogo con información sobre el juego y sus instrucciones.

       Clase: JuegoAdivinanzaForm

Atributos:

JuegoAdivinanza juego: Instancia de la clase JuegoAdivinanza que contiene la lógica del juego.

Métodos:

public static void main(String[] args): Método principal que ejecuta la interfaz del juego.

private void manejarEntrada(): Maneja la entrada del usuario y actualiza el progreso del juego.

private void reiniciarJuego(): Reinicia el juego y actualiza la interfaz.

private void actualizarInterfaz(): Actualiza las etiquetas de la interfaz con el progreso y los intentos restantes.

  °Tecnologías utilizadas

Lenguaje de programación: Java

Entorno de desarrollo: IntelliJ IDEA

JDK: 17 o superior
