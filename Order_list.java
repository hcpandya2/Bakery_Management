// hari
// a list of orders that are mapped to each customers...

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Order_List {
	private ArrayList<Order> orders;
	private HashMap<Integer, Order> orders_by_id;
	
	public Order_List(){
		orders = new ArrayList<Order>();
		orders_by_id = new HashMap<Integer, Order>();
	}
	
	public void add_order(Order order) {
		orders.add(order);
		orders_by_id.put(order.getOrder_id(), order);
	}
	
	public Order getOrder(Integer orderId){
		return orders_by_id.get(orderId);
	}
	
	public ArrayList<Order> getOrders(){
		return orders;
	}
	
	public void print_orders(){
	    for(Order order : orders){
	    	System.out.println(order);
	    }
	}
	
	private Date getTodaysDate(){
		return new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
	}
		    
	public ArrayList<Order> todays_orders(){
		return days_orders(getTodaysDate());
	}
	
	public  ArrayList<Order> days_orders(Date date){
		ArrayList<Order> days_orders = new ArrayList<Order>();	
		
		for(Order an_order : orders){
			if(an_order.getDelivery_date().equals(date)){
				days_orders.add(an_order);
			}
		}
		
		//if printing orders belongs here...this works  	
	  	for(Order an_order : days_orders){
	  		System.out.println(an_order);
	  	}  	
	  	
	  	return days_orders;
	}
	
	public HashMap<Bread,Integer> breads_to_cook_today(){
		return breads_to_cook(getTodaysDate());
	}
	
	public HashMap<Bread,Integer> breads_to_cook(Date date){
		
		// list of orders for a given date
		ArrayList<Order> days_orders = days_orders(date);                                  
		
		HashMap<Bread, Integer> breads_to_cook = new HashMap<Bread, Integer>();
		
		//loop through orders
		for(Order an_order : days_orders){
			//breads associated with an_order
			ArrayList<Bread> breads = an_order.getBreads();
			//loop through each bread in order, add quantity to total
			for(Bread bread : breads){
				//this is the first time seeing this bread
				if(!breads_to_cook.containsKey(bread)) {
					breads_to_cook.put(bread, an_order.getBreadQty(bread));
				}
				//some of this bread already is in breads_to_cook
				else {
					int previous_qty = breads_to_cook.get(bread).intValue();
					Integer new_qty = new Integer(previous_qty + an_order.getBreadQty(bread));
					breads_to_cook.put(bread, new_qty);
				}
			}
		}
		
		return breads_to_cook;
	}  // end of breads to cook
		
	
	public HashMap<Ingredient, Quantity> todays_total_ingredients(ArrayList<Recepie> recepies){
		return total_ingredients(getTodaysDate(), recepies);
	}
	
	public HashMap<Ingredient, Quantity> total_ingredients (Date date, ArrayList<Recepie> recepies){
		
		HashMap<Bread, Integer> days_breads = breads_to_cook(date);
		
		//create hash map of recepies
		HashMap<Integer, Recepie> recepies_by_id = new HashMap<Integer, Recepie>();
		for(Recepie recepie : recepies){
			recepies_by_id.put(new Integer(recepie.getRecepie_id()), recepie);
		}

		HashMap<Ingredient, Quantity> list_of_ingredients = new HashMap<Ingredient, Quantity>();

		//loop through each type of bread for this day
		for(Bread bread : days_breads.keySet()){
			//bread's recepie:
			Recepie breads_recepie = recepies_by_id.get(new Integer(bread.getBread_id()));
			//ingredients for recepie
			HashMap<Ingredient, Quantity> breads_ingredients = breads_recepie.getIngredients();
			
			//loop through each ingredient in this bread's recepie
			for(Ingredient ingredient : breads_ingredients.keySet()){
				
				//not sure if this will work without modification...not sure if we're using the same
				//ingredient object across the entire program for a single ingredient
				Quantity ingredient_qty = breads_ingredients.get(ingredient);
				//amount is amount for one bread times number of this bread
				double amount = ingredient_qty.get_amount() * days_breads.get(bread).intValue();
				
				//ingredient not already in list of ingredients
				if(!list_of_ingredients.containsKey(ingredient)){
					
					Quantity new_quantity = new Quantity(amount, ingredient_qty.getUnit_name());
					list_of_ingredients.put(ingredient, new_quantity);
				}
				else {
					list_of_ingredients.get(ingredient).add_amount(amount);
				}
			}
		}
	    
	    return list_of_ingredients;
	
	} 	//end of total_ingredients																					// end of method
				
}	








