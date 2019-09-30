import java.util.*;
public class crud extends details 
{
	Scanner s = new Scanner(System.in);
	@Override
	void start() throws InterruptedException 
	{
		int n = 0;
		while(n<4)
		{
			System.out.println("----------------------------");
			System.out.print("Choose from options below operations you need to perform \n1)View\n2)Updation\n3)Deletion\nAny Other to exit.\nEnter Your Choice = ");
			n = s.nextInt();
			if(n==1)
			{
				view vi = new view();
				vi.start();
				vi.join();
			}
			if(n==2)
			{
				update up = new update();
				up.start();
				up.join();
			}
			if(n==3)
			{
				delete del = new delete();
				del.start();
				del.join();
			}
		}
	}
}
