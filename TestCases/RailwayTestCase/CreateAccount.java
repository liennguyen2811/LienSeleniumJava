package RailwayTestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Account;
import Constant.Constant;
import Railway.ChangePasswordPage;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.RegisterPage;

public class CreateAccount {
	@BeforeMethod
	public void beforeMethod()
	{
		
		System.out.println("Run beforeMethod");
		
		System.setProperty("webdriver.chrome.driver",  "D:\\LienNguyen\\SeleniumBasic\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Run afterMethod");
		
		//Constant.WEBDRIVER.quit();
	}
	
	@Test
	public void TC05()
	{
		System.out.println("User can create new account");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open();
		
		// Click on "Register" tab
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		//3. Enter valid information into all fields
        //4. Click on Resgiter button
		Account account = new Account();
        account.GenerateData();
        registerPage = registerPage.RegisterAccount(account);
		
      //VP. New account is created and message "Thank you for registering your account" appears
		String actualMsg = registerPage.getLbThankMessaged();
		String expectedMsg= "Thank you for registering your account";
		
		// VP: Welcome message is displayed
		Assert.assertEquals(actualMsg, expectedMsg,"Test case is failed");
	}
	@Test
	public void TC06()
	{
		System.out.println("User can't login with account hasn't been activated");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open();
		
		// Click on "Register" tab
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		//3. Enter valid information into all fields
        //4. Click on Resgiter button
		Account account = new Account();
        account.GenerateData();
        registerPage = registerPage.RegisterAccount(account);
        
        homePage.Open();

		
      //VP. New account is created and message "Thank you for registering your account" appears
        String actualErrorMsg = homePage.gotoLoginPage().login(account.email, account.password).getLbNonPassWordInputed();
		 String expectedErrorMsg = "Invalid username or password. Please try again.";
		 
		//VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
	
	//@Test
	public void TC07()
	{
		System.out.println("User can change password");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open();
		
		// 2. Login with valid Email and Password
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        
        //3. Click on "Change Password" tab
        ChangePasswordPage changePasswordpage = homePage.gotoChangePassword();
		
        //4. Enter valid value into all fields.
        //VP. New account is created and message "Thank you for registering your account" appears
        String actualErrorMsg = changePasswordpage.ChangePassword("liennguyen1","liennguyen","liennguyen").getLbPasswordchangedoned();
		String expectedErrorMsg = "Your password has been updated!";
		 
		//VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
		
	@Test
	public void TC08()
	{
		System.out.println("User can't create account with \"Confirm password\" is not the same with \"Password\"");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open();
		
		// Click on "Register" tab
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		//3. Enter valid information into all fields
        //4. Click on Resgiter button
		Account account = new Account();
        account.GenerateData();
        account.password = "a123:\"/{}!@$\\";
        account.confirmpassword = "b456:\"/{}!@$\\";
        registerPage = registerPage.RegisterAccount(account);
		
        //4. Enter valid information into "Current Password" textbox but enter "a123:"/{}!@$\" into "New Password" textbox and "b456:"/{}!@$\" into "Confirm Password" textbox.
        String actualErrorMsg = registerPage.getLbErrorRegisterMessaged();
		String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
		 
		//VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
	
	@Test
	public void TC09()
	{
		System.out.println("User can't create account with \"Confirm password\" is not the same with \"Password\"");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open();
		
		// Click on "Register" tab
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		//3. Enter valid information into all fields except for confirm password
	    //4. Click on Resgiter button
		Account account = new Account();
	    account.GenerateData();
	    account.confirmpassword = "111";
	    registerPage = registerPage.RegisterAccount(account);
        
        String actualErrorMsg = registerPage.getLbErrorRegisterMessaged();
		String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
		 
		//VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
}
