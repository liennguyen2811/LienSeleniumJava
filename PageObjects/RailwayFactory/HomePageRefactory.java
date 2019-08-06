package RailwayFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Constant.Constant;


public class HomePageRefactory extends GeneralPageRefactory{
	WebDriver driver;

	// Locators
	// Elements;
	// Methods
	
	public HomePageRefactory(WebDriver driver) {
	    this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}

	public HomePageRefactory Open()
	{
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
}
