import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SupplierInsert {
	public SupplierInsert(Connection connection) throws SQLException{
		Statement stmt = connection.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Supplier ID:");
		int sid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Supplier Name:");
		String Sname= sc.nextLine();
		System.out.println("Enter Supplier Email: ");
		String Semail = sc.nextLine();
		System.out.println("Enter Phone number:");
		int Sphno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter City:");
		String scity = sc.nextLine();
		System.out.println("Enter Zip code:");
		int Szip = sc.nextInt();
		int adminid =1;
	    int rs = stmt.executeUpdate("insert into fall22_s004_7_Supplier values ( '"+sid+"','"+Sname+"','"+Semail+"','"+Sphno+"','"+scity+"','"+Szip+"','"+adminid+"')");
	   if(rs>0) {
		   System.out.println("Inserted Succesfully");
		   
	   }
	   else {
		   System.out.println("insertion failed");
	   }
	
	    stmt.close();
       
		} 
}
