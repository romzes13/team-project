package teama.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
import teama.ProductArrayList;
import teama.ProductDataFile;

/**
 * CustomerArrayList class contains implemented methods from Evaluation
 * interface for ArrayList solution.
 * 
 * @author Roman
 *	Edited by Thomas
 */
public class CustomerArrayList implements Evaluation {

	// Creating and populating ArrayList of customers from file.

	private CustomersDataFile cd;
	private ArrayList<Customer> listOfCustomers;

	// purchaseHistory of each customer, where Integer is index same as
	// ArrayList Customer index.

	private ArrayList<LinkedList<Integer>> purchaseHistory;
	private ArrayList<Product> listOfProducts;
	private ProductDataFile productDF;

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

		int totalPurchasesAded = 0;

		// Populating arrayList
		for (int i = 0; i < listOfCustomers.size(); i++) {
			LinkedList<Integer> ll = new LinkedList<>();

			// Generating random number of Nodes to be inserted
			// from 0 to 20 purchases
			int randomTotal = ((int) (Math.random() * 20));

			for (int j = 0; j < randomTotal; j++)

			{
				// Random productID from 1 to total number of products
				int randomProductID = ((int) (Math.random() * productsTotal));
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

	/*
	 * Calculating the total money spent for the specified linkedlist. We want to go
	 * to the linkedList of the specified customer and calculate the total money
	 * spent in the purchase history (linkedlist). This may help with customer
	 * ratings.
	 */

	public double totalSpentPerCustomer(int customer){  //May turn into string argument for ease of access.
		
		//Total amount
		double total = 0;

		//Trying to get to the specified linkedlist to iterate through it
		LinkedList<Integer> customerList = purchaseHistory.get(customer); //So far problem is here, initializing it wrong.

		//The linkedlist contains references to the products in our ProductArrayList.
		ProductArrayList paList = new ProductArrayList();
		ArrayList<Product> productList = paList.getListOfProducts();

		//We need to go through each node in the purchase history and get the price
		//Each run through we'll keep adding up the total price.
		
		for(int i = 0; i < customerList.size(); i++) {
			double tempTotal = 0;
			int pid = customerList.get(i);
			Product tempProduct = productList.get(pid);
			tempTotal = tempProduct.getPrice();

			total = tempTotal + total;
						
		}    
		
		//Print and return total
		System.out.println("$" + total);
		return total;
	}

	/**
	 * Implemented methods from Evaluation:
	 */

	/**
	 * Look up customer by last name and return Customer object. TODO Check if list
	 * is empty first. TODO It uses linear search now, change it to binary search.
	 * Also how to deal with multiple names? Return ListOfCustomers maybe?
	 * 
	 */

	public Customer lookUpCustomer(String name) {

		System.out.println("Looking up: " + name + " from " + listOfCustomers.size() + " names");
		for (Customer c : listOfCustomers) {
			if (c.getLastName().equals(name))
				return c;
		}
		System.out.println("No name has been found!");
		return null;
	}

	/**
	 * Count total money each customer spent on purchases.
	 * 
	 * @param id
	 *            Customer id number
	 * @return total amount of money spent.
	 */
	public double countCustomerP(int id) {

		double total = 0;

		LinkedList<Integer> ll = new LinkedList<>(); // Customer purchase history
		ll = purchaseHistory.get(id);

		// Print all elements in list
		for (Integer productId : ll) {

			// System.out.println("Product id = " + productId + " " +
			// listOfProducts.get(productId).toString());
			/**
			 * TODO Got index out of bounds exception below when product id = 466
			 */
			total = total + listOfProducts.get(productId).getPrice();
		}

		return total;
	}

	/**
	 * Count customer rating from purchase history.
	 */
	public int countCustomerRating(String name) {

		int rank = 0;

		if (lookUpCustomer(name) != null) {

			// get customer index number
			int index = listOfCustomers.indexOf(lookUpCustomer(name));
			// get total amount of money customer has spent
			double total = countCustomerP(index);

			// calculate customer rating
			rank = setCustomerRating(total);

			// set customer rating
			listOfCustomers.get(index).setRank(rank);

		} else {

			System.out.println("Customer not found!");
		}

		return rank;
	}

	/**
	 * Set customer rating.
	 * 
	 * @param total
	 *            amount
	 * @return number from 0 to 11
	 */
	public int setCustomerRating(double total) {

		int rank = 0;

		rank = (int) (total / 40);
		// System.out.println("Total =" + total + " and rating = " + rank);

		return rank;
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
		for (Customer c : listOfCustomers) {
			// total += c.getRank();
			total = total + c.getRank();
		}
		System.out.println("Printing from average, total=" + total);
		return total / listOfCustomers.size();
	}

	/**
	 * Count all customer ratings based on their purchase history. TODO Generate
	 * list of products and prices.
	 */
	@Override
	public void countAllRatings() {
		for (Customer c : listOfCustomers) {

		}

	}

	/**
	 * Setting temporary ratings for customers, from 0 to 10 TODO Generate
	 * ProductList file.
	 */
	public void setAllRatings() {

		/*
		 * for(Customer c : listOfCustomers) { //c.setRank((int )(Math.random() * 10));
		 * }
		 */

		int total = listOfCustomers.size();
		for (int i = 0; i < total; i++) {

			double amount = countCustomerP(i);

			int rank = setCustomerRating(amount);

			listOfCustomers.get(i).setRank(rank);

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

	// Added method to Shuffle the list in random order.

	public ArrayList<Customer> shuffleList() {
		Collections.shuffle(listOfCustomers);
		return listOfCustomers;
	}

}
