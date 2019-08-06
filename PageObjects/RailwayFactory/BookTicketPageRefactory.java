package RailwayFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import Common.Ticket;


public class BookTicketPageRefactory extends GeneralPageRefactory {
	WebDriver driver;

	@FindBy(xpath = "//select[@name='Date']")
	WebElement departDate;
	@FindBy(xpath = "//select[@name='DepartStation']")
	WebElement departStation;
	@FindBy(xpath = "//select[@name='ArriveStation']")
	WebElement arriveStation;
	@FindBy(xpath = "//select[@name='SeatType']")
	WebElement seatType;
	@FindBy(xpath = "//select[@name='TicketAmount']")
	WebElement ticketAmount;
	@FindBy(xpath = "//input[@value='Book ticket']")
	WebElement bookTicket;
	@FindBy(xpath = "//a[@href='/Page/BookTicketPage.cshtml']")
	WebElement goToBookTicket;
	@FindBy(xpath = "//div[@id='content']//h1[text()='Ticket booked successfully!']")
	WebElement bookTicketMsgSuccess;
	
	
	public BookTicketPageRefactory(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
		// Methods
	public String getBookTicketMsgSuccess()
	{
		return bookTicketMsgSuccess.getText();
	}
		
		public void goToBookTicket()
		{
			goToBookTicket.click();
			
		}
		public boolean CheckInitialTicketInfo(String departFrom, String arriveAt) {
			Select cboDepartFrom = new Select(departStation);
			Select cboArriveAt = new Select(arriveStation);
			
			String strDepartFrom = cboDepartFrom.getFirstSelectedOption().getText();
			System.out.println("Lien-----" + strDepartFrom);
			String strArriveAt = cboArriveAt.getFirstSelectedOption().getText();
			System.out.println("Lien-----" + strArriveAt);
			
			
//			Select cboArriveAt = new Select(getCboArriveAt());
//			String strDepartFrom = cboDepartFrom.getFirstSelectedOption().getText();
//			String strArriveAt = cboArriveAt.getFirstSelectedOption().getText();

			//String strDepartFrom =  new Select(driver.findElement(By.name("DepartStation"))).getFirstSelectedOption().getText();
			//System.out.println("Lien-----" + strDepartFrom);
			//String strArriveAt = new Select(driver.findElement(By.name("ArriveStation"))).getFirstSelectedOption().getText();
			if (strDepartFrom.equals(departFrom) && strArriveAt.equals(arriveAt)) {
				return true;
			}
			return false;
		}
		
		 public BookTicketPageRefactory BookTicket(Ticket ticket)
	        {
			 
			 new Select(departDate).selectByVisibleText(ticket.departdate);
			 new Select(departStation).selectByVisibleText(ticket.departstation);
			 
			 try {
				   TimeUnit.SECONDS.sleep(3);
				  } catch (InterruptedException e) {
				   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 
			 new Select(arriveStation).selectByVisibleText(ticket.arrivestation);
			 new Select(seatType).selectByVisibleText(ticket.seattype);
			 new Select(ticketAmount).selectByVisibleText(Integer.toString(ticket.ticketamount));
			 
			 bookTicket.click();
			 return this;
 
	        }
		 
		 public BookTicketPageRefactory BookTicketLowLevel (String date, String departstation, String arrivestation,String seattype, String ticketamount)
	        {
			 new Select(departDate).selectByVisibleText(date);
			 new Select(departStation).selectByVisibleText(departstation);
			 
			 try {
				   TimeUnit.SECONDS.sleep(3);
				  } catch (InterruptedException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			  }
			 
			 new Select(arriveStation).selectByVisibleText(arrivestation);
			 new Select(seatType).selectByVisibleText(seattype);
			 new Select(ticketAmount).selectByVisibleText(ticketamount);
			 
			 bookTicket.click();
			 return this;
	        }
	        
		 public Ticket getBookedTicketInfo()
	        {
	            Ticket ticket = new Ticket();
	            String tableName = "MyTable WideTable";
	            System.out.println("getBookedTicketInfo-----if go here");

	            ticket.departstation = this.GetTableCellValue(tableName, 2, "Depart Station");
	            ticket.arrivestation = this.GetTableCellValue(tableName, 2, "Arrive Station");
	            ticket.seattype = this.GetTableCellValue(tableName, 2, "Seat Type");
	            ticket.departdate = this.GetTableCellValue(tableName, 2, "Depart Date");
	            ticket.ticketamount = Integer.parseInt(GetTableCellValue(tableName, 2, "Amount"));

	            return ticket;
	        }
		 
		 public String GetTableCellValue(String tablename, int rowindex, String columnname)
	     {
	         String xpath = "//table[@class='"+tablename+"']//tr["+rowindex+"]/td[count(//th[.='"+columnname+"']//preceding-sibling::th) + 1]";
	                    
	         return driver.findElement(By.xpath(xpath)).getText();
	     }
		 public Ticket getSelectedTicketInfo()
	        {
	            Ticket ticket = new Ticket();
	            ticket.departdate = new Select(departDate).getFirstSelectedOption().getText();
	            ticket.departstation = new Select(departStation).getFirstSelectedOption().getText();
	            ticket.arrivestation = new Select(arriveStation).getFirstSelectedOption().getText();
	            ticket.seattype = new Select(seatType).getFirstSelectedOption().getText();
	            String ticketamountS = new Select(ticketAmount).getFirstSelectedOption().getText();
	            ticket.ticketamount = Integer.parseInt(ticketamountS);

	            return ticket;
	        }
		
		 
		 public void BookTicketsPage(Ticket[] ticketlist)
	        {
			 for (Ticket t: ticketlist)
			 {
	                BookTicket(t);
	                try {
	 				   TimeUnit.SECONDS.sleep(3);
	 				  } catch (InterruptedException e) {
	 				   // TODO Auto-generated catch block
	 				   e.printStackTrace();
	 			  }
	                getTabBookTicket().click();
	            }

	        }
}

