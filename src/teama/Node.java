package teama;

/**
 *
 * @author Dan
 */
public class Node {
    
    public int id;              // customer id
    public Node leftChild;      // Node left child
    public Node rightChild;     // Node right child
    
    public void displayNode() {
        System.out.print("{id: " + id);
    }
}
