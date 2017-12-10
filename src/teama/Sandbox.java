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

			System.out.println(test.hashCode());
	
	}
}
