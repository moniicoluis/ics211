import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

 /**
 * RealEstate - A program that takes user input to create a house,
 *              remove a house, print all houses or houses lower than
 *              the user's price point.
 *
 * @author Monico Luis.
 */
public class RealEstate {
   
    /**
    * main Method; Prints and loops through menu.
    * @param args Holds command line arguments.
    * @throws HouseException Throws exception for invalid inputs for House. 
    */
   public static void main(String[] args) throws HouseException {
      //Create an array holding House objects.
      final int SIZE = 30;
      House[] myHouseArr = new House[SIZE];
      //Creates a scanner to take in user input.
      Scanner userInput = new Scanner(System.in);
      //Holds the user input value. 
      int userMenuInput;
      //Holds the boolean value that keeps the loop functioning.
      boolean mainLoop = true;
      
      //Loops through program until user ends it. 
      while (mainLoop) {
         userMenuInput = menu();
         try {
         //Switches case based on user input. 
            switch(userMenuInput) {
            
               case 0: //  Case 0: End program.
                  System.out.println("Thank you for using this program!");
                  mainLoop = false;
                  break;
                  
               case 1: //  Case 1: Add a House.
                  addHouse(myHouseArr);
                  break;
                  
                  
               case 2: //  Case 2: Remove a House
                  removeHouse(myHouseArr);
                  break;
                  
               case 3: //  Case 3: Print Houses less than given price
                  printCheaperHouses(myHouseArr);
                  break;
                  
               case 4: //  Case 4: Print all the house
                  System.out.println("\nHere is a list of houses: ");
                  System.out.println("---------------------------\n");
                  for (House h : myHouseArr) {
                  //Prints out objects from non-null indices. 
                     if (h != null) {
                        System.out.println(h.toString());
                        System.out.println("\n---------------------------\n");
                     }
                  }
                  break; 
                  
               default: //Default: Prints message if invalid menu option. 
                  System.out.println("Invalid menu option! "
                     + "Choose another one.\n");
                  break;
            }
         }
         catch (InputMismatchException e) {
            System.out.println("\nUnable to create house! "
               + "Please have valid input!\n");
         }
         
      }
     
   }
    
    /**
    * menu -- Prints the menu and asks the user for their input.
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
    * addHouse -- Creates a house and adds it to the array.
    * @param myHouseArr The array of houses. 
    * @throws HouseException Throws exception for invalid inputs. 
    */   
   public static void addHouse(House[] myHouseArr) throws HouseException {
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
   
   
      houseInfo = new Scanner(System.in);
      System.out.println("Enter the amount of bedrooms (0-5): ");
      bedrooms = houseInfo.nextInt(); //Clears the scanner.
      
      houseInfo = new Scanner(System.in);
      System.out.println("Enter the price ($0 and $1,000,000): ");
      price = houseInfo.nextDouble(); //Clears the scanner.
      
      houseInfo = new Scanner(System.in);
      System.out.println("Enter the seller's name "
         + "(Minimum 2 characters): ");
      seller = houseInfo.nextLine(); //Clears the scanner.
      
      //Catches any invalid input and throws exceptions. 
      try {
         House newHouse = new House(mls, bedrooms, price, seller);
         //Loops through array to find conflicting MLS.
         for (int i = 0; i < myHouseArr.length; i++) {
            //If the index is NOT null, checks if object had the same MLS. 
            if (myHouseArr[i] != null) {
               if (newHouse.getMls() == myHouseArr[i].getMls()) {
                  System.out.println("\nThere is a conflicting MLS! "
                                 + "Unable to create the house. "
                                 + "Returning to menu...\n");
                  break;
               }
            }
            //Else fills the index with object. 
            else { 
               myHouseArr[i] = newHouse;
               System.out.println("\nSuccessfully added the house!\n");
               break;
            }
         }
      }
      //Throws HouseException when the house can't be made.
      catch (HouseException e) {
         System.out.println("\nUnable to create a house "
                        + "due to invalid input! Try again!\n");
      }
   }
   
    /**
    * removeHouse -- Removes a house from the array based on user input.
    * @param myHouseArr The array of houses. 
    * @throws HouseException Throws exception for invalid inputs. 
    */
   public static void removeHouse(House[] myHouseArr) throws HouseException {
     //Holds the MLS of the house the user wants to remove.
      int theMls = 0;
      boolean houseFinder = true;
      //Creates scanner to take in user input. 
      Scanner mlsInfo = new Scanner(System.in);
      
      System.out.println("\nRemove a house!\n"
         + "Enter the MLS of the house you want to remove: ");
         
      //Catches if the user input is valid (an integer).
      try {
         theMls = mlsInfo.nextInt();
      }
      catch (InputMismatchException e) {
         System.out.println("\nPlease enter an integer between "
            + "10001 and 99999!\n");
      }
   
      //If the MLS is not in range, returns to menu.
      if (theMls < 10001 || theMls > 99999) {
         System.out.println("\nInvalid MLS! Try again later!\n");
      }
      //Else, checks existing objects for matching MLS.
      else {
         //Loops through entire array.
         for (int i = 0; i < myHouseArr.length; i++) {
            if (myHouseArr[i] != null) {
               //Checks for a matching house. Sets that index to null.
               if (theMls == myHouseArr[i].getMls()) {
                  myHouseArr[i] = null;
                  System.out.println("\nRemoved the house with MLS of: " 
                        + theMls + "\n");
               }
            }
            else{
                  //Prints message if there is no matching MLS in array. 
               System.out.println("\nThere is no matching MLS! "
                        + "Returning to menu...\n");
            }
         }
      
      }
   
   }
   
    /**
    * printCheaperHouses -- Prints a list of houses under a price
                              set by the user.
    * @param myHouseArr The array of houses. 
    * @throws HouseException Throws exception for invalid inputs. 
    */
   public static void printCheaperHouses(House[] myHouseArr) 
      throws HouseException {
     //Holds the user's set price.
      double userBudget = -1.0;
      //Creates a scanner to take in input. 
      Scanner budgetInfo = new Scanner(System.in);
      //Formats userBudget.
      DecimalFormat priceFormatter = new DecimalFormat("$#,###,##0.00");
      
      System.out.println("\nFind a house below your budget!\n"
         + "Enter your price budget: ");
      
      //Catches if the user input is valid (a double);
      try {
         userBudget = budgetInfo.nextDouble();
      }
      catch (InputMismatchException e) {
         System.out.println("\nPlease enter a price between "
            + " $0 and $1,000,000\n");
      }
      
      //Checks if the user price is in range/
      if (userBudget < 0 || userBudget > 1000000) {
         System.out.println("\nInvalid price! Try again later!\n");
      }
      //Else, prints out the houses cheaper than userBudget. 
      else {
         System.out.println("\nHeres a list of houses lower than " 
            + priceFormatter.format(userBudget) + ":\n");
         for (int i = 0; i < myHouseArr.length; i++) {
            //If array is not null, checks for the price. 
            if (myHouseArr[i] != null) {
               if (userBudget > myHouseArr[i].getPrice()) {
                  System.out.println(myHouseArr[i].toString());
                  System.out.println("\n---------------------------\n");
               }
            }
         }
      }
   }
   
   
}