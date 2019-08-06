package Common;



import Constant.Constant;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;




import java.awt.List;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommonMethods {
	
	 public static int getRandomNumberInRange(int min, int max)
     {
//		 Random rand = new Random();
//		 int randomNum = rand.nextInt((1000 - 100) + 1) + 100;
//		  return randomNum;
		 Random rand = new Random();
		// nextInt as provided by Random is exclusive of the top value so you need to add 1 
		int randomNum = rand.nextInt((max - min) + 1) + min;
		  return randomNum;
     }
	 
	 public static int GenerateRandomNumberEmail()
     {
		 Random rand = new Random();
		 int randomNum = rand.nextInt((100 - 10) + 1) + 10;
		  return randomNum;
     }
	 
	 public static String GenerateRandomString()
     {
		 return "liennguyen" + GenerateRandomNumberEmail();
     }
	 
	 public static String GenerateRandomEmail()
     {
         return "railway.ticket1" + GenerateRandomNumberEmail() + "@gmail.com";
     }
	 
//	 
	 public static String getRandomDateInRange(int min, int max, String dateFormat) {
			int randomNumber = getRandomNumberInRange(min, max);

			long millis = System.currentTimeMillis();
			Date date = new java.util.Date(millis);

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, randomNumber);
			date = cal.getTime();

			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			String randomDate = formatter.format(date);
			return randomDate;
		}
	 public static String GenerateStation()
	    {   
			Random rnd = new Random();
	        List list = new List();
	        
	        list.add(TranslateStation(Constant.Station.SAIGON));	        
	        list.add(TranslateStation(Constant.Station.PHANTHIET));
	        list.add(TranslateStation(Constant.Station.NHATRANG));
	        list.add(TranslateStation(Constant.Station.DANANG));
	        list.add(TranslateStation(Constant.Station.HUE));
	        list.add(TranslateStation(Constant.Station.QUANGNGAI));

	        String randomStation = list.getItem(rnd.nextInt(list.countItems()));
	        return randomStation;
	    }
	 public static String GenerateSeatType()
     {
         Random rnd = new Random();
         List list = new List();;
         list.add(TranslateSeatType(Constant.SeatType.HARDSEAT));
         list.add(TranslateSeatType(Constant.SeatType.SOFTSEAT));
         list.add(TranslateSeatType(Constant.SeatType.SOFTSEATWITHAIR));
         list.add(TranslateSeatType(Constant.SeatType.HARDBED));
         list.add(TranslateSeatType(Constant.SeatType.SOFTBED));
         list.add(TranslateSeatType(Constant.SeatType.SOFTBEDWITHAIR));

         String randomSeatType = list.getItem(rnd.nextInt(list.countItems()));
         return randomSeatType;

     }
	 public static String GenerateDepartDate(int min, int max, String dateFormat) {
			int randomNumber = getRandomNumberInRange(min, max);

			long millis = System.currentTimeMillis();
			Date date = new java.util.Date(millis);

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, randomNumber);
			date = cal.getTime();

			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			String randomDate = formatter.format(date);
			return randomDate;

     }
		
	 public static String TranslateStation(Constant.Station station)
     {
         String result = "";
         if (station == Constant.Station.SAIGON)
         {
             result = "Sài Gòn";
         }
         else if (station == Constant.Station.PHANTHIET)
         {
             result = "Phan Thiết";
         }
         else if (station == Constant.Station.NHATRANG)
         {
             result = "Nha Trang";
         }
         else if (station == Constant.Station.DANANG)
         {
             result = "Đà Nẵng";
         }
         else if (station == Constant.Station.HUE)
         {
             result = "Huế";
         }
         else if (station == Constant.Station.QUANGNGAI)
         {
             result = "Quảng Ngãi";
         }
         return result;
     }
	 
	 public static String TranslateSeatType(Constant.SeatType seattype)
     {
         String result = "";
         if (seattype == Constant.SeatType.HARDBED)
         {
             result = "Hard bed";
         }
         else if (seattype == Constant.SeatType.SOFTSEAT)
         {
             result = "Soft seat";
         }
         else if (seattype == Constant.SeatType.SOFTSEATWITHAIR)
         {
             result = "Soft seat with air conditioner";
         }
         else if (seattype == Constant.SeatType.SOFTBED)
         {
             result = "Soft bed";
         }
         else if (seattype == Constant.SeatType.SOFTBEDWITHAIR)
         {
             result = "Soft bed with air conditioner";
         }

         return result;
     }
	
}
