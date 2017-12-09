package teama.hashtable;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
import teama.ProductArrayList;
import teama.ProductDataFile;
import teama.arraylist.*;
import java.util.*;

public class HashTable implements Evaluation {

	private Hashtable<Customer, Customer> customerProduct = new Hashtable();
	private CustomerArrayList cList;
	private ProductArrayList pList;

	public HashTable() {
		cList = new CustomerArrayList();
		ArrayList<Customer> custArl = cList.getListOfCustomers();
		cList.populatePurHistory();
		pList = new ProductArrayList();
		ArrayList<Product> productArl = pList.getListOfProducts();
		populateTable(custArl, cList);

	} // constructor currently empty

	public void populateTable(ArrayList<Customer> custL, CustomerArrayList caList) {
		ArrayList<Customer> custArlPurchasehistory = cList.getListOfCustomers();
		for (int i = 0; i < custL.size(); i++) {
			customerProduct.put(custL.get(i), custArlPurchasehistory.get(i));
		}

	}

	// Scroll through the table and print out each index

	public void printTable(HashTable table) { // Might need to change void (to hashtable) and cast the HashTable

		long before = System.currentTimeMillis();

		Enumeration l = customerProduct.elements();
		while (l.hasMoreElements())
			System.out.println(l.nextElement());

		long after = System.currentTimeMillis();
		System.out.println("Time taken to print table: " + (after - before) + " milliseconds\n");
	}

	// Return the table
	public Hashtable<Customer, Customer> getTable() {
		return customerProduct;
	}
	
	//temp method to look up customer
	public void getCustomer(String input) {
		

		System.out.println("Looking up: " + input + " from " + customerProduct.size() + " names");
			if(customerProduct.contains(input)) {
			System.out.println(input);
		}
			else {
				System.out.println("Cannot be found.");
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

	@Override
	public Product lookUpProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double averageRating() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void countAllRatings() {
		// TODO Auto-generated method stub

	}

}
