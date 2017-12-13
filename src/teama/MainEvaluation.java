package teama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

import teama.arraylist.CustomerArrayList;
import teama.hashtable.HashTable;
import teama.tree.BinaryNode;
import teama.tree.BinarySearchTree;





/**
 * The MainEvaluation class creates 3 different data 
 * structures for testing and evaluation.
 * @author Roman
 *
 */
public class MainEvaluation {



	
	public static void main(String[] args) throws IOException {
	
		
		while(true) {
			
			
			System.out.println("Choose test to perform\n");
			System.out.println("A -- Customers ArrayList data structure \n");
			System.out.println(" 1-- Populate arrayList");
			System.out.println(" 2-- Calculate ratings ");
			System.out.println(" 3-- Calculate the average rating\n");
			System.out.println("T -- Customers GeneralTree data structure \n");
			System.out.println(" 4-- Populate GeneralTree");
			System.out.println(" 5-- Calculate ratings ");
			System.out.println(" 6-- Calculate the average rating\n");
			System.out.println("H -- Customers HashList data structure \n");
			System.out.println(" 7-- Populate HashList");
			System.out.println(" 8-- Calculate ratings ");
			System.out.println(" 9-- Calculate the average rating");
			
			System.out.print("\nEnter your choice and press enter or Q to exit: ");
			
			//
			char letter = getChar();

			letter = Character.toUpperCase(letter);
			
			switch(letter)
			{
			case 'A':

				System.out.println("A=" + letter);

				break;
			
			case '1':

				long beforeA1 = System.currentTimeMillis();
				CustomerArrayList caList = new CustomerArrayList();
				ArrayList<Customer> custListAr = caList.getListOfCustomers();
				caList.populatePurHistory();
				long afterA1 = System.currentTimeMillis();

				System.out.println("Time taken to populate " + (afterA1 - beforeA1) + " milliseconds\n");

				System.out.println("\nPress Enter to continue ");
				String l = getString();
				
				break;
				
			case '2':
				
				long beforeA2 = System.currentTimeMillis();
				CustomerArrayList caList2 = new CustomerArrayList();
				ArrayList<Customer> custListAr2 = caList2.getListOfCustomers();
				caList2.populatePurHistory();
				caList2.totalSpentPerCustomer(36456);
				long afterA2 = System.currentTimeMillis();

				System.out.println("Time taken to calculate rating: " + (afterA2 - beforeA2) + " milliseconds\n");

				System.out.println("\nPress Enter to continue ");
				String li = getString();
				
				break;
				
			case '3': 
				
				long beforeA3 = System.currentTimeMillis();
				CustomerArrayList caList3 = new CustomerArrayList();
				ArrayList<Customer> custListAr3 = caList3.getListOfCustomers();
				caList3.populatePurHistory();
				caList3.averageRating();
				long afterA3 = System.currentTimeMillis();
				System.out.println("Time taken to get average rating: " + (afterA3 - beforeA3) + " milliseconds");
				System.out.println("\nPress Enter to continue ");
				String li1 = getString();
				
				break;


			case 'T':

				System.out.println("T" + letter);
				
				break;
				
			case '4':
				
				long beforeT1 = System.currentTimeMillis();
				//TestBtree btree1 = new TestBtree();
				//btree1.main(args);
				CustomerArrayList caList4 = new CustomerArrayList();
				ArrayList<Customer> custListAr4 = caList4.getListOfCustomers();
				ArrayList<LinkedList<Integer>> purchaseHistory = new ArrayList();
			    BinarySearchTree btree1 = new BinarySearchTree();
			    for(int i=0; i<custListAr4.size(); i++) {
					custListAr4.get(i).setId(i);
				}
				purchaseHistory = btree1.getPurchaseHistory();
			
				for(int i = 0; i < custListAr4.size(); i++) {
		
					btree1.add(custListAr4.get(i), purchaseHistory.get(i));
					
				}
				long afterT1 = System.currentTimeMillis();
				System.out.println("Time taken to populate " + (afterT1 - beforeT1) + " milliseconds\n");
				System.out.println("\nPress Enter to continue ");
				String input1 = getString();
				
				break;
				
			case '5':
				
				long beforeT2 = System.currentTimeMillis();
				CustomerArrayList caList5 = new CustomerArrayList();
				ArrayList<Customer> custListAr5 = caList5.getListOfCustomers();
				ArrayList<LinkedList<Integer>> purchaseHistory2 = new ArrayList();
				BinarySearchTree btree2 = new BinarySearchTree();
				for(int i=0; i<custListAr5.size(); i++) {
					custListAr5.get(i).setId(i);
				}
				purchaseHistory2 = btree2.getPurchaseHistory();
				
				for(int i = 0; i < custListAr5.size(); i++) {
					
					btree2.add(custListAr5.get(i), purchaseHistory2.get(i));
					
				}
				btree2.countAllRatings();
				System.out.println("Customer rating =" + btree2.countCustomerRating("dinuzzio", "joseph"));
				long afterT2 = System.currentTimeMillis();
				System.out.println("Time taken to calculate rating: " + (afterT2 - beforeT2) + " milliseconds\n");
				System.out.println("\nPress Enter to continue ");
				String input2 = getString();
				
				break;
				
			case '6':
				
				long beforeT3 = System.currentTimeMillis();

				CustomerArrayList caList6 = new CustomerArrayList();
				ArrayList<Customer> custListAr6 = caList6.getListOfCustomers();
				ArrayList<LinkedList<Integer>> purchaseHistory3 = new ArrayList();
				BinarySearchTree btree3 = new BinarySearchTree();
				for(int i=0; i<custListAr6.size(); i++) {
					custListAr6.get(i).setId(i);
				}
				purchaseHistory3 = btree3.getPurchaseHistory();
		
				for(int i = 0; i < custListAr6.size(); i++) {
			
					btree3.add(custListAr6.get(i), purchaseHistory3.get(i));
		
				}
		
				btree3.countAllRatings();
				System.out.print("Average of all ratings: " + btree3.averageRating());
				long afterT3 = System.currentTimeMillis();
				System.out.println("Time taken to get average rating: " + (afterT3 - beforeT3) + " milliseconds");
				System.out.println("\nPress Enter to continue ");
				String input3 = getString();
				
				break;
				
			case 'H':

				System.out.println("H" + letter);
				
				break;
				
			case '7':
				
				long beforeH1 = System.currentTimeMillis();
				HashTable test = new HashTable();
				long afterH1 = System.currentTimeMillis();

				System.out.println("Time taken to populate Hashtable: " + (afterH1 - beforeH1) + " milliseconds\n");

				System.out.println("\nPress Enter to continue ");
				String l1 = getString();
				
				break;
				
			case '8':
	
				long beforeH2 = System.currentTimeMillis();
				HashTable test2 = new HashTable();
				int key = test2.searchCustomer( "Joseph","Dinuzzio");
		        test2.totalSpentPerCustomer(key);
		        long afterH2 = System.currentTimeMillis();

		        System.out.println("Time taken to calculate rating: " + (afterH2 - beforeH2) + " milliseconds\n");

				System.out.println("\nPress Enter to continue ");
				String l2 = getString();
		          
				break;
				 
			case '9':
				
				long beforeH3 = System.currentTimeMillis();
				HashTable test3 = new HashTable();
				test3.populateRatingsTable();
				int count = test3.countRatings();
				test3.averageRatings(count);
				long afterH3 = System.currentTimeMillis();

				System.out.println("Time taken to get average rating: " + (afterH3 - beforeH3) + " milliseconds\n");

				System.out.println("\nPress Enter to continue ");
				String l3 = getString();
				
				break;
			
			case 'Q':

				return;
			
			default:

				System.out.print("Invalid entry\n");
			
			}
		}

	} // End of main method
	
	/**
	 * Method to read strings from command line.
	 * @return
	 * @throws IOException
	 */
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

}
