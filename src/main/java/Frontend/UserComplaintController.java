package Frontend;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserComplaintController implements Initializable {
	
	@FXML
    private ChoiceBox<String> combobox;
	@FXML
	private Label lb1;
	@FXML
	private TextField id;
	@FXML
	private TextArea tarea;
	
	ObservableList<String> list = FXCollections.observableArrayList("Complaint", "Change some Detials", "Feedback", "Suggestion", "Other");
	
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
	public void out1(ActionEvent event) {
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/User.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle(" USER PANEL ");
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
	public void submit(ActionEvent event) {
		if(combobox.getValue().trim().isEmpty() || id.getText().trim().isEmpty() || tarea.getText().trim().isEmpty()) {
			lb1.setStyle
			(
				 "-fx-background-color: white;"
				+ "-fx-text-fill: red;"
			);
			lb1.setText("Enter all details");
			
		}else {
			lb1.setStyle
			(
					
					 "-fx-background-color: #1aff1a;"
					+ "-fx-text-fill: black;"
			);
		lb1.setText("Submitted");
		
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		combobox.setItems(list);
		
	}

}

/*   String MeterID = id.getText();
     String Type = combobox.getValue();
     String Statment = tarea.getText(); 
     
*/