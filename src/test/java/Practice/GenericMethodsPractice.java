package Practice;

import java.io.IOException;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;

public class GenericMethodsPractice {

	public static void main(String[] args) throws IOException {
		
		JavaUtility jLib = new JavaUtility();
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		String date1 = jLib.getSystemDateInFormat();
		System.out.println(date1);
		
		
		String value = pLib.readDataFromPropertyFile("browser");
		System.out.println(value);
		String value1 = pLib.readDataFromPropertyFile("username");
		System.out.println(value1);
		
		
		String val = eLib.readDataFromExcel("Organization", 1, 2);
		System.out.println(val);
		int row = eLib.getRowCount("Contacts");
		System.out.println(row);
		eLib.writeDataIntoExcel("Organization", 7, 8, "CHAITRA");
		
		}
}
