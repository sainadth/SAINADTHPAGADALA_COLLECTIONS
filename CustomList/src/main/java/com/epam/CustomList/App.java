package com.epam.CustomList;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger LOGGER=LogManager.getLogger(MyList.class);
	private static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
       MyList<Integer> customList = new MyList<Integer>();
       int choice;
       int temporaryElement;
       int index;
       String resultString;
       while(true) {
    	   System.out.println("_____MENU_____\n1.Add Element\n2.Get Element\n3.Remove Element\n4.Display List\n5.Exit\nEnter your choice : ");
    	   choice = scanner.nextInt();
    	   LOGGER.info("Choice chosen!...");
    	   switch (choice) {
    	   case 1:	System.out.println("Enter an element: ");
    	   			temporaryElement = scanner.nextInt();
    	   			customList.add(temporaryElement);
    	   			System.out.println("Insertion Completed...\n");
    	   			break;
    	   	
    	   case 2:	System.out.println("Enter the index of the element to be fetched: ");
    	   			index = scanner.nextInt();
    	   			try {
    	   				temporaryElement = customList.getElement(index);
    	   				System.out.println("The element at the index "+index+" is: "+temporaryElement);
    	   			}catch (IndexOutOfBoundsException e) {
    	   				System.out.println("Sorry index out of bounds\nProcess terminated!...");
						LOGGER.info("Error encountered in getting element by index: "+e);
					}
    	   			break;
    	   			
    	   case	3:	System.out.println("Enter the index of the element to be removed: ");
    	   			index = scanner.nextInt();
    	   			try {
    	   				temporaryElement = customList.remove(index);
    	   				System.out.println("The element removed from the CustomList is: "+temporaryElement);
    	   			}catch (IndexOutOfBoundsException e) {
    	   				System.out.println("Sorry index out of bounds\nProcess terminated!...");
						LOGGER.info("Error encountered in getting element by index: "+e);
					}
    	   			break;
    	   			
    	   case 4:	resultString = customList.display();
    		   		System.out.println("The custom list created is :"+resultString);
    		   		break;
    		   		
    	   case 5:	LOGGER.info("Exiting from the application!...");
    		   		System.out.println("Exiting from application!...");
    		   		return;
    		   		
    	   default: LOGGER.info("Ivalid choice is chosen!...");
    				System.out.println("Invalid Choice!...");
    				break;
    	   }	
       }
    }
}
