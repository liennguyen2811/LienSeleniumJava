package RailwayFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRefactory extends GeneralPageRefactory {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "// input[@id= 'password']")
	WebElement password;
	@FindBy(xpath = "//input[@value = 'login']")
	WebElement login;
	@FindBy(xpath = "//p[@class = 'message error LoginForm']")
	WebElement loginErrorMsg;
	@FindBy(xpath = "//div[@class= 'account']/strong")
	WebElement loginWelMsg;
	@FindBy(xpath = ".//*[@id='content']/p")
	WebElement loginNonPassMsg;
	@FindBy(xpath = "//div[@id= 'menu']//a[@href = '/Account/Login.cshtml']")
	WebElement tabLogin;

	public LoginPageRefactory(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void gotoLoginPage() {
		tabLogin.click();

	}

	public String getWelcomeMessaged() {
		System.out.println("if go herer");
		System.out.println(this.getLbWelcomeMessage().getText());
		return this.getLbWelcomeMessage().getText();
	}

	public void setUserName(String strUserName) {

		userName.sendKeys(strUserName);
	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	public void clickLogin() {

		login.click();

	}

	public String getloginErrorMessage() {
		return loginErrorMsg.getText();
	}

	public String getNonPassWordInput() {
		return loginNonPassMsg.getText();
	}

	public String getloginWelMessage() {
		return loginWelMsg.getText();
	}

	public void loginTest(String username, String password) {

		this.setUserName(username);
		this.setPassword(password);
		this.clickLogin();

	}

}
