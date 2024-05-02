package pizza;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */

/**
* Deluxe pizza includes 5 toppings, the price for a small size is $12.99.
* Add $2.00 for each size increase
* Add $1.49 for each additional topping, up to 7 toppings maximum.
* Pizza prices do not decrease if the number of toppings dropped below the number of store customized toppings.
*/
public class Deluxe extends Pizza {

	public Deluxe() {
		super();
		toppings.add(Topping.olives);
		toppings.add(Topping.pepper);
		toppings.add(Topping.mushroom);
		toppings.add(Topping.onion);
		toppings.add(Topping.pepper);
	}
	/**
	 * find price of deluxe
	 *
	 */
	public double price() {

		double price = 12.99;
		int usedToppings = 0;
		int includedToppings = 5;

		if (this.size == Size.medium) {
			price = price + 2;
		}

		if (this.size == Size.large) {
			price = price + 4;
		}

		for (int i = 0; i < toppings.size(); i++) {

			if (toppings.get(i) != null) {
				usedToppings++;
			}

		}

		if (usedToppings - includedToppings > 0) {
			price = price + (usedToppings - includedToppings) * 1.49;
		}

		return price;
	}

}