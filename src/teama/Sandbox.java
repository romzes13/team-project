package teama;

/**
 * Sandbox for testing class methods
 */
public class Sandbox {
    
    public static void main(String[] args){
        Customer customer = new Customer("John", "Doe");
        Node node = new Node(customer.getFirstName(), customer.getLastName);
        node.displayNode();
    }
}
