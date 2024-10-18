package pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IntegrationPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Codeless Automation']")
	private WebElement codelessAutomationLink;
	
	public IntegrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void validateURL_withinIntegrationPage() {
		System.out.println(driver.getCurrentUrl());
		String expectedURL="https://www.lambdatest.com/integrations";
		Assert.assertEquals((driver.getCurrentUrl()),expectedURL);
		System.out.println("url is matched");	
	  }
	
	public TestingWhizPage clickingoncodeless_automationLink() {
		codelessAutomationLink.click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TestingWhizPage(driver);
	}
}
