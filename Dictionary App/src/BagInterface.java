public interface BagInterface <T>{
 boolean contains(T entry);
 int getDefinitionTotal ();
 boolean add(T entry);
 void printList(String word);
 void printList(String word, boolean isDistinct, boolean isReversed);
 boolean isEmpty();
}
