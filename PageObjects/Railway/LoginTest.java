package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Constant.Constant;

public class LoginTest {

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
	public void TC01()
	{
		System.out.println("TC01- User can login Railway with valid username and password");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open();
		
		// Click on "Login" tap
		LoginPage loginPage= homePage.gotoLoginPage();
		
		
		// Enter valid Email and Password
		// Click on "Login" button. User is logged into Railway
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessaged();
		String expectedMsg= "Welcome " + Constant.USERNAME;
		
		// VP: Welcome message is displayed
		Assert.assertEquals(actualMsg, expectedMsg,"Welcome message is not displayed");
	}
	
	@Test
	public void TC02(){
	System.out.println("TC02 - User can't login with blank 'Username' textbox");
	  //1. Navigate to QA Railway Website
	  HomePage homePage = new HomePage();
	  homePage.Open();
	 
	  //2. Click on "Login" tab
	  LoginPage loginPage = homePage.gotoLoginPage();
	 
	  //3. User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox
	  //4. Click on "Login" button. User can't login
	  
	  String actualErrorMsg = loginPage.login("", Constant.PASSWORD).getLbNonPassWordInputed();
	  String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
	 
	  //VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Test cases is failed");
	 }
	
	@Test
	public void TC03(){
		System.out.println("TC02 - User cannot log into Railway with invalid password ");
		//1. Navigate to QA Railway Website
		  HomePage homePage = new HomePage();
		  homePage.Open();
		 
		  //2. Click on "Login" tab
		  LoginPage loginPage = homePage.gotoLoginPage();
		 
		  //3. Enter valid Email and invalid Password
		  //4. Click on "Login" button
		  String actualErrorMsg = loginPage.login (Constant.USERNAME,"111").getLbNonPassWordInputed();
		  String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
		 
		  //VP: Message "There was a problem with your login and/or errors exist in your form. " appears.
		  Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
	@Test
	public void TC04(){
		System.out.println("TC02 - User cannot log into Railway with invalid password ");
		//1. Navigate to QA Railway Website
		  HomePage homePage = new HomePage();
		  homePage.Open();
		 
		  //2. Click on "Login" tab
		  LoginPage loginPage = homePage.gotoLoginPage();
		 
		  // 3. Enter non Email and valid Password
          // 4. Click on "Login" button
          // VP. ser can't login and message "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes." appears.
		  
		  String actualErrorMsg = "";
          for (int i = 0; i < 4; i++)
          {
        	  loginPage.login (Constant.USERNAME,"111").getLbNonPassWordInputed();
          }
		  
          actualErrorMsg = loginPage.login (Constant.USERNAME,"111").getLbNonPassWordInputed();
		  String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		 
		  //VP: You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.
		  Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Test case is failed");
	}
	
}
