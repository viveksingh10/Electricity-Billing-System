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
public static void insertUser( String firstname , String lastname, int meterId , String username , String password , String email , String gender , String addharUid , double billAmount ) throws SQLException, ClassNotFoundException {
Connection con = connection.createConnection();
String query = "INSERT INTO user VALUES(\"" + firstname + "\",\"" + lastname +  "\"," +  meterId + ",\"" + username + "\",\"" + password + "\",\"" + email + "\",\"" + gender + "\",\"" + addharUid + "\"," + billAmount+ ")" ;
PreparedStatement pt = con.prepareStatement(query);
pt.executeUpdate();

}
public static void readFromForgetPage(int meterId) throws SQLException, ClassNotFoundException {
		Connection con = connection.createConnection();
		String type = "Complaint";
		String status = "Pending";
		String remark = "Error in login";
		String query = "INSERT into feedback VALUES(" + meterId + ",\"" +  type + "\",\"" + remark + "\",\"" + status + "\")";
	PreparedStatement pt = con.prepareStatement(query);
	pt.executeUpdate();
}
public static void userComplaint(int meterId , String type , String remark) throws SQLException, ClassNotFoundException {
	Connection con = connection.createConnection();
		String status = "Pending";
		String query = "INSERT into feedback VALUES(" + meterId + ",\"" +  type + "\",\"" + remark + "\",\"" + status + "\")";
	PreparedStatement pt = con.prepareStatement(query);
	pt.executeUpdate();
}

public static void newPayments(int meterId, double d) throws SQLException, ClassNotFoundException {
	Connection con =connection.createConnection();
   	String query = "INSERT INTO newPayments VALUES(" + meterId + "," +  d + ")" ;
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.executeUpdate();
	}
public static void addBill(int meterId , double d) throws ClassNotFoundException, SQLException {
	Connection con = connection.createConnection();
	String query1 ="SELECT * from user where meterId =" + meterId ;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query1);
	double amount =0;
	while(rs.next()) {
	 amount = rs.getDouble("billAmount");
	}
	//amount += billAmount;
	if(amount != 0) {
		amount += d;
	}else {
		amount = d;
	}
	 String query2 = "UPDATE user " + "SET billAmount =  " + amount + " WHERE meterId = " + meterId ;
	 st.executeUpdate(query2);
	 }
}