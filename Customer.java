import java.sql.*;

public class Customer {
	public void Customerwork(Connection connection, int custid) throws SQLException{
	Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery("select * from fall22_s004_7_customer where custid ="+custid);
    while (rs.next())
      System.out.println("Name: "+rs.getString("name")+" | Email: "+rs.getString("email")+
      " | Address :"+rs.getString("street")+", "+rs.getString("city")+", "+rs.getString("country")+", "
      +rs.getString("zip")+" | Phone number: "+rs.getString("phone_no"));
    rs.close();
    stmt.close();
    
	} 

}
