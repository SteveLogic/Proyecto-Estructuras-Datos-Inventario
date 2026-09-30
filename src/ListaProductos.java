public class ListaProductos {

    // Atributos
    private NodoProducto primero;

    // Constructor
    public ListaProductos() {
        this.primero = null;
    }
    // Insertar producto al inicio
    public void insertarInicio(Producto producto) {

        NodoProducto nuevo = new NodoProducto(producto);

        nuevo.setSiguiente(primero);
        primero = nuevo;
    }

        // Mostrar productos
    public void mostrarProductos() {

        NodoProducto actual = primero;

        while (actual != null) {

            Producto producto = actual.getProducto();

            System.out.println(
                    producto.getNombre() +
                    " - Precio: " + producto.getPrecio() +
                    " - Cantidad: " + producto.getCantidad()
            );

            actual = actual.getSiguiente();
        }
    }

        // Insertar producto al final
    public void insertarFinal(Producto producto) {

        NodoProducto nuevo = new NodoProducto(producto);

        // Si la lista está vacía
        if (primero == null) {
            primero = nuevo;
            return;
        }

        NodoProducto actual = primero;

        // Recorrer hasta llegar al último nodo
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        // Enlazar el último nodo con el nuevo
        actual.setSiguiente(nuevo);
    }

        // Buscar producto por nombre
    public Producto buscarProducto(String nombre) {

        NodoProducto actual = primero;

        while (actual != null) {

            if (actual.getProducto().getNombre().equalsIgnoreCase(nombre)) {
                return actual.getProducto();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }
    

        // Modificar producto
    public boolean modificarProducto(
            String nombreActual,
            String nuevoNombre,
            double nuevoPrecio,
            String nuevaCategoria,
            String nuevaFechaVencimiento,
            int nuevaCantidad) {

        Producto producto = buscarProducto(nombreActual);

        if (producto == null) {
            return false;
        }

        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setCategoria(nuevaCategoria);
        producto.setFechaVencimiento(nuevaFechaVencimiento);
        producto.setCantidad(nuevaCantidad);

        return true;
    }

        // Eliminar producto
    public boolean eliminarProducto(String nombre) {

        // Si la lista está vacía
        if (primero == null) {
            return false;
        }

        // Si el producto está en el primer nodo
        if (primero.getProducto().getNombre().equalsIgnoreCase(nombre)) {
            primero = primero.getSiguiente();
            return true;
        }

        NodoProducto anterior = primero;
        NodoProducto actual = primero.getSiguiente();

        while (actual != null) {

            if (actual.getProducto().getNombre().equalsIgnoreCase(nombre)) {

                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

        // Agregar imagen a un producto
    public boolean agregarImagenProducto(String nombre, String rutaImagen) {

        Producto producto = buscarProducto(nombre);

        if (producto == null) {
            return false;
        }

        producto.agregarImagen(rutaImagen);
        return true;
    }


        // Reporte de costos
    public void reporteCostos() {

        NodoProducto actual = primero;
        double costoTotalLista = 0;

        while (actual != null) {

            Producto producto = actual.getProducto();

            double costoProducto =
                    producto.getPrecio() * producto.getCantidad();

            System.out.println(
                    producto.getNombre()
                    + " - Precio: " + producto.getPrecio()
                    + " - Cantidad: " + producto.getCantidad()
                    + " - Costo total: " + costoProducto
            );

            costoTotalLista += costoProducto;

            actual = actual.getSiguiente();
        }

        System.out.println(
                "Costo total de la lista: " + costoTotalLista
        );
    }





}