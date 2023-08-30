import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InventoryUpdate {
	public InventoryUpdate(Connection connection) throws SQLException{
		Statement stmt = connection.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Inventory ID:");
		int iid = sc.nextInt();
		System.out.println("\n Enter what has to be updated.. \n 1.Quantity available \n2. Minimum Quantity  ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
		System.out.println("Enter Quantity available:");
		int iqty= sc.nextInt();
		sc.nextLine();
		int rs = stmt.executeUpdate("update fall22_s004_7_Inventory set QTY_AVAIL = '"+iqty+"' where INVENTORYID = '"+iid+"'");
		   if(rs > 0) {
			   System.out.println("Updation Succesfully");
		   }
		   else {
			   System.out.println("Updation Failed");
		   }
		break;
		case 2:
		System.out.println("Enter Minimum Quantity: ");
		int mqty = sc.nextInt();
		sc.nextLine();
		int rs1 = stmt.executeUpdate("update fall22_s004_7_Inventory set MIN_QTY = '"+mqty+"' where INVENTORYID = '"+iid+"'");
		   if(rs1 > 0) {
			   System.out.println("Updation Succesfully");
			   
		   }
		   else {
			   System.out.println("Updation Failed");
		   }
		break;
		}
	    
		} 
}
