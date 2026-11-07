public class Cliente {
    // Constantes de prioridad
    // Se definen como constantes para no usar "números mágicos" en el código
    public static final int PRIORIDAD_BASICO = 1;
    public static final int PRIORIDAD_AFILIADO = 2;
    public static final int PRIORIDAD_PREMIUM = 3;

    // Atributos
    private String nombre;
    private String identificacion;
    private int prioridad;
    private ListaProductos carrito;

    // Métodos
    // Constructor
    // El carrito se crea vacío; los productos se agregan después desde el inventario de la Tienda
    public Cliente(String nombre, String identificacion, int prioridad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        setPrioridad(prioridad);
        this.carrito = new ListaProductos();
    }

    // Operaciones
    // Valida que la prioridad esté entre 1 (básico) y 3 (premium)
    public static boolean esPrioridadValida(int prioridad) {
        return prioridad >= PRIORIDAD_BASICO && prioridad <= PRIORIDAD_PREMIUM;
    }

    // Retorna el nombre del tipo de cliente según su prioridad
    public String getTipoCliente() {
        switch (prioridad) {
            case PRIORIDAD_PREMIUM:
                return "Premium";
            case PRIORIDAD_AFILIADO:
                return "Afiliado";
            default:
                return "Básico";
        }
    }

    // Agrega un producto al final del carrito del cliente
    public void agregarAlCarrito(Producto producto) {
        carrito.insertarFinal(producto);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public ListaProductos getCarrito() {
        return carrito;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    // Si la prioridad no es válida, se lanza una excepción para no crear clientes inconsistentes
    public void setPrioridad(int prioridad) {
        if (!esPrioridadValida(prioridad)) {
            throw new IllegalArgumentException(
                    "La prioridad debe ser 1 (básico), 2 (afiliado) o 3 (premium).");
        }
        this.prioridad = prioridad;
    }

    public void setCarrito(ListaProductos carrito) {
        this.carrito = carrito;
    }

    // toString
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " - Identificación: " + identificacion
                + " - Prioridad: " + prioridad + " (" + getTipoCliente() + ")";
    }
}