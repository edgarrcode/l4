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
    	theLinkedList.printAllBoxes();
    }
}