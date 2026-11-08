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

    public void insertar(Producto producto) {

        // Se construye un nodo nuevo usando el producto recibido
        NodoArbolProducto nodo = new NodoArbolProducto(producto);

        // Si el árbol está vacío, se inserta el nodo en la raíz
        if (estaVacio()) {
            setRaiz(nodo);
            return;
        }

        // Se declaran dos variables temporales
        NodoArbolProducto temp = raiz;
        NodoArbolProducto padreTemp = temp;

        // Se recorre el árbol hasta encontrar una posición disponible
        while (temp != null) {

            padreTemp = temp;

            // Se comparan los nombres de los productos
            // Se comparan los nombres según sus valores Unicode, A<P => 65<80
            // ignorando diferencias entre mayúsculas y minúsculas.
            // Ají>Ajo => i>o => 237>111
            // Comparamos el producto que deseamos insertar con los productos del árbol bajando.
            int comparacion = temp.getProducto().getNombre()
                    .compareToIgnoreCase(producto.getNombre());

            // Si el nombre actual es menor, se avanza a la derecha
            if (comparacion < 0) {
                temp = temp.getDer();
            }

            // Si el nombre actual es mayor, se avanza a la izquierda
            else if (comparacion > 0) {
                temp = temp.getIzq();
            }

            // Si los nombres son iguales, no se inserta
            else {
                System.out.println("El producto ya está en el árbol.\n");
                return;
            }
        }

        // Se determina dónde insertar el nuevo nodo
        // Comparamos el último nodo que no es null el padreTemp con el producto que deseamos insertar
        // para determinar sin insertamos a la derecha o a la izquierda.
        int comparacion = padreTemp.getProducto().getNombre()
                .compareToIgnoreCase(producto.getNombre());

        if (comparacion < 0) {
            padreTemp.setDer(nodo);
        } else {
            padreTemp.setIzq(nodo);
        }
    }

    public NodoArbolProducto buscar(String nombre) {

        // Si el árbol está vacío, se da un mensaje y se retorna null
        if (estaVacio()) {
            //System.out.println("El árbol está vacío.\n");
            return null;
        }

        // Se declara una variable temporal y se inicializa en la raíz
        NodoArbolProducto temp = raiz;

        // Se recorre el árbol mientras exista un nodo
        while (temp != null) {

            // Se compara el nombre del producto actual con el buscado
            // Se comparan los nombres según sus valores Unicode, A<P => 65<80
            // ignorando diferencias entre mayúsculas y minúsculas.
            // Ají>Ajo => i>o => 237>111
            // Comparamos el producto que deseamos buscar con los productos del árbol bajando.
            int comparacion = temp.getProducto().getNombre()
                    .compareToIgnoreCase(nombre);

            // Si el nombre actual es menor, se avanza a la derecha
            if (comparacion < 0) {
                temp = temp.getDer();
            }

            // Si el nombre actual es mayor, se avanza a la izquierda
            else if (comparacion > 0) {
                temp = temp.getIzq();
            }

            // Si los nombres son iguales, se retorna el nodo
            else {
                return temp;
            }
        }

        // Si no se encontró el producto, se retorna null
        //System.out.println("El producto no está en el árbol.\n");
        return null;
    }


    private NodoArbolProducto getPadre(String nombre) {

        // Se declaran las variables temporales
        NodoArbolProducto temp = raiz;
        NodoArbolProducto padreTemp = null;

        // Se recorre el árbol hasta encontrar el producto
        while (temp != null) {

            // Se compara el nombre actual con el buscado
            int comparacion = temp.getProducto().getNombre()
                    .compareToIgnoreCase(nombre);

            // Si se encuentra el producto, se retorna su padre
            if (comparacion == 0) {
                return padreTemp;
            }

            // Se actualiza la referencia al padre
            padreTemp = temp;

            // Si el nombre actual es menor, se avanza a la derecha
            if (comparacion < 0) {
                temp = temp.getDer();
            }

            // Si el nombre actual es mayor, se avanza a la izquierda
            else {
                temp = temp.getIzq();
            }
        }

        // Si el producto no existe, se retorna null
        return null;
    }

    private NodoArbolProducto getSucesor(NodoArbolProducto nodoBorrar) {

        // Se declaran las variables temporales
        NodoArbolProducto padreSucesor = nodoBorrar;
        NodoArbolProducto sucesor = nodoBorrar;
        NodoArbolProducto temp = nodoBorrar.getDer();

        // Se busca el nodo menor del subárbol derecho
        while (temp != null) {
            padreSucesor = sucesor;
            sucesor = temp;
            temp = temp.getIzq();
        }

        // Si el sucesor no es el hijo derecho inmediato del nodo
        if (sucesor != nodoBorrar.getDer()) {

            // Se conecta el padre del sucesor con el hijo derecho del sucesor
            padreSucesor.setIzq(sucesor.getDer());

            // Se conecta el sucesor con el subárbol derecho del nodo
            sucesor.setDer(nodoBorrar.getDer());
        }

        // Se retorna el nodo sucesor
        return sucesor;
    }

    public NodoArbolProducto eliminar(String nombre) {

        // Si el árbol está vacío, se da un mensaje y se retorna null
        if (estaVacio()) {
            System.out.println("El árbol está vacío.\n");
            return null;
        }

        // Se busca el nodo que se desea eliminar
        NodoArbolProducto nodo = buscar(nombre);

        // Si el producto no existe, se retorna null
        if (nodo == null) {
            return null;
        }

        // Si el nodo es la raíz, entonces:
        if (nodo == raiz) {

            // Si no tiene hijos, se pone null en la raíz
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                setRaiz(null);
            }

            // Si tiene un solo hijo, ese hijo se pone en la raíz
            else if (nodo.getDer() == null) {
                setRaiz(nodo.getIzq());
            }
            else if (nodo.getIzq() == null) {
                setRaiz(nodo.getDer());
            }

            // Si tiene dos hijos, se pone su sucesor en la raíz
            else {
                NodoArbolProducto sucesor = getSucesor(nodo);
                sucesor.setIzq(nodo.getIzq());
                setRaiz(sucesor);
            }

            // Se retorna el nodo eliminado
            return nodo;
        }

        // Se busca el padre del nodo
        NodoArbolProducto padre = getPadre(nombre);

        // Se determina si el nodo es hijo izquierdo del padre
        boolean esIzquierdo = padre.getIzq() == nodo;

        // Si no tiene hijos, se le pone null a su padre del lado correspondiente
        if (nodo.getIzq() == null && nodo.getDer() == null) {

            if (esIzquierdo) padre.setIzq(null);
            else padre.setDer(null);
        }

        // Si tiene un solo hijo, ese hijo se le pone a su padre del lado correspondiente
        else if (nodo.getDer() == null) {

            if (esIzquierdo) padre.setIzq(nodo.getIzq());
            else padre.setDer(nodo.getIzq());
        }

        else if (nodo.getIzq() == null) {

            if (esIzquierdo) padre.setIzq(nodo.getDer());
            else padre.setDer(nodo.getDer());
        }

        // Si tiene dos hijos, se le pone su sucesor a su padre del lado correspondiente
        else {
            NodoArbolProducto sucesor = getSucesor(nodo);
            sucesor.setIzq(nodo.getIzq());

            if (esIzquierdo) padre.setIzq(sucesor);
            else padre.setDer(sucesor);
        }

        // Se retorna el nodo eliminado
        return nodo;
    }

    private void enOrdenRec(NodoArbolProducto subraiz) {// la subraiz es el nodo del subarbol que se desea recorrer
        //Izq->Raiz->Der
        //Imprime cada subárbol de izquierda a derecha

        // Si la subraíz no es null, se recorre el árbol
        if (subraiz != null) {

            // Se recorre el subárbol izquierdo
            enOrdenRec(subraiz.getIzq());//Recursiva, se ejecuta hasta obtener el nodo izquierdo menor, a partir de ahí, recorre el resto del código devolviendo todos los valores que obtuvo a partir de las evaluaciones recursivas

            // Se muestra el producto del nodo actual
            System.out.println(subraiz.getProducto().getNombre());//Primero imprime el nodo izquierdo menor

            // Se recorre el subárbol derecho
            enOrdenRec(subraiz.getDer());
        }
    }


    public void enOrden() { //permite llamar al método desde el Main

        // Se inicia el recorrido en orden desde la raíz
        // Recorre todo el árbol
        enOrdenRec(raiz);

        // Se imprime un salto de línea al finalizar
        System.out.println("\n");
    }

    private void preOrdenRec(NodoArbolProducto subraiz) {//Raiz->Izq->Der

        // Si la subraíz no es null, se recorre el árbol
        if (subraiz != null) {

            // Se muestra el producto del nodo actual
            System.out.println(subraiz.getProducto().getNombre());

            // Se recorre el subárbol izquierdo
            preOrdenRec(subraiz.getIzq());

            // Se recorre el subárbol derecho
            preOrdenRec(subraiz.getDer());
        }
    }

    public void preOrden() {

        // Se inicia el recorrido en preorden desde la raíz
        preOrdenRec(raiz);

        // Se imprime un salto de línea al finalizar
        System.out.println("\n");
    }


    private void postOrdenRec(NodoArbolProducto subraiz) {//Izq->Der->Raiz

        // Si la subraíz no es null, se recorre el árbol
        if (subraiz != null) {

            // Se recorre el subárbol izquierdo
            postOrdenRec(subraiz.getIzq());

            // Se recorre el subárbol derecho
            postOrdenRec(subraiz.getDer());

            // Se muestra el producto del nodo actual
            System.out.println(subraiz.getProducto().getNombre());
        }
    }


    public void postOrden() {

        // Se inicia el recorrido en postorden desde la raíz
        postOrdenRec(raiz);

        // Se imprime un salto de línea al finalizar
        System.out.println("\n");
    }

    // Setter de la raíz
    private void setRaiz(NodoArbolProducto raiz) {
        this.raiz = raiz;
    }
}


