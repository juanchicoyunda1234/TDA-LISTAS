package app;

import java.util.Scanner;

import operacionesbasicas.negocio.ListaCircular;
import roundrobin.modelo.Proceso;
import roundrobin.negocio.ColaCircularProcesos;
import josephus.negocio.Josephus;
import playlist.negocio.PlaylistCircular;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n==========================================");
            System.out.println("     MENU PRINCIPAL - LISTAS CIRCULARES");
            System.out.println("==========================================");
            System.out.println("1. Operaciones basicas sobre lista circular");
            System.out.println("2. Insercion y eliminacion controlada");
            System.out.println("3. Simulacion Round-Robin");
            System.out.println("4. Problema de Josephus");
            System.out.println("5. Playlist musical circular");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1: menuOperacionesBasicas(sc); break;
                case 2: menuInsercionEliminacion(sc); break;
                case 3: menuRoundRobin(sc); break;
                case 4: menuJosephus(sc); break;
                case 5: menuPlaylist(sc); break;
                case 6: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 6);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        if (sc.hasNextInt()) {
            int valor = sc.nextInt();
            sc.nextLine();
            return valor;
        }
        sc.nextLine();
        return -1;
    }

    // ---------------- Ejercicio 1: Operaciones basicas ----------------

    private static void menuOperacionesBasicas(Scanner sc) {
        ListaCircular lista = new ListaCircular();
        int op;
        do {
            System.out.println("\n--- EJERCICIO 1: OPERACIONES BASICAS ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Verificar si esta vacia");
            System.out.println("5. Contar elementos");
            System.out.println("6. Explicacion teorica");
            System.out.println("7. Volver al menu principal");
            System.out.print("Opcion: ");
            op = leerEntero(sc);

            switch (op) {
                case 1:
                    System.out.print("Ingrese valor: ");
                    lista.insertarInicio(leerEntero(sc));
                    break;
                case 2:
                    System.out.print("Ingrese valor: ");
                    lista.insertarFinal(leerEntero(sc));
                    break;
                case 3:
                    lista.mostrar();
                    break;
                case 4:
                    System.out.println("Esta vacia? " + lista.estaVacia());
                    break;
                case 5:
                    System.out.println("Cantidad de elementos: " + lista.contar());
                    break;
                case 6:
                    System.out.println("\nSi el ultimo nodo apuntara a null (como en una lista lineal),");
                    System.out.println("cualquier recorrido que necesite dar varias vueltas terminaria");
                    System.out.println("en NullPointerException al llegar al final. Al apuntar de vuelta");
                    System.out.println("al primer nodo, el recorrido puede continuar indefinidamente.");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (op != 7);
    }

    // ---------------- Ejercicio 2: Insercion y eliminacion ----------------

    private static void menuInsercionEliminacion(Scanner sc) {
        insercioneliminacion.negocio.ListaCircular lista = new insercioneliminacion.negocio.ListaCircular();
        int op;
        do {
            System.out.println("\n--- EJERCICIO 2: INSERCION Y ELIMINACION CONTROLADA ---");
            System.out.println("1. Insertar en posicion");
            System.out.println("2. Eliminar por posicion");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Analisis de casos (vacia / un nodo / varios nodos)");
            System.out.println("6. Volver al menu principal");
            System.out.print("Opcion: ");
            op = leerEntero(sc);

            switch (op) {
                case 1: {
                    System.out.print("Ingrese valor: ");
                    int valor = leerEntero(sc);
                    System.out.print("Ingrese posicion: ");
                    int pos = leerEntero(sc);
                    System.out.print("Antes: ");
                    lista.mostrar();
                    boolean ok = lista.insertarPosicion(valor, pos);
                    System.out.println(ok ? "Insertado." : "Posicion invalida.");
                    System.out.print("Despues: ");
                    lista.mostrar();
                    break;
                }
                case 2: {
                    System.out.print("Ingrese posicion a eliminar: ");
                    int pos = leerEntero(sc);
                    System.out.print("Antes: ");
                    lista.mostrar();
                    boolean ok = lista.eliminarPosicion(pos);
                    System.out.println(ok ? "Eliminado." : "Posicion invalida o lista vacia.");
                    System.out.print("Despues: ");
                    lista.mostrar();
                    break;
                }
                case 3: {
                    System.out.print("Ingrese valor a eliminar: ");
                    int valor = leerEntero(sc);
                    System.out.print("Antes: ");
                    lista.mostrar();
                    boolean ok = lista.eliminarValor(valor);
                    System.out.println(ok ? "Eliminado." : "Valor no encontrado o lista vacia.");
                    System.out.print("Despues: ");
                    lista.mostrar();
                    break;
                }
                case 4:
                    lista.mostrar();
                    break;
                case 5:
                    System.out.println("\nLista vacia: eliminarPosicion()/eliminarValor() devuelven false");
                    System.out.println("sin lanzar excepcion, porque no hay nodo cabeza que recorrer.");
                    System.out.println("Un solo nodo: al eliminarlo, la cabeza pasa a null y la lista");
                    System.out.println("queda vacia (no hay otro nodo al que reapuntar).");
                    System.out.println("Varios nodos: al insertar/eliminar la cabeza, el ultimo nodo");
                    System.out.println("debe actualizar su referencia a la nueva cabeza para no romper el circulo.");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (op != 6);
    }

    // ---------------- Ejercicio 3: Round-Robin ----------------

    private static void menuRoundRobin(Scanner sc) {
        ColaCircularProcesos cola = new ColaCircularProcesos();
        int op;
        do {
            System.out.println("\n--- EJERCICIO 3: SIMULACION ROUND-ROBIN (quantum = 2) ---");
            System.out.println("1. Agregar proceso");
            System.out.println("2. Ejecutar un turno");
            System.out.println("3. Ejecutar simulacion completa");
            System.out.println("4. Mostrar estado de la cola");
            System.out.println("5. Cargar prueba automatica (P1=5, P2=3, P3=7)");
            System.out.println("6. Volver al menu principal");
            System.out.print("Opcion: ");
            op = leerEntero(sc);

            switch (op) {
                case 1: {
                    System.out.print("Nombre del proceso: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tiempo restante: ");
                    int tiempo = leerEntero(sc);
                    cola.agregar(new Proceso(nombre, tiempo));
                    System.out.println("Proceso agregado.");
                    break;
                }
                case 2:
                    cola.ejecutarTurno(2);
                    cola.mostrarEstado();
                    break;
                case 3:
                    if (cola.estaVacia()) {
                        System.out.println("No hay procesos en la cola.");
                        break;
                    }
                    int turno = 0;
                    while (!cola.estaVacia()) {
                        turno++;
                        System.out.println("--- Turno " + turno + " ---");
                        cola.ejecutarTurno(2);
                        cola.mostrarEstado();
                    }
                    System.out.println("Todos los procesos terminaron en " + turno + " turnos.");
                    break;
                case 4:
                    cola.mostrarEstado();
                    break;
                case 5:
                    cola = new ColaCircularProcesos();
                    cola.agregar(new Proceso("P1", 5));
                    cola.agregar(new Proceso("P2", 3));
                    cola.agregar(new Proceso("P3", 7));
                    System.out.println("Procesos P1(5), P2(3) y P3(7) cargados.");
                    cola.mostrarEstado();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (op != 6);
    }

    // ---------------- Ejercicio 4: Josephus ----------------

    private static void menuJosephus(Scanner sc) {
        int op;
        do {
            System.out.println("\n--- EJERCICIO 4: PROBLEMA DE JOSEPHUS ---");
            System.out.println("1. Resolver con n y k personalizados");
            System.out.println("2. Ejecutar los casos requeridos (n=5,k=2 y n=7,k=3)");
            System.out.println("3. Explicacion teorica");
            System.out.println("4. Volver al menu principal");
            System.out.print("Opcion: ");
            op = leerEntero(sc);

            switch (op) {
                case 1: {
                    System.out.print("n (personas): ");
                    int n = leerEntero(sc);
                    System.out.print("k (cada k-esima persona): ");
                    int k = leerEntero(sc);
                    if (n <= 0 || k <= 0) {
                        System.out.println("n y k deben ser positivos.");
                        break;
                    }
                    Josephus.resolver(n, k);
                    break;
                }
                case 2:
                    Josephus.resolver(5, 2);
                    Josephus.resolver(7, 3);
                    break;
                case 3:
                    System.out.println("\nUna lista circular es adecuada porque el problema exige recorrer");
                    System.out.println("el circulo saltando ciclicamente sin importar cuantas vueltas");
                    System.out.println("completas se necesiten, y eliminar un nodo intermedio sin");
                    System.out.println("reconstruir la estructura; con un arreglo habria que desplazar");
                    System.out.println("elementos o marcar posiciones como invalidas.");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (op != 4);
    }

    // ---------------- Ejercicio 5: Playlist circular ----------------

    private static void menuPlaylist(Scanner sc) {
        PlaylistCircular playlist = new PlaylistCircular();
        int op;
        do {
            System.out.println("\n--- EJERCICIO 5: PLAYLIST MUSICAL CIRCULAR ---");
            System.out.println("1. Agregar cancion al inicio");
            System.out.println("2. Agregar cancion al final");
            System.out.println("3. Mostrar playlist");
            System.out.println("4. Reproducir siguiente cancion");
            System.out.println("5. Eliminar cancion por nombre");
            System.out.println("6. Explicacion teorica");
            System.out.println("7. Volver al menu principal");
            System.out.print("Opcion: ");
            op = leerEntero(sc);

            switch (op) {
                case 1:
                    System.out.print("Titulo de la cancion: ");
                    playlist.agregarInicio(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Titulo de la cancion: ");
                    playlist.agregarFinal(sc.nextLine());
                    break;
                case 3:
                    playlist.mostrar();
                    break;
                case 4:
                    playlist.reproducirSiguiente();
                    break;
                case 5:
                    System.out.print("Titulo a eliminar: ");
                    boolean ok = playlist.eliminarPorNombre(sc.nextLine());
                    System.out.println(ok ? "Eliminada." : "No se encontro esa cancion.");
                    break;
                case 6:
                    System.out.println("\nEn una lista lineal, reproducirSiguiente() tendria que detectar");
                    System.out.println("explicitamente el final (siguiente == null) y reiniciar el puntero");
                    System.out.println("a mano. En la circular ese 'reinicio automatico' viene gratis,");
                    System.out.println("dado por la propia estructura: el ultimo nodo ya apunta al primero.");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (op != 7);
    }
}
