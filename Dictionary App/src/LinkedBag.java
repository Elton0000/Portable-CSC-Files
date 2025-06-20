public class LinkedBag <T> implements BagInterface <T>{
    private int numberOfEntries = 0;
    private int capacity;
    private T [] bag;
    private static final int defaultCapacity = 4;
    private static final int maxCapacity = 10000;
    private String partOfSpeech = null;

    LinkedBag() {
        this(defaultCapacity);
    }

    LinkedBag(int initialCapacity){
        this.capacity = initialCapacity;
        T[] tempbag = (T[]) new Object [initialCapacity];
        this.bag = tempbag;
    }

    LinkedBag(Object [] definitions) {
        this.capacity = definitions.length;
        T[] tempBag = (T[])definitions;
        this.bag = tempBag;
        for (T entry : this.bag) {
            if (entry != null) {
                this.numberOfEntries++;
            }
        }
    }

    LinkedBag(Object [] definitions,String tag) {
        this.partOfSpeech = tag;
        this.capacity = definitions.length;
        T[] tempBag = (T[])definitions;
        this.bag = tempBag;
        for (T entry : this.bag) {
            if (entry != null) {
                this.numberOfEntries++;
            }
        }
    }

    @Override
    public boolean contains (T entry) {
        boolean found = false;
        for (int i = 0; i < bag.length && !found; i++) {
            if (entry.equals(bag[i])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getDefinitionTotal() {
        return this.numberOfEntries;
    }

    @Override
    public boolean add(T entry) {
        boolean added = false;
        this.bag[numberOfEntries] = entry;
        numberOfEntries++;
        added = true;
        return added;
    }

    @Override
    public void printList(String word) {
        if (!isEmpty()) {
            for (T entry : this.bag) {
                if (entry != null) {
                    System.out.println(word + " [" + this.partOfSpeech + "] : " + entry);
                }
            }
        }
    }
    @Override
    public void printList (String word, boolean isDistinct, boolean isReversed) {

        if (!isEmpty()) {
            LinkedBag<T> temp = new LinkedBag<>();
            if (isDistinct) {
                for (T entry : this.bag) {
                    if (!temp.contains(entry)) {
                        temp.add(entry);
                    }
                }
            }
            if (isReversed) {
                for (int i = this.numberOfEntries; i > numberOfEntries; i-- ) {
                    System.out.println(word + " [" + this.partOfSpeech + "] : " + this.bag[i]);
                }
            }
            else {
                for (T tempEntry : this.bag) {
                    if (tempEntry != null) {
                        System.out.println(word + " [" + this.partOfSpeech + "] : " + tempEntry);
                    }
                }
            }



//            for (T tempEntry : this.bag) {
//                if (tempEntry != null) {
//                    System.out.println(word + " [" + this.partOfSpeech + "] : " + tempEntry);
//                }
//            }
        }
    }
    @Override public boolean isEmpty() {
        return numberOfEntries == 0;
    }

}
