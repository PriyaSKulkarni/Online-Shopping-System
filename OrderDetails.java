import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDetails {
	public OrderDetails(Connection connection, int custid) throws SQLException{
		Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from fall22_s004_7_order where custid ="+custid);
	    while (rs.next())
	      System.out.println("Orderid is "+rs.getString("orderid")+" ordered on "+rs.getString("order_date")+" for total amount of "+rs.getString("total_amt")+" of "+rs.getString("qty")+" quantity for product id "+rs.getString("productid"));
	    rs.close();
	    stmt.close();
	    
		} 
}
