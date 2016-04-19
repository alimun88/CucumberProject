package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import util.ScreenShot;

public class SeleniumLoginTest {
	WebDriver driver;
	String baseURL ;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void openBrowser(){
		report = new ExtentReports("C:\\Users\\Liaquat\\Desktop\\letskodeit.html");
		test = report.startTest("Selenium Login Test");
		driver = new FirefoxDriver();
		baseURL ="http://www.letskodeit.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
	@Test
	public void seleniumLoginTest() throws InterruptedException{
		driver.get(baseURL);
		WebElement signupLink =driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		WebElement siginpLink =driver.findElement(By.xpath("//div[@id='signUpDialogdialog']//a"));
		siginpLink.click();
		WebElement emailInput =driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailInput.sendKeys("test@email.com");
		WebElement passwordInput =driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordInput.sendKeys("abcabc");
		WebElement goButton =driver.findElement(By.id("memberLoginDialogsubmitButton"));
		goButton.click();
		Thread.sleep(3000);
		WebElement practicePageLink =driver.findElement(By.xpath("//p[@id='DrpDwnMn06label']"));
		practicePageLink.click();
		Thread.sleep(3000);
		String expectedText = "Practice Page (Restricted)";
		try{
		String headerText = driver.findElement(By.xpath("//div[@id='pudoainlineContent']//h2")).getText();
		if (headerText.equals(expectedText)){
			System.out.println("Login Successful");
		}
		}catch (Exception e){
			System.out.println("Login failed "+ e.getMessage());
		}
	}
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException{
		if(testResult.getStatus()==ITestResult.FAILURE){
		ScreenShot.takeScreenShot(driver, testResult.getName());
		}
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
