package operacionesbasicas.negocio;

import operacionesbasicas.modelo.Nodo;

public class ListaCircular {
    private Nodo cabeza;
    private int contador;

    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            Nodo ultimo = obtenerUltimo();
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            ultimo.siguiente = cabeza;
        }
        contador++;
    }

    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            Nodo ultimo = obtenerUltimo();
            ultimo.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        contador++;
    }

    private Nodo obtenerUltimo() {
        Nodo actual = cabeza;
        while (actual.siguiente != cabeza) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        do {
            sb.append(actual.dato).append(" -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        sb.append("(vuelve a ").append(cabeza.dato).append(")");
        System.out.println(sb.toString());
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int contar() {
        return contador;
    }
}
