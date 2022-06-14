package hunt.rainey;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * a program that allows for creation of customer accounts for a buisness, creating a csv file for all customer accounts
 * reporting sales data and checking sales data for fraud
 * @author Rainey Hunt
 *
 */
public class Driver {

	public static void main(String[] args) {
		CustomerArchive customers = new CustomerArchive();
		Sales sales = new Sales();
		boolean cont = true;
		
		// limit menus based on other needed prerequisites 
		boolean customer = false;
		boolean loaded =false;
		while(cont) {
			// display menu directory
			System.out.println("Buisness Analysis System");
			System.out.println("Enter the corresponding number to open each menu");
			System.out.println("(1) Enter Customer Information");
			System.out.println("(2) Sales Report");
			if(customer) {
				System.out.println("(3) Print Customer Information to CSV file");
				System.out.println("(4) Remove Customer");
			}
			if(loaded) {
				System.out.println("(5) Sales Fraud Report");
				System.out.println("(6) Add New Sales");
			}
			
			Scanner in = new Scanner(System.in);
			
			// check what menu to open
			int menu = in.nextInt();
			if(menu ==1) {
				// enter first and last name, as well as city of residence
				System.out.println("Please enter your first name");
				String a = in.next();
				System.out.println("Please enter your last name");
				String b = in.next();
				System.out.println("Please enter your city of residence");
				String c = in.next();
				
				String d = "";
				long e = 0;
				
				// load acceptable postal codes
				ArrayList<String> postal = new ArrayList<>();
				loadCodes(postal);
				boolean valid = false;
				
				// Check if postal code is allowed
				while(!valid) {
					System.out.println("Please enter your postal code; At LEAST 3 characters");
					d = in.next() + " ";
					d = d.substring(0,4);
					if(d.length() >= 3) {
						if(pCodeVeri(d, postal)) {
							valid = true;
						}
					}
					
				}
				
				//check if credit card number passes the lunh algorithm 
				valid = false;
				while(!valid) {
					System.out.println("Please enter your credit card number; 9 digits MINIMUM");
					e = in.nextLong();
					String es = String.valueOf(e);
					if(es.length() >= 9) {
						if(cCardVeri(es)) {
							valid = true;
						}
					}
				}
				
				// add new customer account and display all customer accounts
				Customer w = new Customer(a,b,c,d.toUpperCase(),e);
				customers.add(w);
				customers.sort();
				customers.displayArchive();
				customer = true;
			}
			else if(menu ==2) {
				File f = new File("sales.csv");
				try {
					Scanner inFile = new Scanner(f);
					
					// add given sales data to an array list
					while(inFile.hasNextLine()) {
						String c = inFile.nextLine();
						boolean firstLine = false;
						
						// ensure the headings aren't included in the array list
						if(c.equals("Postal Code,Sales")) {
							firstLine = true;
						}
						String[] s = c.split("\\,");
						if(!firstLine) {
							int integer = Integer.valueOf(s[1]);
							Sale g = new Sale(s[0], integer);
							sales.add(g);
						}	
					}
					inFile.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				//show the array list
				sales.print();
				loaded = true;
				
			}
			else if(menu == 3) {
				if(customer) {
					// print all customer information into csv file
					customers.print();
					System.out.println("Information is in 'customerInfo.csv' file");
				}
				else {
					// Say that the menu isn't available at the moment
					System.out.println("This menu isn't avaliable at this moment; Try adding a customer");
				}
			}
			else if(menu == 4) {
				if(customer) {
					// find account of that id
					System.out.println("What is the ID of the customer information you would like to remove?");
					int id = in.nextInt();
					int loc = customers.findAccount(id);
					if(loc == -1) {
						// say that account doesn't exist
						System.out.println("There is no Account of that id");
					}
					else{
						// remove account
						Customer t = customers.get(loc);
						customers.remove(t);
					}
				}
				else {
					// Say that the menu isn't available at the moment
					System.out.println("This menu isn't avaliable at this moment; Try adding a customer");
				}
			}
			else if(menu == 5) {
				if(loaded) {
					//check for fraud
					if(sales.checkFraud(in)) {
						// show that there is fraud
						System.out.println(" which is completly unacceptable, there is OBVIOUSLY fraud in the given sales data!");
						System.out.println(" ");
					}
					else {
						// show that there isn't fraud
						System.out.println(" which is perfectly acceptable, it is very unlikly that there is fraud in this sales data!");
						System.out.println(" ");
					}
				}
				else {
					// Say that the menu isn't available at the moment
					System.out.println("This menu isn't avaliable at this moment; Try loading sales data");
				}
			}
			else if(menu == 6) {
				// find the postal code
				System.out.println("What is the postal code in which you would like to add sales to?");
				String code = in.next();
				// find the sales
				System.out.println("What is the value of sales you would like to add?");
				int i = in.nextInt();
				// check if the postal code already has sales
				if(sales.codeExists(code)) {
					Sale s = sales.giveSale(code);
					s.addToSales(i);
				}
				else {
					Sale s = new Sale(code, i);
				}
			}
			else {
				// Say that the menu doesn't exist
				System.out.println("That was an Invalid menu option");
			}
			
			// Ask if user would like to stop using the program
			System.out.println("Would you like to stop? Enter Y if yes");
			String proc = in.next();
			if(proc.toUpperCase().equals("Y")) {
				cont = false;
			}
			
		}
		
	}
	
	/**
	 * verify postal code
	 * @param x
	 * @param postal
	 * @return boolean
	 */
	private static boolean pCodeVeri(String x, ArrayList<String> postal) {
		String code = x.substring(0,3).toUpperCase();
		for(String s: postal) {
			if(code.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * load postal codes from csv file
	 * @param words
	 */
	private static void loadCodes(ArrayList<String> words) {
		File f = new File("postal_codes.csv");
		try {
			Scanner inFile = new Scanner(f);
			// set delimiter
			inFile.useDelimiter("|");
			
			// add postal codes to an array list
			while(inFile.hasNextLine()) {
				String c = inFile.nextLine();
				String[] s = c.split("\\|");
				words.add(s[0]);
			}
			words.remove(0);
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Verify credit card number
	 * @param e
	 * @return
	 */
	private static boolean cCardVeri(String e) {
		// reverse number
		String rev = reverse(e);
		// sum the odd digits
		int odd = sumOdd(rev);
		// sum the even digits
		int even = sumEven(rev);
		//check if the last digit of the sum is 0
		if((even + odd)%10 !=0) {
			return false;
		}
		return true;
	}
	
	/**
	 * add all even doubled numbers with two digit numbers having the digits added together 
	 * @param rev
	 * @return int
	 */
	private static int sumEven(String rev) {
		if(rev.length() == 0) {
			return 0;
		}
		if(rev.length()%2 != 0) {
			return 0 + sumEven(rev.substring(1));
		}
		int count = Integer.valueOf(rev.substring(0,1));
		count = count * 2;
		
		if(count >9) {
			count = (count/10) + (count%10);
		}
		
		return count + sumEven(rev.substring(1));
	}
	
	/**
	 * add all odd digits together
	 * @param rev
	 * @return
	 */
	private static int sumOdd(String rev) {
		if(rev.length() == 0) {
			return 0;
		}
		if(rev.length()%2 == 0) {
			return 0 + sumOdd(rev.substring(1));
		}
		int count = Integer.valueOf(rev.substring(0,1));
		
		return count + sumOdd(rev.substring(1));
	}
	
	/**
	 * reverse the order of the credit card number
	 * @param e
	 * @return
	 */
	private static String reverse(String e) {
		if(e.length() == 1) {
			return e;
		}
		String sub = e.substring(e.length()-1);
		return sub + reverse(e. substring(0, e.length()-1) );
		
	}

}
