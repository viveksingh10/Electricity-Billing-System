package Frontend;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ErrorController implements Initializable {
	
	@FXML
	private Label mylbl;
	@FXML
	private TextField uname;
	@FXML
	private TextField mid;
	@FXML
	private TextField ano;

	

	public void submit(ActionEvent event) {

		if(uname.getText().trim().isEmpty() || mid.getText().trim().isEmpty() || ano.getText().trim().isEmpty()) {
			mylbl.setStyle
			(
				 "-fx-background-color: white;"
				+ "-fx-text-fill: red;"
			);
			mylbl.setText("Invalid Details");
			
		}else {
			mylbl.setStyle
			(
					
					 "-fx-background-color: #1aff1a;"
					+ "-fx-text-fill: black;"
			);
		mylbl.setText("Your password reset request is registered, will send you password reset link on your mail");
		
		}
		
		
	}
	
	public void exxit(ActionEvent event) {
	System.exit(0);
		
	}
	
	
	public void out(ActionEvent event) {
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/Login.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle(" Login ");
			primaryStage.show();
		
		} catch (Exception e) {
			
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
