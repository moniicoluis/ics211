/**
 * BSTNode; implements BSTNodeI. Class for BSTNode methods.
 * @author Monico Luis
 */
public class BSTNode implements BSTNodeI{
   
   private CD cd; //CD in the BSTNode
   private BSTNode left; //Left child of the BSTNode
   private BSTNode right; //Right child of the BSTNode
   
   /**
    * Constructor method; holds the cd, left and right child. 
    * @param CD the cd to put into the node
    */
   public BSTNode(CD cd) {
      this.cd = cd; 
      this.left = null;
      this.right = null;
   }
   
   /**
    * This method will set newNode as the left child of the current node.
    * @param BSTNode new Node to add into a BST
    */
   public void setLeftChild(BSTNode newNode) {
      this.left = newNode;
   }
   
   /**
    * This method will set newNode as the right child of the current node.
    * @param BSTNode new Node to add into a BST
    */
   public void setRightChild(BSTNode newNode) {
      this.right = newNode; 
   }
   
   /**
    * This method will return the left child of the current node.
    * @return BSTNode left child
    */
   public BSTNode getLeftChild() {
      return this.left;
   }
   
   /**
    * This method will return the right child of the current node. 
    * @return BSTNode right child
    */
   public BSTNode getRightChild() {
      return this.right;
   }
   
   /**
    * This method returns the information inside the current node CD.
    * @return CD object
    */
   public CD getCD() {
      return this.cd;
   }
   
   /**
    * This method returns a printable version of the CD inside the current node. 
    * @return String with the CD information
    */
   public String toString() {
      return this.cd.toString(); 
   }

}