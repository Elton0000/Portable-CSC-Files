/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OurStack.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartB;

public class OurStack<T> implements StackInterface<T> {
    Node topNode;
    int numberOfEntries;

    public OurStack() {
        topNode = null;
        numberOfEntries = 0;
    }

    @Override
    public void push(T newEntry) {
        Node newNode = new Node (newEntry);
        newNode.next = topNode;
        topNode = newNode;
        numberOfEntries++;
    }

    @Override
    public T peek() {
        T firstElement = null;
        if (topNode != null) {
            firstElement = topNode.data;
        }
        return firstElement;
    }

    @Override
    public T pop() {
        T popped = null;
        if (peek() != null) {
            popped = topNode.data;
            topNode = topNode.next;
            numberOfEntries--;
        }
        return popped;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public void clear() {
        while (topNode != null) {
            pop();
        }
    }
    private class Node {
        T data;
        Node next;
        private Node (T dataPortion) {
            this(dataPortion,null);
        }
        private Node (T dataPortion, Node nextNode) {
            this.data = dataPortion;
            this.next = nextNode;
        }
    }
}