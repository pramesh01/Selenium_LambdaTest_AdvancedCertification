package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseMainTest;

public class TestScenarioOne extends BaseMainTest{
	
	public TestScenarioOne() {
	 super();	
	 }
	
	@BeforeMethod
	public void setup() {
	  driver=initializeBrowser(prop.getProperty("Firefox_Browser")); 
	  
	}
	@AfterMethod
	public void teardown() {
		  if (driver != null) {
	            driver.quit(); 
	        }
	}
	
	@Test
	public void scenarioOne_SimpleFormDemo() {
		driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']")).click();
		String currenturl=driver.getCurrentUrl();
		if(currenturl.contains("simple-form-demo")) {
			System.out.println("Text 'simple-form-demo' is available in url");
		}else
			System.out.println("text 'simple-form-demo' is Not avalable in URL.");
		
		String requiredStringText="Welcome to LambdaTest";
		driver.findElement(By.xpath("//*[@id='user-message']")).sendKeys(requiredStringText);
		driver.findElement(By.cssSelector("#showInput")).click();
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		String ActualText=driver.findElement(By.cssSelector("#message")).getText();
		Assert.assertEquals(ActualText,requiredStringText);
		System.out.println("successful validation of entered text under your message area..");
		System.out.println("First scenarion is completed here..");
	}

}
