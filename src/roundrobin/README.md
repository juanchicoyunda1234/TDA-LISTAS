# Ejercicio 3 - Simulacion Round-Robin

Cola circular de procesos. Cada proceso tiene nombre y tiempo restante.
El quantum es **2**. Si no termina, la cabeza avanza (el proceso queda
al final del ciclo). Si termina, se elimina del circulo.


## Como llegar

El punto de entrada es `app.Main`. En el menu principal elegir **opcion 3**.

```
--- EJERCICIO 3: SIMULACION ROUND-ROBIN (quantum = 2) ---
1. Agregar proceso
2. Ejecutar un turno
3. Ejecutar simulacion completa
4. Mostrar estado de la cola
5. Cargar prueba automatica (P1=5, P2=3, P3=7)
6. Volver al menu principal
```

La opcion 5 carga el caso de prueba y deja la cola lista para simular.
La opcion 3 corre turnos hasta vaciar la cola y muestra el estado
despues de cada uno.

## Solucion

| Clase | Paquete | Responsabilidad |
|---|---|---|
| `Proceso` | `roundrobin.modelo` | `nombre` y `tiempoRestante` |
| `NodoProceso` | `roundrobin.modelo` | apunta a un `Proceso` y al siguiente nodo |
| `ColaCircularProcesos` | `roundrobin.negocio` | TDA: agregar, un turno, mostrar, vacia |

`ejecutarTurno(quantum)` atiende siempre a la cabeza. Resta
`min(quantum, tiempoRestante)`. Si llega a 0, `eliminarCabeza()` (el
ultimo nodo reapunta a la nueva cabeza). Si no, `rotar()` hace
`cabeza = cabeza.siguiente`, que es equivalente a mandar el proceso al
final sin mover nodos.

`Main` instancia `Proceso` y se lo entrega a `agregar`. Por eso `app`
depende de `roundrobin.modelo` ademas del TDA.

## Diagrama de clases

`diagramas/diagrama-clases.png` (Mermaid en `diagramas/diagrama-clases.md`).

`ColaCircularProcesos` agrega `NodoProceso`; cada nodo agrega un `Proceso`.

## Corrida verificada

Cola vacia: `(cola vacia)`. Simulacion sin procesos: `No hay procesos en la cola.`

Prueba automatica P1=5, P2=3, P3=7, quantum 2:

```
P1(5) -> P2(3) -> P3(7) -> ...
Turno 1  P1 5->3   P2(3) -> P3(7) -> P1(3) -> ...
Turno 2  P2 3->1   P3(7) -> P1(3) -> P2(1) -> ...
Turno 3  P3 7->5   P1(3) -> P2(1) -> P3(5) -> ...
Turno 4  P1 3->1   P2(1) -> P3(5) -> P1(1) -> ...
Turno 5  P2 termina   P3(5) -> P1(1) -> ...
Turno 6  P3 5->3   P1(1) -> P3(3) -> ...
Turno 7  P1 termina   P3(3) -> ...
Turno 8  P3 3->1   P3(1) -> ...
Turno 9  P3 termina   (cola vacia)
Todos los procesos terminaron en 9 turnos.
```
