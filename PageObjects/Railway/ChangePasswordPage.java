package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ChangePasswordPage extends GeneralPage {

	// Locator
	private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
	private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By btnChangePassword = By.xpath("//input[@value='Change Password']");

	// Elements
	protected WebElement getTxtCurrentPassword(){
		return Constant.WEBDRIVER.findElement(txtCurrentPassword);
	}
	
	protected WebElement getTxtNewPassword(){
		return Constant.WEBDRIVER.findElement(txtNewPassword);
	}
	
	protected WebElement getTxtConfirmPassword(){
		return Constant.WEBDRIVER.findElement(txtConfirmPassword);
	}

	protected WebElement getBtnChangePassword(){
		return Constant.WEBDRIVER.findElement(btnChangePassword);
	}

	// Methods
	public ChangePasswordPage ChangePassword(String currentPassword, String newPassword, String confirmPassword)
    {
		this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
        return this;
    }
}
