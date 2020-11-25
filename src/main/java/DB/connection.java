package DB;
import java.sql.*;
import Frontend.complaint;
import Frontend.payments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class connection {
static Connection con;
Statement st;
static String url="jdbc:mysql://localhost:3306/";
static String username="";
static String password="";
public static Connection createConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	con =DriverManager.getConnection(url, username, password);
	return con;
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
