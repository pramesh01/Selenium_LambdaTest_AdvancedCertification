package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BaseMainTest;
import util.Utilities;

public class MyTestListener extends Utilities implements ITestListener {
	ExtentReports extentReports=Utilities.generateExtentReports();
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		String testCaseName=result.getTestContext().getName();
		System.out.println(testCaseName +" started in Listeners");
		String testMethodName=result.getName();
		extentTest=extentReports.createTest(testMethodName);
		extentTest.log(Status.INFO," test method "+testMethodName+" started - in Listeners");
	}

	public void onTestSuccess(ITestResult result) {
		String testCaseName=result.getTestContext().getName();
		//System.out.println(testCaseName +" successful in Listeners");
		extentTest.log(Status.PASS,"test method Passed "+result.getName());
	}

	/*public void onTestFailure(ITestResult result) {
		String testCaseName=result.getTestContext().getName();
		System.out.println(testCaseName +"failed in Listeners");
		String testName=result.getName();
		//WebDriver driver=null;;
		///*try {
		//	driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		//} catch (Exception e) {
		//	e.printStackTrace();
		//} 
		// ITestContext context = result.getTestContext();
		// driver = (WebDriver) context.getAttribute("WebDriver");
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotfilePath=System.getProperty("user.dir")+"//Screenshots//"+testName+".png";
		File destFilepath=new File(ScreenshotfilePath);
		try {
			FileUtils.copyFile(srcFile, destFilepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(ScreenshotfilePath); //at test level
		extentTest.log(Status.INFO, "test case Failed.");
		extentTest.log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotfilePath).build());//at log level
		extentTest.log(Status.WARNING, result.getThrowable());
		extentTest.log(Status.FAIL, "test case failed "+testName);
		
	  }*/
	
	public void onTestSkipped(ITestResult result) {
		String testCaseName=result.getTestContext().getName();
		System.out.println(testCaseName +" skipped in Listeners");
		extentTest.log(Status.SKIP,"test method skipped "+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
	  }
        }
