package pageclasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommunityPage {
	
	WebDriver driver;
	@FindBy(css="li[id='menu-item-10121'] a")
	private WebElement communitylink;
	
	public CommunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnCommunityLink() {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(communitylink));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",communitylink);
		  //communitylink.click();
		  
	  }
	
	 public void validateTitle_inCommunityPage() {
		String actualURL1=driver.getCurrentUrl();
		String expectedURL1="https://community.lambdatest.com/";
		Assert.assertEquals(actualURL1, expectedURL1);
	      } 
           }