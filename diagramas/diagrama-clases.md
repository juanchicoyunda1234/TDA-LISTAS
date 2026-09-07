# Diagrama de clases global - Listas Circulares

Todas las clases del programa, agrupadas por paquete. Hay dos `Nodo` y
dos `ListaCircular` porque el ejercicio 1 y el 2 son paquetes distintos:
no comparten codigo.

Vista grafica: `diagrama-clases.png`.

Los diagramas de cada ejercicio (mas detallados, con todos los metodos)
siguen en `src/<paquete>/diagramas/`.

```mermaid
classDiagram
    direction TB

    class Main {
        +main(String[])$ void
        -leerEntero(Scanner)$ int
        -menuOperacionesBasicas(Scanner)$ void
        -menuInsercionEliminacion(Scanner)$ void
        -menuRoundRobin(Scanner)$ void
        -menuJosephus(Scanner)$ void
        -menuPlaylist(Scanner)$ void
    }

    class Nodo_ob["operacionesbasicas.modelo.Nodo"] {
        +int dato
        +Nodo siguiente
        +Nodo(int)
    }
    class ListaCircular_ob["operacionesbasicas.negocio.ListaCircular"] {
        -Nodo cabeza
        -int contador
        +insertarInicio(int) void
        +insertarFinal(int) void
        +mostrar() void
        +estaVacia() boolean
        +contar() int
    }

    class Nodo_ie["insercioneliminacion.modelo.Nodo"] {
        +int dato
        +Nodo siguiente
        +Nodo(int)
    }
    class ListaCircular_ie["insercioneliminacion.negocio.ListaCircular"] {
        -Nodo cabeza
        -int contador
        +insertarInicio(int) void
        +insertarFinal(int) void
        +insertarPosicion(int, int) boolean
        +eliminarPosicion(int) boolean
        +eliminarValor(int) boolean
        +mostrar() void
        +estaVacia() boolean
        +contar() int
    }

    class Proceso {
        +String nombre
        +int tiempoRestante
        +Proceso(String, int)
    }
    class NodoProceso {
        +Proceso proceso
        +NodoProceso siguiente
        +NodoProceso(Proceso)
    }
    class ColaCircularProcesos {
        -NodoProceso cabeza
        -int cantidad
        +agregar(Proceso) void
        +ejecutarTurno(int) void
        +mostrarEstado() void
        +estaVacia() boolean
    }

    class NodoPersona {
        +int id
        +NodoPersona siguiente
        +NodoPersona(int)
    }
    class Josephus {
        +resolver(int, int)$ int
    }

    class NodoCancion {
        +String titulo
        +NodoCancion siguiente
        +NodoCancion(String)
    }
    class PlaylistCircular {
        -NodoCancion cabeza
        -NodoCancion actual
        -int cantidad
        +agregarInicio(String) void
        +agregarFinal(String) void
        +eliminarPorNombre(String) boolean
        +reproducirSiguiente() void
        +mostrar() void
    }

    ListaCircular_ob o-- Nodo_ob
    ListaCircular_ie o-- Nodo_ie
    NodoProceso o-- Proceso
    ColaCircularProcesos o-- NodoProceso
    Josephus ..> NodoPersona
    PlaylistCircular o-- NodoCancion

    Main ..> ListaCircular_ob
    Main ..> ListaCircular_ie
    Main ..> ColaCircularProcesos
    Main ..> Proceso
    Main ..> Josephus
    Main ..> PlaylistCircular
```

## Relaciones

| Desde | Hasta | Tipo | Por que |
|---|---|---|---|
| `ListaCircular` (ej. 1 y 2) | `Nodo` | agregacion | la lista posee los nodos del circulo |
| `ColaCircularProcesos` | `NodoProceso` | agregacion | la cola posee los nodos |
| `NodoProceso` | `Proceso` | agregacion | el nodo guarda el proceso |
| `PlaylistCircular` | `NodoCancion` | agregacion | la playlist posee las canciones |
| `Josephus` | `NodoPersona` | dependencia | clase utilitaria: crea el circulo, no lo guarda como campo |
| `Main` | cada TDA | dependencia | instancia y llama; no hereda ni agrega |
