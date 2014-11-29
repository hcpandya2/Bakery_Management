import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class RecepieTest {

	HashMap<Ingredient,Quantity> ingredients = new HashMap<Ingredient,Quantity>();
	Ingredient ing = new Ingredient("wheat flour", "ABC");
	Quantity qt = new Quantity(5, "lb");
	Bread b ;
	@Test
	public void test() {
	
		Recepie recepie = new Recepie(5, 3, "wheat bread" );
		assertEquals(recepie.getbread_name(),"wheat bread");
		assertEquals(recepie.getHeight(),3,0);
		assertEquals(recepie.getWidth(),5,0);
		
		recepie.add_ingredient(ing, qt);
		assertEquals(recepie.getIngredients(),ingredients);
		assertEquals(recepie.getbread_name(),"wheat bread");
	}

}
