public class LinkedList {
    private Box head;
    private Box iterator;

    LinkedList(){}

    /* Add b as the last node of the linked list.*/
    void addNode(Box b){
    // WRITE YOUR CODE HERE.
        //if LinkedList is empty
        if (head == null) {
            return b;
        }

        //if LinkedList is not empty
        Box iterator = head;
        while(iterator.next != null) {
            iterator.getNext();
        }
        iterator.setNext(b);
    }

    /* Insert b in position pos. If insertion is successful
    * return true, otherwise return false.
    */
    boolean insertNode(Box b, int pos){
    // WRITE YOUR CODE HERE.
    }

    /**Print width, height, length, and volume of each of the boxes in
    * this linked list. */
    void printAllBoxes(){
    // WRITE YOUR CODE HERE.
    }

    /** Remove the box in position pos. Return true if removal
    * is successful, otherwise return false.*/
    boolean removeNode(int pos){
    // WRITE YOUR CODE HERE.
    }

    /** Return the box in position pos. Return null when pos is
    * invalid.*/
    Box getBox(int pos){
    // WRITE YOUR CODE HERE.
    }

    /**Print width, height, length, and volume of each of the boxes in
    * this linked list in reverse order.*/
    void printReverse(){
    // WRITE YOUR CODE HERE.
    }

    /**Initiate the iterator variable*/
    void initiateIterator(){
    // WRITE YOUR CODE HERE.
`    }

    /**
    * Return the box in the current iterator position.
    */
    Box getNextBox(){
    // WRITE YOUR CODE HERE.
`    }
}