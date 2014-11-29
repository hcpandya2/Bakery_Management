import static org.junit.Assert.*;

import org.junit.Test;


public class BreadTest {

	@Test
	public void bread_test() {
		String s = "wheat bread";
		Bread b = new Bread(s);
		String bread_name = b.getbread_name();
		b.setPrice(10);
		b.setBread_id(12);
		double price = b.getPrice();
		
		assertEquals(bread_name,s);
		assertEquals(b.getPrice(),10,0);
		assertEquals(b.getBread_id(),12,0);	
		
		
	}
	
	// add bread to the menu
	// delete bread from the menu
	// add bread to an order
	// decrease the no of bread from the inventory
	// check the amount of bread in inventory
	//
	
}