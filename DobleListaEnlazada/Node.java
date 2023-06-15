public class Node<E> {
    
    Node () {
        this.data = null ;
        this.nextNode = null ;
        this.previousNode = null ;
    }

    Node ( E data ) {
        this.data = data ;
        this.nextNode = null ;
        this.previousNode = null ;
    }

    Node ( E data , Node <E > nextNode ) {
        this.data = data ;
        this.nextNode = nextNode ;
        this.previousNode = null ;
    }

    Node ( E data , Node <E > nextNode , Node <E > previousNode ) {
        this.data = data ;
        this.nextNode = nextNode ;
        this.previousNode = previousNode ;
    }

    private E data ;
    private Node <E> nextNode ;
    private Node <E> previousNode ;
    
    public E getDato() {
    	return data;
    }
    
    public void setDato(E data) {
    	this.data = data;
    }
    
    public Node<E> getNextNode(){
    	return nextNode;
    }
    
    public void setNextNode(Node<E> next) {
    	nextNode = next;
    }
    
    public Node<E> getPreviousNode(){
    	return previousNode;
    }
    
    public void setPreviousNode(Node<E> prev) {
    	previousNode = prev;
    }
}
