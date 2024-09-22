import java.util.InputMismatchException; //Allows use of the exception.
import java.util.Random; //Allows use of the random class.
import java.util.Scanner; //Allos use of the scanner class.

/**
* Payroll -- A program that takes user input and calculates the
*              payroll for the randomly generated employees.
*
* @author Monico Luis
*/
public class Payroll {
    
    /**
    * main method; Takes user input, validates it, and initializes the 2D array
    *                with random numbers.
    * @param args Holds command line arguments. 
    */
   public static void main(String[] args) {
      int[][] employeeArr; //2D Int array that holds the hours worked by each employee.
      int[] employeeHours; //Int array that holds the sum of hours worked by each employee. 
      int employeeCount; //Int that holds the user input of employee amount.
      Scanner userInput = new Scanner(System.in); //Creates scanner object for user input.
      Random rand = new Random(); //Creates random object for random number.
      int randomNum; //Int that holds random number.
   
      System.out.println("Welcome to the ICS 211 payroll program!\n");
      System.out.println("Enter the number of employees (5-20): ");
      
      //Catches invalid input and throws exception.
      try {
         //Asks for user input. 
         employeeCount = userInput.nextInt();
         if (employeeCount < 5 || employeeCount > 20) { //Validates user input. 
            System.out.println("Please input a number between 5 and 20!");
            System.out.println("Exiting the program...");
         }
         
         else {
         
            //Initializes array that is 5 by whatever the user inputs.
            //Each column represents an employee, each row represents a day.
            employeeArr = new int[5][employeeCount];
            
            //Fills array with random numbers. 
            for (int row = 0; row < employeeCount; row++) { 
               for (int column = 0; column < 5; column++) {
                  randomNum = rand.nextInt(13); //Generates number (0-12).
                  employeeArr[column][row] = randomNum;
               }
            }
            
            System.out.println("\nPrinting all employees and hours...\n");
            System.out.println("\t\t\t\t  MON  TUE  WED  THU  FRI");
            
            //Prints out the employee number and their hours. 
            for (int row = 0; row < employeeCount; row++) {
               System.out.print("Employee " + (row + 1) + "\t");
               for (int column = 0; column < 5; column++) {
                  System.out.printf("%5d", employeeArr[column][row]);
               }
               System.out.println();
            }
            //Initializes employeeHours array of the size of the user's input.
            //The array is used to store the total amount of hours each employee worked each week. 
            employeeHours = new int[employeeCount];
            //Calls the calculatePayroll method.
            calculatePayroll(employeeArr, employeeHours);
         }
      }
      
      catch (InputMismatchException ime) {
         System.out.println("Invalid input! Please enter an integer.");
      }
   }
    /**
    * calculatePayroll; Prints the hours worked by each worker and calculates
    *                      the pay of each worker.
    * @param employeeArr A 2D array that holds the hours worked by each worker.
    * @param employeeHours An array that holds the total hours worked by each employee. 
    */
   public static void calculatePayroll(int[][] employeeArr, int[] employeeHours) {
      int totalHours; //Int that holds the total of hours worked.
      double totalPay; //Double that holds the total pay of each worker.
      final double REGULAR_PAY = 14.50; //Double that holds regular pay rate.
      final double OVERTIME_PAY = 21.75; //Double that holds overtime pay rate. 
      
       //Loops over the columns and adds them together. 
      for (int i = 0; i < employeeArr[0].length; i++) {
         totalHours = 0;
         for (int j = 0; j < employeeArr.length; j++) {
            totalHours += employeeArr[j][i];
            
         }
         //Adds the employee's individual sum of hours to employeeHours array. 
         employeeHours[i] = totalHours;
      }
      
      //Prints out the hours worked by each employee. 
      System.out.println("\nHours worked by each employee\n");
      for (int i = 0; i < employeeHours.length; i++) {
         //Uses the employeeHours array to print out result.
         System.out.println("Employee " + (i + 1) + " worked for " + employeeHours[i] + " hour(s).");
      }
      
      //Prints out the employees that worked overtime and by how many hours. 
      System.out.println("\nEmployees that worked overtime");
      for (int i = 0; i < employeeHours.length; i++) {
         if (employeeHours[i] > 40) {
            //Uses the employeeHours array to print out result.
            System.out.println("Employee " + (i + 1) + " overtime = " + (employeeHours[i] - 40) + " hour(s).");
         }
      }
      
      //Prints out the payroll for the employees. 
      System.out.println("\n    PAYROLL FOR THIS WEEK    ");
      //Uses the employeeHours array to print out result. Loops over array to calculate payroll. 
      for (int i = 0; i < employeeHours.length; i++) {
         totalPay = 0;
         if (employeeHours[i] <= 40) { //Calculates regular pay. 
            totalPay = (employeeHours[i] * REGULAR_PAY);
         }
         else { //Calculates overtime pay.
            totalPay = (((employeeHours[i] - 40) * OVERTIME_PAY) + 580);
         }
         //Print and formats the pay. 
         System.out.printf("Employee " + (i + 1) + " pay: $%.2f.%n", totalPay);
      }
   }

}