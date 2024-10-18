package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseMainTest;

public class Utilities extends BaseMainTest{
	
	public static String generateEmailwithtimeStamp() {
		Date d=new Date();
		String timeStamp= d.toString().replace(" ","_").replace(":","_");
		return "pramesh.kumar"+timeStamp+"@gmail.com";
	}
	
	public static ExtentReports generateExtentReports() {
		ExtentReports extentReports=new ExtentReports();
		String reportsPath=System.getProperty("user.dir")+"//Reports//reports.html";
		File file=new File(reportsPath);
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("TN Automation Execution REsults");
		reporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReports.attachReporter(reporter);
		
		Properties reportsProp=new Properties();
		File filepath=new File(System.getProperty("user.dir")+"//src//main//java//config//Config.properties");
		try {
		FileInputStream fis=new FileInputStream(filepath);
		reportsProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		extentReports.setSystemInfo("Application URL",reportsProp.getProperty("url"));
		extentReports.setSystemInfo("Browser",reportsProp.getProperty("Browser"));
		extentReports.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReports.setSystemInfo("Operating System",System.getProperty("user.name"));
		extentReports.setSystemInfo("Operating System",System.getProperty("java.version"));
		return extentReports;
	}	
	  }