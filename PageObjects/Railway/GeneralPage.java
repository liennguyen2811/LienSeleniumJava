package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	
	// Locator
	private final By tabLogin = By.xpath("//div[@id= 'menu']//a[@href = '/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//div[@id= 'menu']//a[@href = '/Account/Logout.cshtml']");
	private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
	private final By tabChangePassWord = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
	private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
	private final By tabTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
	private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
	

	private final By lbWelcomeMessage = By.xpath("//div[@class= 'account']/strong");
	private final By lbNonPassWordInput = By.xpath(".//*[@id='content']/p");
	private final By lbThankMessage = By.xpath("//div[@id='content']//h1");
	private final By lbPasswordchangedone = By.xpath("//form[@id='ChangePW']/fieldset/p[@class='message success']");
	private final By lbErrorRegisterMessage = By.xpath("//div[@id='content']/p[@class='message error']");
	private final By lbErrorMessageChangePass = By.xpath("//form[@id='ChangePW']/fieldset/p[@class='message error']");
	private final By lblBookTicketMessage = By.xpath("//div[@id='content']//h1[text()='Ticket booked successfully!']");
	private final By lbTicketPriceHeaderMessage = By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th");

	
	// Elements
	protected WebElement getTabLogin(){
		return Constant.WEBDRIVER.findElement(tabLogin);
	}
	
	protected WebElement getTapLogin(){
	
		return Constant.WEBDRIVER.findElement(tabLogout);
	}
	
	protected WebElement getTabRegister(){
		
		return Constant.WEBDRIVER.findElement(tabRegister);	
	}
	
	protected WebElement getTabChangePassWord(){
		
		return Constant.WEBDRIVER.findElement(tabChangePassWord);	
	}
	protected WebElement getTabBookTicket(){
		
		return Constant.WEBDRIVER.findElement(tabBookTicket);	
	}
	
	protected WebElement getTabTimeTable(){
		
		return Constant.WEBDRIVER.findElement(tabTimeTable);	
	}
	
	protected WebElement getLbWelcomeMessage(){
		
		return Constant.WEBDRIVER.findElement(lbWelcomeMessage);	
	}
	
	protected WebElement getLbNonPassWordInput(){
		
		return Constant.WEBDRIVER.findElement(lbNonPassWordInput);	
	}
	protected WebElement getLbThankMessage(){
		
		return Constant.WEBDRIVER.findElement(lbThankMessage);	
	}
	
	protected WebElement getLbPasswordchangedone(){
		
		return Constant.WEBDRIVER.findElement(lbPasswordchangedone);	
	}
	
	protected WebElement getLbErrorRegisterMessage(){
		
		return Constant.WEBDRIVER.findElement(lbErrorRegisterMessage);	
	}
	
	protected WebElement getLbErrorMessageChangePass(){
		
		return Constant.WEBDRIVER.findElement(lbErrorMessageChangePass);	
	}
	
	protected WebElement getLblBookTicketMessage(){
		
		return Constant.WEBDRIVER.findElement(lblBookTicketMessage);	
	}
	
	protected WebElement getLbTicketPriceHeaderMessage(){
		
		return Constant.WEBDRIVER.findElement(lbTicketPriceHeaderMessage);	
	}
	
	protected WebElement getTabTicketPrice(){
		
		return Constant.WEBDRIVER.findElement(tabTicketPrice);	
	}
	
	protected WebElement getTabMyTicket(){
		
		return Constant.WEBDRIVER.findElement(tabMyTicket);	
	}
	
	// Methods
	
	public String getWelcomeMessaged()
	{
		return this.getLbWelcomeMessage().getText();
	}
	public String getLbNonPassWordInputed()
	{
		return this.getLbNonPassWordInput().getText();
	}
	public String getLbThankMessaged()
	{
		return this.getLbThankMessage().getText();
	}
	public String getLbPasswordchangedoned()
	{
		return this.getLbPasswordchangedone().getText();
	}
	
	public String getLbErrorRegisterMessaged()
	{
		return this.getLbErrorRegisterMessage().getText();
	}
	
	public String getLbErrorMessageChangePassed()
	{
		return this.getLbErrorMessageChangePass().getText();
	}
	
	public String getLblBookTicketMessaged()
	{
		return this.getLblBookTicketMessage().getText();
	}
	public String getLbTicketPriceHeaderMessaged()
	{
		return this.getLbTicketPriceHeaderMessage().getText();
	}

	public LoginPage gotoLoginPage()
	{
		this.getTabLogin().click();
		return new LoginPage();
	}
	
	public RegisterPage gotoRegisterPage()
	{
		this.getTabRegister().click();
		return new RegisterPage();
	}
	public ChangePasswordPage gotoChangePassword()
	{
		this.getTabChangePassWord().click();
		return new ChangePasswordPage();
	}
	public TimeTablePage gotoTabTimeTable()
	{
		this.getTabTimeTable().click();
		return new TimeTablePage();
	}
	public BookTicketPage gotoBookTicket()
	{
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}
	
	public TicketPricePage gotoTicketPricePage()
	{
		this.getTabTicketPrice().click();
		return new TicketPricePage();
	}
	public MyTicketPage gotoMyTicketPage()
	{
		this.getTabMyTicket().click();
		return new MyTicketPage();
	}
	
	 public String GetTableCellValue(String tablename, int rowindex, String columnname)
     {
         String xpath = "//table[@class='"+tablename+"']//tr["+rowindex+"]/td[count(//th[.='"+columnname+"']//preceding-sibling::th) + 1]";
                    
         return Constant.WEBDRIVER.findElement(By.xpath(xpath)).getText();
     }
	 
//	 public BookTicketPage BookTicketFromTicketPrice(String departstation, String arrivestation, String seattype)
//     {
//         String train = departstation + " to " + arrivestation;
//         String xpathCheckPrice = "//table[@class='NoBorder']//td[.='"+train+"']/following-sibling::td[.='Check Price']";
//         Constant.WEBDRIVER.findElement(By.xpath(xpathCheckPrice)).click();
//
//         String xpathBookTicket = "//table[@class='NoBorder']//td[.='"+seattype+"']/following-sibling::td[.='Book ticket']";
//         Constant.WEBDRIVER.findElement(By.xpath(xpathBookTicket)).click();
//
//         return new BookTicketPage();
//     }
	 
	 public String GetTableCellValueCheckPrice(String tablename, int rowindex,int colunmeindex, String columnname)
     {
         String xpath = "//table[@class='"+tablename+"']//tr[{1}]/td[count(//th[.='"+rowindex+"']//preceding-sibling::th) + "+columnname+"]";
         return Constant.WEBDRIVER.findElement(By.xpath(xpath)).getText();
     }
	 
	 public int GetRowNumber(String table)
     {
         String xpath = "//table[@class='"+table+"']//tr";
         int rowCount= Constant.WEBDRIVER.findElements(By.xpath(xpath)).size();
         return rowCount;
     }
     public int GetCollumNumber(String table)
     {
    	 String xpath = "//table[@class='"+table+"']//td";
    	 int collumnCount=Constant.WEBDRIVER.findElements(By.xpath(xpath)).size();
         return collumnCount;
     }
}

