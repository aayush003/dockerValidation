package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;


public class startDocker {

	
	public void startFile() throws IOException, InterruptedException
	{

		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");

		String file = "output.txt";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 30);
		long stopnow = cal.getTimeInMillis();
		Thread.sleep(3000);

		while(System.currentTimeMillis() < stopnow)
		{

			if(flag)
			{
				break;
			}

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String current_line = reader.readLine();

			while(current_line != null && !flag)
			{
				if(current_line.contains("Registered a node http://172.18.0.3:5555"))
				{
					System.out.println("found my text");
					flag = true;
					break;
				}

				current_line = reader.readLine();	
			}

			reader.close();

		}

		Assert.assertTrue(flag);
		
		runtime.exec("cmd /c start scale.bat");
		Thread.sleep(5000);
	}
}
