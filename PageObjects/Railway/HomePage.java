package Railway;

import org.openqa.selenium.WebDriver;


import Constant.Constant;


public class HomePage extends GeneralPage{
	WebDriver driver;

	// Locators
	// Elements;
	// Methods
	
	public HomePage Open()
	{
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
	
	
}
