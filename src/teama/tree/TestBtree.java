package teama.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import teama.Customer;
import teama.arraylist.CustomerArrayList;

public class TestBtree {

	private BinaryNode<Customer, LinkedList> root;
	
	public TestBtree() {
		root = null;
	}
	//private ArrayList<LinkedList<Integer>> purchaseHistory;
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		Customer customer = new Customer();
		BinarySearchTree<Customer, LinkedList<Integer>> btree = new BinarySearchTree<>();
		
		ArrayList<LinkedList<Integer>> purchaseHistory;
		
		
		// Initializing arraylist with names and implemented methods
		CustomerArrayList caList = new CustomerArrayList();
		// This arrayList has arrayList methods.
		
		
		ArrayList<Customer> custListAr = caList.getListOfCustomers();

		long before = System.currentTimeMillis();
		
		for(int i=0; i<custListAr.size(); i++) {
			custListAr.get(i).setId(i);
		}
		
		long after = System.currentTimeMillis();
		
		System.out.println("Time taken to add id: " + (after - before) + " milliseconds\n");
		// populate purchase history
		caList.populatePurHistory();
		// get the LinkedList
		purchaseHistory = caList.getPurchaseHistory();
		LinkedList<Integer> ll = new LinkedList<>(); 
		ll = purchaseHistory.get(22);
		 
		 System.out.println(" check element #22: " + custListAr.get(22).toString());
		 System.out.println(" Purchase history #22: " + ll.toString());
		 System.out.println(" Total purchase history =" + purchaseHistory.size());
		 
		
		// Shuffle first
		before = System.currentTimeMillis();
		Collections.shuffle(custListAr);
		after = System.currentTimeMillis();

		System.out.println("Time taken to shuffle: " + (after - before) + " milliseconds\n");
		
		list.add(1234);
		
		
		// populating the tree
		before = System.currentTimeMillis();
			for(int i=0; i<custListAr.size();i++) {
			
				custListAr.get(i);
				btree.add(custListAr.get(i), purchaseHistory.get(i));
			}
			
		after = System.currentTimeMillis();
			System.out.println("Time taken to populate tree: " + (after - before) + " milliseconds\n");
		
		
		
		
		customer = custListAr.get(1997);
		System.out.println("Customer=" + customer);

		System.out.println(" Btree " + btree.contains(customer));
		
		
		// Traversal preorder test
		before = System.currentTimeMillis();
		System.out.println("Traversal preorder:");
		btree.traversalPreorder();
		after = System.currentTimeMillis();
		System.out.println("Time taken to traverse tree: " + (after - before) + " milliseconds\n");

		// Look up customer test
		// Returns all customers with the same first and last names
		String lastName = "abbott";
		String firstName = "jerry";
		before = System.currentTimeMillis();
		System.out.println("Look up customer: " + btree.preorderLookUpCustomer(lastName, firstName));
		after = System.currentTimeMillis();
		System.out.println("Time taken to traverse tree: " + (after - before) + " milliseconds\n");
		
		//System.out.println("Customer: " + btree.preorder(lastName, firstName));
		
		/*
		* Average of customer ratings
		*/
		int ratings = btree.countAllRatings();
		int size = btree.size();
		System.out.println(btree.averageRatings(ratings, size));

	}

}
