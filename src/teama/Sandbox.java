package teama;

import java.util.ArrayList;

import teama.arraylist.CustomerArrayList;

/**
 * Sandbox for testing class methods
 */
public class Sandbox {
    
    public static void main(String[] args){
    	
    	//Testing some methods on shuffling and displaying the customers. Feel free to delete if needed. 
    	long before = System.currentTimeMillis();
    	
    	ProductArrayList pl = new ProductArrayList();
    	System.out.println(pl.getListOfProducts());
    	
    	long after = System.currentTimeMillis();
		System.out.println("Time taken: " + (after - before) + " milliseconds\n");
    	
    	
    	
    }
}
