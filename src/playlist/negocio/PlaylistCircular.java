package playlist.negocio;

import playlist.modelo.NodoCancion;

public class PlaylistCircular {
    private NodoCancion cabeza;
    private NodoCancion actual;
    private int cantidad;

    public void agregarInicio(String titulo) {
        NodoCancion nuevo = new NodoCancion(titulo);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = nuevo;
            actual = nuevo;
        } else {
            NodoCancion ultimo = obtenerUltimo();
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            ultimo.siguiente = cabeza;
        }
        cantidad++;
    }

    public void agregarFinal(String titulo) {
        NodoCancion nuevo = new NodoCancion(titulo);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = nuevo;
            actual = nuevo;
        } else {
            NodoCancion ultimo = obtenerUltimo();
            ultimo.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        cantidad++;
    }

    public boolean eliminarPorNombre(String titulo) {
        if (cabeza == null) {
            return false;
        }
        if (cantidad == 1) {
            if (cabeza.titulo.equals(titulo)) {
                cabeza = null;
                actual = null;
                cantidad = 0;
                return true;
            }
            return false;
        }
        NodoCancion anterior = obtenerUltimo();
        NodoCancion nodo = cabeza;
        for (int i = 0; i < cantidad; i++) {
            if (nodo.titulo.equals(titulo)) {
                anterior.siguiente = nodo.siguiente;
                if (nodo == cabeza) {
                    cabeza = nodo.siguiente;
                }
                if (nodo == actual) {
                    actual = nodo.siguiente;
                }
                cantidad--;
                return true;
            }
            anterior = nodo;
            nodo = nodo.siguiente;
        }
        return false;
    }

    public void reproducirSiguiente() {
        if (actual == null) {
            System.out.println("Playlist vacia, nada que reproducir");
            return;
        }
        actual = actual.siguiente;
        System.out.println("Reproduciendo ahora: " + actual.titulo);
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Playlist vacia");
            return;
        }
        StringBuilder sb = new StringBuilder();
        NodoCancion nodo = cabeza;
        do {
            sb.append(nodo.titulo);
            if (nodo == actual) {
                sb.append("*");
            }
            sb.append(" -> ");
            nodo = nodo.siguiente;
        } while (nodo != cabeza);
        sb.append("(vuelve a ").append(cabeza.titulo).append(")");
        System.out.println(sb.toString());
    }

    private NodoCancion obtenerUltimo() {
        NodoCancion nodo = cabeza;
        while (nodo.siguiente != cabeza) {
            nodo = nodo.siguiente;
        }
        return nodo;
    }
}
