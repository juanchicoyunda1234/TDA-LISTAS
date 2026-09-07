# Ejercicio 1 - Operaciones basicas sobre lista circular

Lista simplemente enlazada circular de enteros: insertar al inicio,
insertar al final, mostrar, preguntar si esta vacia y contar.


## Como llegar

No hay un `Main` en este paquete. El punto de entrada del programa es
`app.Main`. En el menu principal elegir **opcion 1**.

```
--- EJERCICIO 1: OPERACIONES BASICAS ---
1. Insertar al inicio
2. Insertar al final
3. Mostrar elementos
4. Verificar si esta vacia
5. Contar elementos
6. Explicacion teorica
7. Volver al menu principal
```

## Solucion

| Clase | Paquete | Responsabilidad |
|---|---|---|
| `Nodo` | `operacionesbasicas.modelo` | `dato` (int) y `siguiente` |
| `ListaCircular` | `operacionesbasicas.negocio` | TDA: `cabeza`, `contador` y las cinco operaciones |

Un solo nodo se apunta a si mismo (`nuevo.siguiente = nuevo`). Con varios
nodos, `obtenerUltimo()` camina hasta el que apunta a `cabeza` y ese es
el que hay que actualizar al insertar al inicio (el nuevo pasa a ser
cabeza y el ultimo debe apuntarla).

`contar()` devuelve el `contador` que se incrementa en cada insercion.
`mostrar()` recorre con un `do-while` hasta volver a `cabeza` y escribe
`(vuelve a X)` para dejar visible el circulo.

## Pregunta teorica del enunciado

> Explique con un ejemplo por que en una lista circular el ultimo nodo
> debe apuntar al primero.

Si el ultimo apuntara a `null` (lista lineal), un recorrido que necesite
dar varias vueltas terminaria en `NullPointerException` al llegar al
final. Al apuntar de vuelta al primer nodo, el recorrido puede continuar
indefinidamente: esa es la propiedad que usan Round-Robin, Josephus y la
playlist en los otros ejercicios.

## Diagrama de clases

`diagramas/diagrama-clases.png` (Mermaid en `diagramas/diagrama-clases.md`).

`ListaCircular` agrega `Nodo`.

## Corrida verificada

Lista vacia: `Esta vacia? true`, `Cantidad de elementos: 0`, `Lista vacia`.

Insertar 10 al inicio, 20 al inicio y 30 al final:

```
20 -> 10 -> 30 -> (vuelve a 20)
Cantidad de elementos: 3
Esta vacia? false
```
