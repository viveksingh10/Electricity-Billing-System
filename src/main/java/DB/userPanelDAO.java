package DB;
import java.sql.*;
public class userPanelDAO {
	
	
	public boolean checkMeterExist(String username) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection con = connection.createConnection();
		Statement st = con.createStatement();
		String query ="SELECT * from user where username =\"" + username + "\"";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			flag = true;
		}
		return flag;
	}
public int getMeterId(String username) throws SQLException, ClassNotFoundException {
	Connection con = connection.createConnection();
	Statement st = con.createStatement();
	String query ="SELECT * from user where username =\"" + username + "\"";
	ResultSet rs = st.executeQuery(query);
	int meterId = 0;
	while(rs.next()) {
	 meterId = rs.getInt("meterId");  
	}
	return meterId;
}

public double getBillAmount(int meterID) throws SQLException, ClassNotFoundException {
	double amount = 0.0;
	Connection con = connection.createConnection();
	Statement st = con.createStatement();
	String meterIdinString =String.valueOf(meterID);
	String query ="SELECT * from user where meterId =" + meterIdinString ;
	ResultSet rs = st.executeQuery(query);
	while(rs.next()) {
	 amount = rs.getDouble("billAmount");
	}

	return amount;
	
}
}
