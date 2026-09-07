package roundrobin.negocio;

import roundrobin.modelo.NodoProceso;
import roundrobin.modelo.Proceso;

public class ColaCircularProcesos {
    private NodoProceso cabeza;
    private int cantidad;

    public void agregar(Proceso proceso) {
        NodoProceso nuevo = new NodoProceso(proceso);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            NodoProceso ultimo = obtenerUltimo();
            ultimo.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        cantidad++;
    }

    private NodoProceso obtenerUltimo() {
        NodoProceso actual = cabeza;
        while (actual.siguiente != cabeza) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int cantidad() {
        return cantidad;
    }

    public void mostrarEstado() {
        if (estaVacia()) {
            System.out.println("  (cola vacia)");
            return;
        }
        StringBuilder sb = new StringBuilder("  ");
        NodoProceso actual = cabeza;
        do {
            sb.append(actual.proceso.nombre).append("(").append(actual.proceso.tiempoRestante).append(") -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        sb.append("...");
        System.out.println(sb.toString());
    }

    public void ejecutarTurno(int quantum) {
        if (estaVacia()) {
            return;
        }
        Proceso actualProceso = cabeza.proceso;
        System.out.println("Ejecutando: " + actualProceso.nombre + " (tenia " + actualProceso.tiempoRestante + ")");

        int tiempoUsado = Math.min(quantum, actualProceso.tiempoRestante);
        actualProceso.tiempoRestante -= tiempoUsado;

        if (actualProceso.tiempoRestante <= 0) {
            System.out.println("  -> " + actualProceso.nombre + " termino, se elimina de la lista");
            eliminarCabeza();
        } else {
            System.out.println("  -> " + actualProceso.nombre + " le quedan " + actualProceso.tiempoRestante
                    + ", vuelve al final del ciclo");
            rotar();
        }
    }

    private void rotar() {
        if (cantidad <= 1) {
            return;
        }
        cabeza = cabeza.siguiente;
    }

    private void eliminarCabeza() {
        if (cantidad == 1) {
            cabeza = null;
            cantidad = 0;
            return;
        }
        NodoProceso ultimo = obtenerUltimo();
        cabeza = cabeza.siguiente;
        ultimo.siguiente = cabeza;
        cantidad--;
    }
}
