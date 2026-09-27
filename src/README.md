# Sistema de Gestión de Inventario con Árbol Binario de Búsqueda (BST)

Un sistema de consola en Java que implementa una estructura de datos de **Árbol Binario de Búsqueda (BST)** para gestionar un inventario de productos. Cada producto se almacena como un nodo dentro del árbol, utilizando su **ID** como clave única de ordenamiento.

---

## 📌 Características Principales

- **Registro de productos**: Inserta elementos en el árbol organizándolos de manera jerárquica ($ID_{izq} < ID_{nodo} < ID_{der}$).
- **Listado ordenado (Inorden)**: Muestra la lista completa de productos ordenada de menor a mayor por su ID.
- **Búsqueda eficiente**: Localiza un producto por su ID en tiempo logarítmico promedio ($\mathcal{O}(\log n)$).
- **Manejo de excepciones**: Control de entradas no numéricas o inválidas en la consola.

---

## 🏗️ Estructura del Código

El proyecto consta de 3 clases principales:

| Clase | Descripción |
| :--- | :--- |
| `Producto.java` | Funciona como el **nodo** del árbol. Almacena las propiedades del producto (`id` y `nombre`) junto con las referencias a sus nodos hijos (`izquierdo` y `derecho`). |
| `ArbolInventario.java` | Implementa la lógica del **Árbol Binario de Búsqueda (BST)**. Contiene los métodos recursivos para inserción, recorrido inorden y búsqueda. |
| `Main.java` | Punto de entrada del programa. Administra el menú interactivo en consola, la entrada del usuario mediante `Scanner` y el manejo de errores. |

---

## 📂 Organización de Archivos

```text
.
├── Main.java
├── ArbolInventario.java
└── Producto.java
```

---

## ⚙️ Requisitos e Instalación

- **Java Development Kit (JDK)** versión 8 o superior.

### Compilación y Ejecución

1. Clona o descarga los archivos en una misma carpeta.
2. Abre una terminal dentro de esa ubicación.
3. Compila las tres clases:

```bash
javac Main.java ArbolInventario.java Producto.java
```

4. Ejecuta el programa:

```bash
java Main
```

---

## 💻 Menú interactivo

Al ejecutar la aplicación, se desplegará el siguiente menú en la consola:

```text
--- INVENTARIO DE PRODUCTOS ---
1. Registrar Producto
2. Ver Inventario Inorden
3. Buscar Producto
0. Salir
Seleccione una opción:
```

### Funcionalidades:

1. **Registrar Producto**: Solicita un ID entero y el Nombre del producto. Inserta el nuevo nodo en el lugar que le corresponde dentro del árbol.
2. **Ver Inventario Inorden**: Imprime todos los registros siguiendo la secuencia `Izquierda -> Raíz -> Derecha`, lo que garantiza una lectura ordenada de los ID de menor a mayor.
3. **Buscar Producto**: Permite consultar si un determinado ID existe en el sistema sin necesidad de recorrer todo el inventario.
0. **Salir**: Finaliza la ejecución de la aplicación.


