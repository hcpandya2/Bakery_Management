import static org.junit.Assert.*;

import org.junit.Test;


public class IngredientTest {

	@Test
	public void test() {
		String name = "wheat flour";
		String info = "ABC company";
		
		Ingredient ing = new Ingredient(name,info);
		assertEquals(ing.get_name(),name);
		assertEquals(ing.get_info(),info);
	
	}

	//add and delete ingredient to inventory
	// get ingredient from a recepie or delete
	// 
	
}
