public class CDException extends Exception{
	private String message;

	public CDException( ){
   
	}
   
	public void setMessage(String newMessage){
		this.message = newMessage;
   }
   
   public String getMessage(){
      return this.message;
   }
}