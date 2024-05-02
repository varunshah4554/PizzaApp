package pizza;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
/**
 *  This is the class to create an instance of the pizza object
 *
 */


//create an instance of subclasses based on the chosen flavor
public class PizzaMaker {
	/**
	 * create the pizza
	 *
	 */
public static Pizza createPizza(String flavor) {
	
	Pizza pizza = null;
	
	
	if(flavor.toLowerCase().equals("deluxe")){
		pizza = new Deluxe();
	}
			
	else if(flavor.toLowerCase().equals("pepperoni")){
		pizza = new Pepperoni();
	}
	
	else if(flavor.toLowerCase().equals("hawaiian")){
		pizza = new Hawaiian();
	}
			
			return pizza;

}
}