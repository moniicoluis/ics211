import java.util.Scanner;
import java.util.InputMismatchException;

 /**
  * AllRecursive -- Math operations using recursion.
  * @author Monico Luis
  *
  */
public class AllRecursive {
    
    /**
     * main Method; Calls the menu method.
     * @param args Holds command line string arguments. 
     */
   public static void main (String[] args) {
      menu(); 
   }
   
    /**
     * menu Method; Prints the menu and implements the other methods. 
     */
   public static void menu() {
      int menuInput = 5; //Holds the user's input choice. 
      Scanner userScanner = new Scanner(System.in); //Scanner.
      
      try {
         userScanner = new Scanner(System.in); //Clears scanner for recursion purposes.
         System.out.println("Welcome to the math operations menu!\n"
            + "1.) Power Operation\n"
            + "2.) Decrease Operation\n"
            + "3.) Summation Operation\n"
            + "0.) Exit\n"
            + "Enter a number: ");
         menuInput = userScanner.nextInt(); //Takes user input. 
         
         switch (menuInput) {
            case 0: //Exit program.
               System.out.println("Thank you for using this program!"); 
               break;
               
            case 1: //Power method.
               int base; 
               int exponent; 
               Scanner powerScanner = new Scanner(System.in); //Scanner.
               
               try { //Validates the user input. 
                  System.out.println("Enter a positive number to be your base: ");
                  base = powerScanner.nextInt();
               
                  System.out.println("Enter a positive number to your exponent: ");
                  powerScanner = new Scanner(System.in);
                  exponent = powerScanner.nextInt(); 
                  
                  if (base < 0 || exponent < 0 || base > 12 || exponent > 12) { //Only accepts positive ints. 
                     System.out.println("\nPlease enter a positive number lesser than 12!\n");
                     menu();
                  }
                  else {
                     System.out.println( "\n" + base + " to the power of " + exponent + " is " + power(base, exponent) + ".\n");  
                  }
               }
               catch (InputMismatchException ime) { //Catches if the user didn't input an integer. 
                  System.out.println("Please enter an integer!");
               }
               
               menu(); //Calls menu method. Recursion. 
               break;
               
            case 2: //Decrease method.
               int decreaseNum; 
               Scanner decreaseScanner = new Scanner(System.in); //Scanner. 
               
               try { //Validates the user input.
                  System.out.println("Enter a positive number to decrease: ");
                  decreaseNum = decreaseScanner.nextInt();
                  
                  if (decreaseNum < 0 || decreaseNum > 12) { //Only accepts positive ints. 
                     System.out.println("\nPlease enter a positive number lesser than 12!\n");
                     menu();
                  }
                  else {
                     System.out.println("\nHere is the decreasing of " + decreaseNum + ":");
                     System.out.println(decrease(decreaseNum));  
                  }
               }
               catch (InputMismatchException ime) {
                  System.out.println("Please enter an integer!");
               }
               
               menu(); //Calls menu method. Recursion. 
               break;
               
            case 3: //Summation method. 
               int sumNum; 
               Scanner summationScanner = new Scanner(System.in);
               
               try { //Validates the user input.
                  System.out.println("Enter a positive number to fiund the summation of: ");
                  sumNum = summationScanner.nextInt();
                  
                  if (sumNum < 0 || sumNum > 12) { //Only accepts positive ints. 
                     System.out.println("\nPlease enter a positive number lesser than 12!\n");
                     menu();
                  }
                  else {
                     System.out.println("\nThe summation of " + sumNum + " is " + summation(sumNum) + ".\n");  
                  }
               }
               catch (InputMismatchException ime) {
                  System.out.println("Please enter an integer!");
               }
               
               menu(); //Calls menu method. Recursion. 
               break;
               
            default:
               System.out.println("Please  input an integer between 0 and 3!"); 
               break;
         }
      }
      catch (InputMismatchException ime) {
         System.out.println("\nInvalid input! Please input an integer.\n");
         menu();
      }
   }
    
    /**
     * power Method; Multiplies the users base by certain amount of times
     * @param base The base int for the exponent.
     * @param exponent 
     * @return base * power(base, exponent - 1) Uses recursion to multply the 
     *         the base.
     */
   public static int power (int base, int exponent) {
      if (exponent == 0) { //Base case.
         //When exponent reaches zero, returns the value.
         return 1;
      }
      else {
         //Recursion. Calls the method itself to multiply the base by itself.
         return base * power(base, exponent-1);
      }
   }
   
    /**
     * decrease Method; decreases and prints the numer till 0.
     * @param iNum Holds the number that'll be decreased. 
     * @return decrease(iNum - 1) Uses recursion to decrement the iNum.
     */
   public static int decrease (int iNum) {
      if (iNum == 0) { //Base case.
         //When iNum reaches zero, returns zero. 
         return 0;
      }
      else {
         System.out.println(iNum);
         //Recursion. Calls the method itself to decrement number. 
         return decrease(iNum - 1);
      }
   }
    
    /**
     * summation Method; finds the sum of 1 to num. 
     * @param num Holds the number that'll the summation will be found of.
     * @return (num + summation(num - 1) Decrements the num and adds it to itself.
     */
   public static int summation (int num) {
      if (num == 1) { //Base case.
         //When num reaches 1, returns summation. 
         return 1; 
      }
      else {
         //Recursion. Calls the method itself to calculate summation of num. 
         return (num + summation(num - 1));
      }
   } 

}