
// hari
import java.io.*;
import java.util.*;


public class Bakery {
	private static ArrayList<Customer> customers;
	private static ArrayList<Recepie>  recepie_list;
	private static ArrayList<Bread>    list_of_breads;
	private static Order_list    	   orders;
	
	
public static void main (String arg[] ){
	
	Scanner scan = new Scanner(System.in);
	
	File customers_file      = new File("customer.xml");
	File orders_per_day_file = new File("orders.xml");
	File recepie_file        = new File("recepies.xml");
	File inventory_file      = new File("inventory.xml");
	
	orders   = new Order_list();
	customers      = new ArrayList<Customer>();
	recepie_list   = new ArrayList<Recepie>();
	list_of_breads = new ArrayList<Bread>();
	
	boolean keep_running = true;
	while(keep_running){
		keep_running = main_menu(scan);
	}
	scan.close();
	
	}                                    // end of main method


private static boolean main_menu(Scanner scan){

	System.out.println("To do any operations regarding customers, enter 'Customer': ");
	System.out.println("To do any operations regarding orders, enter 'Orders':");
	System.out.println("To do any administritative operations regarding bakery, enter 'Bakery': ");
	System.out.println("To quit, enter 'Quit': ");
	
	String menu_choice = scan.nextLine();
	
	if(menu_choice.equalsIgnoreCase("customer")){
		// give further instructions and prompt for appropriate input
		customer_menu(scan);	
	}
	else if(menu_choice.equalsIgnoreCase("orders")) {
		// give further instructions and prompt for appropriate input
		order_menu(scan);
	}
	//else if(menu_choice.equalsIgnoreCase("bakery")){
		// give further instructions and prompt for appropriate input
		//bakery_menu(scan);
	//}
	else if(menu_choice.equalsIgnoreCase("quit")){
		return false;
	}
	else{
		//System.out.println("Invalid option entered.");
	}
	return true;
}

private static void customer_menu(Scanner scan){
	
	Scanner scann = new Scanner(System.in);
	int temp_sub_no;
	boolean vacation;
	String email;
	boolean display_again = true;
	while(display_again){
		
		display_again = false;
		
		System.out.println(" To lookup customer information, enter 'customer lookup' :");
		System.out.println(" To add a new customer, enter 'add customer'");
		System.out.println(" To check customer's subscription, enter 'subscription' :");
		System.out.println(" To get history of orders of a customer, enter 'order history' :");
		System.out.println(" To change the status of subscription of a customer, enter 'status change' :");
		System.out.println(" To notify customers of change in policy or new product promotion, enter 'notification' :");
		System.out.println(" To return to the main menu, enter 'main menu'");
		
		String menu_choice = scan.nextLine();
		
		if(menu_choice.equalsIgnoreCase("customer lookup")){
			// give further instructions and prompt for appropriate input
			System.out.println("customer lookup option selected");
			System.out.println("enter the subscription number of customer for lookup");
			String temp = scann.nextLine();
			temp_sub_no = Integer.parseInt(temp);
			
			for(Customer customer : customers){
				if(customer.getSubscription_no() == (temp_sub_no))
					System.out.println(customer.toString());
			}			
		}
		
		else if (menu_choice.equalsIgnoreCase("add customer")){
			System.out.println("add customer option selected");
			System.out.print("first name: ");
			String first_name = scan.nextLine();
			System.out.print("last name: ");
			String last_name = scan.nextLine();					
			customers.add(new Customer(first_name, last_name));
		}
		
		else if(menu_choice.equalsIgnoreCase("subscription")){
			// give further instructions and prompt for appropriate input
			System.out.println("subscription option selected");
			System.out.print("Enter the subscriptin_no of the customer:");
			temp_sub_no = scan.nextInt();
			for(Customer customer : customers){
				if(customer.getSubscription_no() == temp_sub_no){
					if(vacation = customer.isVacation())
						System.out.println("The customer is on vacation.");
					else System.out.println("The customer is not on vacation.");
					}
			} // end of for loop
			
		}
		
		else if(menu_choice.equalsIgnoreCase("order history")){
			// give further instructions and prompt for appropriate input
			System.out.println("order history option selected");
			System.out.println("Enter the subscription_no of the customer:");
			temp_sub_no = scan.nextInt(); 
			for(Customer customer : customers){
				if(customer.getSubscription_no() == temp_sub_no)
					System.out.println(customer.getHistory_of_orders());
				}
			}
		
		
		else if(menu_choice.equalsIgnoreCase("status change")){
			// give further instructions and prompt for appropriate input
			System.out.println("status change option selected");
			System.out.println("Enter the subscription_no of the customer:");
			temp_sub_no = scan.nextInt();
			for(Customer customer: customers){
				if(customer.getSubscription_no() == temp_sub_no){
					customer.vacation = !(customer.vacation) ;
					}
				}
			
		}
		
		else if(menu_choice.equalsIgnoreCase("notification")){
			// give further instructions and prompt for appropriate input
			System.out.println("notification option selected");
			System.out.println("Enter the subscription_no of the customer to notify:");
			temp_sub_no = scan.nextInt();
			for(Customer customer: customers){
				if(customer.getSubscription_no() == temp_sub_no){
					email = customer.getEmail_id();
					}
			}	
		}
		
		else if(menu_choice.equalsIgnoreCase("main menu")){
			// give further instructions and prompt for appropriate input
			System.out.println("returning to main menu");
		}
		else{
			display_again = true;
			System.out.println(" Invalid option selected");
		}
	}
}

private static void order_menu(Scanner scan){
	
	Scanner scannn = new Scanner(System.in);
	
	int temp_order_id, temp_subs_no, temp =0;
	String temp_status;
	boolean display_again = true;
	while(display_again){
		
		display_again = false;
	
		//some of these options are repeated from the customer menu...fix soon
		System.out.println(" To lookup today's orders, enter 'today's order' :");
		System.out.println(" To check details of order, enter 'order info' :");
		System.out.println(" To get history of orders of a customer, enter 'order history' :");
		System.out.println(" To change the status of subscription of a customer, enter 'status change' :");
		System.out.println(" To notify customers of change in policy or new product promotion, enter 'notification' :");
		System.out.println(" To return to the main menu, enter 'main menu'");
		
		String menu_choice = scannn.nextLine();
		
		if(menu_choice.equalsIgnoreCase("today's order")){
			// give further instructions and prompt for appropriate input
			System.out.println("today's order option selected");
			System.out.print("To get the list of orders, enter the date:");
			
			
		}
		else if(menu_choice.equalsIgnoreCase("order info")){
			// give further instructions and prompt for appropriate input
			System.out.println("order info option selected");
			System.out.print("Enter the order_id , to get the order information: ");
			//temp_order_id = scannn.nextInt();
			String temp_order_id_S = scannn.nextLine();
			temp_order_id = Integer.parseInt(temp_order_id_S); //something like this!
			for(Order order : orders.getOrders()){
				if(order.getOrder_id() == temp_order_id)
					System.out.println(order.toString());
			}
			
		}
		
		else if(menu_choice.equalsIgnoreCase("order history")){
			// give further instructions and prompt for appropriate input
			System.out.println("order history option selected");
			System.out.print("Enter the subscription_no of the customer, to get the history or orders:");
			temp_subs_no = scannn.nextInt();
			for(Customer customer : customers){
				if(customer.getSubscription_no() == temp_subs_no)
					System.out.println(customer.getHistory_of_orders());
			}
		
		
		}
		else if(menu_choice.equalsIgnoreCase("status change")){
			// give further instructions and prompt for appropriate input
			System.out.println("status change option selected");
			System.out.println("Enter the order_id, to change the status of the order:");
			temp_order_id = scannn.nextInt();
			System.out.print("Choose the order status from the three option: 'ready', 'pending', ' delivered' : ");
			
			temp_status = scannn.nextLine();
			while(temp_status != null){
			
			if(temp_status.equalsIgnoreCase("ready"))
				temp = 1;
			else if (temp_status.equalsIgnoreCase("pending"))
				temp = 2;
			else if (temp_status.equals("delivered"))
				temp = 3;
			else {
				System.out.print("invalid input, re-enter: ");
				temp_status = scannn.nextLine();
				}
			
			}
			
			for(Order order : orders.getOrders()){
			
				if(order.getOrder_id() == temp_order_id)
					order.setStatus(temp);
				}
			}
			
	
		else if(menu_choice.equalsIgnoreCase("main menu")){
			// give further instructions and prompt for appropriate input
			System.out.println("returning to main menu");
		}
		else{
			display_again = true;
			System.out.println(" Invalid option selected");
		}
	}
}



	
}


