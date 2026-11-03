
public class ArbolProductos {

    // Atributos
    private NodoArbolProducto raiz;

    // Métodos
    // Constructor
    public ArbolProductos() {
        raiz = null;
    }

    // Operaciones
    private boolean estaVacio() {
        return raiz == null;
    }

    // Getters
    private NodoArbolProducto getRaiz() {
        return raiz;
    }

    // Setters
    private void setRaiz(NodoArbolProducto raiz) {
        this.raiz = raiz;
    }
}

