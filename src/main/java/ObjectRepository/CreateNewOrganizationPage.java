package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

		//Declaration
		@FindBy(name="accountname")
		private WebElement createOrgLookUpImg;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//Initialization
		public CreateNewOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getCreateOrgLookUpImg() {
			return createOrgLookUpImg;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Library
		public void createNewOrg(String OrgName)
		{
			createOrgLookUpImg.sendKeys(OrgName);
			saveBtn.click();
		}
		
		
	
}
