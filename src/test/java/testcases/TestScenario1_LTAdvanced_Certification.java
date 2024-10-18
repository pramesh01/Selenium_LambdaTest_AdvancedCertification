package testcases;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseMainTest;
import pageclasses.CommunityPage;
import pageclasses.HomePage;
import pageclasses.IntegrationPage;
import pageclasses.TestingWhizPage;

public class TestScenario1_LTAdvanced_Certification extends BaseMainTest {
	//Constructor of current class
		public TestScenario1_LTAdvanced_Certification() {
		     super();	
		      }
		
		//Before Method for initialization purpose
		//@Parameters("BName") //- not sure about it.
		@BeforeMethod
		@Parameters("BName")  //-> required when u running on local machine
		public void setup(String browserName) {
		 // driver=initializeBrowser(prop.getProperty("Chrome_Browser")); 
		 driver=initializeBrowser(browserName); // reading data from testng.xml directly.
		 driver.get(prop.getProperty("url"));  // Reading URL data from property file.
		      }
		
		@Test
		public void lambdaTest_AdvancedCertification() throws InterruptedException {
			js=(JavascriptExecutor)driver;
			if(js.executeScript("return document.readyState").equals("complete"))
			{
		    System.out.println("Page has been loaded completely.");
			HomePage hp=new HomePage(driver);
			IntegrationPage ip=hp.GotoIntegrationPage();
			ip.validateURL_withinIntegrationPage();
			TestingWhizPage twp=ip.clickingoncodeless_automationLink();
			twp.clicking_testWiz_IntegrationLink();
		    Thread.sleep(2000);
		    Set<String> str=driver.getWindowHandles();
		    //str.size();
		    System.out.println("count of the current_windows are => "+str.size());
		    driver.navigate().to("https://www.lambdatest.com/blog.");
		    Thread.sleep(5000);
		    CommunityPage cp=new CommunityPage(driver);
		    cp.clickOnCommunityLink();
		    cp.validateTitle_inCommunityPage();
		    System.out.println("whole test got completed....");
		    }
			}
		
		  // After method for cleaning up the resources
		  @AfterMethod
		   public void teardown() {
			  if (driver != null) {
		            driver.quit(); 
		        }
		           }

}
