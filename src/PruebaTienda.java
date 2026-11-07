public class PruebaTienda {

    public static void main(String[] args) {

        Tienda tienda = new Tienda();

        Producto leche = new Producto(
                "Leche",
                1250,
                "Lacteos",
                "15/12/2026",
                15
        );

        Producto pan = new Producto(
                "Pan",
                800,
                "Panaderia",
                "20/12/2026",
                12
        );

        Producto arroz = new Producto(
                "Arroz",
                950,
                "Granos",
                "No aplica",
                20
        );

        tienda.agregarProducto(leche);
        tienda.agregarProducto(pan);
        tienda.agregarProducto(arroz);

        System.out.println("\n--- INVENTARIO ---");
        tienda.mostrarInventario();

        System.out.println("\n--- BUSQUEDA ---");

        Producto encontrado = tienda.buscarProducto("Pan");

        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.getNombre());
            System.out.println("Precio: " + encontrado.getPrecio());
            System.out.println("Cantidad: " + encontrado.getCantidad());
        }
        System.out.println("\n--- COMPRA ---");

        Producto productoCarrito =
                tienda.prepararProductoCarrito("Leche", 3);

        if (productoCarrito != null) {

            System.out.println(
                    "Producto preparado para carrito: "
                    + productoCarrito.getNombre()
            );

            System.out.println(
                    "Cantidad comprada: "
                    + productoCarrito.getCantidad()
            );

            Producto lecheInventario =
                    tienda.buscarProducto("Leche");

            System.out.println(
                    "Cantidad restante en inventario: "
                    + lecheInventario.getCantidad()
            );
        }
        Producto pruebaExceso =
        tienda.prepararProductoCarrito("Leche", 20);

        if (pruebaExceso == null) {
            System.out.println("Compra rechazada: cantidad no disponible.");
        }

        Producto pruebaInexistente =
        tienda.prepararProductoCarrito("Televisor", 1);

        if (pruebaInexistente == null) {
            System.out.println("Compra rechazada: producto no encontrado.");
        }

        System.out.println("\n--- PRUEBA DEL CARRITO ---");

        ListaProductos carrito = new ListaProductos();

        boolean agregadoLeche =
                tienda.agregarProductoAlCarrito(
                        carrito,
                        "Leche",
                        2
                );

        boolean agregadoPan =
                tienda.agregarProductoAlCarrito(
                        carrito,
                        "Pan",
                        4
                );

        if (agregadoLeche && agregadoPan) {
            System.out.println("Productos agregados al carrito correctamente.");
        }

        System.out.println("\n--- CARRITO ---");
        carrito.mostrarProductos();

        System.out.println("\n--- COSTO DEL CARRITO ---");
        carrito.reporteCostos();

        System.out.println("\n--- INVENTARIO DESPUES DE LAS COMPRAS ---");

        Producto lecheFinal = tienda.buscarProducto("Leche");
        Producto panFinal = tienda.buscarProducto("Pan");

        System.out.println(
                "Leche disponible: " + lecheFinal.getCantidad()
        );

        System.out.println(
                "Pan disponible: " + panFinal.getCantidad()
        );

        System.out.println("\n--- PRUEBA CLIENTES Y COLA ---");

        Cliente cliente1 = new Cliente(
                "Steven",
                "111",
                Cliente.PRIORIDAD_BASICO
        );

        Cliente cliente2 = new Cliente(
                "Monica",
                "222",
                Cliente.PRIORIDAD_PREMIUM
        );

        Cliente cliente3 = new Cliente(
                "Danny",
                "333",
                Cliente.PRIORIDAD_AFILIADO
        );

                // Agregar productos a los carritos desde el inventario
        tienda.agregarProductoAlCarrito(
                cliente1,
                "Leche",
                2
        );

        tienda.agregarProductoAlCarrito(
                cliente2,
                "Pan",
                2
        );

        tienda.agregarProductoAlCarrito(
                cliente3,
                "Arroz",
                3
        );

        // Agregar clientes a la cola
        tienda.encolarCliente(cliente1);
        tienda.encolarCliente(cliente2);
        tienda.encolarCliente(cliente3);

        System.out.println("\n--- COLA DE ATENCION ---");
        tienda.mostrarColaClientes();

        // Ver quién será atendido primero
        System.out.println("\n--- SIGUIENTE CLIENTE ---");

        Cliente siguiente = tienda.verSiguienteCliente();

        if (siguiente != null) {
        System.out.println(
                "Siguiente cliente: " + siguiente.getNombre()
        );
        }

        // Atender al cliente con mayor prioridad
        System.out.println("\n--- ATENDIENDO CLIENTE ---");

        Cliente atendido = tienda.atenderSiguienteCliente();

        if (atendido != null) {

        System.out.println(
                "Cliente atendido: " + atendido.getNombre()
        );

        System.out.println("\n--- FACTURA ---");

        atendido.getCarrito().reporteCostos();
        }






    }



}