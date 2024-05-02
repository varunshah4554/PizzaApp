package view;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
/**
 * Controller for Current Orders
 *
 */
public class OrderController implements Initializable{
	@FXML
	TextField pnumber, subtotal, salesTax, orderTotal;
	@FXML
	ListView<String> PizzaList;
	ObservableList<String> pizza = FXCollections.observableArrayList("medium pepperoni pizza with mushrooms and pepperoni");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PizzaList.setItems(pizza);
		subtotal.setText("12.48");
		salesTax.setText("0.87");
		orderTotal.setText("13.35");
	}
	public void showInformation(String number) {
		pnumber.setText(number);
		
	}
public void handleRemove(ActionEvent e) throws IOException {
	String pizzas = PizzaList.getSelectionModel().getSelectedItem();
		if (pizzas == null) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Remove Error");
			error.setContentText("Must Select A Pizza");
			error.show();
		}
		else {
			PizzaList.getItems().clear();
			subtotal.clear();
			salesTax.clear();
			orderTotal.clear();
		}
	}
public void handlePlace(ActionEvent e) throws IOException {
	Alert confirmation = new Alert(AlertType.CONFIRMATION);
	confirmation.setTitle("Order Placed");
	confirmation.setContentText("Order Has Been Placed!");
	confirmation.show();
	PizzaList.getItems().clear();
	subtotal.clear();
	salesTax.clear();
	orderTotal.clear();
	pnumber.clear();
}

}
