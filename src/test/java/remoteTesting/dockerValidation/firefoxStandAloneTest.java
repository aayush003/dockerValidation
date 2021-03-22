package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class firefoxStandAloneTest {

	public static void main(String[] args) throws MalformedURLException 
	{
		// TODO Auto-generated method stub
		
		URL u = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		//Remote WebDriver class
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

}
