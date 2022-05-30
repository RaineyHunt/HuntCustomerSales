package hunt.rainey;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String a = in.next();
		System.out.println("Please enter your last name");
		String b = in.next();
		System.out.println("Please enter your City of residence");
		String c = in.next();
		String d = "";
		int e = 0;
		boolean valid = false;
		while(!valid) {
			System.out.println("Please enter your postal code");
			d = in.next();
			if(pCodeVeri(d)) {
				valid = true;
			}
			
		}
		valid = false;
		while(!valid) {
			System.out.println("Please enter your credit card number");
			e = in.nextInt();
			if(cCardVeri(e)) {
				valid = true;
			}
		}
		Customer w = new Customer(a,b,c,d,e);
		System.out.println(w.toString());
	}
	public static boolean pCodeVeri(String x) {
		return true;
	}
	
	public static boolean cCardVeri(int x) {
		return true;
	}

}
