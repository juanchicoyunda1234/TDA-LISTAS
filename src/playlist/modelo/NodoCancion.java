package playlist.modelo;

public class NodoCancion {
    public String titulo;
    public NodoCancion siguiente;

    public NodoCancion(String titulo) {
        this.titulo = titulo;
    }
}
