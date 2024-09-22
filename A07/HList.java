/**
 * HList - A LinkedList of HNodes. Works with driver class 
 *            to implement HouseListing menu options.
 * @author Monico Luis
 */
public class HList {
   //Int that holds the number of nodes in the list.
   private static int count;
   //HNode that holds a reference to the front of the linked list.
   private HNode front = null;
   //HNode that holds a reference to the back of the linked list. 
   private HNode back = null;
   //HNode that provides access to list traversal for recursion printin. 
   private HNode pointer;
   
   /**
    * HList Method; constructor for the HList.
    */
   public HList() {
      count = 0;
   }
   
   /**
    * add Method; adds a node to the list.
    * @param n Holds the node that is to be added to list.
    */
   public void add(HNode n) {
      HNode cursor = front; //Creates a cursor to traverse the list; 
      //If the list is empty, makes the node the first node of the list. 
      if (count == 0) {
         this.front = n;
         this.back = n;
         this.pointer = this.front; //Assigns pointer to front node.
      }
      else {
         //Checks through the entire linked list for conflicting MLS. 
         for (int i = 1; i <= count; i++) {
            if (cursor.getHouse().getMls() == n.getHouse().getMls()) {
               System.out.println("\nThere is a conflicting MLS! "
                                 + "Unable to create the house. "
                                 + "Returning to menu...\n");
               return;
            }
            cursor = cursor.getNext();
         }
         //If there are no conflicting MLS, adds node to the back of the list. 
         this.back.setNext(n);
         this.back = n;
      }
      count++; //Increments the count. 
      System.out.println("\nThe house was added succesfully!\n");
   }
           
   /**
    * remove Method; removes the node with the user's inputted MLS.
    * @param MLS Holds the MLS of the House the user wants to remove.
    * @return false Returns false if the list is empty or there is not matching MLS. 
    * @return true Returns true if the node is removed successfully.
    */
   public boolean remove(int MLS) {
      //Creates a cursor to traverse list.
      HNode cursor = front; 
      //Creates a precursor that follows behind cursor. 
      HNode precursor = cursor;
      //If the list is empty returns false. 
      if (count == 0) {
         return false;
      }
      else {
                           
         //Checks the entire list for a node with the inputted MLS. 
         while (cursor != null && cursor.getHouse().getMls() != MLS) {
            precursor = cursor;
            cursor = cursor.getNext();
         }
         
         //If the house to be deleted is the first node, sets the front to the node next to it.
         if(front.getHouse().getMls() == MLS) {
            this.front = front.getNext();
            this.pointer = front; //Sets the pointer node to the front again.
            count--;
            return true;
         }
      
         //If the house to be deleted is the last node, sets the node to null.            
         if(back.getHouse().getMls() == MLS) {
            precursor.setNext(cursor.getNext());
            //Makes the back node the node BEFORE the deleted one. 
            this.back = precursor; 
            count--;
            return true;
         }
         
         //Otherwise, the node to be deleted will be unlinked from the list.
         precursor.setNext(cursor.getNext());
         count--;
         return true;
      } 
   }
   
   /**
    * printHousesLessThan Method; uses recursion to print all 
    *                                 the houses less than a given price. 
    * @param price Holds the user inputted price 
    */
   public void printHousesLessThan(double price) {
      //Holds the user inputted price.
      double budget = price; 
      //Checks if the linked list is empty or if it reached the end. 
      if (this.pointer == null) {
         return;
      }
      else {
         //Checks if the node is less than the user budget. 
         if (this.pointer.getHouse().getPrice() < budget) {
            System.out.println(this.pointer.toString() + "\n"); //If it is, print it out. 
         }
         //Gets the next node.
         this.pointer = this.pointer.getNext();
         //Calls the function again using the same budget.
         printHousesLessThan(budget);
      }
      //When its done printing, set the pointer to the front again.
      this.pointer = this.front; 
   }
   
   /**
    * printAllHouses Method; uses recursion to print all houses. 
    */
   public void printAllHouses() { 
      //Checks if the linked list is empty or if it reached the end.
      if (this.pointer == null) {
         return; 
      }
      else {
         //Prints the node the pointer is referencing.
         System.out.println(this.pointer.toString() + "\n");
         //Gets the next node. 
         this.pointer = this.pointer.getNext(); 
         //Calls the function again to print the next node. 
         printAllHouses();
      }
      //When done printing, set the pointer to the front again. 
      this.pointer = this.front; 
   }
}