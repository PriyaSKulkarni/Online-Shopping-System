import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductReview {
	public ProductReview(Connection connection, int custid) throws SQLException{
		Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from fall22_s004_7_customerfeedback where custid ="+custid);
	    while (rs.next()) {
	      System.out.println(" Your feedback Id is "+rs.getString("custfeedbackid")+" on "+rs.getString("feed_date")
	      +" having comment as "+rs.getString("comments")+" and rated "+rs.getString("ratings")
	      +" for this product id "+rs.getString("productid"));
	    }
	    rs.close();
	    stmt.close();
	    
		} 
}
