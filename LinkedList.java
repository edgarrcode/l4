public class LinkedList {
    private Box head;
    private Box iterator;

    LinkedList(){}

    /* Add b as the last node of the linked list.*/
    void addNode(Box b){
    // WRITE YOUR CODE HERE.
        //if LinkedList is empty
        if (head == null) {
            head = b;
            iterator = head;
        } else {
            iterator.next = b;
            iterator = iterator.next;
       }
    }

    /* Insert b in position pos. If insertion is successful
    * return true, otherwise return false.
    */
    boolean insertNode(Box b, int pos){
    // WRITE YOUR CODE HERE.
        //if pos is 0
        if (pos == 0) {
            b.next = head;
            head = b;
            return true;
        }

        //all other positions (except last)
        int counter = 1;
        Box prev = head;
        Box iterator = head.getNext();
        while (iterator != null) {
            if (counter == pos) {
                prev.next = b;
                b.next = iterator;
                return true;
            }
            prev = iterator;
            iterator = iterator.getNext();
            counter++;            
        }

        //last position
        if (counter == (pos + 1)) {
            prev.next = b;
            return true;
        }
        return false;
    }

    /**Print width, height, length, and volume of each of the boxes in
    * this linked list. */
    void printAllBoxes(){
    // WRITE YOUR CODE HERE.
        if (head == null) {
            //if head is empty
            System.out.println("There are no boxes in the list you provided.");
            System.out.print("\n");
        } else {
            iterator = head;
            int counter = 0;
            // iterate to the correct position
            while (iterator != null) {
                System.out.println("    The width of the box #" + counter + " is: " + iterator.getWidth());
                System.out.println("    The height of the box #" + counter + " is: " + iterator.getHeight());
                System.out.println("    The length of the box #" + counter + " is: " + iterator.getLength());
                System.out.println("    The volume of the box #" + counter + " is: " + iterator.getVolume());
                System.out.print("\n");
                iterator = iterator.getNext();
                counter++;
            }
        }

    }

    /** Remove the box in position pos. Return true if removal
    * is successful, otherwise return false.*/
    boolean removeNode(int pos){
    // WRITE YOUR CODE HERE.
        if (pos == 0) {
            head = head.getNext();
            return true;
        }

        int counter = 1;
        Box prev = head;
        Box iterator = head.getNext();

        while(iterator != null) { //edgarr: test with last box
            if (pos ==  counter) {
                prev.next = iterator.getNext();
                return true;
            }
            prev = iterator;
            iterator = iterator.getNext();
            counter++;
        }
        return false;
    }

    /** Return the box in position pos. Return null when pos is
    * invalid.*/
    Box getBox(int pos){
    // WRITE YOUR CODE HERE.
        iterator = head;
        int counter = 0;

        while (iterator != null) {
            if (counter == pos) {
                return iterator;
            }

            iterator = iterator.getNext();
            counter++;
        }

        //pos is greater than linked list. edgarr: test with position greater than list size
        System.out.println("Position was not found.");
        
        return head;
    }

    /**Print width, height, length, and volume of each of the boxes in
    * this linked list in reverse order.*/
    void printReverse(){
    // WRITE YOUR CODE HERE.
        iterator = head;
        int counter = 0;
        if (iterator == null) {
            return;
        }
        //count linked list size
        while(iterator != null) {
            counter ++;
            iterator = iterator.getNext();
        }
        
        //go to counter position;
        while (counter != 0) {
            iterator = head;
            for (int i = 0; i < counter - 1; i++) {
                iterator = iterator.getNext();
            }
            System.out.println("    The width of the box #" + (counter - 1) + " is: " + iterator.getWidth());
            System.out.println("    The height of the box #" + (counter - 1) + " is: " + iterator.getHeight());
            System.out.println("    The length of the box #" + (counter - 1) + " is: " + iterator.getLength());
            System.out.println("    The volume of the box #" + (counter - 1) + " is: " + iterator.getVolume());
            System.out.print("\n");
            counter--;
        }
    }

    /**Initiate the iterator variable*/
    void initiateIterator(){
    // WRITE YOUR CODE HERE.
        Box iterator = new Box();
        if (head.next != null) {
            iterator = head.next;
        }
    }

    /**
    * Return the box in the current iterator position.
    */
    Box getNextBox(){
    // WRITE YOUR CODE HERE.
        iterator = iterator.next;
        return iterator;
    }
}