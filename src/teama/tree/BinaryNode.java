package teama.tree;

public class BinaryNode<E, T> implements Parent<E, T>{

/** The item associated with this node. */
private E item;
private T item2;

/** The node at the root of the left subtree. */
private BinaryNode<E, T> left;

/** The node at the root of the right subtree. */
private BinaryNode<E, T> right;

public BinaryNode() {
	
}
/** Put item in a leaf node. */
public BinaryNode(E item, T item2) {
  this.item = item;
  this.item2 = item2;
  
  // left and right are set to null by default
}

/** Put item in a node with the specified subtrees. */
public BinaryNode(E item,
		           BinaryNode<E, T> left,
		           BinaryNode<E, T> right) {
  this.item = item;
  this.left = left;
  this.right = right;
}

public T getItem2() {
	return item2;
}
public void setItem2(T item2) {
	this.item2 = item2;
}
public BinaryNode<E, T> getChild(int direction) {
  if (direction < 0) {
	  System.out.println("Left");
    return left;
  } else {
	  System.out.println("Right");
    return right;
  }
}

/** Return the item associated with this node. */
public E getItem() {
  return item;
}

/** Return the root of the left subtree. */
public BinaryNode<E, T> getLeft() {
  return left;
}

/** Return the root of the right subtree. */
public BinaryNode<E, T> getRight() {
  return right;
}

/** Return true if this is a leaf. */
public boolean isLeaf() {
  return (left == null) && (right == null);
}

public void setChild(int direction, BinaryNode<E, T> child) {
	System.out.println("from setChild: " + direction+" child="+ child.toString());
  if (direction < 0) {
	  System.out.println("set Left");
    left = child;
  } else {
	  System.out.println("set Right");
    right = child;
  }
}

/** Replace the item associated with this node. */
public void setItem(E item) {
  this.item = item;
}

/** Replace the left subtree with the one rooted at left. */
public void setLeft(BinaryNode<E, T> left) {
  this.left = left;
}

/** Replace the right subtree with the one rooted at right. */
public void setRight(BinaryNode<E, T> right) {
  this.right = right;
}

@Override
public String toString() {
	return "BinaryNode [item=" + item + ", item2=" + item2 + ", left=" + left + ", right=" + right + "]";
}


}
