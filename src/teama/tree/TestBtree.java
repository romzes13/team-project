package teama.tree;

import java.util.ArrayList;
import java.util.LinkedList;

import teama.Customer;
import teama.arraylist.CustomerArrayList;

public class TestBtree {

	private BinaryNode<Customer, LinkedList> root;
	
	public TestBtree() {
		root = null;
	}
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		Customer customer = new Customer();
		BinarySearchTree<Customer, LinkedList<Integer>> btree = new BinarySearchTree<>();
		
		//btree.add(customer, list);
		
		
		//BinarySearchTree<Customer, LinkedList> bt = new BinarySearchTree<>();
		
		// Initializing arraylist with names and implemented methods
		CustomerArrayList caList = new CustomerArrayList();
		// This arrayList has arrayList methods.
		ArrayList<Customer> custListAr = caList.getListOfCustomers();

		for(int i=0; i<custListAr.size(); i++) {
			custListAr.get(i).setId(i);
		}
		custListAr.get(0).setId(1234);
		customer = custListAr.get(0);
		list.add(1234);
		
		btree.add(customer, list);
		
		System.out.println("Customer=" + customer);
		btree.add(custListAr.get(1), list);
		btree.add(custListAr.get(2), list);
		btree.add(custListAr.get(3), list);
		btree.add(custListAr.get(4), list);
		btree.add(custListAr.get(5), list);
		btree.add(custListAr.get(6), list);
		
		
		
		customer = custListAr.get(0);
		System.out.println("Customer=" + customer);
		System.out.println(" Btree " + btree.size());
		//System.out.println(" Btree " + btree.getChild(-1).toString());
		System.out.println(" Btree " + btree.contains(customer));
		
		
		
	}

}
