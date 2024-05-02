package pizza;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */

/**
* Pepperoni. pizza includes 1 toppings, the price for a small size is $8.99.
* Add $2.00 for each size increase
* Add $1.49 for each additional topping, up to 7 toppings maximum.
* Pizza prices do not decrease if the number of toppings dropped below the number of store customized toppings.
*/
public class Pepperoni extends Pizza {

	public Pepperoni() {
		super();
		toppings.add(Topping.pepporoni);
	}
	/**
	 * find price of pepperoni
	 *
	 */
	public double price() {

		double price = 8.99;
		int usedToppings = 0;
		int includedToppings = 1;

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