package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeader;
	
	//Initialization
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgHeader() {
		return orgHeader;
	}
	
	//Business Library
	public String getOrganizationHeader()
	{
		return orgHeader.getText();
	}
	
	
	
}
