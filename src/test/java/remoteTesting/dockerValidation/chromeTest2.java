package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromeTest2 {

	@Test
	public void test2() throws MalformedURLException
	{
		// TODO Auto-generated method stub
		
		URL u = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//Remote WebDriver class
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		driver.get("https://www.yahoo.com");
		System.out.println(driver.getTitle());
	}
}
