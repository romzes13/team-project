package teama.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

//Introduced in Chapter 11
/** A binary search tree of Comparables. */
public class BinarySearchTree <E extends Comparable<E>, T> implements Parent<E, T>, Set<E> {
//	public class BinarySearchTree <E extends Comparable<E>, T> implements  Set<E> {
	
	
/** Root node. */
private BinaryNode<E, T> root;

/** A BinarySearchTree is initially empty. */
public BinarySearchTree() {
 root = null;
}

public void add(E target, T list) {
	BinaryNode<E, T> parent =  new BinaryNode<>() ;
 BinaryNode<E, T> node = root;
 int comparison = 0;
 while (node != null) {
	 System.out.println("While loop:");
   comparison = target.compareTo(node.getItem());
   System.out.println("Comparison=" + comparison);
   if (comparison < 0) {     // Go left
	   System.out.println("Go Left");
     parent =       node;
     node = node.getLeft();
   } else if (comparison == 0) { // It's already here
     return;
   } else {                  // Go right
	   System.out.println("Go Right");
     parent =      node;
     node = node.getRight();
   }
 }
 System.out.println("from add method: " + target +" list=" +list);
 //BinaryNode<E, T> newNode = new BinaryNode<E, T>(target, list);
 //newNode.setChild(comparison, newNode);
 parent.setChild(comparison, new BinaryNode<E, T>(target, list));
 
}
   
public boolean contains(E target) {
 BinaryNode<E, T> node = root;
 while (node != null) {
   int comparison = target.compareTo(node.getItem());
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
     parent = (Parent<E, T>) node;
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
public boolean add(E e) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(Collection<? extends E> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Iterator<E> iterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}

}
