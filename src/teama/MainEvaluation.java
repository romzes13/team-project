package teama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import teama.arraylist.CustomerArrayList;
import teama.hashtable.HashTable;

/**
 * The MainEvaluation class creates 3 different data structures for testing and
 * evaluation.
 * 
 * @author Roman
 *
 */
public class MainEvaluation {

	public static void main(String[] args) throws IOException {

		while (true) {

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

			switch (letter) {
			case 'A':

				System.out.println("A=" + letter);

				break;

			case '1':

				long before = System.currentTimeMillis();
				CustomerArrayList caList = new CustomerArrayList();
				ArrayList<Customer> custListAr = caList.getListOfCustomers();
				long after = System.currentTimeMillis();
				System.out.println("Time took to populate " + (after - before) + " milliseconds\n");
				System.out.println("\nPress Enter to continue ");
				String l = getString();

				break;

			case 'T':

				System.out.println("T" + letter);

				break;

			case 'H':

				System.out.println("H" + letter);

				break;
				
			case '7':
				
				long before3 = System.currentTimeMillis();
				HashTable test = new HashTable();
				long after3 = System.currentTimeMillis();
				System.out.println("Time took to populate Hashtable: " + (after3 - before3) + " milliseconds\n");
				System.out.println("\nPress Enter to continue ");
				String l1 = getString();
				
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
	 * 
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
