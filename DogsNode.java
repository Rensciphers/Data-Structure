public class DogsNode {
    private Dogs doggie;
    private DogsNode next;

    public DogsNode(Dogs doggie){
        this.doggie = doggie;
        this.next = null;
    }

    public Dogs getDoggies() {
        return doggie;
    }

    public DogsNode getNext() {
        return next;
    }

    public void setNext(DogsNode next) {
        this.next = next;
    }
}
