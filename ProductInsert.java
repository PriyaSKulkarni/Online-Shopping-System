import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductInsert {
	public ProductInsert(Connection connection) throws SQLException{
		Statement stmt = connection.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID:");
		int pid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Product category:");
		String pcat=sc.nextLine();
		System.out.println("Enter Product Brand:");
		String pbrand = sc.nextLine();
		System.out.println("Enter Product color:");
		String pcolor = sc.nextLine();
		System.out.println("Enter Product size:");
		String psize=sc.nextLine();
		System.out.println("Enter Product gender:");
		String pgender=sc.nextLine();
		System.out.println("Enter Supplied Quantity of the product: ");
		int sqty = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter selling price of the product:");
		int sell = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter cost price of the product:");
		int cost = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Inventory ID:");
		int iid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Minimum Quantity alert: ");
		int mqty = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Supplier id by whom the product was supplied:");
		int Sid = sc.nextInt();
		int rs = stmt.executeUpdate("insert into fall22_s004_7_Product values ( '"+pid+"','"+sqty+"','"+sell+"','"+cost+"','"+Sid+"')");
		int rs1 = stmt.executeUpdate("insert into fall22_s004_7_Product_category values ( '"+pid+"','"+pcat+"')");
		int rs2 = stmt.executeUpdate("insert into fall22_s004_7_Product_color values ( '"+pid+"','"+pcolor+"')");
		int rs3 = stmt.executeUpdate("insert into fall22_s004_7_Product_brand values ( '"+pid+"','"+pbrand+"')");
		int rs4 = stmt.executeUpdate("insert into fall22_s004_7_Product_size values ( '"+pid+"','"+psize+"')");
		int rs5 = stmt.executeUpdate("insert into fall22_s004_7_Product_gender values ( '"+pid+"','"+pgender+"')");
		int rs6 = stmt.executeUpdate("insert into fall22_s004_7_Inventory values ( '"+iid+"','"+sqty+"','"+mqty+"','"+pid+"')");
		
		if(rs>0 && rs1>0 && rs2>0 && rs3>0 && rs4>0 && rs5>0 && rs6>0) {
		   System.out.println("Inserted Succesfully");
		   
	   }
	   else {
		   System.out.println("insertion failed");
	   }
	
	    stmt.close();
       
		} 
}
