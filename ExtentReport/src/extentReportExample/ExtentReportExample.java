package extentReportExample;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportExample {
	WebDriver driver;
	ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;
	
@BeforeSuite
	public void launchBrowser() {
		extentReport = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("test-output/ExtentReports.html");
		extentReport.attachReporter(htmlReporter);
		driver=new ChromeDriver();
		
	}

	@Test
	public void openGoogle() throws IOException{
		testCase = extentReport.createTest("verify Google Title");
		testCase.log(Status.INFO, "Navigating to Google");
		driver.get("http://www.google.co.in");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual title: "+title);
		testCase.log(Status.INFO, "Expected title: "+"Google");
		testCase.log(Status.INFO, "Verification of Actual and Expected title");
		if(title.equals("Google")) {
			testCase.log(Status.PASS, "Actual title and Excepted title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Excepted title NOT are equal");
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("goog.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("goog.png");
		}
	}
	
	@Test
	public void openWikipedia() throws IOException{
		testCase = extentReport.createTest("verify wikipedia Title");
		testCase.log(Status.INFO, "Navigating to wikipedia");
		driver.get("http://www.wikipedia.org");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual title: "+title);
		testCase.log(Status.INFO, "Expected title: "+"wikipedia");
		testCase.log(Status.INFO, "Verification of Actual and Expected title");
		if(title.equals("Wikipedia")) {
			testCase.log(Status.PASS, "Actual title and Excepted title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Excepted title NOT are equal");
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("wik.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("wik.png");
		}
	}
	@Test
	public void openBing()throws IOException {
		testCase=extentReport.createTest("verify bing Title");
		testCase.log(Status.INFO, "Navigating to bing");
		driver.get("http://www.bing.com");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual title: "+title);
		testCase.log(Status.INFO, "Expected title: "+"bing");
		testCase.log(Status.INFO, "Verification of Actual and Expected title");
		if(title.equals("Bing")) {
			testCase.log(Status.PASS, "Actual title and Excepted title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Excepted title NOT are equal");
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File("bi.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("bi.png");
		}
	}
	
	
	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}
}
