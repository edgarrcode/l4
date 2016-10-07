/*
Author: Edgar E. Rodriguez
TAs: Anthony M Ortiz Cepeda and Khandoker A Rahad
Professor: Mahmud Hossain
LMD: 09/15/16
Goals: Read the widht, height, and length of boxes from file, store them in a linked list, and apply the requested functionality.
*/
import java.util.*;
import java.io.*;

public class Runner {
    //read and return head
    public static LinkedList readFile(String fileName) throws IOException {
        String line;
        FileReader reader = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(reader);
        buffer.mark(1000); //here we assume that the file won't be longer than 1000 lines
        String[] eachLine;
        line = buffer.readLine();
        //check if file has something
        if (line == null) {
            try {
                throw new IOException("File is empty!");
            } catch(IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        //create head
        eachLine = line.split(" ");
        //check if data is in correct format
        if (eachLine.length != 3) {
            try {
                throw new IOException("There should only be 3 values per line.");
            } catch(IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        Box firstBox = new Box(Double.parseDouble(eachLine[0]), Double.parseDouble(eachLine[1]), Double.parseDouble(eachLine[2]));

        LinkedList theLinkedList = new LinkedList();
        theLinkedList.addNode(firstBox);

        //read 2nd and following lines
        line = buffer.readLine();

        while(line != null) {
            eachLine = line.split(" ");
            Box eachLineBox = new Box(Double.parseDouble(eachLine[0]), Double.parseDouble(eachLine[1]), Double.parseDouble(eachLine[2]));
            theLinkedList.addNode(eachLineBox);
            line = buffer.readLine();
        }

        return theLinkedList;

    }

    public static int findSmallest(LinkedList theLinkedList) {
        //set smallestBoxIndex and smallestBoxVolume to first item of the list
        int smallestBoxIndex = 0;
        Box smallestBox = theLinkedList.getBox(0);
        double smallestBoxVolume = smallestBox.getVolume();

        //check the following items of the list
        theLinkedList.initiateIterator();
        Box theNextBox = theLinkedList.getNextBox();
        int counter = 1;

        while(theNextBox != null) {
            if ( smallestBoxVolume > theNextBox.getVolume() ) {
                smallestBoxVolume = theNextBox.getVolume();
                smallestBoxIndex = counter;
            }
            counter++;
            theNextBox = theLinkedList.getNextBox();
        }
        return smallestBoxIndex;
    }

    public static int findLargest(LinkedList theLinkedList) {
        //set largestBoxIndex and largestBoxVolume to first item of the list
        int largestBoxIndex = 0;
        Box largestBox = theLinkedList.getBox(0);
        double largestBoxVolume = largestBox.getVolume();

        //check the following items of the list
        theLinkedList.initiateIterator();
        Box theNextBox = theLinkedList.getNextBox();
        int counter = 1;

        while(theNextBox != null) {
            if ( largestBoxVolume < theNextBox.getVolume() ) {
                largestBoxVolume = theNextBox.getVolume();
                largestBoxIndex = counter;
            }
            counter++;
            theNextBox = theLinkedList.getNextBox();
        }
        return largestBoxIndex;
    }

    public static int howManyCubicBoxes(LinkedList theLinkedList) {
    	int howManyCubicBoxes = 0;
        //check if head is cube
        Box theLinkedListHead = theLinkedList.getBox(0);
        if (theLinkedListHead.isCube() ) {
            howManyCubicBoxes++;
        }

        //check the rest of the boxes
        theLinkedList.initiateIterator();
        Box theNextBox = theLinkedList.getNextBox();
        while(theNextBox != null) {
            if (theNextBox.isCube()) {
                howManyCubicBoxes++;
            }
            theNextBox = theLinkedList.getNextBox();
        }


    	return howManyCubicBoxes;
    }

    public static void main (String[] args) throws IOException {
        String fileName = "";
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is the file name;");
        LinkedList theLinkedList = new LinkedList();
        try {
            fileName = scnr.nextLine();
            //call read file with the file name as parameter
            theLinkedList = readFile(fileName);
        } catch(FileNotFoundException e) {
            System.err.println("File not found!" + e.getMessage());
            System.exit(1);
        } catch(NumberFormatException e) {
            System.err.println("The file should only contain numbers of double precision and single spaces (example: \"1.0 2.3 1.3\"). " + e.getMessage());
            System.exit(1);
        }

        //theLinkedList.initiateIterator();
        //print boxes
        System.out.println("Print All Boxes");
        theLinkedList.printAllBoxes();
        //print boxes
        System.out.println("Print Reverse");
        theLinkedList.printReverse();

        //find the smallest box
        System.out.println("The Smallest Box");
        int findSmallest = findSmallest(theLinkedList);
        Box theSmallestBox = theLinkedList.getBox(findSmallest);
        System.out.println("    The position of the smallest cubic package is: " + findSmallest);
        System.out.println("    The width of the smallest cubic package is: " + theSmallestBox.getWidth());
        System.out.println("    The height of the smallest cubic package is: " + theSmallestBox.getHeight());
        System.out.println("    The length of the smallest cubic package is: " + theSmallestBox.getLength());
        System.out.println("    The volume of the smallest cubic package is: " + theSmallestBox.getVolume());
        System.out.print("\n");

        //find the largest box
        System.out.println("The Largest Box");
        int findLargest = findLargest(theLinkedList);
        Box theLargestBox = theLinkedList.getBox(findLargest);
        System.out.println("    The position of the largest cubic package is: " + findLargest);
        System.out.println("    The width of the largest cubic package is: " + theLargestBox.getWidth());
        System.out.println("    The height of the largest cubic package is: " + theLargestBox.getHeight());
        System.out.println("    The length of the largest cubic package is: " + theLargestBox.getLength());
        System.out.println("    The volume of the largest cubic package is: " + theLargestBox.getVolume());
        System.out.print("\n");

        //how many cubic boxes
        System.out.println("How Many Cubic Boxes");
        int howManyCubicBoxes = howManyCubicBoxes(theLinkedList);
        System.out.println("    Ammount of cubic boxes: " + howManyCubicBoxes);
        System.out.print("\n");

        //removeNode
        System.out.println("Remove Node");
        if(theLinkedList.removeNode(10)) {
            System.out.println("    Linked list item 10 was successfully removed.");
        } else {
            System.out.println("    No list item was removed, position not found!");
        }
        System.out.print("\n");
        System.out.println("Print All Boxes");
        theLinkedList.printAllBoxes();
        System.out.print("\n");

        //insertNode
        System.out.println("Insert Node");
        Box newBox = new Box(100, 100, 100);
        if(theLinkedList.insertNode(newBox, 100)) {
            System.out.println("    New Box successfully added in position 100.");
        } else {
            System.out.println("    No Box was added, invalid position!");
        }
        System.out.print("\n");
        System.out.println("Print All Boxes");
        theLinkedList.printAllBoxes();
        System.out.print("\n");


    }
}