package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

		//Declaration
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement createOrgLookUpImg;
		
		//Initialization
		public OrganizationsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getCreateOrgLookUpImg() {
			return createOrgLookUpImg;
		}
		
		//Business Library
		/**
		 * This method will click on Create Organization Look Up Image
		 */
		public void clickOnCreateOrgImg()
		{
			createOrgLookUpImg.click();
		}
			
			
}
