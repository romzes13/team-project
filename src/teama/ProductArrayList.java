
package teama.arraylist;

import java.util.ArrayList;

import teama.Customer;
import teama.Evaluation;
import teama.Product;

/*This class should ideally work as the CustomerArrayList class
 * 
 * TODO, Might need some additional methods depending on
 * what we need from the class, added a few.
 * 
 * @author Thomas
 *  */

public class ProductArrayList implements Evaluation{
	
	//The actual reference that holds the data file and ArrayList of Products
	
	private ArrayList<Product> productList;
	private ProductDataFile pd;

	//Constructor, ideally to put the data file into the ArrayList
	
	public ProductArrayList(){
		
		pd = new ProductDataFile();
		productList = pd.getPList();
		
	}
	
	//To check an item in the .txt file and see if it exists,
	//if so return the item. If not, "No product has been found."
	
	public Product lookUpProduct(String item) {
		System.out.println("Looking up: " + item + " from" productList.size() + " products");
		for(Product p : productList) {
		if(p.getName().equalsIgnoreCase(name))
			return p;	
		}

		System.out.println("No product has been found.");
		return null;

	}
	
	//Look up an item in the .txt file and return the price of it
	public Product lookUpItemPrice(String item) {
	 	System.out.println("Looking up the price for: "  + item);
		for(Product p : productList) {
		if(p.getName().equalsIgnoreCase(name))
			return getPrice;			// TODO - fix the price both here and in ProductData class,
										// may require modification in the Product class itself

		}
		
		//return the whole lift of Products.
		public Product getListOfProducts() {
			return productList;
		}

		/*Logic to check if list is null:
		* if(productList.isEmpty())     -exchange for listOfCustomers also
		*	return;
		*/
		
}
	//End of Class
