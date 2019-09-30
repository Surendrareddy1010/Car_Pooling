import java.sql.SQLException;
import java.util.*;
public class connectionManager
{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException
	{
		System.out.println("--------Welcome to the Car Pooling Site-------");
		System.out.println("Choose options from below : ");
		System.out.println("1. Register\n2. Login\nAny Other to exit.\nYour Choice : ");
		int n = s.nextInt();
		if(n==1)
		{
			registration reg = new registration();
			reg.start();
		}
		if(n==2)
		{
			login lo = new login();
		    lo.start();
		    
		}
	}
}
