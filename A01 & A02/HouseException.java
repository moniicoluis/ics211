/**
* HouseException - Creates and extends Exceptions
*                    for House.
* @author Monico Luis 
*/
public class HouseException extends Exception {
  //String that holds the message for the exception. 
   private String exceptionMessage = "The program has crashed!";
   
   /**
   * Constructor method; Creates the exception. 
   * @param exceptionMessage The message for the exception. 
   */
   public HouseException(String exceptionMessage) {
      setMessage(exceptionMessage);
   }
   
   /**
   * Set method; Sets the message for the exception.
   * @param exceptionMessage The message for the exception.
   */
   public void setMessage(String exceptionMessage) {
      this.exceptionMessage = exceptionMessage; 
   }
   
   /**
   * Get method; Gets the message for the exception.
   * @return exceptionMessage Returns the exception's method. 
   */
   public String getMessage() {
      return this.exceptionMessage; 
   }
   
}