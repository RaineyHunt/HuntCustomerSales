package hunt.rainey;

import java.util.ArrayList;

public class Sales {
	ArrayList<Sale> salesData;
	Sales(){
		salesData = new ArrayList<>();
	}
	
	public void print() {
		System.out.println("Postal Code: Sales");
		for(Sale s: salesData) {
			System.out.println(s.toString());
		}
	}
	
	public Sale get(int i) {
		return salesData.get(i);
	}
	
	public void add(Sale s) {
		salesData.add(s);
	}
	
	public boolean checkFraud() {
		return false;
		
	}
	
}
