package teama.arraylist;

import java.util.ArrayList;

import teama.Customer;
import teama.Product;
import teama.ProductArrayList;
/**
 * TestArray class tests implemented methods from CustomerArrayList.
 * 
 * @author Roman
 *
 */
public class TestArray {
	

	public static void main(String[] args) {
		
		/**
		 * 
		 * From here starts main arrayList testing with implemented
		 * methods and some logic.
		 */
		
		// Initializing arraylist with names and implemented methods
		CustomerArrayList caList = new CustomerArrayList();
		// This arrayList has arrayList methods.
		ArrayList<Customer> custListAr = caList.getListOfCustomers();
		caList.setAllRatings();
		caList.shuffleList();
		
		System.out.println("Average rating: " + caList.averageRating());
		
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
