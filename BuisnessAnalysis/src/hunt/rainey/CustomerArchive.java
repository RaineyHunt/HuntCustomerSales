package hunt.rainey;

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

	public ArrayList<Customer> getArchive(ArrayList<Customer> customerArchive) {
		for(Customer q: customers) {
			customerArchive.add(q);
		}
		return customerArchive;
	}

}
