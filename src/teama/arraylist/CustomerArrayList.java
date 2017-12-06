package teama.arraylist;

import java.util.ArrayList;
import java.util.Collections;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
/**
 * CustomerArrayList class contains implemented methods
 * from Evaluation interface.
 * 
 * @author Roman
 *
 */
public class CustomerArrayList  implements Evaluation{
	

	// Creating and populating ArrayList of customers from file.
	private  CustomersDataFile cd;	
	private  ArrayList<Customer> listOfCustomers;
	

	public CustomerArrayList() {
		   cd = new CustomersDataFile();
		   listOfCustomers = cd.getList();
		
	}
	
	
	
	/**
	 * Implemented methods:
	 */
	
	
	/**
	 * Look up customer by last name and return Customer object.
	 * TODO Check if list is empty first.
	 * 
	 */
	
	public Customer lookUpCustomer(String name) {
		System.out.println("Looking up: " + name + " from " + listOfCustomers.size() + " names");
		for(Customer c : listOfCustomers) {
			if(c.getLastName().equals(name))
				return c;
		}
		System.out.println("No name has been found!");
		return null;
	}

	
	/**
	 * Count customer rating from purchase history.
	 */
	public int countCustomerRating(String name) {
		// TODO 
		return 0;
	}

	@Override
	public Product lookUpProduct(String name) {
		// TODO Generate list of products.
		return null;
	}

	/**
	 * Calculating average rating.
	 */
	@Override
	public double averageRating() {
		int total = 0;
		for(Customer c : listOfCustomers) {
			//total += c.getRank();
			total = total + c.getRank();
		}
		System.out.println("Printing from average, total=" +total);
		return total/listOfCustomers.size();
	}

	/**
	 * Count all customer ratings based on their purchase history.
	 * TODO Generate list of products and prices.
	 */
	@Override
	public void countAllRatings() {
		for(Customer c : listOfCustomers) {
			
				
		}
		
	}
	/**
	 * Setting temporary ratings for customers, 
	 * from 0 to 10
	 * TODO Generate ProductList file.
	 */
	public void setAllRatings() {
		for(Customer c : listOfCustomers) {
			c.setRank((int )(Math.random() * 10));
		}
		
	}
	
	public ArrayList<Customer> getListOfCustomers() {
		return listOfCustomers;
	}



	@Override
	public Customer lookUpCustomer(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int countCustomerRating(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Added method to Shuffle the list in random order.
	
	public ArrayList<Customer> shuffleList() {
		Collections.shuffle(listOfCustomers);
		return listOfCustomers;
	}
	

}
