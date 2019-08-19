package RailwayTestCaseRefactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.Constant;
import Common.GmailHelper;
import PDFEmail.BaseClass;
import RailwayFactory.HomePageRefactory;
import RailwayFactory.LoginPageRefactory;
import reporter.JyperionListener;

@Listeners(JyperionListener.class)
public class LoginTestRefactory extends BaseClass {
	
	WebDriver driver;

	LoginPageRefactory loginPage;
	

	HomePageRefactory homePage;

//	@BeforeMethod
//	public void beforeMethod()
//	{
//		
//		System.out.println("Run beforeMethod");
//		
//		System.setProperty("webdriver.chrome.driver",  "F:\\Lien Disk D\\Selenium\\SeleniumBasic\\Executables\\chromedriver.exe");
//		Constant.WEBDRIVER = new ChromeDriver();
//		Constant.WEBDRIVER.manage().window().maximize();
//	}

	@BeforeMethod

	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http://192.168.170.195:4444/wd/hub"), DesiredCapabilities.chrome());
		// WebDriver driver = new ChromeDriver();
		// WebDriver driver =

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://18.136.107.136/Account/Login.cshtml");

	}
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("Run afterTest");
		driver.quit();
	}

	@Test
	public void TC01() {
		System.out.println("TC01- User can login Railway with valid username and password");

		loginPage = new LoginPageRefactory(driver);
		// Enter valid Email and Password
		// Click on "Login" button. User is logged into Railway
		loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD);
		String actualMsg = loginPage.getloginWelMessage();
		// String actualMsg = loginPage.login(Constant.USERNAME,
		// Constant.PASSWORD).getWelcomeMessaged();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		

		// VP: Welcome message is displayed
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed");
	}

	@Test
	public void TC02() {
		System.out.println("TC02 - User can't login with blank 'Username' textbox");
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		loginPage = new LoginPageRefactory(driver);

		// 3. User doesn't type any words into "Username" textbox but enter valid
		// information into "Password" textbox
		// 4. Click on "Login" button. User can't login

		loginPage.loginTest("", Constant.PASSWORD);
		String actualErrorMsg = loginPage.getNonPassWordInput();
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

		// VP: Message "There was a problem with your login and/or errors exist in your
		// form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Test cases is failed");
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password ");
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		loginPage = new LoginPageRefactory(driver);

		// 3. Enter valid Email and invalid Password
		// 4. Click on "Login" button
		loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD + 11);
		String actualErrorMsg = loginPage.getNonPassWordInput();
		String expectedErrorMsg = "Invalid username or password. Please try again.";

		// VP: Message "There was a problem with your login and/or errors exist in your
		// form. " appears.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Test case is failed");
	}

	@Test
	public void TC04() {
		System.out.println("TC04 - User cannot log into Railway with invalid password ");
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		loginPage = new LoginPageRefactory(driver);

		// 3. Enter non Email and valid Password
		// 4. Click on "Login" button
		// VP. User can't login and message "You have used 4 out of 5 login attempts.
		// After all 5 have been used, you will be unable to login for 15 minutes." appears.

		for (int i = 0; i < 5; i++) {

			loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD + 11);
			loginPage.getNonPassWordInput();
		}

		
		String actualErrorMsg = loginPage.getNonPassWordInput();
		String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		// VP: You have used 4 out of 5 login attempts. After all 5 have been used, you
		// will be unable to login for 15 minutes.
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Test case is failed");
	}

	@AfterSuite
	public void tearDown(){
		GmailHelper.sendPDFReportByGMail("thanhletraining01@gmail.com", "logigear123", "liennguyen2811@gmail.com", "PDF Report", "");
	}
	
	
}
