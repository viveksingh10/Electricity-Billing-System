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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	 
	
	    @FXML
	    private Label isConnected;
	    
	    @FXML
	    private TextField txtusername;
	    
	    @FXML
	    private TextField txtpassword;
	    
	    @FXML
	    private ComboBox<String> combobox;
	    
	    ObservableList<String> list = FXCollections.observableArrayList("ADMIN", "USER");
	
   public void exxit(ActionEvent event) {
		System.exit(0);	
		}
	
   public void NewUser(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/NewUser.fxml").openStream());
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle(" Welcome to the Company");
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
	public void Error(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/Error.fxml").openStream());
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle(" Forgot Password ");
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}

   public void Login (ActionEvent event) throws Throwable {
			
			if(combobox.getValue()=="USER") {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/User.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	 		
			
			
		}else if(combobox.getValue()=="ADMIN") {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/Admin.fxml").openStream());
			//AdminController adminController = (AdminController)loader.getController();
			//adminController.GetAdmin(txtusername.getText());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
   }		

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		combobox.setItems(list);
	}

}
