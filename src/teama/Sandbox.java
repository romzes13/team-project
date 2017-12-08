package teama;

import java.util.ArrayList;

import teama.arraylist.CustomerArrayList;

/**
 * Sandbox for testing class methods
 */
public class Sandbox {

	public static void main(String[] args) {

		// Testing some methods on shuffling and displaying the customers. Feel free to
		// delete if needed.
		long before = System.currentTimeMillis();

		CustomerArrayList caList = new CustomerArrayList();
		ArrayList<Customer> custListAr = caList.getListOfCustomers();

		caList.populatePurHistory();
		caList.totalSpentPerCustomer(355);

		long after = System.currentTimeMillis();
		System.out.println("Time taken to add up orders: " + (after - before) + " milliseconds\n");

	}
}
