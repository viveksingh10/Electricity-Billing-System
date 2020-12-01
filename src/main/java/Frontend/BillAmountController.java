package Frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import DB.adminPanelDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BillAmountController implements Initializable {

    @FXML
    private TableView<amount> table_pendingbill;

    @FXML
    private TableColumn<amount, Integer> col_meterId;

    @FXML
    private TableColumn<amount, Double> col_amount;

    @FXML
    private Label statuslbl;

    @FXML
    private TextField amount;

    @FXML
    private TextField meterId;
    
    @FXML
    private Label adminLabel;
    
    public void GetAdmin(String admin) {

		adminLabel.setText(admin);

   }

    ObservableList<amount> listM;
    

    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Statement stmt;
    
    @FXML
    void isSelected(MouseEvent event) {
	    	index = table_pendingbill.getSelectionModel().getSelectedIndex();
	    	if(index <= -1) {
	    		return;
	    	}
	    	meterId.setText(col_meterId.getCellData(index).toString());
	    	amount.setText(col_amount.getCellData(index).toString());
	    	statuslbl.setText("One meterID selected");
	  
    }
    
    @FXML
    void dashboad(ActionEvent event) throws IOException {
 
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/Frontend/Admin.fxml").openStream());
		Scene scene = new Scene(root);
		AdminController adminController = (AdminController)loader.getController();
	    adminController.GetAdmin(adminLabel.getText());
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
    }

    @FXML
    void exxit(ActionEvent event) {

    	System.exit(0);	
    }

    @FXML
    void logout(ActionEvent event) throws IOException {

    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/Frontend/Login.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
    }
    
    public void Update() throws ClassNotFoundException, SQLException {
    	col_meterId.setCellValueFactory(new PropertyValueFactory<amount, Integer>("meterId"));
		col_amount.setCellValueFactory(new PropertyValueFactory<amount, Double>("amount"));
		
		listM = adminPanelDao.getDatapendingbill();
		table_pendingbill.setItems(listM);
    }

    @FXML
    void notify(ActionEvent event) {
      if(meterId.getText().trim().isEmpty() || amount.getText().trim().isEmpty())
         statuslbl.setText("Select one meterId first");
      else
    	  statuslbl.setText("Email sent to the user.");
          meterId.setText("");
          amount.setText("");
      
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Update();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
