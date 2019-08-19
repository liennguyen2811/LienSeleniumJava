package Guru99TakeScreenshot;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Guru99TakeScreenshot {
	WebDriver driver;

	@Test
	public void testGuru99TakeScreenShot() throws Exception{
		
		System.setProperty("webdriver.firefox.driver", "F:\\Eclipse\\Driver\\chromedriver_win32\\geckodriver.exe");
		driver = new RemoteWebDriver(new URL("http://192.168.170.195:4444/wd/hub"), DesiredCapabilities.firefox());
		driver.get("http://demo.guru99.com/V4/");
		//Call take screenshot function
		Guru99TakeScreenshot.takeSnapShot(driver, "f://imagefolder//test.png");
		
	}
	
	
	/**
	 * This function will take screenshot
	 * @param webdriver
	 * @param fileWithPath
	 * @throws Exception
	 */
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination 
				File DestFile=new File(fileWithPath);
				//Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);
			
	}

}
