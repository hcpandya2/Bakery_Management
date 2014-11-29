// hari
import java.util.HashMap;
import java.util.Scanner;


public class Recepie {

	private int recepie_id;
	private double width;
	private double height;
	private Bread b; //should this just be bread ID? 

	HashMap<Ingredient,Quantity> ingredients = new HashMap<Ingredient,Quantity>();
	
	
	public Recepie(double width,double height, String bread_name){
		this.width = width;
		this.height = height;
		
		//this is going to cause a null reference exception. no bread exists yet.
		b.setbread_name(bread_name);
		
	}
			
	public void add_ingredient(Ingredient ing, Quantity qt){
		ingredients.put(ing, qt);		
		
	}	
	
	
	public HashMap<Ingredient, Quantity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<Ingredient, Quantity> ingredients) {
		this.ingredients = ingredients;
	}

	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getRecepie_id() {
		return recepie_id;
	}
	public String getbread_name(){
		return b.getbread_name();
	}
	
	
	
	
	
	
	
}
