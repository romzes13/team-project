/**
* The Tree class implements the Evaluation class
* And contains methods for looking up customer names, 
* ratings, and products.
*/

public class Tree implements Evaluation {
  
  private Node root;
  
  /* Constructor */
  public Tree() {
    root = null;
  }
  
  /**
	 * Look up customer by name.
	 * @param name
	 * @return Customer information.
	 */
	public Customer lookUpCustomer(String lastName, String firstName) {
        Node current = root; 
        while(current.lastName != lastName) {
          if(lastName.charAt(0).compareTo(current.lastName.charAt(0)) < 0
            || lastName.charAt(0).compareTo(current.lastName.charAt(0)) > 0) {
            current = current.child;
        }
        return current;
    }
	
	/**
	 * Calculates customer rating by provided name.
	 * @return Customer rating.
	 */
	public int countCustomerRating(String name) {
    
    }
	
	/**
	 * Look up product by name.
	 * @param name
	 * @return Product information.
	 */
	public Product lookUpProduct(String name) {
    
    }
	
	/**
	 * Calculates the average rating of all customers.
	 * @return Average rating.
	 */
	public double averageRating() {
    
    }
	
	/**
	 * This method counts all ratings and stores it in
	 * rank for each customer.
	 */
    public void countAllRatings() {
    
    }
}
