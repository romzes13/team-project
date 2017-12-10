package teama;

import java.util.ArrayList;
import java.util.Hashtable;
import teama.arraylist.CustomerArrayList;
import teama.hashtable.HashTable;

/**
 * Sandbox for testing class methods
 */
public class Sandbox {

	public static void main(String[] args) {

<<<<<<< HEAD
		long before = System.currentTimeMillis();

		HashTable test = new HashTable();
		test.populateRatingsTable();
		
		long after = System.currentTimeMillis();
		System.out.println("Time taken: " + (after - before) + " milliseconds");
=======
			Hashtable customerProduct = test.getTable();
            test.printTable(test);
			test.printValues(test);
            test.printKeys(test);
            int key = test.searchCustomer( "Joseph","Dinuzzio");
            test.totalSpentPerCustomer(key);
            test.populateRatingsTable();
            int count = test.countRatings();
            test.averageRatings(count);
            
	
>>>>>>> refs/remotes/origin/master
	}
}
