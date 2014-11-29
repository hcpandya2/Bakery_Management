import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;


public class OrderTest {
	ArrayList<Bread> breads = new ArrayList<Bread>();
	HashMap<Bread,Integer> breads_qty = new HashMap<Bread,Integer>();
	
	@Test
	public void test() {
		Bread bread = new Bread("Rustic Potato");
		Customer customer = new Customer("John", "Doe");
		Order order = new Order(customer.getSubscription_no(), new Date());
		
		assertEquals(order.getCustomer_id(),customer.getSubscription_no());
		assertEquals(order.getDelivery_date(),new Date());
		
	}

	public void add_bread(){
		Bread bread = new Bread("Rustic Potato");
		Customer customer = new Customer("John", "Doe");
		Order order = new Order(customer.getSubscription_no(), new Date());
		order.add_item(bread, 5);
		
		assertEquals(breads.size(),1);
		assertFalse(breads.isEmpty());
		assertEquals(breads.get(0), bread);
		assertEquals(breads_qty.containsKey(bread),true);
		assertEquals(breads_qty.get(bread),5,0);
		
	}

	
	

	
}
