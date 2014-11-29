//hari

import java.util.ArrayList;
import java.util.HashMap;


public class Ingredient {
	String name;
	String info;   //info about the ingredient ex. brand name, type/category of ingredient
	
		
	public Ingredient(String name, String info){
		this.name = name;
		this.info = info;
	}
	
	public String get_name(){
		return name;
	}
		
	public String get_info(){
		return this.info;
	}
	
	
}
