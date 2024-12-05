public class Palabra {
    private String palabraSeleccionada;

    public void setPalabraSeleccionada(String palabra) {
        this.palabraSeleccionada = palabra;
    }

    public void mostrarConGuiones(String progreso) {
        System.out.println("Progreso: " + progreso);
    }

    public boolean comprobarLetra(String letra) {
        return palabraSeleccionada.contains(letra);
    }
}