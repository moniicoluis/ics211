/**
* RPS; Driver class for RPSGUIFile.
* @author Monico Luis 
*/
public class RPS {
    /**
    * main Method; creates the GUI.
    * @param args Holds command line arguments.
    */
   public static void main(String[] args) {
      RPSGUIFile rps = new RPSGUIFile(); 
      rps.initializeGUI();
      rps.setVisible(true); 
   }
   
}