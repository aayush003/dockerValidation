package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.annotations.Test;

import org.testng.Assert;

public class stopDocker {

	@Test
	public void stopFile() throws IOException, InterruptedException
	{

		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerDown.bat");

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
				if(current_line.contains("selenium-hub exited"))
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
		
	}
}
