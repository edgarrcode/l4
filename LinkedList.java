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
            iterator.next;
        }
        iterator.next = b;
    }

    /* Insert b in position pos. If insertion is successful
    * return true, otherwise return false.
    */
    boolean insertNode(Box b, int pos){
    // WRITE YOUR CODE HERE.
        //if pos is 0
        if (pos == 0) {
            b.next = head;
        }

        //all other positions (except last)
        int counter = 1;
        Box prev = head;
        Box iterator = head.next;
        while (iterator != null) {
            if (counter == pos) {
                prev.next = b;
                b.next = iterator;
            }
            prev = iterator;
            iterator = iterator.next;
            counter++;            
        }

        //last position
        if (counter == (pos + 1)) {
            prev.next = b;
        }

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
                System.out.println("The width of the box #" + counter + " is: " + iterator.getWidth());
                System.out.println("The height of the box #" + counter + " is: " + iterator.getHeight());
                System.out.println("The length of the box #" + counter + " is: " + iterator.getLength());
                System.out.println("The volume of the box #" + counter + " is: " + iterator.getVolume());
                System.out.print("\n");
                iterator = iterator.next;
                counter++;
            }
        }

    }

    /** Remove the box in position pos. Return true if removal
    * is successful, otherwise return false.*/
    boolean removeNode(int pos){
    // WRITE YOUR CODE HERE.
        if (pos = 0) {
            head = head.next;
        }

        int counter = 1;
        Box prev = head;
        Box iterator = head.next;

        while(iterator != null) { //edgarr: test with last box
            if (pos ==  counter) {
                prev.next = iterator.next;
            }
            prev = iterator;
            iterator = iterator.next;
            counter++;
        }

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

            iterator = iterator.next;
            counter++;
        }

        //pos is greater than linked list. edgarr: test with position greater than list size
        System.out.print("You have entered an invalid position");
        break;
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
        }
        
        //go to counter position;
        //edgarr: test this loop
        while (counter == 0) {
            iterator = head;
            for (int i = 0; i > counter; i--) {
                iterator = iterator.next;
            }
            System.out.println("The width of the box #" + counter + " is: " + iterator.getWidth());
            System.out.println("The height of the box #" + counter + " is: " + iterator.getHeight());
            System.out.println("The length of the box #" + counter + " is: " + iterator.getLength());
            System.out.println("The volume of the box #" + counter + " is: " + iterator.getVolume());
            System.out.print("\n");
            counter--;
        }

    }

    /**Initiate the iterator variable*/
    void initiateIterator(){
    // WRITE YOUR CODE HERE.
        Box iterator = new Box();
    }

    /**
    * Return the box in the current iterator position.
    */
    Box getNextBox(){
    // WRITE YOUR CODE HERE.
        return iterator;
    }
}