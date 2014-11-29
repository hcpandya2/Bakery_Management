// hari
import java.util.*;

import java.util.*;

public class Order {
	private ArrayList<Bread>        breads;
	private HashMap<Bread, Integer> breads_qty;
	private HashMap<Bread, Double>  prices_when_ordered;
	
	private int    customer_id;
	private int    order_id = 100;         //need to set this
	private Date   order_date;
	private Date   delivery_date;
	private int    status; 			 // 1 = ready, 2 = pending , 3 = delivered/in past 
	private double delivery_price;   //need to set this
	
	public Order(int customer_id, Date delivery_date){
		//should order date be passed in, too?
		this.order_date = new Date();
		
		this.customer_id   = customer_id;
		this.delivery_date = delivery_date;
		
		//bread and quantity
		breads     = new ArrayList<Bread>();
		breads_qty = new HashMap<Bread,Integer>();
		prices_when_ordered = new HashMap<Bread, Double>();
	}
	
	//this version of add_item allows a price for the bread to be specified
	//(this may be different than the current price stored in 'bread')
	public void add_item(Bread bread, int q, double price){
		breads.add(bread);
		prices_when_ordered.put(bread, price);
		//if bread already exists in breads_qty, just add q to the
		//quantity desired...
		if(!breads_qty.containsKey(bread)){
			breads_qty.put(bread,q);
		}
		else{
			int old_qty = breads_qty.get(bread).intValue();
			breads_qty.put(bread, (old_qty + q));
		}

		//pending
		setStatus(2);
	}
	
	public void add_item(Bread bread, int q){
		breads.add(bread);
		prices_when_ordered.put(bread, bread.getPrice());
		
		//if bread already exists in breads_qty, just add q to the
		//quantity desired...
		if(!breads_qty.containsKey(bread)){
			breads_qty.put(bread,q);
		}
		else{
			int old_qty = breads_qty.get(bread).intValue();
			breads_qty.put(bread, (old_qty + q));
		}
		
		//pending
		setStatus(2);
	}
	
	public double total_price(){
		double charge = 0;
		
		for(Bread b : breads){
			int quantity = breads_qty.get(b).intValue();
			charge += prices_when_ordered.get(b).doubleValue() * quantity;
		}
		
		//delivery_price is not currently being set
		return charge + delivery_price;
	}
	
	public ArrayList<Bread> getBreads(){
		return breads;
	}
	
	public HashMap<Bread, Integer> getBreads_qty(){
		return breads_qty;
	}
	
	public Integer getBreadQty(Bread b){
		return breads_qty.get(b);
	}
	
	public Date getDelivery_date(){
		return delivery_date;
	}
	
	public void setDelivery_date(Date delivery_date){
		this.delivery_date = delivery_date;
	}
	
	public Date getOrder_date(){
		return order_date;
	}
	
	public void setOrder_date(Date order_date){
		this.order_date = order_date;
	}
	
	public int getCustomer_id(){
		return customer_id;
	}
	
	public void setCustomer_id(int customer_id){
		this.customer_id = customer_id;
	}
	
	public int getOrder_id(){
		return order_id;
	}
	
	public void setOrder_id(int order_id){
		this.order_id = order_id;
	}
	
	public double getDelivery_price(){
		return delivery_price;
	}
	
	public void setDelivery_price(double delivery_price){
		this.delivery_price = delivery_price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String toString(){
		String s = String.format("Order No: %-4d  Customer No: %-4d\n", order_id, customer_id);
		s = s +    "Order Date:     " + (order_date.getMonth() + 1) + "-" + order_date.getDate() + "-" + order_date.getYear() + "\n";
		s = s +    "Delivery Date:  " + (delivery_date.getMonth() + 1) + "-" + delivery_date.getDate() + "-" + delivery_date.getYear() + "\n";
		for(Bread b : breads){
			s = s + String.format("  %-13s $%2.2f x %d\n", b, prices_when_ordered.get(b), breads_qty.get(b));
		}
		return s;
	}
}
