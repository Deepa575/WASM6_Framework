package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //rule 1: create a separate java class for every web page
	
	//rule 2: Identify the elements using @FindBy, @FindAll, @FindBys
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passwordEdt;
	
	@FindBys({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='password']")})
	//private WebElement passwordEdt;   -->syntax for @FindBys annotation
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule 3: Create a constructor to initialize these variables
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//rule 4: provide getter methods to access these variables
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
