package Frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import DB.checkLoginDAO;
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
import javafx.stage.StageStyle;

public class LoginController implements Initializable {
	 
	public checkLoginDAO ck = new checkLoginDAO();
	
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
	
   public void newUser(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/NewUser.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
   public void error(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/Error.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
   public void Login (ActionEvent event) throws Throwable {
	   
	   if(combobox.getValue()=="USER") {
       	
	    	try {
	    		if(ck.checkUser(txtusername.getText(), txtpassword.getText()))
				{
					  ((Node)event.getSource()).getScene().getWindow().hide();
					   Stage primaryStage = new Stage();
					   FXMLLoader loader = new FXMLLoader();
					   Pane root = loader.load(getClass().getResource("/Frontend/User.fxml").openStream());
					   UserController userController = (UserController)loader.getController();
					   userController.GetUser(txtusername.getText());
					   Scene scene = new Scene(root);
					   primaryStage.setScene(scene);
					   primaryStage.initStyle(StageStyle.TRANSPARENT);
					   primaryStage.show();
			   }else {
				   
	    		isConnected.setStyle( "-fx-background-color:  #ffb3b3;"+ "-fx-text-fill: red;");
				isConnected.setText("Invalid Username or pass");
	    	    }
			
            	}catch(SQLException e) {
   		      isConnected.setStyle( "-fx-background-color:  #ffb3b3;"+ "-fx-text-fill: red;");
		          isConnected.setText("Invalid Username and Password");
		          e.printStackTrace();
  	            
             }catch (IOException e) {
		       	e.printStackTrace();
  	           }
      }
		    
	   else if(combobox.getValue()=="ADMIN") {
		        	
		    	try {
		    		if(ck.checkAdmin(txtusername.getText(), txtpassword.getText()))
					{
						  ((Node)event.getSource()).getScene().getWindow().hide();
						   Stage primaryStage = new Stage();
						   FXMLLoader loader = new FXMLLoader();
						   Pane root = loader.load(getClass().getResource("/Frontend/Admin.fxml").openStream());
						   AdminController adminController = (AdminController)loader.getController();
						   adminController.GetAdmin(txtusername.getText());
						   Scene scene = new Scene(root);
						   primaryStage.setScene(scene);
						   primaryStage.initStyle(StageStyle.TRANSPARENT);
						   primaryStage.show();
				   }else {
					   
		    		isConnected.setStyle( "-fx-background-color:  #ffb3b3;"+ "-fx-text-fill: red;");
					isConnected.setText("Invalid Username or pass");
		    	    }
				
	             	}catch(SQLException e) {
	    		      isConnected.setStyle( "-fx-background-color:  #ffb3b3;"+ "-fx-text-fill: red;");
			          isConnected.setText("Invalid Username and Password");
			          e.printStackTrace();
	   	            
	              }catch (IOException e) {
			       	e.printStackTrace();
	   	           }
           }
	   else {
		      isConnected.setStyle( "-fx-background-color:  #ffb3b3;"+ "-fx-text-fill: red;");
	          isConnected.setText("User or Admin? Select Login type");
	   }
   }

	public void initialize(URL arg0, ResourceBundle arg1) {

		combobox.setItems(list);
	}


//
}
