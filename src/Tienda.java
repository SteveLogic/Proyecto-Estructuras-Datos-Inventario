public class Tienda {

    // Atributos
    private ArbolProductos inventario;
    private ColaClientes colaClientes;

    // Constructor
    public Tienda() {
        this.inventario = new ArbolProductos();
        this.colaClientes = new ColaClientes();
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
    // Agregar un cliente a la cola de atención
    public void encolarCliente(Cliente cliente) {
        colaClientes.encolar(cliente);
    }

    // Ver el próximo cliente sin retirarlo
    public Cliente verSiguienteCliente() {
        return colaClientes.verSiguiente();
    }

    // Atender al siguiente cliente
    public Cliente atenderSiguienteCliente() {
        return colaClientes.atender();
    }

    // Mostrar la cola de clientes
    public void mostrarColaClientes() {
        colaClientes.mostrarCola();
    }

    // Obtener la cola de clientes
    public ColaClientes getColaClientes() {
        return colaClientes;
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
        // Agregar un producto del inventario al carrito de un cliente
    public boolean agregarProductoAlCarrito(
            Cliente cliente,
            String nombre,
            int cantidad) {

        Producto productoCarrito =
                prepararProductoCarrito(nombre, cantidad);

        if (productoCarrito == null) {
            return false;
        }

        cliente.agregarAlCarrito(productoCarrito);

        return true;
    }


}