package Railway;

import Constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
	
	// Locator
	private final By txtUsername = By.xpath("//input[@id='username']");
	private final By txtPassword = By.xpath("// input[@id= 'password']");
	private final By bntLogin= By.xpath("//input[@value = 'login']");
	private final By lbLoginErrorMsg = By.xpath ("//p[@class = 'message error LoginForm']");
	

	// Element
	 // static readonly By _lbErrorMessage = By.XPath("//p[@class='message error LoginForm']");

	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(txtUsername);
	}

	public WebElement getTxtPassword()
	{
		return Constant.WEBDRIVER.findElement(txtPassword);
	}
	public WebElement getBtbLogin()
	{
		return Constant.WEBDRIVER.findElement(bntLogin);
	}
	public WebElement getLbloginErrorMsg()
	{
		return Constant.WEBDRIVER.findElement(lbLoginErrorMsg);
	}
	
	// Methods
	
	
	public String getLbloginErrorMessage()
	{
		return this.getLbloginErrorMsg().getText();
	}

	public HomePage login (String username,String password)
	{
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtbLogin().click();
		
		// Land on HomePage
		return new HomePage();
	}
}
