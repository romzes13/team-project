package teama;
/**
 * This interface has to be implemented by each of our solutions.
 * It contains common methods, which help determine program speed
 * and efficiency.
 * @author roman
 *
 */
public interface Evaluation {

	/**
	 * Look up customer by name.
	 * @param name
	 * @return Customer information.
	 */
	public Customer lookUpCustomer(String lastName, String firstName);
	
	/**
	 * Calculates customer rating by provided name.
	 * @return Customer rating.
	 */
	public int countCustomerRating(String lastName, String firstName);
	
	/**
	 * Look up product by name.
	 * @param name
	 * @return Product information.
	 */
	public Product lookUpProduct(String name);
	
	/**
	 * Calculates the average rating of all customers.
	 * @return Average rating.
	 */
	public double averageRating();
	
	/**
	 * This method counts all ratings and stores it in
	 * rank for each customer.
	 */
	public void countAllRatings();
	
	
	
	
	
}
