package Frontend;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import DB.userPanelDAO;
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
import javafx.stage.StageStyle;

public class UserComplaintController implements Initializable {
	
	@FXML
    private ChoiceBox<String> combobox;
	@FXML
	private Label lb1;
	@FXML
	private TextField id;
	@FXML
	private TextArea tarea;
	@FXML
	private Label userLabel;
	

	public void GetUser(String user, String meterid) {

	  userLabel.setText(user);
	  id.setText(meterid);

	}
	
	ObservableList<String> list = FXCollections.observableArrayList("Complaint", "Change some Detials", "Feedback", "Suggestion", "Other");
	
	public void out(ActionEvent event) {
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/Login.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
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
			UserController userController = (UserController)loader.getController();
		    userController.GetUser(userLabel.getText());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
	public void submit(ActionEvent event) throws NumberFormatException, ClassNotFoundException, SQLException {
		if(combobox.getValue()==null || id.getText().trim().isEmpty() || tarea.getText().trim().isEmpty()) {
			lb1.setStyle
			(
				 "-fx-background-color: #ffb3b3;"
				+ "-fx-text-fill: red;"
			);
			lb1.setText("ENTER ALL DETAILS");
			
		}else {
			userPanelDAO.userComplaint(Integer.parseInt(id.getText()), combobox.getValue().toString(), tarea.getText());
			lb1.setStyle
			(
					
					 "-fx-background-color: #1aff1a;"
					+ "-fx-text-fill: black;"
			);
		lb1.setText("DETAILS SUBMITTED");
		
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		combobox.setItems(list);
		
	}

}
