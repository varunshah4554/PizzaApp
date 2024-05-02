package pizza;
import java.util.LinkedList;
import java.io.FileWriter; 
import java.io.IOException; 


/**
 * An instance of this class keeps the list of orders placed by the user.
 * an export() method in this class to save the store orders to an external text file
 */
public class StoreOrders {

	LinkedList<Order> StoreOrders = new LinkedList<Order>();
	/**
	 * Add pizza to order
	 *
	 */
	public boolean addtoOrder(Order order, LinkedList<Order> StoreOrders, Pizza pizza) {

		int totalSize = StoreOrders.size();

		boolean added = false;
		// ArrayList<Topping> toppings = null;
		Size size = Size.small;
		String flavor = "";

		boolean toAdd = false;
		boolean toRemove = false;
		Topping selectedTopping = null;

		for (int i = 0; i < totalSize; i++) {
			int j = 0;
			// add to prexisting order
			while (j < order.size()) {
				StoreOrders.getFirst();
				if (Order.getPhone().equals(Order.getPhone())) {

					order.Order.add(PizzaMaker.createPizza(flavor));
					// editToppings(order.Order.getLast(), toppings);

					if (toAdd) {

						addTopping(order.Order.getLast(), selectedTopping);
						toAdd = false;

					}

					if (toRemove) {

						removeTopping(order.Order.getLast(), selectedTopping);
						toRemove = false;

					}

					editSize(order.Order.getLast(), size);
					added = true;
					return added;
				}
			}

		}

		if (added == false) {
			added = true;
			createOrder(order);
			return added;
		}

		return added;

	}
	/**
	 * Remove pizza from order
	 *
	 */
	public boolean removeOrder(Order order, LinkedList<Order> StoreOrders) {

		boolean cancelled = false;

				 for (Order element : StoreOrders) {
				if (Order.getPhone().equals(Order.getPhone())){
						//.getFirst().getPhone())) {
					
					
					StoreOrders.remove(element);
					
					cancelled = true;
				}

		}

		return cancelled;
	}
	
	/**
	 * Remove pizza from order
	 *
	 */
	public boolean removePizzaFromOrder(Order order, Pizza pizza) {

		boolean cancelled = false;
		
		
		 for (Pizza element : order.Order) {
				if (element.equals(pizza)){
					order.Order.remove(pizza);
				}
					
					cancelled = true;
				}

		return cancelled;
	}
	
	/**
	 * Create order
	 *
	 */
	private void createOrder(Order order) {

		LinkedList<Pizza> CustomerOrder = new LinkedList<Pizza>();
		// ArrayList<Topping> toppings = null;
		Size size = Size.small;
		String flavor = "";

		// get gui to see what customer wants and modify topping, size and flavor

		CustomerOrder.add(PizzaMaker.createPizza(flavor));

		boolean toAdd = false;
		boolean toRemove = false;
		Topping selectedTopping = null;

		if (toAdd) {

			addTopping(CustomerOrder.getLast(), selectedTopping);
			toAdd = false;

		}

		if (toRemove) {

			removeTopping(CustomerOrder.getLast(), selectedTopping);
			toRemove = false;

		}

		// editToppings(CustomerOrder.getLast(), toppings);
		editSize(CustomerOrder.getLast(), size);

		// get gui to see what if add pizza to order

		boolean continueOrder = true;

		while (continueOrder) {

			if (continueOrder) {
				CustomerOrder.add(PizzaMaker.createPizza(flavor));

				// editToppings(CustomerOrder.getLast(), toppings);

				if (toAdd) {

					addTopping(CustomerOrder.getLast(), selectedTopping);
					toAdd = false;

				}

				if (toRemove) {

					removeTopping(CustomerOrder.getLast(), selectedTopping);
					toRemove = false;

				}

				editSize(CustomerOrder.getLast(), size);
			}
		}

		;
	}

	/*
	 * 
	 * private void editToppings(Pizza pizza, ArrayList<Topping> toppings) {
	 * 
	 * if (toppings.size() > 6) return; // give error in gui
	 * 
	 * for (int i = 0; i < toppings.size(); i++)
	 * 
	 * pizza.toppings.set(i, toppings.get(i)); }
	 * 
	 */
	/**
	 * Add topping to pizza
	 *
	 */
	private void addTopping(Pizza pizza, Topping topping2add) {

		pizza.toppings.add(topping2add);

	}

	/**
	 * Remove topping from pizza
	 *
	 */
	private void removeTopping(Pizza pizza, Topping topping2remove) {

		pizza.toppings.remove(topping2remove);

	}

	private void editSize(Pizza pizza, Size size) {
		pizza.size = size;

	}
	/**
	 * Export order to text file.
	 *
	 */
	public void export(LinkedList<Order> storeorders) throws IOException {
		int i = 0;
		int k = 0;
		String phone;
		Pizza currentPizza;
		double orderTotal;

		 FileWriter myWriter = new FileWriter("StoreOrders.txt");
		
		while (i < storeorders.size()) {

			storeorders.get(i);
			phone = Order.getPhone();
			  myWriter.write("Order: "+ phone);
			  myWriter.write("\n");
			// output phone

			while (k < storeorders.get(i).Order.size()) {

				currentPizza = storeorders.get(i).Order.get(k);
				 myWriter.write(currentPizza.toString());
				 myWriter.write("\n");
				 
				 int t=0;
				 while(currentPizza.toppings.get(t)!=null) {
					 myWriter.write(currentPizza.toppings.get(t).name());
					 myWriter.write("\n");
				 }
				// output pizza w toppings

			}

			orderTotal = getTotalAfterTax(getTotalOrder(storeorders.get(i).Order));
			  myWriter.write(String.format("Order Total: %.2f", orderTotal));
			  myWriter.write("\n");
			// output order total
		}

	}
	/**
	 * Get the total price of order
	 *
	 */
	public double getTotalOrder(LinkedList<Pizza> customerOrder) {

		int i = 0;
		double total = 0;

		while (i < customerOrder.size()) {

			total = total + customerOrder.get(i).price();
			i++;
		}

		return total;
	}

	/*
	 * public double getTotalAllOrders(LinkedList<Order> storeorders) { int i = 0;
	 * int k = 0; double total = 0;
	 * 
	 * while (i < storeorders.size()) {
	 * 
	 * while (k < storeorders.get(i).Order.size()) {
	 * 
	 * // if(storeorders.get(i).Order.get(k) instanceof Pepperoni) { total = total +
	 * storeorders.get(i).Order.get(k).price(); k++; } k = 0; i++; } return total; }
	 * 
	 */

	public double getTax(double total) {
		return total * 0.06625;
	}

	public double getTotalAfterTax(double total) {
		return total * 0.06625 + total;
	}

}
