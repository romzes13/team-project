package teama.hashtable;

import teama.Customer;
import teama.Evaluation;
import teama.Product;
import teama.ProductArrayList;
import teama.ProductDataFile;
import teama.arraylist.*;
import java.util.*;

public class HashTable implements Evaluation {

	private Hashtable<Customer, Customer> custumerProduct = new Hashtable();
	private CustomerArrayList cList;
	private ProductArrayList pList;
	
	public HashTable() {
		cList = new CustomerArrayList();
		ArrayList<Customer> custArl = cList.getListOfCustomers();
		cList.populatePurHistory();
	    pList = new ProductArrayList();
	    ArrayList<Product> productArl = pList.getListOfProducts();
	    populateTable(custArl,cList);
		
	}  //constructor currently empty
	
	public void populateTable(ArrayList<Customer> custL, CustomerArrayList caList) {
		ArrayList<Customer> custArlPurchasehistory = cList.getListOfCustomers();
		for (int i = 0; i < custL.size(); i++) {
				custumerProduct.put(custL.get(i), custArlPurchasehistory.get(i));
		}
		
	}
	
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
