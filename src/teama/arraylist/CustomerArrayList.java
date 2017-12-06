package teama.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
import teama.ProductDataFile;
/**
 * CustomerArrayList class contains implemented methods
 * from Evaluation interface.
 * 
 * @author Roman
 *
 */
public class CustomerArrayList  implements Evaluation{
	

	// Creating and populating ArrayList of customers from file.
	
		private  CustomersDataFile   cd;	
		private  ArrayList<Customer> listOfCustomers;
	
	// purchaseHistory of each customer, where Integer is index same as 
	// ArrayList Customer index.
		
		private  ArrayList<LinkedList<Integer>> purchaseHistory;
		private  ArrayList<Product> listOfProducts;
		private  ProductDataFile productDF;

	
	// Constructor creates and populates Customers array from the file
	public CustomerArrayList() {
		   
		   cd = new CustomersDataFile();
		   listOfCustomers = cd.getList();
		   
		   // Setting initial capacity 
		   purchaseHistory = new ArrayList<>(listOfCustomers.size());
		
	}
	
	/**
	 * Populates purchase history.
	 */
	public void populatePurHistory() {
		
		long before = System.currentTimeMillis();
		
		productDF = new ProductDataFile();
		listOfProducts = productDF.getPList();
		
		int productsTotal = listOfProducts.size();
		System.out.println("\nProducts total: " + productsTotal);
		
		int totalPurchasesAded =0;
		
		// Populating arrayList 
		for( int i = 0; i < listOfCustomers.size(); i++) 
		{
			LinkedList<Integer> ll = new LinkedList<>();
			
			// Generating random number of Nodes to be inserted
			// from 0 to 20 purchases
			int randomTotal = ((int) (Math.random() * 20));
			
			for(int j = 0; j < randomTotal; j++) 
				
			{
				// Random productID from 1 to total number of products
				int randomProductID = ((int) (Math.random() * productsTotal + 1));
				// Add it to LinkedList
				ll.add(randomProductID);
				
				// increasing counter to get total number of sales/purchases
				// of all customers
				totalPurchasesAded++;
				
			}
			purchaseHistory.add(ll);
			
		}
		System.out.println("Purchase history populated with: " + totalPurchasesAded + "\n");
		
		long after = System.currentTimeMillis();
		System.out.println("Time took to populate purchaseHistory: " + (after - before) + " milliseconds\n");
		
		
		
	}
	
	
	/**
	 * Implemented methods from Evaluation:
	 */
	
	
	/**
	 * Look up customer by last name and return Customer object.
	 * TODO Check if list is empty first.
	 * TODO It uses linear search now, change it to binary search.
	 * Also how to deal with multiple names? Return ListOfCustomers
	 * maybe?
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
	
	// Getter for listOfCustomers
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
