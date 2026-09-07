# Ejercicio 2 - Insercion y eliminacion controlada

Lista circular de enteros con insercion en una posicion, eliminacion por
posicion y eliminacion por valor. Las posiciones son **base 0**
(0 = cabeza). `insertarPosicion` acepta tambien `posicion == contar()`,
que equivale a insertar al final.


## Como llegar

El punto de entrada es `app.Main`. En el menu principal elegir **opcion 2**.

```
--- EJERCICIO 2: INSERCION Y ELIMINACION CONTROLADA ---
1. Insertar en posicion
2. Eliminar por posicion
3. Eliminar por valor
4. Mostrar lista
5. Analisis de casos (vacia / un nodo / varios nodos)
6. Volver al menu principal
```

El submenu imprime la lista **antes y despues** de insertar o eliminar
(si la operacion falla, el "despues" es el mismo que el "antes").

## Solucion

| Clase | Paquete | Responsabilidad |
|---|---|---|
| `Nodo` | `insercioneliminacion.modelo` | `dato` (int) y `siguiente` |
| `ListaCircular` | `insercioneliminacion.negocio` | TDA con insercion/eliminacion controlada |

`insertarInicio` e `insertarFinal` existen en la clase y las usa
`insertarPosicion` cuando la posicion es 0 o el final. El menu no las
expone por separado porque el enunciado pide posicion especifica.

Si la posicion o el valor no existen, los metodos devuelven `false` y no
lanzan excepcion.

## Analisis solicitado (vacia / un nodo / varios nodos)

- **Lista vacia.** `eliminarPosicion` y `eliminarValor` devuelven `false`
  sin lanzar excepcion: no hay `cabeza` que recorrer. Insertar en
  posicion 0 crea el circulo de un nodo (`siguiente` apunta a si mismo).
  Cualquier otra posicion es invalida.
- **Un solo nodo.** Al eliminarlo, `cabeza` pasa a `null` y `contador` a 0.
  No hay otro nodo al que reapuntar. El circulo desaparece.
- **Varios nodos.** Insertar o eliminar la cabeza obliga a actualizar el
  `siguiente` del ultimo nodo; si no se hace, el circulo queda apuntando
  al nodo viejo y se rompe.

## Diagrama de clases

`diagramas/diagrama-clases.png` (Mermaid en `diagramas/diagrama-clases.md`).

`ListaCircular` agrega `Nodo`. `insertarInicio` e `insertarFinal` son
auxiliares de `insertarPosicion`.

## Corrida verificada

Insertar 10 en 0, 20 en 1, 30 en 1:

```
Antes: Lista vacia
Insertado.
Despues: 10 -> (vuelve a 10)

Antes: 10 -> (vuelve a 10)
Insertado.
Despues: 10 -> 20 -> (vuelve a 10)

Antes: 10 -> 20 -> (vuelve a 10)
Insertado.
Despues: 10 -> 30 -> 20 -> (vuelve a 10)
```

Eliminar posicion 0 y luego el valor 30:

```
Antes: 10 -> 30 -> 20 -> (vuelve a 10)
Eliminado.
Despues: 30 -> 20 -> (vuelve a 30)

Antes: 30 -> 20 -> (vuelve a 30)
Eliminado.
Despues: 20 -> (vuelve a 20)
```

Insertar 40 en posicion 10 (invalida) y eliminar posicion -1: el "despues"
es el mismo que el "antes" (`20 -> (vuelve a 20)`).
