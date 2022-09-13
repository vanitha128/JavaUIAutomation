package test.java.demoqa;

import main.demoqa.pages.BitlyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.demoqa.setup.SetupTest;

public class DemoQATests extends SetupTest {
	
	private String driverUrl="https://bitly.com/pages/home/v2";

	@DataProvider(name = "testData")
	public Object[][] getData() {
		return new Object[][] { 
			{"https://www.google.com", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"},
			{"www.facebook.com", "//*[@id=\"content\"]/div/div/div/div[1]/div/img"}
			};

	}

	@Test(groups = { "critical" }, dataProvider = "testData")
	public void testBitlyUrlConversion(String sourceURL, String verifyElement) throws InterruptedException {
		driver.get(driverUrl);
		// convert url
		BitlyPage bitlyPage = new BitlyPage(driver);
		bitlyPage.enterSourceURL(sourceURL);
		Thread.sleep(2000);
		String bitlyURL = bitlyPage.getShortenedUrlTxt();

		// Go to bitly url
		driver.get(bitlyURL);
		WebDriverWait wait = new WebDriverWait(driver,5);
		System.out.println(driver.getCurrentUrl());
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyElement)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")));
	}

}
