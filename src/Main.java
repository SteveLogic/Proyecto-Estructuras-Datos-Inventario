import java.util.Scanner;
import java.io.File;

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
    Tienda tienda = new Tienda();

    int opcion;

    do {

        limpiarPantalla();

        System.out.println(AZUL + "====================================" + RESET);
        System.out.println(AZUL + "     SISTEMA DE GESTION DE TIENDA" + RESET);
        System.out.println(AZUL + "====================================" + RESET);

        System.out.println("1. Agregar producto al inventario");
        System.out.println("2. Registrar cliente y realizar compra");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Mostrar cola de clientes");
        System.out.println("5. Atender siguiente cliente");
        System.out.println("6. Salir");

        System.out.println(AZUL + "====================================" + RESET);

        opcion = leerEntero(
                scanner,
                "Seleccione una opcion: "
        );

        switch (opcion) {

            case 1:
            {

                boolean seguirAgregando = true;

                while (seguirAgregando) {

                    limpiarPantalla();

                    System.out.println(
                            VERDE + "====================================" + RESET
                    );
                    System.out.println(
                            VERDE + "     AGREGAR PRODUCTO AL INVENTARIO" + RESET
                    );
                    System.out.println(
                            VERDE + "====================================" + RESET
                    );

                    String nombre = leerTexto(
                            scanner,
                            "Nombre: "
                    );
                    if (tienda.buscarProducto(nombre) != null) {

                        System.out.println(  ROJO + "\nYa existe un producto con ese nombre." + RESET);
                        System.out.print(  "\nPresione ENTER para intentar con otro nombre...");
                        scanner.nextLine();
                        continue;



                    }

                    double precio = leerDouble(
                            scanner,
                            "Precio: "
                    );

                    String categoria = leerTexto(
                            scanner,
                            "Categoria: "
                    );

                    System.out.print(
                            "Fecha de vencimiento (ENTER si no aplica): "
                    );
                    String fechaVencimiento = scanner.nextLine().trim();

                    if (fechaVencimiento.isBlank()) {
                        fechaVencimiento = "No aplica";
                    }

                    int cantidad = leerCantidad(
                            scanner,
                            "Cantidad: "
                    );

                    Producto nuevoProducto = new Producto(
                            nombre,
                            precio,
                            categoria,
                            fechaVencimiento,
                            cantidad
                    );

                    tienda.agregarProducto(nuevoProducto);

                    System.out.println(
                            VERDE + "\nProducto agregado al inventario." + RESET
                    );

                    String respuesta = leerConfirmacion(
                            scanner,
                            "\n¿Desea agregar otro producto? (S/N): "
                    );

                    if (!respuesta.equalsIgnoreCase("S")) {
                        seguirAgregando = false;
                    }
                }

                break;
            }

            case 2:
                limpiarPantalla();

                System.out.println(
                        MORADO + "====================================" + RESET
                );
                System.out.println(
                        MORADO + "      REGISTRAR CLIENTE Y COMPRA" + RESET
                );
                System.out.println(
                        MORADO + "====================================" + RESET
                );

                System.out.print("Nombre del cliente: ");
                String nombreCliente = leerTexto(scanner,"Nombre del cliente: ");
                String identificacion = leerTexto(scanner,"Identificacion: ");

                int prioridad;

                do {
                    System.out.println("\nTipo de cliente:");
                    System.out.println("1. Basico");
                    System.out.println("2. Afiliado");
                    System.out.println("3. Premium");

                    prioridad = leerEntero(
                            scanner,
                            "Seleccione la prioridad: "
                    );

                    if (prioridad < 1 || prioridad > 3) {
                        System.out.println(
                                ROJO + "Prioridad invalida." + RESET
                        );
                    }

                } while (prioridad < 1 || prioridad > 3);

                Cliente nuevoCliente = new Cliente(
                        nombreCliente,
                        identificacion,
                        prioridad
                );

                boolean carritoConProductos = false;

                while (true) {

                    System.out.println(
                            CIAN + "\n--- PRODUCTOS DISPONIBLES ---" + RESET
                    );

                    tienda.mostrarInventario();

                    System.out.print(
                            "\nIngrese el nombre del producto "
                            + "(0 para finalizar compra): "
                    );

                    String nombreProducto = scanner.nextLine();

                    if (nombreProducto.equals("0")) {
                        break;
                    }

                    Producto productoDisponible =
                            tienda.buscarProducto(nombreProducto);

                    if (productoDisponible == null) {

                        System.out.println(
                                ROJO + "Producto no encontrado." + RESET
                        );

                        continue;
                    }

                    System.out.println(
                            "Precio: " + productoDisponible.getPrecio()
                    );

                    System.out.println(
                            "Cantidad disponible: "
                            + productoDisponible.getCantidad()
                    );

                    int cantidadCompra = leerCantidad(
                        scanner,
                        "Cantidad a comprar: ");

                    boolean agregado =
                            tienda.agregarProductoAlCarrito(
                                    nuevoCliente,
                                    nombreProducto,
                                    cantidadCompra
                            );

                    if (agregado) {

                        carritoConProductos = true;

                        System.out.println(
                                VERDE
                                + "Producto agregado al carrito."
                                + RESET
                        );

                    } else {

                        System.out.println(
                                ROJO
                                + "No fue posible agregar el producto."
                                + RESET
                        );
                    }
                }

                if (carritoConProductos) {

                    tienda.encolarCliente(nuevoCliente);

                    System.out.println(
                            VERDE
                            + "\nCliente agregado a la cola de atencion."
                            + RESET
                    );

                } else {

                    System.out.println(
                            AMARILLO
                            + "\nEl cliente no fue agregado porque "
                            + "su carrito esta vacio."
                            + RESET
                    );
                }

                pausar(scanner);
                break;

            case 3:
                limpiarPantalla();

                System.out.println(
                        CIAN + "===== INVENTARIO =====" + RESET
                );

                tienda.mostrarInventario();

                pausar(scanner);
                break;

            case 4:
                limpiarPantalla();

                System.out.println(
                        MORADO + "===== COLA DE CLIENTES =====" + RESET
                );

                tienda.mostrarColaClientes();

                pausar(scanner);
                break;

            case 5:
                limpiarPantalla();

                System.out.println(
                        AMARILLO + "====================================" + RESET
                );
                System.out.println(
                        AMARILLO + "       ATENDER SIGUIENTE CLIENTE" + RESET
                );
                System.out.println(
                        AMARILLO + "====================================" + RESET
                );

                Cliente clienteAtendido =
                        tienda.atenderSiguienteCliente();

                if (clienteAtendido == null) {

                    System.out.println(
                            ROJO + "\nNo hay clientes en la cola." + RESET
                    );

                } else {

                    System.out.println(
                            VERDE + "\nCliente atendido:" + RESET
                    );

                    System.out.println(
                            "Nombre: " + clienteAtendido.getNombre()
                    );

                    System.out.println(
                            "Identificacion: "
                            + clienteAtendido.getIdentificacion()
                    );

                    System.out.println(
                            "Prioridad: "
                            + clienteAtendido.getPrioridad()
                    );

                    System.out.println(
                            CIAN + "\n===== FACTURA =====" + RESET
                    );

                    clienteAtendido
                            .getCarrito()
                            .reporteCostos();
                }

                pausar(scanner);
                break;
            case 6:
                System.out.println(
                        AZUL + "\nSaliendo del sistema..." + RESET
                );
                break;

            default:
                System.out.println(
                        ROJO + "\nOpcion invalida." + RESET
                );

                pausar(scanner);
        }

    } while (opcion != 6);
}



    public static void pausar(Scanner scanner) {
        System.out.println("\nPresione ENTER para volver al menu principal...");
        scanner.nextLine();
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static String leerTexto(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            if (!texto.isBlank()) {
                return texto;
            }

            System.out.println(ROJO + "Este campo no puede estar vacío." + RESET);
        }
    }
    // Leer y validar números enteros
    public static int leerEntero(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(ROJO + "Ingrese un número entero válido." + RESET);
            }
        }
    }
    // Leer y validar cantidades
    public static int leerCantidad(Scanner scanner, String mensaje) {

        while (true) {
            int cantidad = leerEntero(scanner, mensaje);

            if (cantidad >= 0) {
                return cantidad;
            }

            System.out.println(ROJO + "La cantidad no puede ser negativa." + RESET);
        }
    }
    // Leer y validar números decimales
    public static double leerDouble(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                double numero = Double.parseDouble(entrada);

                if (numero >= 0) {
                    return numero;
                }

                System.out.println(ROJO + "El valor no puede ser negativo." + RESET);

            } catch (NumberFormatException e) {
                System.out.println(ROJO + "Ingrese un número válido." + RESET);
            }
        }
    }
    // Verificar que la ruta de una imagen exista
    public static boolean existeImagen(String rutaImagen) {
        File archivo = new File(rutaImagen);
        return archivo.exists() && archivo.isFile();
    }
    //Verificar que sólo ingrese S o N para eliminar un objeto
    public static String leerConfirmacion(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim();

            if (respuesta.equalsIgnoreCase("S")
                    || respuesta.equalsIgnoreCase("N")) {
                return respuesta;
            }

            System.out.println(
                    ROJO + "Ingrese únicamente S o N." + RESET
            );
        }
    }
}