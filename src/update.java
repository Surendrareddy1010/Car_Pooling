import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class update extends Thread
{
	Scanner s = new Scanner(System.in);
	public void run() 
	{
		Connection conn=null;
		try
		{
			conn=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","SYSTEM","MANAGER");
			if(conn!=null)
			{
				System.out.println("-------------------------------------------------");
				System.out.println("Connected to Database Succesfully");
				Statement stmt = conn.createStatement();
				System.out.print("Enter Query for Updation : ");
				String query = s.nextLine();
				stmt.executeQuery(query);
				ResultSet rs = stmt.executeQuery("SELECT * FROM CPOOL.EMPLOYEE");
				System.out.println("Employee Name\t\tEmployee ID\t\tContact Number");
				while(rs.next())
				{
					System.out.print(""+rs.getString(1));
					System.out.print("\t\t"+rs.getString(2));
					System.out.println("\t\t"+rs.getString(3));
				}
				System.out.println("-------------------------------------------------");
				rs = stmt.executeQuery("SELECT * FROM CPOOL.CAR");
				System.out.println("Car_Number\t\tAUTH");
				while(rs.next())
				{
					System.out.print(""+rs.getString(1));
					System.out.println("\t\t"+rs.getString(2));
				}

			}
			else
				System.out.println("Not Connected");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver Class is not found! Exception Occured!!");
		}
		catch(SQLException se)
		{
			System.out.println("Exception occured while creating a connection!!");
			System.out.println(se);
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException sqlE)
			{
				System.out.println("Exception occured while closing the connection!!)");
			}
		}
	}
}
