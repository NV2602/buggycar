package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class buggylogin {

	/*
	 * All locators for buggy car registration page are maintained 
	 */
		
	WebDriver driver =null;
	private By txt_login = By.id("username");
	private By txt_firstName = By.id("firstName");
	private By txt_lastName = By.id("lastName");
	private By txt_password = By.id("password");
	private By txt_confirmPassword = By.id("confirmPassword");
	private By btn_Register = By.linkText("Register");
	private By btn_Submit = By.xpath("//button[text()='Register']");
	private By alert_message= By.xpath("//div[@class='result alert alert-danger']");
	private By alert_success =By.xpath("//div[@class='result alert alert-success']");

	public buggylogin(WebDriver driver) {

		this.driver =driver;
	}

	public void enterlogin(String login)
	{
		driver.findElement(txt_login).sendKeys(login);
	}

	public void enterfirstName(String firstName)
	{
		driver.findElement(txt_firstName).sendKeys(firstName);
	}

	public void enterlasttName(String lastName)
	{
		driver.findElement(txt_lastName).sendKeys(lastName);
	}

	public void enterpassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}

	public void enterconfirmpassword(String confirmpassword)
	{
		driver.findElement(txt_confirmPassword).sendKeys(confirmpassword);
	}

	public void clickRegister()
	{
		driver.findElement(btn_Register).click();
	}
	public void clickSubmit()
	{
		driver.findElement(btn_Submit).click();
	}
	public String getAlertMessage()
	{
		String strAlert = driver.findElement(alert_message).getText();
		return strAlert;
	}
	public String getSuccessMessgae()
	{
		String strAlertSuccess = driver.findElement(alert_success).getText();
		return strAlertSuccess;
	}

}
