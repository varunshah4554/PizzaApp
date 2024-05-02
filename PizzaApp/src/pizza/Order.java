package pizza;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
import java.util.Iterator;
import java.util.LinkedList;

/**
 * An instance of this class has a unique phone number and keeps the list of
 * instances of Pizza class.
 */
public class Order{

	
	private static String phone;
	
	LinkedList <Pizza> Order = new LinkedList <Pizza>();
	


	public static String getPhone() {
		return phone;
	}

	/**
	 * find size of pizza order
	 *
	 */
	public int size() {
		
		int size=0;
		
		Iterator<Pizza> iterator = Order.iterator();
		while (iterator.hasNext()) {
	
		size++;
		}
		
		return size;
	}


	
	
	
}
