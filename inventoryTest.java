import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class inventoryTest {

	@Test
	public void test() {
	
		Bread b = new Bread("Italian herb");
		Ingredient ing = new Ingredient("flour","ABC comp");
		Quantity q = new Quantity(20, "lb");
		
		HashMap<String, Bread>  bread =  new HashMap<String,Bread>();
		 HashMap<Bread,Quantity> bread_qty = new HashMap<Bread,Quantity>() ;
		
		 HashMap<String, Ingredient>  ingredients = new HashMap<String, Ingredient>();
		 HashMap<Ingredient,Quantity> ingredients_qty = new HashMap<Ingredient,Quantity>();
		 
		 inventory inv = new inventory(bread,bread_qty,ingredients,ingredients_qty); 
		 
		
		 inv.add_bread("Italian herb",5, "packs");
		 inv.add_ingredients("flour","ABC comp", 20, "lb");
		 
		assertEquals(bread_qty.size(),1);
		assertEquals(ingredients.size(),1);
		assertEquals(bread.size(),1);
		assertEquals(ingredients.containsKey("flour"),true);
		assertEquals(ingredients.isEmpty(),false);
		assertEquals(bread.isEmpty(),false);
		assertEquals(inv.get_breadcount("Italian herb"),5,0);
		assertEquals(inv.get_ingredientcount("flour"),20,0);
		
		
		


	}


}
