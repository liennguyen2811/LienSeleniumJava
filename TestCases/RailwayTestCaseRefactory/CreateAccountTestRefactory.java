package RailwayTestCaseRefactory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Account;
import RailwayFactory.HomePageRefactory;
import RailwayFactory.LoginPageRefactory;
import RailwayFactory.RegisterPageRefactory;

public class CreateAccountTestRefactory {
	WebDriver driver;
	HomePageRefactory homePage;
	LoginPageRefactory loginPage;
	RegisterPageRefactory registerPage;
	
	@BeforeMethod
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http://192.168.170.195:4444/wd/hub"), DesiredCapabilities.chrome());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://18.136.107.136/Account/Login.cshtml");

	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Run afterMethod");	
		driver.quit();
	}

	@Test
	public void TC05()
	{
		System.out.println("User can create new account");
		// Navigate to QA Railway Website
		// Click on "Register" tab
		registerPage = new RegisterPageRefactory(driver);
		registerPage.goToRegister();
	
		
		//3. Enter valid information into all fields
        //4. Click on Resgiter button
		Account account = new Account();
        account.GenerateData();
        registerPage = registerPage.RegisterAccount(account);
		
      //VP. New account is created and message "Thank you for registering your account" appears
		String actualMsg = registerPage.getThankMessage();
		String expectedMsg= "Thank you for registering your account";
		
		// VP: Welcome message is displayey
		Assert.assertEquals(actualMsg, expectedMsg,"Test case is failed");
	}
	
	@Test
	public void TC06()
	{
		System.out.println("User can't login with account hasn't been activated");
		// Navigate to QA Railway Website
		// Click on "Register" tab
		registerPage = new RegisterPageRefactory(driver);
		registerPage.goToRegister();
		
		//3. Enter valid information into all fields
        //4. Click on Resgiter button
		Account account = new Account();
        account.GenerateData();
        registerPage = registerPage.RegisterAccount(account);
        loginPage = new LoginPageRefactory(driver);
        
        loginPage.gotoLoginPage();
        loginPage.loginTest(account.email, account.password);
		
      //VP. New account is created and message "Thank you for registering your account" appears
        String actualErrorMsg = loginPage.getloginErrorMessage();
		 String expectedErrorMsg = "Invalid username or password. Please try again.";
		 
		//VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
	
	
	@Test
	public void TC07()
	{
		System.out.println("User can create new account");
		// Navigate to QA Railway Website
		// Click on "Register" tab
		registerPage = new RegisterPageRefactory(driver);
		registerPage.goToRegister();
		
		//3. Enter valid information into all fields
        //4. Click on Resgiter button
		Account account = new Account();
        account.GenerateData();
        registerPage = registerPage.RegisterAccount(account);
		
      //VP. New account is created and message "Thank you for registering your account" appears
		String actualMsg = registerPage.getThankMessage();
		String expectedMsg= "Thank you for registering your account";
		
		Assert.assertEquals(actualMsg, expectedMsg,"Test case is failed");
		registerPage.activateAccount(account.email);
	
	
	}
	
}
