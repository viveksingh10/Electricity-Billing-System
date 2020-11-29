package DB;
import java.sql.*;
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
}


//}
//
//package DB;
//import java.sql.*;
//public class connection {
//static Connection con;
//Statement st;
//static String url="jdbc:mysql://localhost:3306/ElectricityBillingSystem";
//static String username="vatsuvaksi";
//static String password="";
//public static Connection createConnection() throws ClassNotFoundException, SQLException {
//	Class.forName("com.mysql.jdbc.Driver");
//	con =DriverManager.getConnection(url, username, password);
//	return con;
//}
//}
