package stockmarket;
import java.sql.*;
import java.util.Scanner;

public class nameupdate {
	  
    System.out.println("ENTER THE STOCKID TO UPDATE ");
    int updateid=obj.nextInt();
    System.out.println("ENTER THE STOCKNAME TO UPDATE ");
    String updatename=obj.nextLine();
    
    
    String q5="UPDATE stocks.NIFTY50 set STOCKNAME=updatename where STOCKID=updateid";
	Statement st2=con.createStatement(); 
	st2.executeUpdate(q5);
	System.out.println("Data updated..");
	ResultSet rs=st2.executeQuery("SELECT * FROM stocks.NIFTY50 WHERE STOCKID=updateid"); 
	rs=st2.executeQuery("SELECT * FROM stocks.NIFTY50 WHERE STOCKID=updateid"); 
   System.out.println(rs.getInt("STOCKID")+" "+rs.getString("STOCKNAME"));

}
