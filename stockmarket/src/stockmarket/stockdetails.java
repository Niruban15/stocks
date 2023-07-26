package stockmarket;
import java.sql.*;
import java.util.Scanner;

public class stockdetails{
	Scanner obj=new Scanner(System.in);
	  String url="jdbc:mysql://127.0.0.1:3306/java";
		String username="root";
		String password="5609";
		
		
		  public void create()

		  {
			  try { 
				
					Connection con=DriverManager.getConnection(url,username,password);
		        String q1="create database stocks";
	           Statement st=(Statement) con.createStatement();      
	            st.executeUpdate(q1);
	          System.out.println("Created new DATABASE:STOCKS"); 	
	          String q2="create table stocks.NIFTY50"+
	                 "(STOCKID integer primary key auto_increment,"+
	                 "STOCKNAME VARCHAR(50)UNIQUE,"+
	                 "CLOSINGPRICE FLOAT,"+
	                 "OPENINGPRICE FLOAT,"+
	                 "DAYHIGH FLOAT,"+
	                "DAYLOW FLOAT)";
	      st.executeUpdate(q2);
	      System.out.println("Created table NIFTY50");   
	      String q3="create table stocks.USER"+
	    		    "(USERID int PRIMARY KEY auto_increment,"+
	                "USERNAME VARCHAR(50),"+
	                "PAN_NUMBER INTEGER UNIQUE,"+
	                "TRADES_TAKEN INTEGER,"+
	                "TOTAL_BUY_VALUE FLOAT,"+
	                "TOTAL_SELL_VALUE FLOAT,"+
	                "FUNDS_AVAILABLE FLOAT)";
	      st.executeUpdate(q3);
	      System.out.println("Created table USER");}
		  catch(SQLException e) {
			  e.printStackTrace();
			  
		  }}
		  
		  public void insert()throws Exception{
			 try {
				
		 Connection con=DriverManager.getConnection(url,username,password);
	          System.out.println("Enter the number of data insertion row:");
	           int size=obj.nextInt();
	                    obj.nextLine();
	          String q4="insert into stocks.NIFTY50"+
	        	         "(STOCKNAME,CLOSINGPRICE,OPENINGPRICE,DAYHIGH,DAYLOW)VALUES (?,?,?,?,?);";
	        	         PreparedStatement st1 =con.prepareStatement(q4);
	         
	        for(int i=0;i<size;i++)
	         {	 
	        	
	        	System.out.println("ENTER THE STOCKNAME: ");
	        	 String STOCKNAME=obj.nextLine();
	        	 st1.setString(1,STOCKNAME);
	        	 
	        	 System.out.println("ENTER THE CLOSINGPRICE: ");
	        	 float CLOSINGPRICE=obj.nextFloat()	;
	        	   st1.setFloat(2,CLOSINGPRICE);
	        	 
	        	 System.out.println("ENTER THE OPENINGPRICE: ");
	        		float OPENINGPRICE=obj.nextFloat();
	        	 st1.setFloat(3,OPENINGPRICE);
	        	 
	        	 System.out.println("ENTER THE DAYHIGH:");
	        		float DAYHIGH=obj.nextFloat()	;
	        	     st1.setFloat(4,DAYHIGH);
	        	     
	        		 
	        	System.out.println("ENTER THE DAYLOW:");
	        	float DAYLOW=obj.nextFloat();
	        	             obj.nextLine();
	            st1.setFloat(5,DAYLOW);
	            
	            st1.executeUpdate();
	 
	         }
	      
		  }
			  catch(SQLException e) {
				  e.printStackTrace();
				  
			  }}
	        public void nameupdate()

	        {
	        	try {
	        
	         Connection con=DriverManager.getConnection(url,username,password);
			 
	         System.out.println("ENTER THE NEW STOCKNAME YOU WOULD LIKE TO UPDATE ");
	         String updatename=obj.nextLine();
	         
	         System.out.println("ENTER THE CORRESPONDING STOCKID  ");
	         int updateid=obj.nextInt();
	         
	         String q5="UPDATE stocks.NIFTY50 set STOCKNAME=? where STOCKID=?";
	         PreparedStatement st2 =con.prepareStatement(q5);
	         st2.setString(1,updatename);
	         st2.setInt(2, updateid);
	         st2.executeUpdate();
	 		 System.out.println("Data updated..");
	        	}
	        	catch(SQLException e) {
				  e.printStackTrace();
				  
			  }}
	        	public void getbystockid(){
	        		try { Connection con=DriverManager.getConnection(url,username,password);
	    			
	    			System.out.println("ENTER THE STOCKID TO VIEW STOCKDETAILS");
	   	             int getbystockid=obj.nextInt();
	   	          String q6="select*from stocks.NIFTY50 where STOCKID=?";
	   	    PreparedStatement st4 =con.prepareStatement(q6);
	    			 st4.setInt(1,getbystockid);
	    			 st4.executeUpdate();
	    			 Statement st5=con.createStatement();
	    			 ResultSet rs= st5.executeQuery(q6);
	    			 while(rs.next()) {
	    	        	 System.out.println("ID"+rs.getInt(1));
	    	        	 System.out.println("STOCKNAME"+rs.getString(2));
	    	        	 System.out.println("CLOSINGPRICE"+rs.getFloat(3));
	    	        	 System.out.println("OPENINGPRICE"+rs.getFloat(4));
	    	        	 System.out.println("DAYHIGH"+rs.getFloat(5));
	    	        	 System.out.println("DAYLOW"+rs.getFloat(6));
	    	        	}}
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();
	   				  
	   			  }}
	        public static void main(String[] args)throws Exception{
	           stockdetails obj=new stockdetails();
	                 // obj.create();
	                // obj.insert();
	               // obj.nameupdate();
	           obj.getbystockid();
	 
}}

