/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartA;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }
    @Override
    public int getCurrentSize(){
        return numberOfEntries;
    }
    @Override
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    @Override
    public boolean add(T newEntry){
        boolean success;
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        success = true;
        return success;
    }
    @Override
    public boolean removeAllOccurrences(T[][] entries){
        System.out.print("[-] Converting 2D array to 1D...\n");

        int totalSize = 0;
        for (Object [] row : entries) {
            totalSize += row.length;
        }
        int index = 0;
        T [] convertedArray = (T []) new Object [totalSize];
        for (Object [] row : entries) {
            for (Object col : row) {
                convertedArray[index] = (T) col;
                index++;
            }
        }

        System.out.print("[-] Removing duplicates in 1D array...\n");

        int subtractFromSize = 0;
        for (int i = 0; i < convertedArray.length - 1; i++) {
            for (int j = i + 1; j < convertedArray.length; j++) {
                if (convertedArray[i] != null && convertedArray[i] == convertedArray[j]) {
                    convertedArray[j] = null;
                    subtractFromSize++;
                }
            }
        }

        T [] convertedArray2 = (T[]) new Object[totalSize - subtractFromSize];
        index = 0;
        for (T oldNonNull : convertedArray) {
            if (oldNonNull != null) {
                convertedArray2[index] = oldNonNull;
                index++;
            }
        }

        System.out.print("[>] The final 1D array now contains: ");
        for (T nonDuplicate : convertedArray2) {
            System.out.print(nonDuplicate + " ");
        }
        System.out.print("\n[-] Removing the final 1D array items from the bag...\n");
        for (T entriesToRemove : convertedArray2) {
            while (remove(entriesToRemove)) {

            }
        }
        return false;
    }
    @Override
    public T[] toArray(){
        T [] myArray = (T[]) new Object[getCurrentSize()];
        Node currentNode = firstNode;
        int index = 0;

        while (currentNode != null && index < numberOfEntries) {
            myArray[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        return myArray;
    }
    private Node getReferenceTo(T entry) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(entry)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;

    }
    public boolean remove(T entry) {
        Node toRemove = getReferenceTo(entry);
        boolean removed = false;
        if (toRemove != null) {
            toRemove.data = firstNode.data;
            firstNode = firstNode.next;
            removed = true;
            numberOfEntries--;
            Node currentNode = firstNode;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
        return removed;

    }
    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}