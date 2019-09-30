import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class registration extends details 
{
	Scanner s = new Scanner(System.in);
	@Override
	void start() throws ClassNotFoundException, SQLException, InterruptedException 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			System.out.println("-------Registration-------");
			System.out.println("Enter the User Name to register : ");
			user_name = s.nextLine();
			System.out.println("Enter the Password : ");
			password = s.nextLine();
			System.out.println("Enter the Employee ID : ");
			Employee_id = s.nextInt();
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","SYSTEM","MANAGER");
			if(conn!=null)
			{
				Statement stmt = conn.createStatement();
				stmt.executeQuery("INSERT INTO CPOOL.USERS VALUES('"+user_name+"',"+"'"+password+"',"+Employee_id+")");
				System.out.println("User Registered Succesfully.");
				login l = new login();
				l.start();
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