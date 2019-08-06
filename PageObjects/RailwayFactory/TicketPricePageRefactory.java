package RailwayFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TicketPricePageRefactory extends GeneralPageRefactory{
	
	WebDriver driver;
	
	public TicketPricePageRefactory(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	 public void BookTicketFromTicketPrice(String departstation, String arrivestation, String seattype)
    {
        String train = departstation + " to " + arrivestation;
      //  String xpathCheckPrice = "//table[@class='NoBorder']//td[.='"+train+"']/following-sibling::td[.='Check Price']";
        String xpathCheckPrice= "//td[.='"+departstation+"']/following-sibling::td[.='"+arrivestation+"']/following-sibling::td[.='check price']";
        driver.findElement(By.xpath(xpathCheckPrice)).click();

        String xpathBookTicket = "//table[@class='NoBorder']//td[.='"+seattype+"']/following-sibling::td[.='Book ticket']";
        driver.findElement(By.xpath(xpathBookTicket)).click();

    }

}
