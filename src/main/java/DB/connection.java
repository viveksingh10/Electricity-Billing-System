package DB;
import java.sql.*;
import Frontend.complaint;
import Frontend.payments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class connection {
static Connection con;

public static Connection createConnection() throws ClassNotFoundException, SQLException {
	try {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:tabel");
	//	JOptionPane.showMessageDialog(null, "database connected");
		return con;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Database not connected error-dbconnect");
		return null;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("database class not found error - dbconnect");
		return null;
	}
}


public static ObservableList<complaint>getDatacomplaints() throws ClassNotFoundException, SQLException{
	con= connection.createConnection();
	ObservableList<complaint> list = FXCollections.observableArrayList();
	try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from feedback");
		while(rs.next()) {
			list.add(new complaint(rs.getInt("meterId"), rs.getString("type"), rs.getString("remark"), rs.getString("status")));
		}
		con.close();
	}catch(Exception e) {
	}
	return list;
	
}


public static ObservableList<payments>getDatapayments() throws ClassNotFoundException, SQLException{
	con= connection.createConnection();
	ObservableList<payments> list = FXCollections.observableArrayList();
	try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from newPayments");
		while(rs.next()) {
			list.add(new payments(rs.getInt("meterId"), rs.getInt("amount")));
		}
		con.close();
	}catch(Exception e) {
	}
	return list;
	
}

}
