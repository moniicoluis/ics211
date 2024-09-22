public interface BSTNodeI{
/**
 * This method will set newNode as
 * the left child of the current node
 * @param BSTNode new Node to add into a BST
 */
   abstract void setLeftChild(BSTNode newNode);
   
/**
 * This method will set newNode as
 * the right child of the current node
 * @param BSTNode new Node to add into a BST
 */
   abstract void setRightChild(BSTNode newNode);
   
/**
 * This method will return the left child
 * of the current node
 * @param no paramteters
 * @return BSTNode left child
 */
   abstract BSTNode getLeftChild( );
   
/**
 * This method will return the right child
 * of the current node
 * @param no paramteters
 * @return BSTNode right child
 */
   abstract BSTNode getRightChild( );
   
/**
 * This method return the information
 * inside the current node CD
 * @param none
 * @return CD object
 */
   abstract CD getCD( );
   
/**
 * This method return a printable version
 * of the CD inside the current node
 * @param none
 * @return String with the CD information
 */
   abstract String toString( );
}