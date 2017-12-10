package teama.hashtable;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
import teama.ProductArrayList;
import teama.ProductDataFile;
import teama.arraylist.*;
import java.util.*;

public class HashTable implements Evaluation {

	private Hashtable<Customer, LinkedList> customerProduct = new Hashtable();
	private CustomerArrayList cList;
	private ProductArrayList pList;
	private ArrayList<Customer> custArl;
	private ArrayList<LinkedList<Integer>> purchaseHistory;
	private ArrayList<Product> productArl;
	

	public HashTable() {
		cList = new CustomerArrayList();
		custArl = cList.getListOfCustomers();
		cList.populatePurHistory();
		purchaseHistory = cList.getPurchaseHistory();
		pList = new ProductArrayList();
		productArl = pList.getListOfProducts();
		populateTable(custArl, purchaseHistory);

	} 
	

	public void populateTable(ArrayList<Customer> custL, ArrayList<LinkedList<Integer>> purHistory) {
		for (int i = 0; i < custL.size(); i++) {
			customerProduct.put(custL.get(i), purHistory.get(i));
		}

	}

	// Scroll through the table and print out each value (i.e. purchase history
	// node)

	public void printValues(HashTable table) { // Might need to change void (to hashtable) and cast the HashTable

		long before = System.currentTimeMillis();

		Enumeration l = customerProduct.elements();
		while (l.hasMoreElements())
			System.out.println("$" + l.nextElement());

		long after = System.currentTimeMillis();
		System.out.println("Time taken to print values from table: " + (after - before) + " milliseconds\n");
	}

	// Scroll through the table and print out each key (i.e. Customer object)
	public void printKeys(HashTable table) {

		long before = System.currentTimeMillis();

		Enumeration k = customerProduct.keys();
		while (k.hasMoreElements())
			System.out.println(k.nextElement());

		long after = System.currentTimeMillis();
		System.out.println("Time taken to print keys from table: " + (after - before) + " milliseconds\n");
	}

	//TODO Search method
	public int searchCustomer(String firstName, String lastName){

	
	    System.out.println("Looking up Customer from: " + customerProduct.size() + " total customers");
	    int count = 0;
		Enumeration<Customer> n = customerProduct.keys();
		boolean flag = false;
		while (n.hasMoreElements()) {
			count++;
			if(n.nextElement().toString().contains(firstName + ", " + "last name: " + lastName)) {
				System.out.println("Customer: " + firstName + " " + lastName + " exists in HashTable");
				System.out.println("Customer is located at key: " + count);
			    System.out.println("Next Customer Key = " + n.nextElement());
			    flag = true;
			    break;
			}		
		
		}
		if(flag == false) 
			System.out.println("There is no record of Customer: " + firstName + " " + lastName);
	
		return count;  //Return index of where Customer key corresponds to
	}
	
	
	public double totalSpentPerCustomer(int key) {
			
			//total spent
			double total = 0;
			
			//create a new temp LinkedList to replicate the value LinkedList
			LinkedList tempValue = new LinkedList();
			
			//Store the searched customers value into this list
			Customer target = new Customer();
			target = custArl.get(key);
	
			tempValue = customerProduct.get(target);
			Product tempProduct = new Product();
		
			
			for(int i = 0; i < tempValue.size(); i++) { //testing the total, keeps giving different sums
				double tempTotal = 0;
				int pid = (int) tempValue.get(i);
				tempProduct = productArl.get(pid);
				tempTotal = tempProduct.getPrice();
				total = tempTotal + total;
				
			}
			System.out.println("Total spent for customer at key " + key + " = $" + total);
			
	

		   
			
			//This is supposed to set the rating for a specific customer however since the Customer is the key,
			//I don't know how to tap into the key and change the customer ranking. 
			
			/*if(total <=  0) {
				customerProduct;
				System.out.println("Customer rank is: unranked");
			}
			
			if(total > 0 && total < 150) {
				listOfCustomers.get(customer).setRank(1);
				System.out.println("Customer rank is: level 1");
			}
			
			if(total >= 150 && total < 300) {
				listOfCustomers.get(customer).setRank(2);
				System.out.println("Customer rank is: level 2");
			}
			
			if(total >= 300 && total < 450) {
				listOfCustomers.get(customer).setRank(3);
				System.out.println("Customer rank is: level 3");
			}
			
			if(total >= 450 && total < 600) {
				listOfCustomers.get(customer).setRank(4);
				System.out.println("Customer rank is: level 4");
			}
			
			if(total >= 600 && total < 750) {
				listOfCustomers.get(customer).setRank(5);
				System.out.println("Customer rank is: level 5");
			}
			
			if(total >= 750) {
				listOfCustomers.get(customer).setRank(6);
				System.out.println("Customer rank is: level 6, Master rank");
			}
				System.out.println("$" + total + " total spent");
				return total; */
			return total;
		
	} 


	// Return the table
	public Hashtable<Customer, LinkedList> getTable() {
		return customerProduct;
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

	public void printTable(HashTable test) {
		// TODO Auto-generated method stub
		
	}

}
