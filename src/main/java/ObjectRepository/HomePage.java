package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

		//declaration
		@FindBy(linkText="Organizations")
		private WebElement OrganizationsLnk;
		
		@FindBy(linkText="Contacts")
		private WebElement ContactsLnk;
		
		@FindBy(linkText="Opportunities")
		private WebElement OpportunitiesLnk;

		@FindBy(linkText="Products")
		private WebElement ProductsLnk;
		
		@FindBy(linkText="Leads")
		private WebElement administratorImg;
		

		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement LeadsLnk;
		
		@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")})
		private WebElement signOutLnk;
		
		//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getOrganizationsLnk() {
			return OrganizationsLnk;
		}

		public WebElement getContactsLnk() {
			return ContactsLnk;
		}

		public WebElement getOpportunitiesLnk() {
			return OpportunitiesLnk;
		}

		public WebElement getProductsLnk() {
			return ProductsLnk;
		}

		public WebElement getLeadsLnk() {
			return LeadsLnk;
		}

		public WebElement getAdministratorImg() {
			return administratorImg;
		}

		public void setAdministratorImg(WebElement administratorImg) {
			this.administratorImg = administratorImg;
		}
		
		
		//Business Library
		/**
		 * This method will click on Organizations link
		 */
		
		public void clickOnOrgLink() 
		{
			OrganizationsLnk.click();
		}
		
		/**
		 * This method will click on Contacts link
		 */
		public void clickOnContactsLnk() 
		{
			ContactsLnk.click();
		}
		

		/**
		 * This method will perform sign out operation
		 * @param driver
		 */
		public void signOutOfApp(WebDriver driver)
		{
			mouseHoverOn(driver,administratorImg);
			signOutLnk.click();
		}
			
}
