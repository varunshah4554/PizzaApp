/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * Controls the GUI for this project. Inputs and outputs for the GUI are managed here.
 */
public class MainController {
	@FXML
	Button addButton;
	@FXML
	TextField phonenumber;
	@FXML
	TextArea textArea;


	public void start(Stage primaryStage) {
		primaryStage.setOnCloseRequest(event -> {
		});

	}
	public void handlePepperoni(ActionEvent e) throws IOException{
		if (phonenumber.getText().matches(".*[a-zA-Z]+.*")) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain numerical values");
			error.show();
		}
		else if(phonenumber.getText().matches(".*[0-9]+.*") && phonenumber.getText().length() == 10){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Customization.fxml"));
			Parent root = loader.load();
			CustomizationController customcontroller = loader.getController();
			customcontroller.showInformationPepperoni();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Order Pizza");
			stage.show();
		}
		else {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain 10 numerical values");
			error.show();
		}
	}
	public void handleHawaiian(ActionEvent e) throws IOException {
		if (phonenumber.getText().matches(".*[a-zA-Z]+.*")) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain numerical values");
			error.show();
		}
		else if(phonenumber.getText().matches(".*[0-9]+.*") && phonenumber.getText().length() == 10){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Customization.fxml"));
			Parent root = loader.load();
			CustomizationController customcontroller = loader.getController();
			customcontroller.showInformationHawaiian();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Order Pizza");
			stage.show();
		}
		else {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain 10 numerical values");
			error.show();
		}

	}

	public void handleDeluxe(ActionEvent e) throws IOException {
		if (phonenumber.getText().matches(".*[a-zA-Z]+.*")) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain numerical values");
			error.show();
		}
		else if(phonenumber.getText().matches(".*[0-9]+.*") && phonenumber.getText().length() == 10){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Customization.fxml"));
			Parent root = loader.load();
			CustomizationController customcontroller = loader.getController();
			customcontroller.showInformationDeluxe();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Order Pizza");
			stage.show();
		}
		else {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain 10 numerical values");
			error.show();
		}
	}

	public void handleStore(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Store.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Store Order");
		stage.show();
	}

	public void handleCurrent(ActionEvent e) throws IOException {
		if (phonenumber.getText().matches(".*[a-zA-Z]+.*")) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain numerical values");
			error.show();
		}
		else if(phonenumber.getText().matches(".*[0-9]+.*") && phonenumber.getText().length() == 10){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Order.fxml"));
			Parent root = loader.load();
			OrderController ordercontroller = loader.getController();
			ordercontroller.showInformation(phonenumber.getText());
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Current Order");
			stage.show();
		}
		else {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Phone Error");
			error.setContentText("Phone Number must only contain 10 numerical values");
			error.show();
		}
	}

}
