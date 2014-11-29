import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;


public class Order_listTest {

	ArrayList<Order> orders;
	HashMap<Integer, Order> orders_by_id;
	Customer customer = new Customer("Jane", "Doe");
	Order order = new Order(customer.getSubscription_no(), new Date());
	
	
	

	@Test
	public void test() {
		Order_list orls = new Order_list();
		orls.add_order(order);
		
		
		
		assertEquals(orders.size(),1);
		assertEquals(orders_by_id.size(),1);
		assertEquals(orders.get(0),order);
		assertEquals(orls.getOrders(),orders);
		assertEquals(orls.getOrder(100),order);
		assertEquals(orls.todays_orders(),orders);
		
		
	}

}
