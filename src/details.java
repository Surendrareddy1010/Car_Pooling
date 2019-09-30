import java.sql.SQLException;

public abstract class details 
{
	String user_name;
	String password;
	int Employee_id;
	
	
	abstract void start() throws ClassNotFoundException, SQLException, InterruptedException;
}
