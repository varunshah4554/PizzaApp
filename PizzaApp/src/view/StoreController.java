package view;
import java.io.FileWriter;
/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
/**
 * Controller for Store Orders
 *
 */
public class StoreController implements Initializable{
	
	@FXML
	ComboBox<String> phoneoption;
	@FXML
	ListView<String> Pizzas;
	@FXML
	TextField ordertotal;
	ObservableList<String> pizza = FXCollections.observableArrayList("medium pepperoni pizza with mushrooms and pepperoni", "large hawaiian pizza with ham and pineapple");
	ObservableList<String> numbers = FXCollections.observableArrayList("1111111111", "2222222222");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Pizzas.setItems(pizza);
		phoneoption.setItems(numbers);
		phoneoption.getSelectionModel().selectFirst();
		ordertotal.setText("29.33");
	}
	public void handleExport(ActionEvent e) throws IOException{
		PrintWriter writer = new PrintWriter("src/StoreOrders.txt", "UTF-8");
		writer.println("Phone Number: 1111111111\nmedium pepperoni pizza with mushrooms and pepperoni\nlarge hawaiian pizza with ham and pineapple\nOrder Total: 29.33\n");
		writer.println("Phone Number: 2222222222\nlarge pepperoni pizza with pepperoni\", \"small hawaiian pizza with ham and pepperoni\nOrder Total: 25.57\n");
		writer.close();
		ordertotal.clear();
		Pizzas.getItems().clear();
		phoneoption.getItems().clear();
		Alert confirmation = new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("Store Orders Exported");
		confirmation.setContentText("Store Orders Have Been Exported!");
		confirmation.show();
	}
	public void handleCancel(ActionEvent e) throws IOException{
		ordertotal.clear();
		Pizzas.getItems().clear();
		phoneoption.getItems().clear();
		Alert confirmation = new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("Store Orders Cancelled");
		confirmation.setContentText("Store Orders Have Been Cancelled!");
		confirmation.show();
	}
	public void comboChanged(ActionEvent e) throws IOException {
		if(phoneoption.getValue() == "1111111111") {
			Pizzas.getItems().clear();
			Pizzas.getItems().addAll("medium pepperoni pizza with mushrooms and pepperoni", "large hawaiian pizza with ham and pineapple");
			ordertotal.setText("29.33");
		}
		else if (phoneoption.getValue() == "2222222222") {
			Pizzas.getItems().clear();
			Pizzas.getItems().addAll("large pepperoni pizza with pepperoni", "small hawaiian pizza with ham and pepperoni");
			ordertotal.setText("25.57");
		}
	}
}

