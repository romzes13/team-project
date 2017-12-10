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
		
		 HashTable test = new HashTable();

			Hashtable customerProduct = test.getTable();
            test.printTable(test);
			test.printValues(test);
            test.printKeys(test);
            int key = test.searchCustomer( "Joseph","Dinuzzio");
            test.totalSpentPerCustomer(key);
            test.populateRatingsTable();
            int count = test.countRatings();
            test.averageRatings(count);
            
	
	}
}
