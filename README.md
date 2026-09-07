# Listas Circulares - Estructura de Datos (UTA, Nivel III)

Deber individual de **Juan Carlos Chico**: cinco ejercicios sobre listas
simplemente enlazadas circulares, en Java. Un solo programa y un solo
punto de entrada (`app.Main`), con un menu principal que abre un submenu
interactivo por ejercicio.

## Descripcion

Cada ejercicio reutiliza la misma idea (el ultimo nodo apunta al primero)
en un dominio distinto. Para que clases homonimas (`Nodo`, `ListaCircular`)
no choquen, cada ejercicio es un paquete Java real (`modelo` + `negocio`).
`app` es el sexto paquete: solo presenta el menu y despacha.

| Menu | Paquete | Que resuelve |
|---|---|---|
| 1 | `operacionesbasicas` | Insertar al inicio y al final, mostrar, vacia, contar |
| 2 | `insercioneliminacion` | Insertar y eliminar por posicion y por valor |
| 3 | `roundrobin` | Cola circular de procesos, quantum = 2 |
| 4 | `josephus` | Eliminar cada k-esima persona hasta un superviviente |
| 5 | `playlist` | Playlist musical que vuelve sola a la primera cancion |

La especificacion de la solucion (clases, pregunta teorica y corrida
verificada) esta en el `README.md` de ese mismo paquete.

## Solucion propuesta

`Main` no implementa las listas: lee el teclado y llama al TDA de cada
paquete. La circularidad se resuelve igual en todos: un puntero `cabeza`
y, al insertar o borrar, el ultimo nodo se reengancha a la nueva cabeza
para no romper el circulo.

| Capa | Responsabilidad |
|---|---|
| `modelo` | El nodo (y en Round-Robin tambien `Proceso`) |
| `negocio` | El TDA circular de ese ejercicio |
| `app` | Menu principal y cinco submenus |

Los cinco paquetes de ejercicio **no se importan entre si**. Solo `app.Main`
los usa.

## Estructura del proyecto

```
ListasCirculares/
  README.md                         (este archivo)
  diagramas/
    diagrama-paquetes.md / .png     (vision global de los 6 paquetes)
    diagrama-clases.md / .png       (todas las clases, por paquete)
  src/
    app/                            menu unico (opcion 1 a 5)
    operacionesbasicas/             ejercicio 1
    insercioneliminacion/           ejercicio 2
    roundrobin/                     ejercicio 3
    josephus/                       ejercicio 4
    playlist/                       ejercicio 5
```

Cada carpeta de ejercicio contiene:

```
README.md                 especificacion de la solucion
modelo/                   clases del dominio
negocio/                  el TDA
diagramas/                diagrama de clases de ese ejercicio
```

## Diagramas

- Diagrama de paquetes (el que muestra como se relacionan los 6 paquetes):
  `diagramas/diagrama-paquetes.md` y `diagramas/diagrama-paquetes.png`
- Diagrama de clases global:
  `diagramas/diagrama-clases.md` y `diagramas/diagrama-clases.png`
- Diagrama de clases de cada ejercicio:
  `src/<paquete>/diagramas/diagrama-clases.md` y `.png`

## Como ejecutar

Desde esta carpeta (`ListasCirculares`), la que contiene `src/` y este README.

### Windows (PowerShell)

```powershell
$javaFiles = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
if (Test-Path bin) { Remove-Item -Recurse -Force bin }
New-Item -ItemType Directory -Path bin | Out-Null
javac -d bin $javaFiles
java -cp bin app.Main
```

### Linux / macOS

```bash
mkdir -p bin
find src -name "*.java" -print > sources.txt
javac -d bin @sources.txt
java -cp bin app.Main
```

El menu principal ofrece las opciones 1 a 5 (ejercicios) y 6 (salir).
Cada ejercicio tiene su propio submenu y una opcion para volver.

## Autor

| Rol | Integrante |
|---|---|
| Autor | Juan Carlos Chico |
