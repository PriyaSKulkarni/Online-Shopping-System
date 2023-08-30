import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {
	public void ProductDisplay(Connection connection) throws SQLException{
		Statement stmt = connection.createStatement();
		
	    ResultSet rs = stmt.executeQuery("select * from fall22_s004_7_Product  p,"
	    		+ "fall22_s004_7_product_brand b,fall22_s004_7_product_color c,"
	    		+ "fall22_s004_7_product_category c1, fall22_s004_7_product_gender g,"
	    		+ "fall22_s004_7_product_size s where p.productid = b.productid and "
	    		+ "p.productid = c.productid and p.productid = c1.productid and "
	    		+ "p.productid = g.productid and p.productid = s.productid ");
	    while (rs.next()) {
	      System.out.println("Product id :"+rs.getString("Productid")+" | Selling price :"+rs.getString("selling_price")
	      +" | Brand: "+rs.getString("Product_brand")+" | Category: "+rs.getString("Product_category")
	      +" | Color: "+rs.getString("Product_color")+" | Size: "+rs.getString("Product_size")+" | Gender: "+rs.getString("Product_gender"));
	    }
	    rs.close();
	    stmt.close();
       
		} 

}
