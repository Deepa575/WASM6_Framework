package OrganizationTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: read the required data
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
				Properties pobj = new Properties();
				pobj.load(fis);
				String BROWSER = pobj.getProperty("browser");
				String URL = pobj.getProperty("url");
				String USERNAME = pobj.getProperty("username");
				String PASSWORD = pobj.getProperty("password");
				
				FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("Organization");
				Row rw = sh.getRow(1);
				Cell cl = rw.getCell(2);
				String ORGNAME = cl.getStringCellValue();
				
				Random ran = new Random();
				int value = ran.nextInt(500);
				
				String ORG=ORGNAME+value;
				
				WebDriver driver = null;
				
				//Step 2: Launch the browser - RUN TIME POLYMORPHISM
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
				    driver = new ChromeDriver();
					System.out.println("=== "+BROWSER+" is launched ===");
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println("=== "+BROWSER+" is launched ===");
				}
				else
				{
					System.out.println("invalid Browser name");
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(URL);
				
				//Step 3: Login to the application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 4: navigate organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 5: enter mandatory fields and save
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(ORG);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		
	}
}
