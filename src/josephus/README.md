# Ejercicio 4 - Problema de Josephus

`n` personas en circulo. Se elimina cada `k`-esima hasta que queda una.
Se muestra el orden de eliminacion y el superviviente.


## Como llegar

El punto de entrada es `app.Main`. En el menu principal elegir **opcion 4**.

```
--- EJERCICIO 4: PROBLEMA DE JOSEPHUS ---
1. Resolver con n y k personalizados
2. Ejecutar los casos requeridos (n=5,k=2 y n=7,k=3)
3. Explicacion teorica
4. Volver al menu principal
```

La opcion 2 corre los dos casos que pide el enunciado. `n` y `k` deben
ser positivos; si no, el menu no llama a `resolver`.

## Solucion

| Clase | Paquete | Responsabilidad |
|---|---|---|
| `NodoPersona` | `josephus.modelo` | `id` (1..n) y `siguiente` |
| `Josephus` | `josephus.negocio` | clase utilitaria: arma el circulo y elimina |

`Josephus` no guarda la lista como campo: `resolver(n, k)` construye el
circulo, cuenta `k` pasos, desenlaza el nodo y sigue desde el siguiente
hasta que `restantes == 1`. Devuelve el id del superviviente y ademas lo
imprime.

Las personas se numeran desde 1. El conteo empieza en la persona 1.

## Pregunta teorica del enunciado

> Por que una lista circular es una estructura adecuada para este problema?

Porque hay que recorrer el circulo saltando de forma ciclica, sin
importar cuantas vueltas completas hagan falta, y hay que eliminar un
nodo intermedio sin reconstruir la estructura. Con un arreglo habria que
desplazar elementos o marcar posiciones como invalidas cada vez que
alguien sale.

## Diagrama de clases

`diagramas/diagrama-clases.png` (Mermaid en `diagramas/diagrama-clases.md`).

`Josephus` **usa** `NodoPersona` (dependencia): no lo agrega como
atributo permanente.

## Corrida verificada

Casos del enunciado (opcion 2):

```
n=5, k=2
  Se elimina: 2
  Se elimina: 4
  Se elimina: 1
  Se elimina: 5
  Sobreviviente: 3

n=7, k=3
  Se elimina: 3
  Se elimina: 6
  Se elimina: 2
  Se elimina: 7
  Se elimina: 5
  Se elimina: 1
  Sobreviviente: 4
```

`n=1, k=1` (opcion 1): `Sobreviviente: 1`. `n=0` o `k=0`: el menu
responde `n y k deben ser positivos` y no entra a `resolver`.
