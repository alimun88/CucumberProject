package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingSteps {
	WebDriver driver;
	
	@Given("^User is in home page$")
	public void user_is_in_home_page() {
		driver = new FirefoxDriver();
		String baseURL ="http://www.letskodeit.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password(){
		WebElement signupLink =driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		WebElement siginpLink =driver.findElement(By.xpath("//div[@id='signUpDialogdialog']//a"));
		siginpLink.click();
		WebElement emailInput =driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailInput.sendKeys("test@email.com");
		WebElement passwordInput =driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordInput.sendKeys("abcabc");
	}

	@When("^clicks go button$")
	public void clicks_go_button() throws InterruptedException {
		WebElement goButton =driver.findElement(By.id("memberLoginDialogsubmitButton"));
		goButton.click();
		Thread.sleep(4000);
	}

	@Then("^He can visit the practice page$")
	public void he_can_visit_the_practice_page() {
		WebElement practicePageLink =driver.findElement(By.xpath("//p[text()='Practice Page']"));
		practicePageLink.click();
	}

	@Then("^A message is displayed$")
	public void a_message_is_displayed() {
		String expectedText = "Practice Page (Restricted)";
		String headerText = driver.findElement(By.xpath("//div[@id='pudoainlineContent']//h2")).getText();
		if (headerText.equals(expectedText)){
			System.out.println("Login Successful");
		}else{
			System.out.println("Login failed");
		}
	}
	
	@When("^user click Home Page Link$")
	public void user_click_Home_Page_Link() {
		WebElement homePageLink =driver.findElement(By.id("DrpDwnMn00label"));
		homePageLink.click();
	}

	@Then("^He can see the logout link$")
	public void he_can_see_the_logout_link() throws Throwable {
		String logoutText = driver.findElement(By.xpath("//div[text()='Log out']")).getText();
		if(logoutText.endsWith("Log out")){
			System.out.println("Log out link is present, user in Home page");
		}else{
			System.out.println("Log out link is not present, user is not in Home page");
		} 
	}

	@When("^user click on logout link$")
	public void user_click_on_logout_link() {
		WebElement logoutLink =driver.findElement(By.xpath("//div[text()='Log out']"));
		logoutLink.click();
	}

	@Then("^he can see signup login link$")
	public void he_can_see_signup_login_link() {
		String loginSignupText = driver.findElement(By.xpath("//div[text()='Login/Sign up']")).getText();
		if(loginSignupText.endsWith("Login/Sign up")){
			System.out.println("Login/signup link is present");
		}else{
			System.out.println("Login/signup link is not present");
		} 
	}

	@Then("^user close the browser$")
	public void user_close_the_browser() {
	    driver.close();
	}

}
