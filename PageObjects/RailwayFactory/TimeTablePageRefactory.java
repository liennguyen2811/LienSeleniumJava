package RailwayFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constant.Constant;

public class TimeTablePageRefactory extends GeneralPageRefactory{
	WebDriver driver;
	@FindBy(xpath = "//a[@href='TrainTimeListPage.cshtml']")
	WebElement timeTable;
	
	// Methods private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
	public TimeTablePageRefactory(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	public void goToTimetable()
	{
		timeTable.click();

	}
	
	public void BookTicketFromTimetable(String departStation, String arriveStation)
    {
        //Select trip            
		String xpath= "//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/following-sibling::td[.='book ticket']";
		driver.findElement(By.xpath(xpath)).click();

        //Land on Book Ticket page

    }

    public void CheckPriceFromTimetable(String departStation, String arriveStation)
    {
       //Select trip  
    	
    	String xpath= "//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/following-sibling::td[.='check price']";
    	driver.findElement(By.xpath(xpath)).click();

    }
}
