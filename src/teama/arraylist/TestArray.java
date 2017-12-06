package teama.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;

import teama.Customer;
import teama.Product;
import teama.ProductArrayList;
/**
 * TestArray class tests implemented methods from CustomerArrayList.
 * 
 * @author roman
 *
 */
public class TestArray {
	
	// ArrayList of Products
	public	ArrayList<Product> listOfProducts = new ArrayList<>();
			
	// ArrayList of Customers
	private static ArrayList<Customer> listOfCustomers = new ArrayList<>();
	

	public static void main(String[] args) {
		
		/**
		 * From here: different data structures, nodes and LinkedList
		 * just for testing and examples and should be deleted. 
		 */
		Customer customer1 = new Customer("Roman", "Babushkin");
		Customer customer2 = new Customer("Joe", "Bro");
		Customer customer3 = new Customer("Jenna", "Kelly");
		Customer customer4 = new Customer("Maria", "Kunis");
		
		// Adding customers to listNode
		ListNode<Customer> c1 = new ListNode<Customer>(customer1);		
		ListNode<Customer> c2 = new ListNode<Customer>(customer2);
		ListNode<Customer> c3 = new ListNode<Customer>(customer3);
		ListNode<Customer> c4 = new ListNode<Customer>(customer4);

		// Every node points to the next node
		c1.setNext(c2);
		c2.setNext(c3);
		c3.setNext(c4);
		
		// Adding customers to listOfCustomers
		
		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
		listOfCustomers.add(customer3);
		listOfCustomers.add(customer4);
		
		
		System.out.println("Nodes=" + c4.getItem());
		
		System.out.println("List of customers: " + listOfCustomers);
		
		// Set the rank to 9 from 0
		System.out.println("List of customers: " + listOfCustomers.get(2).getRank());
		listOfCustomers.get(2).setRank(9);
		
		System.out.println("List of customers: " + listOfCustomers.get(2).getRank());
		
		LinkedList<Customer> custLinList = new LinkedList<>();
		custLinList.add(customer1);
		custLinList.add(customer2);
		custLinList.add(customer3);
		custLinList.add(customer4);
		
		
		// Printing list of customers
		for(Customer c : custLinList) {
			System.out.println(c.toString());
			
		}
		
		/**
		 * Anything above is for testing LinkNodes and LinkedLists.
		 * 
		 * From here starts main arrayList testing with implemented
		 * methods and some logic.
		 */
		
		// Initializing arraylist with names and implemented methods
		CustomerArrayList caList = new CustomerArrayList();
		// This arrayList has arrayList methods.
		ArrayList<Customer> custListAr = caList.getListOfCustomers();
		
		caList.setAllRatings();
		
		System.out.println("Average rating: " + caList.averageRating());
		//TODO Fix lookUpCustomer method or way o save last name without commas
		System.out.println("Look up customer with name: " + caList.lookUpCustomer("kelly"));
		
		//
		System.out.println("First name: =" + custListAr.get(0).toString());
		
		
		// Get the random number from 0 to array.sizi()
		int randomNumber = ((int )(Math.random() * custListAr.size()));
		System.out.println("Random number = " + randomNumber);
		System.out.println("Random name: =" + custListAr.get(randomNumber).getLastName() + "==" 
					+ custListAr.get(randomNumber).getFirstName() + "= and rank = " + custListAr.get(randomNumber).getRank());
		
		/**
		 * Testing Products
		 */
		
		ProductArrayList paList = new ProductArrayList();
		ArrayList<Product> productList = paList.getListOfProducts();
		
		System.out.println(" Products total = " + productList.size());
		System.out.println(" Products: " + paList.lookUpItemPrice("box"));
		System.out.println(" Product #155  " + productList.get(155).toString());
		
	
		
	} // End of main

}
