package teama.arraylist;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import teama.Customer;
/**
 * This class only purpose is to read data from the file
 * and populate the ArrayList of customers.
 * TODO It also concatenates first name and middle initial, 
 * which has to fixed. For example: it would return first 
 * name as "erik p" instead of "erick".
 * Capitalizing the first letter in name would be nice.
 * @author roman
 *
 */
public class CustomersDataFile {
	
	private ArrayList<Customer> list;
	
	public  CustomersDataFile() {
		
		list = new ArrayList<Customer>();
		     
		String line = " ";
        String cvsSplitBy = ", ";
		    
		     try
		       {
		           BufferedReader br = new BufferedReader(new FileReader("names.csv"));

		           // Skipping first line because it doesn't have a name
		           line = br.readLine();
		           
		           while ((line = br.readLine()) != null)
		           {
		               
		               // split by comma
		               String[] name = line.split(cvsSplitBy);
		               
		               
		             //list.add(new Customer(firstName, lastName));
		               
		               name[1]= name[1].substring(0, name[1].indexOf(" "));
		               
		             list.add(new Customer(name[1], name[0]));		             
		              
		           }
		           
		           br.close();
		       }
		  
		     catch (FileNotFoundException f)
		     {
		         System.out.println("File not found!");
		     }
		     catch (java.io.IOException e) {
		         e.printStackTrace();
		         System.exit(1);
		     }
		
		
	}

	public ArrayList<Customer> getList() {
		return list;
	}
	

}
