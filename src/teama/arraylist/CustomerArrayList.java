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
 * @author Roman Edited by Thomas
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
			int randomTotal = ((int) (Math.random() * 30));

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
		System.out.println("Purchase history populated with: " + totalPurchasesAded + " purchases\n");

		long after = System.currentTimeMillis();
		System.out.println("Time took to populate purchaseHistory: " + (after - before) + " milliseconds\n");

	}



	/*
	 * Calculating the total money spent for the specified linkedlist. We want to go
	 * to the linkedList of the specified customer and calculate the total money
	 * spent in the purchase history (linkedlist). This may help with customer
	 * ratings.
	 */

	public double totalSpentPerCustomer(int customer) { // May turn into string argument for ease of access.

		// Total amount
		double total = 0;

		// Trying to get to the specified linkedlist to iterate through it
		LinkedList<Integer> customerList = purchaseHistory.get(customer);

		// The linkedlist contains references to the products in our ProductArrayList.
		ProductArrayList paList = new ProductArrayList();
		ArrayList<Product> productList = paList.getListOfProducts();

		// We need to go through each node in the purchase history and get the price
		// Each run through we'll keep adding up the total price.

		for (int i = 0; i < customerList.size(); i++) {
			double tempTotal = 0;
			int pid = customerList.get(i);
			Product tempProduct = productList.get(pid);
			tempTotal = tempProduct.getPrice();

			total = tempTotal + total;

		}

		if (total <= 0) {
			listOfCustomers.get(customer).setRank(0);
			System.out.println("Customer rank is: unranked");
		}

		if (total > 0 && total < 150) {
			listOfCustomers.get(customer).setRank(1);
			System.out.println("Customer rank is: level 1");
		}

		if (total >= 150 && total < 300) {
			listOfCustomers.get(customer).setRank(2);
			System.out.println("Customer rank is: level 2");
		}

		if (total >= 300 && total < 450) {
			listOfCustomers.get(customer).setRank(3);
			System.out.println("Customer rank is: level 3");
		}

		if (total >= 450 && total < 600) {
			listOfCustomers.get(customer).setRank(4);
			System.out.println("Customer rank is: level 4");
		}

		if (total >= 600 && total < 750) {
			listOfCustomers.get(customer).setRank(5);
			System.out.println("Customer rank is: level 5");
		}

		if (total >= 750) {
			listOfCustomers.get(customer).setRank(6);
			System.out.println("Customer rank is: level 6, Master rank");
		}

		// Print and return total
		System.out.println("$" + total + " total spent");
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
	 * 
	 * @return total amount of money spent.
	 */

	public double countCustomerAmount(int id) {

		double total = 0;

		LinkedList<Integer> ll = new LinkedList<>(); // Customer purchase history
		ll = purchaseHistory.get(id);

		// Print all elements in list
		for (Integer productId : ll) {

			// System.out.println("Product id = " + productId + " " +
			// listOfProducts.get(productId).toString());
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

			double total = countCustomerAmount(index);

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

	// Method to print whole list
	public void printCustomerList() {
		long before = System.currentTimeMillis();

		for (Customer c : listOfCustomers) {
			System.out.println(c);
		}

		long after = System.currentTimeMillis();
		System.out.println("Time taken: " + (after - before) + "milliseconds\n");

	}

	@Override
	public Product lookUpProduct(String name) {
		// TODO Generate list of products.
		return null;
	}

	/**
	 * Calculating the average rating of all customers.
	 */
	@Override
	public double averageRating() {

		// Creates new instance of ProductArrayList, reading in from the .txt file

		// two variables for calculating average
		double count = 0;
		double average = 0;

		// Nested for-loop to cycle through each customer, grab their productHistory,
		// add it, set their ranking and count
		// what ranking they are.

		for (int i = 0; i < listOfCustomers.size(); i++) {
			double total = 0;
			LinkedList<Integer> customerList = purchaseHistory.get(i);
			for (int j = 0; j < customerList.size(); j++) {
				double tempTotal = 0;
				int pid = customerList.get(j);
				Product tempProduct = listOfProducts.get(pid);
				tempTotal = tempProduct.getPrice();

				total = tempTotal + total;

			}
			
			if (total <= 0) {
				listOfCustomers.get(i).setRank(0);
				count = count + 0;
			}

			if (total > 0 && total < 150) {
				listOfCustomers.get(i).setRank(1);
				count = count + 1;
			}

			if (total >= 150 && total < 300) {
				listOfCustomers.get(i).setRank(2);
				count = count + 2;
			}

			if (total >= 300 && total < 450) {
				listOfCustomers.get(i).setRank(3);
				count = count + 3;
			}

			if (total >= 450 && total < 600) {
				listOfCustomers.get(i).setRank(4);
				count = count + 4;
			}

			if (total >= 600 && total < 750) {
				listOfCustomers.get(i).setRank(5);
				count = count + 5;
			}

			if (total >= 750) {
				listOfCustomers.get(i).setRank(6);
				count = count + 6;
			}

		}

		// Calculate the average based off the count added and the total amount of
		// customers.

		average = count / listOfCustomers.size();
		System.out.println("The average ranking is: " + average);
		return average;
	}

	/**
	 * Count all customer ratings based on their purchase history.
	 * 
	 */
	@Override
	public void countAllRatings() {

		int total = listOfCustomers.size();

		for (int i = 0; i < total; i++) {

			double amount = countCustomerAmount(i);
			int rank = setCustomerRating(amount);
			listOfCustomers.get(i).setRank(rank);
		}
	}

	/**
	 * Setting ratings for customers, from 0 to 11.
	 * 
	 */
	public void setAllRatings() {

		int total = listOfCustomers.size();
		for (int i = 0; i < total; i++) {

			double amount = countCustomerAmount(i);

			int rank = setCustomerRating(amount);
			// System.out.println("rank="+rank);
			listOfCustomers.get(i).setRank(rank);
		}

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

	// Getter for listOfCustomers
	public ArrayList<Customer> getListOfCustomers() {
		return listOfCustomers;
	}

	public ArrayList<LinkedList<Integer>> getPurchaseHistory() {
		return purchaseHistory;
	}

	// Added method to Shuffle the list in random order.

	public ArrayList<Customer> shuffleList() {
		Collections.shuffle(listOfCustomers);
		return listOfCustomers;
	}

}
