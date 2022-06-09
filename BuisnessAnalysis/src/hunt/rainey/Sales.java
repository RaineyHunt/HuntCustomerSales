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
		System.out.println("");
	}
	
	public Sale get(int i) {
		return salesData.get(i);
	}
	
	public void add(Sale s) {
		salesData.add(s);
	}
	
	public boolean checkFraud() {
		int[] count = new int[10];
		double length = salesData.size();
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
		
		System.out.println("Distribution of the first digit in given sales data");
		System.out.print("1: " + count[1]);		
		System.out.print("  2: " + count[2]);	
		System.out.println("  3: " + count[3]);
		System.out.print("4: " + count[4]);
		System.out.print("  5: " + count[5]);
		System.out.println("  6: " + count[6]);
		System.out.print("7: " + count[7]);
		System.out.print("   8: " + count[8]);
		System.out.println("   9: " + count[9]);
		double oneFrequency = (count[1]/length) * 100;
		String s = String.format("%.2f", oneFrequency);
		System.out.print(s+ "% of given sales data starts with the number 1");
		if(oneFrequency<29 || oneFrequency > 32) {
			return true;
		}
		return false;
		
	}
	
}
