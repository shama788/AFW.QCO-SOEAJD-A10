package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBCSample {
	@Test
	public void executeQuerySample() throws SQLException
	{
		//fetch driver from database
		Driver dref = new Driver();//mysql
		
		//Register the driver
		DriverManager.registerDriver(dref);
		
		//Get Connect with Driver - give databse name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Issue create statement
		Statement state = con.createStatement();
		
		//Execute the query - table name 
		ResultSet result = state.executeQuery("select * from customerinfo;");
		
	  while(result.next())
	  {
		  System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
	  }
		
		//Close the database
		con.close();
	} 
	
	@Test
	public void executeUpdateSample() throws SQLException
	{
		//fetch driver from database
		Driver dref = new Driver();//mysql
		
		//Register the driver
		DriverManager.registerDriver(dref);
		
		//Get Connect with Driver - give databse name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Issue create statement
		Statement state = con.createStatement();
		
		//Execute the query - table name 
		int result = state.executeUpdate("insert into customerinfo values('Kareena',23,'Mumbai');");
		
	  if(result==1) {
		  System.out.println("Data added");
	  }
	  else
	  {
		  System.out.println("Data not added");
	  }
		
		//Close the database
		con.close();
	} 

	@Test
	public void executeDeleteSample() throws SQLException
	{
		//fetch driver from database
		Driver dref = new Driver();//mysql
		
		//Register the driver
		DriverManager.registerDriver(dref);
		
		//Get Connect with Driver - give databse name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Issue create statement
		Statement state = con.createStatement();
		
		//Execute the query - table name 
		boolean result = state.execute("DELETE from customerinfo where id=23;");
		
	  if(result==true) {
		  System.out.println("Data deleted");
	  }
	  else
	  {
		  System.out.println("Data not deleted");
	  }
	}	
}
