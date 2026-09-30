public class Main {

    public static void main(String[] args) {

        Producto producto1 = new Producto(
                "Leche",
                1250,
                "Lacteos",
                "15/10/2026",
                10
        );

        Producto producto2 = new Producto(
                "Arroz",
                950,
                "Granos",
                "20/12/2026",
                15
        );

        Producto producto3 = new Producto(
                "Cafe",
                2500,
                "Bebidas",
                "10/01/2027",
                8
        );

        Producto producto4 = new Producto(
                "Pan",
                800,
                "Panaderia",
                "05/10/2026",
                12
        );
        

        ListaProductos lista = new ListaProductos();

        lista.insertarInicio(producto1);
        lista.insertarInicio(producto2);
        lista.insertarInicio(producto3);
        lista.insertarFinal(producto4);

        lista.mostrarProductos();

        Producto encontrado = lista.buscarProducto("Arroz");

            if (encontrado != null) {
                System.out.println("Producto encontrado: " + encontrado.getNombre());
            } else {
                System.out.println("Producto no encontrado.");
            }

            boolean modificado = lista.modificarProducto(
                    "Arroz",
                    "Arroz Integral",
                    1200,
                    "Granos",
                    "25/12/2026",
                    20
            );

            if (modificado) {
                System.out.println("Producto modificado correctamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            lista.mostrarProductos();

            boolean eliminado = lista.eliminarProducto("Leche");

                if (eliminado) {
                    System.out.println("Producto eliminado correctamente.");
                } else {
                    System.out.println("Producto no encontrado.");
                }

                lista.mostrarProductos();

            boolean eliminadoPrimero = lista.eliminarProducto("Cafe");

                if (eliminadoPrimero) {
                    System.out.println("Primer producto eliminado correctamente.");
                } else {
                    System.out.println("Producto no encontrado.");
                }

                lista.mostrarProductos();


            boolean imagenAgregada = lista.agregarImagenProducto(
                        "Pan",
                        "imagenes/pan1.jpg"
                );

                if (imagenAgregada) {
                    System.out.println("Imagen agregada correctamente.");
                } else {
                    System.out.println("Producto no encontrado.");
                }

                Producto productoConImagen = lista.buscarProducto("Pan");

                if (productoConImagen != null) {
                    System.out.println(
                            "Imagenes de Pan: " + productoConImagen.getListaImagenes()
                    );
                }

                System.out.println("\n--- REPORTE DE COSTOS ---");
                lista.reporteCostos();




    }

    

    

    

    
}

