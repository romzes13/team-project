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
  
	// TODO: populate tree with customers and products
	
  /**
	 * Look up customer by name.
	 * @param name
	 * @return Customer information.
	 */
	public Customer lookUpCustomer(String lastName, String firstName) {
		Node current = root; 
		while(current.lastName != lastName) {
		  if(lastName.compareTo(current.lastName) < 0
		    || lastName.compareTo(current.lastName) > 0) {
		    current = current.child;
        }
        return current;
    }
	
	/**
	 * Calculates customer rating by provided name.
	 * @return Customer rating.
	 */
	public int countCustomerRating(String lastName, String firstName, int rank) {
		Node current = root;
		Node currentRank;
		/*
		* While the lastName being searched for does not match current node's lastName, 
		* keep moving down the tree until there is a match
		*/
		while(current.lastName != lastName) {
		  if(lastName.compareTo(current.lastName) < 0
		    || lastName.compareTo(current.lastName) > 0) {
		    current = current.child;		  // current becomes firstName
        	}
			
		/*
		* While the firstName being searched for does not match current node's firstName, 
		* keep moving down the tree until there is a match
		*/
		while(current.firstName ! = firstName) {
			if(firstName.compareTo(current.firstName) < 0
		     	|| firstName.compareTo(current.firstName) > 0) {
			  current = current.child;	// current node becomes rank
			  currentRank = current.rank; // found rank
		  	}
		}
        return current;
	return currentRank;
    }
	
	/**
	 * Look up product by name.
	 * @param name
	 * @return Product information.
	 */
	public Product lookUpProduct(String lastName, String firstName, String productName) {
    		Node current = root;
		Node currentProduct;
		/*
		* While the lastName being searched for does not match current node's lastName, 
		* keep moving down the tree until there is a match
		*/
		while(current.lastName != lastName) {
		  if(lastName.compareTo(current.lastName) < 0
		    || lastName.compareTo(current.lastName) > 0) {
		    current = current.child;		  // current becomes firstName
        	}
			
		/*
		* While the firstName being searched for does not match current node's firstName, 
		* keep moving down the tree until there is a match
		*/
		while(current.firstName ! = firstName) {
			if(firstName.compareTo(current.firstName) < 0
		     	|| firstName.compareTo(current.firstName) > 0) {
			  current = current.child;	// current node becomes rank
			  currentRank = current.rank; // found rank
		  	}
		}
			
		/*
		* While the firstName being searched for does not match current node's firstName, 
		* keep moving down the tree until there is a match
		*/
		while(current.productName ! = productName) {
			if(productName.compareTo(current.productName) < 0
		     	|| productName.compareTo(current.productName) > 0) {
			  current = current.child;	// current node becomes 
			  currentProduct = current.name; // found rank
		  	}
		}
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
