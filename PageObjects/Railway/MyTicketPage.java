package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.Ticket;

import java.util.concurrent.TimeUnit;
import Constant.Constant;

public class MyTicketPage extends GeneralPage{

	//Locator
	
	private final By cmbFilterDepartStation = By.xpath("//select[@name='FilterDpStation']");
	private final By cmbFilterArriveStation = By.xpath("//select[@name='FilterArStation']");
	private final By txtFilterDepartDate = By.xpath("//input[@name='FilterDpDate']");
	private final By cmbFilterStatus = By.xpath("//select[@name='FilterStatus']");
	
	private final By btnApplyFilter = By.xpath("//input[@value='Apply filter']");
	private final By msgNoResult = By.xpath("//div[@class='error message']");
	private final By selectorCanclebutton = By.xpath("//table[@class='MyTable']//tr[2]//td[11]//input[@value='Cancel']");
	
	// Elements
	
	protected WebElement getCmbFilterDepartStation(){
		return Constant.WEBDRIVER.findElement(cmbFilterDepartStation);
	}
	
	protected WebElement getCmbFilterArriveStation(){
		return Constant.WEBDRIVER.findElement(cmbFilterArriveStation);
	}

	protected WebElement getTxtFilterDepartDate(){
		return Constant.WEBDRIVER.findElement(txtFilterDepartDate);
	}

	protected WebElement getCmbFilterStatus(){
		return Constant.WEBDRIVER.findElement(cmbFilterStatus);
	}
	
	protected WebElement getBtnApplyFilter(){
		return Constant.WEBDRIVER.findElement(btnApplyFilter);
	}
	
	protected WebElement getMsgNoResult(){
		return Constant.WEBDRIVER.findElement(msgNoResult);
	}
	
	protected WebElement getSelectorCanclebutton(){
		return Constant.WEBDRIVER.findElement(selectorCanclebutton);
	}
	
	// Methods
	public String getMsgNoResulted()
	{
		return this.getMsgNoResult().getText();
	}
	
	 public MyTicketPage CancelTicket()
     {

        // Constant.WebDriver.FindElement(By.XPath("//table[@class='MyTable']//tr[2]/td[count(//th[.='Operation']//preceding-sibling::th) + 1]//input[@value='Cancel']")).Click();
         String xpathx = "//table[@class='MyTable']//tr[2]//td[11]//input[@value='Cancel']";
         WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathx)));
         Constant.WEBDRIVER.findElement(By.xpath(xpathx)).click();

         try {
			   TimeUnit.SECONDS.sleep(4);
			  } catch (InterruptedException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		  }
		
         Constant.WEBDRIVER.switchTo().alert().accept();
         Constant.WEBDRIVER.switchTo().defaultContent();

         return this;
     }
	 
	 
	 public MyTicketPage FilterTicket(String departstation, String arrivestation, String departdate, String status)
     {
         if (departstation != "")
         {
        	 Select DepartStation = new Select(getCmbFilterDepartStation());
        	 DepartStation.selectByVisibleText(departstation);
         }
         if (arrivestation != "")
         {
        	Select ArriveStation = new Select(getCmbFilterArriveStation());
        	ArriveStation.selectByVisibleText(arrivestation);
         }
         if (status != "")
         {
        	 Select Status = new Select(getCmbFilterStatus());
        	 Status.selectByVisibleText(status);
         }
         if (departdate != "")
         {
        	 getTxtFilterDepartDate().sendKeys(departdate);
         }

         getBtnApplyFilter().click();

         return this;
     }
	 
	 public Ticket getMyTicketInfo(int row)
     {
         Ticket ticket = new Ticket();
         String tableName = "MyTable";

         ticket.departstation = GetTableCellValue(tableName, row, "Depart Station");
         ticket.arrivestation = GetTableCellValue(tableName, row, "Arrive Station");
         ticket.seattype = GetTableCellValue(tableName, row, "Seat Type");
         ticket.departdate = GetTableCellValue(tableName, row, "Depart Date");
         ticket.ticketamount = Integer.parseInt(GetTableCellValue(tableName, row, "Amount"));

         return ticket;
     }
	 
	 
	 public void checkFilter(String table, String value, String header)
     {
         for (int count = 2; count < this.GetRowNumber(table); count++)
         {
             Ticket ticket = this.getMyTicketInfo(count);
             
             if (header == "Depart Station")
             {
            	 Assert.assertEquals(value, ticket.departstation, "Inconsistent depart station");
             }
             if (header == "Arrive Station")
             {
            	 Assert.assertEquals(value, ticket.arrivestation, "Inconsistent arrive station");
             }
             if (header == "Depart Date")
             {
            	 Assert.assertEquals(value, ticket.departdate, "Inconsistent depart date");
             }
         }
         
         
}
}