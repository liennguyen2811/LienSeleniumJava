package RailwayTestCase;



import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Common.Ticket;
import Constant.Constant;
import Railway.HomePage;
import Railway.MyTicketPage;


public class ManageTicket {
	
	@BeforeMethod
	public void beforeMethod()
	{
		
		System.out.println("Run beforeMethod");
		System.setProperty("webdriver.chrome.driver",  "D:\\LienNguyen\\SeleniumBasic\\Executables\\chromedriver.exe");
		//Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Run afterMethod");
		
		//Constant.WEBDRIVER.quit();
	}
	
	@Test
	public void TC14()
	{
		System.out.println("User can cancel a ticket");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		homePage.Open().gotoLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
		
		Ticket ticket = new Ticket(Constant.Station.NHATRANG, Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
		
		String actualMsg = homePage.gotoBookTicket().BookTicket(ticket).gotoMyTicketPage().CancelTicket().FilterTicket(ticket.departstation, ticket.arrivestation, "", "")
	            .getMsgNoResulted();
		String expectedMsg = "Sorry, can't find any results that match your filters."+"\n"+"Please change the filters and try again.";
		Assert.assertEquals(expectedMsg, actualMsg, "Ticket still exists");
	} 
	
	@Test
	public void TC15()
	{
		System.out.println("User can filter \"Manager ticket\" table with Depart Station");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		
		Ticket[] ticketArray = new Ticket[6];
	     ticketArray[0] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[1] = new Ticket(Constant.Station.DANANG,Constant.Station.NHATRANG, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[2] = new Ticket(Constant.Station.DANANG,Constant.Station.QUANGNGAI, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[3] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[4] = new Ticket(Constant.Station.DANANG,Constant.Station.HUE, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[5] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
		
		//3. Book more than 6 tickets with different Depart Stations
	     MyTicketPage myTicketPage = new MyTicketPage();
	        myTicketPage =homePage.Open().gotoLoginPage().login(Constant.USERNAME, Constant.PASSWORD)
	            .gotoBookTicket()
	            .BookTicketsPage(ticketArray).gotoMyTicketPage();
	      
	     //5. Select one of booked Depart Station in "Depart Station" dropdown list
	     //6. Click "Apply filter" button
	      
	      String filteredDepartStation = myTicketPage.getMyTicketInfo(2).departstation;
	        myTicketPage.FilterTicket(filteredDepartStation, "", "", "")
	            .checkFilter("MyTable", filteredDepartStation, "Depart Station");  
	        
	        System.out.println("testcase");
	} 
	
	
	@Test
	public void TC16()
	{
		System.out.println("User can filter \"Manager ticket\" table with Depart Date");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		
		 Ticket[] ticketArray = new Ticket[6];
	     ticketArray[0] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[1] = new Ticket(Constant.Station.DANANG,Constant.Station.NHATRANG, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[2] = new Ticket(Constant.Station.DANANG,Constant.Station.QUANGNGAI, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[3] = new Ticket(Constant.Station.SAIGON,Constant.Station.NHATRANG, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[4] = new Ticket(Constant.Station.DANANG,Constant.Station.HUE, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[5] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
		
		//3. Book more than 6 tickets with different Depart Stations
	     MyTicketPage myTicketPage = new MyTicketPage();
	        myTicketPage =homePage.Open().gotoLoginPage().login(Constant.USERNAME, Constant.PASSWORD)
	            .gotoBookTicket()
	            .BookTicketsPage(ticketArray).gotoMyTicketPage();
	      
	     //5. Select one of booked Depart Station in "Depart Station" dropdown list
	     //6. Click "Apply filter" button
	      
	      String filteredDepartDate = myTicketPage.getMyTicketInfo(2).departdate;
	        myTicketPage.FilterTicket("", "", filteredDepartDate, "")
	            .checkFilter("MyTable", filteredDepartDate, "Depart Date");  
	} 
	
	@Test
	public void TC17()
	{
		System.out.println("User can't filter \"Manage ticket\" table when choosing value of \"Status\" doesn't exist in \"Manage ticket\" table");
		// Navigate to QA Railway Website
		HomePage homePage = new HomePage();
		
		 Ticket[] ticketArray = new Ticket[6];
	     ticketArray[0] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[1] = new Ticket(Constant.Station.DANANG,Constant.Station.NHATRANG, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[2] = new Ticket(Constant.Station.DANANG,Constant.Station.QUANGNGAI, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[3] = new Ticket(Constant.Station.SAIGON,Constant.Station.HUE, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[4] = new Ticket(Constant.Station.DANANG,Constant.Station.HUE, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
	     ticketArray[5] = new Ticket(Constant.Station.DANANG,Constant.Station.SAIGON, Constant.SeatType.SOFTBEDWITHAIR,"5/10/2017", 1);
		
		//3. Book more than 6 tickets with different Depart Stations
	     MyTicketPage myTicketPage = new MyTicketPage();
	        myTicketPage =homePage.Open().gotoLoginPage().login(Constant.USERNAME, Constant.PASSWORD)
	            .gotoBookTicket()
	            .BookTicketsPage(ticketArray).gotoMyTicketPage();;
	      
	     //5. Select one of booked Depart Station in "Depart Station" dropdown list
	     //6. Click "Apply filter" button
	      
	        String filteredStatus = "Paid";
	        String actualMsg = myTicketPage.FilterTicket("", "", "", filteredStatus).getMsgNoResulted();
	        String expectedMsg = "Sorry, can't find any results that match your filters."+"\n"+"Please change the filters and try again.";
	        Assert.assertEquals(actualMsg, expectedMsg,"Test case is failed");
		} 
}
