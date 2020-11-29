package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//testing user 
public class test {
	public static boolean checkDetails(String username,String password) throws ClassNotFoundException, SQLException {
		checkLoginDAO ck = new checkLoginDAO();
		if(ck.checkUser(username, password)) {
			return true;
		}else {
			return false;
		}
	}
	//main
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*
		 * 
		 *  Uncomment these to test the DAO Classes
		 *  
		 *  
		 *  */
//		Connection con=connection.createConnection();
//		String sql = "Insert into user(username,password) values (?,?)";
//		PreparedStatement pr=con.prepareStatement(sql);
//		pr.setString(1, "vats");
//		pr.setString(2,"vatsal");
//		pr.executeUpdate();
//		boolean val = checkDetails("henloooooo", "henloo");
//		System.out.println(val);
		
//		userPanelDAO uk = new userPanelDAO();
//		 boolean checkMeterID = userPanelDAO.checkMeterExist("vatdcvdsal");
//		 System.out.println(checkMeterID);
//		userPanelDAO uk = new userPanelDAO();
//		int t = uk.getMeterId("vatsdfval");
//		System.out.println(t);
//         Connection con =connection.createConnection();
//		userPanelDAO us = new userPanelDAO();
//		us.newPayments(102, 2000);
//        us.userComplaint(102, "Yo", "juwe"); 
		//us.insertUser("vatsal", 1010, "username", "password", "email", "M", "addharUid", 109);
//		   Connection con =connection.createConnection();
//			userPanelDAO us = new userPanelDAO();
//			us.addBill(101, 10);
//		Connection con =connection.createConnection();
//		adminPanelDao db = new adminPanelDao();
//		db.executingAmount(101);
//			
//		
	}

}
