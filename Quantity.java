// hari
import java.util.*;

public class Quantity {
	private double amount;
	private String unit_name;
	
public Quantity(double amount, String unit){
	this.amount = amount;
	this.unit_name = unit;	
	
}
	public double get_amount(){
		return this.amount ;
	}
	
	public String getUnit_name(){
		return unit_name;
	}
	public void add_amount(double amount){
		if(amount > 0){
			this.amount += amount;
		}
	}
	
}
