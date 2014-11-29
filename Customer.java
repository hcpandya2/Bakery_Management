//hari
import java.util.*;
/**
 * @author hari
 *
 */
public class Customer {
	String firstname;
	String lastname;
	String email_id;
	String address;
	String phone_no;
	String twitter_info;
	String facebook_info;
	boolean vacation;																// flag for whether the customer is on vacation or not
	Date date;           															// date of start of subscription 
	int subscription_no = 100;															// subscription_no is the unique ID no for any customer
	int total_customers = 0;
	
	// moved to the bakery class
	//ArrayList<Customer> customers = new ArrayList<Customer>();                      // list of all the customer in the bakery
	//HashMap<Integer, Customer> subscription = new HashMap <Integer, Customer> ();    // list of all the customer and their subscription no mapped to their names
	ArrayList<Order> history_of_orders;    											// history of orders of a customer from the date of subscription
	
	Scanner scan = new Scanner(System.in);
	
	public Customer(String first_name, String last_name){
		this.firstname = first_name;
		this.lastname = last_name;
		
		System.out.print("Enter email_id : ");
		//if(scan.nextLine() != null)
			this.email_id = scan.nextLine();
		System.out.print("Enter address of customer: ");
		//if(scan.nextLine() != null)
			this.address = scan.nextLine();
		System.out.print("enter phone_no: ");
		//if(scan.nextLine() != null)
			this.phone_no = scan.nextLine();
		System.out.print("enter twitter_info, in the absence of twitter account enter NA: ");
		//if(scan.nextLine() != null)
			this.twitter_info = scan.nextLine();
		System.out.print("facebook_info or in absence of facebook account enter NA: ");
		//if(scan.nextLine() != null)
			this.facebook_info = scan.nextLine();
		
		System.out.print("enter vacation info., either yes or no: ");
		//if(scan.nextLine() != null)
			if(scan.nextLine().equalsIgnoreCase("yes"))
				this.vacation = true;
			else this.vacation = false;
		this.date = new Date();
		
		this.total_customers ++;
		this.subscription_no ++;
		//subscription.put(this.subscription_no ,this);                               //adding the customer to the Hashmap with the respective subscription_no
		//this.total_customers = subscription.size();                                  // total no of customers
		history_of_orders = new ArrayList<Order>();
		
	}
	
	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", lastname=" + lastname
				+ ", email_id=" + email_id + ", address=" + address
				+ ", phone_no=" + phone_no + ", twitter_info=" + twitter_info
				+ ", facebook_info=" + facebook_info + ", vacation=" + vacation
				+ ", date=" + date + ", subscription_no=" + subscription_no
				+ "]";
	}

	public ArrayList<Order> getHistory_of_orders() {
		return history_of_orders;
	}

	public void setHistory_of_orders(ArrayList<Order> history_of_orders) {
		this.history_of_orders = history_of_orders;
	}

	public boolean isVacation() {
		return vacation;
	}

	public void setVacation(boolean vacation) {
		this.vacation = vacation;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getSubscription_no() {
		return subscription_no;
	}
	public void setSubscription_no(int subscription_no) {
		this.subscription_no = subscription_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	
	
	
	
}
