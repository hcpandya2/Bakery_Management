// hari
import java.util.HashMap;
import java.util.Scanner;

import java.util.HashMap;

public class Recepie {
	private int    recepie_id;
	private String bread_name;
	private double width;
	private double height;
	private double length;
	private String description;

	HashMap<Ingredient,Quantity> ingredients = new HashMap<Ingredient, Quantity>();
	
	public Recepie(String bread_name, double width, double height, double length){
		this.width      = width;
		this.height     = height;
		this.length     = length;
		this.bread_name = bread_name;
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
		return bread_name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return bread_name + ": [" + width + "(W) x " + length + "(L) x " + height + "(H)]";
	}
}