package test.java.demoqa.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class SetupTest {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		ChromeOptions options = new ChromeOptions().setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
