package Railway;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import Common.Ticket;
import Constant.Constant;

public class BookTicketPage extends GeneralPage {
	
	// Locator
		private final By cmbDepartDate = By.xpath("//select[@name='Date']");
		private final By cmbDepartStation = By.xpath("//select[@name='DepartStation']");
		private final By cmbArriveStation = By.xpath("//select[@name='ArriveStation']");
		private final By cmbSeatType = By.xpath("//select[@name='SeatType']");
		private final By cmbTicketAmount = By.xpath("//select[@name='TicketAmount']");
		private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");

		// Elements
		protected WebElement getCmbDepartDate(){
			return Constant.WEBDRIVER.findElement(cmbDepartDate);
		}
		
		protected WebElement getCmbDepartStation(){
			return Constant.WEBDRIVER.findElement(cmbDepartStation);
		}
		
		protected WebElement getCmbArriveStation(){
			return Constant.WEBDRIVER.findElement(cmbArriveStation);
		}
		
		protected WebElement getCmbSeatType(){
			return Constant.WEBDRIVER.findElement(cmbSeatType);
		}
		
		protected WebElement getCmbTicketAmount(){
			return Constant.WEBDRIVER.findElement(cmbTicketAmount);
		}
		
		protected WebElement getbtnBookTicket(){
			return Constant.WEBDRIVER.findElement(btnBookTicket);
		}
		
		// Methods
		
		public BookTicketPage gotoGetBookTicket()
		{
			this.getbtnBookTicket().click();
			return new BookTicketPage();
		}
		
		 public BookTicketPage BookTicket(Ticket ticket)
	        {
			 
			 new Select(Constant.WEBDRIVER.findElement(By.name("Date"))).selectByVisibleText(ticket.departdate);
			 new Select(Constant.WEBDRIVER.findElement(By.name("DepartStation"))).selectByVisibleText(ticket.departstation);
			 
			 try {
				   TimeUnit.SECONDS.sleep(3);
				  } catch (InterruptedException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			  }
			 
			 new Select(Constant.WEBDRIVER.findElement(By.name("ArriveStation"))).selectByVisibleText(ticket.arrivestation);
			 new Select(Constant.WEBDRIVER.findElement(By.name("SeatType"))).selectByVisibleText(ticket.seattype);
			 new Select(Constant.WEBDRIVER.findElement(By.name("TicketAmount"))).selectByVisibleText(Integer.toString(ticket.ticketamount));
			 
			 getbtnBookTicket().click();
			 return this;
 
	        }
		 
		 public BookTicketPage BookTicketLowLevel (String date, String departstation, String arrivestation,String seattype, String ticketamount)
	        {
			 new Select(Constant.WEBDRIVER.findElement(By.name("Date"))).selectByVisibleText(date);
			 new Select(Constant.WEBDRIVER.findElement(By.name("DepartStation"))).selectByVisibleText(departstation);
			 
			 try {
				   TimeUnit.SECONDS.sleep(3);
				  } catch (InterruptedException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			  }
			 
			 new Select(Constant.WEBDRIVER.findElement(By.name("ArriveStation"))).selectByVisibleText(arrivestation);
			 new Select(Constant.WEBDRIVER.findElement(By.name("SeatType"))).selectByVisibleText(seattype);
			 new Select(Constant.WEBDRIVER.findElement(By.name("TicketAmount"))).selectByVisibleText(ticketamount);
			 
			 getbtnBookTicket().click();
			 return this;
	        }
	        
		 public Ticket getBookedTicketInfo()
	        {
	            Ticket ticket = new Ticket();
	            String tableName = "MyTable WideTable";

	            ticket.departstation = GetTableCellValue(tableName, 2, "Depart Station");
	            ticket.arrivestation = GetTableCellValue(tableName, 2, "Arrive Station");
	            ticket.seattype = GetTableCellValue(tableName, 2, "Seat Type");
	            ticket.departdate = GetTableCellValue(tableName, 2, "Depart Date");
	            ticket.ticketamount = Integer.parseInt(GetTableCellValue(tableName, 2, "Amount"));

	            return ticket;
	        }
		 public Ticket getSelectedTicketInfo()
	        {
	            Ticket ticket = new Ticket();
	            ticket.departdate = new Select(Constant.WEBDRIVER.findElement(By.name("Date"))).getFirstSelectedOption().getText();
	            ticket.departstation = new Select(Constant.WEBDRIVER.findElement(By.name("DepartStation"))).getFirstSelectedOption().getText();
	            ticket.arrivestation = new Select(Constant.WEBDRIVER.findElement(By.name("ArriveStation"))).getFirstSelectedOption().getText();
	            ticket.seattype = new Select(Constant.WEBDRIVER.findElement(By.name("SeatType"))).getFirstSelectedOption().getText();
	            String ticketamountS = new Select(Constant.WEBDRIVER.findElement(By.name("SeatType"))).getFirstSelectedOption().getText();
	            ticket.ticketamount = Integer.parseInt(ticketamountS);

	            return ticket;
	        }
		 
		 public BookTicketPage BookTicketsPage(Ticket[] ticketlist)
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
	            return new BookTicketPage();

	        }
}

