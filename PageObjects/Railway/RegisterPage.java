package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Account;
import Common.Ticket;
import Constant.Constant;

public class RegisterPage extends GeneralPage {
	// Locator
	private final By txtEmail = By.xpath("//input[@id='email']");
	private final By txtPasword = By.xpath("//input[@id='password']");
	private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By txtPID = By.xpath("//input[@id='pid']");
	private final By btnRegister = By.xpath("//input[@value='Register']");
	
	// Elements
	
		protected WebElement getTxtEmail(){
			return Constant.WEBDRIVER.findElement(txtEmail);
		}
		
		protected WebElement getTxtPasword(){
			return Constant.WEBDRIVER.findElement(txtPasword);
		}

		protected WebElement getTxtConfirmPassword(){
			return Constant.WEBDRIVER.findElement(txtConfirmPassword);
		}
		
		protected WebElement getTxtPID(){
			return Constant.WEBDRIVER.findElement(txtPID);
		}
		
		protected WebElement getBtnRegister(){
			return Constant.WEBDRIVER.findElement(btnRegister);
		}
		
		// Methods
		
		 public RegisterPage RegisterAccount(Account account){

			 this.getTxtEmail().sendKeys(account.email);
			 this.getTxtPasword().sendKeys(account.password);
			 this.getTxtConfirmPassword().sendKeys(account.confirmpassword);
			 this.getTxtPID().sendKeys(account.regPID);
			 this.getBtnRegister().click();

             return this;
         }
		 
		 public Ticket getBookedTicketInfo()
	        {
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