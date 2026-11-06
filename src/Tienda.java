public class Tienda {

    // Atributos
    private ArbolProductos inventario;

    // Constructor
    public Tienda() {
        this.inventario = new ArbolProductos();
    }

    // Agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        inventario.insertar(producto);
    }

    // Buscar un producto en el inventario
    public Producto buscarProducto(String nombre) {

        NodoArbolProducto nodo = inventario.buscar(nombre);

        if (nodo == null) {
            return null;
        }

        return nodo.getProducto();
    }

    // Mostrar los productos del inventario
    public void mostrarInventario() {
        inventario.enOrden();
    }

    // Getter
    public ArbolProductos getInventario() {
        return inventario;
    }
    // Preparar un producto para agregarlo al carrito
    public Producto prepararProductoCarrito(String nombre, int cantidad) {

        Producto productoInventario = buscarProducto(nombre);

        // Verificar que el producto exista
        if (productoInventario == null) {
            return null;
        }

        // Verificar que la cantidad sea válida
        if (cantidad <= 0) {
            return null;
        }

        // Verificar que exista suficiente inventario
        if (cantidad > productoInventario.getCantidad()) {
            return null;
        }

        // Crear un producto independiente para el carrito
        Producto productoCarrito = new Producto(
                productoInventario.getNombre(),
                productoInventario.getPrecio(),
                productoInventario.getCategoria(),
                productoInventario.getFechaVencimiento(),
                cantidad
        );

        // Descontar del inventario
        productoInventario.setCantidad(
                productoInventario.getCantidad() - cantidad
        );

        return productoCarrito;
    }

        // Agregar un producto del inventario a un carrito
    public boolean agregarProductoAlCarrito(
            ListaProductos carrito,
            String nombre,
            int cantidad) {

        Producto productoCarrito =
                prepararProductoCarrito(nombre, cantidad);

        if (productoCarrito == null) {
            return false;
        }

        carrito.insertarFinal(productoCarrito);

        return true;
    }


}