package Common;

import Constant.Constant;

public class Ticket {
	
	// Fields
	public String departdate;
	public String departstation;
	public String arrivestation;
	public String seattype;
	public int ticketamount;
	
	 public void setDepartdate (String departdate)
	    {
	        this.departdate= departdate;
	    }
	 
	 public String getDepartdate()
	    {
	        return this.departdate;
	    }
	 
	 public void setDepartstation (String departstation)
	    {
	        this.departstation= departstation;
	    }
	 
	 public String getDepartstation()
	    {
	        return this.departstation;
	    }
	
	 public void setArrivestation (String arrivestation)
	    {
	        this.arrivestation= arrivestation;
	    }
	 
	 public String getArrivestation()
	    {
	        return this.arrivestation;
	    }
	 
	 public void setSeattype (String seattype)
	    {
	        this.seattype= seattype;
	    }
	 
	 public String getSeattype()
	    {
	        return this.seattype;
	    }
	 
	 public void setticketamount (int ticketamount)
	    {
	        this.ticketamount= ticketamount;
	    }
	 
	 public int getTicketamount()
	    {
	        return this.ticketamount;
	    }	 
	 public Ticket() { super();}
	 
	 // Method
	 public Ticket GenerateTicket()
     {
         this.departdate = CommonMethods.GenerateDepartDate(3, 8, "M/d/yyyy");
         this.departstation = CommonMethods.GenerateStation();
         this.seattype = CommonMethods.GenerateSeatType();
         this.ticketamount = 1;
        // this.ArriveStation = Constant.stations[this.DepartFrom][new Random().Next(Constant.stations[this.DepartFrom].Count())];

         return this;
     }


	 
	 public Ticket(Constant.Station departstation, Constant.Station arrivestation, Constant.SeatType seattype, int ticketamount)
     {
         this.departstation = CommonMethods.TranslateStation(departstation);
         this.arrivestation = CommonMethods.TranslateStation(arrivestation);
         this.departdate = CommonMethods.GenerateDepartDate(3, 8, "M/d/yyyy");
         //this.departdate = CommonMethods.getRandomDateInRange(3, 8, "M/d/yyyy");
         this.seattype = CommonMethods.TranslateSeatType(seattype);
         this.ticketamount = ticketamount;
     }
	 
	 public Ticket(Constant.Station departstation, Constant.Station arrivestation, Constant.SeatType seattype,String Date, int ticketamount)
     {
         this.departstation = CommonMethods.TranslateStation(departstation);
         this.arrivestation = CommonMethods.TranslateStation(arrivestation);
         this.departdate = Date;
         this.seattype = CommonMethods.TranslateSeatType(seattype);
         this.ticketamount = ticketamount;
     }
}
