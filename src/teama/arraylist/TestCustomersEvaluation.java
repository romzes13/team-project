package teama.arraylist;

import java.util.ArrayList;

import teama.Customer;
import teama.Product;
import teama.ProductArrayList;

/**
 * This class runs evaluation methods.
 * 
 * @author Roman
 *
 */
public class TestCustomersEvaluation {

	public static void main(String[] args) {

		/**
		 * Testing Products
		 */

		ProductArrayList paList = new ProductArrayList();
		ArrayList<Product> productList = paList.getListOfProducts();

		System.out.println(" Products total = " + productList.size());
		System.out.println(" Products: " + paList.lookUpItemPrice("box"));
		System.out.println(" Product #155  " + productList.get(155).toString());

		/**
		 * Testing Customers
		 */

		// Initializing arraylist with names and implemented methods
		CustomerArrayList caList = new CustomerArrayList();
		// This arrayList has arrayList methods.
		ArrayList<Customer> custListAr = caList.getListOfCustomers();

		// Generating random history purchase
		caList.populatePurHistory();
		
		/**
		 * Timing to calculate all records
		 */
		
		long before = System.currentTimeMillis();
			caList.setAllRatings();
		
			long after = System.currentTimeMillis();
		
			System.out.println("Time took to calculate ratings: " + (after - before) + " milliseconds\n");
			
			
			System.out.println("Look up customer with name: " + caList.lookUpCustomer("kelly"));
			System.out.println("Average rating: " + caList.averageRating());

		// Get the random number from 0 to array.sizi()
		int randomNumber = ((int) (Math.random() * custListAr.size()));
		System.out.println("========================================================\n");
		System.out.println("Random number = " + randomNumber);
		System.out.println("Random name: =" + custListAr.get(randomNumber).getLastName() + "=="
				+ custListAr.get(randomNumber).getFirstName() + "= and rank = "
				+ custListAr.get(randomNumber).getRank());
		
		System.out.println("========================================================\n");
		
		// Get customer id
		String name = "kelly";
		System.out.println("Customer name: " + name + " matches: " + caList.lookUpCustomer(name));
		
		// Get customer id
		int id = custListAr.indexOf(caList.lookUpCustomer(name));
		System.out.println("At index=" + id );
		
		
		System.out.println("\nTotal=" + caList.countCustomerAmount(id));
		
		
		

		
		
		
	}

}
