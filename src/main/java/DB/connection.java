package DB;
import java.sql.*;
public class connection {
static Connection con;
Statement st;
static String url="jdbc:mysql://localhost:3306/dummy_db2";
static String username="";
static String password="";
public static Connection createConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	con =DriverManager.getConnection(url, username, password);
	return con;
}
}