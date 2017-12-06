package teama;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import teama.Product;

/*Similar to the CustomersDataFile, this class will read data 
 * from file and create an ArrayList of Products.
 * - Thomas
 *  Updated: Roman
 */

public class ProductDataFile {

	private ArrayList<Product> pList;

	// Constructor
	public ProductDataFile()
	{
		
		pList = new ArrayList<Product>(); 
		
		//I believe these are still needed despite the txt being slightly different
		
		String line = " ";
		String split = ",";
		
		//For consistency sake, I'll keep the same format from CustomersData class
		//By defualt I'll put the product quantity set to 1. 
		
		int quan = 1;
		
		try
		{
		BufferedReader br = new BufferedReader(new FileReader("products.txt")); 

		while ((line = br.readLine()) != null)
		{
			//Again, the string lines are split by comma
			String[] product = line.split(split);
			
			/*Same idea as CustomerData Class,
			*  Add each new products (it's fields) to the new ArrayList.
			*  list.add(new Product(name, price, quantity));
			*/
			
			//NOTE (TODO); I am unable to compile right now, this may not work because
			//price's filed in the Product class is initialized to a double. 
			double price;
			
			price = Double.parseDouble(product[1].replace("$", ""));  
			pList.add(new Product(product[0], price, quan));
			
		} 
	
		//pList = list;			//May not work (TODO) You already have pList.
		
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
		// Getting the new ArrayList 
		public ArrayList<Product> getPList() {
			return pList;
		}

}