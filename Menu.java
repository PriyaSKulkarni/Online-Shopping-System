import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
 public static void main(String args[]) throws SQLException {
	// System.out.println("-------- Oracle JDBC Connection Testing ------");
	 
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;

		}

		// System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

         connection = DriverManager.getConnection("jdbc:oracle:thin:@acaddbprod.uta.edu:1523/pcse1p.data.uta.edu", "Psk8875", "Priya1508999");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control of your database now!\n");
      } else {
			System.out.println("Failed to make connection!");
		}
		
	    Scanner myObj = new Scanner(System.in);  
	    System.out.println("Welcome to Online shopping center");
	    System.out.println("Enter username");
	    String userName = myObj.nextLine(); 
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery("select password from fall22_s004_7_admins where name = '"+userName+"'");
	    rs.next();
	    String pass= rs.getString("password");
	    System.out.println("Enter Admin password");
	    String passenter = myObj.nextLine();
	    if (pass.equals(passenter)) {
	    	 System.out.println("Welcome " + userName); 
	    	 while(true) {
	    		    System.out.println("Menu:");
	    		    System.out.println("1. New Supplier");
	    		    System.out.println("2. New Product");
	    		    System.out.println("3. Update Inventory");
	    		    System.out.println("4. Exit ");
	    		    System.out.println("Enter your choice:");
	    		    int menuchoice1 = myObj.nextInt();
	    		    
	    		    switch(menuchoice1) {
	    		    case 1: 
	    		    	SupplierInsert a = new SupplierInsert(connection);
	    		    	break;
	    		    case 2:
	    		    	ProductInsert p = new ProductInsert(connection);
	    		        break;
	    		    case 3:
	    		    	InventoryUpdate iu= new InventoryUpdate(connection);
	    		    	break;
	    		    default:
	    		    	System.out.println("Closing the connection...");
	    	            connection.close();
	    		    	break;
	    		    	
	    		    }
	    		    if (menuchoice1 == 4) {
	    		    	System.out.println("Connection Closed");
	    		    	break;
	    		    }
	    	 }
	    }
	    
	    else {
	    System.out.println("Welcome " + userName); 
	    System.out.println("Enter Customer ID:");
	    int CustId = myObj.nextInt();
	    while(true) {
	    System.out.println("Menu:");
	    System.out.println("1. Customer Details");
	    System.out.println("2. Product");
	    System.out.println("3. Order Details");
	    System.out.println("4. My Product Review");
	    System.out.println("5. Exit ");
	    System.out.println("Enter your choice:");
	    int menuchoice = myObj.nextInt();
	    
	    switch(menuchoice) {
	    case 1: 
	    	Customer a = new Customer();
	    	a.Customerwork(connection, CustId);
	    	break;
	    
	    case 2:
	    	Product p = new Product();
	    	p.ProductDisplay(connection);
	    	break;
	    case 3:
	    	OrderDetails od = new OrderDetails(connection, CustId);
	    	break;
	    case 4:
	    	ProductReview p1 = new ProductReview(connection, CustId);
	    	break;
	    default:
	    	System.out.println("Closing the connection...");
            connection.close();
	    	break;
	    	
	    }
	    if (menuchoice == 5) {
	    	System.out.println("Connection Closed");
	    	break;
	    }
	   
	    }
	    }  
 }
}
