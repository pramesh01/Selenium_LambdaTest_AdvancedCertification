package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingWhizPage {
	
WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Integrate Testing Whiz with LambdaTest']")
	private WebElement testwiz_hyperlink;
	
	public TestingWhizPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clicking_testWiz_IntegrationLink() {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 Actions act=new Actions(driver);
		 act.moveToElement(testwiz_hyperlink).perform();
		 wait.until(ExpectedConditions.elementToBeClickable(testwiz_hyperlink));
	    //act.moveToElement(e3).perform();
	    wait(4000);
	    testwiz_hyperlink.click();
	    
	}
	
	public void wait(int timeinseconds) {
		try {
			Thread.sleep(timeinseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
