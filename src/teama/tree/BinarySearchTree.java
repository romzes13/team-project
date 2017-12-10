package teama.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import teama.Customer;
import teama.Evaluation;
import teama.Product;


/** A binary search tree of Comparables. 
 * TODO Not sure if Set<E> has anything to do here...
 * 
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
 */
// Replaced E with the Customer
public boolean contains(Customer target) {
 BinaryNode<E, T> node = root;
 while (node != null) {
   int comparison = target.compareTo((Customer) node.getItem());
   if (comparison < 0) {     // Go left
     node = node.getLeft();
   } else if (comparison == 0) { // Found it
     return true;
   } else {                  // Go right
     node = node.getRight();
   }
 }
 return false;
}

public BinaryNode<E, T> getChild(int direction) {
 return root;
}

public void remove(E target) {
 Parent<E, T> parent = (Parent<E, T>) this;
 BinaryNode<E, T> node = root;
 int direction = 0;
 while (node != null) {
   int comparison = target.compareTo(node.getItem());
   if (comparison < 0) {     // Go left
     parent =  node;
     node = node.getLeft();
   } else if (comparison == 0) { // Found it
     spliceOut(node, parent, direction);
     return;
   } else {                  // Go right
     parent = (Parent<E, T>) node;
     node = node.getRight();
   }
   direction = comparison;
 }
}

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
	
	BinaryNode<E, T> node = root;
	 while (node != null) {
		 System.out.println("Nodes: " + node.getItem().toString());
	   int comparison = customer.compareTo((Customer) node.getItem());
	   if (comparison < 0) {     // Go left
	     node = node.getLeft();
	   } else if (comparison == 0) { // Found it
	     //return true;
		   System.out.println("Found it!" + node.getItem().toString());
	   } else {                  // Go right
	     node = node.getRight();
	   }
	 }
	
	return null;
}

@Override
public int countCustomerRating(String lastName, String firstName) {
	// TODO Auto-generated method stub
	Customer customer = new Customer(lastName, firstName);
	lookUpCustomer(customer.getLastName(), customer.getFirstName());
	return customer.getRank();
}

@Override
public Product lookUpProduct(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public double averageRating() {
	// TODO Auto-generated method stub
	// Divide ratings by number of customers
	double average = countAllRatings()//number of customers
}

@Override
public void countAllRatings() {
	String result ="";
	//result +=item;
	Customer customer;
	int rank =0;
	
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

/**
 * TODO Methods below are implemented from the Set<E> Interface
 * and probably can be removed with the Set<E> interface.
 */


}
