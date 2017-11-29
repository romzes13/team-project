package teama;

/**
 * The Node class
 */

/**
 * @author Daniel
 */

public class Node {
    
   public String firstName;       // Customer first name
   public String lastName;        // Customer last name
   public Node child;             // Node's child
   
   /*
   Empty constructor
   */
   public Node() {
       
   }
   
   /*
   Constructor
   */
   public Node(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }
   
   /**
    * Display Node contents
    */
   public void displayNode() {
       System.out.print('{');
       System.out.print(firstName + ", ");
       System.out.print(lastName + '}');
   }
}