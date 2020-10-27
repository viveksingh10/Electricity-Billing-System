package Frontend;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NewUserController implements Initializable {
	
	@FXML
	private Label mylbl;
	@FXML
	private TextField uname;
	@FXML
	private TextField mid;
	@FXML
	private TextField fname;
	@FXML
	private TextField lname;
	@FXML
	private TextField ano;
	@FXML
	private PasswordField pass;
	@FXML
    private ComboBox<String> combobox;
	@FXML
	private Button btn1;
	@FXML
	private ListView<String> listview;
	
	public void ButtonAction(ActionEvent enent) {
		FileChooser fc= new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile!= null) {
			listview.getItems().add(selectedFile.getName());
		} else {
			mylbl.setStyle
			(
				 "-fx-background-color: white;"
				+ "-fx-text-fill: red;"
			);
			mylbl.setText("File is not valid");
		}
	}
	
    
    ObservableList<String> list = FXCollections.observableArrayList("MALE", "FEMALE", "OTHERS");

	

	public void submit(ActionEvent event) {

		   if(  lname.getText().trim().isEmpty() || fname.getText().trim().isEmpty() ||
				uname.getText().trim().isEmpty() || pass.getText().trim().isEmpty() || 
				mid.getText().trim().isEmpty() || combobox.getValue().trim().isEmpty() || listview.getItems().isEmpty() ) {
			mylbl.setStyle
			(
				 "-fx-background-color: white;"
				+ "-fx-text-fill: red;"
			);
			mylbl.setText("Enter all fields correctly");
			
		}else {
			mylbl.setStyle
			(
					
					 "-fx-background-color: #1aff1a;"
					+ "-fx-text-fill: black;"
			);
		mylbl.setText("Details submitted, you can login now");
		
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
			primaryStage.show();
		
		} catch (Exception e) {
			
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		combobox.setItems(list);
		
	}
}