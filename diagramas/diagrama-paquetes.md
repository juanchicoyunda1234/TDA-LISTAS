# Diagrama de paquetes - Listas Circulares

Seis paquetes Java en un solo programa. `app` es el unico punto de entrada.
Cada ejercicio tiene su propio `modelo` y `negocio`; los cinco ejercicios
**no se importan entre si**.

Vista grafica: `diagrama-paquetes.png`.

```mermaid
flowchart TB
    subgraph app [app]
        Main["Main<br/>menu principal y 5 submenus"]
    end

    subgraph ob [operacionesbasicas]
        OB_N["modelo.Nodo"]
        OB_L["negocio.ListaCircular"]
        OB_L --> OB_N
    end

    subgraph ie [insercioneliminacion]
        IE_N["modelo.Nodo"]
        IE_L["negocio.ListaCircular"]
        IE_L --> IE_N
    end

    subgraph rr [roundrobin]
        RR_P["modelo.Proceso"]
        RR_N["modelo.NodoProceso"]
        RR_C["negocio.ColaCircularProcesos"]
        RR_N --> RR_P
        RR_C --> RR_N
    end

    subgraph jo [josephus]
        JO_N["modelo.NodoPersona"]
        JO_J["negocio.Josephus"]
        JO_J --> JO_N
    end

    subgraph pl [playlist]
        PL_N["modelo.NodoCancion"]
        PL_P["negocio.PlaylistCircular"]
        PL_P --> PL_N
    end

    Main --> OB_L
    Main --> IE_L
    Main --> RR_C
    Main --> RR_P
    Main --> JO_J
    Main --> PL_P
```

```mermaid
classDiagram
    direction TB

    namespace app {
        class Main
    }

    namespace operacionesbasicas_modelo {
        class Nodo_ob["Nodo"]
    }
    namespace operacionesbasicas_negocio {
        class ListaCircular_ob["ListaCircular"]
    }

    namespace insercioneliminacion_modelo {
        class Nodo_ie["Nodo"]
    }
    namespace insercioneliminacion_negocio {
        class ListaCircular_ie["ListaCircular"]
    }

    namespace roundrobin_modelo {
        class Proceso
        class NodoProceso
    }
    namespace roundrobin_negocio {
        class ColaCircularProcesos
    }

    namespace josephus_modelo {
        class NodoPersona
    }
    namespace josephus_negocio {
        class Josephus
    }

    namespace playlist_modelo {
        class NodoCancion
    }
    namespace playlist_negocio {
        class PlaylistCircular
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

## Dependencias entre paquetes

| Paquete | Contiene | Depende de |
|---|---|---|
| `operacionesbasicas.modelo` | `Nodo` | nada |
| `operacionesbasicas.negocio` | `ListaCircular` | `operacionesbasicas.modelo` |
| `insercioneliminacion.modelo` | `Nodo` | nada |
| `insercioneliminacion.negocio` | `ListaCircular` | `insercioneliminacion.modelo` |
| `roundrobin.modelo` | `Proceso`, `NodoProceso` | nada |
| `roundrobin.negocio` | `ColaCircularProcesos` | `roundrobin.modelo` |
| `josephus.modelo` | `NodoPersona` | nada |
| `josephus.negocio` | `Josephus` | `josephus.modelo` |
| `playlist.modelo` | `NodoCancion` | nada |
| `playlist.negocio` | `PlaylistCircular` | `playlist.modelo` |
| `app` | `Main` | los cinco `negocio` (y `roundrobin.modelo.Proceso` para instanciar) |

`negocio` nunca importa otro ejercicio. El tipo concreto de nodo lo crea
el TDA de su propio paquete. `Main` solo instancia `Proceso` a mano porque
el enunciado de Round-Robin pide nombre y tiempo restante por teclado.
