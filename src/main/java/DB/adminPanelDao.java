package DB;
import java.sql.*;

import Frontend.amount;
import Frontend.complaint;
import Frontend.payments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class adminPanelDao {
//
//   public static void payment(int meterId , double amount) throws SQLException, ClassNotFoundException {
//        if(checkMeterIdExist(meterId)){
//          Connection con = connection.createConnection();
//          Statement st = con.createStatement();
//            String queryForOriginalAmount ="SELECT * from user where meterId =\"" + meterId + "\"";
//            ResultSet rs = st.executeQuery(queryForOriginalAmount);
//            double billAmount =0;
//            while(rs.next()) {
//                billAmount = rs.getDouble("billAmount");
//            }
//            double newAmount = billAmount - amount;
//            String query = "INSERT INTO newPayments VALUES(" + meterId + "," +  amount + ")" ;
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.executeQuery();
//            String query2 = "INSERT INTO approvedPayments VALUES(" + meterId + "," +  amount + ")" ;
//            PreparedStatement psttmt = con.prepareStatement(query2);
//            psttmt.executeQuery();
//            String query3 = "UPDATE user" + "SET billAmount =  " + newAmount + "WHERE meterId = " + meterId ;
//            PreparedStatement psttmtt = con.prepareStatement(query3);
//            psttmtt.executeQuery();
//        }
//    }
//

public static ObservableList<complaint>getDatacomplaints() throws ClassNotFoundException, SQLException{
	Connection con= connection.createConnection();
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
	Connection con= connection.createConnection();
	ObservableList<payments> list = FXCollections.observableArrayList();
	try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from newPayments");
		while(rs.next()) {
			list.add(new payments(rs.getInt("meterId"), rs.getDouble("amount")));
		}
		con.close();
	}catch(Exception e) {
	}
	return list;
	
}

public static ObservableList<amount>getDatapendingbill() throws ClassNotFoundException, SQLException{
	Connection con= connection.createConnection();
	ObservableList<amount> list = FXCollections.observableArrayList();
	try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user where billAmount>0");
		while(rs.next()) {
			list.add(new amount(rs.getInt("meterId"), rs.getDouble("billamount")));
		}
		con.close();
	}catch(Exception e) {
	}
	return list;
	
}



    public static boolean checkMeterIdExist(int meterId) throws ClassNotFoundException, SQLException {
        boolean flag = false;
        Connection con = connection.createConnection();
        Statement st = con.createStatement();
        String query ="SELECT * from user where meterId =\"" + meterId + "\"";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            flag = true;
        }
        return flag;
    }
//    public void insertAdmin(String name , String username , String password ,String email) throws SQLException, ClassNotFoundException {
//		Connection con = connection.createConnection();
//		String query = "INSERT into admin VALUES(\"" + name + "\"," +  username + "," + password + "," + email + ")";
//		PreparedStatement pt = con.prepareStatement(query);
//		pt.executeQuery();
//	}
    
	public static void executingAmount(int meterId) throws SQLException, ClassNotFoundException {
		Connection con = connection.createConnection();
		Statement st = con.createStatement();
		String queryForOriginalAmount ="SELECT * from user where meterId =" + meterId ;
		ResultSet rs = st.executeQuery(queryForOriginalAmount);
		double billAmount =0.0;
		while(rs.next()) {
			billAmount = rs.getInt("billAmount");
		}
		String newPayment = "SELECT * from newPayments where meterId =" + meterId ;
		int newPayments =0;
		ResultSet rss = st.executeQuery(newPayment);
		while(rss.next()){
			newPayments = rss.getInt("amount");
		}
		double updatedBill = billAmount - newPayments ;
		String query3 = "UPDATE user " + "SET billAmount =  " + updatedBill + " WHERE meterId = " + meterId ;
		st.executeUpdate(query3);
	}
}
