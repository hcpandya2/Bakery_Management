// hari


import java.util.*;

public class inventory {
	
	// inventory of bread
	private HashMap<String, Bread>  bread ;    
	private HashMap<Bread,Quantity> bread_qty;    
	
	// inventory of all the ingredients used for making different breads
	private HashMap<String, Ingredient>  ingredients ;    
	private HashMap<Ingredient,Quantity> ingredients_qty ; 
	
	// methods to add to these arraylists
	
	
	
	public inventory(HashMap<String, Bread> bread,
			HashMap<Bread, Quantity> bread_qty,
			HashMap<String, Ingredient> ingredients,
			HashMap<Ingredient, Quantity> ingredients_qty) {
		super();
		this.bread = bread;
		this.bread_qty = bread_qty;
		this.ingredients = ingredients;
		this.ingredients_qty = ingredients_qty;
	}
	
	public void add_bread(String bread_name , double quantity, String unit){
		Quantity q = new Quantity(quantity, unit);
		Bread 	 b = new Bread(bread_name);
		
		bread.put(bread_name, b);
		bread_qty.put(b,q);
		
		}

	public void add_ingredients(String ingredient_name, String info, double quantity, String unit){
		Quantity   q   = new Quantity(quantity,unit);
		Ingredient ing = new Ingredient(ingredient_name,info);
		
		//might need to adjust this later for if the ingredient already exists
		ingredients.put(ingredient_name, ing);
		ingredients_qty.put(ing,q);
		}
	
	public double get_breadcount(String bread_name){
	
		return bread_qty.get(bread.get(bread_name)).get_amount();
	}
	
	public double get_ingredientcount(String ingredient_name){
		return ingredients_qty.get(ingredients.get(ingredient_name)).get_amount();
	}
	
	
	
	
	
	
	
}
