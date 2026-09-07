# Paquete `app` - punto de entrada

Menu de consola que une los cinco ejercicios de listas circulares.
Este paquete **no** contiene ningun TDA: solo lee el teclado y llama a
las clases de `negocio` (y a `roundrobin.modelo.Proceso` para crear
procesos).

## Como llegar

Compilar y ejecutar desde la raiz del proyecto (ver el README general).
El programa arranca aqui:

```
java -cp bin app.Main
```

```
==========================================
     MENU PRINCIPAL - LISTAS CIRCULARES
==========================================
1. Operaciones basicas sobre lista circular
2. Insercion y eliminacion controlada
3. Simulacion Round-Robin
4. Problema de Josephus
5. Playlist musical circular
6. Salir
```

| Opcion | Paquete que atiende |
|---|---|
| 1 | `operacionesbasicas` |
| 2 | `insercioneliminacion` |
| 3 | `roundrobin` |
| 4 | `josephus` |
| 5 | `playlist` |
| 6 | cierra el `Scanner` y termina |

Cada submenu tiene su propia opcion "Volver al menu principal". La lista
(o cola, o playlist) de ese submenu se crea al entrar y se pierde al
volver: no hay estado compartido entre ejercicios.

## Clases

| Clase | Responsabilidad |
|---|---|
| `Main` | `main`, lectura de enteros y los cinco submenus |

`leerEntero` consume la linea. Si el usuario no escribe un entero,
devuelve `-1` (el menu lo trata como opcion invalida). Asi no se cae el
programa con `InputMismatchException`.

## Diagramas

`Main` aparece en el diagrama de paquetes y en el de clases global:

- `diagramas/diagrama-paquetes.png` (raiz del proyecto)
- `diagramas/diagrama-clases.png` (raiz del proyecto)
