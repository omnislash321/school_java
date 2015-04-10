/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Node of a singly linked list of strings.
 */
public class Node {

    private Object element; // we assume elements are character strings
    private Node next;

    /**
     * Creates a node with the given element and next node.
     */
    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    /**
     * Returns the element of this node.
     */
    public Object getElement() {
        return element;
    }

    /**
     * Returns the next node of this node.
     */
    public Node getNext() {
        return next;
    }
    // Modifier methods:
    /**
     * Sets the element of this node.
     */
    public void setElement(Object newElement) {
        element = newElement;
    }

    /**
     * Sets the next node of this node.
     */
    public void setNext(Node newNext) {
        next = newNext;
    }
    
    public String toString () {
        return "[" + element + ":" + next + "]";
    }
}