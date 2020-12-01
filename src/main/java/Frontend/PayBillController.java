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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PayBillController implements Initializable {
	
	
	@FXML
	private ComboBox<String> combobox1;
	@FXML
	private ComboBox<String> combobox2;
	@FXML
	private ComboBox<String> combobox3;
	@FXML
	private Label lb1;
	@FXML
	private Label lb2;
	@FXML
	private TextField cv;
	@FXML
	private TextField cardno;
	@FXML
	private TextField amount;
	@FXML
	private TextField meterID;
	@FXML
	private Label userLabel;
	@FXML
	private Label statlabel;

	
    ObservableList<String> list1 = FXCollections.observableArrayList("VISA", "DEBIT", "CREDIT");
    ObservableList<String> list2 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
    ObservableList<String> list3 = FXCollections.observableArrayList("2020", "2021", "2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034");
    
    public void GetAmount(String ID, String user) throws ClassNotFoundException, SQLException {
		
    	int mid = Integer.parseInt(ID);
    	double value = getBillAmount(mid,user);
		lb1.setText(Double.toString(value));
		userLabel.setText(user);
		meterID.setText(ID);

   }
    
    public void exxit(ActionEvent event) {
		System.exit(0);	
		}
	
   public void dashboad(ActionEvent event) {
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
	
   public void login(ActionEvent event) {
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
   
   public void submit(ActionEvent event) throws ClassNotFoundException, SQLException {

		if(cv.getText().trim().isEmpty()||meterID.getText().trim().isEmpty()||cardno.getText().trim().isEmpty()|| amount.getText().trim().isEmpty()) {
			lb2.setStyle
			(
				 "-fx-background-color: #ffb3b3;"
				+ "-fx-text-fill: red;"
			);
			lb2.setText("INVALID ENTRIES"); 
			
		}else {
			userPanelDAO.newPayments(Integer.parseInt(meterID.getText()), Double.parseDouble(amount.getText()));
			lb2.setStyle
			(
					
					 "-fx-background-color: #1aff1a;"
					+ "-fx-text-fill: black;"
			);
		lb2.setText("AMOUNT PAID");
		statlabel.setStyle
		(
				
				 "-fx-background-color: #ccffff;"
				+ "-fx-text-fill: blue;"
		);
	statlabel.setText("The Amount will be updated when admin accepts your payment");
		
		}	
	}
   
   public double getBillAmount(int meterId , String username) throws ClassNotFoundException, SQLException {
		userPanelDAO up = new userPanelDAO();
		if(up.checkMeterExist(username)) {
			double value = up.getBillAmount(meterId);
			return value;
			
		}else {
			return -1;
		}	
	  }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		combobox1.setItems(list1);
		combobox2.setItems(list2);
		combobox3.setItems(list3);
	}
}

/*   String MeterID = meterID.getText();
     String Amount = amount.getText();  */
