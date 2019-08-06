package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class TimeTablePage extends GeneralPage {

	// Methods
	
	public BookTicketPage BookTicketFromTimetable(String departStation, String arriveStation)
    {
        //Select trip            
		String xpath= "//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/following-sibling::td[.='book ticket']";
		Constant.WEBDRIVER.findElement(By.xpath(xpath)).click();

        //Land on Book Ticket page
        return new BookTicketPage();
    }

    public TicketPricePage CheckPriceFromTimetable(String departStation, String arriveStation)
    {
        //Select trip  
    	
    	String xpath= "//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/following-sibling::td[.='check price']";
    	Constant.WEBDRIVER.findElement(By.xpath(xpath)).click();

        //Land on Book Ticket page
        return new TicketPricePage();
    }
}
