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
import DB.connection;
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

public class NewPaymentsController implements Initializable{

    @FXML
    private TableView<payments> table_payments;

    @FXML
    private TableColumn<payments, Integer> col_meterId;

    @FXML
    private TableColumn<payments, Double> col_amount;

    @FXML
    private Label statuslbl;

    @FXML
    private TextField meterId;

    @FXML
    private TextField amount;
    
    @FXML
    private Label adminLabel;
    
    public void GetAdmin(String admin) {

		adminLabel.setText(admin);

   }

    ObservableList<payments> listM;
    

    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Statement stmt;
    
    @FXML
    void isSelected(MouseEvent event) {
	    	index = table_payments.getSelectionModel().getSelectedIndex();
	    	if(index <= -1) {
	    		return;
	    	}
	    	meterId.setText(col_meterId.getCellData(index).toString());
	    	amount.setText(col_amount.getCellData(index).toString());
	    	statuslbl.setText("One ID selected");
	    	
	  
    }

    @FXML
    void approve(ActionEvent event) throws ClassNotFoundException {
    	try {
    		if(meterId.getText().trim().isEmpty())
    			statuslbl.setText("Select a query first");
    		adminPanelDao.executingAmount(Integer.parseInt(meterId.getText()));
            conn = connection.createConnection();
			ps = conn.prepareStatement("delete from newPayments where meterId = ? and amount = ? ");
			ps.setInt(1, col_meterId.getCellData(index));
			ps.setDouble(2, col_amount.getCellData(index));
			ps.executeUpdate();
			statuslbl.setText("Approved");
			Update();
		    index=-1;
			amount.setText("");
			meterId.setText("");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			statuslbl.setText("Select a column first");
		}

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
    	col_meterId.setCellValueFactory(new PropertyValueFactory<payments, Integer>("meterId"));
		col_amount.setCellValueFactory(new PropertyValueFactory<payments, Double>("amount"));
		
		listM = adminPanelDao.getDatapayments();
		table_payments.setItems(listM);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Update();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

