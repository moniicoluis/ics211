/**
 * HNode -- Creates an HNode and its methods.
 * @author Monico Luis
 */
public class HNode {
   //Holds the house object of the node.
   private House house = null;
   //Holds the next node of the current one.
   private HNode next = null;
   
   /**
    * HNode Method; constructor method. Creates the HNode.
    */
   public HNode() {
      this.house = null;
      this.next = null;
   }
   
   /**
    * setNext Method; sets a node to be the next node in the list.
    * @param n An HNode that holds the house of the next node
    */
   public void setNext(HNode n) {
      this.next = n;
   }
   
   /**
    * getNext Method; gets the next node in the lit.
    * @return next An HNode that holds the next node. 
    */
   public HNode getNext() {
      return this.next;
   }
   
   /**
    * setHouse Method; sets the house of the node. 
    * @param h A House object to be assigned to the node. 
    */
   public void setHouse(House h) {
      this.house = h;
   }
   
   /**
    * getHouse Method; gets the house of the node.
    * @return house A House object of the node. 
    */
   public House getHouse() {
      return this.house;
   }
   
   /**
    * toString Method; prints the house in a readable format.
    * @return s The string representation of the house. 
    */
   public String toString() {
      String s = this.getHouse().toString();
      return s;
   }

}