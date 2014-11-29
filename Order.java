// hari
import java.util.*;

public class Order {
	
	

	@Override
	public String toString() {
		return "Order [breads=" + breads + ", breads_qty=" + breads_qty
				+ ", customer_id=" + customer_id + ", order_id=" + order_id
				+ ", order_date=" + order_date + ", delivery_date="
				+ delivery_date + ", status=" + status + ", delivery_price="
				+ delivery_price + ", total_price=" + total_price + "]";
	}

	private ArrayList<Bread>       breads;
	private HashMap<Bread,Integer> breads_qty;
	
	private int    customer_id;
	private int    order_id;   //need to set this
	private Date   order_date;
	private Date   delivery_date;
	private int    status; 														// 1 = ready, 2 = pending , 3 = delivered/in past 
	private double delivery_price = 10;  //need to set this
	
	public double getDelivery_price() {
		return delivery_price;
	}

	public void setDelivery_price(double delivery_price) {
		this.delivery_price = delivery_price;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	private double total_price = 0; // will probably need this
	
	
	
	
	public Order(int customer_id, Date delivery_date){
		
		//should order date be passed in, too?
				this.order_date = new Date();
				
				this.customer_id   = customer_id;
				this.delivery_date = delivery_date;
				
				//bread and quantity
				breads     = new ArrayList<Bread>();
				breads_qty = new HashMap<Bread,Integer>();
				
				//order_id???      (a global variable that keeps incrementing )
				//delivery_price???
		
	}
	
	public void add_item(Bread bread,int q){
		breads.add(bread);
		//might need to check if bread already exists...if so just add q (not replace)
		breads_qty.put(bread,q);
		status = 2;
		
	}
	
	public void setBreads_qty(HashMap<Bread, Integer> breads_qty) {
		this.breads_qty = breads_qty;
	}

	public double total_price(){
	double charge = 0;
		
		for(Bread b : breads){
			int quantity = breads_qty.get(b).intValue();
			charge += b.getPrice() * quantity;
		}
		
		//delivery_price is not currently being set
		return total_price = delivery_price + charge ;
		
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	
	public Date getOrder_date(){
		return order_date;
	}
	
	public int getCustomer_id(){
		return customer_id;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
