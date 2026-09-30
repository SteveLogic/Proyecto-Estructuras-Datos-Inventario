import java.util.Scanner;

public class Main {

    // Colores ANSI
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";
    public static final String VERDE = "\u001B[32m";
    public static final String CIAN = "\u001B[36m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String ROJO = "\u001B[31m";
    public static final String MORADO = "\u001B[35m";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        ListaProductos lista = new ListaProductos();

        int opcion;

        do {

            limpiarPantalla();

            System.out.println(AZUL + "=================================" + RESET);
            System.out.println(AZUL + "   SISTEMA DE GESTION DE INVENTARIO" + RESET);
            System.out.println(AZUL + "=================================" + RESET);
            System.out.println("1. Insertar producto al inicio");
            System.out.println("2. Insertar producto al final");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Buscar producto");
            System.out.println("5. Modificar producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Agregar imagen a producto");
            System.out.println("8. Reporte de costos");
            System.out.println("9. Salir");
            System.out.println(AZUL + "=================================" + RESET);
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    limpiarPantalla();

                    System.out.println(VERDE + "=================================" + RESET);
                    System.out.println(VERDE + "   INSERTAR PRODUCTO AL INICIO" + RESET);
                    System.out.println(VERDE + "=================================" + RESET);

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Fecha de vencimiento (ENTER si no aplica): ");
                    String fechaVencimiento = scanner.nextLine();

                    if (fechaVencimiento.isBlank()) {
                        fechaVencimiento = "No aplica";
                    }

                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());

                    Producto nuevoProducto = new Producto(
                            nombre,
                            precio,
                            categoria,
                            fechaVencimiento,
                            cantidad
                    );

                    lista.insertarInicio(nuevoProducto);

                    System.out.println(
                            VERDE + "\nProducto agregado correctamente." + RESET
                    );

                    pausar(scanner);
                    break;
                case 2:
                    limpiarPantalla();

                    System.out.println(VERDE + "=================================" + RESET);
                    System.out.println(VERDE + "    INSERTAR PRODUCTO AL FINAL" + RESET);
                    System.out.println(VERDE + "=================================" + RESET);

                    System.out.print("Nombre: ");
                    String nombreFinal = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precioFinal = Double.parseDouble(scanner.nextLine());

                    System.out.print("Categoria: ");
                    String categoriaFinal = scanner.nextLine();

                    System.out.print("Fecha de vencimiento (ENTER si no aplica): ");
                    String fechaVencimientoFinal = scanner.nextLine();

                    if (fechaVencimientoFinal.isBlank()) {
                        fechaVencimientoFinal = "No aplica";
                    }

                    System.out.print("Cantidad: ");
                    int cantidadFinal = Integer.parseInt(scanner.nextLine());

                    Producto productoFinal = new Producto(
                            nombreFinal,
                            precioFinal,
                            categoriaFinal,
                            fechaVencimientoFinal,
                            cantidadFinal
                    );

                    lista.insertarFinal(productoFinal);

                    System.out.println(
                            VERDE + "\nProducto agregado correctamente al final." + RESET
                    );

                    pausar(scanner);
                    break;

                case 3:
                    limpiarPantalla();

                    System.out.println(CIAN + "=================================" + RESET);
                    System.out.println(CIAN + "        MOSTRAR PRODUCTOS" + RESET);
                    System.out.println(CIAN + "=================================" + RESET);

                    lista.mostrarProductos();

                    pausar(scanner);
                    break;
                case 4:
                    limpiarPantalla();

                    System.out.println(CIAN + "=================================" + RESET);
                    System.out.println(CIAN + "         BUSCAR PRODUCTO" + RESET);
                    System.out.println(CIAN + "=================================" + RESET);

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreBusqueda = scanner.nextLine();

                    Producto productoEncontrado = lista.buscarProducto(nombreBusqueda);

                    if (productoEncontrado != null) {

                        System.out.println(CIAN + "\nProducto encontrado:" + RESET);
                        System.out.println("Nombre: " + productoEncontrado.getNombre());
                        System.out.println("Precio: " + productoEncontrado.getPrecio());
                        System.out.println("Categoria: " + productoEncontrado.getCategoria());
                        System.out.println(
                                "Fecha de vencimiento: "
                                        + productoEncontrado.getFechaVencimiento()
                        );
                        System.out.println("Cantidad: " + productoEncontrado.getCantidad());
                        System.out.println(
                                "Imagenes: " + productoEncontrado.getListaImagenes()
                        );

                    } else {
                        System.out.println(
                                ROJO + "\nProducto no encontrado." + RESET
                        );
                    }

                    pausar(scanner);
                    break;
                case 5:
                    limpiarPantalla();

                    System.out.println(AMARILLO + "=================================" + RESET);
                    System.out.println(AMARILLO + "       MODIFICAR PRODUCTO" + RESET);
                    System.out.println(AMARILLO + "=================================" + RESET);

                    System.out.print("Ingrese el nombre del producto a modificar: ");
                    String nombreActual = scanner.nextLine();

                    Producto productoModificar = lista.buscarProducto(nombreActual);

                    if (productoModificar == null) {

                        System.out.println(
                                ROJO + "\nProducto no encontrado." + RESET
                        );

                    } else {

                        System.out.println(
                                AMARILLO + "\nProducto encontrado." + RESET
                        );

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                        System.out.print("Nueva categoria: ");
                        String nuevaCategoria = scanner.nextLine();

                        System.out.print(
                                "Nueva fecha de vencimiento (ENTER si no aplica): "
                        );
                        String nuevaFechaVencimiento = scanner.nextLine();

                        if (nuevaFechaVencimiento.isBlank()) {
                            nuevaFechaVencimiento = "No aplica";
                        }

                        System.out.print("Nueva cantidad: ");
                        int nuevaCantidad = Integer.parseInt(scanner.nextLine());

                        boolean modificado = lista.modificarProducto(
                                nombreActual,
                                nuevoNombre,
                                nuevoPrecio,
                                nuevaCategoria,
                                nuevaFechaVencimiento,
                                nuevaCantidad
                        );

                        if (modificado) {
                            System.out.println(
                                    VERDE + "\nProducto modificado correctamente." + RESET
                            );
                        }
                    }

                    pausar(scanner);
                    break;

                case 6:
                    limpiarPantalla();

                    System.out.println(ROJO + "=================================" + RESET);
                    System.out.println(ROJO + "        ELIMINAR PRODUCTO" + RESET);
                    System.out.println(ROJO + "=================================" + RESET);

                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    Producto productoEliminar = lista.buscarProducto(nombreEliminar);

                    if (productoEliminar == null) {

                        System.out.println(
                                ROJO + "\nProducto no encontrado." + RESET
                        );

                    } else {

                        System.out.println("\nProducto encontrado:");
                        System.out.println("Nombre: " + productoEliminar.getNombre());
                        System.out.println("Precio: " + productoEliminar.getPrecio());
                        System.out.println("Categoria: " + productoEliminar.getCategoria());
                        System.out.println("Cantidad: " + productoEliminar.getCantidad());

                        System.out.print(
                                "\n¿Esta seguro de que desea eliminar este producto? (S/N): "
                        );

                        String confirmacion = scanner.nextLine();

                        if (confirmacion.equalsIgnoreCase("S")) {

                            boolean eliminado = lista.eliminarProducto(nombreEliminar);

                            if (eliminado) {
                                System.out.println(
                                        VERDE + "\nProducto eliminado correctamente." + RESET
                                );
                            }

                        } else {
                            System.out.println(
                                    AMARILLO + "\nOperacion cancelada." + RESET
                            );
                        }
                    }

                    pausar(scanner);
                    break;
                case 7:
                    limpiarPantalla();

                    System.out.println(MORADO + "=================================" + RESET);
                    System.out.println(MORADO + "     AGREGAR IMAGEN A PRODUCTO" + RESET);
                    System.out.println(MORADO + "=================================" + RESET);

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreImagen = scanner.nextLine();

                    Producto productoImagen = lista.buscarProducto(nombreImagen);

                    if (productoImagen == null) {

                        System.out.println(
                                ROJO + "\nProducto no encontrado." + RESET
                        );

                    } else {

                        System.out.println(
                                MORADO + "\nProducto encontrado: "
                                + productoImagen.getNombre() + RESET
                        );

                        System.out.print(
                                "Ingrese la ruta de la imagen (ej. imagenes/producto.jpg): "
                        );
                        String rutaImagen = scanner.nextLine();

                        boolean imagenAgregada = lista.agregarImagenProducto(
                                nombreImagen,
                                rutaImagen
                        );

                        if (imagenAgregada) {
                            System.out.println(
                                    VERDE + "\nImagen agregada correctamente." + RESET
                            );

                            System.out.println(
                                    "Imagenes del producto: "
                                    + productoImagen.getListaImagenes()
                            );
                        }
                    }

                    pausar(scanner);
                    break;

                case 8:
                    limpiarPantalla();

                    System.out.println(MORADO + "=================================" + RESET);
                    System.out.println(MORADO + "         REPORTE DE COSTOS" + RESET);
                    System.out.println(MORADO + "=================================" + RESET);

                    lista.reporteCostos();

                    pausar(scanner);
                    break;

                case 9:
                    limpiarPantalla();

                    System.out.println(AZUL + "Saliendo del sistema..." + RESET);
                    break;

                default:
                    limpiarPantalla();

                    System.out.println(ROJO + "Opcion invalida. Intente nuevamente." + RESET);

                    pausar(scanner);
            }

        } while (opcion != 9);

        scanner.close();
    }

    public static void pausar(Scanner scanner) {
        System.out.println("\nPresione ENTER para volver al menu principal...");
        scanner.nextLine();
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }
}