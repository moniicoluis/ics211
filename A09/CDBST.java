/**
 * CDBST; implements CDBSTI. Class for CD Binary Search Tree methods.
 * @author Monico Luis
 */
public class CDBST implements CDBSTI {
   
   private BSTNode root;  //Root of the binary search tree
    
    /**
     * Constructor method; holds the root of the CDBST.
     */
   public CDBST() {
      this.root = null;
   }
    
   /**
    * Inserts node into binary search tree.
    * @param CD cd
    * @return boolean
    */
   public boolean addNode(CD cd) {
     //If root is null (meaning no nodes in BST)
      if (this.root == null) {
         this.root = new BSTNode(cd); //Add the first node as the root. 
         return true;
      }
      else {
         BSTNode node = new BSTNode(cd); 
         BSTNode pointer = this.root; //Uses the root as the pointer. 
         
         while (pointer != null) {
            //Does not add CDs with the same artist. 
            if(pointer.getCD().equals(cd)) {
               return false;
            }
            //If the CD is greater than pointer CD, go to the right subtree. 
            else if (pointer.getCD().compareTo(cd) < 0) {
               if (pointer.getRightChild() == null) {
                  //If the right child is null, then add the node.
                  pointer.setRightChild(node);
                  return true;
               }
               else {
                  //Otherwise, go down to the next right child, continue while loop. 
                  pointer = pointer.getRightChild(); 
               }
            }
            //If the CD is lesser than pointer CD, go to the left subtree. 
            else {
               if (pointer.getLeftChild() == null) {
                  //If the left childd is null, then add the node. 
                  pointer.setLeftChild(node);
                  return true;
               }
               else {
                  //Otherwise, go down to the next left child, continue while loop. 
                  pointer = pointer.getLeftChild(); 
               }
            }
         }
      }
      return false;
   }
   
   /**
    * Looks for a node within the binary search tree.
    * @param CD cd
    * @return boolean
    */
   public boolean findNode(CD cd) {
     //Use the root as a pointer. 
      BSTNode pointer = root;
      while (pointer != null) {
         //If the pointer CD is equal to the CD to be found, return true. 
         if (pointer.getCD().equals(cd)) {
            return true; 
         }
         //If the pointer CD is lesser than the CD to be found. 
         else if (pointer.getCD().compareTo(cd) < 0) {
            pointer = pointer.getRightChild(); //Go to right subtree. 
         }
         //If the pointer CD is greater than the CD to be found. 
         else {
            pointer = pointer.getLeftChild(); //Go to the left subtree. 
         }
      }
      return false; 
   }
   
   /**
    * Prints binary search tree in inorder traversal using recursion. 
    * @param BSTNode root
    */
   public void printBSTree (BSTNode root) {
      if (root != null) {
         printBSTree(root.getLeftChild());
         System.out.println(root + "\n");
         printBSTree(root.getRightChild()); 
      }
   }
   
   /**
    * @Overload
    * Overloads method of the same name to access private variable root.
    */
   public void printBSTree() {
      printBSTree(root); 
   }
}