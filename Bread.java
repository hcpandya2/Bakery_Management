// hari


public class Bread {
	String bread_name;
	int bread_id;
	int recepie_id; 
	double price;

	public Bread(String bread_name){
		this.bread_name = bread_name;
	}  // constructor
	
	public String getBread_name() {
		return bread_name;
	}
	
	public void setBread_name(String bread_name) {
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
	
	public void setRecepie_id(int recepie_id){
		this.recepie_id = recepie_id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return bread_name;
	}
}











