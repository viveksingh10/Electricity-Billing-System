package Frontend;

import java.sql.SQLException;

import DB.userPanelDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserController {
	@FXML
	private Label lb1;
	@FXML
	private Label lb2;
	
	public void GetUser(String User) throws ClassNotFoundException, SQLException {

		lb1.setText(User);
		int value = getMeterId(User);
		lb2.setText(Integer.toString(value));

   }

	public int getMeterId(String username) throws ClassNotFoundException, SQLException {
		userPanelDAO up =new userPanelDAO();
		if(up.checkMeterExist(username)) {
			return up.getMeterId(username);
		}else {
			return -1;
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
			Pane root = loader.load(getClass().getResource("/Frontend/UserComplaint.fxml").openStream());
			Scene scene = new Scene(root);
			UserComplaintController usercomplaintController = (UserComplaintController)loader.getController();
		    usercomplaintController.GetUser(lb1.getText(), lb2.getText());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	public void out2(ActionEvent event) {
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Frontend/PayBill.fxml").openStream());
			PayBillController paybillController = (PayBillController)loader.getController();
			paybillController.GetAmount(lb2.getText(),lb1.getText());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}

}
