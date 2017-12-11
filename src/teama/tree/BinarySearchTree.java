package teama.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
<<<<<<< HEAD
import teama.ProductDataFile;
import teama.arraylist.CustomerArrayList;

/**
 * A binary search tree of Comparables. TODO Not sure if Set<E> has anything to
 * do here...
=======
import teama.CustomerArrayList;

/** A binary search tree of Comparables. 
 * TODO Not sure if Set<E> has anything to do here...
>>>>>>> branch 'Daniel' of https://github.com/romzes13/team-project.git
 * 
<<<<<<< HEAD
=======
 * */
public class BinarySearchTree <E extends Comparable<E>, T> implements Parent<E, T>, Evaluation {
//public class BinarySearchTree <E extends Comparable<E>, T> implements Parent<E, T>, Set<E>, Evaluation {

	
	
/** Root node. */
private BinaryNode<E, T> root;
private Parent<E, T> parent;

/** The node at the root of the left subtree. */
private BinaryNode<E, T> left;

/** The node at the root of the right subtree. */
private BinaryNode<E, T> right;

/** A BinarySearchTree is initially empty. */
public BinarySearchTree() {
 root = null;
}

public void add(E target, T list) {
	
	 parent = this;
	
 BinaryNode<E, T> node = root;
 int comparison = 0;
 while (node != null) {
	
   comparison = target.compareTo(node.getItem());
  
   if (comparison < 0) {     // Go left	 
     parent =        node;
     node = node.getLeft();
   } else if (comparison == 0) { // It's already here
     return;
   } else {                  // Go right
     parent =       node;
     node = node.getRight();
   }
 }
 parent.setChild(comparison, new BinaryNode<E, T>(target, list));
 
}
/**
 * Check if node exists.   
 * @param target
 * @return
>>>>>>> branch 'Daniel' of https://github.com/romzes13/team-project.git
 */
public class BinarySearchTree<E extends Comparable<E>, T> implements Parent<E, T>, Evaluation {

	/** Root node. */
	private BinaryNode<E, T> root;
	private Parent<E, T> parent;

	private BinaryNode<E, T> left;
	private BinaryNode<E, T> right;

<<<<<<< HEAD
	public ArrayList<LinkedList<Integer>> purchaseHistory;
	public CustomerArrayList caList;
	public ArrayList<Customer> custListAr;
	
	// Products
	public ArrayList<Product> listOfProducts;
	public ProductDataFile productDF;
	

	/** A BinarySearchTree is initially empty.
	 * 
	 */
	public BinarySearchTree() {
		// root is null
		root = null;
		// populate array with customers
		caList = new CustomerArrayList();
		custListAr = caList.getListOfCustomers();

		// Set id for Customers
		for (int i = 0; i < custListAr.size(); i++) {
			custListAr.get(i).setId(i);
		}
		// populate purchase history
		caList.populatePurHistory();
		// get the LinkedList
		purchaseHistory = caList.getPurchaseHistory();
		
		// populate products array
		productDF = new ProductDataFile();
		listOfProducts = productDF.getPList();
		
	}


	/**
	 * Adding node to a tree.
	 * @param target Customer object.
	 * @param list LinkedList of Integers
	 */
	public void add(E target, T list) {

		parent = this;

		BinaryNode<E, T> node = root;
		int comparison = 0;
		while (node != null) {

			comparison = target.compareTo(node.getItem());

			if (comparison < 0) { // Go left
				parent = node;
				node = node.getLeft();
			} else if (comparison == 0) { // It's already here
				return;
			} else { // Go right
				parent = node;
				node = node.getRight();
			}
		}
		parent.setChild(comparison, new BinaryNode<E, T>(target, list));

	}

	/**
	 * Check if node exists.
	 * 
	 * @param target Customer object.
	 * @return true if it exist, otherwise falls.
	 */
	public boolean contains(Customer target) {
		BinaryNode<E, T> node = root;
		while (node != null) {
			int comparison = target.compareTo((Customer) node.getItem());
			if (comparison < 0) { // Go left
				node = node.getLeft();
			} else if (comparison == 0) { // Found it
				return true;
			} else { // Go right
				node = node.getRight();
			}
		}
		return false;
	}

