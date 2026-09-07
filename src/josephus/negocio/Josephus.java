package josephus.negocio;

import josephus.modelo.NodoPersona;

public class Josephus {

    public static int resolver(int n, int k) {
        NodoPersona cabeza = construirCirculo(n);
        NodoPersona anterior = obtenerUltimo(cabeza, n);
        NodoPersona actual = cabeza;
        int restantes = n;

        System.out.println("n=" + n + ", k=" + k);
        while (restantes > 1) {
            for (int i = 1; i < k; i++) {
                anterior = actual;
                actual = actual.siguiente;
            }
            System.out.println("  Se elimina: " + actual.id);
            anterior.siguiente = actual.siguiente;
            actual = anterior.siguiente;
            restantes--;
        }
        System.out.println("  Sobreviviente: " + actual.id);
        return actual.id;
    }

    private static NodoPersona construirCirculo(int n) {
        NodoPersona cabeza = new NodoPersona(1);
        NodoPersona actual = cabeza;
        for (int i = 2; i <= n; i++) {
            actual.siguiente = new NodoPersona(i);
            actual = actual.siguiente;
        }
        actual.siguiente = cabeza;
        return cabeza;
    }

    private static NodoPersona obtenerUltimo(NodoPersona cabeza, int n) {
        NodoPersona actual = cabeza;
        for (int i = 1; i < n; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }
}
