# Proyecto de Gestión de Inventarios

Proyecto final del curso Estructuras de Datos.

Universidad CENFOTEC  
Curso: Estructuras de Datos  
Periodo: C3-2026

MONICA LUCIA ALVARADO QUIROS
STEVEN GEOVANNY LORIA SEGURA
DANNY ELIECER TREJOS MORALES

## Descripción

Este proyecto consiste en un sistema de gestión de inventarios desarrollado en Java. El programa permite administrar productos utilizando una lista enlazada simple como estructura principal.

Cada producto almacena información como nombre, precio, categoría, fecha de vencimiento y cantidad. Además, permite asociar varias imágenes a un mismo producto mediante una lista dinámica de rutas.

## Funcionalidades

El sistema permite:

- Insertar productos al inicio de la lista.
- Insertar productos al final de la lista.
- Mostrar los productos registrados.
- Buscar productos por nombre.
- Modificar la información de un producto.
- Eliminar productos.
- Asociar varias imágenes a un producto.
- Verificar que las rutas de las imágenes existan.
- Generar un reporte con el costo de cada producto y el costo total del inventario.
- Validar los datos ingresados por el usuario.

## Estructuras utilizadas

Para almacenar los productos se utiliza una lista enlazada simple implementada mediante las clases `ListaProductos` y `NodoProducto`.

Las rutas de las imágenes asociadas a cada producto se almacenan utilizando un `ArrayList<String>`.

## Organización del proyecto

- `Producto.java`: contiene los datos y métodos relacionados con cada producto.
- `NodoProducto.java`: representa los nodos de la lista enlazada.
- `ListaProductos.java`: contiene las operaciones de la lista enlazada.
- `Main.java`: contiene el menú principal, la interacción con el usuario y las validaciones.
- `imagenes/`: contiene las imágenes utilizadas para las pruebas del sistema.

## Ejecución

Para ejecutar el programa se debe correr la clase `Main.java`. El sistema mostrará un menú en consola desde el cual se pueden utilizar las diferentes funcionalidades del inventario.