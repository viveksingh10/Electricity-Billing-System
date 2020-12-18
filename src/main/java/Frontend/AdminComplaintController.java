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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AdminComplaintController implements Initializable{

	    @FXML
	    private TextField meterId;

	    @FXML
	    private TextArea remark;

	    @FXML
	    private TextField type;

	    @FXML
	    private TableView<complaint> table_complaint;

	    @FXML
	    private TableColumn<complaint, Integer> col_meterId;

	    @FXML
	    private TableColumn<complaint, String> col_type;

	    @FXML
	    private TableColumn<complaint, String> col_statment;

	    @FXML
	    private TableColumn<complaint, String> col_status;

	    @FXML
	    private Label statuslbl;
	    
	    @FXML
	    private Label adminLabel;
	    
	    public void GetAdmin(String admin) {

			adminLabel.setText(admin);

	   }
	    
	    ObservableList<complaint> listM;
	    

	    int index = -1;
	    
	    Connection conn = null;
	    ResultSet rs = null;
	    PreparedStatement ps = null;
	    Statement stmt;
	    
	    
	    public void getSelected(MouseEvent event) {
	    	index = table_complaint.getSelectionModel().getSelectedIndex();
	    	if(index <= -1) {
	    		return;
	    	}
	    	meterId.setText(col_meterId.getCellData(index).toString());
	    	type.setText(col_type.getCellData(index).toString());
	    	remark.setText(col_statment.getCellData(index).toString());
	    	statuslbl.setStyle
			(
				 "-fx-background-color:  #6699ff;"
			);
	    	statuslbl.setText("One query selected");

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
	    void delete(ActionEvent event) throws ClassNotFoundException {
	    	try {
	    		
	    		if(col_status.getCellData(index).toString().equals("Solved") && meterId.getText()!="") {
	    			conn = connection.createConnection();
				ps = conn.prepareStatement("delete from feedback where meterId = ? and remark = ? ");
				ps.setInt(1, col_meterId.getCellData(index));
				ps.setString(2, col_statment.getCellData(index));
				ps.executeUpdate();
				statuslbl.setStyle
				(
					 "-fx-background-color:  #6699ff;"
				);
				statuslbl.setText("Deleted");
				
				Update();
				
				type.setText("");
				remark.setText("");
				meterId.setText("");
				index = -1;
		
	    		}
	    		else {
	    			statuslbl.setStyle
					(
						 "-fx-background-color:  #ffb3b3 ;"
						 + "-fx-text-fill: red;"
					);
	    			statuslbl.setText("Solve the problem first");}
				conn.close();
			} catch (Exception e) {
				statuslbl.setStyle
				(
					 "-fx-background-color:  #ffb3b3;"
					 + "-fx-text-fill: red;"
				);
				statuslbl.setText("Select a column first");
			}

	    }
	    
	    public void Update() throws ClassNotFoundException, SQLException {
	    	col_meterId.setCellValueFactory(new PropertyValueFactory<complaint, Integer>("meterId"));
			col_type.setCellValueFactory(new PropertyValueFactory<complaint, String>("type"));
			col_statment.setCellValueFactory(new PropertyValueFactory<complaint, String>("remark")); 
			col_status.setCellValueFactory(new PropertyValueFactory<complaint, String>("status"));
			
			listM = adminPanelDao.getDatacomplaints();
			table_complaint.setItems(listM);
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

	    @FXML
	    void update(ActionEvent event) {

	    	try {
	    		
	    		if(!col_status.getCellData(index).toString().equals("Solved") && meterId.getText()!=type.getText()) {
	    			conn = connection.createConnection();
	    			stmt = conn.createStatement();
	    			stmt.execute("update feedback set status = 'Solved' where meterId = " + col_meterId.getCellData(index) +" and remark = '"+ col_statment.getCellData(index)+"'");
	    			statuslbl.setStyle
					(
						 "-fx-background-color:  #6699ff;"
					);
	    			statuslbl.setText("Solved");
	    			
	    			Update();
	    			
	    			type.setText("");
	    			remark.setText("");
	    			meterId.setText("");
	    			index = -1;
	    			
	    		}else {
	    			statuslbl.setStyle
					(
						 "-fx-background-color:   #ffb3b3;"
						 + "-fx-text-fill: red;"
					);
	    			statuslbl.setText("Already Solved");
	    		}
	    		conn.close();
	    	}catch(Exception e) {
	    		statuslbl.setStyle
				(
					 "-fx-background-color:   #ffb3b3;"
					 + "-fx-text-fill: red;"
				);
	    		statuslbl.setText("Select a column first");
	    	}
	    }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
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

