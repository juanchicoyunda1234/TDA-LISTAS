# Ejercicio 5 - Playlist musical circular

Playlist de canciones (titulo) en lista circular: agregar al inicio y al
final, mostrar, reproducir la siguiente y eliminar por nombre. Al pasar
la ultima cancion, la siguiente es otra vez la primera, sin reiniciar
el puntero a mano.


## Como llegar

El punto de entrada es `app.Main`. En el menu principal elegir **opcion 5**.

```
--- EJERCICIO 5: PLAYLIST MUSICAL CIRCULAR ---
1. Agregar cancion al inicio
2. Agregar cancion al final
3. Mostrar playlist
4. Reproducir siguiente cancion
5. Eliminar cancion por nombre
6. Explicacion teorica
7. Volver al menu principal
```

## Solucion

| Clase | Paquete | Responsabilidad |
|---|---|---|
| `NodoCancion` | `playlist.modelo` | `titulo` y `siguiente` |
| `PlaylistCircular` | `playlist.negocio` | TDA: `cabeza`, `actual` (en reproduccion) y `cantidad` |

`mostrar()` marca con `*` la cancion `actual`. `reproducirSiguiente()`
avanza `actual = actual.siguiente` y la imprime. Como el ultimo nodo
apunta al primero, ese avance da la vuelta solo.

Si se elimina la cancion que se esta reproduciendo, `actual` pasa a su
siguiente. Si se elimina la cabeza, el ultimo nodo reapunta a la nueva
cabeza. Con una sola cancion, borrar por nombre deja `cabeza` y `actual`
en `null`.

## Pregunta teorica del enunciado

> Que ventaja tiene usar una lista circular frente a una lista lineal?

En una lista lineal, `reproducirSiguiente()` tendria que detectar el
final (`siguiente == null`) y reiniciar el puntero a mano. En la circular
ese reinicio automatico lo da la estructura: el ultimo nodo ya apunta al
primero. Insertar y eliminar en medio siguen siendo O(n) de recorrido,
pero no hace falta desplazar un arreglo.

## Diagrama de clases

`diagramas/diagrama-clases.png` (Mermaid en `diagramas/diagrama-clases.md`).

`PlaylistCircular` agrega `NodoCancion` (dos referencias: `cabeza` y `actual`).

## Corrida verificada

Playlist vacia: `Playlist vacia`. Reproducir vacia:
`Playlist vacia, nada que reproducir`.

Agregar A al inicio, B al final, C al final:

```
A* -> (vuelve a A)
A* -> B -> (vuelve a A)
A* -> B -> C -> (vuelve a A)
```

Tres veces "reproducir siguiente":

```
Reproduciendo ahora: B
Reproduciendo ahora: C
Reproduciendo ahora: A
```

La tercera llamada vuelve sola a A (cierre del circulo). Eliminar `B`:
`A* -> C -> (vuelve a A)`. Titulo inexistente: `No se encontro esa cancion.`
Eliminar A y luego C deja `Playlist vacia`.
