# Proyecto de Gestión de Inventarios

Proyecto desarrollado para el curso **Estructuras de Datos (SOFT-10)** de la Universidad CENFOTEC, correspondiente al segundo avance del proyecto de gestión de inventarios.

## Descripción

La aplicación simula un sistema de ventas e inventario mediante estructuras de datos dinámicas.

El sistema permite administrar productos, registrar clientes, realizar compras, manejar una cola de atención según prioridad y generar la factura correspondiente al carrito de cada cliente.

## Estructuras de datos utilizadas

### Árbol binario de búsqueda

El inventario de la tienda se administra mediante la clase `ArbolProductos`.

Cada nodo almacena un objeto `Producto` y utiliza el nombre del producto como llave para realizar operaciones de:

- Inserción.
- Búsqueda.
- Eliminación.
- Recorridos en orden, preorden y postorden.

### Lista enlazada

La clase `ListaProductos` se utiliza para almacenar los productos agregados al carrito de cada cliente.

Permite administrar los productos comprados y calcular el costo total de la compra.

### Cola de prioridad

La clase `ColaClientes` administra los clientes pendientes de atención.

Las prioridades utilizadas son:

- `1` - Cliente Básico.
- `2` - Cliente Afiliado.
- `3` - Cliente Premium.

Los clientes con mayor prioridad son atendidos primero. Cuando dos clientes tienen la misma prioridad, se conserva el orden de llegada.

## Clases principales

- `Producto`: representa los productos del inventario.
- `NodoProducto`: nodo utilizado por la lista enlazada de productos.
- `ListaProductos`: administra los productos del carrito.
- `NodoArbolProducto`: representa los nodos del árbol binario de búsqueda.
- `ArbolProductos`: administra el inventario de productos.
- `Cliente`: almacena la información del cliente, su prioridad y su carrito.
- `NodoCliente`: nodo utilizado para administrar la cola de clientes.
- `ColaClientes`: implementa la cola de atención por prioridad.
- `Tienda`: integra el inventario, los clientes y el proceso de compra.
- `Main`: contiene la rutina principal y el menú de interacción con el usuario.

## Funcionalidades

Desde el menú principal se pueden realizar las siguientes operaciones:

1. Agregar productos al inventario.
2. Registrar un cliente y realizar una compra.
3. Mostrar los productos disponibles en el inventario.
4. Mostrar la cola de clientes.
5. Atender al siguiente cliente según su prioridad.
6. Salir del programa.

Durante una compra, los productos son seleccionados directamente desde el inventario de la tienda y la cantidad disponible se actualiza según las unidades adquiridas.

## Ejecución

El programa inicia desde la clase:

`Main.java`

Al ejecutar la rutina `main()`, se inicia automáticamente el menú principal de la aplicación.

## Pruebas

El proyecto incluye clases utilizadas para validar el funcionamiento de las estructuras principales:

- `PruebaArbolProductos.java`
- `PruebaColaClientes.java`
- `PruebaTienda.java`

Estas permiten comprobar operaciones como inserción, búsqueda, eliminación, recorridos del árbol, prioridad de atención de clientes e integración entre inventario y carrito.

## Integrantes

MONICA LUCIA ALVARADO QUIROS
STEVEN GEOVANNY LORIA SEGURA
DANNY ELIECER TREJOS MORALES

## Curso

**Universidad CENFOTEC**
**Curso:** Estructuras de Datos
**Código:** SOFT-10
**Periodo:** C3-2026