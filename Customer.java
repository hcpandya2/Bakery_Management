//hari

import java.util.*;
/**
 * @author hari
 */
public class Customer {
	private String firstname;
	private String lastname;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String twitter_id;
	private String facebook_id;
	private boolean vacation;					// flag for whether the customer is on vacation or not
	private Date date;           				// date of start of subscription 
	private int subscription_no;				// subscription_no is the unique ID no for any customer
	
	//history of orders of customer (including current) from the date of subscription
	Order_List customers_orders;
	
	private static int total_customers = 0;									
	
	//this will allow total_customers to be set when program starts, if necessary
	public static void set_total_customers(int total_customers){
		if(total_customers > 0){
			Customer.total_customers = total_customers;
		}
	}
	
	public Customer(String first_name, String last_name){
		this.firstname = first_name;
		this.lastname  = last_name;
		
		this.date = new Date();
		setStreet("");
		setCity("");
		setState("");
		setZip("");
		email = "";
		phone = "";
		twitter_id = "";
		facebook_id = "";
		
		customers_orders = new Order_List();
		
		total_customers++;
		this.subscription_no = total_customers;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getSubscription_no() {
		return subscription_no;
	}
	
	public void setSubscription_no(int subscription_no) {
		this.subscription_no = subscription_no;
	}
	
	public Date getDate() {
		return date;
	}

	public String getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(String facebook_id) {
		this.facebook_id = facebook_id;
	}

	public boolean isVacation() {
		return vacation;
	}

	public void setVacation(boolean vacation) {
		this.vacation = vacation;
	}

	public String getTwitter_id() {
		return twitter_id;
	}

	public void setTwitter_id(String twitter_id) {
		this.twitter_id = twitter_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String toString(){
		String s = "";
		s = firstname + " " + lastname + "\n" + street + "\n" + city + ", " + state + " " + zip + "\n\n";
		s = s + phone + " | " + email + "\n";
		if(!twitter_id.equals("")){
			s = s + "Twitter: " + twitter_id + "\n";
		}
		if(!facebook_id.equals("")){
			s = s + "Facebook: " + facebook_id + "\n";
		}
		
		return s;
	}
	
	public String getsubscriberXMLString(){
		return ( 
			   "   <subscriber>\n" 
			+  "      <name>" + firstname + " " + lastname + "</name>\n"
			+  "      <street>" + street + "</street>\n"
			+  "      <city>" + city + "</city>\n"
			+  "      <state>" + state + "</state>\n"
			+  "      <zip>" + zip + "</zip>\n"
			+  "      <email>" + email + "</email>\n"
			+  "      <phone>" + phone + "</phone>\n"
			+  "      <twitter>" + twitter_id + "</twitter>\n"
			+  "      <facebook>" + facebook_id + "</facebook>\n"
			+  "   </subscriber>\n"
		);
	}
}
