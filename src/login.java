import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class login extends details 
{
	Scanner s = new Scanner(System.in);
	@Override
	void start() throws ClassNotFoundException, SQLException, InterruptedException 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			System.out.println("---------Login-----------");
			System.out.println("Enter User Name : ");
			user_name = s.nextLine();
			System.out.println("Enter Password : ");
			password = s.nextLine();
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","SYSTEM","MANAGER");
			if(conn!=null)
			{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM CPOOL.USERS WHERE USER_NAME='"+user_name+"' AND PASSWORD='"+password+"'");
				if(rs.next())
				{
					System.out.println("Login Successful");
					crud cr = new crud();
					cr.start();
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