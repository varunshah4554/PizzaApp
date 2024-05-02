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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
/**
 * Controller for the Customization of Pizzas GUI
 *
 */
public class CustomizationController implements Initializable{
	
	@FXML
	ImageView pepperonipizza, hawaiianpizza, deluxepizza;
	@FXML
	Text Pepperoni, Hawaiian, Deluxe;
	@FXML
	ComboBox<String> sizeoption;
	@FXML
	ListView<String> additionaltoppings, selectedtoppings;
	@FXML
	TextArea prices;
double pepperoni = 8.99, hawaiian = 10.99, deluxe = 12.99, newprice;
double currentprices;
int checksize;
String currentprice;
String pepperonip = String.valueOf(pepperoni);
String hawaiianh = String.valueOf(hawaiian);
String deluxed = String.valueOf(deluxe);

	ObservableList<String> additionaltoppingss = FXCollections.observableArrayList("pepperoni", "pineapple", "ham", "olives", "pepper", "mushroom", "onion", "sausage");
	ObservableList<String> selectedtoppingss = FXCollections.observableArrayList();
	ObservableList<String> sizes = FXCollections.observableArrayList("small", "medium", "large");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sizeoption.setItems(sizes);
		sizeoption.getSelectionModel().selectFirst();
		additionaltoppings.setItems(additionaltoppingss);
		selectedtoppings.setItems(selectedtoppingss);
	}
	public void showInformationPepperoni() {
		pepperonipizza.setOpacity(1.0);
		deluxepizza.setOpacity(0.0);
		hawaiianpizza.setOpacity(0.0);
		Hawaiian.setOpacity(0.0);
		Deluxe.setOpacity(0.0);
		prices.setText(pepperonip);
		additionaltoppings.getItems().removeAll("pepperoni");
		selectedtoppings.getItems().addAll("pepperoni");
	}
	public void showInformationHawaiian() {
		hawaiianpizza.setOpacity(1.0);
		deluxepizza.setOpacity(0.0);
		pepperonipizza.setOpacity(0.0);
		Pepperoni.setOpacity(0.0);
		Deluxe.setOpacity(0.0);
		prices.setText(hawaiianh);
		additionaltoppings.getItems().removeAll("ham", "pineapple");
		selectedtoppings.getItems().addAll("ham", "pineapple");
	}
	public void showInformationDeluxe() {
		deluxepizza.setOpacity(1.0);
		pepperonipizza.setOpacity(0.0);
		hawaiianpizza.setOpacity(0.0);
		Hawaiian.setOpacity(0.0);
		Pepperoni.setOpacity(0.0);
		prices.setText(deluxed);
		additionaltoppings.getItems().removeAll("pepperoni", "olives", "pepper", "mushroom", "onion");
		selectedtoppings.getItems().addAll("pepperoni", "olives", "pepper", "mushroom", "onion");
	}
	public void handleAddToOrder(ActionEvent e) throws IOException {
		Alert confirmation = new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("Added To Oder");
		confirmation.setContentText("Pizza Has Been Added To Order!");
		confirmation.show();
		sizeoption.getItems();
	}
public void handleAdd(ActionEvent e) throws IOException {
		int checksizee = selectedtoppings.getItems().size();
		String toppings = additionaltoppings.getSelectionModel().getSelectedItem();
		if (checksizee == 7) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Toppings Error");
			error.setContentText("Maximum 7 Toppings");
			error.show();
		}
		else if(toppings == null) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Toppings Error");
			error.setContentText("Must Select A Topping To Add");
			error.show();
		}
		else {
		String topping = additionaltoppings.getSelectionModel().getSelectedItem();
		additionaltoppings.getItems().removeAll(topping);
		selectedtoppings.getItems().addAll(topping);
		currentprice = prices.getText();
		currentprices = Double.valueOf(currentprice);
		checksize  = additionaltoppings.getItems().size();
		if (pepperonipizza.getOpacity() == 1.0 && sizeoption.getValue() == "small" && checksize == 7) {
			prices.setText(pepperonip);
		}
		else if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "medium" && checksize == 7) {
			prices.setText("10.99");
		}
		else if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "large" && checksize == 7) {
			prices.setText("12.99");
		}
		else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "small" && checksize >= 6) {
			prices.setText(hawaiianh);
		}
		else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "medium" && checksize >= 6) {
			prices.setText("12.99");
		}
		else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "large" && checksize >= 6) {
			prices.setText("14.99");
		}
		else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "small" && checksize >= 3) {
			prices.setText(deluxed);
		}
		else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "medium" && checksize >= 3) {
			prices.setText("14.99");
		}
		else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "large" && checksize >= 3) {
			prices.setText("16.99");
		}
		else {
			newprice = currentprices + 1.49;
			String newprices = String.valueOf(newprice);
			prices.setText(newprices);
		}
		}
	}
public void handleRemove(ActionEvent e) throws IOException {
	String toppings = selectedtoppings.getSelectionModel().getSelectedItem();
	if(toppings == null) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Toppings Error");
		error.setContentText("Must Select A Topping To Remove");
		error.show();
	}
	else {
	String topping = selectedtoppings.getSelectionModel().getSelectedItem();
	selectedtoppings.getItems().removeAll(topping);
	additionaltoppings.getItems().addAll(topping);
	currentprice = prices.getText();
	currentprices = Double.valueOf(currentprice);
	checksize  = selectedtoppings.getItems().size();
	if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "small" && checksize == 0) {
		prices.setText(pepperonip);
	}
	else if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "medium" && checksize == 0) {
		prices.setText("10.99");
	}
	else if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "large" && checksize == 0) {
		prices.setText("12.99");
	}
	else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "small" && checksize <= 1) {
		prices.setText(hawaiianh);
	}
	else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "medium" && checksize <= 1) {
		prices.setText("12.99");
	}
	else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "large" && checksize <= 1) {
		prices.setText("14.99");
	}
	else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "small" && checksize <= 4) {
		prices.setText(deluxed);
	}
	else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "medium" && checksize <= 4) {
		prices.setText("14.99");
	}
	else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "large" && checksize <= 4) {
		prices.setText("16.99");
	}
	else {
		newprice = currentprices - 1.49;
		String newprices = String.valueOf(newprice);
		prices.setText(newprices);
	}
	}
}
public void comboChanged(ActionEvent e) throws IOException {
	if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "small") {
		additionaltoppings.setItems(additionaltoppingss);
		selectedtoppings.setItems(selectedtoppingss);
		prices.setText(pepperonip);
	}
	else if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "medium") {
		prices.setText("10.99");
	}
	else if (pepperonipizza.getOpacity()==1.0 && sizeoption.getValue() == "large") {
		prices.setText("12.99");
	}
	else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "small") {
		prices.setText(hawaiianh);
	}
	else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "medium") {
		prices.setText("12.99");
	}
	else if (hawaiianpizza.getOpacity()==1.0 && sizeoption.getValue() == "large") {
		prices.setText("14.99");
	}
	else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "small") {
		prices.setText(deluxed);
	}
	else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "medium") {
		prices.setText("14.99");
	}
	else if (deluxepizza.getOpacity()==1.0 && sizeoption.getValue() == "large") {
		prices.setText("16.99");
	}
}
}