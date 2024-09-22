/**
  * @author Blanca Polo
  */ 

abstract interface MathOperations {

/**
  * This method will receive two double numbers as a parameters
  * it will add them.
  * @param double d1, first number to add
  * @param double d2, second number to add
  * @return double, the addition of d1 + d2
  */
   abstract double add(double dNum1, double dNum2);

/**
  * This method will receive a double number as a parameter
  * it will calculate its absolute value 
  * @param double dNum
  * @return double an absolute value
  */
   abstract double absoluteValue (double dNum);


/**
  * This method will receive an int number as a parameter
  * it will determine if the number is even 
  * @param int iNum
  * @return boolean true if the number is even, false otherwise
  */

   abstract boolean isEven(int iNum);

} //ends class