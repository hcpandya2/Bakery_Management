// hari

import java.util.ArrayList;


public class Bread {
	String bread_name;
	int bread_id;
	int inventory_id; 
	int recepie_id; 
	double price;
	

	public Bread(String bread_name){
		this.bread_name = bread_name;
	}                                                           // constructor
	
	/*  remove all these methods

	public void add_bread(String bread_name){
		Bread b = new Bread(bread_name);
		list_of_breads.add(b);                                
	}                                                            // method to add a new bread to the list 
	
	public ArrayList<Bread> getList_of_breads() {
		return list_of_breads;
	}



	public void setList_of_breads(ArrayList<Bread> list_of_breads) {
		this.list_of_breads = list_of_breads;
	}



	public void remove_bread(String bread_name){
		Bread b = new Bread(bread_name);
		list_of_breads.remove(b);                                // method to remove a bread object from the list
	}
	
	*/
	
	public String getbread_name() {
		return bread_name;
	}
	public void setbread_name(String bread_name) {
		this.bread_name = bread_name;
	}
	
	public int getBread_id() {
		return bread_id;
	}
	public void setBread_id(int bread_id) {
		this.bread_id = bread_id;
	}
	public int getRecepie_id() {
		return this.recepie_id;
	}
	//public int getinventory_id(){
		//return this.inventory_id;
	//}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
