package dad.javafx.holamundo.fxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private HolaMundoFXMLController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new HolaMundoFXMLController();
		
		Scene scene = new Scene(controller.getView(), 320, 200);
		primaryStage.setTitle("Hola Mundo FXML");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