	// Getter
	public BinaryNode<E, T> getChild(int direction) {
		return root;
	}

	/**
	 * Remove Customer from tree.
	 * @param target Customer object.
	 */
	public void remove(E target) {
		Parent<E, T> parent = (Parent<E, T>) this;
		BinaryNode<E, T> node = root;
		int direction = 0;
		while (node != null) {
			int comparison = target.compareTo(node.getItem());
			if (comparison < 0) { // Go left
				parent = node;
				node = node.getLeft();
			} else if (comparison == 0) { // Found it
				spliceOut(node, parent, direction);
				return;
			} else { // Go right
				parent = (Parent<E, T>) node;
				node = node.getRight();
			}
			direction = comparison;
		}
	}

	/**
	 * Remove the leftmost descendant of node and return the item contained in
	 * the removed node.
	 */
	protected E removeLeftmost(BinaryNode<E, T> node, Parent<E, T> parent) {
		int direction = 1;
		while (node.getLeft() != null) {
			parent = (Parent<E, T>) node;
			direction = -1;
			node = node.getLeft();
		}
		E result = node.getItem();
		spliceOut(node, parent, direction);
		return result;
	}

	/**
	 * Set child node.
	 */
	public void setChild(int direction, BinaryNode<E, T> child) {
		root = child;

	}

	/**
	 * Size of the tree.
	 * @return int size.
	 */
	public int size() {
		return size(root);
	}

	/** Return the size of the subtree rooted at node. */
	protected int size(BinaryNode<E, T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.getLeft()) + size(node.getRight());
		}
	}

	/**
	 * Remove node, which is a child of parent. Direction is positive if node is
	 * the right child of parent, negative if it is the left child.
	 */
	protected void spliceOut(BinaryNode<E, T> node, Parent<E, T> parent, int direction) {
		if (node.getLeft() == null) {
			parent.setChild(direction, node.getRight());
		} else if (node.getRight() == null) {
			parent.setChild(direction, node.getLeft());
		} else {
			node.setItem(removeLeftmost(node.getRight(), (Parent<E, T>) node));
		}
	}

	/**
	 * Look up Customer by name in the Tree.
	 */
	@Override
	public Customer lookUpCustomer(String lastName, String firstName) {

		return root.lookUpCustomer(lastName, firstName);
	}

	/**
	 * Counts customer rating and returns it.
	 */
	@Override
	public int countCustomerRating(String lastName, String firstName) {
		
		Customer customer;
		customer = lookUpCustomer(lastName, firstName);

		    return customer.getRank();
		
	}

	@Override
	public Product lookUpProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

=======
/**
* Remove the leftmost descendant of node and return the
* item contained in the removed node.
*/
protected E removeLeftmost(BinaryNode<E, T> node, Parent<E, T> parent) {
 int direction = 1;
 while (node.getLeft() != null) {
   parent = (Parent<E, T>) node;
   direction = -1;
   node = node.getLeft();
 }
 E result = node.getItem();
 spliceOut(node, parent, direction);
 return result;
}

public void setChild(int direction, BinaryNode<E, T> child) {
 root = child;
 
}

public int size() {
 return size(root);
}

/** Return the size of the subtree rooted at node. */
protected int size(BinaryNode<E, T> node) {
 if (node == null) {
   return 0;
 } else {
   return 1 + size(node.getLeft()) + size(node.getRight());
 }
}

/**
* Remove node, which is a child of parent.  Direction is positive
* if node is the right child of parent, negative if it is the
* left child.
*/
protected void spliceOut(BinaryNode<E, T> node,
                        Parent<E, T> parent,
                        int direction) {
 if (node.getLeft() == null) {
   parent.setChild(direction, node.getRight());
 } else if (node.getRight() == null) {
   parent.setChild(direction, node.getLeft());
 } else {
   node.setItem(removeLeftmost(node.getRight(), (Parent<E, T>) node));
 }
}


