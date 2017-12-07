package teama.hashtable;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
import java.util.*;

public class HashTable implements Evaluation {

	private Hashtable<Customer, Product> custumerProduct = new Hashtable();
	
	public HashTable() {}  //constructor currently empty
	
	@Override
	public Customer lookUpCustomer(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomerRating(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product lookUpProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double averageRating() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void countAllRatings() {
		// TODO Auto-generated method stub
		
	}

}
