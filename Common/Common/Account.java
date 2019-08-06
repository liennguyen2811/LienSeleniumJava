package Common;

public class Account {
	
	// Fields
	public String email;
	public String password;
	public String confirmpassword;
	public String regPID;

    // Constructor
    public void setEmail (String email)
    {
        this.email= email;
    }
    
    public String getEmail ()
    {
        return this.email;
    }

    public void setPassword (String password)
    {
        this.password= password;
    }
    
    public String getPassword ()
    {
        return this.password;
    }
    
    public void setConfirmpassword (String confirmpassword)
    {
        this.confirmpassword= confirmpassword;
    }
    
    public String getConfirmpassword ()
    {
        return this.confirmpassword;
    }
    
    public void setRegPID (String regPID)
    {
        this.regPID= regPID;
    }
    
    public String getregPID ()
    {
        return this.regPID;
    }
   
    public Account() { super();}

	public void GenerateData()
	{
	    this.email = CommonMethods.GenerateRandomEmail();
	    this.password = CommonMethods.GenerateRandomString();
	    this.confirmpassword = this.password;
	    this.regPID = CommonMethods.GenerateRandomString();
	}
	
	
	 

	
}