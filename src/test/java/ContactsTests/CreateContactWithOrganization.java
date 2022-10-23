package ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;



public class CreateContactWithOrganization {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step 1: Create Object of all the libraries
		JavaUtility jLib = new JavaUtility();
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Step 2: read all the required data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String LASTNAME = eLib.readDataFromExcel("Contact", 4, 2) + jLib.getRandomNumber();
		String ORGNAME = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getRandomNumber();

		WebDriver driver = null;

		// Step 3: launch the browser
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser name");
		}

		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);

		// Step 4: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: Navigate to create Organizations look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 7: Create new organization and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate for Organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization creation failed");
			wLib.takeScreenShot(driver, "CreateContactWithOrganization");
		}
		
		//Step 9: Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 10: Navigate to create Contact Look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 11: create contact with mandatory details
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step 12: Select the Organization created in org window
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
    		wLib.switchToWindow(driver, "Accounts");
        	driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
        	driver.findElement(By.name("search")).click();
        	driver.findElement(By.linkText(ORGNAME)).click();
        	wLib.switchToWindow(driver, "Contacts");
        
        	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        	//Step 13: Validate for Contact
        	String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
			wLib.takeScreenShot(driver, "CreateContactWithOrganization");
		}
		
		
		
		//Step 14: logout of Application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}
}
