package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {
	
	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "http://18.136.107.136/Account/Login.cshtml";
	public static final String USERNAME = "liennguyenlogigear12@gmail.com";
	public static final String PASSWORD = "liennguyen";
	
	
	// Constant for Mail Service
		public static final String GMAIL_HOST = "pop.gmail.com";
		public static final String GMAIL_STORETYPE = "pop3";
		public static final String GMAIL_USERNAME = "mailto:thanhletraining01@gmail.com";
		public static final String GMAIL_PASSWORD = "logigear123";
 

	public enum Station
    {
        SAIGON,
        PHANTHIET,
        NHATRANG,
        DANANG,
        HUE,
        QUANGNGAI
    }
	public enum SeatType
    {
        HARDSEAT,
        SOFTSEAT,
        SOFTSEATWITHAIR,
        HARDBED,
        SOFTBED,
        SOFTBEDWITHAIR
    }
}
