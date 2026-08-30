// Code written by YAM JUN JIE
// junjie.yam.2025@computing.smu.edu.sg

public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        if (isEmpty()) {
            return "";
        }

        Node<E> currentNode = this.head;
        String output = currentNode.getElement().toString();

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            output += currentNode.getElement().toString();
        }

        return output;
    }

    public E removeLast(){
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = this.tail;
        this.size--;

        if (this.size == 0) {
            this.head = null;
            this.tail = null;
            return removedNode.getElement();
        }

        Node<E> newLastNode = this.head;

        while (newLastNode.getNext() != this.tail) {
            newLastNode = newLastNode.getNext();
        }

        this.tail = newLastNode;
        newLastNode.setNext(null);        

        return removedNode.getElement();
    }

    public void reverse(){
        if (this.size <= 1) {
            return;
        }

        Node<E> prevNode = null;
        Node<E> currentNode = this.head;
        Node<E> nextNode = null;
        this.tail = this.head;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }

        this.head = prevNode;
    }
}