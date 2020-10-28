package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con=connection.createConnection();
		String sql = "Insert into user(username,password) values (?,?)";
		PreparedStatement pr=con.prepareStatement(sql);
		pr.setString(1, "henlo");
		pr.setString(2,"henloo");
		pr.executeUpdate();
		
	}

}
