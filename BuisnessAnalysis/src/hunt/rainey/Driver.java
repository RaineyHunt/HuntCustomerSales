package hunt.rainey;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
		System.out.println(rev);
		int odd = sumOdd(rev);
		System.out.println(odd);
		int even = sumEven(rev);
		System.out.println(even);
		return true;
	}
	private static int sumEven(String rev) {
		if(rev.length() == 0) {
			return 0;
		}
		if(rev.length()%2 != 0) {
			return 0 + sumOdd(rev.substring(1));
		}
		int count = Integer.valueOf(rev.substring(0,1));
		count = count *2;
		System.out.println(count);
		
		return count + sumOdd(rev.substring(1));
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
