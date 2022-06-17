package hunt.rainey;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that holds all sales for a given financial period
 * @author Rainey Hunt
 *
 */
public class Sales {
	ArrayList<Sale> salesData;
	
	/**
	 * Create a new sales class
	 */
	Sales(){
		salesData = new ArrayList<>();
	}
	
	/**
	 * show all sales with postal codes 
	 */
	public void print() {
		System.out.println("Postal Code: Sales");
		for(Sale s: salesData) {
			System.out.println(s.toString());
		}
		System.out.println("");
	}
	
	/**
	 * add a new total sales to the ArrayList
	 * @param s
	 */
	public void add(Sale s) {
		salesData.add(s);
	}
	
	/**
	 * remove a sale from the sales list
	 * @param s
	 */
	public void remove(int s) {
		salesData.remove(s);
	}
	
	/**
	 * Check for fraud in the sales data with the option to show representations of first digit distribution
	 * @param in
	 * @return boolean
	 */
	public boolean checkFraud(Scanner in) {
		int[] count = new int[10];
		double length = salesData.size();
		
		// check each sale for the first digit
		for(Sale i: salesData) {
			String money = String.valueOf(i.giveSales());
			int firstDig = Integer.valueOf(money.substring(0,1));
			for(int b = 1; b<10; b++) {
				if(firstDig == b) {
					count[b] += 1;
				}
			}
		}
		
		// check what first digit distribution representation type is used 
		System.out.println("Would you like to see the first digit distribution in (n)umeric representation, (v)isual representation or (B)OTH?");
		String ans = in.next();
		ans =ans.toUpperCase();
		
		//numeric
		if(ans.equals("N")) {
			numeric(count);
		}
		
		//visual
		else if(ans.equals("V")){
			visual(count);
		}
		
		//both
		else if(ans.equals("B")) {
			numeric(count);
			visual(count);
		}
		
		// neither
		else {
			System.out.println("As you didn't answer any of the predefined answers, you obviously don't want to see"); 
			System.out.println("a representation of first digit distribution so you won't be shown one");
		}
		
		// check frequency of the number 1 in first digits
		double oneFrequency = (count[1]/length) * 100;
		String s = String.format("%.2f", oneFrequency);
		System.out.print(s+ "% of given sales data starts with the number 1");
		if(oneFrequency<29 || oneFrequency > 32) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * display 10 first digits as a single '#'
	 * @param count
	 */
	private void visual(int[] count) {
		System.out.println("Each # is 10 first digits for that number");
		for(int i = 1; i<10; i++) {
			int numSymbols = count[i]/10;
			System.out.print(i + ": ");
			for(int s = 0; s<numSymbols; s++) {
				System.out.print("#");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	/**
	 * Show number of first digits for each number
	 * @param count
	 */
	private void numeric(int[] count) {
		System.out.print("1: " + count[1]);		
		System.out.print("  2: " + count[2]);	
		System.out.println("  3: " + count[3]);
		System.out.print("4: " + count[4]);
		System.out.print("  5: " + count[5]);
		System.out.println("  6: " + count[6]);
		System.out.print("7: " + count[7]);
		System.out.print("   8: " + count[8]);
		System.out.println("   9: " + count[9]);
		System.out.println(" ");
	}
	
	/**
	 * check if a postal code already has sales registered
	 * @param i
	 * @return boolean
	 */
	public boolean codeExists(String i) {
		for(Sale s: salesData) {
			if(s.giveCode().equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Give a Sale class already in this Sales
	 * @param code
	 * @return Sale
	 */
	public Sale giveSale(int loc) {
		return salesData.get(loc);
	}

	public int findSale(String code) {
		for(int i =0; i<salesData.size(); i++) {
			Sale s = salesData.get(i);
			if(s.giveCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}
	
}
