public class TestDogs {
    public static void main(String[] args) {
        Dogs garfield = new Dogs("German Shepard", 3, "orange");
        Dogs lolly = new Dogs("Boston Terrier", 7, "white");
        Dogs clifford = new Dogs("Golden Retriever", 1, "blue");
        Dogs duke = new Dogs("Beagle", 5, "brown");

        DogsLinkedList list = new DogsLinkedList();
        list.insertNode(garfield);
        list.insertNode(lolly);
        list.insertNode(clifford);
        list.insertNode(duke);

        //TESTING removeAfter() METHOD
        //printing original list to compare to new list
        System.out.println("Original List:");
        list.printList();

        //choosing node to remove after next node
        DogsNode chosenNode = list.head.getNext();
        list.removeAfter(chosenNode);
        //reprints list after removing the node after
        list.printList();

        //testing max() method
        int maxAge = list.max();
        System.out.println("Maximum age: " + maxAge);

        //testing copy() method
        DogsLinkedList copied = list.copy();

        list.removeAfter(list.head);
        list.removeDuplicate("Golden Retriever");

        //print both lists to show copy
        System.out.println("\nModified List:");
        list.printList();
        System.out.println("\nCopied List");
        copied.printList();
    }
}
