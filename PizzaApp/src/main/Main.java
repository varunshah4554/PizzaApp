/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.MainController;
/**
 *  This is the driver class to invoke the launch() method. 
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/MainView.fxml")); 
		AnchorPane root = (AnchorPane) loader.load();
		MainController controller = loader.getController();
		controller.start(primaryStage);
		Scene scene = new Scene(root);
		primaryStage.setTitle("RU Pizza Store Front");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	/**
	 *  @param args launch()
	 *
	 */
	public static void main(String[] args) {
		launch(args);
	}

}