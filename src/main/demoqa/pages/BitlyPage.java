package main.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BitlyPage extends PageObject {

	@FindBy(id="shorten_url")
	private WebElement shortenURLTxt;

	@FindBy(id="shorten_btn")
	private WebElement shortenButton;

	@FindBy(xpath="//*[@id=\"most_recent_links\"]/li[1]/span[2]/span[1]/a")
	private WebElement shortenedUrl;

	public BitlyPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterSourceURL(String sourceURL) {
		this.shortenURLTxt.clear();
		this.shortenURLTxt.sendKeys(sourceURL);
		this.shortenButton.click();

	}

	public String getShortenedUrlTxt() {
		return this.shortenedUrl.getAttribute("href");
	}
}
