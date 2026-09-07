package insercioneliminacion.negocio;

import insercioneliminacion.modelo.Nodo;

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

    public boolean insertarPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > contador) {
            return false;
        }
        if (posicion == 0) {
            insertarInicio(dato);
            return true;
        }
        if (posicion == contador) {
            insertarFinal(dato);
            return true;
        }
        Nodo anterior = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.siguiente;
        }
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo;
        contador++;
        return true;
    }

    public boolean eliminarPosicion(int posicion) {
        if (estaVacia() || posicion < 0 || posicion >= contador) {
            return false;
        }
        if (contador == 1) {
            cabeza = null;
            contador = 0;
            return true;
        }
        if (posicion == 0) {
            Nodo ultimo = obtenerUltimo();
            cabeza = cabeza.siguiente;
            ultimo.siguiente = cabeza;
            contador--;
            return true;
        }
        Nodo anterior = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.siguiente;
        }
        anterior.siguiente = anterior.siguiente.siguiente;
        contador--;
        return true;
    }

    public boolean eliminarValor(int valor) {
        if (estaVacia()) {
            return false;
        }
        if (contador == 1) {
            if (cabeza.dato == valor) {
                cabeza = null;
                contador = 0;
                return true;
            }
            return false;
        }
        if (cabeza.dato == valor) {
            return eliminarPosicion(0);
        }
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != cabeza) {
            if (actual.dato == valor) {
                anterior.siguiente = actual.siguiente;
                contador--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
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
