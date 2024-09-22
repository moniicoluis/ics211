/**
* CDBSTI Interface to be used for CDBST.java
*/
public interface CDBSTI {

   /**
    * Inserts node into binary search tree.
    * @param CD cd
    * @exception Any exception.
    * @return boolean.
    */
   abstract boolean addNode(CD cd);
   
   /**
    * Looks for a node within the binary search tree.
    * @param CD cd
    * @exception Any exception.
    * @return boolean.
    */
   abstract boolean findNode(CD cd);
   
    /**
     * Prints binary search tree in inorder
     * traversal using recursion.
     * @param BSTNode root.
     * @exception Any exception.
     * @return No return value.
     */
   abstract void printBSTree(BSTNode root);
   
 /**
  * Overloads method of the same name to
  * access private variable root.
  * @param None.
  * @exception Any exception.
  * @return No return value.
  */
   abstract void printBSTree( );
}
