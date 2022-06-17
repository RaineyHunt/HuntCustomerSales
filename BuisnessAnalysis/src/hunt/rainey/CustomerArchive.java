package hunt.rainey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * a class that holds all customers for the business 
 * @author Rainey Hunt
 *
 */
public class CustomerArchive {
	private ArrayList<Customer> customers;
	
	/**
	 * makes a customer archive
	 */
	CustomerArchive(){
		customers = new ArrayList<>();
	}
	
	/**
	 * deletes an account
	 * @param t
	 */
	public  void remove(Customer t) {
		customers.remove(t);
	}
	
	/**
	 * adds a new account to the archive
	 * @param b
	 */
	public  void add(Customer b) {
		customers.add(b);
	}
	
	/**
	 * allows for searching of a specific account
	 * @param tarId
	 * @return int
	 */
	public int findAccount(int tarId) {
		for(int i =0; i<customers.size(); i++) {
			Customer w = customers.get(i);
			int id = w.getId();
			if(tarId == id) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * gives the account at a specific location in the archive
	 * @param loc
	 * @return Customer
	 */
	public Customer get(int loc) {
		return customers.get(loc);
	}

	/**
	 * Displays all customer accounts
	 */
	public void displayArchive() {
		for(Customer i: customers) {
			System.out.println(i);
		}
		
	}
	
	/**
	 * puts customer information in a csv file
	 */
	public void print() {
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
			for(Customer q : customers) {
				out.write(String.valueOf(q.getId()) +", " + String.valueOf(q.getName()) + "," + String.valueOf(q.getCity()) + "," + String.valueOf(q.getCode()) + "," + String.valueOf(q.getCard()) + System.getProperty("line.separator"));
			}
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Sorts customer archive by account numbers
	 */
	public void sort() {
		Collections.sort(customers);
		print();
	}
	
	/**
	 * give the number of customer accounts the business has
	 * @return
	 */
	public int size() {
		return customers.size();
	}

}
