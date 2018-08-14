package integration.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
	
	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sougata_S_B\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sougata_S_B\\chromedriver_win32.exe");
		//	Thread.sleep(5000);
		//  WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/StrutsLoginEx/");
		System.out.println("Driver Started");
		driver.quit();
	}

}
