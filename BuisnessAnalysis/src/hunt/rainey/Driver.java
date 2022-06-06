package hunt.rainey;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		boolean cont = true;
		while(cont) {
			System.out.println("Buisness Analysis System");
			System.out.println("Enter the corresponding number to open");
			System.out.println("(1) Enter Customer Information");
			System.out.println("(2) Sales Report");
			System.out.println("(3) Print Customer Information to CSV file");
			System.out.println("(4) Sales Fraud Report");
			System.out.println("(5) Remove Customer");
			Scanner in = new Scanner(System.in);
			CustomerArchive customers = new CustomerArchive();
			
			int menu = in.nextInt();
			if(menu ==1) {
				System.out.println("Please enter your first name");
				String a = in.next();
				System.out.println("Please enter your last name");
				String b = in.next();
				System.out.println("Please enter your city of residence");
				String c = in.next();
				String d = "";
				long e = 0;
				ArrayList<String> postal = new ArrayList<>();
				loadCodes(postal);
				boolean valid = false;
				while(!valid) {
					System.out.println("Please enter your postal code; At LEAST 3 characters");
					d = in.next();
					if(d.length() >= 3) {
						if(pCodeVeri(d, postal)) {
							valid = true;
						}
					}
					
				}
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
				Customer w = new Customer(a,b,c,d.toUpperCase(),e);
				System.out.println(w.toString());
				customers.add(w);
				
			}
			else if(menu ==2) {
				
			}
			else if(menu == 3) {
				File res = new File("customerInfo.csv");
				try {
					FileWriter wri = new FileWriter(res);
					wri.write("");
					wri.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					FileWriter out = new FileWriter(res, true);
					ArrayList<Customer> customerArchive = new ArrayList<>();
					customerArchive = customers.getArchive(customerArchive);
					for(Customer q : customerArchive) {
						out.write(String.valueOf(q.getId()) +", " + String.valueOf(q.getName()) + "," + String.valueOf(q.getCity()) + "," + String.valueOf(q.getCode()) + "," + String.valueOf(q.getCard()) + System.getProperty("line.separator"));
					}
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(menu == 4) {
				
			}
			else if(menu == 5) {
				System.out.println("What is the ID of the customer information you would like to remove?");
				int id = in.nextInt();
				int loc = customers.findAccount(id);
				if(loc == -1) {
					System.out.println("There is no Account with that name");
				}
				else{
					Customer t = customers.get(loc);
					customers.remove(t);
				}
			}
			else {
				System.out.println("That was an Invalid menu option");
			}
			
			System.out.println("Would you like to stop? Enter Y if yes");
			String proc = in.next();
			if(proc.toUpperCase().equals("Y")) {
				cont = false;
			}
			
		}
		
	}
	private static boolean pCodeVeri(String x, ArrayList<String> postal) {
		String code = x.substring(0,3).toUpperCase();
		System.out.println(code);
		for(String s: postal) {
			if(code.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	private static void loadCodes(ArrayList<String> words) {
		File f = new File("postal_codes.csv");
		try {
			Scanner inFile = new Scanner(f);
			inFile.useDelimiter("|");
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
	
	private static boolean cCardVeri(String e) {
		String rev = reverse(e);
		int odd = sumOdd(rev);
		int even = sumEven(rev);
		if((even + odd)%10 !=0) {
			return false;
		}
		return true;
	}
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
	private static String reverse(String e) {
		if(e.length() == 1) {
			return e;
		}
		//49927398716
		String sub = e.substring(e.length()-1);
		return sub + reverse(e. substring(0, e.length()-1) );
		
	}

}
