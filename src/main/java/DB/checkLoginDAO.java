package DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class checkLoginDAO {

	public boolean checkUser(String user, String password) throws ClassNotFoundException, SQLException {
		{
			boolean flag= false;
			Connection con = connection.createConnection();
			String sql = "SELECT * FROM user WHERE username =\"" + user + "\" and password = \"" + password + "\"" ;
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
			flag = true;	
			}
			return flag;
		}

	}
	

	public boolean checkAdmin(String user, String password) throws ClassNotFoundException, SQLException {
		{
			boolean flag= false;
			Connection con = connection.createConnection();
			String sql = "SELECT * FROM admin WHERE username =\"" + user + "\" and password = \"" + password + "\"" ;
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
			flag = true;	
			}
			return flag;
		}
    }
}