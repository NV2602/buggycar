package StepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.buggylogin;

public class buggyRegister_POM {

	WebDriver driver = null;
	buggylogin pagelogin;


/*
 * Step definition for buggylogin.feature file 
 */
	private void lanuchChrome() throws InterruptedException
	{
		String projectpath =System.getProperty("user.dir");
		System.out.println("Project path is" +projectpath);
		System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("chrome://settings/clearBrowserData");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//object created 
		pagelogin = new buggylogin(driver);
		Thread.sleep(2000);
		//launching the url
		driver.navigate().to("https://buggy.justtestit.org/");
		//verifying whether user is on right page
		if(!driver.getTitle().equals("Buggy Cars Rating")){

			throw new IllegalStateException("This is not the buggylogin page. The current page is" +driver.getCurrentUrl());

		}

	}

	//Regression_scenario1
	/*
	 * Registration functionality without password criteria matching 
	 */
	@Given("The User Navigate to the application")
	public void the_user_navigate_to_the_application() throws InterruptedException 
	{

		lanuchChrome();	

	}

	@When("The user selects Registeration option")
	public void the_user_selects_registeration_option()
	{

		pagelogin.clickRegister();

	}

	@Then("^User enters (.*) , (.*) , (.*) , (.*), (.*)$")
	public void user_enters(String Login , String FirstName , String LastName , String Password , String ConfirmPassword) throws InterruptedException {



		pagelogin.enterlogin(Login);
		pagelogin.enterfirstName(FirstName);
		pagelogin.enterlasttName(LastName);
		pagelogin.enterpassword(Password);
		pagelogin.enterconfirmpassword(ConfirmPassword);  

	}

	@When("The User click to Register button")
	public void the_user_click_to_register_button() {

		pagelogin.clickSubmit();

	}

	@Then("User registration is unsuccessful")
	public void user_registration_is_unsuccessful() throws InterruptedException {

		String text=pagelogin.getAlertMessage();
		String expectedText = "InvalidPasswordException: Password did not conform with policy: Password must have uppercase characters";
		System.out.println(text);
		Assert.assertEquals(text,expectedText);
		System.out.println("AssertEquals Test Passed");
		driver.navigate().refresh();
	}


	@Then("^User enters Password again (.*) , (.*) , (.*), (.*) , (.*)$")
	public void user_enters_password_again(String Login , String FirstName , String LastName, String NPassword, String NConfirmPassword) {


		pagelogin.enterlogin(Login);
		pagelogin.enterfirstName(FirstName);
		pagelogin.enterlasttName(LastName);
		pagelogin.enterpassword(NPassword);
		pagelogin.enterconfirmpassword(NConfirmPassword); 

	}

	@And("User again click to Register button")
	public void user_again_click_to_Register_button() {

		pagelogin.clickSubmit();
	}

	@Then("User registration is again unsuccessful")
	public void user_registration_is_again_unsuccessful() {

		String text=pagelogin.getAlertMessage();
		String expectedText = "InvalidPasswordException: Password did not conform with policy: Password must have symbol characters";
		System.out.println(text);
		Assert.assertEquals(text,expectedText);
		System.out.println("AssertEquals Test Passed");
		driver.navigate().refresh();
	}


	@Then("^User entering Password without Lowercase character (.*) , (.*) , (.*), (.*) , (.*)$")
	public void user_entering_Password_without_Lowercase_character(String Login , String FirstName , String LastName, String NPassword, String NConfirmPassword) {


		pagelogin.enterlogin(Login);
		pagelogin.enterfirstName(FirstName);
		pagelogin.enterlasttName(LastName);
		pagelogin.enterpassword(NPassword);
		pagelogin.enterconfirmpassword(NConfirmPassword); 

	}

	@Then("User again click to Register button for Registeration")
	public void user_again_click_to_register_button_for_registeration() {


		pagelogin.clickSubmit();
	}

	@Then("User registration is again unsuccessful because password standared")
	public void user_registration_is_again_unsuccessful_because_password_standared() 
	{
		String text=pagelogin.getAlertMessage();
		String expectedText = "InvalidPasswordException: Password did not conform with policy: Password must have lowercase characters";
		System.out.println(text);
		Assert.assertEquals(text,expectedText);
		System.out.println("AssertEquals Test Passed");
		driver.quit();



	}

	//Regression_scenarios 2 
	/*
	 * Registration functionality with password criteria matching
	 */
	@Given("User try to register again")
	public void user_try_to_register_again() throws InterruptedException 
	{

		lanuchChrome();			
		pagelogin.clickRegister();
	}
	@When("^Enters(.*) , (.*) , (.*), (.*) , (.*)$")
	public void enters (String Login , String FirstName , String LastName, String NPassword, String NConfirmPassword) 
	{

		pagelogin.enterlogin(Login.trim());
		pagelogin.enterfirstName(FirstName);
		pagelogin.enterlasttName(LastName);
		pagelogin.enterpassword(NPassword);
		pagelogin.enterconfirmpassword(NConfirmPassword); 
	}
	@When("click to Register button for Registeration")
	public void click_to_register_button_for_registeration() 
	{

		pagelogin.clickSubmit();

	}
	@Then("Registration is successful and a message will be display")
	public void registration_is_successful_and_a_message_will_be_display() throws InterruptedException 
	{

		String text=pagelogin.getSuccessMessgae();
		String expectedText = "Registration is successful";		
		Assert.assertEquals(text,expectedText);
		System.out.println("AssertEquals Test Passed");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+expectedText+"');");
		Thread.sleep(5000);
		driver.quit();  
	}

	// Regression Scenario 3
	/*
	 * Validate a user can Register once
	 */
	@Given("User tries to register with existing credientals")
	public void user_tries_to_register_with_existing_credientals() throws InterruptedException {
		
		lanuchChrome();		
		pagelogin.clickRegister();
	}


	@When("^Entering existing credienatls (.*) , (.*) , (.*), (.*) , (.*)$")
	public void entering_existing_credienatls(String Login , String FirstName , String LastName, String NPassword, String NConfirmPassword) {
		pagelogin.enterlogin(Login.trim());
		pagelogin.enterfirstName(FirstName);
		pagelogin.enterlasttName(LastName);
		pagelogin.enterpassword(NPassword);
		pagelogin.enterconfirmpassword(NConfirmPassword); 
	}

	@When("Try to submit")
	public void try_to_submit() {

		pagelogin.clickSubmit();
	}
	@Then("Validation should occurs for user can only register once")
	public void validation_should_occurs_for_user_can_only_register_once() {
		String text=pagelogin.getAlertMessage();
		String expectedText = "UsernameExistsException: User already exists";		
		Assert.assertEquals(text,expectedText);
		System.out.println("AssertEquals Test Passed - visitor can only register once");
		driver.quit();

	}

}
