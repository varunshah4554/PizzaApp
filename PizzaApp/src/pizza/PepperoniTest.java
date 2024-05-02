package pizza;
import static org.junit.Assert.*;
import org.junit.Test;



public class PepperoniTest {
	@Test
	public void Testprice() {
		
		Pizza pizza = new Pepperoni();
		
		// test case #1, a small pepperorni pizza with no added toppings is $8.99
		assertTrue(pizza.price()==8.99);
		
		// test case #2, a medium pepperorni pizza with no added toppings is $10.99
		pizza.size=Size.medium;
		assertFalse(pizza.price()==8.99);
		
		// test case #3, a large pepperorni pizza with no added toppings is $12.99
		pizza.size=Size.large;
		assertTrue(pizza.price()==12.99);
		
		// test case #4, a small pepperorni pizza with pepperoni removed is $8.99
		Pizza pizza2 = new Pepperoni();
		pizza2.toppings.remove(Topping.pepporoni);
		assertTrue(pizza2.price()==8.99);
		
		// test case #4, a small pepperorni pizza with pepperoni and onion toppings is $10.48
		pizza2.toppings.add(Topping.pepporoni);
		pizza2.toppings.add(Topping.onion);
		assertTrue(pizza2.price()==10.48);
		
		// test case #5, a large pepperorni pizza with pepperoni,ham  and onion toppings is $15.97
		pizza2.toppings.add(Topping.ham);
		pizza2.size=Size.large;
		assertTrue(pizza2.price()==15.97);
		
		// test case #6, a medium pepperorni pizza with pepperoni,ham,pineapple  and onion toppings is $15.46
				pizza2.toppings.add(Topping.pineapple);
				pizza2.size=Size.medium;
				assertTrue(pizza2.price()==15.46);
				
				
		// test case #7, a small pepperorni pizza with pepperoni, adding ham and removing ham is $8.99
				Pizza pizza3 = new Pepperoni();	
				pizza3.toppings.add(Topping.ham);
				pizza3.toppings.remove(Topping.ham);
				assertTrue(pizza3.price()==8.99);
		
	}
}