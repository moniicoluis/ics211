import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * HouseListing - Creates an HList and manipulates it using userinput.
 * @author Monico Luis
 *
 */
public class HouseListing{
   /**
    * main Method; Prints and loops through menu.
    * @param args Holds command line arguments.
    * @throws HouseException Throws exception for invalid inputs for House. 
    */
   public static void main(String[] args) throws HouseException {
     //Creates an HList to hold the house nodes. 
      HList houseList = new HList();
      //Creates a scanner to take in user input.
      Scanner userInput = new Scanner(System.in);
      //Holds the user input value. 
      int userMenuInput;
      //Holds the boolean value that keeps the loop functioning.
      boolean mainLoop = true;
      
      //Loops through program until user ends it. 
      while (mainLoop) {
         userMenuInput = menu();
         switch(userMenuInput) {
            
            case 0: //  Case 0: End program.
               System.out.println("Thank you for using this program!");
               mainLoop = false;
               break;
                  
            case 1: //  Case 1: Add a House.
               //Catches if the program cannot add the house or add it to the linked list.
               try {
                  //Create node to be inputted into houseList. 
                  HNode newNode = new HNode();
                  House newHouse = createHouse();
                  newNode.setHouse(newHouse); //Assigns created node to the house. 
                  houseList.add(newNode); //Adds node to house. 
               }
               catch (HouseException he) {
                  System.out.println("\nUnable to create a house "
                        + "due to invalid input! Try again!\n");
               }
               catch (NullPointerException npe) {
                  System.out.println("Something went wrong. Try again! Returning to menu...\n");
               }
               
               break;
                  
                  
            case 2: //  Case 2: Remove a House
               //Holds the MLS of the house the user wants to remove.
               int theMls = 0;
               //Creates scanner to take in user input. 
               Scanner mlsInfo = new Scanner(System.in);
               //Holds boolean value of the remove method. 
               boolean remove;
                  
               System.out.println("\nRemove a house!\n"
                     + "Enter the MLS of the house you want to remove: ");
               //Catches if the user input is valid (an integer).
               try {
                  theMls = mlsInfo.nextInt();
                  //If the MLS is not in range, returns to menu.
                  if (theMls < 10001 || theMls > 99999) {
                     System.out.println("\nInvalid MLS! Try again later!\n");
                  }
                  else {
                     //Removes the house.
                     remove = houseList.remove(theMls);
                     if (remove == true) { //Checks if it succesfully removed the house or not.
                        System.out.println("\nThe house with the inputted MLS has been removed!\n");
                     }
                     else {
                        System.out.println("\nNo houses with that MLS have been found!\n");
                     }
                  }
               }
               catch (InputMismatchException ime) {
                  System.out.println("\nPlease enter an integer between "
                        + "10001 and 99999!\n");
               }
               catch (NullPointerException npe) {
                  System.out.println("\nNo houses with that MLS have been found!\n");
               }
                  
               break;
                  
            case 3: //  Case 3: Print Houses less than given price
               //Holds the price of the houses the user wants to search under.
               double thePrice = 0;
               //Creates a scanner that'll take in user info. 
               Scanner priceInfo = new Scanner(System.in); 
               System.out.println("\nPrint a house lesser than a given price!\n"
                  + "Enter the price of houses you want to search under: ");
                  
               try { //Catches if the user does not input a double.
                  thePrice = priceInfo.nextDouble(); 
                  //If the price is not in range, returns to menu. 
                  if (thePrice < 0 || thePrice > 1000000) {
                     System.out.println("\nThe price you inputted is invalid! Try again later!\n"); 
                  }
                  else {
                     //Prints houses under the price the userinputs. 
                     System.out.println("\nHere are houses that are less than your budget: \n");
                     houseList.printHousesLessThan(thePrice); 
                  }
               }
               catch (InputMismatchException ime) {
                  System.out.println("Please enter a price between $0 and $1,000,000.");
               }
               break;
                  
            case 4: //  Case 4: Print all the house
               //Prints all houses. 
               System.out.println("\nThese are all the houses: \n");
               houseList.printAllHouses();
               break; 
                  
            default: //Default: Prints message if invalid menu option. 
               System.out.println("Invalid menu option! "
                     + "Choose another one.\n");
               break;
         }
       
      }
     
   }
   
   /**
    * menu Method; Prints the menu and asks the user for their input.
    * @return userMenuInput Integer that holds user input. 
    */
   public static int menu() {
      //Creates a scanner to take in user input.
      Scanner userInput = new Scanner(System.in);
      //Holds the user input value. 
      int userMenuInput = 5;
     //Print out menu. 
      try {
         System.out.println("Welcome to the real estate listings menu!\n"
               + "1.) Add a house.\n"
               + "2.) Remove a house.\n"
               + "3.) Print a house that costs less than a given price.\n"
               + "4.) Print all houses.\n"
               + "0.) Exit menu.\n"
               + "Enter a number: ");
         userMenuInput = userInput.nextInt();
      }
      //Catches non-integer input. 
      catch (InputMismatchException e) {
         System.out.println("Please enter an integer between 0 and 4!");
      }
      return userMenuInput;
   }
    
    /**
     * createHouse Method; Creates a house using user input.
     * @return house A House object that holds the user-created house.
     * @throws HouseException Exception for an invalid house object. 
     */
   public static House createHouse() throws HouseException{
      //Holds the user's input MLS.
      int mls; 
      //Holds the user's input bedrooms.
      int bedrooms; 
      //Holds the user's input price.
      double price; 
      //Holds the user's input seller.
      String seller;
      //Creates the scanner to take in user input. 
      Scanner houseInfo = new Scanner(System.in);
      
      //Asks for user input.
      System.out.println("Time to add a house!\n"
         + "Enter the MLS (10001-99999): ");
      mls = houseInfo.nextInt();
   
      houseInfo = new Scanner(System.in); //Clears the scanner.
      System.out.println("Enter the amount of bedrooms (0-5): ");
      bedrooms = houseInfo.nextInt(); 
      
      houseInfo = new Scanner(System.in); //Clears the scanner.
      System.out.println("Enter the price ($0 and $1,000,000): ");
      price = houseInfo.nextDouble(); 
      
      houseInfo = new Scanner(System.in); //Clears the scanner.
      System.out.println("Enter the seller's name "
         + "(Minimum 2 characters): ");
      seller = houseInfo.nextLine(); 
      
      House house = new House(mls, bedrooms, price, seller);
      return house;
      
   }
   
}