public class PruebaColaClientes {
    public static void main(String[] args) {
        // Se crea la cola de clientes
        ColaClientes cola = new ColaClientes();

        // Se prueba atender con la cola vacía
        System.out.println("Atender con la cola vacía:");
        cola.atender();

        // Se crean clientes con distintas prioridades
        Cliente ana = new Cliente("Ana", "101", Cliente.PRIORIDAD_BASICO);
        Cliente bruno = new Cliente("Bruno", "102", Cliente.PRIORIDAD_AFILIADO);
        Cliente carla = new Cliente("Carla", "103", Cliente.PRIORIDAD_BASICO);
        Cliente diego = new Cliente("Diego", "104", Cliente.PRIORIDAD_PREMIUM);
        Cliente elena = new Cliente("Elena", "105", Cliente.PRIORIDAD_AFILIADO);
        Cliente fabian = new Cliente("Fabian", "106", Cliente.PRIORIDAD_PREMIUM);

        // Se agregan productos al carrito de un cliente
        diego.agregarAlCarrito(new Producto("Leche", 1200, "Lácteos", "2026-12-15", 2));
        diego.agregarAlCarrito(new Producto("Cafe", 3500, "Bebidas", "2027-08-10", 1));

        // Se encolan en orden de llegada
        cola.encolar(ana);
        cola.encolar(bruno);
        cola.encolar(carla);
        cola.encolar(diego);
        cola.encolar(elena);
        cola.encolar(fabian);

        // Orden esperado: Diego, Fabian (premium), Bruno, Elena (afiliados), Ana, Carla (básicos)
        System.out.println("Cola en orden de atención (" + cola.getTamano() + " clientes):");
        cola.mostrarCola();

        // Se consulta el siguiente sin sacarlo
        System.out.println("\nSiguiente a atender: " + cola.verSiguiente().getNombre());

        // Se atiende al primer cliente y se muestra su carrito
        System.out.println("\nSe atiende a:");
        Cliente atendido = cola.atender();
        System.out.println(atendido);
        atendido.getCarrito().reporteCostos();

        // Se atiende al resto
        System.out.println("\nOrden de atención del resto:");
        while (!cola.estaVacia()) {
            System.out.println(cola.atender());
        }

        // Se prueba una prioridad inválida
        System.out.println("\nPrueba de prioridad inválida:");
        try {
            new Cliente("Error", "999", 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}