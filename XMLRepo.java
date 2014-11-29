import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//Used the following for reference while completing this class:
//this method's code is based upon guidance from the following site:
//http://www.java-samples.com/showtutorial.php?tutorialid=152

public class XMLRepo {
	
	public static ArrayList<Customer> xmlParseCustomers(String file_name){
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			customers = customerDocumentParse(builder.parse(file_name));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return customers;
	}
	
	public static ArrayList<Recepie> xmlParseRecepies(String file_name){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		ArrayList<Recepie> recepies = new ArrayList<Recepie>();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			recepies = recepieDocumentParse(builder.parse(file_name));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return recepies;
	}
	
	public static HashMap<Ingredient,Quantity> xmlParseIngredientInventory(String file_name){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		HashMap<Ingredient,Quantity> ingredient_qty = new HashMap<Ingredient,Quantity>();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			ingredient_qty = ingredientInventoryDocumentParse(builder.parse(file_name));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ingredient_qty;
	}

	public static HashMap<Bread,Quantity> xmlParseBreadInventory(String file_name, ArrayList<Bread> breads_offered){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		HashMap<Bread, Quantity> bread_qty = new HashMap<Bread, Quantity>();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			bread_qty = breadInventoryDocumentParse(builder.parse(file_name), breads_offered);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return bread_qty;
	}
	
	public static ArrayList<Bread> xmlParseBreadsOffered(String file_name){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		ArrayList<Bread> breads_offered = new ArrayList<Bread>();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			breads_offered = breadsOfferedDocumentParse(builder.parse(file_name));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return breads_offered;
	}
	
