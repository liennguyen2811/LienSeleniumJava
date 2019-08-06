package RailwayFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.Account;
import Common.GmailHelper;
import Common.Ticket;


public class RegisterPageRefactory extends GeneralPageRefactory {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//input[@id='password']")
	WebElement Pasword;
	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement confirmPassword;
	@FindBy(xpath = "//input[@id='pid']")
	WebElement PID;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement Register;
	@FindBy(xpath = "//div[@id='menu']//a[@href='/Account/Register.cshtml']")
	WebElement tabRegister;
	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement thankMessage;

	public RegisterPageRefactory(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Locator
	//private final By lbThankMessage = By.xpath("//div[@id='content']//h1");
//	private final By txtEmail = By.xpath("//input[@id='email']");
//	private final By txtPasword = By.xpath("//input[@id='password']");
//	private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
//	private final By txtPID = By.xpath("//input[@id='pid']");
//	private final By btnRegister = By.xpath("//input[@value='Register']");

	// Elements

//		protected WebElement getTxtEmail(){
//			return Constant.WEBDRIVER.findElement(txtEmail);
//		}
//		
//		protected WebElement getTxtPasword(){
//			return Constant.WEBDRIVER.findElement(txtPasword);
//		}
//
//		protected WebElement getTxtConfirmPassword(){
//			return Constant.WEBDRIVER.findElement(txtConfirmPassword);
//		}
//		
//		protected WebElement getTxtPID(){
//			return Constant.WEBDRIVER.findElement(txtPID);
//		}
//		
//		protected WebElement getBtnRegister(){
//			return Constant.WEBDRIVER.findElement(btnRegister);
//		}

	// Methods
	public void activateAccount(String username) {
		String findMsg = "Please confirm your account " + username;
		String activeLink = GmailHelper.getLinkContent(findMsg);
		System.out.println(activeLink);
		driver.navigate().to(activeLink);
		driver.get("http://18.136.107.136/Account/Login.cshtml");
	}
	
	
	public String getThankMessage()
	{
		return thankMessage.getText();
	}

	public void goToRegister() {
		System.out.println("goToRegister");

		tabRegister.click();

	}

	public RegisterPageRefactory RegisterAccount(Account account) {

		Email.sendKeys(account.email);

		Pasword.sendKeys(account.password);
		System.out.println(account.password);
		confirmPassword.sendKeys(account.password);
		System.out.println(account.password);
		//try {
//	        Thread.sleep(10*1000);
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }
		System.out.println(account.regPID);
		PID.sendKeys(account.regPID);
		Register.click();

		return this;
	}

	public Ticket getBookedTicketInfo() {
		Ticket ticket = new Ticket();
		String tableName = "MyTable WideTable";

		ticket.departdate = GetTableCellValue(tableName, 2, "Depart Station");
		ticket.arrivestation = GetTableCellValue(tableName, 2, "Arrive Station");
		ticket.seattype = GetTableCellValue(tableName, 2, "Seat Type");
		ticket.departstation = GetTableCellValue(tableName, 2, "Depart Date");
		ticket.ticketamount = Integer.parseInt(GetTableCellValue(tableName, 2, "Amount"));

		return ticket;
		
	}
}