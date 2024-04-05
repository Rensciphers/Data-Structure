public class DogsLinkedList {
    DogsNode head;
    private DogsNode tail;

    public DogsLinkedList() {
        head = null;
        tail = null;
    }

    public void insertNode(Dogs doggie) {
        try {
            DogsNode node = new DogsNode(doggie);
            if (head == null) {
                head = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
        } catch (NullPointerException e) {
            System.out.println("Error inserting node: " + e.getMessage());
        }
    }

    //takes linklist node as arguement and removes the node following the given one
    //does nothing if the initial node is null and as well as the next node being null
    public void removeAfter(DogsNode prev) {
        try {
            if (prev == null || prev.getNext() == null) { //"||" - means or like in python
                return; //return nothing if true
            }
            DogsNode nodeRemove = prev.getNext();
            if (nodeRemove == tail) {
                tail = prev;
            }
        } catch (NullPointerException e) {
            System.out.println("Error removing node: " + e.getMessage());
        }
    }

    //prints a copy of the original linkList without destroying the original
    public DogsLinkedList copy() {
        DogsLinkedList newList = new DogsLinkedList();
        DogsNode current = head;

        while (current != null) {
            try {
                Dogs doggie = current.getDoggies();
                DogsNode newNode = new DogsNode(new Dogs(doggie.getBreed(), doggie.getAge(), doggie.getColor()));

                if (newList.head == null) {
                    newList.head = newNode;
                } else {
                    newList.tail.setNext(newNode);
                }
                newList.tail = newNode;
                current = current.getNext();
            } catch (NullPointerException e) {
                System.out.println("Error copying node: " + e.getMessage());
            }
        }
        return newList;
    }

    //takes a linked-list Node and a string key as its argument and removes every node in the list whose item field is equal to key
    public void removeDuplicate(String key) {
        try {
            DogsNode current = head;
            DogsNode prev = null;

            while (current != null) {
                Dogs doggie = current.getDoggies();
                if (doggie != null && doggie.getBreed().equals(key)) { //note to self: && means the same thing as and in python
                    if (prev == null) {
                        head = current.getNext();
                    } else {
                        prev.setNext(current.getNext());
                    }
                    if (current == tail) {
                        tail = prev;
                    }
                } else {
                    prev = current;
                }
                current = current.getNext();
            }
        } catch (NullPointerException e) {
            System.out.println("Error removing duplicate node: " + e.getMessage());
        }
    }

    //takes the first node of the linked list as its argument and returns the value of the maximum item in teh list
    //assume all items are positive integers and return 0 if the linked list is empty

    public int max(){
        try {
            if (head == null) {
                return 0;
            }
            int maxInt = Integer.MIN_VALUE;
            DogsNode current = head;

            while (current != null) {
                Dogs doggie = current.getDoggies();
                if (doggie != null && doggie.getAge() > maxInt) {
                    maxInt = doggie.getAge();
                }
                current = current.getNext();
            }
            return maxInt;
        } catch (NullPointerException e) {
            System.out.println("Error finding maximum age: " + e.getMessage());
            return 0;
        }
    }

    //prints the linkedList
    public void printList() {
        try {
            DogsNode current = head;
            System.out.println("~Print Start~");
            System.out.print(current.getDoggies().getBreed());
            System.out.print(" " + current.getDoggies().getAge());
            System.out.println(" " + current.getDoggies().getColor());

            while (current.getNext() != null) {
                System.out.print(current.getNext().getDoggies().getBreed());
                System.out.print(" " + current.getDoggies().getAge());
                System.out.println(" " + current.getDoggies().getColor());
                current = current.getNext();
            }
            System.out.println("~Print End~");
        } catch (NullPointerException e) {
            System.out.println("Error printing list: " + e.getMessage());
        }
    }
}
