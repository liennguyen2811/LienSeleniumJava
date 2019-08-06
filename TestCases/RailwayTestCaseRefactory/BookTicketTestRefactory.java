package RailwayTestCaseRefactory;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.URL;

import Common.CommonMethods;
import Common.Ticket;
import Constant.Constant;
import RailwayFactory.BookTicketPageRefactory;
import RailwayFactory.HomePageRefactory;
import RailwayFactory.LoginPageRefactory;
import RailwayFactory.TicketPricePageRefactory;
import RailwayFactory.TimeTablePageRefactory;


public class BookTicketTestRefactory {
	WebDriver driver;
	HomePageRefactory homePage;
	LoginPageRefactory loginPage;
	BookTicketPageRefactory bookTicketPage;
	TimeTablePageRefactory timeTablePage;
	TicketPricePageRefactory ticketPricePage;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http://192.168.170.195:4444/wd/hub"), DesiredCapabilities.chrome());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://18.136.107.136/Account/Login.cshtml");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Run afterMethod");
		
		//driver.quit();
	}
	
	@Test
	public void TC10()
	{
		System.out.println("User can book 1 ticket at a time");
		loginPage = new LoginPageRefactory(driver);
		loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD);
		// Navigate to QA Railway Website
		//3. Click on "Book ticket" tab
		bookTicketPage = new BookTicketPageRefactory(driver);
		bookTicketPage.goToBookTicket();
		
		//4. Select a "Depart date" from the list
        //5. Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
        //6. Select "Soft bed with air conditioner" for "Seat type"
        //7. Select "1" for "Ticket amount"
        //8. Click on "Book ticket" button
        //VP. Message "Ticket booked successfully!" displays. 
        //Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)

        Ticket ticket = new Ticket(Constant.Station.SAIGON, Constant.Station.NHATRANG, Constant.SeatType.SOFTBEDWITHAIR, 1);
        //ticket.departdate = "8/8/2019";
        
        bookTicketPage.BookTicket(ticket);
		
		//bookTicket.BookTicketLowLevel("5/10/2017", "Nha Trang", "Sài Gòn", "Soft bed with air conditioner", "1");
        
        String actualMsg = bookTicketPage.getBookTicketMsgSuccess();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(expectedMsg, actualMsg, "Fail to book ticket");

        Ticket actualTicket = bookTicketPage.getBookedTicketInfo();

        Assert.assertEquals(ticket.departstation, actualTicket.departstation, "Wrong depart station");
        Assert.assertEquals(ticket.arrivestation, actualTicket.arrivestation, "Wrong arrive station");
        Assert.assertEquals(ticket.seattype, actualTicket.seattype, "Wrong seat type");
        Assert.assertEquals(ticket.ticketamount, actualTicket.ticketamount, "Wrong ticket amount");
        Assert.assertEquals(ticket.departdate, actualTicket.departdate, "Wrong date");
	}

	
		@Test
		public void TC11()
		{
			System.out.println("User can book many ticket at a time");
			loginPage = new LoginPageRefactory(driver);
			loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD);
			// Navigate to QA Railway Website
			//3. Click on "Book ticket" tab
			bookTicketPage = new BookTicketPageRefactory(driver);
			bookTicketPage.goToBookTicket();
			
			//4. Select a "Depart date" from the list
	        //5. Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
	        //6. Select "Soft bed with air conditioner" for "Seat type"
	        //7. Select "1" for "Ticket amount"
	        //8. Click on "Book ticket" button
	        //VP. Message "Ticket booked successfully!" displays. 
	        //Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)

	        Ticket ticket = new Ticket(Constant.Station.SAIGON, Constant.Station.NHATRANG, Constant.SeatType.SOFTBEDWITHAIR, 5);
	        
	        bookTicketPage.BookTicket(ticket);
			
			//bookTicket.BookTicketLowLevel("5/10/2017", "Nha Trang", "Sài Gòn", "Soft bed with air conditioner", "1");
	        
	        String actualMsg = bookTicketPage.getBookTicketMsgSuccess();
	        String expectedMsg = "Ticket booked successfully!";
	       Assert.assertEquals(expectedMsg, actualMsg, "Fail to book ticket");

	        Ticket actualTicket = bookTicketPage.getBookedTicketInfo();

	        Assert.assertEquals(ticket.departstation, actualTicket.departstation, "Wrong depart station");
	        Assert.assertEquals(ticket.arrivestation, actualTicket.arrivestation, "Wrong arrive station");
	        Assert.assertEquals(ticket.seattype, actualTicket.seattype, "Wrong seat type");
	        Assert.assertEquals(ticket.ticketamount, actualTicket.ticketamount, "Wrong ticket amount");
	        Assert.assertEquals(ticket.departdate, actualTicket.departdate, "Wrong date");
		}
		
		@Test
		public void TC12()
		{
			System.out.println("User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\"");
			// Navigate to QA Railway Website
			loginPage = new LoginPageRefactory(driver);
			loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD);
			
			//3. Click on "Timetable" tab
			timeTablePage = new TimeTablePageRefactory (driver);
			timeTablePage.goToTimetable();
			//4. Click on "Book ticket" link of the route from "Huế" to "Sài Gòn"
			
			
			 String departstation = CommonMethods.TranslateStation(Constant.Station.HUE);
	         String arrivestation = CommonMethods.TranslateStation(Constant.Station.SAIGON);
	         
	         //TicketPricePage ticketPricePage = timeTablePage.CheckPriceFromTimetable(departstation, arrivestation); 
	         
	         timeTablePage.BookTicketFromTimetable(departstation, arrivestation);
	         
	         bookTicketPage = new BookTicketPageRefactory(driver);
				
	         boolean actualIsDisplay = bookTicketPage.CheckInitialTicketInfo(Common.CommonMethods.TranslateStation(Constant.Station.HUE), Common.CommonMethods.TranslateStation(Constant.Station.SAIGON));
		     Assert.assertTrue(actualIsDisplay, "Initial value of ticket is not correct"); 	
		}
		
		@Test
		public void TC13()
		{
			System.out.println("User can open \"Book ticket\" page by click on \"Book ticket\" link in \"Ticket price\"");
			// Navigate to QA Railway Website
			loginPage = new LoginPageRefactory(driver);
			loginPage.loginTest(Constant.USERNAME, Constant.PASSWORD);
			
			//3. Click on "Timetable" tab
			timeTablePage = new TimeTablePageRefactory (driver);
			timeTablePage.goToTimetable();
			//4. Click on "Check price" link of ticket from "Nha Trang" to "Phan Thiết"
			
			 String departstation = CommonMethods.TranslateStation(Constant.Station.NHATRANG);
	         String arrivestation = CommonMethods.TranslateStation(Constant.Station.SAIGON);
	         String seattype = CommonMethods.TranslateSeatType(Constant.SeatType.SOFTBEDWITHAIR);
	         bookTicketPage = new BookTicketPageRefactory(driver);
	         ticketPricePage = new TicketPricePageRefactory(driver);
	         
	         ticketPricePage.BookTicketFromTicketPrice(departstation, arrivestation, seattype);
				
	         boolean actualIsDisplay = bookTicketPage.CheckInitialTicketInfo(Common.CommonMethods.TranslateStation(Constant.Station.NHATRANG), Common.CommonMethods.TranslateStation(Constant.Station.SAIGON));
		     Assert.assertTrue(actualIsDisplay, "Initial value of ticket is not correct");  
		}


}

