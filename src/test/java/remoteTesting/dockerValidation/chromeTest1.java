package remoteTesting.dockerValidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chromeTest1 {

	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException
	{
	
		File fi = new File("output.txt");
		if(fi.delete())
		{
			System.out.println("file deleted successfully");
		}
		
		startDocker start_docker = new startDocker();
		start_docker.startFile();
		
	}
	
	
	@Test
	public void test1() throws MalformedURLException
	{
		// TODO Auto-generated method stub
		
		URL u = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//Remote WebDriver class
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException
	{
		stopDocker stop_docker = new stopDocker();
		stop_docker.stopFile();
	}
}
