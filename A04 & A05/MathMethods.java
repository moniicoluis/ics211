/**
* MathMethods - implements MathOperations. Finds the sum,
*                 the absolute values, or if it is even.
* @author Monico Luis
*/
public class MathMethods implements MathOperations{

   private double dNum1; //Holds the first double number.
   private double dNum2; //Holds the secoond double number. 
   private int iNum;     //Holds an integer.
   
 /**
  * add; takes two doubles as parameters and adds them.
  * @param double d1, first number to add
  * @param double d2, second number to add
  * @return double, the addition of d1 + d2 
  */     
   public double add(double d1, double d2){
      this.dNum1 = d1;
      this.dNum2 = d2;
      return (this.dNum1 + this.dNum2);
   }
   
 /**
  * absoluteValue; takes a double as a parameter and finds the 
  *                  absolute value. 
  * @param double dNum, first number to add
  * @return double, the addition of dNum1 + dNum2 
  */
   public double absoluteValue(double dNum){
      this.dNum1 = dNum;
      if (this.dNum1 < 0) {
         return this.dNum1 *= -1;
      }
      else {
         return this.dNum1;
      }
   }
   
 /**
  * This method will receive an int number as a parameter
  * it will determine if the number is even 
  * @param int iNum
  * @return boolean true if the number is even, false otherwise
  */

   public boolean isEven(int iNum){
      this.iNum = iNum;
      if (this.iNum % 2 == 0) {
         return true;
      }
      else {
         return false;
      }
      
   }

}