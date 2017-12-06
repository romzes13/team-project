package teama;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Customer class defines customer object.
 * 
 *
 */
public class Customer {
	
	private String firstName;
	private String lastName;
	private int	   rank;
	
	// Default constructor
	public Customer() {
		
	}
	
	// Customer constructor
	public Customer(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName  = lastName;
		rank = 0;
		
		/*Testing, still messing with git :)
		Right now I see the constructor take in two strings, 
		method to randomize the two strings needed*/
	}

	/**
	 * Getters and setters for our private variables.
	 * 
	 */
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Customer name: " + StringUtils.capitalize(firstName) + ", last name: " + StringUtils.capitalize(lastName) + ", rank = " + rank + "]";
	}
	
	

}
