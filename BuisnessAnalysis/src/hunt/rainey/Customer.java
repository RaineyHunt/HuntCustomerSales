package hunt.rainey;

/**
 * A class that creates a comparable by id, customer account for a business; and return each variable of account
 * @author Rainey Hunt
 *
 */
public class Customer implements Comparable<Customer>{
	private String first;
	private String last;
	static int nextId = 1;
	private String city;
	private String pCode;
	private long cCard;
	private int id;
	
	/**\
	 * create a new customer account
	 * @param s
	 * @param a
	 * @param d
	 * @param g
	 * @param e
	 */
	Customer(String s, String a, String d, String g, long e){
		first = s;
		last = a;
		id = nextId;
		city = d;
		pCode = g;
		cCard = e;
		nextId++;
	}
	
	/**
	 * convert a customer account to a printable string
	 */
	@Override
	public String toString() {
		return String.format("%nCustomer ID: %d %nName: %s %s %nCity: %s Postal Code: %s", id,first,last,city, pCode);
	}
	
	/**
	 * gives account id
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * gives full name of account owner
	 * @return String
	 */
	public String getName() {
		return first + " " + last;
	}
	
	/**
	 * Gives the name of the city that the customer lives
	 * @return String
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Gives the postal code of the customer
	 * @return String
	 */
	public String getCode() {
		return pCode;
	}
	
	/**
	 * gives credit card number of customer
	 * @return long
	 */
	public long getCard() {
		return cCard;
	}
	
	/**
	 * Allows customer accounts to be compared by account id
	 */
	@Override
	public int compareTo(Customer o) {
		if (getId() <o.getId()){
			return -1;
		}
		else if (getId()> o.getId()){
			return 1;
		}
		return 0;
	}
}

