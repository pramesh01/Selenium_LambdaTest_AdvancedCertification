package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
  WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Explore all Integrations')]")
	private List<WebElement> exploteAllIntegrationLink;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public IntegrationPage GotoIntegrationPage() {
    	List<WebElement> e=exploteAllIntegrationLink;
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0;i<e.size();i++) {
			if(e.get(i).getText().equals("Explore all Integrations")) {
		js.executeScript("arguments[0].scrollIntoView(true);",e.get(e.size()-1));
		js.executeScript("window.scrollBy(0,-100)");
		//Thread.sleep(2000);
		e.get(i).click();  //functionality mismatch here..opening in same tab window ...
		System.out.println("successfully clicked on Explore All Integration link");
		}
		}
    	return new IntegrationPage(driver);
    	
	 }	
	 }

