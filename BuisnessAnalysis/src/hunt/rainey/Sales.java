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
	 * add a new total sales ro the ArrayList
	 * @param s
	 */
	public void add(Sale s) {
		salesData.add(s);
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
			String firstDig = money.substring(0,1);
			if(firstDig.equals("1")) {
				count[1] +=1;
			}
			if(firstDig.equals("2")) {
				count[2] +=1;
			}
			if(firstDig.equals("3")) {
				count[3] +=1;
			}
			if(firstDig.equals("4")) {
				count[4] +=1;
			}
			if(firstDig.equals("5")) {
				count[5] +=1;
			}
			if(firstDig.equals("6")) {
				count[6] +=1;
			}
			if(firstDig.equals("7")) {
				count[7] +=1;
			}
			if(firstDig.equals("8")) {
				count[8] +=1;
			}
			if(firstDig.equals("9")) {
				count[9] +=1;
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
	
}