@Override
public Customer lookUpCustomer(String lastName, String firstName) {
	Customer customer = new Customer(firstName, lastName);	
>>>>>>> branch 'Daniel' of https://github.com/romzes13/team-project.git
	
	/**
	 * Count ratings for all customers.
	 */
	@Override
	public void countAllRatings() {
		
				setRatings(root);
	}

	/** Return the size of the subtree rooted at node. */
	protected int setRatings(BinaryNode<E, T> node) {
		Customer customer;
		LinkedList<Integer> list;
		if (node == null) {
			return 0;
		} else {
			customer = (Customer) node.getItem();
			list = (LinkedList<Integer>) node.getItem2();
			double total = 0;
			
				// Calculating total amount for a customer
				for(int i=0; i<list.size(); i++) {
					total = total + listOfProducts.get(i).getPrice();					
				}
				customer.setRank(setCustomerRating(total));
			return 1 + setRatings(node.getLeft()) + setRatings(node.getRight());
		}
	}
	
	/**
	 * Set customer rating.
	 * @param total amount          
	 * @return number from 0 to 11
	 */
	private int setCustomerRating(double total) {

<<<<<<< HEAD
		int rank = 0;
=======
@Override
public int countCustomerRating(String lastName, String firstName) {
	// TODO Auto-generated method stub

	// Initialize CustomerArrayList reference
	CustomerArrayList customerArray = new CustomerArrayList();
	// Initialize Customer reference
	Customer customer = new Customer(lastName, firstName);
	// Find customer by name
	customer.lookUpCustomer(customer.getLastName(), customer.getFirstName());
	// Retrieve purhcase history
	root.getItem2();
	// TODO: calculate total ints
	// TODO: calculate rank
	
}
>>>>>>> branch 'Daniel' of https://github.com/romzes13/team-project.git

		rank = (int) (total / 40);
		 //System.out.println("Total =" + total + " and rating = " + rank);

<<<<<<< HEAD
		return rank;
	}
=======
@Overload
public double averageRating(int ratings, int treeSize) {
	// TODO Auto-generated method stub
	// Divide ratings by number of customers
	double average = ratings/treeSize;
	return average;
}

@Override
public void countAllRatings() {
	String result ="";
	//result +=item;
	Customer customer;
	int rank =0;
>>>>>>> branch 'Daniel' of https://github.com/romzes13/team-project.git
	
<<<<<<< HEAD
	/** Return the size of the subtree rooted at node. */
	protected int avrgRating(BinaryNode<E, T> node) {
		Customer customer;
		//LinkedList<Integer> list;
		if (node == null) {
			return 0;
		} else {
			customer = (Customer) node.getItem();
						
			return customer.getRank() + avrgRating(node.getLeft()) + avrgRating(node.getRight());
		}
	}
	/**
	 * Counts average rating and returns it.
	 * @return double , rating or 0.
	 */
	public double averageRating() {
		
		int rank = avrgRating(root);
		System.out.println("Rank =" + rank + "  size =" + size());
=======
	if (left != null) {
		this.countAllRatings();
		//result += left.toStringPreorder();
		//customer.setRank(rank);
	}
	if (right != null) {
		result += right.toStringPreorder();
	}
	//return result;
	
}


public String traversalPreorder() {
	
	root.toStringPreorder();
	return "";
}

public String preorderLookUpCustomer(String lastName, String firstName) {
	
	return root.trPreorder(lastName, firstName);
}

/**
 * Duplicate method and needs some work.
 * @param lastName
 * @param firstName
 * @return
 */
public String preorder(String lastName, String firstName) {
	String result ="";
	
	if (left != null) {
		Customer customer;
		customer = (Customer) left.getItem();
		
		if(customer.getLastName().equals(lastName) && customer.getFirstName().equals(firstName)) {
			result += customer.toString();
			
		}
		result += left.trPreorder(lastName, firstName);
	}
	if (right != null) {
		Customer customer;
		customer = (Customer) right.getItem();
		
		if(customer.getLastName().equals(lastName) && customer.getFirstName().equals(firstName)) {
			result += customer.toString();			
		}
	
		result += right.trPreorder(lastName, firstName);
	}
	if (result.equals("")){
		return "Customer not found!";
	}
	return result;
}
>>>>>>> branch 'Daniel' of https://github.com/romzes13/team-project.git

		return rank/this.size();

	}
	
}
