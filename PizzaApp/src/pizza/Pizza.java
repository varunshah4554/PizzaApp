package pizza;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
/**
 *  defines pizza
 *
 */


import java.util.ArrayList;
/**
 * Pizza class to hold all pizzas
 *
 */
public abstract class Pizza {
	
protected ArrayList<Topping> toppings = new ArrayList<Topping>();

protected Size size;
public abstract double price();
/**
 * find pizza
 *
 */
public Pizza() {
	this.toppings=new ArrayList<Topping>();
	this.size=Size.small;
}
/**
 * toString pizza
 *
 */
public String toString() { // String representation of User
    return ("Size: " + this.size + "\nToppings:");
}

}