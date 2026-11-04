
public class PruebaArbolProductos {

    public static void main(String[] args) {

        // Se crea el árbol de productos
        ArbolProductos arbol = new ArbolProductos();

        // Se crean los productos
        Producto leche = new Producto("Leche", 1200, "Lácteos", "2026-12-15", 10);
        Producto arroz = new Producto("Arroz", 950, "Granos", "2027-06-20", 25);
        Producto pan = new Producto("Pan", 1100, "Panadería", "2026-11-10", 15);
        Producto cafe = new Producto("Cafe", 3500, "Bebidas", "2027-08-10", 20);
        Producto miel = new Producto("Miel", 4200, "Endulzantes", "2027-09-15", 8);

        // Se insertan los productos en el árbol
        arbol.insertar(leche);
        arbol.insertar(arroz);
        arbol.insertar(pan);
        arbol.insertar(cafe);
        arbol.insertar(miel);

        // Se muestran los productos en orden alfabético
        System.out.println("Recorrido en orden:");
        arbol.enOrden();


        // Se busca un producto existente
        System.out.println("Búsqueda de producto existente:");

        NodoArbolProducto encontrado = arbol.buscar("Miel");

        if (encontrado != null) {
            System.out.println("Producto encontrado: "
                    + encontrado.getProducto().getNombre());
        }

        // Se busca un producto inexistente
        System.out.println("\nBúsqueda de producto inexistente:");

        NodoArbolProducto noEncontrado = arbol.buscar("Azúcar");


        // Se elimina un producto que no tiene hijos
        System.out.println("\nEliminación de un nodo hoja:");

        NodoArbolProducto eliminado = arbol.eliminar("Miel");

        if (eliminado != null) {
            System.out.println("Producto eliminado: "
                    + eliminado.getProducto().getNombre());
        }

        // Se muestra el árbol después de eliminar el producto
        System.out.println("\nÁrbol después de eliminar:");
        arbol.enOrden();

        // Se elimina un producto que tiene un solo hijo
        System.out.println("\nEliminación de un nodo con un hijo:");

        NodoArbolProducto eliminadoUnHijo = arbol.eliminar("Arroz");

        if (eliminadoUnHijo != null) {
            System.out.println("Producto eliminado: "
                    + eliminadoUnHijo.getProducto().getNombre());
        }

        // Se muestra el árbol después de eliminar el producto
        System.out.println("\nÁrbol después de eliminar:");
        arbol.enOrden();


        // Se elimina la raíz que tiene dos hijos
        System.out.println("\nEliminación de un nodo con dos hijos:");

        NodoArbolProducto eliminadoDosHijos = arbol.eliminar("Leche");

        if (eliminadoDosHijos != null) {
            System.out.println("Producto eliminado: "
                    + eliminadoDosHijos.getProducto().getNombre());
        }

        // Se muestra el árbol después de eliminar el producto
        System.out.println("\nÁrbol después de eliminar:");
        arbol.enOrden();


        // Se crea un nuevo árbol para probar el sucesor
        ArbolProductos arbolSucesor = new ArbolProductos();

        // Se insertan los productos
        arbolSucesor.insertar(new Producto("Leche", 1200, "Lácteos", "2026-12-15", 10));
        arbolSucesor.insertar(new Producto("Arroz", 950, "Granos", "2027-06-20", 25));
        arbolSucesor.insertar(new Producto("Pan", 1100, "Panadería", "2026-11-10", 15));
        arbolSucesor.insertar(new Producto("Miel", 4200, "Endulzantes", "2027-09-15", 8));
        arbolSucesor.insertar(new Producto("Queso", 2500, "Lácteos", "2026-12-20", 12));

        // Se elimina un nodo cuyo sucesor no es su hijo derecho inmediato
        System.out.println("\nEliminación con sucesor indirecto:");
        arbolSucesor.eliminar("Leche");

        // Se muestra el árbol después de eliminar
        System.out.println("\nRecorrido en orden:");
        arbolSucesor.enOrden();


        // Se crea un árbol para probar un sucesor con hijo derecho
        ArbolProductos arbolSucesorHijo = new ArbolProductos();

        // Se insertan los productos
        arbolSucesorHijo.insertar(new Producto("Leche", 1200, "Lácteos", "2026-12-15", 10));
        arbolSucesorHijo.insertar(new Producto("Arroz", 950, "Granos", "2027-06-20", 25));
        arbolSucesorHijo.insertar(new Producto("Pan", 1100, "Panadería", "2026-11-10", 15));
        arbolSucesorHijo.insertar(new Producto("Miel", 4200, "Endulzantes", "2027-09-15", 8));
        arbolSucesorHijo.insertar(new Producto("Naranja", 700, "Frutas", "2026-11-20", 18));
        arbolSucesorHijo.insertar(new Producto("Queso", 2500, "Lácteos", "2026-12-20", 12));

        // Se elimina la raíz
        System.out.println("\nEliminación con sucesor que tiene hijo derecho:");
        arbolSucesorHijo.eliminar("Leche");

        // Se muestra el árbol resultante
        System.out.println("\nRecorrido en orden:");
        arbolSucesorHijo.enOrden();


        // Se crea un árbol para probar la eliminación de un nodo interno
        ArbolProductos arbolInterno = new ArbolProductos();

        // Se insertan los productos
        arbolInterno.insertar(new Producto("Leche", 1200, "Lácteos", "2026-12-15", 10));
        arbolInterno.insertar(new Producto("Cafe", 3500, "Bebidas", "2027-08-10", 20));
        arbolInterno.insertar(new Producto("Pan", 1100, "Panadería", "2026-11-10", 15));
        arbolInterno.insertar(new Producto("Arroz", 950, "Granos", "2027-06-20", 25));
        arbolInterno.insertar(new Producto("Galletas", 1500, "Snacks", "2027-04-10", 12));
        arbolInterno.insertar(new Producto("Harina", 850, "Granos", "2027-05-15", 18));

        // Se elimina un nodo con dos hijos que no es la raíz
        System.out.println("\nEliminación de un nodo interno con dos hijos:");

        NodoArbolProducto eliminadoInterno = arbolInterno.eliminar("Cafe");

        if (eliminadoInterno != null) {
            System.out.println("Producto eliminado: "
                    + eliminadoInterno.getProducto().getNombre());
        }

        // Se muestra el árbol después de eliminar
        System.out.println("\nRecorrido en orden:");
        arbolInterno.enOrden();

        // Se prueba el recorrido en preorden
        System.out.println("\nRecorrido en preorden:");
        arbolInterno.preOrden();

        // Se prueba el recorrido en postorden
        System.out.println("\nRecorrido en postorden:");
        arbolInterno.postOrden();

        // Se intenta insertar un producto con un nombre existente
        System.out.println("\nPrueba de producto duplicado:");

        arbolInterno.insertar(new Producto(
                "Pan", 1500, "Panadería", "2026-12-20", 5));

        // Se muestra el árbol para verificar que no se duplicó
        System.out.println("\nÁrbol después del intento de inserción:");
        arbolInterno.enOrden();


        // Se crea un árbol vacío para realizar las pruebas
        ArbolProductos arbolVacio = new ArbolProductos();

        // Se intenta buscar un producto en el árbol vacío
        System.out.println("\nBúsqueda en un árbol vacío:");
        arbolVacio.buscar("Leche");

        // Se intenta eliminar un producto en el árbol vacío
        System.out.println("\nEliminación en un árbol vacío:");
        arbolVacio.eliminar("Leche");


        // Se intenta eliminar un producto inexistente
        System.out.println("\nEliminación de un producto inexistente:");

        NodoArbolProducto eliminadoInexistente = arbolInterno.eliminar("Azúcar");

        // Se comprueba que no se eliminó ningún producto
        if (eliminadoInexistente == null) {
            System.out.println("No se eliminó ningún producto.");
        }

        // Se muestra el árbol para comprobar que permanece intacto
        System.out.println("\nÁrbol después del intento de eliminación:");
        arbolInterno.enOrden();
    }
}

