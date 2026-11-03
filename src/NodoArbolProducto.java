
public class NodoArbolProducto {

    // Atributos
    private Producto producto;
    private NodoArbolProducto izq;
    private NodoArbolProducto der;

    // Métodos
    // Constructor
    public NodoArbolProducto(Producto producto) {
        this.producto = producto;
        izq = der = null;
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public NodoArbolProducto getIzq() {
        return izq;
    }

    public NodoArbolProducto getDer() {
        return der;
    }

    // Setters
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setIzq(NodoArbolProducto izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbolProducto der) {
        this.der = der;
    }

    // toString
    @Override
    public String toString() {
        return "\nNombre: " + producto.getNombre()
                + "\nPrecio: " + producto.getPrecio()
                + "\nCategoría: " + producto.getCategoria()
                + "\nFecha de vencimiento: " + producto.getFechaVencimiento()
                + "\nCantidad: " + producto.getCantidad()
                + "\n";
    }
}