	public static Order_List xmlParseOrders(String file_name, ArrayList<Bread> breads_offered) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		Order_List orders = new Order_List();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			orders = ordersDocumentParse(builder.parse(file_name), breads_offered);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return orders;
	}
	
	private static Order_List ordersDocumentParse(Document dom, ArrayList<Bread> breads_offered) {
		Order_List orders_list = new Order_List();
		//this gets the root element
		Element documentElement = dom.getDocumentElement();
		//get list of subscribers
		NodeList orders = documentElement.getElementsByTagName("order");
		System.out.println("");
		
		System.out.println("Order count: " + orders.getLength() + "\n");
		
		//need a hashmap of <bread_id, Bread>
		HashMap <Integer, Bread> breads_offered_by_id = new HashMap <Integer, Bread>();
		for(Bread b : breads_offered){
			breads_offered_by_id.put(b.getBread_id(), b);
		}
		
		for(int i = 0; i < orders.getLength(); i++){
			Element order = (Element)orders.item(i);
			
			String orderid_S	  = order.getElementsByTagName("orderid").item(0).getFirstChild().getNodeValue();
			String customerid_S   = order.getElementsByTagName("customerid").item(0).getFirstChild().getNodeValue();
			String orderdate_S    = order.getElementsByTagName("orderdate").item(0).getFirstChild().getNodeValue();
			String deliverydate_S = order.getElementsByTagName("deliverydate").item(0).getFirstChild().getNodeValue();
			String status_S       = order.getElementsByTagName("status").item(0).getFirstChild().getNodeValue();
			String price_S        = order.getElementsByTagName("deliveryprice").item(0).getFirstChild().getNodeValue();
			
			int orderid = Integer.parseInt(orderid_S);
			int customerid = Integer.parseInt(customerid_S);
		
			int status = Integer.parseInt(status_S);
			double price = Double.parseDouble(price_S);
			String[] orderdate_S_split = orderdate_S.split("-");
			String[] deliverydate_S_split = deliverydate_S.split("-");
			//temp dates...
			Date deliverydate = new Date();
			deliverydate.setYear(Integer.parseInt(deliverydate_S_split[0]));
			deliverydate.setMonth(Integer.parseInt(deliverydate_S_split[1]) - 1);
			deliverydate.setDate(Integer.parseInt(deliverydate_S_split[2]));
			deliverydate.setHours(0);
			deliverydate.setMinutes(0);
			deliverydate.setSeconds(0);
			
			Date orderdate = new Date();
			orderdate.setYear(Integer.parseInt(orderdate_S_split[0]));
			orderdate.setMonth(Integer.parseInt(orderdate_S_split[1]) - 1);
			orderdate.setDate(Integer.parseInt(orderdate_S_split[2]));
			orderdate.setHours(0);
			orderdate.setMinutes(0);
			orderdate.setSeconds(0);
			
			Order odr = new Order(customerid, deliverydate);
			odr.setOrder_id(orderid);
			odr.setOrder_date(orderdate);
			odr.setDelivery_price(price);
			odr.setStatus(status);
			
			NodeList order_items = order.getElementsByTagName("item");
			for(int j = 0; j < order_items.getLength(); j++){
				Element item = (Element)order_items.item(j);
				String item_line = item.getTextContent();
				String[] item_parts = item_line.split(",");

				int bread_id = Integer.parseInt(item_parts[0]);
				Bread this_bread;
				//if bread is still offered, set bread to the same object,
				//otherwise, create a new bread
				
				if(breads_offered_by_id.containsKey(bread_id)){
					this_bread = breads_offered_by_id.get(bread_id);
				}
				else {
					this_bread = new Bread("discontinued bread [id=" + bread_id + "]");
				}
				
				int count = Integer.parseInt(item_parts[1]);
				double price_paid = Double.parseDouble(item_parts[2]);
				
				odr.add_item(this_bread, count, price_paid);
			}

			orders_list.add_order(odr);
			System.out.println(odr);
		}
		
		return orders_list;
	}

	private static ArrayList<Bread> breadsOfferedDocumentParse(Document dom) {
		ArrayList<Bread> breads_offered = new ArrayList<Bread>();
		//this gets the root element
		Element documentElement = dom.getDocumentElement();
		//get list of subscribers
		NodeList breads = documentElement.getElementsByTagName("bread");
		System.out.println("");
		
		for(int i = 0; i < breads.getLength(); i++){
			Element bread = (Element)breads.item(i);
			
			String id_S		   = bread.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
			String name        = bread.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			String recepieid_S = bread.getElementsByTagName("recepieid").item(0).getFirstChild().getNodeValue();
			String price_S     = bread.getElementsByTagName("price").item(0).getFirstChild().getNodeValue();
			
			Bread brd = new Bread(name);
			brd.setBread_id(Integer.parseInt(id_S));
			brd.setRecepie_id(Integer.parseInt(recepieid_S));
			brd.setPrice(Double.parseDouble(price_S));
			
			breads_offered.add(brd);
			
			//the following output is for debugging
			System.out.printf("%-15s [$%2.2f]\n", brd, brd.getPrice());
		}
		
		System.out.println("");

		return breads_offered;
	}

	private static HashMap<Ingredient, Quantity> ingredientInventoryDocumentParse(Document dom) {
		HashMap<Ingredient, Quantity> ingredient_qty = new HashMap<Ingredient, Quantity>();
		
		//this gets the root element
		Element documentElement = dom.getDocumentElement();
		//get list of ingredients
		NodeList ingredients = documentElement.getElementsByTagName("ingredient");
		System.out.println("");
		
		for(int i = 0; i < ingredients.getLength(); i++){
			Element ingredient = (Element)ingredients.item(i);
			
			String name = ingredient.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			String info = "";
			try{
				info = ingredient.getElementsByTagName("info").item(0).getFirstChild().getNodeValue();
			}
			catch (Exception e){
				//do nothing...no Twitter account for this subscriber
			}
			String quantity_S = ingredient.getElementsByTagName("quantity").item(0).getFirstChild().getNodeValue();
			String unit       = ingredient.getElementsByTagName("unit").item(0).getFirstChild().getNodeValue();
			
			Ingredient ingred   = new Ingredient(name, info);
			Quantity   quantity = new Quantity(Double.parseDouble(quantity_S), unit);
		
			ingredient_qty.put(ingred, quantity);
			
			//the following output is for debugging
			System.out.printf("%-15s %s\n", ingred, quantity);
		}
		
		System.out.println("");
		
		return ingredient_qty;
	}
	
	private static HashMap<Bread, Quantity> breadInventoryDocumentParse(Document dom, ArrayList<Bread> breads_offered) {
		HashMap<Bread, Quantity> bread_qty = new HashMap<Bread, Quantity>();
		
		//create a hash map so breads in breads_offered can be found easily by name
		HashMap<String, Bread> breads_offered_map = new HashMap<String, Bread>();
		for(Bread b : breads_offered){
			breads_offered_map.put(b.getBread_name(), b);
		}
		
		//this gets the root element
		Element documentElement = dom.getDocumentElement();
		//get list of breads
		NodeList breads = documentElement.getElementsByTagName("bread");
		System.out.println("");
		
		for(int i = 0; i < breads.getLength(); i++){
			Element bread = (Element)breads.item(i);
			
			String name       = bread.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			
			String quantity_S = bread.getElementsByTagName("quantity").item(0).getFirstChild().getNodeValue();
			String unit       = bread.getElementsByTagName("unit").item(0).getFirstChild().getNodeValue();
			
			Bread brd = breads_offered_map.get(name);
			Quantity quantity = new Quantity(Double.parseDouble(quantity_S), unit);
		
			bread_qty.put(brd, quantity);
			
			//the following output is for debugging
			System.out.printf("%-15s %s\n", brd, quantity);
		}
		
		System.out.println("");
		
		return bread_qty;
	}

	private static ArrayList<Customer> customerDocumentParse(Document dom){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		//this gets the root element
		Element documentElement = dom.getDocumentElement();
		//get list of subscribers
		NodeList subscribers    = documentElement.getElementsByTagName("subscriber");

		System.out.println("");
		
		for(int i = 0; i < subscribers.getLength(); i++){
			Element subscriber = (Element)subscribers.item(i);
			
			String name   = subscriber.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			String street = subscriber.getElementsByTagName("street").item(0).getFirstChild().getNodeValue();
			String city   = subscriber.getElementsByTagName("city").item(0).getFirstChild().getNodeValue();
			String state  = subscriber.getElementsByTagName("state").item(0).getFirstChild().getNodeValue();
			String zip    = subscriber.getElementsByTagName("zip").item(0).getFirstChild().getNodeValue();
			String email  = subscriber.getElementsByTagName("email").item(0).getFirstChild().getNodeValue();
			String phone  = subscriber.getElementsByTagName("phone").item(0).getFirstChild().getNodeValue();
			
			String twitter = "";
			try{
				twitter = subscriber.getElementsByTagName("twitter").item(0).getFirstChild().getNodeValue();
			}
			catch (Exception e){
				//do nothing...no Twitter account for this subscriber
			}
			
			String facebook = "";
			try{
				facebook = subscriber.getElementsByTagName("facebook").item(0).getFirstChild().getNodeValue();
			}
			catch(Exception e){
				//do nothing...no Facebook account for this subscriber
			}
			
			Customer cust = new Customer("new","customer");
			String[] names = name.split(" ");
			
			if(names.length > 0)
				cust.setFirstname(names[0]);
			if(names.length > 1)
				cust.setLastname(names[1]);
			cust.setStreet(street);
			cust.setCity(city);
			cust.setState(state);
			cust.setZip(zip);
			cust.setEmail(email);
			cust.setTwitter_id(twitter);
			cust.setFacebook_id(facebook);
			cust.setPhone(phone);
		
			customers.add(cust);
			
			//the following output is for debugging
			System.out.println(cust);
		}
		
		return customers;
	}
	
	private static ArrayList<Recepie> recepieDocumentParse(Document dom){
		ArrayList<Recepie> recepies = new ArrayList<Recepie>();
		
		//this gets the root element
		Element documentElement = dom.getDocumentElement();
		//get list of recipes
		NodeList recepies_nodes = documentElement.getElementsByTagName("recipe");

		System.out.println("");
		
		for(int i = 0; i < recepies_nodes.getLength(); i++){
			Element recepe = (Element)recepies_nodes.item(i);
			String name = recepe.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();

			HashMap<Ingredient, Quantity> recepie_ingredients = new HashMap<Ingredient, Quantity>();
			
			NodeList recipe_ingredients = recepe.getElementsByTagName("ingredient");
			for(int j = 0; j < recipe_ingredients.getLength(); j++){
				Element ingredient = (Element)recipe_ingredients.item(j);
				//ingredient_S has both ingredient and quantity
				String ingredient_S = ingredient.getTextContent();
				//need to convert ingredient_S to <Ingredient,Quantity> ingredient
				String[] ingredient_tok = ingredient_S.split(",");
				
				String ingredient_name = ingredient_tok[0];
				
				//ingredient
				Ingredient new_ingredient = new Ingredient(ingredient_name, "");
				
				//quantity
				double amount = Double.parseDouble(ingredient_tok[1]);
				String unit_type = ingredient_tok[2];
				Quantity qty = new Quantity(amount, unit_type);
				
				//add ingredient to recepie
				recepie_ingredients.put(new_ingredient, qty);
			}
			
			String width_S  = recepe.getElementsByTagName("width").item(0).getFirstChild().getNodeValue();
		    String height_S = recepe.getElementsByTagName("height").item(0).getFirstChild().getNodeValue();
		    String length_S = recepe.getElementsByTagName("length").item(0).getFirstChild().getNodeValue();
			String desc     = recepe.getElementsByTagName("description").item(0).getFirstChild().getNodeValue();
			
			Recepie resc = new Recepie(name, Double.parseDouble(width_S), Double.parseDouble(height_S), Double.parseDouble(length_S));
			resc.setIngredients(recepie_ingredients);
			resc.setDescription(desc);

			//The following few lines of output is for debugging purposes,
			//but it can be reused to print a recepie later
			System.out.println(resc);
			for(Ingredient ingred : resc.getIngredients().keySet()){
				System.out.printf("  %-15s %s\n", ingred, resc.getIngredients().get(ingred));
			}
			System.out.println(resc.getDescription());
			System.out.println("");
			
			recepies.add(resc);
		}
		
		return recepies;
	}
}