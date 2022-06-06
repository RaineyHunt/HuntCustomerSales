package hunt.rainey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerArchive {
	private ArrayList<Customer> customers;
	
	CustomerArchive(){
		customers = new ArrayList<>();
	}
	
	public  void remove(Customer t) {
		customers.remove(t);
	}
	
	public  void add(Customer b) {
		customers.add(b);
	}

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

	public Customer get(int loc) {
		return customers.get(loc);
	}

	public void printInfo() {
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
}