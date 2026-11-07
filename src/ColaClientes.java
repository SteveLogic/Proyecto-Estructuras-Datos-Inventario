public class ColaClientes {
    // Cola de prioridad implementada con una lista enlazada ordenada.
    // Los clientes se mantienen ordenados de mayor a menor prioridad
    // (3 = premium, 2 = afiliado, 1 = básico).
    // Si hay empate de prioridad, se respeta el orden de llegada (FIFO):
    // el que llegó primero queda más cerca del frente.
    // De esta forma, atender siempre saca al cliente del frente en O(1)
    // y el costo de ordenar se paga al encolar, en O(n).

    // Atributos
    private NodoCliente frente;
    private NodoCliente fin;
    private int tamano;

    // Métodos
    // Constructor
    public ColaClientes() {
        frente = null;
        fin = null;
        tamano = 0;
    }

    // Operaciones
    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Cliente cliente) {
        // Se construye un nodo nuevo usando el cliente recibido
        NodoCliente nodo = new NodoCliente(cliente);

        // Si la cola está vacía, el nodo es el frente y el fin a la vez
        if (estaVacia()) {
            frente = nodo;
            fin = nodo;
        }
        // Si el nuevo cliente tiene MAYOR prioridad que el del frente, se inserta al frente.
        // Se usa ">" y no ">=" para que, en empate, el que ya estaba se quede adelante.
        else if (cliente.getPrioridad() > frente.getCliente().getPrioridad()) {
            nodo.setSiguiente(frente);
            frente = nodo;
        }
        // Si su prioridad es menor o igual que la del último, se inserta al final (caso más común)
        else if (cliente.getPrioridad() <= fin.getCliente().getPrioridad()) {
            fin.setSiguiente(nodo);
            fin = nodo;
        }
        // Si no, se busca su posición en medio de la cola
        else {
            // Se avanza mientras el siguiente tenga prioridad mayor o igual,
            // así el nuevo cliente queda detrás de todos los de su misma prioridad
            NodoCliente temp = frente;
            while (temp.getSiguiente() != null
                    && temp.getSiguiente().getCliente().getPrioridad() >= cliente.getPrioridad()) {
                temp = temp.getSiguiente();
            }
            // Se enlaza el nuevo nodo entre temp y su siguiente
            nodo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nodo);
        }

        tamano++;
    }

    // Saca y retorna el cliente que se debe atender (el de mayor prioridad que llegó primero)
    public Cliente atender() {
        // Si la cola está vacía, no hay a quién atender
        if (estaVacia()) {

            return null;
        }

        // Se guarda el cliente del frente y se avanza el frente
        Cliente atendido = frente.getCliente();
        frente = frente.getSiguiente();

        // Si la cola quedó vacía, el fin también debe quedar en null
        if (frente == null) {
            fin = null;
        }

        tamano--;
        return atendido;
    }

    // Retorna el próximo cliente a atender sin sacarlo de la cola
    public Cliente verSiguiente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getCliente();
    }

    // Muestra los clientes en el orden en que serán atendidos
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("No hay clientes en la cola.");
            return;
        }

        NodoCliente actual = frente;
        int posicion = 1;
        while (actual != null) {
            System.out.println(posicion + ". " + actual.getCliente());
            actual = actual.getSiguiente();
            posicion++;
        }
    }

    // Getters
    public int getTamano() {
        return tamano;
    }
}