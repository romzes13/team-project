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

		long before = System.currentTimeMillis();

		HashTable test = new HashTable();
		test.populateRatingsTable();
		
		long after = System.currentTimeMillis();
		System.out.println("Time taken: " + (after - before) + " milliseconds");
	}
}
