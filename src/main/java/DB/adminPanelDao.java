package DB;
import java.sql.*;
public class adminPanelDao {

   public static void payment(int meterId , double amount) throws SQLException, ClassNotFoundException {
        if(checkMeterIdExist(meterId)){
          Connection con = connection.createConnection();
          Statement st = con.createStatement();
            String queryForOriginalAmount ="SELECT * from user where meterId =\"" + meterId + "\"";
            ResultSet rs = st.executeQuery(queryForOriginalAmount);
            double billAmount =0;
            while(rs.next()) {
                billAmount = rs.getDouble("billAmount");
            }
            double newAmount = billAmount - amount;
            String query = "INSERT INTO newPayments VALUES(" + meterId + "," +  amount + ")" ;
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeQuery();
            String query2 = "INSERT INTO approvedPayments VALUES(" + meterId + "," +  amount + ")" ;
            PreparedStatement psttmt = con.prepareStatement(query2);
            psttmt.executeQuery();
            String query3 = "UPDATE user" + "SET billAmount =  " + newAmount + "WHERE meterId = " + meterId ;
            PreparedStatement psttmtt = con.prepareStatement(query3);
            psttmtt.executeQuery();
        }
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
}
