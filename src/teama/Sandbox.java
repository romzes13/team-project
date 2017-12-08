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
		
		//CustomerArrayList clist = new CustomerArrayList();
		//ArrayList<Customer> cr = clist.getListOfCustomers();
		//clist.printCustomerList();
		
		//Hashtable is faster so far.
		
	HashTable test = new HashTable();
	Hashtable<Customer, Customer> customerProduct = test.getTable();
	test.printTable(test);
	
	}
}
