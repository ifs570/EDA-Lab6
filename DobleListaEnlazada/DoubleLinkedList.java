public class DoubleLinkedList<T extends Comparable<T>> {

    private Node<T> cabeza;
    private Node<T> cola;

    public DoubleLinkedList(){
        cabeza = null;
        cola = null;
    }

    public void push(T dato) {
        Node<T> nodo = new Node<T>(dato);

        if (cabeza != null) {
            cola.setNextNode(nodo);
            nodo.setPreviousNode(cola);
            cola = nodo;
        }
        else {
            cabeza = nodo;
            cola = nodo;
        }
    }

    public void intercambiar(Node<T> nodo1, Node<T> nodo2){
        T aux = nodo1.getDato();
        nodo1.setDato(nodo2.getDato());
        nodo2.setDato(aux);
    }

    public long ordenamientoInsercion(){
        Node<T> puntero = cabeza;
        Node<T> llave = null;

        long inicio = System.nanoTime();
        while (puntero != null) {
            
            llave = puntero.getNextNode();
            
            while (llave != null && llave.getPreviousNode() != null && llave.getDato().compareTo(llave.getPreviousNode().getDato()) < 0) {
                intercambiar(llave, llave.getPreviousNode());
                llave = llave.getPreviousNode();
            }
            puntero = puntero.getNextNode();
        }
        long fin = System.nanoTime();

        return fin - inicio;
    }

    public String toString(){
        String cadena = "";

        Node<T> puntero = cabeza;
        if (cabeza == null)
            return "Lista vacia";
        
        while (puntero != null){
            cadena += puntero.getDato() + " ";
            puntero = puntero.getNextNode();
        }
        return cadena;
    }

}
