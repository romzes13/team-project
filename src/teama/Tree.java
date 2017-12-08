package teama;

public class Tree implements Evaluation {
    
    private Node root;
    
    /* Constructor */
    public Tree() {
        root = null;
    }
    	
   /**
    * Insert method adapted from Lafore, R. (2003). Binary Trees. Data Structures and 
    * Algorithms in Java (2nd ed.). Sams Publishing.
    */
   
    /**
     * Insert method inserts a new node
     * @param id
     */
    public void insert(int id) {
        Node newNode = new Node();
        newNode.id = id;
        
        if(root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while(true) {
                parent = current;
                if(id < current.id) {
                    current = current.leftChild;
                    if(current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if(current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

	
  	/**
	 * Look up customer
	 * @param name
	 * @return Customer information.
	 */
	public Customer lookUpCustomer(int id, String lastName, String firstName) {
		Node current = root;
        	while(current.id != id) {
		    if(id < current.id) {
			current = current.leftChild;
			while(current.firstName != firstName) {
				if(firstName.compareTo(current.firstName) < 0)
					current = current.leftChild;
				else
					current = current.rightChild;
			}
			while(current.lastName != lastName) {
				if(lastName.compareTo(current.lastName) < 0) 
					current = current.leftChild;
				else
					current = current.rightChild;
			}
		    }
		    else {
			current = current.rightChild;
			    while(current.firstName != firstName) {
				if(firstName.compareTo(current.firstName) < 0)
					current = current.leftChild;
				else
					current = current.rightChild;
			 }
			    while(current.lastName != lastName) {
				if(lastName.compareTo(current.lastName) < 0) 
					current = current.leftChild;
				else
					current = current.rightChild;
			}
		    }
		    if(current == null)
			return null;
		}
		return current;
    }
	
	/**
	 * Calculates customer rating by provided name.
	 * @return Customer rating.
	 */
	public int countCustomerRating(String lastName, String firstName, int rank) {
		// TODO
    }
	
	/**
	 * Look up product by name.
	 * @param name
	 * @return Product information.
	 */
	public Product lookUpProduct(String lastName, String firstName, String productName) {
    		// TODO
    }
	
	/**
	 * Calculates the average rating of all customers.
	 * @return Average rating.
	 */
	public double averageRating() {
    		return 0;
    }
	
	/**
	 * This method counts all ratings and stores it in
	 * rank for each customer.
	 */
    public void countAllRatings() {
    		return null;
    }
}
