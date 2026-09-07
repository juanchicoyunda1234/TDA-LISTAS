# Diagrama de clases - Operaciones basicas

`ListaCircular` administra el circulo de enteros. `Nodo` guarda el dato
y el enlace al siguiente (el ultimo apunta otra vez a la cabeza).

Vista grafica: `diagrama-clases.png`.

Paquetes Java: `operacionesbasicas.modelo` y `operacionesbasicas.negocio`.

```mermaid
classDiagram
    class Nodo {
        +int dato
        +Nodo siguiente
        +Nodo(int)
    }
    class ListaCircular {
        -Nodo cabeza
        -int contador
        +insertarInicio(int) void
        +insertarFinal(int) void
        +mostrar() void
        +estaVacia() boolean
        +contar() int
    }
    ListaCircular o-- Nodo
```
