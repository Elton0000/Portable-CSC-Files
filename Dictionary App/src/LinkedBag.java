public class LinkedBag <T> implements BagInterface <T>{
    private int numberOfEntries = 0;
    private int capacity;
    private T [] bag;
    private static final int defaultCapacity = 5;
    private static final int maxCapacity = 10000;
    LinkedBag() {
        this(defaultCapacity);
    }
    LinkedBag(int initialCapacity){
        this.capacity = initialCapacity;
    }
    LinkedBag(Object [] definitions) {
        this.capacity = definitions.length;
        T[] tempBag = (T[])definitions;
        this.bag = tempBag;
    }
    public boolean contains (T entry) {
        boolean found = false;
        for (int i = 0; i < bag.length && !found; i++) {
            if (entry.equals(bag[i])) {
                found = true;
            }
        }
        return found;
    }
}
