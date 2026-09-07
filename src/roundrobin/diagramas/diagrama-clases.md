# Diagrama de clases - Round-Robin

`ColaCircularProcesos` es el TDA. Cada `NodoProceso` guarda un `Proceso`
(nombre y tiempo restante) y el enlace al siguiente. El quantum lo recibe
`ejecutarTurno`; no es un campo de la cola.

Vista grafica: `diagrama-clases.png`.

Paquetes Java: `roundrobin.modelo` y `roundrobin.negocio`.

```mermaid
classDiagram
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
    NodoProceso o-- Proceso
    ColaCircularProcesos o-- NodoProceso
```
