package dad.javafx.holamundo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/*
 * Ahora tenemos que implementar esta interface para poder
 * cargar el FXML.
 */
public class HolaMundoFXMLController implements Initializable {

	// model
	
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty saludo = new SimpleStringProperty();
	
	// view, para inyectar los objetos con los "id" en las variables
	
	@FXML
	private VBox view;
	
	@FXML 
	private TextField nameTxt;
	
	@FXML
	private Label saludoLbl;
	
	@FXML
	private Button helloBt;
	
	public HolaMundoFXMLController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HolaMundoView.fxml")); // Buscamos el FXML en recursos
 		loader.setController(this); // Este será nuestro controlador
		loader.load(); // Lo cargamos, lanza IOException
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Es invocado por el load() cuando termina de cargar los recursos
		nombre.bind(nameTxt.textProperty());
		saludoLbl.textProperty().bind(saludo);
	}
	
	public VBox getView() {
		return view;
	}
	
	// Lo incorporamos en el FXML
	@FXML
	private void onSaludarAction(ActionEvent e) {
		saludo.setValue("¡Hola " + nombre.get() + "!");
	}

}
